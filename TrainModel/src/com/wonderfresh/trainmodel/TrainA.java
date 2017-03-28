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
public class TrainA {
    public static ArrayList<TrainModel> trainList;
    public static int count;
    
    public TrainA(){
        trainList = new ArrayList<>();
        count = 0;
    }
    
    public int size(){
        return count;
    }
    
    public void addTrain(TrainModel train1){
        trainList.add(train1);
        count++;
    }
    
    public static TrainModel getTrain(int trainID){
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
