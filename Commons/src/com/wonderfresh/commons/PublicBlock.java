/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wonderfresh.commons;

/**
 *
 * @author kwc12
 */
public class PublicBlock extends Block{
    
    private boolean BeaconPresent;
    private String Signal; // For beacon
    private PublicBlock nextBlock;
    private PublicBlock prevBlock; 
    
    PublicBlock(){
        super();
        // After calling super() and initiatiating a block, I think that 
        // the init() function needs to be called to send the PublicBlock 
        // to the first block of the line.
    }
 
    public boolean hasBeacon(){
        return false;
    }
    
    public String getBeaconSignal(){
        return "this is a beacon signal";
    }
    
    public String getNextBlock(){
        PublicBlock aNewBlock;
        prevBlock = this;
        //return aRandomBlock;
        return "will return a public block";
    }
    
    public int getNumPeopleAtStation(){
        return 0;
    }
    
    public boolean takePeopleAtStation(int NumPeopleToTake){
        if(isStation()){
            
        }
        return true;
    }
}
