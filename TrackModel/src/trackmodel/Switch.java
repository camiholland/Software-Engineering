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
 * @author Kevin Carr
 */
public class Switch {
    private Block MasterBlock;
    private Block PrimaryBlock;
    private Block SecondaryBlock;
    private boolean Default = true;
    
    public Switch(Block staticBlock){
        this(staticBlock, null, null);
    }
    
    public Switch(Block staticBlock, Block first, Block second){
        MasterBlock = staticBlock;
        PrimaryBlock = first;
        SecondaryBlock = second;
    }
    
    public void addPrimary(Block first){
        PrimaryBlock = first;
    }
    
    public void addSecondary(Block second){
        SecondaryBlock = second;
    }
    
    /**
     * Use this method to set the switch to link the two blocks and disconnect the other 
     * blocks currently connected.
     * @param block_one First block to connect
     * @param block_two Second block to connect
     */
    public void SetSwitchTo(Block block_one, Block block_two){
        
        if(block_one.equals(MasterBlock) && block_two.equals(PrimaryBlock)){
            setEdgeStatus(MasterBlock, PrimaryBlock, SecondaryBlock);
        }else if(block_one.equals(MasterBlock) && block_two.equals(SecondaryBlock)){
            setEdgeStatus(MasterBlock, SecondaryBlock, PrimaryBlock);
        }else if(block_one.equals(PrimaryBlock) && block_two.equals(MasterBlock)){
            setEdgeStatus(PrimaryBlock, MasterBlock, SecondaryBlock);
        }else if(block_one.equals(PrimaryBlock) && block_two.equals(SecondaryBlock)){
            setEdgeStatus(PrimaryBlock, SecondaryBlock, MasterBlock);
        }else if(block_one.equals(SecondaryBlock) && block_two.equals(MasterBlock)){
            setEdgeStatus(SecondaryBlock, MasterBlock, PrimaryBlock);
        }else{
            setEdgeStatus(SecondaryBlock, PrimaryBlock, MasterBlock);
        }
    }
    
    private void setEdgeStatus(Block ConnectOne, Block Connect2, Block Disconnect){
        
        Edge tempEdge;
        ArrayList<Edge> tempList_BlockOne = ConnectOne.getNeighbors();
        ArrayList<Edge> tempList_BlockTwo = Connect2.getNeighbors();
        Iterator<Edge> edgeIterator1 = tempList_BlockOne.iterator();
        Iterator<Edge> edgeIterator2 = tempList_BlockTwo.iterator();
        
        
        while(edgeIterator1.hasNext()){
            tempEdge = edgeIterator1.next();
            if(tempEdge.getEndingBlock().equals(Connect2)){
                tempEdge.setOpenOrClosed(true);
            }
            if(tempEdge.getEndingBlock().equals(Disconnect)){
                tempEdge.setOpenOrClosed(false);
            }
        }
        while(edgeIterator2.hasNext()){
            tempEdge = edgeIterator2.next();
            if(tempEdge.getEndingBlock().equals(ConnectOne)){
                tempEdge.setOpenOrClosed(true);
            }
            if(tempEdge.getEndingBlock().equals(Disconnect)){
                tempEdge.setOpenOrClosed(false);
            }
        }
    }
        
    public boolean isDefault(){
        return Default;
    }
    
    public boolean contains(Block TestBlock){
        if(TestBlock.equals(MasterBlock)){
            return true;
        }else if(TestBlock.equals(PrimaryBlock)){
            return true;
        }else if(TestBlock.equals(SecondaryBlock)){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        return (MasterBlock.getLabel()+PrimaryBlock.getLabel()+SecondaryBlock.getLabel()).hashCode();
    }
    
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Switch)){
            return false;
        }
        Switch e = (Switch)other;
        
        return e.MasterBlock.equals(this.MasterBlock) && 
                e.PrimaryBlock.equals(this.PrimaryBlock) &&
                e.SecondaryBlock.equals(this.SecondaryBlock);
    }
    
}
