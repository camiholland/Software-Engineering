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
public class TestingImpl implements Testing {
    TrainModelTestTrain trainlist;
    public TestingImpl(TrainModelTestTrain trainlist){
        this.trainlist = trainlist;
    }
    
    //from Track Model
    /*public Block getNextBlock(Block currentBlock, Block previousBlock){
        
    }*/
    
    //to train controller
    @Override
    public void setSpeedAndAuth(int speed, int authority, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET SPEED AND AUTHORITY");
        System.out.println("Speed: " + speed);
        System.out.println("Authority: " + authority);
        System.out.println();
    }

    @Override
    public void setSpeedLimit(int limit, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET SPEED LIMIT");
        System.out.println("Speed Limit: " + limit);
        System.out.println();
    }

    @Override
    public void setSpeed(double speed, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET SPEED");
        System.out.println("Speed: " + speed);
        System.out.println();
    }

    @Override
    public void setTemperature(int temperature, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET TEMPERATURE");
        System.out.println("Temp: " + temperature);
        System.out.println();
    }

    @Override
    public void setRightDoors(int status, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET RIGHT DOORS");
        System.out.println("Status: " + status);
        System.out.println();
    }

    @Override
    public void setLeftDoors(int status, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET LEFT DOORS");
        System.out.println("Status: " + status);
        System.out.println();
    }

    @Override
    public void setLights(int status, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET LIGHTS");
        System.out.println("Status: " + status);
        System.out.println();
    }

    @Override
    public void setAirConditioning(int status, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET AC");
        System.out.println("Status: " + status);
        System.out.println();
    }

    @Override
    public void setHeating(int status, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET HEAT");
        System.out.println("Status: " + status);
        System.out.println();
    }

    @Override
    public void failPower(int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("POWER FAILURE");
        System.out.println();
    }

    @Override
    public void failBrake(int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("BRAKE FAILURE");
        System.out.println();
    }

    @Override
    public void emergencyBrake(int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("EMERGENCY BRAKE ACTIVATED");
        System.out.println();
    }

    @Override
    public void sendBeaconInfo(boolean doors, int distance, String station, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("BEACON INFO");
        System.out.println("Doors: " + doors);
        System.out.println("Distance: " + distance);
        System.out.println("Station: " + station);
        System.out.println();
    }
}
