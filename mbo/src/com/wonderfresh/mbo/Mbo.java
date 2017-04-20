/*
 * Moving Block Overlay portion of the train control system
 * Angela Hoeltje - amh227@pitt.edu
 */
package com.wonderfresh.mbo;

import com.wonderfresh.interfaces.TrainModelAPI;
import com.wonderfresh.commons.mboTrain;
import com.wonderfresh.commons.Time;
import com.wonderfresh.commons.Block;
import com.wonderfresh.commons.Section;
import com.wonderfresh.commons.TrackGraph;
import com.wonderfresh.commons.TrackModel;
import com.wonderfresh.commons.TrackSimulator;
import com.wonderfresh.commons.TrackModelImplementation;
import javax.swing.JFrame;
import com.wonderfresh.interfaces.Interfaces;
import com.wonderfresh.interfaces.MboInterface;
//import com.wonderfresh.commons.MboInterfaceImpl;
import com.wonderfresh.interfaces.TrackModelInterface;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Mbo extends Thread{
    int ready=0;
    int drivers=0;
    int redPassengers=0,greenPassengers=0;
    private mboUI gui=null;
    
    public Mbo(){
        
    }
    public void launchUI(){
        gui = new mboUI(this); // GUI gui = new GUI() as well
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.setVisible(true);
    }
    
    @Override
    public void run() {
        //get initialized interface
        MboInterface mboInterface=Interfaces.getMboInterface();
        //max 100 trains per line
        mboTrain[] redTrain=new mboTrain[100];
        mboTrain[] greenTrain=new mboTrain[100];
        String[] redSta=new String[20];
        String[] greenSta=new String[20];
        boolean shift[][]=new boolean[7][120]; //max run 1 every 5mins
        int passengerCount=0;
        int greenRuns,redRuns, redRunTime,greenRunTime, passPerCar=300, i; 
        boolean test=true;
        int running=1;
        Time startTime=Time.getTimeNow();
        String timeOutput,lastStation="nothing";
        Time currentTime=startTime;
        
//  GET USER INPUTS       
        getInputs(); //function to get user inputs

/**********************  UPLOADING TRACK FROM TRAACKMODEL  ********************************/ 

        TrackSimulator ts=TrackSimulator.getInstance();
        //System.out.println("GET temp "+ts.getTemp());
        TrackModel tm=ts.getTrack();
        //System.out.println("TrackModel: ");
        TrackGraph redLine=tm.getRedLine();
        //System.out.println("redline"+redLine.getBlock("Red",60));
        TrackGraph greenLine=tm.getGreenLine();
        //System.out.println("Section a "+A.getArrowDirection());
        
      
        /**used for testing of integration - 
         * track is called but CTC was never integrated into the system
        int loop=0;
        while(loop==0){
            try {
                //Check for intigration on closed block with CTC
                Section e=redLine.getSection("E");
                Block b4=greenLine.getBlock("Green", 4);
                boolean cl=b4.closed;
                if (cl){System.out.println("Block is open"); }
                else{ System.out.println("Block is closed");
                    loop=1;}
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mbo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        **/
//estimate train runs for passengers
        int minsPerDay=28*60;   //24+4 for double rush
        int redWait = 0;
        redRuns=(redPassengers/passPerCar);//24+4 for double car on rush hour
        greenRuns=(greenPassengers/passPerCar);
        if (redRuns>0){ redWait=(minsPerDay/redRuns);}
        redWait=redWait-redWait%5;
        int greenWait=(minsPerDay/greenRuns);
        greenWait=greenWait-greenWait%5;
        if(drivers>50){System.out.println("MBO: Only 50 Drivers are supported");}
        if(drivers<7){System.out.println("MBO: Innadequate number of drivers to run 24 hours a day, 7 days a week");}
        System.out.println("MBO: Number of Drivers:"+drivers);
        System.out.println("MBO: Red Passangers: "+redPassengers+"  Running total:"+redRuns+ "  minutes between runs: "+(minsPerDay/(redRuns+1))+ "  redWait:"+redWait);    
        System.out.println("MBO: Green Passangers: "+greenPassengers+ "  Running total: "+greenRuns+"  minutes between runs: "+(minsPerDay/(greenRuns+1))+"  greenWait"+greenWait);
        int timeBetweenAllRuns=(((redWait+greenWait)/2)-((redWait+greenWait)/2)%5);
        System.out.println("MBO: need a driver every "+timeBetweenAllRuns+" minutes");
//Create and output drivers Schedule        
        driverSchedule ds=new driverSchedule();
        ds.getSchedule(drivers, shift, timeBetweenAllRuns);
        setDriverArray(ds);//DisplayDrivers  
        
//Get Safe breaking distance with max speed off of the blocks &print to Screen
        double minDist=0;
        double maxSpeed=40;
        minDist=getBrakeDistance(maxSpeed);//get max speed by iterating through the track
        System.out.println("MBO: Min braking distance: "+minDist);
//intializ mboSection arrays
        mboSection[] greenSections=new mboSection[28];
        for (i=0;i<28;i++){
            mboSection temp=new mboSection();
            greenSections[i]=temp; }
        mboSection[] redSections=new mboSection[21];
        for (i=0;i<21;i++){
            mboSection temp=new mboSection();
            redSections[i]=temp; }
//Get time around track
        int redTimeAroundTrack=getTimeAroundTrack(0,redLine,greenLine, redSections);       //0 for red
        int greenTimeAroundTrack=getTimeAroundTrack(1,redLine,greenLine, greenSections);     //1 for green
//create Train schedule with available drivers
        trainSchedule redSchedule=new trainSchedule();
        trainSchedule greenSchedule=new trainSchedule();
        trainSchedule[] redGreenSchedule=new trainSchedule[2];
        redGreenSchedule=trainSchedule.getTrainSchedule(drivers,ds,redTimeAroundTrack,greenTimeAroundTrack,redPassengers, greenPassengers);
        redSchedule=redGreenSchedule[0];
        greenSchedule=redGreenSchedule[1];   
//outputTrainSchedule-- Starts from green-yard
        
//Train Depart Info Initializations
        mboTrainDepartInfo[] departInfo=new mboTrainDepartInfo[100];
        departInfo=initializeDepartInfo();
/***************************     ALL INITIAL INFORMATION LOADED - CONTINUE RUNNINW IN WHILE LOOP     **************/        
       //running variable declarations
        String[] closedTracks=new String[100];
        mboTrain[] allTrains=new mboTrain[100];
        allTrains=mboTrainInitialization(allTrains);//initialize all trains
        //System.out.println("id: "+allTrains[0].id+" "+allTrains[0].color);
        running=1;
        while(running==1){
            try {
                Thread.sleep(100);
                //update time
                if (gui!=null){
                    gui.clock.setText(Time.stringTime(Time.getTimeNow()));//update clock
                    displayClosedTracks(closedTracks);
/****** UPDATE DEPART INFO FOR TRACK MODEL ********/
                    
                    
/****** Get Updated Track chosen for schedule *****/
                    String station =null;
                    station=checkUserStation(station);
/****** Get Passenger count ***********************/                    
                 //   passengerCount=passengerCount+=getPassengers(redTrain, greenTrain);
                    gui.passengerCount.setText(" "+(passengerCount));
                    
                    //iterate track schedule for time to new station
                    
/**************Get train locations from Train Controller since the CTC is MIA******************/
                    allTrains=mboInterface.getLocation();
                    allTrains=mboInterface.getAuthority(allTrains);
                    displayTrainLocations(allTrains);
                    
                    
                    
                }
            } catch (InterruptedException ex) { Logger.getLogger(Mbo.class.getName()).log(Level.SEVERE, null, ex); }
        }
 /******************************    END OF RUNNING WHILE LOOP     ***************************************/  
    }
    
    
    int getBrakeDistance(double speed){
        int lengthOfCar=33;                     //Taken from Track Layout and vehicle Data excel document. Rounded up from 32.2 to 33, in meters
        int lengthOf2Cars=lengthOfCar*2;
        int distance=0;                         //calculated stopping distance to be returned
        int humanWeight=75;                     //Standardized Human weight in kg
        int numHumansPerTrain=300+1;              //Max people per train + driver
        
        int totalHumans=numHumansPerTrain*2;    //Double the total potential human weight to calculate brake distance for rush hour
        int totalHumanWeight=totalHumans*humanWeight;
        int trainWeight=40900*2;                //2 trains for max weight ; 40.9 t taken from vehicle document
        double maxSpeed=speed;           //the maximum speed t calculate the largest possible stopping distance required        
        int totalWeight=trainWeight+totalHumanWeight;
        System.out.println("\n\nStats for breaking distance:\n\nTotal Weight for calculated breaking distance(in kg): "+totalWeight);
        System.out.println("length of 2 cars to add to breaking distance, since using point mass: "+lengthOf2Cars);
        System.out.println("Max speed used for calculating distance (taken from track module): "+maxSpeed);
        System.out.println("Calculate safe breakig distance = "+distance+"\n\n");
        return distance;
        
    }
    
    /**
     * @param track 0 for red 1 for green
     * @return 
     */
    int getTimeAroundTrack(int track, TrackGraph gr, TrackGraph red, mboSection[] mySections){
        ArrayList<Block> Included_Blocks;
        boolean checkStation=false;
        String stationName="  ";
        int time=0,itter,total=0;
        double len=0, lowspeed=100;  //1 for green
        //red
        if (track==0){/**********RED**************/
 /**
  * Add u,c,b,a,f,g,h,i,j,k,l,m,n,i,
  */           
            
            
        }
        else{ /**********GREEN**************/
 
 /**  yard -k-l-m-n-o-p-q-n-r-s-t-u-v-w-x-y-z-f-e-d-c-b-a-d-e-f-g-h-i-(j-continue//zz-yard(leaving) or yy(coming in))**/
            
            Section k=new Section("k");
                    checkStation=false;
                    k=gr.getSection("K");
                    mySections[0].ID=k.getSectionName();
                    mySections[0].lowBlock=k.getLowestBlock().getBlockNum();
                    mySections[0].highBlock=k.getHighestBlock().getBlockNum();
                    Included_Blocks=k.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                mySections[0].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    mySections[0].length=len;
                    mySections[0].lengthFromStation=len-mySections[0].lengthToStation;
                    mySections[0].maxSpeed=lowspeed;
                    mySections[0].numBlocks=total;
                    mySections[0].station=stationName;
                    
            Section l=gr.getSection("l");
                mySections[1].ID=k.getSectionName();
                
            Section m=gr.getSection("m");
                mySections[2].ID=k.getSectionName();
            Section n=gr.getSection("n");
                mySections[3].ID=k.getSectionName();
            Section o=gr.getSection("o");
                mySections[4].ID=k.getSectionName();
            Section p=gr.getSection("p");
            Section q=gr.getSection("q");
            Section r=gr.getSection("r");
            Section s=gr.getSection("s");
            Section t=gr.getSection("t");
            Section u=gr.getSection("u");
            Section v=gr.getSection("v");
            Section w=gr.getSection("w");
            Section x=gr.getSection("x");
            Section y=gr.getSection("y");
            Section z=gr.getSection("z");
            Section f=gr.getSection("f");
            Section e=gr.getSection("e");
            Section d=gr.getSection("g");
            Section c=gr.getSection("c");
            Section b=gr.getSection("b");
            Section a=gr.getSection("a");
            Section g=gr.getSection("g");
            Section h=gr.getSection("h");
            Section i=gr.getSection("i");
            
            Section yy=gr.getSection("yy"); 
            Section zz=gr.getSection("zz");
            //28
           
            
        }    
        return time;
    }
   public void setDrivers(int i){
       drivers=i;
       
   }  

    private void setDriverArray(driverSchedule ds) {
        gui.displayWorkers.setModel(new javax.swing.table.DefaultTableModel(
            new String [][] {
                
{ds.arr[0][0], ds.arr[0][1], ds.arr[0][2], ds.arr[0][3],ds.arr[0][4], ds.arr[0][5], ds.arr[0][6], ds.arr[0][7] },
{ds.arr[1][0], ds.arr[1][1], ds.arr[1][2], ds.arr[1][3],ds.arr[1][4], ds.arr[1][5], ds.arr[1][6], ds.arr[1][7] },
{ds.arr[2][0], ds.arr[2][1], ds.arr[2][2], ds.arr[2][3],ds.arr[2][4], ds.arr[2][5], ds.arr[2][6], ds.arr[2][7] },
{ds.arr[3][0], ds.arr[3][1], ds.arr[3][2], ds.arr[3][3],ds.arr[3][4], ds.arr[3][5], ds.arr[3][6], ds.arr[3][7] },
{ds.arr[4][0], ds.arr[4][1], ds.arr[4][2], ds.arr[4][3],ds.arr[4][4], ds.arr[4][5], ds.arr[4][6], ds.arr[4][7] },
{ds.arr[5][0], ds.arr[5][1], ds.arr[5][2], ds.arr[5][3],ds.arr[5][4], ds.arr[5][5], ds.arr[5][6], ds.arr[5][7] },
{ds.arr[6][0], ds.arr[6][1], ds.arr[6][2], ds.arr[6][3],ds.arr[6][4], ds.arr[6][5], ds.arr[6][6], ds.arr[6][7] },
{ds.arr[7][0], ds.arr[7][1], ds.arr[7][2], ds.arr[7][3],ds.arr[7][4], ds.arr[7][5], ds.arr[7][6], ds.arr[7][7] },
{ds.arr[8][0], ds.arr[8][1], ds.arr[8][2], ds.arr[8][3],ds.arr[8][4], ds.arr[8][5], ds.arr[8][6], ds.arr[8][7] },
{ds.arr[9][0], ds.arr[9][1], ds.arr[9][2], ds.arr[9][3],ds.arr[9][4], ds.arr[9][5], ds.arr[9][6], ds.arr[9][7] },
{ds.arr[10][0], ds.arr[10][1], ds.arr[10][2], ds.arr[10][3],ds.arr[10][4], ds.arr[10][5], ds.arr[10][6], ds.arr[10][7] },
{ds.arr[11][0], ds.arr[11][1], ds.arr[11][2], ds.arr[11][3],ds.arr[11][4], ds.arr[11][5], ds.arr[11][6], ds.arr[11][7] },
{ds.arr[12][0], ds.arr[12][1], ds.arr[12][2], ds.arr[12][3],ds.arr[12][4], ds.arr[12][5], ds.arr[12][6], ds.arr[12][7] },
{ds.arr[13][0], ds.arr[13][1], ds.arr[13][2], ds.arr[13][3],ds.arr[13][4], ds.arr[13][5], ds.arr[13][6], ds.arr[13][7] },
{ds.arr[14][0], ds.arr[14][1], ds.arr[14][2], ds.arr[14][3],ds.arr[14][4], ds.arr[14][5], ds.arr[14][6], ds.arr[14][7] },
{ds.arr[15][0], ds.arr[15][1], ds.arr[15][2], ds.arr[15][3],ds.arr[15][4], ds.arr[15][5], ds.arr[15][6], ds.arr[15][7] },
{ds.arr[16][0], ds.arr[16][1], ds.arr[16][2], ds.arr[16][3],ds.arr[16][4], ds.arr[16][5], ds.arr[16][6], ds.arr[16][7] },
{ds.arr[17][0], ds.arr[17][1], ds.arr[17][2], ds.arr[17][3],ds.arr[17][4], ds.arr[17][5], ds.arr[17][6], ds.arr[17][7] },
{ds.arr[18][0], ds.arr[18][1], ds.arr[18][2], ds.arr[18][3],ds.arr[18][4], ds.arr[18][5], ds.arr[18][6], ds.arr[18][7] },
{ds.arr[19][0], ds.arr[19][1], ds.arr[19][2], ds.arr[19][3],ds.arr[19][4], ds.arr[19][5], ds.arr[19][6], ds.arr[19][7] },
{ds.arr[20][0], ds.arr[20][1], ds.arr[20][2], ds.arr[20][3],ds.arr[20][4], ds.arr[20][5], ds.arr[20][6], ds.arr[20][7] },
{ds.arr[21][0], ds.arr[21][1], ds.arr[21][2], ds.arr[21][3],ds.arr[21][4], ds.arr[21][5], ds.arr[21][6], ds.arr[21][7] },
{ds.arr[22][0], ds.arr[22][1], ds.arr[22][2], ds.arr[22][3],ds.arr[22][4], ds.arr[22][5], ds.arr[22][6], ds.arr[22][7] },
{ds.arr[23][0], ds.arr[23][1], ds.arr[23][2], ds.arr[23][3],ds.arr[23][4], ds.arr[23][5], ds.arr[23][6], ds.arr[23][7] },
{ds.arr[24][0], ds.arr[24][1], ds.arr[24][2], ds.arr[24][3],ds.arr[24][4], ds.arr[24][5], ds.arr[24][6], ds.arr[24][7] },
{ds.arr[25][0], ds.arr[25][1], ds.arr[25][2], ds.arr[25][3],ds.arr[25][4], ds.arr[25][5], ds.arr[25][6], ds.arr[25][7] },
{ds.arr[26][0], ds.arr[26][1], ds.arr[26][2], ds.arr[26][3],ds.arr[26][4], ds.arr[26][5], ds.arr[26][6], ds.arr[26][7] },
{ds.arr[27][0], ds.arr[27][1], ds.arr[27][2], ds.arr[27][3],ds.arr[27][4], ds.arr[27][5], ds.arr[27][6], ds.arr[27][7] },
{ds.arr[28][0], ds.arr[28][1], ds.arr[28][2], ds.arr[28][3],ds.arr[28][4], ds.arr[28][5], ds.arr[28][6], ds.arr[28][7] },
{ds.arr[29][0], ds.arr[29][1], ds.arr[29][2], ds.arr[29][3],ds.arr[29][4], ds.arr[29][5], ds.arr[29][6], ds.arr[29][7] },
{ds.arr[30][0], ds.arr[30][1], ds.arr[30][2], ds.arr[30][3],ds.arr[30][4], ds.arr[30][5], ds.arr[30][6], ds.arr[30][7] },
{ds.arr[31][0], ds.arr[31][1], ds.arr[31][2], ds.arr[31][3],ds.arr[31][4], ds.arr[31][5], ds.arr[31][6], ds.arr[31][7] },
{ds.arr[32][0], ds.arr[32][1], ds.arr[32][2], ds.arr[32][3],ds.arr[32][4], ds.arr[32][5], ds.arr[32][6], ds.arr[32][7] },
{ds.arr[33][0], ds.arr[33][1], ds.arr[33][2], ds.arr[33][3],ds.arr[33][4], ds.arr[33][5], ds.arr[33][6], ds.arr[33][7] },
{ds.arr[34][0], ds.arr[34][1], ds.arr[34][2], ds.arr[34][3],ds.arr[34][4], ds.arr[34][5], ds.arr[34][6], ds.arr[34][7] },
{ds.arr[35][0], ds.arr[35][1], ds.arr[35][2], ds.arr[35][3],ds.arr[35][4], ds.arr[35][5], ds.arr[35][6], ds.arr[35][7] },
{ds.arr[36][0], ds.arr[36][1], ds.arr[36][2], ds.arr[36][3],ds.arr[36][4], ds.arr[36][5], ds.arr[36][6], ds.arr[36][7] },
{ds.arr[37][0], ds.arr[37][1], ds.arr[37][2], ds.arr[37][3],ds.arr[37][4], ds.arr[37][5], ds.arr[37][6], ds.arr[37][7] },
{ds.arr[38][0], ds.arr[38][1], ds.arr[38][2], ds.arr[38][3],ds.arr[38][4], ds.arr[38][5], ds.arr[38][6], ds.arr[38][7] },
{ds.arr[39][0], ds.arr[39][1], ds.arr[39][2], ds.arr[39][3],ds.arr[39][4], ds.arr[39][5], ds.arr[39][6], ds.arr[39][7] },
{ds.arr[40][0], ds.arr[40][1], ds.arr[40][2], ds.arr[40][3],ds.arr[40][4], ds.arr[40][5], ds.arr[40][6], ds.arr[40][7] },
{ds.arr[41][0], ds.arr[41][1], ds.arr[41][2], ds.arr[41][3],ds.arr[41][4], ds.arr[41][5], ds.arr[41][6], ds.arr[41][7] },
{ds.arr[42][0], ds.arr[42][1], ds.arr[42][2], ds.arr[42][3],ds.arr[42][4], ds.arr[42][5], ds.arr[42][6], ds.arr[42][7] },
{ds.arr[43][0], ds.arr[43][1], ds.arr[43][2], ds.arr[43][3],ds.arr[43][4], ds.arr[43][5], ds.arr[43][6], ds.arr[43][7] },
{ds.arr[44][0], ds.arr[44][1], ds.arr[44][2], ds.arr[44][3],ds.arr[44][4], ds.arr[44][5], ds.arr[44][6], ds.arr[44][7] },
{ds.arr[45][0], ds.arr[45][1], ds.arr[45][2], ds.arr[45][3],ds.arr[45][4], ds.arr[45][5], ds.arr[45][6], ds.arr[45][7] },
{ds.arr[46][0], ds.arr[46][1], ds.arr[46][2], ds.arr[46][3],ds.arr[46][4], ds.arr[46][5], ds.arr[46][6], ds.arr[46][7] },
{ds.arr[47][0], ds.arr[47][1], ds.arr[47][2], ds.arr[47][3],ds.arr[47][4], ds.arr[47][5], ds.arr[47][6], ds.arr[47][7] },
{ds.arr[48][0], ds.arr[48][1], ds.arr[48][2], ds.arr[48][3],ds.arr[48][4], ds.arr[48][5], ds.arr[48][6], ds.arr[48][7] },
{ds.arr[49][0], ds.arr[49][1], ds.arr[49][2], ds.arr[49][3],ds.arr[49][4], ds.arr[49][5], ds.arr[49][6], ds.arr[49][7] },

            },
            new String [] {
                "Worker ID", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ));
         }

    private void displayClosedTracks(String[] closedTracks) {
        int i=0;
        for(i=0;i<100;i++){
            gui.displayClosedTrack.getModel().setValueAt(closedTracks[i], 0, 0);
        }
    }
    private void DisplayTrainSchedule(trainSchedule ts){
    
        
           gui.trainScheduleDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
           
{ts.arr[0][0], ts.arr[0][1], ts.arr[0][2], ts.arr[0][3],ts.arr[0][4], ts.arr[0][5], ts.arr[0][6], ts.arr[0][7] },
{ts.arr[1][0], ts.arr[1][1], ts.arr[1][2], ts.arr[1][3],ts.arr[1][4], ts.arr[1][5], ts.arr[1][6], ts.arr[1][7] },
{ts.arr[2][0], ts.arr[2][1], ts.arr[2][2], ts.arr[2][3],ts.arr[2][4], ts.arr[2][5], ts.arr[2][6], ts.arr[2][7] },
{ts.arr[3][0], ts.arr[3][1], ts.arr[3][2], ts.arr[3][3],ts.arr[3][4], ts.arr[3][5], ts.arr[3][6], ts.arr[3][7] },
{ts.arr[4][0], ts.arr[4][1], ts.arr[4][2], ts.arr[4][3],ts.arr[4][4], ts.arr[4][5], ts.arr[4][6], ts.arr[4][7] },
{ts.arr[5][0], ts.arr[5][1], ts.arr[5][2], ts.arr[5][3],ts.arr[5][4], ts.arr[5][5], ts.arr[5][6], ts.arr[5][7] },
{ts.arr[6][0], ts.arr[6][1], ts.arr[6][2], ts.arr[6][3],ts.arr[6][4], ts.arr[6][5], ts.arr[6][6], ts.arr[6][7] },
{ts.arr[7][0], ts.arr[7][1], ts.arr[7][2], ts.arr[7][3],ts.arr[7][4], ts.arr[7][5], ts.arr[7][6], ts.arr[7][7] },
{ts.arr[8][0], ts.arr[8][1], ts.arr[8][2], ts.arr[8][3],ts.arr[8][4], ts.arr[8][5], ts.arr[8][6], ts.arr[8][7] },
{ts.arr[9][0], ts.arr[9][1], ts.arr[9][2], ts.arr[9][3],ts.arr[9][4], ts.arr[9][5], ts.arr[9][6], ts.arr[9][7] },
{ts.arr[10][0], ts.arr[10][1], ts.arr[10][2], ts.arr[10][3],ts.arr[10][4], ts.arr[10][5], ts.arr[10][6], ts.arr[10][7] },
{ts.arr[11][0], ts.arr[11][1], ts.arr[11][2], ts.arr[11][3],ts.arr[11][4], ts.arr[11][5], ts.arr[11][6], ts.arr[11][7] },
{ts.arr[12][0], ts.arr[12][1], ts.arr[12][2], ts.arr[12][3],ts.arr[12][4], ts.arr[12][5], ts.arr[12][6], ts.arr[12][7] },
{ts.arr[13][0], ts.arr[13][1], ts.arr[13][2], ts.arr[13][3],ts.arr[13][4], ts.arr[13][5], ts.arr[13][6], ts.arr[13][7] },
{ts.arr[14][0], ts.arr[14][1], ts.arr[14][2], ts.arr[14][3],ts.arr[14][4], ts.arr[14][5], ts.arr[14][6], ts.arr[14][7] },
{ts.arr[15][0], ts.arr[15][1], ts.arr[15][2], ts.arr[15][3],ts.arr[15][4], ts.arr[15][5], ts.arr[15][6], ts.arr[15][7] },
{ts.arr[16][0], ts.arr[16][1], ts.arr[16][2], ts.arr[16][3],ts.arr[16][4], ts.arr[16][5], ts.arr[16][6], ts.arr[16][7] },
{ts.arr[17][0], ts.arr[17][1], ts.arr[17][2], ts.arr[17][3],ts.arr[17][4], ts.arr[17][5], ts.arr[17][6], ts.arr[17][7] },
{ts.arr[18][0], ts.arr[18][1], ts.arr[18][2], ts.arr[18][3],ts.arr[18][4], ts.arr[18][5], ts.arr[18][6], ts.arr[18][7] },
{ts.arr[19][0], ts.arr[19][1], ts.arr[19][2], ts.arr[19][3],ts.arr[19][4], ts.arr[19][5], ts.arr[19][6], ts.arr[19][7] },
{ts.arr[20][0], ts.arr[20][1], ts.arr[20][2], ts.arr[20][3],ts.arr[20][4], ts.arr[20][5], ts.arr[20][6], ts.arr[20][7] },
{ts.arr[21][0], ts.arr[21][1], ts.arr[21][2], ts.arr[21][3],ts.arr[21][4], ts.arr[21][5], ts.arr[21][6], ts.arr[21][7] },
{ts.arr[22][0], ts.arr[22][1], ts.arr[22][2], ts.arr[22][3],ts.arr[22][4], ts.arr[22][5], ts.arr[22][6], ts.arr[22][7] },
{ts.arr[23][0], ts.arr[23][1], ts.arr[23][2], ts.arr[23][3],ts.arr[23][4], ts.arr[23][5], ts.arr[23][6], ts.arr[23][7] },
{ts.arr[24][0], ts.arr[24][1], ts.arr[24][2], ts.arr[24][3],ts.arr[24][4], ts.arr[24][5], ts.arr[24][6], ts.arr[24][7] },
{ts.arr[25][0], ts.arr[25][1], ts.arr[25][2], ts.arr[25][3],ts.arr[25][4], ts.arr[25][5], ts.arr[25][6], ts.arr[25][7] },
{ts.arr[26][0], ts.arr[26][1], ts.arr[26][2], ts.arr[26][3],ts.arr[26][4], ts.arr[26][5], ts.arr[26][6], ts.arr[26][7] },
{ts.arr[27][0], ts.arr[27][1], ts.arr[27][2], ts.arr[27][3],ts.arr[27][4], ts.arr[27][5], ts.arr[27][6], ts.arr[27][7] },
{ts.arr[28][0], ts.arr[28][1], ts.arr[28][2], ts.arr[28][3],ts.arr[28][4], ts.arr[28][5], ts.arr[28][6], ts.arr[28][7] },
{ts.arr[29][0], ts.arr[29][1], ts.arr[29][2], ts.arr[29][3],ts.arr[29][4], ts.arr[29][5], ts.arr[29][6], ts.arr[29][7] },
{ts.arr[30][0], ts.arr[30][1], ts.arr[30][2], ts.arr[30][3],ts.arr[30][4], ts.arr[30][5], ts.arr[30][6], ts.arr[30][7] },
{ts.arr[31][0], ts.arr[31][1], ts.arr[31][2], ts.arr[31][3],ts.arr[31][4], ts.arr[31][5], ts.arr[31][6], ts.arr[31][7] },
{ts.arr[32][0], ts.arr[32][1], ts.arr[32][2], ts.arr[32][3],ts.arr[32][4], ts.arr[32][5], ts.arr[32][6], ts.arr[32][7] },
{ts.arr[33][0], ts.arr[33][1], ts.arr[33][2], ts.arr[33][3],ts.arr[33][4], ts.arr[33][5], ts.arr[33][6], ts.arr[33][7] },
{ts.arr[34][0], ts.arr[34][1], ts.arr[34][2], ts.arr[34][3],ts.arr[34][4], ts.arr[34][5], ts.arr[34][6], ts.arr[34][7] },
{ts.arr[35][0], ts.arr[35][1], ts.arr[35][2], ts.arr[35][3],ts.arr[35][4], ts.arr[35][5], ts.arr[35][6], ts.arr[35][7] },
{ts.arr[36][0], ts.arr[36][1], ts.arr[36][2], ts.arr[36][3],ts.arr[36][4], ts.arr[36][5], ts.arr[36][6], ts.arr[36][7] },
{ts.arr[37][0], ts.arr[37][1], ts.arr[37][2], ts.arr[37][3],ts.arr[37][4], ts.arr[37][5], ts.arr[37][6], ts.arr[37][7] },
{ts.arr[38][0], ts.arr[38][1], ts.arr[38][2], ts.arr[38][3],ts.arr[38][4], ts.arr[38][5], ts.arr[38][6], ts.arr[38][7] },
{ts.arr[39][0], ts.arr[39][1], ts.arr[39][2], ts.arr[39][3],ts.arr[39][4], ts.arr[39][5], ts.arr[39][6], ts.arr[39][7] },
{ts.arr[40][0], ts.arr[40][1], ts.arr[40][2], ts.arr[40][3],ts.arr[40][4], ts.arr[40][5], ts.arr[40][6], ts.arr[40][7] },
{ts.arr[41][0], ts.arr[41][1], ts.arr[41][2], ts.arr[41][3],ts.arr[41][4], ts.arr[41][5], ts.arr[41][6], ts.arr[41][7] },
{ts.arr[42][0], ts.arr[42][1], ts.arr[42][2], ts.arr[42][3],ts.arr[42][4], ts.arr[42][5], ts.arr[42][6], ts.arr[42][7] },
{ts.arr[43][0], ts.arr[43][1], ts.arr[43][2], ts.arr[43][3],ts.arr[43][4], ts.arr[43][5], ts.arr[43][6], ts.arr[43][7] },
{ts.arr[44][0], ts.arr[44][1], ts.arr[44][2], ts.arr[44][3],ts.arr[44][4], ts.arr[44][5], ts.arr[44][6], ts.arr[44][7] },
{ts.arr[45][0], ts.arr[45][1], ts.arr[45][2], ts.arr[45][3],ts.arr[45][4], ts.arr[45][5], ts.arr[45][6], ts.arr[45][7] },
{ts.arr[46][0], ts.arr[46][1], ts.arr[46][2], ts.arr[46][3],ts.arr[46][4], ts.arr[46][5], ts.arr[46][6], ts.arr[46][7] },
{ts.arr[47][0], ts.arr[47][1], ts.arr[47][2], ts.arr[47][3],ts.arr[47][4], ts.arr[47][5], ts.arr[47][6], ts.arr[47][7] },
{ts.arr[48][0], ts.arr[48][1], ts.arr[48][2], ts.arr[48][3],ts.arr[48][4], ts.arr[48][5], ts.arr[48][6], ts.arr[48][7] },
{ts.arr[49][0], ts.arr[49][1], ts.arr[49][2], ts.arr[49][3],ts.arr[49][4], ts.arr[49][5], ts.arr[49][6], ts.arr[49][7] },
    },
            new String [] {  "Train ID", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }
        ) { Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class };

            public Class getColumnClass(int columnIndex) {return types [columnIndex];  }
        });
            
        
      }
    public mboTrain getTrain(int id ,int block,int distInBlock){
        mboTrain train=new mboTrain();
        train.block=block;
        train.id=id;
        train.metersInBlock=distInBlock;
        return train;
        
    }
    public void getInputs(){
        //Get User Inputs
            int running=1;
            while(gui == null) {
                try {Thread.sleep(1000); } 
                catch (Exception ex) {
                    //do nothing busy work
                }
            }
            while(running==1){
                //keep clock running    
              // System.out.println("here");
                    gui.clock.setText(Time.stringTime(Time.getTimeNow()));
                    if (ready==1){
                        running=0;
                    } 
            }
        //verify correct inputs    
        System.out.println("MBO: Accepted inputs (Drivers:"+drivers+", Red Passengers:"+redPassengers+", GreenPassengers:"+greenPassengers);      

        
    }


    private void displayTrainLocations(mboTrain[] t) {
        String[][] redDetails=new String[100][5];
        String[][] greenDetails=new String[100][5];
        int i=0,j=0,redIndex=0,greenIndex=0,redNoIndex=0,greenNoIndex=0;
        //System.out.println("entering for loop");
        for(i=0;i<100;i++){
            //System.out.println(i+"id: "+t[i].id+" "+t[i].color);
            if (t[i].block!=0){
                t[i].id=i;
            }
            if (t[i].id>=1 && t[i].color.compareToIgnoreCase("red")==0){
            //   "Train ID", "Location", "Speed", "Authority", "Passengers"
                redDetails[redIndex][0]=t[i].id+"";
                redDetails[redIndex][1]=t[i].block+":"+t[i].metersInBlock;
                redDetails[redIndex][2]=t[i].speed+"";
                redDetails[redIndex][3]=t[i].authority+"";
                redDetails[redIndex][4]=t[i].number+"";
                redIndex++;
            }
            if(t[i].id<1 && t[i].color.compareToIgnoreCase("red")==0){
               for(j=0;j<5;j++){
                   redDetails[redNoIndex][j]=null;
                   redNoIndex++;
               }
            }
             if (t[i].id>=1 && t[i].color.compareToIgnoreCase("green")==0){
            //   "Train ID", "Location", "Speed", "Authority", "Passengers"
                greenDetails[greenIndex][0]=t[i].id+"";
                greenDetails[greenIndex][1]=t[i].block+":"+t[i].metersInBlock;
                greenDetails[greenIndex][2]=t[i].speed+"";
                greenDetails[greenIndex][3]=t[i].authority+"";
                greenDetails[greenIndex][4]=t[i].number+"";
                greenIndex++;
            }
            if(t[i].id<1 &&t[i].color.compareToIgnoreCase("green")==0){
               for(j=0;j<5;j++){
                   greenDetails[greenNoIndex][j]=null;
                   greenNoIndex++;
               }
            }
            
        }
        gui.trainDetails1.setModel(new javax.swing.table.DefaultTableModel(//red
            new Object [][] {
                {redDetails[0][0], redDetails[0][1], redDetails[0][2], redDetails[0][3], redDetails[0][4]},
                {redDetails[1][0], redDetails[1][1], redDetails[1][2], redDetails[1][3], redDetails[1][4]},
                {redDetails[2][0], redDetails[2][1], redDetails[2][2], redDetails[2][3], redDetails[2][4]},
                {redDetails[3][0], redDetails[3][1], redDetails[3][2], redDetails[3][3], redDetails[3][4]},
                {redDetails[4][0], redDetails[4][1], redDetails[4][2], redDetails[4][3], redDetails[4][4]},
                {redDetails[5][0], redDetails[5][1], redDetails[5][2], redDetails[5][3], redDetails[5][4]},
                {redDetails[6][0], redDetails[6][1], redDetails[6][2], redDetails[6][3], redDetails[6][4]},
                {redDetails[7][0], redDetails[7][1], redDetails[7][2], redDetails[7][3], redDetails[7][4]},
                {redDetails[8][0], redDetails[8][1], redDetails[8][2], redDetails[8][3], redDetails[8][4]},
                {redDetails[9][0], redDetails[9][1], redDetails[9][2], redDetails[9][3], redDetails[9][4]},

                {redDetails[10][0], redDetails[10][1], redDetails[10][2], redDetails[10][3], redDetails[10][4]},
                {redDetails[11][0], redDetails[11][1], redDetails[11][2], redDetails[11][3], redDetails[11][4]},
                {redDetails[12][0], redDetails[12][1], redDetails[12][2], redDetails[12][3], redDetails[12][4]},
                {redDetails[13][0], redDetails[13][1], redDetails[13][2], redDetails[13][3], redDetails[13][4]},
                {redDetails[14][0], redDetails[14][1], redDetails[14][2], redDetails[14][3], redDetails[14][4]},
                {redDetails[15][0], redDetails[15][1], redDetails[15][2], redDetails[15][3], redDetails[15][4]},
                {redDetails[16][0], redDetails[16][1], redDetails[16][2], redDetails[16][3], redDetails[16][4]},
                {redDetails[17][0], redDetails[17][1], redDetails[17][2], redDetails[17][3], redDetails[17][4]},
                {redDetails[18][0], redDetails[18][1], redDetails[18][2], redDetails[18][3], redDetails[18][4]},
                {redDetails[19][0], redDetails[19][1], redDetails[19][2], redDetails[19][3], redDetails[19][4]},

                  {redDetails[20][0], redDetails[20][1], redDetails[20][2], redDetails[20][3], redDetails[20][4]},
                {redDetails[21][0], redDetails[21][1], redDetails[21][2], redDetails[21][3], redDetails[21][4]},
                {redDetails[22][0], redDetails[22][1], redDetails[22][2], redDetails[22][3], redDetails[22][4]},
                {redDetails[23][0], redDetails[23][1], redDetails[23][2], redDetails[23][3], redDetails[23][4]},
                {redDetails[24][0], redDetails[24][1], redDetails[24][2], redDetails[24][3], redDetails[24][4]},
                {redDetails[25][0], redDetails[25][1], redDetails[25][2], redDetails[25][3], redDetails[25][4]},
                {redDetails[26][0], redDetails[26][1], redDetails[26][2], redDetails[26][3], redDetails[26][4]},
                {redDetails[27][0], redDetails[27][1], redDetails[27][2], redDetails[27][3], redDetails[27][4]},
                {redDetails[28][0], redDetails[28][1], redDetails[28][2], redDetails[28][3], redDetails[28][4]},
                {redDetails[29][0], redDetails[29][1], redDetails[29][2], redDetails[29][3], redDetails[29][4]},

		{redDetails[30][0], redDetails[30][1], redDetails[30][2], redDetails[30][3], redDetails[30][4]},
                {redDetails[31][0], redDetails[31][1], redDetails[31][2], redDetails[31][3], redDetails[31][4]},
                {redDetails[32][0], redDetails[32][1], redDetails[32][2], redDetails[32][3], redDetails[32][4]},
                {redDetails[33][0], redDetails[33][1], redDetails[33][2], redDetails[33][3], redDetails[33][4]},
                {redDetails[34][0], redDetails[34][1], redDetails[34][2], redDetails[34][3], redDetails[34][4]},
                {redDetails[35][0], redDetails[35][1], redDetails[35][2], redDetails[35][3], redDetails[35][4]},
                {redDetails[36][0], redDetails[36][1], redDetails[36][2], redDetails[36][3], redDetails[36][4]},
                {redDetails[37][0], redDetails[37][1], redDetails[37][2], redDetails[37][3], redDetails[37][4]},
                {redDetails[38][0], redDetails[38][1], redDetails[38][2], redDetails[38][3], redDetails[38][4]},
                {redDetails[39][0], redDetails[39][1], redDetails[39][2], redDetails[39][3], redDetails[39][4]},

                {redDetails[40][0], redDetails[40][1], redDetails[40][2], redDetails[40][3], redDetails[40][4]},
                {redDetails[41][0], redDetails[41][1], redDetails[41][2], redDetails[41][3], redDetails[41][4]},
                {redDetails[42][0], redDetails[42][1], redDetails[42][2], redDetails[42][3], redDetails[42][4]},
                {redDetails[43][0], redDetails[43][1], redDetails[43][2], redDetails[43][3], redDetails[43][4]},
                {redDetails[44][0], redDetails[44][1], redDetails[44][2], redDetails[44][3], redDetails[44][4]},
                {redDetails[45][0], redDetails[45][1], redDetails[45][2], redDetails[45][3], redDetails[45][4]},
                {redDetails[46][0], redDetails[46][1], redDetails[46][2], redDetails[46][3], redDetails[46][4]},
                {redDetails[47][0], redDetails[47][1], redDetails[47][2], redDetails[47][3], redDetails[47][4]},
                {redDetails[48][0], redDetails[48][1], redDetails[48][2], redDetails[48][3], redDetails[48][4]},
                {redDetails[49][0], redDetails[49][1], redDetails[49][2], redDetails[49][3], redDetails[49][4]},

                {redDetails[50][0], redDetails[50][1], redDetails[50][2], redDetails[50][3], redDetails[50][4]},
                {redDetails[51][0], redDetails[51][1], redDetails[51][2], redDetails[51][3], redDetails[51][4]},
                {redDetails[52][0], redDetails[52][1], redDetails[52][2], redDetails[52][3], redDetails[52][4]},
                {redDetails[53][0], redDetails[53][1], redDetails[53][2], redDetails[53][3], redDetails[53][4]},
                {redDetails[54][0], redDetails[54][1], redDetails[54][2], redDetails[54][3], redDetails[54][4]},
                {redDetails[55][0], redDetails[55][1], redDetails[55][2], redDetails[55][3], redDetails[55][4]},
                {redDetails[56][0], redDetails[56][1], redDetails[56][2], redDetails[56][3], redDetails[56][4]},
                {redDetails[57][0], redDetails[57][1], redDetails[57][2], redDetails[57][3], redDetails[57][4]},
                {redDetails[58][0], redDetails[58][1], redDetails[58][2], redDetails[58][3], redDetails[58][4]},
                {redDetails[59][0], redDetails[59][1], redDetails[59][2], redDetails[59][3], redDetails[59][4]},

                {redDetails[60][0], redDetails[60][1], redDetails[60][2], redDetails[60][3], redDetails[60][4]},
                {redDetails[61][0], redDetails[61][1], redDetails[61][2], redDetails[61][3], redDetails[61][4]},
                {redDetails[62][0], redDetails[62][1], redDetails[62][2], redDetails[62][3], redDetails[62][4]},
                {redDetails[63][0], redDetails[63][1], redDetails[63][2], redDetails[63][3], redDetails[63][4]},
                {redDetails[64][0], redDetails[64][1], redDetails[64][2], redDetails[64][3], redDetails[64][4]},
                {redDetails[65][0], redDetails[65][1], redDetails[65][2], redDetails[65][3], redDetails[65][4]},
                {redDetails[66][0], redDetails[66][1], redDetails[66][2], redDetails[66][3], redDetails[66][4]},
                {redDetails[67][0], redDetails[67][1], redDetails[67][2], redDetails[67][3], redDetails[67][4]},
                {redDetails[68][0], redDetails[68][1], redDetails[68][2], redDetails[68][3], redDetails[68][4]},
                {redDetails[69][0], redDetails[69][1], redDetails[69][2], redDetails[69][3], redDetails[69][4]},

                {redDetails[70][0], redDetails[70][1], redDetails[70][2], redDetails[70][3], redDetails[70][4]},
                {redDetails[71][0], redDetails[71][1], redDetails[71][2], redDetails[71][3], redDetails[71][4]},
                {redDetails[72][0], redDetails[72][1], redDetails[72][2], redDetails[72][3], redDetails[72][4]},
                {redDetails[73][0], redDetails[73][1], redDetails[73][2], redDetails[73][3], redDetails[73][4]},
                {redDetails[74][0], redDetails[74][1], redDetails[74][2], redDetails[74][3], redDetails[74][4]},
                {redDetails[75][0], redDetails[75][1], redDetails[75][2], redDetails[75][3], redDetails[75][4]},
                {redDetails[76][0], redDetails[76][1], redDetails[76][2], redDetails[76][3], redDetails[76][4]},
                {redDetails[77][0], redDetails[77][1], redDetails[77][2], redDetails[77][3], redDetails[77][4]},
                {redDetails[78][0], redDetails[78][1], redDetails[78][2], redDetails[78][3], redDetails[78][4]},
                {redDetails[79][0], redDetails[79][1], redDetails[79][2], redDetails[79][3], redDetails[79][4]},

                {redDetails[80][0], redDetails[80][1], redDetails[80][2], redDetails[80][3], redDetails[80][4]},
                {redDetails[81][0], redDetails[81][1], redDetails[81][2], redDetails[81][3], redDetails[81][4]},
                {redDetails[82][0], redDetails[82][1], redDetails[82][2], redDetails[82][3], redDetails[82][4]},
                {redDetails[83][0], redDetails[83][1], redDetails[83][2], redDetails[83][3], redDetails[83][4]},
                {redDetails[84][0], redDetails[84][1], redDetails[84][2], redDetails[84][3], redDetails[84][4]},
                {redDetails[85][0], redDetails[85][1], redDetails[85][2], redDetails[85][3], redDetails[85][4]},
                {redDetails[86][0], redDetails[86][1], redDetails[86][2], redDetails[86][3], redDetails[86][4]},
                {redDetails[87][0], redDetails[87][1], redDetails[87][2], redDetails[87][3], redDetails[87][4]},
                {redDetails[88][0], redDetails[88][1], redDetails[88][2], redDetails[88][3], redDetails[88][4]},
                {redDetails[89][0], redDetails[89][1], redDetails[89][2], redDetails[89][3], redDetails[89][4]},

                {redDetails[90][0], redDetails[90][1], redDetails[90][2], redDetails[90][3], redDetails[90][4]},
                {redDetails[91][0], redDetails[91][1], redDetails[91][2], redDetails[91][3], redDetails[91][4]},
                {redDetails[92][0], redDetails[92][1], redDetails[92][2], redDetails[92][3], redDetails[92][4]},
                {redDetails[93][0], redDetails[93][1], redDetails[93][2], redDetails[93][3], redDetails[93][4]},
                {redDetails[94][0], redDetails[94][1], redDetails[94][2], redDetails[94][3], redDetails[94][4]},
                {redDetails[95][0], redDetails[95][1], redDetails[95][2], redDetails[95][3], redDetails[95][4]},
                {redDetails[96][0], redDetails[96][1], redDetails[96][2], redDetails[96][3], redDetails[96][4]},
                {redDetails[97][0], redDetails[97][1], redDetails[97][2], redDetails[97][3], redDetails[97][4]},
                {redDetails[98][0], redDetails[98][1], redDetails[98][2], redDetails[98][3], redDetails[98][4]},
                {redDetails[99][0], redDetails[99][1], redDetails[99][2], redDetails[99][3], redDetails[99][4]}
            },
            new String [] {
                "Train ID", "Location", "Speed", "Authority", "Passengers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
                gui.trainDetails2.setModel(new javax.swing.table.DefaultTableModel(//red
            new Object [][] {
                {greenDetails[0][0], greenDetails[0][1], greenDetails[0][2], greenDetails[0][3], greenDetails[0][4]},
                {greenDetails[1][0], greenDetails[1][1], greenDetails[1][2], greenDetails[1][3], greenDetails[1][4]},
                {greenDetails[2][0], greenDetails[2][1], greenDetails[2][2], greenDetails[2][3], greenDetails[2][4]},
                {greenDetails[3][0], greenDetails[3][1], greenDetails[3][2], greenDetails[3][3], greenDetails[3][4]},
                {greenDetails[4][0], greenDetails[4][1], greenDetails[4][2], greenDetails[4][3], greenDetails[4][4]},
                {greenDetails[5][0], greenDetails[5][1], greenDetails[5][2], greenDetails[5][3], greenDetails[5][4]},
                {greenDetails[6][0], greenDetails[6][1], greenDetails[6][2], greenDetails[6][3], greenDetails[6][4]},
                {greenDetails[7][0], greenDetails[7][1], greenDetails[7][2], greenDetails[7][3], greenDetails[7][4]},
                {greenDetails[8][0], greenDetails[8][1], greenDetails[8][2], greenDetails[8][3], greenDetails[8][4]},
                {greenDetails[9][0], greenDetails[9][1], greenDetails[9][2], greenDetails[9][3], greenDetails[9][4]},

                {greenDetails[10][0], greenDetails[10][1], greenDetails[10][2], greenDetails[10][3], greenDetails[10][4]},
                {greenDetails[11][0], greenDetails[11][1], greenDetails[11][2], greenDetails[11][3], greenDetails[11][4]},
                {greenDetails[12][0], greenDetails[12][1], greenDetails[12][2], greenDetails[12][3], greenDetails[12][4]},
                {greenDetails[13][0], greenDetails[13][1], greenDetails[13][2], greenDetails[13][3], greenDetails[13][4]},
                {greenDetails[14][0], greenDetails[14][1], greenDetails[14][2], greenDetails[14][3], greenDetails[14][4]},
                {greenDetails[15][0], greenDetails[15][1], greenDetails[15][2], greenDetails[15][3], greenDetails[15][4]},
                {greenDetails[16][0], greenDetails[16][1], greenDetails[16][2], greenDetails[16][3], greenDetails[16][4]},
                {greenDetails[17][0], greenDetails[17][1], greenDetails[17][2], greenDetails[17][3], greenDetails[17][4]},
                {greenDetails[18][0], greenDetails[18][1], greenDetails[18][2], greenDetails[18][3], greenDetails[18][4]},
                {greenDetails[19][0], greenDetails[19][1], greenDetails[19][2], greenDetails[19][3], greenDetails[19][4]},

                  {greenDetails[20][0], greenDetails[20][1], greenDetails[20][2], greenDetails[20][3], greenDetails[20][4]},
                {greenDetails[21][0], greenDetails[21][1], greenDetails[21][2], greenDetails[21][3], greenDetails[21][4]},
                {greenDetails[22][0], greenDetails[22][1], greenDetails[22][2], greenDetails[22][3], greenDetails[22][4]},
                {greenDetails[23][0], greenDetails[23][1], greenDetails[23][2], greenDetails[23][3], greenDetails[23][4]},
                {greenDetails[24][0], greenDetails[24][1], greenDetails[24][2], greenDetails[24][3], greenDetails[24][4]},
                {greenDetails[25][0], greenDetails[25][1], greenDetails[25][2], greenDetails[25][3], greenDetails[25][4]},
                {greenDetails[26][0], greenDetails[26][1], greenDetails[26][2], greenDetails[26][3], greenDetails[26][4]},
                {greenDetails[27][0], greenDetails[27][1], greenDetails[27][2], greenDetails[27][3], greenDetails[27][4]},
                {greenDetails[28][0], greenDetails[28][1], greenDetails[28][2], greenDetails[28][3], greenDetails[28][4]},
                {greenDetails[29][0], greenDetails[29][1], greenDetails[29][2], greenDetails[29][3], greenDetails[29][4]},

		{greenDetails[30][0], greenDetails[30][1], greenDetails[30][2], greenDetails[30][3], greenDetails[30][4]},
                {greenDetails[31][0], greenDetails[31][1], greenDetails[31][2], greenDetails[31][3], greenDetails[31][4]},
                {greenDetails[32][0], greenDetails[32][1], greenDetails[32][2], greenDetails[32][3], greenDetails[32][4]},
                {greenDetails[33][0], greenDetails[33][1], greenDetails[33][2], greenDetails[33][3], greenDetails[33][4]},
                {greenDetails[34][0], greenDetails[34][1], greenDetails[34][2], greenDetails[34][3], greenDetails[34][4]},
                {greenDetails[35][0], greenDetails[35][1], greenDetails[35][2], greenDetails[35][3], greenDetails[35][4]},
                {greenDetails[36][0], greenDetails[36][1], greenDetails[36][2], greenDetails[36][3], greenDetails[36][4]},
                {greenDetails[37][0], greenDetails[37][1], greenDetails[37][2], greenDetails[37][3], greenDetails[37][4]},
                {greenDetails[38][0], greenDetails[38][1], greenDetails[38][2], greenDetails[38][3], greenDetails[38][4]},
                {greenDetails[39][0], greenDetails[39][1], greenDetails[39][2], greenDetails[39][3], greenDetails[39][4]},

                {greenDetails[40][0], greenDetails[40][1], greenDetails[40][2], greenDetails[40][3], greenDetails[40][4]},
                {greenDetails[41][0], greenDetails[41][1], greenDetails[41][2], greenDetails[41][3], greenDetails[41][4]},
                {greenDetails[42][0], greenDetails[42][1], greenDetails[42][2], greenDetails[42][3], greenDetails[42][4]},
                {greenDetails[43][0], greenDetails[43][1], greenDetails[43][2], greenDetails[43][3], greenDetails[43][4]},
                {greenDetails[44][0], greenDetails[44][1], greenDetails[44][2], greenDetails[44][3], greenDetails[44][4]},
                {greenDetails[45][0], greenDetails[45][1], greenDetails[45][2], greenDetails[45][3], greenDetails[45][4]},
                {greenDetails[46][0], greenDetails[46][1], greenDetails[46][2], greenDetails[46][3], greenDetails[46][4]},
                {greenDetails[47][0], greenDetails[47][1], greenDetails[47][2], greenDetails[47][3], greenDetails[47][4]},
                {greenDetails[48][0], greenDetails[48][1], greenDetails[48][2], greenDetails[48][3], greenDetails[48][4]},
                {greenDetails[49][0], greenDetails[49][1], greenDetails[49][2], greenDetails[49][3], greenDetails[49][4]},

                {greenDetails[50][0], greenDetails[50][1], greenDetails[50][2], greenDetails[50][3], greenDetails[50][4]},
                {greenDetails[51][0], greenDetails[51][1], greenDetails[51][2], greenDetails[51][3], greenDetails[51][4]},
                {greenDetails[52][0], greenDetails[52][1], greenDetails[52][2], greenDetails[52][3], greenDetails[52][4]},
                {greenDetails[53][0], greenDetails[53][1], greenDetails[53][2], greenDetails[53][3], greenDetails[53][4]},
                {greenDetails[54][0], greenDetails[54][1], greenDetails[54][2], greenDetails[54][3], greenDetails[54][4]},
                {greenDetails[55][0], greenDetails[55][1], greenDetails[55][2], greenDetails[55][3], greenDetails[55][4]},
                {greenDetails[56][0], greenDetails[56][1], greenDetails[56][2], greenDetails[56][3], greenDetails[56][4]},
                {greenDetails[57][0], greenDetails[57][1], greenDetails[57][2], greenDetails[57][3], greenDetails[57][4]},
                {greenDetails[58][0], greenDetails[58][1], greenDetails[58][2], greenDetails[58][3], greenDetails[58][4]},
                {greenDetails[59][0], greenDetails[59][1], greenDetails[59][2], greenDetails[59][3], greenDetails[59][4]},

                {greenDetails[60][0], greenDetails[60][1], greenDetails[60][2], greenDetails[60][3], greenDetails[60][4]},
                {greenDetails[61][0], greenDetails[61][1], greenDetails[61][2], greenDetails[61][3], greenDetails[61][4]},
                {greenDetails[62][0], greenDetails[62][1], greenDetails[62][2], greenDetails[62][3], greenDetails[62][4]},
                {greenDetails[63][0], greenDetails[63][1], greenDetails[63][2], greenDetails[63][3], greenDetails[63][4]},
                {greenDetails[64][0], greenDetails[64][1], greenDetails[64][2], greenDetails[64][3], greenDetails[64][4]},
                {greenDetails[65][0], greenDetails[65][1], greenDetails[65][2], greenDetails[65][3], greenDetails[65][4]},
                {greenDetails[66][0], greenDetails[66][1], greenDetails[66][2], greenDetails[66][3], greenDetails[66][4]},
                {greenDetails[67][0], greenDetails[67][1], greenDetails[67][2], greenDetails[67][3], greenDetails[67][4]},
                {greenDetails[68][0], greenDetails[68][1], greenDetails[68][2], greenDetails[68][3], greenDetails[68][4]},
                {greenDetails[69][0], greenDetails[69][1], greenDetails[69][2], greenDetails[69][3], greenDetails[69][4]},

                {greenDetails[70][0], greenDetails[70][1], greenDetails[70][2], greenDetails[70][3], greenDetails[70][4]},
                {greenDetails[71][0], greenDetails[71][1], greenDetails[71][2], greenDetails[71][3], greenDetails[71][4]},
                {greenDetails[72][0], greenDetails[72][1], greenDetails[72][2], greenDetails[72][3], greenDetails[72][4]},
                {greenDetails[73][0], greenDetails[73][1], greenDetails[73][2], greenDetails[73][3], greenDetails[73][4]},
                {greenDetails[74][0], greenDetails[74][1], greenDetails[74][2], greenDetails[74][3], greenDetails[74][4]},
                {greenDetails[75][0], greenDetails[75][1], greenDetails[75][2], greenDetails[75][3], greenDetails[75][4]},
                {greenDetails[76][0], greenDetails[76][1], greenDetails[76][2], greenDetails[76][3], greenDetails[76][4]},
                {greenDetails[77][0], greenDetails[77][1], greenDetails[77][2], greenDetails[77][3], greenDetails[77][4]},
                {greenDetails[78][0], greenDetails[78][1], greenDetails[78][2], greenDetails[78][3], greenDetails[78][4]},
                {greenDetails[79][0], greenDetails[79][1], greenDetails[79][2], greenDetails[79][3], greenDetails[79][4]},

                {greenDetails[80][0], greenDetails[80][1], greenDetails[80][2], greenDetails[80][3], greenDetails[80][4]},
                {greenDetails[81][0], greenDetails[81][1], greenDetails[81][2], greenDetails[81][3], greenDetails[81][4]},
                {greenDetails[82][0], greenDetails[82][1], greenDetails[82][2], greenDetails[82][3], greenDetails[82][4]},
                {greenDetails[83][0], greenDetails[83][1], greenDetails[83][2], greenDetails[83][3], greenDetails[83][4]},
                {greenDetails[84][0], greenDetails[84][1], greenDetails[84][2], greenDetails[84][3], greenDetails[84][4]},
                {greenDetails[85][0], greenDetails[85][1], greenDetails[85][2], greenDetails[85][3], greenDetails[85][4]},
                {greenDetails[86][0], greenDetails[86][1], greenDetails[86][2], greenDetails[86][3], greenDetails[86][4]},
                {greenDetails[87][0], greenDetails[87][1], greenDetails[87][2], greenDetails[87][3], greenDetails[87][4]},
                {greenDetails[88][0], greenDetails[88][1], greenDetails[88][2], greenDetails[88][3], greenDetails[88][4]},
                {greenDetails[89][0], greenDetails[89][1], greenDetails[89][2], greenDetails[89][3], greenDetails[89][4]},

                {greenDetails[90][0], greenDetails[90][1], greenDetails[90][2], greenDetails[90][3], greenDetails[90][4]},
                {greenDetails[91][0], greenDetails[91][1], greenDetails[91][2], greenDetails[91][3], greenDetails[91][4]},
                {greenDetails[92][0], greenDetails[92][1], greenDetails[92][2], greenDetails[92][3], greenDetails[92][4]},
                {greenDetails[93][0], greenDetails[93][1], greenDetails[93][2], greenDetails[93][3], greenDetails[93][4]},
                {greenDetails[94][0], greenDetails[94][1], greenDetails[94][2], greenDetails[94][3], greenDetails[94][4]},
                {greenDetails[95][0], greenDetails[95][1], greenDetails[95][2], greenDetails[95][3], greenDetails[95][4]},
                {greenDetails[96][0], greenDetails[96][1], greenDetails[96][2], greenDetails[96][3], greenDetails[96][4]},
                {greenDetails[97][0], greenDetails[97][1], greenDetails[97][2], greenDetails[97][3], greenDetails[97][4]},
                {greenDetails[98][0], greenDetails[98][1], greenDetails[98][2], greenDetails[98][3], greenDetails[98][4]},
                {greenDetails[99][0], greenDetails[99][1], greenDetails[99][2], greenDetails[99][3], greenDetails[99][4]}
            },
            new String [] {
                "Train ID", "Location", "Speed", "Authority", "Passengers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
    }
                        

    private String checkUserStation(String lastStation) {
        String station=(String) gui.jComboBox1.getSelectedItem();
        if ((lastStation!=null)  &&  (lastStation.equalsIgnoreCase(station)!=true)){
            System.out.println("MBO: User chose:"+station);
            lastStation=station;
        }
        return lastStation;

    }

    
    /**
     * initializes the id to -1 and the color to "---" to avoid null pointer exceptions 
     * @param allTrains
     * @return allTrains
     */
    private mboTrain[] mboTrainInitialization(mboTrain[] allTrains) {
        mboTrain[] t=new mboTrain[100];
        int i=0;
        for(i=0;i<100;i++){
            t[i]=new mboTrain();
            t[i].id=0;
            t[i].AMPM=-1;
            t[i].block=-1;
            t[i].authority=-1;
            t[i].bound="---";
            t[i].departureTime="---";
            t[i].hour=-1;
            t[i].minutes=-1;
            t[i].metersInBlock=-1;
            t[i].number=-1;
            t[i].speed=-1;
            t[i].color= "---";
            //System.out.println(""+t[i].id+"  "+t[i].color);
        }
        return t;
   }

    private mboTrainDepartInfo[] initializeDepartInfo() {
       mboTrainDepartInfo[] a = new mboTrainDepartInfo[100];
       mboTrainDepartInfo info = new mboTrainDepartInfo();
       int i=0;
       for (i=0;i<100;i++){
           a[i]=info;
       }
       return a;
    }
}
