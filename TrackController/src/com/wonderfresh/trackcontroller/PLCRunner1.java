/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trackcontroller;

import com.wonderfresh.commons.TrackSimulator;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author obkeel
 */
public class PLCRunner1 extends PLCRunner {
    
    String[] sections;
    String[] blocks;
    String line;
    DefaultListModel lm;
    
    public PLCRunner1(){
        sections = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "YY", "ZZ"};
        blocks = new String[152];
        for(int i = 0; i < 152; i++){
            blocks[i] = Integer.toString(i + 1);
        }
        line = "Green";
    }
    
    @Override
    public void run(){
        
        int printNQM;
        int printYYJ;
        int printDEFAZ;
        int printCrossing;
        
        TrackSimulator.setSwitch("Green", 62, 152);
        printYYJ = 0;
        print("62 to 152");
        TrackSimulator.setSwitch("Green", 77, 76);
        printNQM = 2;
        print("76 to 77");
        TrackSimulator.setSwitch("Green", 28, 150);
        printDEFAZ = 2;
        print("28 to 150");
        TrackSimulator.setCrossing("Green", 19, false);
        printCrossing = 1;
        print("Crossing 19 off");
        TrackSimulator.setSwitch("Green", 151, 57);
        print("57 to 151");
        
        while(!Thread.interrupted()){
            if(TrackSimulator.isSectionOccupied("Green", "N")) {
                TrackSimulator.setSwitch("Green", 85, 86);
                TrackSimulator.setSwitch("Green", 77, 101);
                if(printNQM != 0){
                    printNQM = 0;
                    print("85 to 86, 77 to 101");
                }
            }
            else if(TrackSimulator.isSectionOccupied("Green", "Q")) {
                TrackSimulator.setSwitch("Green", 85, 100);
                if(printNQM != 1){
                    printNQM = 1;
                    print("85 to 100");
                }
            }
            else if(TrackSimulator.isSectionOccupied("Green", "M")) {
                TrackSimulator.setSwitch("Green", 77, 76);
                if(printNQM != 2){
                    printNQM = 2;
                    print("77 to 76");
                }
            }
            if(TrackSimulator.isSectionOccupied("Green", "YY")) {
                TrackSimulator.setSwitch("Green", 62, 152);
                if(printYYJ != 0){
                    printYYJ = 0;
                    print("62 to 152");
                }
            }
            else if(TrackSimulator.isBlockOccupied("Green", 58) || TrackSimulator.isBlockOccupied("Green", 59) || 
                    TrackSimulator.isBlockOccupied("Green", 60) || TrackSimulator.isBlockOccupied("Green", 61)){
                TrackSimulator.setSwitch("Green", 62, 61);
                if(printYYJ != 1){
                    printYYJ = 1;
                    print("61 to 62");
                }
            }
            if(TrackSimulator.isSectionOccupied("Green","F") || TrackSimulator.isSectionOccupied("Green","D") || 
                    TrackSimulator.isSectionOccupied("Green","E")) {
                TrackSimulator.setSwitch("Green", 28, 29);
                TrackSimulator.setSwitch("Green", 12, 13);
                if(printDEFAZ != 0){
                    printDEFAZ = 0;
                    print("28 to 29, 12 to 13");
                }
            }
            else if(TrackSimulator.isSectionOccupied("Green", "A")){
                TrackSimulator.setSwitch("Green", 1, 13);
                if(printDEFAZ != 1){
                    printDEFAZ = 1;
                    print("1 to 13");
                }
            }
            else if(TrackSimulator.isSectionOccupied("Green", "Z")){
                TrackSimulator.setSwitch("Green", 28, 150);
                if(printDEFAZ != 2){
                    printDEFAZ = 2;
                    print("28 to 150");
                }
            }
            
            if(TrackSimulator.isBlockOccupied("Green", 18) || TrackSimulator.isBlockOccupied("Green", 19) || 
                    TrackSimulator.isBlockOccupied("Green", 20)){
                TrackSimulator.setCrossing("Green", 19, true);
                if(printCrossing != 0){
                    printCrossing = 0;
                    print("Crossing 19 on");
                }
            }
            else{
                TrackSimulator.setCrossing("Green", 19, false);
                if(printCrossing != 1){
                    printCrossing = 1;
                    print("Crossing 19 off");
                }
            }
        }
        print("PLC1 ended");
    }
    
    @Override
    public String[] getBlocks(){
        return blocks;
    }
    
    @Override
    public String[] getSections(){
        return sections;
    }
    
    @Override
    public String getLine(){
        return line;
    }
    
    @Override
    public void setJListModel(ListModel lm){
        this.lm = (DefaultListModel)lm;
    }
    
    @Override
    public void print(String s){
        this.lm.addElement(s);
    }
}
