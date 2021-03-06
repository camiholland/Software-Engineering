/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trainmodel;

/**
 *
 * @author Cami
 */
public interface TrainModelAPI {
    //generic methods that both Train Controller and Track Model receive
}

interface TrainToTrainController extends TrainModelAPI{
    //communications received by Train Controller
    public void setEBrake(boolean status, int trainID);
    public void setServiceBrake(int status, int trainID);
    public void setLeftDoors(int status, int trainID);
    public void setRightDoors(int status, int trainID);
    public void setTargetTemperature(int status, int trainID);
    public void setLights(int status, int trainID);
    public void setPowerCommand(double pwrCmd, int trainID);
    public void setAnnouncement(String announcement, int trainID);

    
    public void addTrain(int trainID, String line);
}

interface Testing extends TrainModelAPI{
    //testing for communications received by Train Model
    //from Track Model
    
    //public Block getNextBlock(Block currentBlock, Block previousBlock);
    
    //to Train Controller
    /*public void setSpeedAndAuth(int speed, int authority, int trainID);
    public void setSpeedLimit(int limit, int trainID);
    public void setSpeed(double speed, int trainID);
    public void setTemperature(int temperature, int trainID);
    public void setRightDoors(int status, int trainID);
    public void setLeftDoors(int status, int trainID);
    public void setLights(int status, int trainID);
    public void setAirConditioning(int status, int trainID);
    public void setHeating(int status, int trainID);
    public void failPower(int trainID);
    public void failBrake(int trainID);
    public void emergencyBrake(int trainID);
    public void sendBeaconInfo(boolean doors, int distance, String station, int trainID);*/
    
    //to antenna
    //public void setSpeedAndAuth(double speed, int authority);
    //public void setBeaconInfo(String info);
}