/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trainmodel;

import static java.lang.Math.ceil;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cami
 */
public class SpeedCalculator implements Runnable {
    int currentTime;
    TrainModel tm;
    
    Thread thr;
    boolean started;
    //boolean waiting;
    
    double speed;
    double sps;
    double acc;
    
    public SpeedCalculator(TrainModel TM){
        tm = TM;
        thr = new Thread(this);
        started = false;
        //waiting = true;
    }
    
    public void setSpeed(double acc, double currentSpeed, double sps) {
        this.acc = acc;
        this.speed = currentSpeed;
        this.sps = sps;
        if(!started){
            System.out.println("Thread started");
            started = true;
            thr.start();
        }
    }
    
    @Override
    public void run(){
        System.out.println("running SpeedCalc");
        while(true){
            System.out.println("running...");                                   //WTH this loop works when this line exists but not when it doesn't
            if((int)speed != (int)sps){
                currentTime = (int) ceil(System.nanoTime()/1000000000);
                while((int)speed > (int)sps && acc < 0){
                    if(System.nanoTime()/1000000000 >= currentTime+1){
                        //System.out.println("speed > sps");
                        //System.out.println("SPS: " + sps + "  Speed: " + speed);
                        //v = v0 + at, where t = 1
                        speed += acc;
                        System.out.println("acc = " + acc);
                        if(speed < 0){
                            speed = 0;
                        }
                        tm.updateSpeed(speed);
                        currentTime++;
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(TemperatureCalculator.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
                while((int)speed < (int)sps && acc > 0){
                    if(System.nanoTime()/1000000000 >= currentTime + 1){
                        //System.out.println("speed < sps");
                        //System.out.println("SPS: " + sps + "  Speed: " + speed);
                        speed += acc;
                        System.out.println("acc = " + acc);
                        if(speed < 0)
                            speed = 0;
                        acc = tm.updateAcc(speed);
                        tm.updateSpeed(speed);
                        
                        currentTime++;
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(TemperatureCalculator.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
                tm.updateSpeed(speed);
                //waiting = true;
            }
            /*waiting = true;
            while(waiting){
                try {
                    thr.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TemperatureCalculator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
        }
    }
}
