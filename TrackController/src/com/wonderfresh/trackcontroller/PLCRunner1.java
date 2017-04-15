/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trackcontroller;

import com.wonderfresh.commons.TrackSimulator;

/**
 *
 * @author obkeel
 */
public class PLCRunner1 extends Thread {
    
    String[] sections;
    int[] blocks;
    
    public PLCRunner1(){
        
    }
    
    @Override
    public void run(){
        
        int printNQM;
        int printYYJ;
        int printDEFAZ;
        int printCrossing;
        
        sections = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "YY", "ZZ"};
        blocks = new int[152];
        for(int i = 0; i < 152; i++){
            blocks[i] = i + 1;
        }
        
        TrackSimulator.setSwitch("Green", 62, 152);
        printYYJ = 0;
        System.out.println("62 to 152");
        TrackSimulator.setSwitch("Green", 77, 76);
        printNQM = 2;
        System.out.println("76 to 77");
        TrackSimulator.setSwitch("Green", 28, 150);
        printDEFAZ = 2;
        System.out.println("28 to 150");
        TrackSimulator.setCrossing("Green", 19, false);
        printCrossing = 1;
        System.out.println("Crossing 19 off");
        TrackSimulator.setSwitch("Green", 151, 57);
        System.out.println("57 to 151");
        
        while(!Thread.interrupted()){
            if(TrackSimulator.isSectionOccupied("Green", "N")) {
                TrackSimulator.setSwitch("Green", 85, 86);
                TrackSimulator.setSwitch("Green", 77, 101);
                if(printNQM != 0){
                    printNQM = 0;
                    System.out.println("85 to 86, 77 to 101");
                }
            }
            else if(TrackSimulator.isSectionOccupied("Green", "Q")) {
                TrackSimulator.setSwitch("Green", 85, 100);
                if(printNQM != 1){
                    printNQM = 1;
                    System.out.println("85 to 100");
                }
            }
            else if(TrackSimulator.isSectionOccupied("Green", "M")) {
                TrackSimulator.setSwitch("Green", 77, 76);
                if(printNQM != 2){
                    printNQM = 2;
                    System.out.println("77 to 76");
                }
            }
            if(TrackSimulator.isSectionOccupied("Green", "YY")) {
                TrackSimulator.setSwitch("Green", 62, 152);
                if(printYYJ != 0){
                    printYYJ = 0;
                    System.out.println("62 to 152");
                }
            }
            else if(TrackSimulator.isBlockOccupied("Green", 58) || TrackSimulator.isBlockOccupied("Green", 59) || 
                    TrackSimulator.isBlockOccupied("Green", 60) || TrackSimulator.isBlockOccupied("Green", 61)){
                TrackSimulator.setSwitch("Green", 62, 61);
                if(printYYJ != 1){
                    printYYJ = 1;
                    System.out.println("61 to 62");
                }
            }
            if(TrackSimulator.isSectionOccupied("Green","F") || TrackSimulator.isSectionOccupied("Green","D") || 
                    TrackSimulator.isSectionOccupied("Green","E")) {
                TrackSimulator.setSwitch("Green", 28, 29);
                TrackSimulator.setSwitch("Green", 12, 13);
                if(printDEFAZ != 0){
                    printDEFAZ = 0;
                    System.out.println("28 to 29, 12 to 13");
                }
            }
            else if(TrackSimulator.isSectionOccupied("Green", "A")){
                TrackSimulator.setSwitch("Green", 1, 13);
                if(printDEFAZ != 1){
                    printDEFAZ = 1;
                    System.out.println("1 to 13");
                }
            }
            else if(TrackSimulator.isSectionOccupied("Green", "Z")){
                TrackSimulator.setSwitch("Green", 28, 150);
                if(printDEFAZ != 2){
                    printDEFAZ = 2;
                    System.out.println("28 to 150");
                }
            }
            
            if(TrackSimulator.isBlockOccupied("Green", 18) || TrackSimulator.isBlockOccupied("Green", 19) || 
                    TrackSimulator.isBlockOccupied("Green", 20)){
                TrackSimulator.setCrossing("Green", 19, true);
                if(printCrossing != 0){
                    printCrossing = 0;
                    System.out.println("Crossing 19 on");
                }
            }
            else{
                TrackSimulator.setCrossing("Green", 19, false);
                if(printCrossing != 1){
                    printCrossing = 1;
                    System.out.println("Crossing 19 off");
                }
            }
        }
        System.out.println("PLC1 ended");
    }
    
    public int[] getBlocks(){
        return blocks;
    }
    
    public String[] getSections(){
        return sections;
    }
}
