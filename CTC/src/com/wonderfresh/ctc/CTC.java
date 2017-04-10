package com.wonderfresh.ctc;

import java.io.*;
import java.io.BufferedReader;

//import com.wonderfresh.trackmodel;

//@author Sarah
public class CTC {

    public static void main(String args[]) throws Exception {
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

        //load fixed block automatic mode schedule
        //String scheduleFilename = "/Users/Madchen/Documents/sched.txt"; //hardcoded temporarily
        //String[] scheduleLines = loadArrayStyleFile(scheduleFilename);
        
        //load track
        //a TrackModel has two TrackGraphs (one for each line)
        //a TrackGraph has Blocks, Sections, Edges and Switches.
        //each of those things has more member variables
        //TrackModel mytrack = TrackModelInterface.getTrackModel();
        
        //mytrack won't stay synced with real track without input from track controller
        
        //note: instead of switching data in block table,
        //have two tables and switch tables
        //have a function for loading the tables
        //fill green line block table with green line blocks
        //same for red line
        
        //load switch table too
        
        //and remember, again
        //don't update mytrack unless track controller says so
        //even when you send info to track
        //because you don't know for sure it'll be successful
        
        //Create and display the user interface
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CTCUI().setVisible(true);
            }
        });
        
        //need a loop that checks for changing values
        //check time
        //check track
        //check MBO if in MBO mode
        //check own schedule if in Fixed Block Auto mode
        //calculate throughput
        //animations?
    }

    //yes, java functions return the whole array. use with care.
    public static String[] loadArrayStyleFile(String filename) throws Exception {
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
}
