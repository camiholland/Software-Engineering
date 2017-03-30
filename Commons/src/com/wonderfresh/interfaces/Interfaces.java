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
public class Interfaces {
    
    private static TrainModelAPI trainModelAPI = null;
    
    public static TrainModelAPI getTrainModelInterface() {
        
        if (trainModelAPI == null) {
            trainModelAPI = new TestingTrainModelAPI();
        }
        
        return trainModelAPI;
    }
    
}
