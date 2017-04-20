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
    PLCRunner2 plc2;
    TrackControllerUI tcui1;
    TrackControllerUI tcui2;
    
    public TrackController(){
        plc1 = new PLCRunner1();
        plc2 = new PLCRunner2();
        tcui1 = new TrackControllerUI(plc1);
        tcui2 = new TrackControllerUI(plc2);
    }
    
    public void start(){
        plc1.start();
        plc2.start();
    }
    
    public void setVisible(){
        tcui1.initValues();
        tcui1.setVisible(true);
        tcui2.initValues();
        tcui2.setVisible(true);
    }
    
    public void stop(){
        plc1.interrupt();
        plc2.interrupt();
    }
    
    public static void main(String[] args) {
        System.out.println("Start");
        TrackControllerUI tcui = new TrackControllerUI(new PLCRunner1());
        tcui.setVisible(true);
    }
    
}
