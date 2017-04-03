/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo;

/**
 *
 * @author angie
 */
class BetaEdge {
    
    private BetaBlock from, to;
    private String OpenOrClosed;
    /**
     * 
     * @param one The first BetaBlock in the BetaEdge
     * @param two The second BetaBlock in the BetaEdge
     */
    public BetaEdge(BetaBlock one, BetaBlock two){
        this(one,two,"closed");
    }
    
    public BetaEdge(BetaBlock from, BetaBlock to, String OoC){
        this.from = from;
        this.to = to;
        this.OpenOrClosed = OoC;
    }
    
    public BetaBlock getNeighbor(BetaBlock current){
        if(!(current.equals(from) || current.equals(to))){
            return null;
        }
        return(current.equals(from)) ? to : from;
    }
    
    public BetaBlock getStartingBlock(){
        return this.from;
    }
    
    public BetaBlock getEndingBlock(){
        return this.to;
    }
    
    public String getStatus(){
        return this.OpenOrClosed;
    }
    
    public void setOpenOrClosed(String OoC){
        this.OpenOrClosed = OoC;
    }
    
    public boolean isBetterThen(BetaEdge other){
        if(this.OpenOrClosed.compareTo("open")==0 && other.OpenOrClosed.compareTo("closed")==0){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "({"+from+", "+to+"}, "+OpenOrClosed+")";
    }
    
    @Override
    public int hashCode(){
        return (from.getLabel() + to.getLabel()).hashCode();
    }
    
    @Override
    public boolean equals(Object other){
        if(!(other instanceof BetaEdge)){
            return false;
        }
        BetaEdge e = (BetaEdge)other;
        
        return e.from.equals(this.from) && e.to.equals(this.to);
    }
}
