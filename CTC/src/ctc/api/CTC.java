/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctc.api;

/**
 *
 * @author Sarah Higbee
 */
public interface CTC {
    public int getSetSpeed(int block); //mph
    
    public boolean setSetSpeed(int block, int speed);
    
    
    public int getAuthority(int block);
    
    public boolean setAuthority(int block, int authority);
    
    
    public boolean getBlockOpen(int block); //true = open
    
    public boolean setBlockOpen(int block, boolean open);
    //if automatic modes don't tell the CTC to open/close blocks, remove this
    
    
    public boolean getSwitchState();
    
    public boolean setSwitchState();
    //can automatic modes don't tell the CTC to flip a switch, remove this
    
    
    public int getMode();
    //if CTC tells the MBO when it's needed through the MBO's interface, remove this
    
    
    public int getSimulationSpeed();
    //if other modules are sensitive to simulation speed

}
