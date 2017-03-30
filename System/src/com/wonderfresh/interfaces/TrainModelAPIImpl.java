/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.interfaces;


import com.wonderfresh.trainmodel.Train;

/**
 *
 * @author Cami
 */

public class TrainModelAPIImpl implements TrainModelAPI {
    Train trains;
    public TrainModelAPIImpl(Train trains){
        this.trains = trains;
    }
    
    //communications received by Train Controller
    @Override
    public void setEBrake(boolean status, int trainID){
        trains.getTrain(trainID).setEBrake(status);
    }
    @Override
    public void setServiceBrake(int status, int trainID){
        trains.getTrain(trainID).setServiceBrake(1, true);
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
        trains.getTrain(trainID).setTargetTemp(temp);
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
}
