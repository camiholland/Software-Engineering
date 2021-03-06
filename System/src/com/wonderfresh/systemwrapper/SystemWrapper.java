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
//import com.wonderfresh.commons.TrackSimulator;
//Modules

import com.wonderfresh.traincontroller.model.TrainController;
import com.wonderfresh.traincontroller.model.Trains;
import com.wonderfresh.trainmodel.Train;
import com.wonderfresh.trainmodel.TrainModel;
import com.wonderfresh.commons.TrackSimulator;
import com.wonderfresh.mbo.Mbo;
import com.wonderfresh.ctc.CTC;
//Interfaces
import com.wonderfresh.interfaces.Interfaces;
import com.wonderfresh.interfaces.MboInterface;
import com.wonderfresh.interfaces.TrainControllerInterfaceImpl;
import com.wonderfresh.interfaces.TrainModelAPIImpl;
import com.wonderfresh.interfaces.MboInterfaceImpl;
import com.wonderfresh.interfaces.TrackModelInterface;
import com.wonderfresh.trackcontroller.TrackController;
//import com.wonderfresh.trackcontroller.TrackController;


public class SystemWrapper {
    
    
    public static Trains trainControllers;
    public static Train trainModels;
    public static Mbo mbo;
    public static TrackSimulator trackSimulator;
    public static TrackController trackController;
    public static MboInterface mboInterface;
    public static CTC ctc;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Time time = Time.getInstance();
        System.out.println(time.setSpeed(2));
        

        trackSimulator = TrackSimulator.getInstance();
        trackController = new TrackController();
        trackController.start();
        trainControllers = new Trains();
        trainModels = new Train();
        
        Interfaces.setMBOInterface(new MboInterfaceImpl());
        
        mbo = new Mbo();
        mbo.start(); 
        ctc = new CTC();
        ctc.start();
        
        
        //mboInterface.initializeTrainArray();
        
        //MboInterface mboInterface=Interfaces.getMboInterface();
        
        Interfaces.setTrainControllerInterface(new TrainControllerInterfaceImpl(trainControllers));
        Interfaces.setTrainModelInterface(new TrainModelAPIImpl(trainModels));
        
        
        trainModels.addTrain(new TrainModel(1, "Green"));
        trainControllers.addTrainController(new TrainController(1, 3));
       // trackController.start();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new SystemLauncher(trainControllers, trainModels,mbo,ctc, trackController)).setVisible(true);
            }
        });
        
        
    }
    
}
