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
    TrainModelTest trainModelTest;
    TrainModelTestTrain trainlist;
    public TestingImpl(TrainModel TM){
        trainModelTest = new TrainModelTest(TM);
        trainlist = new TrainModelTestTrain();
    }
    
    //from Track Model
    /*public Block getNextBlock(Block currentBlock, Block previousBlock){
        
    }*/
    
    //to train controller
    @Override
    public void setSpeedAndAuth(int speed, int authority, int trainID) {
        TrainModelTest train = TrainModelTestTrain.getTrain(trainID);
        train.setSpeedAndAuthority(speed,authority);
    }

    @Override
    public void setSpeedLimit(int limit, int trainID) {
        TrainModelTest train = TrainModelTestTrain.getTrain(trainID);
        train.setSpeedLimit(limit);
    }

    @Override
    public void setSpeed(double speed, int trainID) {
        TrainModelTest train = TrainModelTestTrain.getTrain(trainID);
        train.setRealSpeed(speed);
    }

    @Override
    public void setTemperature(int temperature, int trainID) {
        TrainModelTest train = TrainModelTestTrain.getTrain(trainID);
        train.setCurrentTemp(temperature);
    }

    @Override
    public void setRightDoors(int status, int trainID) {
        TrainModelTest train = TrainModelTestTrain.getTrain(trainID);
        train.setDoorsRight(status);
    }

    @Override
    public void setLeftDoors(int status, int trainID) {
        TrainModelTest train = TrainModelTestTrain.getTrain(trainID);
        train.setDoorsLeft(status);
    }

    @Override
    public void setLights(int status, int trainID) {
        TrainModelTest train = TrainModelTestTrain.getTrain(trainID);
        train.setLights(status);
    }

    @Override
    public void setAirConditioning(int status, int trainID) {
        TrainModelTest train = TrainModelTestTrain.getTrain(trainID);
        train.setAC(status);
    }

    @Override
    public void setHeating(int status, int trainID) {
        TrainModelTest train = TrainModelTestTrain.getTrain(trainID);
        train.setHeat(status);
    }

    @Override
    public void failPower(int trainID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void failBrake(int trainID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void emergencyBrake(int trainID) {
        TrainModelTest train = trainlist.getTrain(trainID);
        train.engageEmergencyBrake();
    }

    @Override
    public void sendBeaconInfo(boolean doors, int distance, String station, int trainID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //from antenna
    public void setSpeedAndAuth(double speed, int authority){
        
    }
    public void setBeaconInfo(String info){
        
    }
    /*
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
        
    }*/
}
