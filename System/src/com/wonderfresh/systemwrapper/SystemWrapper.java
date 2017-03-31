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
import com.wonderfresh.trainmodel.Train;
import com.wonderfresh.trainmodel.TrainModel;
import com.wonderfresh.interfaces.Interfaces;
import com.wonderfresh.interfaces.TrainControllerInterfaceImpl;
import com.wonderfresh.interfaces.TrainModelAPIImpl;

public class SystemWrapper {
    
    public static Trains trainControllers;
    public static Train trainModels;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Time time = Time.getInstance();
        System.out.println(time.setSpeed(1));
        

        
        trainControllers = new Trains();
        trainModels = new Train();
        Interfaces.setTrainControllerInterface(new TrainControllerInterfaceImpl(trainControllers));
        Interfaces.setTrainModelInterface(new TrainModelAPIImpl(trainModels));

        trainModels.addTrain(new TrainModel(1));
        trainControllers.addTrainController(new TrainController(1, 3));
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new SystemLauncher(trainControllers, trainModels)).setVisible(true);
            }
        });
    }
    
}
