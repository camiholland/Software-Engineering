/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller;

import com.wonderfresh.traincontroller.model.TrainController;
import com.wonderfresh.traincontroller.model.Trains;
import com.wonderfresh.commons.Time;
import javax.swing.JFrame;

/**
 *
 * @author Austin
 */
public class TrainControllerExecutable {
            /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        Time time = Time.getInstance();
        time.setSpeed(1);

        Trains trains = new Trains();
        TrainController train = new TrainController(1,3);
        
        trains.addTrainController(train);
        
        TrainControllerInterfaceImpl test = new TrainControllerInterfaceImpl(trains);
        
        train.launchUI();
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override //annotation if you are using Java >= 1.5
            public void run() {
                JFrame f = new JFrame();
                InterfaceTestUI jPanel1 = new InterfaceTestUI(test);
                f.getContentPane().add(jPanel1);
                f.pack();
                f.setVisible(true);
                f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            }
        });
        

    }
}
