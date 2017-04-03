/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.mbo;

/**
 * @author angie
 */
public interface MboInterface {
    com.wonderfresh.commons.mboTrain[] setDispatchedTrain(int trainID, double speed, double authority,com.wonderfresh.commons.mboTrain[] array);
    com.wonderfresh.commons.mboTrain[] setUpdatedSpeedAuthority(int trainID, double speed, double authority, com.wonderfresh.commons.mboTrain[] array);
    com.wonderfresh.commons.mboTrainDepartInfo[] setTrainDepartInfo(String station,String trainIDandDepartTime,com.wonderfresh.commons.mboTrainDepartInfo[] info);
    com.wonderfresh.commons.mboTrain[] getDispatchedTrain();
    com.wonderfresh.commons.mboTrain[] getUpdatedSpeedAuthority();
    com.wonderfresh.commons.mboTrainDepartInfo[] getTrainDepartInfo();
}

