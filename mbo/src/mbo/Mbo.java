/*
 * Moving Block Overlay portion of the train control system
 */
package mbo;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import javax.swing.JFrame;


/**
 *
 * @author angie
 */
public class Mbo {
    
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        int drivers = 0;
        int redPassengers;
        int greenPassengers;
        int timeConst=1;
        String timeOutput="00:00:00";
        boolean test=true;
        int running=1;
        int timeConstant = 10;
        time startTime=time.getTimeNow();
        time currentTime=startTime;
        timeOutput=time.stringTime(startTime);
        ui gui = new ui(); // GUI gui = new GUI() as well
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // ui.setTime(timeOutput);
        gui.setVisible(true);
        System.out.println("Done");
        
        //Get User Inputs
        while(running==1){
    //keep clock running            
            if (timeConst==1){
                currentTime=time.getTimeNow();
                gui.clock.setText(time.stringTime(currentTime));
            }
            else if (timeConst==10){ gui.clock.setText(time.stringTime(time.get10x(startTime, timeConst))); }
            else{ System.out.println("Issue with time constant; not 1 or 10"); }
            //wait for data
           if (gui.getData==1){
               running=0;
           } 
        }
        System.out.println("Accepted inputs");
      
    //get tracks
        section[] greenTrack=new section[100];
        section[] redTrack=new section[100];
        
        
        int numDrivers=drivers;
        driverSchedule ds=new driverSchedule();
        ds=driverSchedule.getSchedule(numDrivers);
        
        int count=0;
        //generate schedulesme.getTimeNow();
        running=1;
        while(running==1){
            //arbitrary passenger count
            count++;
            //update time
            currentTime=time.getTimeNow();
            if (timeConst==10){timeOutput=time.stringTime(time.get10x(startTime, timeConst));}
            else{timeOutput=time.stringTime(currentTime);}
            
            
            
            gui.displayClosedTrack.getModel().setValueAt(timeOutput, 0, 0);
            gui.clock.setText(timeOutput);
            gui.passengerCount.setText(" "+count);
            //gui.displayClosedTrack.setModel("Testing");
            gui.displayClosedTrack.repaint();
            //gui.jScrollPane1.setViewportView(gui.displayClosedTrack);
            
            
            
        }
            
            
        

        
    }
    
}
