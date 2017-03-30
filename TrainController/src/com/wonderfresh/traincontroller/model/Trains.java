/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller.model;

import java.util.ArrayList;

/**
 *
 * @author Austin
 */
public class Trains {
    
    public ArrayList<TrainController> trains;
    public int count;
    
    public Trains() {
        trains = new ArrayList<>();
        count = 0;
    }
    
    public int size() {
        return count;
    }
    
    public void addTrainController(TrainController train) {
        trains.add(train);
        count++;
    }
    
    public TrainController getTrainController(int id) {
        TrainController train;
        int cid;
        
        for (int i = 0; i < count; i++) {
            train = trains.get(i);
            cid = train.getTrainId();
            
            if (cid == id) {
                return train;
            }
        }
        
        return null;
    }
    
}
