/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.interfaces;

/**
 *
 * @author Austin
 */
public interface TrainModelAPI {
    public void setEBrake(boolean status, int trainID);
    
    public void setServiceBrake(int status, int trainID);
    
    public void setLeftDoors(int status, int trainID);
    
    public void setRightDoors(int status, int trainID);
    
    public void setTargetTemperature(int status, int trainID);
    
    public void setLights(int status, int trainID);
    
    public void setPowerCommand(double pwrCmd, int trainID);
    
    public void setAnnouncement(String announcement, int trainID);
    
    public void addTrain(int trainID, String line);
}
