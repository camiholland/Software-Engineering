package com.wonderfresh.ctc;

import java.io.*;
import java.io.BufferedReader;

//import com.wonderfresh.trackmodel;
import com.wonderfresh.commons.Block;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.wonderfresh.commons.Time;

//@author Sarah
public class CTC extends Thread {
    int i;
    Block[] greenBlocks, redBlocks;
    Time time;
    CTCUI ctcui;
    int mode;
    int simspeed;
    public CTC() {
        
    }
    
    public void launchUI() {
        //Set the Nimbus look and feel for the user interface
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CTCUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CTCUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CTCUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CTCUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ctcui.setVisible(true);
            }
        });
    }
    
//    public void init() throws Exception {
//        //load fixed block automatic mode schedule
//        String scheduleFilename = "/Users/Madchen/Documents/sched.txt"; //hardcoded temporarily
//        String[] scheduleLines = loadArrayStyleFile(scheduleFilename);
//    }
    
    public void run() {
        ctcui = new CTCUI();
        mode = 0;
        int i;
        
        while(true) {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) { Logger.getLogger(CTC.class.getName()).log(Level.SEVERE, null, ex); }
            
            //check time
            time = Time.getTimeNow();
            
            //check track
            //for every block
            for (i=0; i < ctcui.strak.mytrack.getGreenCount(); i++) {
                
            }
            for (i=0; i < ctcui.strak.mytrack.getRedCount(); i++) {
                
            }
            
            //check trains
            
            //check MBO if in MBO mode
            
            //check own schedule if in Fixed Block Auto mode
            
            //calculate throughput
            
            //animations?
        }
    }


    //yes, java functions return the whole array. use with care.
//    public String[] loadArrayStyleFile(String filename) throws Exception {
////    public static String[] loadArrayStyleFile(String filename) throws Exception {
//        String[] items;
//        int i;
//        int numLines;
//
//        //try-with-resources, closes resources automatically at end of block
//        //or when there's an exception
//        try (BufferedReader buf = new BufferedReader(new FileReader(filename))) {
//            numLines = Integer.parseInt(buf.readLine());
//            items = new String[numLines];
//
//            for (i = 0; i < numLines; i++) {
//                items[i] = buf.readLine();
//            }
//        }
//
//        //could also buf.close() here but the try block is safer
//        return items;
//    }
    
    public void routeTrains() {
        //get schedule
        //see if schedule is same as old schedule, if yes return
        
        //iterate over the schedule:
        //give trains their speed and auth
        //then remove that instr from the schedule
        //then send request to track controller
        //if request was success, update your info
    }
    
    public void scheduleNext() {
        //get make sure lines and trains are updated
        
        //for each train
        //check whether train has traveled to the next block
        //because switches, must determine what that block is
        //update train info
        //check whether train has reached destination
        //check whether exceeded authority
        //add new train speed, authority, etc to schedule
        
        //return the new schedule
    }
}
