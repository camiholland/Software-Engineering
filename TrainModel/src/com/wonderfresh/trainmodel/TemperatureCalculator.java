package com.wonderfresh.trainmodel;

import static java.lang.Math.ceil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cami
 */
public class TemperatureCalculator {
    int currentTime;
    TrainModel tm;
    
    public TemperatureCalculator(TrainModel TM){
        tm = TM;
    }
    
    public void setTemp(int currentTemp, int targetTemp){
        currentTime = (int) ceil(System.nanoTime()/1000000000);
        while(currentTemp != targetTemp){
            if(System.nanoTime()/1000000000 >= currentTime+1){
                if(currentTemp < targetTemp){
                    currentTemp++;
                    tm.adjustTemp(currentTemp, -1);
                }
                else{
                    currentTemp--;
                    tm.adjustTemp(currentTemp, 1);
                }
                currentTime++;
            }
        }
        tm.adjustTemp(currentTemp, 0);
    }
}
