package com.wonderfresh.interfaces;

import com.wonderfresh.traincontroller.model.Trains;
import com.wonderfresh.traincontroller.model.TrainController;

/**
 *
 * @author Austin
 */
public class TrainControllerInterfaceImpl implements TrainControllerInterface {

    private Trains trains;
    
    public TrainControllerInterfaceImpl(Trains trains) {
        this.trains = trains;
    }
    
    @Override
    public int setSpeedAndAuth(int speed, int authority, int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } else if (speed < 0) {
            return -2;
        } else if (authority < 0) {
            return -3;
        }
        
        train.setSpeedAndAuthority(speed,authority);
        return 0;
       
    }

    @Override
    public int setSpeedLimit(int limit, int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } else if (limit < 0) {
            return -2;
        } 
        
        train.setSpeedLimit(limit);
        return 0;
        
    }

    @Override
    public int setSpeed(double speed, int trainID) {
        
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } else if (speed < 0) {
            return -2;
        } 
        
        train.setRealSpeed(speed * 2.23694);
        return 0;
    }

    @Override
    public int setTemperature(int temperature, int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        }
        
        train.setCurrentTemp(temperature);
        return 0;
    }

    @Override
    public int setRightDoors(int status, int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } else if (status != 0 && status != 1 && status != -1) {
            return -2;
        } 
        
        train.setDoorsRight(status,false);
        return 0;
    }

    @Override
    public int setLeftDoors(int status, int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } else if (status != 0 && status != 1 && status != -1) {
            return -2;
        } 
        
        train.setDoorsLeft(status,false);
        return 0;
    }

    @Override
    public int setLights(int status, int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } else if (status != 0 && status != 1 && status != -1) {
            return -2;
        } 
        
        train.setLights(status,false);
        return 0;
    }

    @Override
    public int setAirConditioning(int status, int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } else if (status != 0 && status != 1 && status != -1) {
            return -2;
        } 
        
        train.setAC(status);
        return 0;
    }

    @Override
    public int setHeating(int status, int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } else if (status != 0 && status != 1 && status != -1) {
            return -2;
        } 
        
        train.setHeat(status);
        return 0;
    }

    @Override
    public int failPower(int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } 
        
        train.failure("power");
        train.engageEmergencyBrake(true);
        return 0;
    }

    @Override
    public int failBrake(int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } 
        
        train.failure("brake");
        train.engageEmergencyBrake(true);
        return 0;
    }

    @Override
    public int emergencyBrake(int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } 
        
        train.engageEmergencyBrake(false);
        return 0;
    }

    @Override
    public int sendBeaconInfo(boolean doors, int distance, String station, int trainID) {
        TrainController train = trains.getTrainController(trainID);
        
        if (train == null) {
            return -1;
        } 
        
        int door = 0;
        
        if (!doors) {
            door = 1;
        }
        
        train.approachStation(door,distance,station);
        return 0;
    }
    
}