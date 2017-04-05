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

public class PowerCalculators extends Thread{
    
    private TrainController train;
    private PowerCalculator pc0;
    private PowerCalculator pc1;
    private PowerCalculator pc2;
    private Time time;
    private boolean station;
    private boolean proceed;
    private boolean stop;
    
    
    @SuppressWarnings("CallToThreadStartDuringObjectConstruction")
    public PowerCalculators(TrainController train, double kp, double ki) {
        this.train = train;
        pc0 = new PowerCalculator(train, kp, ki);
        pc1 = new PowerCalculator(train, kp, ki);
        pc2 = new PowerCalculator(train, kp, ki);
        time = Time.getInstance();
        proceed = true;
        stop = false;
        
        pc0.start();
        pc1.start();
        pc2.start();
    }
    
    public void setGainValues(double kp, double ki){
        pc0.setGainValues(kp,ki);
        pc1.setGainValues(kp,ki);
        pc2.setGainValues(kp,ki);
    }
    
    public void stopTemp() {
        pc0.stopTemp();
        pc1.stopTemp();
        pc2.stopTemp();
    }
    
    public void startTemp() {
        pc0.startTemp();
        pc1.startTemp();
        pc2.startTemp();
    }
    
    public void stopRun() {
        proceed = false;
    }
    
    @SuppressWarnings("SleepWhileInLoop")
    @Override
    public void run() {
        
        double prevPowerCommand = -1;
        double powerCommand;
        double powerCommand1;
        double powerCommand2;
        double speed;
        
        while (proceed) {
            while(stop) {
                try {
                    sleep(1000 / time.getSpeed());
                } catch (InterruptedException ex) {
                    //busy waiting // nothing is required
                }
            }
            
            powerCommand = pc0.getPowerCommand();
            powerCommand1 = pc1.getPowerCommand();
            powerCommand2 = pc2.getPowerCommand();
            
            if (powerCommand1 < powerCommand) {
                powerCommand = powerCommand1;
            }
            
            if (powerCommand2 < powerCommand) {
                powerCommand = powerCommand2;
            }
            
            speed = train.getRealSpeed();
            
            //commented for testing
            //if (prevPowerCommand != powerCommand) {
                train.setPowerCommand(powerCommand);
                prevPowerCommand = powerCommand;
            //}
            
            //sleep till one second system time
            try {
                sleep(1000 / time.getSpeed());
            } catch (InterruptedException ex) {
                //busy waiting // nothing is required
            }
        }
        
    }
      
}
