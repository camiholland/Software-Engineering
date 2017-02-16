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
public interface TrainModelAPI {
    //generic methods that both Train Controller and Track Model receive
    
    
}

interface TrainToTrainController extends TrainModelAPI{
    //communications received by Train Controller
    public double getActualSpeed(int trainID);
    public double getSetPointSpeed(int trainID);
    public int getAC(int trainID);
    public int getHeat(int trainID);
    public int getLights(int trainID);
    public int getLeftDoors(int trainID);
    public int getRightDoors(int trainID);
    public int getServiceBrake(int trainID);
    public double getTemperature(int trainID);
    public boolean getEBrakeStatus(int trainID);
    public String getAuthority(int trainID);
    public int getNumPassengersOnBoard(int trainID);
    public String getBeaconInfo(int trainID);
}

interface TrainToTrack extends TrainModelAPI{
    //communications received by Track Model
    public int getNumAvailableSeats(int trainID, int numAvailableSeats);
    public void setNumAvailableSeats(int trainID, int numAvailableSeats);
}

interface Testing extends TrainModelAPI{
    //testing for communications received by Train Model
    //from Track Model
    public int getNumPassengersWaiting(int trainID);
    public String getBeaconInfo(int trainID);
    
    //from Train Controller
    public boolean getEBrakeStatus();
    public int getLeftDoors();
    public int getRightDoors();
    public int getAC();
    public int getHeat();
    public int getLights();
    public double getPowerCommand();
    public double getIntegralGain();
    public double getProportionalGain();
    
    //from antenna
    public double getSetPointSpeed();
    public String getAuthority();
    
    //from self
    public void setTemperature();
    public void setEBrakeStatus();
    public void setACFailure();
    public void setHeatFailure();
    public void setLightsFailure();
    public void setLeftDoorsFailure();
    public void setRighDoorsFailure();
    public void setBrakesFailure();
    public void setBeaconFailure();
}