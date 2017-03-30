/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller.model;

import com.wonderfresh.traincontroller.TrainControllerUI;
import com.wonderfresh.interfaces.TrainModelAPI;
import com.wonderfresh.interfaces.Interfaces;

/**
 *
 * @author Austin
 */
public class TrainController {

    public TrainController(int trainID, int routeID) {
        this.trainID = trainID;
        this.routeID = routeID;
        this.trainModel = Interfaces.getTrainModelInterface();
        auto = true;
        setPointSpeed = 0;
        setAuthority = 0;
        setSpeed = 0;
        realSpeed = 0;
        speedLimit = 25;
        powerCommand = 0;
        lights = 0;
        doorsLeft = 0;
        doorsRight = 0;
        airConditioning = 0;
        heating = 0;
        tempSet = 70;
        tempCurrent = 70;
        brakeService = false;
        brakeEmergency = false;
        gainProportional = 30000;
        gainIntegral = 100;
    
        pc = new PowerCalculator(this, gainProportional, gainIntegral);
        dc = new DistanceCalculator(this);

        pc.start();
        dc.start();
    }    

    public TrainModelAPI trainModel;
    public DistanceCalculator dc;
    public PowerCalculator pc;
    public TrainControllerUI trainUI;
    public boolean openUI = false;

    public int trainID;
    public int routeID;
    public boolean auto;
    public int setPointSpeed;
    public int setAuthority;
    public int setSpeed;
    public double realSpeed;
    public int speedLimit;
    public double powerCommand;
    public int lights;
    public int doorsLeft;
    public int doorsRight;
    public int airConditioning;
    public int heating;
    public int tempSet;
    public int tempCurrent;
    public boolean brakeService;
    public boolean brakeEmergency;
    public double gainProportional;
    public double gainIntegral;
  
    public int launchUI() {
        /* Create and display the form */
        trainUI = new TrainControllerUI(this, trainModel);

        java.awt.EventQueue.invokeLater(() -> {
            trainUI.setVisible(true);
        });

        openUI = true;

        trainUI.setTrainID(trainID);
        trainUI.setRouteID(routeID);
        trainUI.setCurrentTemp(tempCurrent);
        trainUI.setSetTemp(tempSet);
        trainUI.setAC(airConditioning);
        trainUI.setHeat(heating);
        trainUI.setLights(lights);
        trainUI.setLeftDoors(doorsLeft);
        trainUI.setRightDoors(doorsRight);
        trainUI.setGainValues(gainProportional, gainIntegral);
        trainUI.setSpeed(realSpeed);
        trainUI.setSetSpeed(setSpeed);
        trainUI.setPower(powerCommand);
        trainUI.setSpeedLimit(speedLimit);
        
        if(brakeEmergency){
            trainUI.emergencyBrakeEngaged();
        }

        return 1;
    }
  
    public int getTrainId() { 
        return trainID; 
    }

    public int getRouteId() { 
        return routeID; 
    }
    public void setRouteID(int id) {
        routeID = id;

        if(trainUI != null){
            trainUI.setRouteID(id);
        }
    }

    public boolean getAuto() {
        return auto;
    }
    public void setAuto(boolean mode) {
        auto = mode;
        if(trainUI !=  null){
            trainUI.setAuto(mode);
        }
    }

    public void setSpeedAndAuthority(int speed, int authority){
        setPointSpeed = speed;
        setAuthority = authority;
    }

    public int getSetPointSpeed() { 
        return setPointSpeed; 
    }
    public int getAuthority() {
        return setAuthority;
    }

    public int getSetSpeed() {
        return setSpeed;
    }
    public void setSetSpeed(int speed) {

        setSpeed = speed;

        if (setSpeed == 0) {
          pc.stopTemp();
        } else {
          pc.startTemp();
        }

        if(trainUI != null) {
            trainUI.setSetSpeed(speed);
        }
    }

    public double getRealSpeed() {
        return realSpeed;
    }
    public void setRealSpeed(double speed) {
        realSpeed = speed;

        if(trainUI != null) {
            trainUI.setSpeed(speed);
        }
        
    }

    public int getSpeedLimit() {
        return speedLimit;
    }
    public void setSpeedLimit(int limit) {
        speedLimit = limit;

        if (limit < setSpeed) {
          setSetSpeed(limit);
        }

        if(trainUI != null) {
            trainUI.setSpeedLimit(limit);
        }
    }

    public double getPowerCommand() {
        return powerCommand;
    }
    public void setPowerCommand(double power) {
        powerCommand = power;
        
        trainModel.setPowerCommand(power, trainID);

        if (brakeEmergency) {
            if (realSpeed < 6.11) {
                setRealSpeed(0);
            } else {
                setRealSpeed(realSpeed - 6.11);
            }
        } else if (setSpeed == 0) {
            if (realSpeed < 2.68) {
                setRealSpeed(0);
            } else {
                setRealSpeed(realSpeed - 2.68);
            }
        } else if (realSpeed < setSpeed) {
            setRealSpeed(realSpeed+2);
        } else if (realSpeed > setSpeed) {
            setRealSpeed(realSpeed - 1);
        }

        if(trainUI != null) {
            trainUI.setPower(power);
        }
    }

    public void setGainValues(double gainProportional, double gainIntegral) {
        pc.setGainValues(gainProportional, gainIntegral);
        this.gainProportional = gainProportional;
        this.gainIntegral = gainIntegral;

        System.out.println("kp = " + this.gainProportional + "\nki = " + this.gainIntegral);
    }

    public double getGainProportional() { 
        return gainProportional; 
    }

    public double getGainIntegral() { 
        return gainIntegral; 
    }

    public int getAC() {
        return airConditioning;
    }
    public void setAC(int status) {
        airConditioning = status;

        if(trainUI != null) {
            trainUI.setAC(status);          
        }
 
    }

    public int getHeat() {
        return heating;
    }
    public void setHeat(int status) {
        heating = status;

        if(trainUI != null){
            trainUI.setHeat(status); 
        }
        
    }

    public int getSetTemp() { 
        return tempSet; 
    }
    public void setSetTemp(int temp) { 
        tempSet = temp;

        if (tempCurrent > (2 + tempSet)) {
            setAC(1);
            setHeat(0);
        } else if (tempCurrent < (tempSet - 2)) {
            setAC(0);
            setHeat(1);
        } else {
            setAC(0);
            setHeat(0);
        }

        trainModel.setTargetTemperature(temp,trainID);
    }

    public void setCurrentTemp(int temp) {
        tempCurrent = temp;
    }

    public int getDoorsLeft() {
        return doorsLeft;
    }
    public void setDoorsLeft(int status) {
        doorsLeft = status;

        trainModel.setLeftDoors(status, trainID);

        if(trainUI != null) {
            trainUI.setLeftDoors(status);         
        }
    }

    public int getDoorsRight() {
        return doorsRight;
    }
    public void setDoorsRight(int status) {
        doorsRight = status;

        trainModel.setRightDoors(status, trainID);

        if(trainUI != null) {
            trainUI.setRightDoors(status);         
        }
    }

    public int getLights() {
        return lights;
    }
    public void setLights(int status) {
        lights = status;
        trainModel.setLights(status, trainID);
    }

    public boolean engageEmergencyBrake() {
        brakeEmergency = !brakeEmergency;

        if(brakeEmergency){
            pc.stopTemp();
        } else {
            pc.startTemp();
        }

        trainModel.setEBrake(brakeEmergency, trainID);

        return brakeEmergency;
    }

}
