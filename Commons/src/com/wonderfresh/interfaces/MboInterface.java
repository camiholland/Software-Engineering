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
public interface MboInterface {
    mboTrain[] setDispatchedTrain(int trainID, double speed, double authority,mboTrain[] array);
    mboTrain[] setUpdatedSpeedAuthority(int trainID, double speed, double authority, mboTrain[] array);
    mboTrain[] setLocation(int blockNum, int metersIn,int ID);
    mboTrain[] getLocation(mboTrain[] array);
    mboTrainDepartInfo[] setTrainDepartInfo(String station,String trainIDandDepartTime,mboTrainDepartInfo[] info);
    mboTrain[] getDispatchedTrain();
    mboTrain[] getUpdatedSpeedAuthority();
    mboTrainDepartInfo[] getTrainDepartInfo();
}
