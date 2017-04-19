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
    //boolean waiting;
    
    double speed;
    double targetAcc;
    double acc;
    
    public SpeedCalculator(TrainModel TM){
        tm = TM;
        thr = new Thread(this);
        started = false;
        time = time.getInstance();
        //waiting = true;
    }
    
    public void setSpeed(double acc, double currentSpeed, double targetAcc) {
        this.acc = acc;
        this.targetAcc = targetAcc;
        this.speed = currentSpeed;
        if(!started){
            //System.out.println("Thread started");
            started = true;
            thr.start();
        }
    }
    
    @Override
    public void run(){
        //System.out.println("running SpeedCalc");
        while(true){
            speed += acc;
            //System.out.println("acc = " + acc);
            if(speed < 0){
                speed = 0;
            }
            tm.updateDistance(acc);
            acc = tm.updateAcc(speed);
            tm.updateSpeed(speed);
            //currentTime++;
            try {
                Thread.sleep(1000 / time.getSpeed());
            } catch (InterruptedException ex) {
                Logger.getLogger(TemperatureCalculator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
