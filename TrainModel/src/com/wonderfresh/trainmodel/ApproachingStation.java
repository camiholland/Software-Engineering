/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trainmodel;

import static java.lang.Math.ceil;
import com.wonderfresh.commons.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cami
 */
public class ApproachingStation implements Runnable {
    int currentTime;
    TrainModelUI gui;
    Time time;
    
    Thread thr;
    boolean started;
    boolean isApproaching;
    boolean isVisible;
    
    javax.swing.JLabel label;
    
    public ApproachingStation(TrainModelUI GUI){
        gui = GUI;
        thr = new Thread(this);
        started = false;
        time = time.getInstance();
        isApproaching = false;
        isVisible = false;
    }
    public void blink(javax.swing.JLabel label){
        this.label = label;
        isApproaching = true;
        if(!started){
            started = true;
            thr.start();
        }
    }
    public void isAtStation(javax.swing.JLabel label){
        isApproaching = false;
    }
    
    public void run(){
        while(true){
            while(isApproaching){
                isVisible = !isVisible;
                gui.blink(label, isVisible);
                
                try {
                    Thread.sleep(1000 / time.getSpeed());
                } catch (InterruptedException ex) {
                    Logger.getLogger(TemperatureCalculator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
