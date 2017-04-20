/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trainmodel;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cami
 */

public class TrainToTrainControllerImpl implements TrainToTrainController {
    Train trains;
    public TrainToTrainControllerImpl(Train trains){
        this.trains = trains;
    }
    
    //communications received by Train Controller
    @Override
    public void setEBrake(boolean status, int trainID){
        trains.getTrain(trainID).setEBrake(status);
    }
    @Override
    public void setServiceBrake(int status, int trainID){
        trains.getTrain(trainID).setServiceBrake(status, true);
    }
    @Override
    public void setLeftDoors(int status, int trainID){
        trains.getTrain(trainID).setLeftDoors(status);
    }
    @Override
    public void setRightDoors(int status, int trainID){
        trains.getTrain(trainID).setRightDoors(status);
    }
    @Override
    public void setTargetTemperature(int temp, int trainID){
        try {
            trains.getTrain(trainID).setTargetTemp(temp);
        } catch (InterruptedException ex) {
            Logger.getLogger(TrainToTrainControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void setLights(int status, int trainID){
        trains.getTrain(trainID).setLights(status);
    }
    @Override
    public void setPowerCommand(double pwrCmd, int trainID){
        trains.getTrain(trainID).setPowerCmd(pwrCmd);
    }
    @Override
    public void setAnnouncement(String announcement, int trainID){
        trains.getTrain(trainID).setAnnouncement(announcement);
    }
    
    //not from trian controller
    @Override
    public void addTrain(int trainID, String line){
        trains.addTrain(trainID, line);
    }
}
