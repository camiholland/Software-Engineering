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

public class TrainModelTest {
    TrainToTrainController trainToTC;
    TrainModelTestUI gui;
    
    private double sps = 0;
    private String authority = null;
    private int numPassWaiting = 0;
    private String beacon = null;
    private double powerCmd = 0;
    private double intGain = 0;
    private double propGain = 0;
    private int trainID = 1;
    
    int acStatus;
    int heatStatus;
    int lightsStatus;
    int leftDoorsStatus;
    int rightDoorsStatus;
    int serviceBrakeStatus;
    boolean eBrake;
    
    public TrainModelTest(TrainModel TM){
        gui = new TrainModelTestUI(this);
        gui.setVisible(true);
        trainToTC = new TrainToTrainControllerImpl(TM);

        
        acStatus = 0;
        heatStatus = 0;
        lightsStatus = 0;
        leftDoorsStatus = 0;
        rightDoorsStatus = 0;
        serviceBrakeStatus = 0;
        eBrake = false;
        
        
        //while(true){
            
            acStatus = trainToTC.getAC(1);
            heatStatus = trainToTC.getHeat(1);
            lightsStatus = trainToTC.getLights(1);
            leftDoorsStatus = trainToTC.getLeftDoors(1);
            rightDoorsStatus = trainToTC.getRightDoors(1);
            serviceBrakeStatus = trainToTC.getServiceBrake(1);
            
            
        //}
        
        //acting train controller:
        //final TrainToTrainController testingTC = new TrainToTrainControllerImpl();
        //acting track model:
        //final TrainToTrack testingTrack = new TrainToTrackImpl();
    }
    
    protected void setEBrake(boolean a){
        eBrake = a;
    }
    protected boolean getEBrake(){
        return eBrake;
    }
    
    
    protected void setSPS(String spsString){
        sps = Double.parseDouble(spsString);
    }
    protected double getSPS(){
        return sps;
    }
    protected void setAuthority(String authorityString){
        authority = authorityString;
    }
    protected String getAuthority(){
        return authority;
    }
    protected void setNumPassengersWaiting(String numPassString){
        numPassWaiting = Integer.parseInt(numPassString);
    }
    protected int getNumPassengersWaiting(){
        return numPassWaiting;
    }
    protected void setBeaconInfo(String beaconString){
        beacon = beaconString;
    }
    protected String getBeaconInfo(){
        return beacon;
    }
    protected void setPowerCmd(String pwrCmdString){
        powerCmd = Double.parseDouble(pwrCmdString);
    }
    protected double getPowerCmd(){
        return powerCmd;
    }
    protected void setIntGain(String intGainString){
        intGain = Double.parseDouble(intGainString);
    }
    protected double getIntGain(){
        return intGain;
    }
    protected void setPropGain(String propGainString){
        propGain = Double.parseDouble(propGainString);
    }
    protected double getPropGain(){
        return propGain;
    }
    protected void setTrainID(int id){
        trainID = id;
    }
    
    
    protected int getAC(){
        return acStatus;
    }
    protected void setAC(int status){
        acStatus = status;
        if(status > 0){
            gui.on(1);
        }
        else if(status == 0){
            gui.off(1);
        }
        else{
            gui.fail(1);
        }
    }
    protected int getHeat(){
        return heatStatus;
    }
    protected void setHeat(int status){
        heatStatus = status;
        if(status > 0){
            gui.on(2);
        }
        else if(status == 0){
            gui.off(2);
        }
        else{
            gui.fail(2);
        }
    }
    protected int getLights(){
        return lightsStatus;
    }
    protected void setLights(int status){
        lightsStatus = status;
        if(status > 0){
            gui.on(3);
        }
        else if(status == 0){
            gui.off(3);
        }
        else{
            gui.fail(3);
        }
    }
    protected int getLeftDoors(){
        return leftDoorsStatus;
    }
    protected void setLeftDoors(int status){
        leftDoorsStatus = status;
        if(status > 0){
            gui.on(4);
        }
        else if(status == 0){
            gui.off(4);
        }
        else{
            gui.fail(4);
        }
    }
    protected int getRightDoors(){
        return rightDoorsStatus;
    }
    protected void setRightDoors(int status){
        rightDoorsStatus = status;
        if(status > 0){
            gui.on(5);
        }
        else if(status == 0){
            gui.off(5);
        }
        else{
            gui.fail(5);
        }
    }
    protected int getServiceBrake(){
        return serviceBrakeStatus;
    }
    protected void setServiceBrake(int status){
        serviceBrakeStatus = status;
        if(status > 0){
            gui.on(6);
        }
        else if(status == 0){
            gui.off(6);
        }
        else{
            gui.fail(6);
        }
    }
}
