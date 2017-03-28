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
public class Train {
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
    String authority;
    
    public Train(){
        numCars = 0;
        numPass = 0;
        numCrew = 0;
        
        speed = 0;
        totalMass = 0;
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
        authority = null;
    }
}
