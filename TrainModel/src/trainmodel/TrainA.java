/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainmodel;

import java.util.ArrayList;

/**
 *
 * @author Cami
 */
public class TrainA {
    public ArrayList<TrainModel> train;
    public int count;
    
    public TrainA(){
        train = new ArrayList<TrainModel>();
        count = 0;
    }
    
    public int size(){
        return count;
    }
    
    public void addTrain(TrainModel train1){
        train.add(train1);
        count++;
    }
    
    public TrainModel getTrainModel(int trainID){
        TrainModel train1;
        int cid;
        
        for (int i = 0; i < count; i++){
            train1 = train.get(i);
            //cid = train1.getTrainId();
            
            if(cid == trainID){
                return train1;
            }
        }
        return null;
    }
    
}
