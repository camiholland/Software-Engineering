package com.wonderfresh.ctcapi;

//@author Sarah
public class CTCImplementation implements CTC {
    @Override public int getSetSpeed(int block) {
        //write these
        return 0;
    }
    
    @Override public boolean setSetSpeed(int block, int speed) {
        return true;
    }
    
    
    @Override public int getAuthority(int block) {
        return 0;
    }
    
    @Override public boolean setAuthority(int block, int authority) {
        return true;
    }
    
    
    @Override public boolean getBlockOpen(int block) {
        return true;
    }
    
    @Override public boolean setBlockOpen(int block, boolean open) {
        return true;
    }
    
    
    @Override public boolean getSwitchState() {
        return true;
    }
    
    @Override public boolean setSwitchState() {
        return true;
    }
    
    
    @Override public int getMode() {
        return 0;
    }
    
    
    @Override public int getSimulationSpeed() {
        return 0;
    }
}
