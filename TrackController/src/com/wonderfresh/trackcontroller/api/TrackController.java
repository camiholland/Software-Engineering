/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trackcontroller.api;

import java.util.List;

/**
 *
 * @author obkeel
 */
public interface TrackController {
    public boolean setSetSpeed(int block, int speed);
    
    public int getSetSpeed(int block);
    
    public int getSpeedLimit(int block);
    
    public boolean setBlockOpen(int block, boolean open);
    
    public boolean getBlockOpen(int block);
    
    public boolean setAuthority(int block, int authority);
    
    public int getAuthority(int block);
    
    public boolean getTrainPresence(int block);
    
    public List<Integer> getBlocks();
    
    public String getLine();
}
