/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trainmodel;

import static java.lang.Math.abs;
import static java.lang.Math.ceil;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.swing.JFrame;


/**
 *
 * @author Cami
 */
public class TrainModel {
    TrainModelUI gui;
    Testing testing;
    TemperatureCalculator tempCalc;
    
    int ID;
    
    int currentSecond;
    
    final int MAX_POWER = 120000; //watts
    final double CAR_MASS_TON = 40.9; //tonnes (metric ton = 1000kg = 2204.62lbs)
    final int PASS_WEIGHT = 75; //kg                                            //... or 70???
    final int CAR_MASS = 40900; //kg
    final double FRICTION = 1;                                                  //<-- that ain't right!
    final int T = 1;
    final double MAX_ACC = .5; //m/s2
    final double S_BRAKE_RATE = -1.2; //m/s2
    final double E_BRAKE_RATE = -2.73; //m/s2
    final int DEFAULT_TEMP = 75;
    
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
    double previousPowerCmd;
    
    int acStatus;
    int heatStatus;
    int lightsStatus;
    int leftDoorsStatus;
    int rightDoorsStatus;
    int serviceBrakesStatus;
    boolean driverSetBrake;
    
    String beacon;
    String previousBeacon;
    
    int currentTemp;
    int targetTemp;
    boolean eBrake;
    int authority;
    String announcement;
    
    public TrainModel(int trainID, TrainModelTestTrain tclist){
        ID = trainID;
        
        tempCalc = new TemperatureCalculator(this);
        gui = new TrainModelUI(this);
        
        testing = new TestingImpl(tclist);
        
        
        
        
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
        previousPowerCmd = 0;
        
        acStatus = 0;
        heatStatus = 0;
        lightsStatus = 0;
        leftDoorsStatus = 0;
        rightDoorsStatus = 0;
        serviceBrakesStatus = 0;
        driverSetBrake = false;
        
        beacon = null;
        previousBeacon = null;
        
        currentTemp = DEFAULT_TEMP; //degrees F
        targetTemp = DEFAULT_TEMP;
        eBrake = false;
        authority = 0;
        announcement = null;
        
        launchUI();
        //currentSecond = (int) ceil(System.nanoTime()/1000000000);
        /*while(true){
            if(System.nanoTime()/1000000000 - currentSecond >= 1){
                if(currentTemp > targetTemp + 2 || currentTemp < targetTemp - 2){
                    adjustTemp();
                }

                if(eBrake || serviceBrakesStatus == 1 || sps != speed){
                    adjustSpeed();
                }
            }
            currentSecond++;
        }*/
    }
    
    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        // TODO code application logic here
        
    }*/
    
    public void launchUI() {
        gui.setVisible(true);
    }
    
    public int getID(){
        return ID;
    }
    
    
    
    /*private void updateAll(String speed, String sps, String speedLimit, String powerCmd){
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
    }*/
    
    protected void adjustSpeed(){
        //totalMass = CAR_MASS * numCars + PASS_WEIGHT * (numPass + numCrew);
        //error = sps - speed;
        //netForceUphillDecel = totalMass * acc + totalMass * 9.8 * sin(grade) + FRICTION * totalMass * 9.8 * cos(grade);
        //netForceUphillAccel = totalMass * acc - totalMass * 9.8 * sin(grade) - FRICTION * totalMass * 9.8 * cos(grade);
        //netForceDownhillDecel = totalMass * acc - totalMass * 9.8 * sin(grade) + FRICTION * totalMass * 9.8 * cos(grade);
        //netForceDownhillAccel = totalMass * acc + totalMass * 9.8 * sin(grade) - FRICTION * totalMass * 9.8 * cos(grade);
        if(eBrake){
            acc = E_BRAKE_RATE;
            speed += acc*1;
            if(speed < 0)
                speed = 0;
        }
        else if(driverSetBrake){
            acc = S_BRAKE_RATE;
            speed += acc*1;
            if(speed < 0)
                speed = 0;
        }
        else if(powerCmd <= MAX_POWER){
            //a = P/mv
            acc = abs(powerCmd - previousPowerCmd) / (totalMass * (sps - speed));
            if(acc < 0){
                acc = S_BRAKE_RATE;
                setServiceBrake(1, driverSetBrake);
            }
            else{
                setServiceBrake(0, driverSetBrake);
                if(acc > MAX_ACC)
                    acc = MAX_ACC;
            }
            //v = v0 + at, where t = 1
            speed += acc*1;
            if(speed < 0)
                speed = 0;
        }
        testing.setSpeed(speed, ID);
    }
    public void setTargetTemp(int temp){
        targetTemp = temp;
        if(targetTemp != currentTemp){
            tempCalc.setTemp(currentTemp, targetTemp);
        }
//        if(targetTemp != currentTemp)
//            train.adjustTemp(); every second                                  FIX THIS and maybe do the same thing with speed so I don't have to deal with threads
    }
    protected void adjustTemp(int currentTemp, int status){
        this.currentTemp = currentTemp;
        if(status == 1 && acStatus == 0){
            setAC(1);
            setHeat(0);
        }
        else if(status == -1 && heatStatus == 0){
            setHeat(1);
            setAC(0);
        }
        gui.setTemp(Integer.toString(currentTemp));
        testing.setTemperature(currentTemp, ID);
    }
    
    protected void setAC(int status){
        acStatus = status;
        if(status > 0){
            gui.on(1);
            testing.setAirConditioning(1, ID);
        }
        else if(status == 0){
            gui.off(1);
            testing.setAirConditioning(0, ID);
        }
        else{
            gui.fail(1);
            testing.setAirConditioning(-1, ID);
            testing.failPower(ID);
        }
    }
    protected void setHeat(int status){
        heatStatus = status;
        if(status > 0){
            gui.on(2);
            testing.setHeating(1, ID);
        }
        else if(status == 0){
            gui.off(2);
            testing.setHeating(0, ID);
        }
        else{
            gui.fail(2);
            testing.setHeating(-1, ID);
            testing.failPower(ID);
        }
    }
    public void setLeftDoors(int status){
        leftDoorsStatus = status;
        if(status > 0){
            gui.on(4);
        }
        else if(status == 0){
            gui.off(4);
        }
        else{
            gui.fail(4);
            testing.failPower(ID);
        }
    }
    public void failLeftDoors(){
        leftDoorsStatus = -1;
        gui.fail(4);
        testing.setLeftDoors(-1, ID);
        testing.failPower(ID);
    }
    public void setRightDoors(int status){
        rightDoorsStatus = status;
        if(status > 0){
            gui.on(5);
        }
        else if(status == 0){
            gui.off(5);
        }
        else{
            gui.fail(5);
            testing.failPower(ID);
        }
    }
    public void failRightDoors(){
        rightDoorsStatus = -1;
        gui.fail(5);
        testing.setRightDoors(-1, ID);
        testing.failPower(ID);
    }
    public void setLights(int status){
        lightsStatus = status;
        if(status > 0){
            gui.on(3);
        }
        else if(status == 0){
            gui.off(3);
        }
        else{
            gui.fail(3);
            testing.failPower(ID);
        }
    }
    public void failLights(){
        lightsStatus = -1;
        gui.fail(3);
        testing.setLights(-1, ID);
        testing.failPower(ID);
    }
    public void activateEBrake(){
        eBrake = true;
        testing.emergencyBrake(ID);
        adjustSpeed();
    }
    public void setEBrake(boolean status){
        eBrake = status;
        adjustSpeed();
    }
    public void setServiceBrake(int status, boolean driverSet){
        serviceBrakesStatus = status;
        driverSetBrake = driverSet;
        if(status > 0){
            gui.on(6);
        }
        else if(status == 0){
            gui.off(6);
        }
        else{
            gui.fail(6);
            testing.failBrake(ID);
        }
    }
    public void setPowerCmd(double pwrCmd){
        powerCmd = pwrCmd;
        gui.setPowerCmd(String.format("%.2f",powerCmd/1000));
    }
    public void setAnnouncement(String announcement){
        this.announcement = announcement;
        gui.setNotification(announcement);
    }
}