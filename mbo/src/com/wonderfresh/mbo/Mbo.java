/*
 * Moving Block Overlay portion of the train control system
 * Angela Hoeltje - amh227@pitt.edu
 */
package com.wonderfresh.mbo;

import com.wonderfresh.commons.Time;
import com.wonderfresh.commons.Block;
import com.wonderfresh.commons.PublicBlock;
import com.wonderfresh.commons.Section;
import com.wonderfresh.commons.TrackModel;
import javax.swing.JFrame;
import com.wonderfresh.interfaces.Interfaces;
import com.wonderfresh.interfaces.TrackModelInterface;
import com.wonderfresh.commons.TrackModelImplementation;

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
        
        //max 100 trains per line
        mboTrain[] redTrain=new mboTrain[100];
        mboTrain[] greenTrain=new mboTrain[100];
        String[] redSta=new String[20];
        String[] greenSta=new String[20];
        boolean shift[][]=new boolean[7][120]; //max run 1 every 5mins
        int i;
        int passengerCount=0;
        String station =null;
        int greenRuns,redRuns;
        int redRunTime,greenRunTime; 
        int passPerCar=300; //assume that all 300 wont ride at once
        boolean test=true;
        int running=1;
        Time startTime=Time.getTimeNow();
        String timeOutput,lastStation="nothing";
        Time currentTime=startTime;
       /*
        mboUI gui = new mboUI(); // GUI gui = new GUI() as well
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        */
        System.out.println("Done");
        
//Get User Inputs
        
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
        System.out.println("MBO: Accepted inputs (Drivers:"+drivers+", Red Passengers:"+redPassengers+", GreenPassengers:"+greenPassengers);      
//get tracks
        
        TrackModel tm=new TrackModel();
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   //model input
        /*
        drivers=gui.drivers;
        redPassengers=gui.redPass;
        greenPassengers=gui.greenPass;
        */
    //estimate train runs for passengers
        int minsPerDay=28*60;   //24+4 for double rush
        int redWait = 0;
        redRuns=(redPassengers/passPerCar);//24+4 for double car on rush hour
        greenRuns=(greenPassengers/passPerCar);
        
        if (redRuns>0){
           redWait=(minsPerDay/redRuns);}
        redWait=redWait-redWait%5;
        int greenWait=(minsPerDay/greenRuns);
        greenWait=greenWait-greenWait%5;
        if(drivers>50){System.out.println("MBO: Only 50 Drivers are supported");}
        if(drivers<7){System.out.println("MBO: Innadequate number of drivers to run 24 hours a day, 7 days a week");}
        System.out.println("MBO: Number of Drivers:"+drivers);
        System.out.println("MBO: Red Passangers: "+redPassengers+"  Running total:"+redRuns+ "  minutes between runs: "+(minsPerDay/redRuns)+ "  redWait:"+redWait);    
        System.out.println("MBO: Green Passangers: "+greenPassengers+ "  Running total: "+greenRuns+"  minutes between runs: "+(minsPerDay/greenRuns)+"  greenWait"+greenWait);
        
        int timeBetweenAllRuns=(((redWait+greenWait)/2)-((redWait+greenWait)/2)%5);
        
        System.out.println("MBO: need a driver every "+timeBetweenAllRuns+" minutes");
        driverSchedule ds=new driverSchedule();
        ds.getSchedule(drivers, shift, timeBetweenAllRuns);
//DisplayDrivers      
        setDriverArray(ds);
//Load Track
        
//Get Safe breaking distance with max speed off of the blocks &print to Screen
        double minDist=0;
        double maxSpeed=40;
        //get max speed by iterating through the track
        minDist=getBrakeDistance(maxSpeed);
        System.out.println("MBO: Min braking distance: "+minDist);
//Get time around track
        
//create Train schedule with available drivers
        
//outputTrainSchedule
        //get station
        //add time for station
        
       
        running=1;
        while(running==1){
            //update time
            if (gui!=null){
                gui.clock.setText(Time.stringTime(Time.getTimeNow()));  
                /*
                *get closed track information from CTC --- Save to String temp
                */
                String[] closedTracks=new String[100];
   //---> closedTracks=com.wonderfresh.interfaces.CTC.getClosedTracks();
                displayClosedTracks(closedTracks);
                
                /*
                Get Updated Track chosen for schedule
                (String)myCombobox.getSelectedItem()
                onlyprints if station is changed
                */
                station=(String) gui.jComboBox1.getSelectedItem();
                if (lastStation.equalsIgnoreCase(station)!=true){
                    System.out.println("MBO: User chose:"+station);
                    lastStation=station;
                }
                
                
                //iterate track schedule for time to new station
                
                /*
                Get train locations from Communications
                */
                
                /*
                Update authority with distance to station
                */
                
                
                
                gui.passengerCount.setText(" "+(passengerCount));
            }
        }
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
    int getTimeAroundTrack(int track){
        int time=0;
        //red
        if (track==0){
 /**
  * Add u,c,b,a,f,g,h,i,j,k,l,m,n,i,
  */           
            
            
        }
        else{ //green
            
            
            
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
            new String [] {
                "Train ID", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
            
        
      }
}
