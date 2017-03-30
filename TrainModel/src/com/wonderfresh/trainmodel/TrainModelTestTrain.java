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
public class TrainModelTestTrain {
    
    public static ArrayList<TrainModelTest> trainList;
    public static int count;
    
    public TrainModelTestTrain(){
        trainList = new ArrayList<>();
        count = 0;
    }
    
    public int size(){
        return count;
    }
    
    public static void addTrain(TrainModelTest newTrain){
        trainList.add(newTrain);
        count++;
    }
    
    public static TrainModelTest getTrain(int trainID){
        TrainModelTest trainmodeltest;
        int checkID;
        
        for (int i = 0; i < count; i++){
            trainmodeltest = trainList.get(i);
            checkID = trainmodeltest.getID();
            
            if(checkID == trainID){
                return trainmodeltest;
            }
        }
        return null;
    }
    
}
