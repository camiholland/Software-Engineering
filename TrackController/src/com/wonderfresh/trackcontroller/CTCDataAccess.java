/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trackcontroller;

import com.wonderfresh.commons.Block;
import com.wonderfresh.commons.TrackSimulator;

/**
 *
 * @author obkeel
 */
public class CTCDataAccess {
    public static Block getBlock(String line, int block){
        if(line.equals("Red")){
            return TrackSimulator.getInstance().getTrack().getRedLine().getBlock(line, block);
        }
        else if(line.equals("Green")){
            return TrackSimulator.getInstance().getTrack().getGreenLine().getBlock(line, block);
        }
        return null;
    }
    
    public static boolean setAuthority(String line, int block, int authority){
        return TrackSimulator.setAuthority(line, block, authority);
    }
    
    public static boolean setSetSpeed(String line, int block, int setSpeed){
        return TrackSimulator.setSetPointSpeed(line, block, setSpeed);
    }
    
    public static boolean setBlockOpen(String line, int block, boolean open){
        if(line.equals("Red")){
            return TrackSimulator.getInstance().getTrack().getRedLine().getBlock(line, block).closed = !open;
        }
        else if(line.equals("Green")){
            return TrackSimulator.getInstance().getTrack().getGreenLine().getBlock(line, block).closed = !open;
        }
        return false;
    }
    
    public static boolean setSwitch(String line, int block1, int block2){
        TrackSimulator.setSwitch(line, block1, block2);
        return true;
    }
    
    public static boolean deployTrain(String line, int setSpeed, int authority){
        return false;
    }
}
