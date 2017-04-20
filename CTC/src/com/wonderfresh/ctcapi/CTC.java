package com.wonderfresh.ctcapi;

public interface CTC {
    public int getSetSpeed(String line, int block); //mph
    
    public boolean setSetSpeed(String line, int block, int speed);
    
    
    public int getAuthority(String line, int block);
    
    public boolean setAuthority(String line, int block, int authority);
    
    
    public boolean getBlockOpen(String line, int block); //true = open
    
    public boolean setBlockOpen(String line, int block, boolean open);
    //if automatic modes don't tell the CTC to open/close blocks, remove this
    
    
    public boolean getSwitchState();
    
    public boolean setSwitchState();
    //can automatic modes don't tell the CTC to flip a switch, remove this
    
    
    public int getMode();
    //if CTC tells the MBO when it's needed through the MBO's interface, remove this
    
    
    public int getSimulationSpeed();
    //if other modules are sensitive to simulation speed
}
