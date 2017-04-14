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
        if(line.equals("Red")){
            return TrackSimulator.setAuthority(authority);
        }
        else if(line.equals("Green")){
            return TrackSimulator.setAuthority(authority);
        }
        return false;
    }
    
    public static boolean setSetSpeed(String line, int block, int setSpeed){
        if(line.equals("Red")){
            return TrackSimulator.setAuthority(setSpeed);
        }
        else if(line.equals("Green")){
            return TrackSimulator.setAuthority(setSpeed);
        }
        return false;
    }
    
    public static boolean setBlockOpen(boolean open){
        return false;
    }
    
    public static boolean setSwitch(String line, int block1, int block2){
        TrackSimulator.setSwitch(line, block1, block2);
        return true;
    }
}
