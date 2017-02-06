/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller.api;

/**
 *
 * @author Austin
 */
public interface TrainControllerInterface {
    
    public int setSetPointSpeed(int speed, int trainID);
    
    public int setAuthority(int authority, int trainID);
    
    public int setSpeedLimit(int speed, int trainID);
    
}
