/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo;

/**
 * @author angie
 */
public interface MboInterface {
    mboTrain[] setDispatchedTrain(int trainID, double speed, double authority);
    mboTrain[] setUpdatedSpeedAuthority(int trainID, double speed, double authority);
    //change to String Station and String for trainID and time
    mboTrainDepartInfo[] setTrainDepartInfo(String station,String trainIDandDepartTime);
    mboTrain[] getDispatchedTrain(int trainID, double speed, double authority);
    mboTrain[] getUpdatedSpeedAuthority(int trainID, double speed, double authority);
    mboTrainDepartInfo[] getTrainDepartInfo(String line);
}
