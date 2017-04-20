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
import java.util.Random;

import com.wonderfresh.interfaces.TrainControllerInterface;
import com.wonderfresh.interfaces.MboInterface;
import com.wonderfresh.interfaces.Interfaces;
import com.wonderfresh.commons.Time;

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
    Random random;
    Time time;

    Block prevBlock;
    Block block;
    Block nextBlock;
    boolean line; //if true, green line; else, red line
    
    int ID;
    
    final int MAX_POWER = 480000; //watts
    final double CAR_MASS_TON = 40.9; //tonnes (metric ton = 1000kg = 2204.62lbs)
    final int PASS_WEIGHT = 75; //kg                                            //... or 70???
    final int CAR_MASS = 40900; //kg
    final double FRICTION = .06;
    final int T = 1;
    final double MAX_ACC = .5; //m/s2
    final double S_BRAKE_RATE = -1.2; //m/s2
    final double E_BRAKE_RATE = -2.73; //m/s2
    final int DEFAULT_TEMP = 70;
    final double G = 9.8; //m/s2
    
    int numCars;
    int numPass;
    int numCrew;
    int maxPassCapacity;
    int numNewPass;
    int numDisembarking;
    
    double speed;
    double totalMass;
    double acc;
    double grade;
    int sps;
    int speedLimit;
    double powerCmd;
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
    
    String[] beacon;
    String previousStation;
    
    int currentTemp;
    int targetTemp;
    boolean eBrake;
    double authority;
    String announcement;
    
    //String[] testStationString = {"Pioneer", "Edgebrook", "University of Pittsburgh", "Whited", "South Bank", "Central", "Inglewood", "Overbrook", "Glenbury", "Dormont", "Mount Lebanon", "Castle Shannon", "Poplar"};
    
    public TrainModel(int trainID, String lineString){
        ID = trainID;
        
        tempCalc = new TemperatureCalculator(this);
        speedCalc = new SpeedCalculator(this);
        gui = new TrainModelUI(this);
        prevBlock = null;
        if(lineString.equals("Red"))
            line = false;
        else if(lineString.equals("Green"))
            line = true;
        else{
            System.out.println("Error: incorrect line. Green line will be assumed");
            line = true;
        }
        if(line)
            block = TrackSimulator.initBlock("Green");
        else
            block = TrackSimulator.initBlock("Red");
        block.setOccupied(true);
        nextBlock = block.getNextBlock(null);
        random = new Random();
        time = time.getInstance();
        
        testing = Interfaces.getTrainControllerInterface();
        mboInterface = Interfaces.getMboInterface();
        
        if(time.getComparableTime() >= 70000 && time.getComparableTime() < 90000 || time.getComparableTime() >= 160000 && time.getComparableTime() < 160000)
            numCars = 2;
        else
            numCars = 1;
        numPass = 1;
        numCrew = 1;
        maxPassCapacity = 222*numCars;
        numNewPass = 0;
        numDisembarking = 0;
        
        speed = 0;
        totalMass = CAR_MASS*numCars + PASS_WEIGHT*(numPass + numCrew);
        acc = 0;
        grade = block.getBlockGrade();
        sps = block.getSetPointSpeed();
        speedLimit = block.getSpeedLimit();
        powerCmd = 0;
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
        
        beacon = block.getBeaconSignal();
        previousStation = null;
        
        currentTemp = DEFAULT_TEMP; //degrees F
        targetTemp = DEFAULT_TEMP;
        eBrake = false;
        authority = block.getAuthority();
        announcement = null;
        
        
        
        gui.setSpeedLimit(Integer.toString(speedLimit));
        //set max passenger capacity, num crew on board, num pass on board, sps, train ID
        gui.setInitials(Integer.toString(maxPassCapacity), Integer.toString(numCrew), Integer.toString(numPass), Integer.toString(sps), Integer.toString(ID));
        gui.setTemp(Double.toString(currentTemp));
        testing.setSpeedLimit(speedLimit, ID);
        testing.setSpeedAndAuth(sps, authority, ID);
        if(Integer.parseInt(beacon[2]) == -1)
                testing.sendBeaconInfo(false, Integer.parseInt(beacon[1]), beacon[0], ID);
        else if(Integer.parseInt(beacon[2]) == 1)
            testing.sendBeaconInfo(true, Integer.parseInt(beacon[1]), beacon[0], ID);
            nextBlock = block.getNextBlock(prevBlock);
        gui.setLine(line);
        mboInterface.addToDailyPassengers(numNewPass);
        mboInterface.setPassengersOnTrain(ID, numPass);
    }
    
    public void launchUI() {
        gui.setVisible(true);
    }
    
    public int getID(){
        return ID;
    }
    
    protected void adjustSpeed(){
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
            acc = powerCmd/(totalMass*speed) - G*sin(grade) - FRICTION*G*cos(grade);
            if(Double.isNaN(acc)){
                acc = 0;
            }
            if(acc < 0){
                acc = S_BRAKE_RATE;
                if(serviceBrakesStatus == 0)
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
        mboInterface.setSpeedAuthorityPassengerCount(ID, speed, authority, numPass);
    }
    protected double updateAcc(double speed){
        acc = powerCmd/(totalMass*speed) - G*sin(grade) - FRICTION*G*cos(grade);  //reaches infinity...
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
            block = nextBlock;
            if(block == null)
                System.out.println("Error: block is null");
            block.setOccupied(true);
            prevBlock.setOccupied(false);
            grade = block.getBlockGrade();
            speedLimit = block.getSpeedLimit();
            sps = block.getSetPointSpeed();
            authority = block.getAuthority();
            blockLengthTotal += block.getBlockLength();
            beacon = block.getBeaconSignal();
            if(Integer.parseInt(beacon[2]) == -1)
                testing.sendBeaconInfo(false, Integer.parseInt(beacon[1]), beacon[0], ID);
            else if(Integer.parseInt(beacon[2]) == 1)
                testing.sendBeaconInfo(true, Integer.parseInt(beacon[1]), beacon[0], ID);
            nextBlock = block.getNextBlock(prevBlock);
            gui.setUnderground(block.isUnderground());
            if(block.isStation()){
                gui.setStation(line, block.getStation()/*beacon[0]*/, true);
                gui.setNotification("Next Stop: " + block.getStation()/*beacon[0]*/+ "!");
                /*for(int i = 0; i < 13; i++){
                    gui.setStation(line, testStationString[i], true);
                    gui.setNotification("Next Stop: " + testStationString[i]);
                }*/
                numDisembarking = random.nextInt(numPass);
                numPass -= numDisembarking;
                numNewPass = block.takePeopleAtStation(maxPassCapacity-numPass);
                numPass += numNewPass;
                mboInterface.addToDailyPassengers(numNewPass);
                mboInterface.setPassengersOnTrain(ID, numPass);
                gui.setNumPass(Integer.toString(numPass), Integer.toString(numDisembarking));
            }
            if(prevBlock.isStation()){
                gui.setStation(line, previousStation, false);
                /*for(int i = 0; i < 13; i++)
                    gui.setStation(line, testStationString[i], false);*/
            }
        }
        mboInterface.setLocation(ID, block.getBlockNum(), (int)distanceWithinBlock, line);
    }
    public void setTargetTemp(int temp) throws InterruptedException{
        targetTemp = temp;
        if(targetTemp != currentTemp){
            tempCalc.setTemp(currentTemp, targetTemp);
        }
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
            setEBrake(true);
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
            setEBrake(true);
        }
    }
    public void setLeftDoors(int status){
        leftDoorsStatus = status;
        if(status > 0){
            gui.on(4);
            numDisembarking = random.nextInt(numPass);
            numPass -= numDisembarking;
            numNewPass = block.takePeopleAtStation(maxPassCapacity-numPass);
            numPass += numNewPass;
            mboInterface.addToDailyPassengers(numNewPass);
            mboInterface.setPassengersOnTrain(ID, numPass);
            gui.setNumPass(Integer.toString(numPass), Integer.toString(numDisembarking));
        }
        else if(status == 0){
            gui.off(4);
        }
        else{
            gui.fail(4);
            testing.failPower(ID);
            setEBrake(true);
        }
    }
    public void failLeftDoors(){
        leftDoorsStatus = -1;
        gui.fail(4);
        testing.setLeftDoors(-1, ID);
        testing.failPower(ID);
        setEBrake(true);
    }
    public void setRightDoors(int status){
        rightDoorsStatus = status;
        if(status > 0){
            gui.on(5);
            numDisembarking = random.nextInt(numPass);
            numPass -= numDisembarking;
            numNewPass = block.takePeopleAtStation(maxPassCapacity-numPass);
            numPass += numNewPass;
            mboInterface.addToDailyPassengers(numNewPass);
            mboInterface.setPassengersOnTrain(ID, numPass);
            gui.setNumPass(Integer.toString(numPass), Integer.toString(numDisembarking));
        }
        else if(status == 0){
            gui.off(5);
        }
        else{
            gui.fail(5);
            testing.failPower(ID);
            setEBrake(true);
        }
    }
    public void failRightDoors(){
        rightDoorsStatus = -1;
        gui.fail(5);
        testing.setRightDoors(-1, ID);
        testing.failPower(ID);
        setEBrake(true);
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
            setEBrake(true);
        }
    }
    public void failLights(){
        lightsStatus = -1;
        gui.fail(3);
        testing.setLights(-1, ID);
        testing.failPower(ID);
        setEBrake(true);
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
        int previousStatus = serviceBrakesStatus;
        serviceBrakesStatus = status;
        
        if(status > 0){
            driverSetBrake = driverSet;
            gui.on(6);
            if(driverSet)
                adjustSpeed();
        }
        else if(status == 0){
            if(!driverSet && previousStatus == -1){
                serviceBrakesStatus = -1;
                gui.fail(6);
            }
            else
                gui.off(6);
            driverSetBrake = false;
            //gui.off(6);
        }
        else{
            driverSetBrake = false;
            adjustSpeed();
            testing.failBrake(ID);
            setEBrake(true);
            gui.fail(6);
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