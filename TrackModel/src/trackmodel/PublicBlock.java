/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trackmodel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author kwc12
 */
public class PublicBlock extends Block{
    
    private boolean BeaconPresent;
    private String Signal; // For beacon
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
    
    /**
     * The train model can use this function to move to the next block and see
     * its attributes.
     * @return The next Public Block on the line.
     */
    public PublicBlock getNextBlock(){
        // First if the block is the first block, if prevBlock is null then move to the next block.
        // If current block is switch, next block in switch.
        // If current block isn't switch or first block, take the difference in block num for direction and find the next block
        
        PublicBlock newBlock;
        Block tempBlock = null;
        Edge tempEdge;
        
        if(this.prevBlock==null){
            ArrayList<Edge> neighbors = this.getNeighbors();
            Iterator<Edge> neighborIterator = neighbors.iterator();
            if(neighborIterator.hasNext()){
                tempEdge = neighborIterator.next();
                tempBlock = tempEdge.getEndingBlock();
            }
            newBlock = (PublicBlock)tempBlock;
            newBlock.prevBlock = this;
            return newBlock;
            
        }else{
                    
            ArrayList<Edge> neighbors = this.getNeighbors();
            Iterator<Edge> neighborIterator = neighbors.iterator();
            while(neighborIterator.hasNext()){
                tempEdge = neighborIterator.next();
                if(tempEdge.getStatus()){
                    tempBlock = tempEdge.getEndingBlock();
                    if((tempBlock.getBlockNum()-this.prevBlock.getBlockNum())!=0){
                        break;
                    }
                }
            }
            newBlock = (PublicBlock)tempBlock;
            newBlock.prevBlock = this;
            
            return newBlock;
            
        }
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
