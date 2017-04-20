package com.wonderfresh.trainmodel;

import static java.lang.Math.ceil;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cami
 */
public class TemperatureCalculator implements Runnable {
    int currentTime;
    TrainModel tm;
    
    Thread thr;
    boolean started;
    
    int currentTemp;
    int targetTemp;
    
    public TemperatureCalculator(TrainModel TM){
        tm = TM;
        thr = new Thread(this);
        started = false;
    }
    
    public void setTemp(int currentTemp, int targetTemp) {
        this.currentTemp = currentTemp;
        this.targetTemp = targetTemp;
        if(!started){
            started = true;
            thr.start();
        }
    }
    
    @Override
    public void run(){
        while(true){
            if(currentTemp != targetTemp){
                currentTime = (int) ceil(System.nanoTime()/1000000000);
                while(currentTemp != targetTemp){
                    if(System.nanoTime()/1000000000 >= currentTime+1){
                        if(currentTemp < targetTemp){
                            currentTemp++;
                            tm.updateTemp(currentTemp, -1);
                        }
                        else{
                            currentTemp--;
                            tm.updateTemp(currentTemp, 1);
                        }
                        currentTime++;
                    }
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TemperatureCalculator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                tm.updateTemp(currentTemp, 0);
            }
            try {
                Thread.sleep(800);
            } catch (InterruptedException ex) {
                Logger.getLogger(TemperatureCalculator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
