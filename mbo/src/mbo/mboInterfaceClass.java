/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo;

/**
 *
 * @author angie
 */
public class mboInterfaceClass implements mboInterface{
    void setDispatchedTrain(int trainID, double speed, double authority, int locationBlock,double locationInBlock){
        
        
        
    }

    @Override
    public mboTrain[] setDispatchedTrain(int trainID, double speed, double authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public mboTrain[] setUpdatedSpeedAuthority(int trainID, double speed, double authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public mboTrain[] getDispatchedTrain(int trainID, double speed, double authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public mboTrain[] getUpdatedSpeedAuthority(int trainID, double speed, double authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public mboTrainDepartInfo[] setTrainDepartInfo(String station, String trainIDandDepartTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public mboTrainDepartInfo[] getTrainDepartInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public mboTrainDepartInfo[] getTrainDepartInfo(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

