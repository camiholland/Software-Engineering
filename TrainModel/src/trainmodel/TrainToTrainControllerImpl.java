/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainmodel;

/**
 *
 * @author Cami
 */

public class TrainToTrainControllerImpl implements TrainToTrainController {
    TrainModel trainModel;
    public TrainToTrainControllerImpl(TrainModel TM){
        trainModel = TM;
    }
    
    //communications received by Train Controller
    public double getActualSpeed(int trainID){
        return trainModel.getSpeed();
    }
    public double getSetPointSpeed(int trainID){
        return trainModel.getSPS();
    }
    public int getAC(int trainID){
        return trainModel.getAC();
    }
    public int getHeat(int trainID){
        return trainModel.getHeat();
    }
    public int getLights(int trainID){
        return trainModel.getLights();
    }
    public int getLeftDoors(int trainID){
        return trainModel.getLeftDoors();
    }
    public int getRightDoors(int trainID){
        return trainModel.getRightDoors();
    }
    public int getServiceBrake(int trainID){
        return trainModel.getServiceBrake();
    }
    public double getTemperature(int trainID){
        return trainModel.getTemp();
    }
    public boolean getEBrakeStatus(int trainID){
        return trainModel.getEBrake();
    }
    public String getAuthority(int trainID){
        return trainModel.getAuthority();
    }
    public int getNumPassengersOnBoard(int trainID){
        return trainModel.getNumPass();
    }
    public String getBeaconInfo(int trainID){
        return trainModel.getBeacon();
    }
}
