package com.wonderfresh.ctcapi;

import com.wonderfresh.ctc.CTCUI;

//@author Sarah
public class CTCImplementation implements CTC {
    //returns the set speed the CTC believes this block currently has
    @Override public int getSetSpeed(String line, int block) {
        //return mytrack -> line -> block -> speed
        return 0;
    }
    
    //informs CTC of a change in the track.
    @Override public boolean setSetSpeed(String line, int block, int speed) {
        //make sure speed is valid and within speed limit
        //if it is: mytrack -> line -> block -> speed = speed
        //and return true
        //else return false
        return true;
    }
    
    //returns the authority the CTC believes this block currently has
    @Override public int getAuthority(String line, int block) {
        //return mytrack -> line -> block -> authority
        return 0;
    }
    
    //informs CTC of a change in the track.
    @Override public boolean setAuthority(String line, int block, int authority) {
        //make sure authority is valid
        //if it is: mytrack -> line -> block -> authority = authority
        //and return true
        //else return false
        return true;
    }
    
    //returns whether or not the CTC believes a block is open
    @Override public boolean getBlockOpen(String line, int block) {
        //return mytrack -> line -> block -> open
        return true;
    }
    
    //informs CTC of a change in the track.
    @Override public boolean setBlockOpen(String line, int block, boolean open) {
        //for now, don't do any checks
        //may need to check for train
        //mytrack -> line -> block -> open = open
        //might not need to return a boolean but keep it consistent in case
        return true;
    }
    
    
    @Override public boolean getSwitchState() {
        //return mytrack -> line -> block -> switch -> state?
        //how's this stored? check the track model
        return true;
    }
    
    @Override public boolean setSwitchState() {
        //may need to check for train, may not
        //current state = mytrack -> line -> block -> switch -> state?
        //set state to reverse of what it was
        return true;
    }
    
    //0 = manual, 1 = fixed block auto, 2 = MBO
    @Override public int getMode() {
        //return mode
        //0 = manual, 1 = fixed block auto, 2 = MBO
        return 0;
    }
    
    
    @Override public int getSimulationSpeed() {
        //return speed
        //two speeds: 1 and 10
        //1 is wall clock, 10 is 10x wall clock
        return 0;
    }
}
