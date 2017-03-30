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
        Train.getTrain(trainID).setEBrake(status);
    }
    public void setServiceBrake(int status, int trainID){
        Train.getTrain(trainID).setServiceBrake(1, true);
    }
    public void setLeftDoors(int status, int trainID){
        Train.getTrain(trainID).setLeftDoors(status);
    }
    public void setRightDoors(int status, int trainID){
        Train.getTrain(trainID).setRightDoors(status);
    }
    public void setTargetTemperature(int temp, int trainID){
        Train.getTrain(trainID).setTargetTemp(temp);
    }
    public void setLights(int status, int trainID){
        Train.getTrain(trainID).setLights(status);
    }
    public void setPowerCommand(double pwrCmd, int trainID){
        Train.getTrain(trainID).setPowerCmd(pwrCmd);
    }
    public void setAnnouncement(String announcement, int trainID){
        Train.getTrain(trainID).setAnnouncement(announcement);
    }
}
