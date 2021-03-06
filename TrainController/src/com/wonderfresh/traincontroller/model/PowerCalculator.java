/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller.model;


/**
 *
 * @author Austin
 */

import com.wonderfresh.commons.Time;

public class PowerCalculator extends Thread{
    
    
    private TrainController train;
    @SuppressWarnings("FieldMayBeFinal")
    private Time time;
    private double prevPowerCommand;
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
        time = Time.getInstance();
        this.kp = kp;
        this.ki = ki;
        
        ek = 0;
        ek1 = 0;
        uk = -1000;
        uk1 = -1000;
        prevPowerCommand = 0;
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
        ek = 0;
        ek1 = 0;
        uk = -1000;
        uk1 = -1000;
    }
    
    public void startTemp() {
        stop = false;
    }
    
    public void setGainValues(double kp, double ki){
        this.kp = kp;
        this.ki = ki;
    }
    
    public double getPowerCommand() {
        return powerCommand;
    }
    
    /**
     * Calculate power output based on current and requested speeds
     */
    
    @SuppressWarnings("SleepWhileInLoop")
    @Override
    public void run() {
        proceed = true;
        
        while (proceed) {  
            
            while (stop) {
                
                powerCommand = 0;
                
                try {
                    sleep(1000 / time.getSpeed());
                } catch (InterruptedException ex) {
                    //busy waiting // nothing is required
                }
            }
                
            double vReq, vCur;

            if (uk == -1000 || uk1 == -1000) {
                uk1 = uk;
                vReq = 0.44704 * (double)train.getSetSpeed();
                vCur = 0.44704 * train.getRealSpeed();
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
                vReq = 0.44704 * train.getSetSpeed();
                vCur = 0.44704 * train.getRealSpeed();
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
        
            //sleep till one second system time
            try {
                sleep(1000 / time.getSpeed());
            } catch (InterruptedException ex) {
                //busy waiting // nothing is required
            }
        }         
        
        train = null;
    }

}
