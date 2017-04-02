/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo;

/**
 *
 * @author angie
 */
public class mboInterfaceClass implements MboInterface{
    
    com.wonderfresh.commons.mboTrain[] array;
    com.wonderfresh.commons.mboTrainDepartInfo[] info;
    
    @Override
    public com.wonderfresh.commons.mboTrain[] setDispatchedTrain(int trainID, double speed, double authority,com.wonderfresh.commons.mboTrain[] array){
        array[trainID].speed=speed;
        array[trainID].authority=authority;
        return array;
    }
    @Override
    public com.wonderfresh.commons.mboTrain[] setUpdatedSpeedAuthority(int trainID, double speed, double authority, com.wonderfresh.commons.mboTrain[] array){
        
        return array;
    }
    @Override
    public com.wonderfresh.commons.mboTrainDepartInfo[] setTrainDepartInfo(String station,String trainIDandDepartTime,com.wonderfresh.commons.mboTrainDepartInfo[] info){
        
        return info;
    }
    @Override
    public com.wonderfresh.commons.mboTrain[] getDispatchedTrain(){
        
        return array;
    }
    @Override
    public com.wonderfresh.commons.mboTrain[] getUpdatedSpeedAuthority(){
        return array;
    }
    @Override
    public com.wonderfresh.commons.mboTrainDepartInfo[] getTrainDepartInfo(){
        return info;
    }
    

}

