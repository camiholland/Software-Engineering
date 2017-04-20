/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.interfaces;

/**
 *
 * @author Cami
 */
public class TestingTrainControllerInterface implements TrainControllerInterface {
    
    @Override
    public int setSpeedAndAuth(int speed, double authority, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET SPEED AND AUTHORITY");
        System.out.println("Speed: " + speed);
        System.out.println("Authority: " + authority);
        System.out.println();
        
        return 0;
    }

    @Override
    public int setSpeedLimit(int limit, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET SPEED LIMIT");
        System.out.println("Speed Limit: " + limit);
        System.out.println();
        
        return 0;
    }

    @Override
    public int setSpeed(double speed, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET SPEED");
        System.out.println("Speed: " + speed);
        System.out.println();
        
        return 0;
    }

    @Override
    public int setTemperature(int temperature, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET TEMPERATURE");
        System.out.println("Temp: " + temperature);
        System.out.println();
        
        return 0;
    }

    @Override
    public int setRightDoors(int status, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET RIGHT DOORS");
        System.out.println("Status: " + status);
        System.out.println();
        
        return 0;
    }

    @Override
    public int setLeftDoors(int status, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET LEFT DOORS");
        System.out.println("Status: " + status);
        System.out.println();
        
        return 0;
    }

    @Override
    public int setLights(int status, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET LIGHTS");
        System.out.println("Status: " + status);
        System.out.println();
        
        return 0;
    }

    @Override
    public int setAirConditioning(int status, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET AC");
        System.out.println("Status: " + status);
        System.out.println();
        
        return 0;
    }

    @Override
    public int setHeating(int status, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("SET HEAT");
        System.out.println("Status: " + status);
        System.out.println();
        
        return 0;
    }

    @Override
    public int failPower(int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("POWER FAILURE");
        System.out.println();
        
        return 0;
    }

    @Override
    public int failBrake(int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("BRAKE FAILURE");
        System.out.println();
        
        return 0;
    }

    @Override
    public int emergencyBrake(int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("EMERGENCY BRAKE ACTIVATED");
        System.out.println();
        
        return 0;
    }

    @Override
    public int sendBeaconInfo(boolean doors, double distance, String station, int trainID) {
        System.out.println("TRAIN ID: " + trainID);
        System.out.println("BEACON INFO");
        System.out.println("Doors: " + doors);
        System.out.println("Distance: " + distance);
        System.out.println("Station: " + station);
        System.out.println();
        
        return 0;
    }
}
