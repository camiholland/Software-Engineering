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
        trainUI = new TrainControllerUI(this, trainModel);
        auto = true;
        setPointSpeed = 10;
        setAuthority = 0.3;
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
        timeAtStation = 0;
    
        pc = new PowerCalculators(this, gainProportional, gainIntegral);
        dc = new DistanceCalculator(this);

        pc.start();
        dc.start();
    }    

    public TrainModelAPI trainModel;
    public DistanceCalculator dc;
    public PowerCalculators pc;
    public TrainControllerUI trainUI;
    public boolean openUI = false;

    public int trainID;
    public int routeID;
    public boolean auto;
    public int setPointSpeed;
    public double setAuthority;
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
    public boolean approachingStation;
    public String station;
    public int timeAtStation;
    public int distanceToStation;
    public int stationDoors;
    public boolean brakeService;
    public boolean brakeEmergency;
    public double gainProportional;
    public double gainIntegral;
    public double distance;
  
    public int launchUI() {
        /* Create and display the form */
        

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
        trainUI.setAuthority(setAuthority);
        trainUI.setSetPointSpeed(setPointSpeed);
        
        
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

    public void setSpeedAndAuthority(int speed, double authority){
        setPointSpeed = speed;
        setAuthority = authority;
        
        trainUI.setSetPointSpeed(speed);
        trainUI.setAuthority(authority);
        
        if(auto) {
            setSetSpeed(speed);
        }
    }
    


    public int getSetPointSpeed() { 
        return setPointSpeed; 
    }
    public double getAuthority() {
        return setAuthority;
    }
    public void setAuthority(int authority) {
        setAuthority = authority;
        
        trainUI.setAuthority(authority);
    }

    public int getSetSpeed() {
        return setSpeed;
    }
    public void setSetSpeed(int speed) {

        setSpeed = speed;
        
        if (brakeEmergency) {
            setSpeed = 0;
        }

        if (setSpeed == 0) {
          pc.stopTemp();
        } else {
          pc.startTemp();
        }

        if(trainUI != null) {
            trainUI.setSetSpeed(setSpeed);
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
        
        setAuthority -= (realSpeed * 0.000277778);

        
        
        if (setAuthority < 0) {
            powerCommand = 0;
            trainUI.setAuthority(0);
        } else {
            trainUI.setAuthority(setAuthority);
        }
        
        double stoppingDistance = ((realSpeed * 0.44704) * (realSpeed * 0.44704) / 2.4) * 0.000621371;
        
        if(stoppingDistance >= setAuthority && setSpeed != 0) {
            setSetSpeed(0);
            powerCommand = 0;
        }
        
        if(approachingStation) {
            distanceToStation -= (realSpeed * 0.000277778);
            
            if (stoppingDistance >= distanceToStation) {
                setSetSpeed(0);
                powerCommand = 0;
            }
            if (distanceToStation <= 0) {
                approachingStation = false;
                timeAtStation = 30;
                trainUI.notification("Arrived at " + station + " station.");
                if(auto && stationDoors == 0) {
                    setDoorsRight(1,true);
                } else if(auto) {
                    setDoorsLeft(1,true);
                }
            }
        }
        
        timeAtStation--;
        if (timeAtStation == 0 && auto) {
            if(stationDoors == 0) {
                setDoorsRight(0,true);
            } else {
                setDoorsLeft(0,true);
            }
            setSetSpeed(setPointSpeed);
        }
        
        trainModel.setPowerCommand(powerCommand, trainID);

        /*if (brakeEmergency) {
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
        }*/

        if(trainUI != null) {
            trainUI.setPower(power);
        }
    }

    public void setGainValues(double gainProportional, double gainIntegral) {
        pc.setGainValues(gainProportional, gainIntegral);
        this.gainProportional = gainProportional;
        this.gainIntegral = gainIntegral;
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
        
        if(trainUI != null){
            trainUI.setCurrentTemp(temp); 
        }
        
    }

    public int getDoorsLeft() {
        return doorsLeft;
    }
    public void setDoorsLeft(int status, boolean send) {
        doorsLeft = status;

        if(send) {
            trainModel.setLeftDoors(status, trainID);
        }

        if(trainUI != null) {
            trainUI.setLeftDoors(status);         
        }
    }

    public int getDoorsRight() {
        return doorsRight;
    }
    public void setDoorsRight(int status, boolean send) {
        doorsRight = status;

        if (send) {
            trainModel.setRightDoors(status, trainID);
        }

        if(trainUI != null) {
            trainUI.setRightDoors(status);         
        }
    }

    public int getLights() {
        return lights;
    }
    public void setLights(int status, boolean send) {
        lights = status;
        
        if (send) {
            trainModel.setLights(status, trainID);
        }
        
        if(trainUI != null) {
            trainUI.setLights(status);         
        }
    }

    public boolean engageEmergencyBrake(boolean send) {
        
        if(!send){
            brakeEmergency = true;
            trainUI.emergencyBrakeEngaged();
        } else {
            brakeEmergency = !brakeEmergency;
        }

        if(brakeEmergency){
            pc.stopTemp();
            setSetSpeed(0);
        } else {
            pc.startTemp();
        }

        if(send) {
            trainModel.setEBrake(brakeEmergency, trainID);
        }

        return brakeEmergency;
    }
    
    public void approachStation(int doors, int distance, String station) {
        this.station = station;
        distanceToStation = distance;
        stationDoors = doors;
        approachingStation = true;
        
        if(trainUI != null) {
            trainUI.notification("Approaching " + station + " in " + distance);         
        }
    }
    
    public void failure(String type) {
        trainUI.notification("Emergency brake engaged due to " + type + " failue.");
    }

}
