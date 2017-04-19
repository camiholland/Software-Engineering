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
public class Edge {
    private Block from, to;
    private boolean open;
    private Beacon b = null;
    
    
    /**
     * 
     * @param one The first Block in the Edge
     * @param two The second Block in the Edge
     */
    public Edge(Block one, Block two){
        this(one,two,true);
    }
    
    /**
     * 
     * @param from the starting block
     * @param to the destination block
     * @param isOpen equivalent to the weight of the edge
     */
    public Edge(Block from, Block to, boolean isOpen){
        this.from = from;
        this.to = to;
        this.open = isOpen;
    }
    
    /**
     * 
     * @param current is the current block that the train is on
     * @return the Block object that the edge points to
     */
    public Block getNeighbor(Block current){
        if(!(current.equals(from) || current.equals(to))){
            return null;
        }
        return(current.equals(from)) ? to : from;
    }
    
    /**
     * Used to reference the current block 
     * @return the current block 
     */
    public Block getStartingBlock(){
        return this.from;
    }
    
    /**
     * Used to reference the next block in the edge
     * @return the destination block that the edge goes to
     */
    public Block getEndingBlock(){
        return this.to;
    }
    
    /**
     * To be used in comparing edges so as to pick open path.
     * Ultimately decided by Wayside Controller.
     * @return the open status where true means the track is open and false indicates a closed track.
     */
    public boolean getStatus(){
        return this.open;
    }
    
    public void setOpenOrClosed(boolean isOpen){
        this.open = isOpen;
    }
    
    public boolean isBetterThan(Edge other){
        if(this.open == true && other.open == false){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "({"+ this.from +", "+ this.to +"}, "+ this.open +")";
    }
    
    @Override
    public int hashCode(){
        return (from.getLabel() + to.getLabel()).hashCode();
    }
    
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Edge)){
            return false;
        }
        Edge e = (Edge)other;
        
        return e.from.equals(this.from) && e.to.equals(this.to);
    }
    
    public void setBeacon(Beacon a){
        this.b = a;
    }
    
    public Beacon getBeacon(){
        return this.b;
    }
}
