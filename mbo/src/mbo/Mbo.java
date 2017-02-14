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
    int drivers;
    int redPassengers;
    int greenPassengers;
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        String timeOutput="00:00:00";
        boolean test=true;
        int running=1;
        int timeConstant = 1;
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
            currentTime=time.getTimeNow();
            timeOutput=time.stringTime(currentTime);
            gui.jTextField1.setText(timeOutput);
            //wait for data
           if (gui.getData==1){
               running=0;
           } 
        }
        System.out.println("Accepted inputs");
        
        //generate schedulesme.getTimeNow();
        running=1;
        while(running==1){
            //update time
            currentTime=time.getTimeNow();
            timeOutput=time.stringTime(currentTime);
            gui.displayClosedTrack.getModel().setValueAt(timeOutput, 0, 0);
            gui.jTextField1.setText(timeOutput);
            //gui.displayClosedTrack.setModel("Testing");
            gui.displayClosedTrack.repaint();
            //gui.jScrollPane1.setViewportView(gui.displayClosedTrack);
        }
            
            
        

        
    }
    
}
