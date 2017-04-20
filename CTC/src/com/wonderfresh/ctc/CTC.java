package com.wonderfresh.ctc;

import java.io.*;
import java.io.BufferedReader;

import com.wonderfresh.commons.Block;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.wonderfresh.commons.Time;
import com.wonderfresh.interfaces.MboInterface;
import com.wonderfresh.commons.mboTrain;

//@author Sarah
public class CTC extends Thread {
    int i;
    Block[] greenBlocks, redBlocks;
    Time time;
    CTCUI ctcui;
    int mode;
    int simspeed;
    Time startTime;
    Time currentTime;
    double starttimedecimal;
    double currenttimedecimal;
    String[] scheduleLines;
    MboInterface mbo;
    mboTrain[] mboTrains;
    String[] closedblocks;
    ScheduleItem[] schedule; //index is train id
    int nblocks;
    
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
        
        ctcui = new CTCUI();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ctcui.setVisible(true);
            }
        });
    }
    
    public void init() throws Exception {
        //load fixed block automatic mode schedule
        String scheduleFilename = "/Users/Madchen/Documents/sched.txt"; //hardcoded temporarily
        scheduleLines = loadArrayStyleFile(scheduleFilename);
    }
    
    public void run() {
        startTime=Time.getTimeNow();
        currentTime=startTime;
        starttimedecimal = 0;
        currenttimedecimal = starttimedecimal;
        mode = 0;
        
        //to account for every train theoretically possible,
        //schedule has length = number of blocks in whole transit system
        nblocks = ctcui.strak.mytrack.getGreenCount() + ctcui.strak.mytrack.getRedCount();
        schedule = new ScheduleItem[nblocks];
        
        int i;
        
        while(true) {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) { Logger.getLogger(CTC.class.getName()).log(Level.SEVERE, null, ex); }
            
            //check time
            currentTime = Time.getTimeNow();
            currenttimedecimal = timeToDouble(currentTime);
            
            //check track
            //for every block
            for (i=0; i < ctcui.strak.mytrack.getGreenCount(); i++) {
                
            }
            for (i=0; i < ctcui.strak.mytrack.getRedCount(); i++) {
                
            }
            
            //check trains
            
            //check MBO if in MBO mode
            if (ctcui.mode == 2) {
                //lots of functions that return an mboTrain array
                //are they really interchangeable?
                mboTrains = mbo.getUpdatedSpeedAuthority();
                for (i=0;i<mboTrains.length;i++) {
                    //check for new speed, auth, and train ids
                    //compare to current train/track info
                    //call track controller if something's different
                }
                closedblocks = mbo.getClosedBlocks();
                for (i=0;i<closedblocks.length;i++) {
                    //check for changed blocks
                    //compare to current track info
                    //call track controller if something's different
                }
            }
            //check own schedule if in Fixed Block Auto mode
            else if (ctcui.mode == 1) {
                
            }
            
            //calculate throughput
            calcThroughput();
            
            //animations?
        }
    }


    //yes, java functions return the whole array. use with care.
    public String[] loadArrayStyleFile(String filename) throws Exception {
//    public static String[] loadArrayStyleFile(String filename) throws Exception {
        String[] items;
        int i;
        int numLines;

        //try-with-resources, closes resources automatically at end of block
        //or when there's an exception
        try (BufferedReader buf = new BufferedReader(new FileReader(filename))) {
            numLines = Integer.parseInt(buf.readLine());
            items = new String[numLines];

            for (i = 0; i < numLines; i++) {
                items[i] = buf.readLine();
            }
        }

        //could also buf.close() here but the try block is safer
        return items;
    }
    
    public void routeTrains() {
        ScheduleItem[] newschedule = scheduleNext();
        
        //get schedule
        //see if schedule is same as old schedule, if yes return
        
        //iterate over the schedule:
        //give trains their speed and auth
        //then remove that instr from the schedule
        //then send request to track controller
        //if request was success, update your info
    }
    
//    int trainID;
//    Block currBlock;
//    Block prevBlock;
//    String currLine;
//    double currDistance;
//    
//    //predictions about the train
//    Block nextBlock;
//    String nextLine;
//    
//    //suggestions scheduled for this train
//    double speed, authority;
//    Block destination;
    public ScheduleItem[] scheduleNext() {
        int i, j;
        ScheduleItem tempCurrSchedItem;
        Block movingToNextBlock;
        
        ScheduleItem[] newschedule = new ScheduleItem[nblocks];
        //make sure lines and trains are updated (maybe not necessary)
        
        //for each train
        int[] trainids = ctcui.getMyTrains();
        for (i=0;i<ctcui.ntrains;i++) {
            //the schedule update
            newschedule[trainids[i]] = new ScheduleItem();
            //the old schedule
            tempCurrSchedItem = schedule[trainids[i]];
            
            //check whether train has traveled to the next block
            if (tempCurrSchedItem.currDistance > tempCurrSchedItem.currBlock.getBlockLength()) {
                //get next block to move to
                movingToNextBlock = tempCurrSchedItem.currBlock.getNextBlock(tempCurrSchedItem.prevBlock);
            }
            
            //update train info
            
            //check whether train has reached destination
            if (tempCurrSchedItem.currBlock.getBlockNum() == tempCurrSchedItem.destination.getBlockNum()) {
                
            }
            
            //check whether exceeded authority
            if (tempCurrSchedItem.authority <= 0) {
                
            }
            
            //add new train speed, authority, etc to schedule
        }
        
        return newschedule;
    }
    
    //returns time as a decimal number of hours
    public double timeToDouble(Time time) {
        double hr = 0, min = 0, sec = 0;
        
        char[] timeArray = time.getTime().toCharArray();
        
        //if hours < 10
        if (timeArray[0] != '0') {
            hr += Character.getNumericValue(timeArray[0])*10;
        }
        hr += Character.getNumericValue(timeArray[1]);
        
        //if minutes < 10
        if (timeArray[3] != '0') {
            min += Character.getNumericValue(timeArray[3])*10;
        }
        min += Character.getNumericValue(timeArray[4]);
        
        //if seconds < 10
        if (timeArray[6] != '0') {
            sec += Character.getNumericValue(timeArray[6])*10;
        }
        sec += Character.getNumericValue(timeArray[7]);
        
        return hr + min/60 + sec/360;
    }
    
    public double calcThroughput() {
        double trains = 1;
        
        double tput = trains/currenttimedecimal;
        ctcui.setThroughput(tput);
        
        return tput;
    }
}
