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
        String timeOutput="00:00:00";
        int running=1;
        int timeConstant = 1;
        int startTime=time.get(0, timeConstant);
        int currentTime=startTime;
        timeOutput=time.stringTime(startTime);
        ui2 ui = new ui2(); // GUI gui = new GUI() as well
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // ui.setTime(timeOutput);
        ui.setVisible(true);
        System.out.println("Done");
        
        //Get Schedule loaded
        
        
        
        
        while(running==1){
            //update time
            currentTime=time.get(startTime, timeConstant);
            timeOutput=time.stringTime(currentTime);
            //ui.setTime(timeOutput);
             
        }
            
            
        

        
    }
    
}
