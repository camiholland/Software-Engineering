/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.interfaces;

import com.wonderfresh.interfaces.TrainModelAPI;

/**
 *
 * @author Austin
 */
public class TestingTrainModelAPI implements TrainModelAPI {

    @Override
    public void setEBrake(boolean status, int trainID) {
        System.out.println("\nTrainID: " + trainID + "\nEmergency brake status: " + status);
    }

    @Override
    public void setServiceBrake(int status, int trainID) {
        System.out.println("\nTrainID: " + trainID + "\nService brake status: " + status);
    }

    @Override
    public void setLeftDoors(int status, int trainID) {
        System.out.println("\nTrainID: " + trainID + "\nLeft doors status: " + status);
    }

    @Override
    public void setRightDoors(int status, int trainID) {
        System.out.println("\nTrainID: " + trainID + "\nRight doors status: " + status);
    }

    @Override
    public void setTargetTemperature(int status, int trainID) {
        System.out.println("\nTrainID: " + trainID + "\nTemperature set to: " + status);
    }

    @Override
    public void setLights(int status, int trainID) {
        System.out.println("\nTrainID: " + trainID + "\nLights status: " + status);
    }

    @Override
    public void setPowerCommand(double pwrCmd, int trainID) {
        System.out.println("\nTrainID: " + trainID + "\nPower command set: " + pwrCmd);
    }

    @Override
    public void setAnnouncement(String announcement, int trainID) {
        System.out.println("\nTrainID: " + trainID + "\nAnnouncement: " + announcement);
    }
    
    @Override
    public void addTrain(int trainID, String line){
        System.out.println("\nTrainID: " + trainID + "\nLine: " + line);
    }
}
