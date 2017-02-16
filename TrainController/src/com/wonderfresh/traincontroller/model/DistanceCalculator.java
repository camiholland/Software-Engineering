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
public class DistanceCalculator extends Thread {
    
    private TrainController train;
    private double velocity;
    private int dist;
    private int distInBlock;
    private int block;
    private boolean proceed;
    
    public DistanceCalculator(TrainController train) {
        this.train = train;
        velocity = 0.0;
        dist = 0;
        distInBlock = 0;
        block = 0;
        proceed = true;
    }
    
    public void stopRun() {
        proceed = false;
    }
    
    @SuppressWarnings("SleepWhileInLoop")
    @Override
    public void run() {
        
        while(proceed) {
            
            dist += (int)(1.60934 * train.getRealSpeed());
            
            //sleep for one second to get new speed
            try {
                sleep(1000);
            } catch (Exception ex) {
                //busy waiting // nothing is required
            }
        }
        
    }
    
}
