/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.systemwrapper;

/**
 *
 * @author Austin
 */

import com.wonderfresh.commons.Time;

import com.wonderfresh.traincontroller.model.TrainController;
import com.wonderfresh.traincontroller.model.Trains;

import com.wonderfresh.interfaces.TrainControllerInterface;
import com.wonderfresh.interfaces.TrainModelAPI;

import com.wonderfresh.interfaces.TrainControllerInterfaceImpl; 
import com.wonderfresh.interfaces.TestingTrainModelAPI;

public class SystemWrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Time time = Time.getInstance();
        System.out.println(time.setSpeed(50));
        
        Trains trains = new Trains();

        
        trains.addTrainController(new TrainController(1, 3));
        trains.addTrainController(new TrainController(2, 2));
        trains.addTrainController(new TrainController(3, 1));
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new SystemLauncher(trains)).setVisible(true);
            }
        });
    }
    
}
