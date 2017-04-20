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
public class PLCRunner2 extends PLCRunner {
    
    String[] sections;
    String[] blocks;
    String line;
    DefaultListModel lm;
    
    public PLCRunner2(){
        sections = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U"};
        blocks = new String[77];
        for(int i = 0; i < 77; i++){
            blocks[i] = Integer.toString(i + 1);
        }
        line = "Red";
    }
    
    @Override
    public void run(){
        int print27 = -1;
        int print33 = -1;
        int print44 = -1;
        TrackSimulator.setSwitch(line, 9, 77);
        print("9 to 77");
        TrackSimulator.setSwitch(line, 1, 16);
        print("1 to 16");
        
        while(!Thread.interrupted()){
            
            if(TrackSimulator.isSectionOccupied("Red", "U") || TrackSimulator.isSectionOccupied("Red", "A") || 
                    TrackSimulator.isSectionOccupied("Red", "B") || TrackSimulator.isSectionOccupied("Red", "C") || 
                    TrackSimulator.isSectionOccupied("Red", "F") || TrackSimulator.isSectionOccupied("Red", "G") || 
                    TrackSimulator.isBlockOccupied(line, 24) || TrackSimulator.isBlockOccupied(line, 25) || 
                    TrackSimulator.isBlockOccupied(line, 26) || TrackSimulator.isBlockOccupied(line, 27)){
                if(print27 != 0){
                    print27 = 0;
                    print("27 to 76");
                }
                TrackSimulator.setSwitch(line, 27, 76);
            }
            else if(TrackSimulator.isBlockOccupied(line, 28) || TrackSimulator.isBlockOccupied(line, 29) || 
                    TrackSimulator.isBlockOccupied(line, 30) || TrackSimulator.isBlockOccupied(line, 31) || 
                    TrackSimulator.isBlockOccupied(line, 32)){
                if(print27 != 1){
                    print27 = 1;
                    print("27 to 28");
                }
                TrackSimulator.setSwitch(line, 27, 28);
            }
            
            
            if(TrackSimulator.isBlockOccupied(line, 33) || TrackSimulator.isBlockOccupied(line, 34) || 
                    TrackSimulator.isBlockOccupied(line, 35) || TrackSimulator.isBlockOccupied(line, 36) || 
                    TrackSimulator.isBlockOccupied(line, 37) || TrackSimulator.isBlockOccupied(line, 38)){
                if(print33 != 0){
                    print33 = 0;
                    print("32 to 33, 38 to 71");
                }
                TrackSimulator.setSwitch(line, 32, 33);
                TrackSimulator.setSwitch(line, 38, 71);
            }
            else if(TrackSimulator.isBlockOccupied(line, 39) || TrackSimulator.isBlockOccupied(line, 40) || 
                    TrackSimulator.isBlockOccupied(line, 41) || TrackSimulator.isBlockOccupied(line, 42) || 
                    TrackSimulator.isBlockOccupied(line, 43)){
                if(print33 != 1){
                    print33 = 1;
                    print("38 to 39");
                }
                TrackSimulator.setSwitch(line, 38, 39);
            }
            else if(TrackSimulator.isSectionOccupied(line, "R") || TrackSimulator.isSectionOccupied(line, "S") || 
                    TrackSimulator.isSectionOccupied(line, "T")){
                if(print33 != 2){
                    print33 = 2;
                    print("33 to 72");
                }
                TrackSimulator.setSwitch(line, 33, 72);
            }
            
            
            if(TrackSimulator.isSectionOccupied(line, "I") || TrackSimulator.isBlockOccupied(line, 44) || 
                    TrackSimulator.isBlockOccupied(line, 49) || TrackSimulator.isBlockOccupied(line, 50) || 
                    TrackSimulator.isBlockOccupied(line, 51) || TrackSimulator.isBlockOccupied(line, 52)){
                if(print44 != 0){
                    print44 = 0;
                    print("52 to 53, 43 to 44");
                }
                TrackSimulator.setSwitch(line, 52, 53);
                TrackSimulator.setSwitch(line, 43, 44);
            }
            else if(TrackSimulator.isSectionOccupied(line, "M") || TrackSimulator.isSectionOccupied(line, "N")){
                if(print44 != 1){
                    print44 = 1;
                    print("52 to 66");
                }
                TrackSimulator.setSwitch(line, 52, 66);
            }
            else if(TrackSimulator.isSectionOccupied(line, "O") || TrackSimulator.isSectionOccupied(line, "P")){
                if(print44 != 2){
                    print44 = 2;
                    print("44 to 67");
                }
                TrackSimulator.setSwitch(line, 44, 67);
            }
        }
        print("PLC2 ended");
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
