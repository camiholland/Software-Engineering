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
    TrackControllerUI tcui;
    /**
     * @param args the command line arguments
     */
    public TrackController(){
        plc1 = new PLCRunner1();
        tcui = new TrackControllerUI(plc1);
    }
    
    public void start(){
        plc1.start();
    }
    
    public void setVisible(){
        System.out.println("init");
        tcui.initValues();
        System.out.println("visible");
        tcui.setVisible(true);
    }
    
    public void stop(){
        plc1.interrupt();
    }
    
    public static void main(String[] args) {
        System.out.println("Start");
        TrackControllerUI tcui = new TrackControllerUI(new PLCRunner1());
        tcui.setVisible(true);
    }
    
}
