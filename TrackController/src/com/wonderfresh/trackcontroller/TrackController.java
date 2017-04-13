/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trackcontroller;

/**
 *
 * @author obkeel
 */
public class TrackController {
    PLCRunner1 plc1;
    /**
     * @param args the command line arguments
     */
    public TrackController(){
        plc1 = new PLCRunner1();
    }
    
    public void start(){
        plc1.start();
    }
    
    public void stop(){
        plc1.interrupt();
    }
    
    public static void main(String[] args) {
        System.out.println("Start");
    }
    
}
