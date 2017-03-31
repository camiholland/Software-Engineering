/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trainmodel;

import java.util.ArrayList;

/**
 *
 * @author Cami
 */
public class Train {
    
    public ArrayList<TrainModel> trainList;
    public int count;
    
    public Train(){
        trainList = new ArrayList<>();
        count = 0;
    }
    
    public int size(){
        return count;
    }
    
    public void addTrain(TrainModel newTrain){
        trainList.add(newTrain);
        count++;
    }
    
    public TrainModel getTrain(int trainID){
        TrainModel trainmodel;
        int checkID;
        
        for (int i = 0; i < count; i++){
            trainmodel = trainList.get(i);
            checkID = trainmodel.getID();
            
            if(checkID == trainID){
                return trainmodel;
            }
        }
        return null;
    }
    
}
