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
        trains = new ArrayList<TrainController>();
        count = 0;
    }
    
    public int size() {
        return count;
    }
    
    public void addTrainController(TrainController train) {
        trains.add(train);
        count++;
    }
    
    public int getTrainControllerIndex(int id) {
        TrainController train;
        
        for (int i = 0; i < count; i++) {
            train = trains.get(i);
            
            if (train.getTrainId() == id) {
                return i;
            }
        }
        
        return -1;
    }
    
    public TrainController getTrainController(int index) {
        return trains.get(index);
    }
    
}
