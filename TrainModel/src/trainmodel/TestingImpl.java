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
public class TestingImpl implements Testing {
    TrainModelTest trainModelTest;
    public TestingImpl(TrainModel TM){
        trainModelTest = new TrainModelTest(TM);
    }
    
    //from Track Model
    public int getNumPassengersWaiting(int trainID){
        return trainModelTest.getNumPassengersWaiting();
    }
    public String getBeaconInfo(int trainID){
        return trainModelTest.getBeaconInfo();
    }
    
    //from Train Controller
    public boolean getEBrakeStatus(){
        return trainModelTest.getEBrake();
    }
    public int getLeftDoors(){
        return trainModelTest.getLeftDoors();
    }
    public int getRightDoors(){
        return trainModelTest.getRightDoors();
    }
    public int getAC(){
        return trainModelTest.getAC();
    }
    public int getHeat(){
        return trainModelTest.getHeat();
    }
    public int getLights(){
        return trainModelTest.getLights();
    }
    public double getPowerCommand(){
        return trainModelTest.getPowerCmd();
    }
    public double getIntegralGain(){
        return trainModelTest.getIntGain();
    }
    public double getProportionalGain(){
        return trainModelTest.getPropGain();
    }
    
    //from antenna
    public double getSetPointSpeed(){
        return trainModelTest.getSPS();
    }
    public String getAuthority(){
        return trainModelTest.getAuthority();
    }
    
    //from self
    public void setTemperature(){
        
    }
    public void setEBrakeStatus(){
        
    }
    public void setACFailure(){
        
    }
    public void setHeatFailure(){
        
    }
    public void setLightsFailure(){
        
    }
    public void setLeftDoorsFailure(){
        
    }
    public void setRighDoorsFailure(){
        
    }
    public void setBrakesFailure(){
        
    }
    public void setBeaconFailure(){
        
    }
}
