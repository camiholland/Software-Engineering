/*
 * 
 */
package com.wonderfresh.interfaces;

import com.wonderfresh.commons.mboTrain;
import com.wonderfresh.commons.mboTrainDepartInfo;

/**
 *
 * @author angie
 */
public class TestMbo implements MboInterface {
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

    @Override
    public mboTrain[] setLocation(int block, int metersInBlock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public mboTrain[] getLocation(int trainID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

