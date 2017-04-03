/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.interfaces;
import com.wonderfresh.commons.mboTrain;
import com.wonderfresh.commons.mboTrainDepartInfo;

/**
 *
 * @author angie
 */
public class MboInterfaceImpl implements MboInterface {

/**
 *
 * @author angie
 */

    mboTrain[] array;
    mboTrainDepartInfo[] info;
    
    
    @Override
    public mboTrain[] setLocation(int blockNum, int metersIn,int ID){
        array[ID].block=blockNum;
        array[ID].metersInBlock=metersIn;
        return array;
    }
    public mboTrain[] getLocation(mboTrain[] array){
        return array;
    }
    
    
    @Override
    public mboTrain[] setDispatchedTrain(int trainID, double speed, double authority,mboTrain[] array){
        array[trainID].speed=speed;
        array[trainID].authority=authority;
        return array;
    }
    @Override
    public mboTrain[] setUpdatedSpeedAuthority(int trainID, double speed, double authority, mboTrain[] array){
        
        return array;
    }
    @Override
    public mboTrainDepartInfo[] setTrainDepartInfo(String station,String trainIDandDepartTime,mboTrainDepartInfo[] info){
        
        return info;
    }
    @Override
    public mboTrain[] getDispatchedTrain(){
        
        return array;
    }
    @Override
    public mboTrain[] getUpdatedSpeedAuthority(){
        return array;
    }
    @Override
    public mboTrainDepartInfo[] getTrainDepartInfo(){
        return info;
    }

 
}


