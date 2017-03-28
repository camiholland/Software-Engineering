/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trainmodel;

import static java.lang.Math.cos;
import static java.lang.Math.sin;


/**
 *
 * @author Cami
 */
public class TrainModel {
    TrainModelUI gui;
    Testing testing;
    
    int ID;
    
    double currentSpeedTime;
    double previousSpeedTime;
    double currentTempTime;
    double previousTempTime;
    
    final int MAX_POWER = 120000; //watts
    final double CAR_MASS_TON = 40.9; //tonnes (metric ton = 1000kg = 2204.62lbs)
    final int PASS_WEIGHT = 75; //kg                                            //... or 70???
    final int CAR_MASS = 40900; //kg
    final double FRICTION = 1;                                                  //<-- that ain't right!
    final int T = 1;
    final double MAX_ACC = .5; //m/s2
    final double S_BRAKE_RATE = 1.2; //m/s2
    final double E_BRAKE_RATE = 2.73; //m/s2
    final double DEFAULT_TEMP = 75;
    
    int numCars;
    int numPass;
    int numCrew;
    
    double speed;
    double totalMass;
    double acc;
    double netForceUphillDecel;
    double netForceUphillAccel;
    double netForceDownhillDecel;
    double netForceDownhillAccel;
    double error;
    double previousError;
    double grade;
    double sps;
    double speedLimit;
    double powerCmd;
    
    int acStatus;
    int heatStatus;
    int lightsStatus;
    int leftDoorsStatus;
    int rightDoorsStatus;
    int serviceBrakesStatus;
    
    String beacon;
    String previousBeacon;
    
    double currentTemp;
    double targetTemp;
    boolean eBrake;
    int authority;
    String announcement;
    
    public TrainModel(int trainID){
        gui = new TrainModelUI(this);
        gui.setVisible(true);
        testing = new TestingImpl(this);
        
        currentSpeedTime = 0;
        previousSpeedTime = 0;
        
        numCars = 1;
        numPass = 0;
        numCrew = 1;
        
        speed = 0;
        totalMass = CAR_MASS*numCars + PASS_WEIGHT*(numPass + numCrew);
        acc = 0;
        netForceUphillDecel = 0;
        netForceUphillAccel = 0;
        netForceDownhillDecel = 0;
        netForceDownhillAccel = 0;
        error = 0;
        previousError = 0;
        grade = 0;
        sps = 0;
        speedLimit = 0;
        powerCmd = 0;
        
        acStatus = 0;
        heatStatus = 0;
        lightsStatus = 0;
        leftDoorsStatus = 0;
        rightDoorsStatus = 0;
        serviceBrakesStatus = 0;
        
        beacon = null;
        previousBeacon = null;
        
        currentTemp = DEFAULT_TEMP; //degrees F
        targetTemp = DEFAULT_TEMP;
        eBrake = false;
        authority = 0;
        announcement = null;
        
        /*while(true){
            
            
            sps = testing.getSetPointSpeed();
            
            powerCmd = testing.getPowerCommand();
            setSpeed(powerCmd);
            setTemp(targetTemp);
            beacon = testing.getBeaconInfo(1);
            
            updateAll(Double.toString(speed), Double.toString(sps), Double.toString(speedLimit), Double.toString(powerCmd));
        }*/
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
    }
    
    public int getID(){
        return ID;
    }
    
    public void setEBrake(int trainID, boolean status){
        TrainModel train = TrainA.getTrain(trainID);
        train.eBrake = status;
        
    }
    public void setServiceBrake(int trainID, int status){
        TrainModel train = TrainA.getTrain(trainID);
        train.serviceBrakesStatus = status;
    }
    public void setLeftDoors(int trainID, int status){
        TrainModel train = TrainA.getTrain(trainID);
        train.leftDoorsStatus = status;
    }
    public void setRightDoors(int trainID, int status){
        TrainModel train = TrainA.getTrain(trainID);
        train.rightDoorsStatus = status;
    }
    public void setTemperature(int trainID, int status){
        TrainModel train = TrainA.getTrain(trainID);
        train.targetTemp = status;
    }
    public void setLights(int trainID, int status){
        TrainModel train = TrainA.getTrain(trainID);
        train.lightsStatus = status;
    }
    public void setPowerCommand(int trainID, double pwrCmd){
        TrainModel train = TrainA.getTrain(trainID);
        train.powerCmd = pwrCmd;
    }
    public void setAnnouncement(int trainID, String announcement){
        TrainModel train = TrainA.getTrain(trainID);
        train.announcement = announcement;
    }
    
    private void updateAll(String speed, String sps, String speedLimit, String powerCmd){
        gui.setSpeed(speed);
        gui.setSPS(sps);
        gui.setPowerCmd(powerCmd);
        if(beacon != null){
            if(previousBeacon != null){
                if(!beacon.equals(previousBeacon))
                    gui.setNotification(beacon);
            }
            else
                gui.setNotification(beacon);
            previousBeacon = beacon;
        }
    }
    
    protected double getSpeed(){
        return speed;
    }
    protected void setSpeed(double power){
        totalMass = CAR_MASS * numCars + PASS_WEIGHT * (numPass + numCrew);
        //error = sps - speed;
        //netForceUphillDecel = totalMass * acc + totalMass * 9.8 * sin(grade) + FRICTION * totalMass * 9.8 * cos(grade);
        //netForceUphillAccel = totalMass * acc - totalMass * 9.8 * sin(grade) - FRICTION * totalMass * 9.8 * cos(grade);
        //netForceDownhillDecel = totalMass * acc - totalMass * 9.8 * sin(grade) + FRICTION * totalMass * 9.8 * cos(grade);
        //netForceDownhillAccel = totalMass * acc + totalMass * 9.8 * sin(grade) - FRICTION * totalMass * 9.8 * cos(grade);
        
        currentSpeedTime = System.nanoTime()/1000000000;
        if(currentSpeedTime - previousSpeedTime >= 1){
            if(power <= MAX_POWER){
                acc = power / (totalMass * sps);
                speed += acc;
                //speed += T/2 * (error + previousError);
                //previousError = error;
            }
            previousSpeedTime = currentSpeedTime;
        }
        
    }
    protected double getSPS(){
        return sps;
    }
    protected double getTemp(){
        return currentTemp;
    }
    protected void setTemp(double setTemp){
        currentTempTime = System.nanoTime()/1000000000;
        if(currentTempTime - previousTempTime >= 1){
            if(setTemp < currentTemp){
                currentTemp -= (currentTemp - setTemp)/5;
            }
            else if(setTemp > currentTemp){
                currentTemp += (setTemp - currentTemp)/5;
            }
            previousTempTime = currentTempTime;
        }
    }
    protected String getBeacon(){
        return beacon;
    }
    protected int getAuthority(){
        return authority;
    }
    protected boolean getEBrake(){
        return eBrake;
    }
    protected void setEBrake(boolean a){
        eBrake = a;
    }
    protected int getNumPass(){
        return numPass;
    }
    
    protected int getAC(){
        return acStatus;
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
    protected int getHeat(){
        return heatStatus;
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
    protected int getLights(){
        return lightsStatus;
    }
    protected void setLights(int status){
        lightsStatus = status;
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
    protected int getLeftDoors(){
        return leftDoorsStatus;
    }
    protected void setLeftDoors(int status){
        leftDoorsStatus = status;
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
    protected int getRightDoors(){
        return rightDoorsStatus;
    }
    protected void setRightDoors(int status){
        rightDoorsStatus = status;
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
    protected int getServiceBrake(){
        return serviceBrakesStatus;
    }
    protected void setServiceBrake(int status){
        serviceBrakesStatus = status;
        if(status > 0){
            gui.on(6);
        }
        else if(status == 0){
            gui.off(6);
        }
        else{
            gui.fail(6);
        }
    }
    
}
