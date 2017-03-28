/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller;

import com.wonderfresh.traincontroller.model.TrainController;
import com.wonderfresh.traincontroller.model.Trains;
import com.wonderfresh.interfaces.TrainModelAPI;
import com.wonderfresh.interfaces.TestingTrainModelAPI;

/**
 *
 * @author Austin
 */
public class TrainControllerExecutable {
            /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        TrainModelAPI trainModel = new TestingTrainModelAPI();

        Trains trains = new Trains();
        
        trains.addTrainController(new TrainController(1,3,trainModel));
        trains.addTrainController(new TrainController(2,2,trainModel));
        trains.addTrainController(new TrainController(3,1,trainModel));
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new LaunchPadUI(trains)).setVisible(true);
            }
        });

    }
}
