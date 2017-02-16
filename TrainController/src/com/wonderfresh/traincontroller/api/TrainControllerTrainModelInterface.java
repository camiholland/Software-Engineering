/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller.api;

/**
 *
 * @author Austin
 */
public interface TrainControllerTrainModelInterface extends TrainControllerInterface {
    
    public int setSpeed(double speed, int trainID);
    
    public int setPassengerCount(int passengerCount, int trainID);
    
    public int setTemperature(int temperature, int trainID);
    
    public int setRightDoors(int status, int trainID);
    
    public int setLeftDoors(int status, int trainID);
        
    public int setLights(int status, int trainID);
    
    public int setAirConditioning(int status, int trainID);
    
    public int setHeating(int status, int trainID);
    
    public int failPower(int trainID);
    
    public int failBrake(int trainID);
   
    public int failAntenna(int trainID);
    
    public int emergencyBrake(int trainID);
    
    public int sendBeaconInformation(boolean doors, int distance, String station, int trainID);
    
}
