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

public class TrainModelTest {
    TrainToTrainController trainToTC;
    TrainModelTestUI gui;
    TrainModel tm;
    
    int ID;
    
    private double speed = 0;
    private int sps = 0;
    private int speedLimit = 0;
    private int authority = 0;
    private int temperature = 0;
    private int numPassWaiting = 0;
    private String beacon = null;
    private double powerCmd = 0;
    
    int acStatus;
    int heatStatus;
    int lightsStatus;
    int leftDoorsStatus;
    int rightDoorsStatus;
    int serviceBrakeStatus;
    boolean eBrake;
    
    public TrainModelTest(TrainModel TM){
        gui = new TrainModelTestUI(this);
        trainToTC = new TrainToTrainControllerImpl(TM);
        tm = TM;
        gui.setVisible(true);
        
        ID = tm.getID();
        
        acStatus = 0;
        heatStatus = 0;
        lightsStatus = 0;
        leftDoorsStatus = 0;
        rightDoorsStatus = 0;
        serviceBrakeStatus = 0;
        eBrake = false;
        
        TrainModelTestTrain.addTrain(this);
        
        
        /*while(true){
            
            acStatus = trainToTC.getAC(1);
            heatStatus = trainToTC.getHeat(1);
            lightsStatus = trainToTC.getLights(1);
            leftDoorsStatus = trainToTC.getLeftDoors(1);
            rightDoorsStatus = trainToTC.getRightDoors(1);
            serviceBrakeStatus = trainToTC.getServiceBrake(1);
            
            
        }*/
        
        //acting train controller:
        //final TrainToTrainController testingTC = new TrainToTrainControllerImpl();
        //acting track model:
        //final TrainToTrack testingTrack = new TrainToTrackImpl();
    }
    public int getID(){
        return ID;
    }
    
    
    
    protected void setSpeedAndAuthority(int speed, int auth){
        sps = speed;
        authority = auth;
    }
    protected void setSpeedLimit(int limit){
        speedLimit = limit;
    }
    protected void setRealSpeed(double speed){
        this.speed = speed;
    }
    protected void setCurrentTemp(int temperature){
        this.temperature = temperature;
        trainToTC.setTargetTemperature(temperature, ID);
    }
    protected void setDoorsLeft(int status){
        leftDoorsStatus = status;
        trainToTC.setLeftDoors(status, ID);
        if(status > 0){
            gui.on(4);
        }
        else if(status == 0){
            gui.off(4);
        }
        else{
            gui.fail(4);
        }
    }
    protected void setDoorsRight(int status){
        rightDoorsStatus = status;
        trainToTC.setRightDoors(status, ID);
        if(status > 0){
            gui.on(5);
        }
        else if(status == 0){
            gui.off(5);
        }
        else{
            gui.fail(5);
        }
    }
    protected void setLights(int status){
        lightsStatus = status;
        trainToTC.setLights(status, ID);
        if(status > 0){
            gui.on(3);
        }
        else if(status == 0){
            gui.off(3);
        }
        else{
            gui.fail(3);
        }
    }
    protected void setAC(int status){
        acStatus = status;
        if(status > 0){
            gui.on(1);
        }
        else if(status == 0){
            gui.off(1);
        }
        else{
            gui.fail(1);
        }
    }
    protected void setHeat(int status){
        heatStatus = status;
        if(status > 0){
            gui.on(2);
        }
        else if(status == 0){
            gui.off(2);
        }
        else{
            gui.fail(2);
        }
    }
    protected void engageEmergencyBrake(){
        eBrake = true;
        trainToTC.setEBrake(eBrake, ID);
    }
    
    protected void setEBrake(boolean status){
        if(status)
            engageEmergencyBrake();
        else{
            eBrake = false;
            trainToTC.setEBrake(eBrake, ID);
        }
    }
    protected void setPowerCmd(String cmd){
        double pwrCmd = Double.parseDouble(cmd);
        trainToTC.setPowerCommand(pwrCmd, ID);
        powerCmd = pwrCmd;
    }
    protected void setServiceBrake(int status){
        trainToTC.setServiceBrake(status, ID);
        serviceBrakeStatus = status;
    }
}
