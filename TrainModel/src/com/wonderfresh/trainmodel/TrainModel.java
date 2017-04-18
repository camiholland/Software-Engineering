/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trainmodel;

import com.wonderfresh.commons.Block;
import com.wonderfresh.commons.TrackSimulator;
import static java.lang.Math.abs;
import static java.lang.Math.ceil;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.swing.JFrame;

import com.wonderfresh.interfaces.TrainControllerInterface;
import com.wonderfresh.interfaces.MboInterface;
import com.wonderfresh.interfaces.Interfaces;


/**
 *
 * @author Cami
 */
public class TrainModel {
    TrainModelUI gui;
    TrainControllerInterface testing;
    MboInterface mboInterface;
    TemperatureCalculator tempCalc;
    SpeedCalculator speedCalc;

    Block prevBlock;
    Block block;
    Block nextBlock;
    boolean line; //if true, green line; else, red line
    //TrackSimulator trackSim;

    
    int ID;
    
    int currentSecond;
    
    final int MAX_POWER = 480000; //watts
    final double CAR_MASS_TON = 40.9; //tonnes (metric ton = 1000kg = 2204.62lbs)
    final int PASS_WEIGHT = 75; //kg                                            //... or 70???
    final int CAR_MASS = 40900; //kg
    final double FRICTION = .06;                                                  //<-- that ain't right!
    final int T = 1;
    final double MAX_ACC = .5; //m/s2
    final double S_BRAKE_RATE = -1.2; //m/s2
    final double E_BRAKE_RATE = -2.73; //m/s2
    final int DEFAULT_TEMP = 75;
    final double G = 9.8; //m/s2
    
    int numCars;
    int numPass;
    int numCrew;
    
    double speed;
    double totalMass;
    double acc;
    //double error;
    double previousError;
    double grade;
    int sps;
    int speedLimit;
    double powerCmd;
    //double previousPowerCmd;
    double distance;
    double distanceWithinBlock;
    double blockLengthTotal;
    
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
    
    public TrainModel(int trainID){
        ID = trainID;
        
        tempCalc = new TemperatureCalculator(this);
        speedCalc = new SpeedCalculator(this);
        gui = new TrainModelUI(this);
        //trackSim = TrackSimulator.getInstance();
        prevBlock = null;
        line = true;                                                            // this should be a variable
        if(line)
            block = TrackSimulator.initBlock("Green");
        else
            block = TrackSimulator.initBlock("Red");
        block.setOccupied(true);
        nextBlock = block.getNextBlock(null);
        //System.out.println(block.getLabel());
        //System.out.println(nextBlock.getLabel());
        
        testing = Interfaces.getTrainControllerInterface();
        mboInterface = Interfaces.getMboInterface();
        
        
        numCars = 1;
        numPass = 0;
        numCrew = 1;
        
        speed = 0;
        totalMass = CAR_MASS*numCars + PASS_WEIGHT*(numPass + numCrew);
        acc = 0;
        //error = 0;
        previousError = 0;
        grade = block.getBlockGrade();
        sps = 0;
        speedLimit = block.getSpeedLimit();
        powerCmd = 0;
        //previousPowerCmd = 0;
        distance = 0;
        distanceWithinBlock = 0;
        blockLengthTotal = block.getBlockLength();
        
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
        
        gui.setSpeedLimit(Integer.toString(speedLimit));
        //set max passenger capacity, num crew on board, num pass on board, train ID
        gui.setInitials(Integer.toString(numCars*222), Integer.toString(numCrew), Integer.toString(numPass), Integer.toString(ID));
        gui.setTemp(Double.toString(currentTemp));
        testing.setSpeedLimit(speedLimit, ID);
        gui.setLine(line);
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
            speedCalc.setSpeed(acc, speed, powerCmd/(totalMass*sps));
        }
        else if(driverSetBrake){
            acc = S_BRAKE_RATE;
            speedCalc.setSpeed(acc, speed, powerCmd/(totalMass*sps));
        }
        else if(powerCmd <= MAX_POWER){
            //a = P/mv
            //acc = abs(powerCmd - previousPowerCmd) / (totalMass * (sps - speed)); //? I don't think this is right. plus obvi haven't taken into acct friction, grade, etc.
            acc = powerCmd/(totalMass*speed) - G*sin(grade) - FRICTION*G*cos(grade);  //reaches infinity...
            if(Double.isNaN(acc)){
                acc = 0;
            }
            if(acc < 0){
                acc = S_BRAKE_RATE;
                setServiceBrake(1, driverSetBrake);
            }
            else{
                setServiceBrake(0, driverSetBrake);
                if(acc > MAX_ACC)
                    acc = MAX_ACC;
            }
            speedCalc.setSpeed(acc, speed, powerCmd/(totalMass*sps));
            setServiceBrake(0, driverSetBrake);
        }
    }
    protected void updateSpeed(double speed){
        this.speed = speed;
        gui.setSpeed(Double.toString(speed*3600/1602)); //m/s / 1602 m/mi * 3600 s/h
        testing.setSpeed(speed, ID);
    }
    protected double updateAcc(double speed){
        acc = powerCmd/(totalMass*speed) - G*sin(grade) - FRICTION*G*cos(grade);  //reaches infinity...
        //System.out.println("Acceleration = " + acc);
        if(eBrake)
            acc = E_BRAKE_RATE;
        else if(driverSetBrake){
            acc = S_BRAKE_RATE;
        }
        else if(acc > 0){
            setServiceBrake(0, false);
            if(acc > MAX_ACC)
                acc = MAX_ACC;
        }
        else if(acc < 0){
            acc = S_BRAKE_RATE;
            setServiceBrake(1, false);
        }
        else if(Double.isNaN(acc)){
            acc = 0;
        }
        return acc;
    }
    
    
    
    protected void updateDistance(double acc){
        //d = vi*t + 1/2*a*t^2 where t = 1
        distance += speed + acc/2;
        distanceWithinBlock += speed + acc/2;
        if(distance >= blockLengthTotal){
            distanceWithinBlock = distance - blockLengthTotal;
            prevBlock = block;
            prevBlock.setOccupied(false);
            block = nextBlock;
            block.setOccupied(true);
            grade = block.getBlockGrade();
            speedLimit = block.getSpeedLimit();
            blockLengthTotal += block.getBlockLength();
            nextBlock = block.getNextBlock(prevBlock);
            if(nextBlock.isStation()){
                gui.setStation(line, nextBlock.getStation(), false);
            }
            if(block.isStation()){
                gui.setStation(line, block.getStation(), true);
            }
            //System.out.println("moved to next block" + block.getBlockNum());
        }
        mboInterface.setLocation(ID, block.getBlockNum(), (int)distanceWithinBlock, line);
    }
    public void setTargetTemp(int temp) throws InterruptedException{
        targetTemp = temp;
        if(targetTemp != currentTemp){
            tempCalc.setTemp(currentTemp, targetTemp);
        }
//        if(targetTemp != currentTemp)
//            train.adjustTemp(); every second                                  FIX THIS and maybe do the same thing with speed so I don't have to deal with threads
    }
    protected void updateTemp(int currentTemp, int status){
        this.currentTemp = currentTemp;
        if(status == 1 && acStatus == 0){
            setAC(1);
            setHeat(0);
        }
        else if(status == -1 && heatStatus == 0){
            setHeat(1);
            setAC(0);
        }
        else if(status == 0){
            setAC(0);
            setHeat(0);
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
        gui.setEBrake(eBrake);
        adjustSpeed();
    }
    public void setServiceBrake(int status, boolean driverSet){
        serviceBrakesStatus = status;
        
        if(status > 0){
            driverSetBrake = driverSet;
            gui.on(6);
            if(driverSet)
                adjustSpeed();
        }
        else if(status == 0){
            driverSetBrake = false;
            gui.off(6);
        }
        else{
            driverSetBrake = false;
            gui.fail(6);
            eBrake = true;
            adjustSpeed();
            testing.failBrake(ID);
        }
    }
    public void setPowerCmd(double pwrCmd){
        powerCmd = pwrCmd;
        gui.setPowerCmd(String.format("%.2f",powerCmd/1000));
        powerCmd *= 4;
        adjustSpeed();
    }
    public void setAnnouncement(String announcement){
        this.announcement = announcement;
        gui.setNotification(announcement);
    }
    
    public void setSPS(int sps){
        this.sps = sps;
        gui.setSPS(Integer.toString(sps*3600/1602)); //m/s / 1602 m/mi * 3600 s/h
    }
}