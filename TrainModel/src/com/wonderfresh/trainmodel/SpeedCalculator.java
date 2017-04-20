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
public class SpeedCalculator implements Runnable {
    int currentTime;
    TrainModel tm;
    Time time;
    
    Thread thr;
    boolean started;
    
    double speed;
    double targetAcc;
    double acc;
    
    public SpeedCalculator(TrainModel TM){
        tm = TM;
        thr = new Thread(this);
        started = false;
        time = time.getInstance();
    }
    
    public void setSpeed(double acc, double currentSpeed, double targetAcc) {
        this.acc = acc;
        this.targetAcc = targetAcc;
        this.speed = currentSpeed;
        if(!started){
            started = true;
            thr.start();
        }
    }
    
    @Override
    public void run(){
        while(true){
            speed += acc;
            if(speed < 0){
                speed = 0;
            }
            tm.updateDistance(acc);
            acc = tm.updateAcc(speed);
            tm.updateSpeed(speed);
            try {
                Thread.sleep(1000 / time.getSpeed());
            } catch (InterruptedException ex) {
                Logger.getLogger(TemperatureCalculator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
