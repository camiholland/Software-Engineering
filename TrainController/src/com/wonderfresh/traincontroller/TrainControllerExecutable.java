/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller;

import com.wonderfresh.traincontroller.model.TrainController;
import com.wonderfresh.traincontroller.model.Trains;

/**
 *
 * @author Austin
 */
public class TrainControllerExecutable {
            /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        Trains trains = new Trains();
        
        trains.addTrainController(new TrainController(1,3));
        trains.addTrainController(new TrainController(2,2));
        trains.addTrainController(new TrainController(3,1));
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new LaunchPadUI(trains)).setVisible(true);
            }
        });

    }
}
