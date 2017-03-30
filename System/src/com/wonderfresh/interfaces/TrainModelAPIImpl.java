/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.interfaces;

import com.wonderfresh.interfaces.TrainModelAPI;
import com.wonderfresh.trainmodel.Train;
import com.wonderfresh.trainmodel.TrainModel;

/**
 *
 * @author Cami
 */

public class TrainModelAPIImpl implements TrainModelAPI {
    TrainModel trainModel;
    public TrainModelAPIImpl(TrainModel TM){
        trainModel = TM;
    }
    
    //communications received by Train Controller
    public void setEBrake(boolean status, int trainID){
        Train.getTrain(trainID).eBrake = status;
    }
    public void setServiceBrake(int status, int trainID){
        TrainModel train = Train.getTrain(trainID);
        train.setServiceBrake(1);
        if(status == 1)
            train.driverSetBrake = true;
        else
            train.driverSetBrake = false;
    }
    public void setLeftDoors(int status, int trainID){
        TrainModel train = Train.getTrain(trainID);
        train.leftDoorsStatus = status;
        if(status > 0){
            train.gui.on(4);
        }
        else if(status == 0){
            train.gui.off(4);
        }
        else{
            train.gui.fail(4);
            train.testing.failPower(trainID);
        }
    }
    public void setRightDoors(int status, int trainID){
        TrainModel train = Train.getTrain(trainID);
        train.rightDoorsStatus = status;
        if(status > 0){
            train.gui.on(5);
        }
        else if(status == 0){
            train.gui.off(5);
        }
        else{
            train.gui.fail(5);
            train.testing.failPower(trainID);
        }
    }
    public void setTargetTemperature(int status, int trainID){
        TrainModel train = Train.getTrain(trainID);
        train.targetTemp = status;
//        if(targetTemp != currentTemp)
//            train.adjustTemp(); every second                                  FIX THIS and maybe do the same thing with speed so I don't have to deal with threads
        
    }
    public void setLights(int status, int trainID){
        TrainModel train = Train.getTrain(trainID);
        train.lightsStatus = status;
        if(status > 0){
            train.gui.on(3);
        }
        else if(status == 0){
            train.gui.off(3);
        }
        else{
            train.gui.fail(3);
            train.testing.failPower(trainID);
        }
    }
    public void setPowerCommand(double pwrCmd, int trainID){
        Train.getTrain(trainID).powerCmd = pwrCmd;
    }
    public void setAnnouncement(String announcement, int trainID){
        Train.getTrain(trainID).announcement = announcement;
    }
}
