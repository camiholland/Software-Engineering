/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trackcontroller;

import com.wonderfresh.trackmodel.TrackSimulator;

/**
 *
 * @author obkeel
 */
public class PLCRunner1 extends Thread {
    
    public PLCRunner1(){
        
    }
    
    @Override
    public void run(){
        
        while(!Thread.interrupted()){
            if(TrackSimulator.isSectionOccupied("Green", "N")) {
                TrackSimulator.setSwitch("Green", 85, 86);
                TrackSimulator.setSwitch("Green", 77, 101);
                System.out.println("N occupied");
            }
            else if(TrackSimulator.isSectionOccupied("Green", "Q")) {
                TrackSimulator.setSwitch("Green", 85, 100);
                System.out.println("Q occupied");
            }
            else if(TrackSimulator.isSectionOccupied("Green", "M")) {
                TrackSimulator.setSwitch("Green", 77, 76);
                System.out.println("M occupied");
            }
            if(TrackSimulator.isSectionOccupied("Green", "YY")) {
                TrackSimulator.setSwitch("Green", 62, 152);
                System.out.println("YY occupied");
            }
            else {
                TrackSimulator.setSwitch("Green", 62, 61);
                System.out.println("J occupied");
            }
            if(TrackSimulator.isSectionOccupied("Green","F") || TrackSimulator.isSectionOccupied("Green","D") || 
                    TrackSimulator.isSectionOccupied("Green","E")) {
                TrackSimulator.setSwitch("Green", 28, 29);
                TrackSimulator.setSwitch("Green", 12, 13);
                System.out.println("F, D, E occupied");
            }
            else if(TrackSimulator.isSectionOccupied("Green", "A")){
                TrackSimulator.setSwitch("Green", 1, 13);
                System.out.println("A occupied");
            }
            else if(TrackSimulator.isSectionOccupied("Green", "Z")){
                TrackSimulator.setSwitch("Green", 62, 61);
                System.out.println("Z occupied");
            }
        }
    }
}
