/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Austin
 */
public class PowerCalculator extends Thread{
    
    
    private TrainController train;
    private double powerCommand;
    private double kp;
    private double ki;
    private double ek;
    private double ek1;
    private double uk;
    private double uk1;
    private final double T = 1; //sampling period of the train model is 1 sec
    private final double pMax;
    private boolean proceed;
    private boolean stop;
    
    public PowerCalculator(TrainController train, double kp, double ki) {
        this.train = train;
        this.kp = kp;
        this.ki = ki;
        
        ek = 0;
        ek1 = 0;
        uk = -1000;
        uk1 = -1000;
        powerCommand = 0;
        
        double M = 50*1000; //train is 50 metric tons / 1000kg
        double maxa = 0.5;
        double maxv = 70*((double)1000/(double)3600); // 70km/h * 1h/3600s * 1000m/1km
        pMax = 120000;
    }

    /**
     * Used to stop the loop before the controller is disposed
     */
    public void stopRun() {
        proceed = false;
    }
    
    /**
     * Used to temporarily stop the train
     */
    public void stopTemp() {
        stop = true;
    }
    
    public void startTemp() {
        stop = false;
    }
    
    public void setGainValues(double kp, double ki){
        this.kp = kp;
        this.ki = ki;
    }
    
    /**
     * Calculate power output based on current and requested speeds
     */
    
    @SuppressWarnings("SleepWhileInLoop")
    @Override
    public void run() {
        proceed = true;
        
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PowerCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (proceed) {
            
            while (stop) {
                
                if (powerCommand != 0) {
                    train.setPowerCommand(0); //ensure train sets power to 0
                }
            
                try {
                    sleep(1000);
                } catch (Exception ex) {
                    //busy waiting // nothing is required
                }
            }
             
            long timestart = System.currentTimeMillis();
                
            double vReq, vCur;

            if (uk == -1000 || uk1 == -1000) {
                uk1 = uk;
                vReq = 1.60934 * (double)train.getSetSpeed();
                vCur = 1.60934 * train.getRealSpeed();
                if (uk == 0) {
                    uk = (T/2)*(ek + ek1);
                } else {
                    uk = 0;
                }

                if (ek > 0 || vReq != 0) {
                    powerCommand = pMax;
                } else {
                    powerCommand = 0;
                }

            } else {
                //calculate ek
                ek1 = ek; //update old value
                vReq = 1.60934 * train.getSetSpeed();
                vCur = 1.60934 * train.getRealSpeed();
                ek = vReq - vCur;

                //calculate uk
                uk1 = uk; //update old value
                if (powerCommand >= pMax) {
                    uk = uk1 + (T/2)*(ek + ek1);
                } else {
                    uk = uk1;
                }

                //calculate power command
                powerCommand = kp*ek + ki*uk;
                
                if (powerCommand >= pMax) {
                    powerCommand = pMax;
                }
                if (vReq == 0 && vCur == 0) {
                    powerCommand = 0;
                }
            }
            
            if (vReq < vCur) {
                powerCommand = 0;
            }
            
            train.setPowerCommand(powerCommand);
        
            //sleep for one second
            try {
                sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }         
        
        train = null;
    }

}
