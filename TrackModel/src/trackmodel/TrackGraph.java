/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trackmodel;

import java.util.*;
/**
 *
 * @author kwc12
 */
public class TrackGraph {
    private HashMap<String, BetaBlock> blocks;
    private HashMap<Integer, BetaEdge> edges;
    
    
    public TrackGraph(){
        this.blocks = new HashMap<>();
        this.edges = new HashMap<>();
    }
    
    public TrackGraph(ArrayList<BetaBlock> blocks){
        this.blocks = new HashMap<>();
        this.edges = new HashMap<>();
        
        for(BetaBlock v: blocks){
            this.blocks.put(v.getLabel(), v);
        }
    }
    
    public boolean addEdge(BetaBlock one, BetaBlock two){
        return addEdge(one,two, "closed");
    }
    
    public boolean addEdge(BetaBlock from, BetaBlock to, String OoC){
        if(from.equals(to)){
            System.out.println("They are equal to in hash.");
            return false;
        }
        
        //ensures the Edge is not in the Graph
        
        BetaEdge e = new BetaEdge(from,to,OoC);
        
        if(edges.containsKey(e.hashCode())){
            System.out.println("edges already contains key.");
            return false;
        }else if(from.containsNeighbor(e) || to.containsNeighbor(e)){
            System.out.println("One or the other contains Neighbor e");
            return false;
        }
        
        edges.put(e.hashCode(), e);
        from.addNeighbor(e);
        to.addNeighbor(e);
        return true;
    }
    
    public boolean containsEdge(BetaEdge e){
        if(e.getStartingBlock() == null || e.getEndingBlock() == null){
            return false;
        }
        
        return this.edges.containsKey(e.hashCode());
    }
    
    /*
    public BetaEdge removeEdge(BetaEdge e){
        e.getStartingBlock().removeNeighbor(e);
        e.getEndingBlock().removeNeighbor(e);
        return this.edges.remove(e.hashCode());
    }*/
    
    public boolean containsBlock(BetaBlock block){
        return this.blocks.get(block.getLabel()) != null;
    }
    
    public BetaBlock getBlock(String label){
        return blocks.get(label);
    }
    
    public boolean addBlock(BetaBlock block, boolean overwriteExisting){
        BetaBlock current = this.blocks.get(block.getLabel());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }
            /*
            while(current.getNeighborCount() > 0){
                this.removeEdge(current.getNeighbor(0));
            }*/
        }
        
        blocks.put(block.getLabel(), block);
        
        return true;
    }
   /*
    public BetaBlock removeBlock(String label){
        BetaBlock v = blocks.remove(label);
        
        while(v.getNeighborCount() > 0){
            this.removeEdge(v.getNeighbor(0));
        }
        
        return v;
    }*/
    
    public Set<String> BetaBlockKeys(){
        return this.blocks.keySet();
    }
    
    public Set<BetaEdge> getEdges(){
        return new HashSet<>(this.edges.values());
    }
}
