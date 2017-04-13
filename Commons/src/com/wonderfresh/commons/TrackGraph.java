/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wonderfresh.commons;

import java.util.*;
/**
 *
 * @author kwc12
 */
public class TrackGraph {
    private HashMap<String, Block> blocks;
    private HashMap<Integer, Edge> edges;
    private HashMap<Integer, Switch> switches;
    private HashMap<Integer, Section> sections;
    private String TrackName;
    
    
    public TrackGraph(String Name){
        this.blocks = new HashMap<>();
        this.edges = new HashMap<>();
        this.switches = new HashMap<>();
        this.sections = new HashMap<>();
        this.TrackName = Name;
    }
    
    public TrackGraph(ArrayList<Block> blocks){
        this.blocks = new HashMap<>();
        this.edges = new HashMap<>();
        this.switches = new HashMap<>();
        this.sections = new HashMap<>();
        
        for(Block v: blocks){
            this.blocks.put(v.getLabel(), v);
        }
    }
    
    public Block init(){
        int yardSwitch = 0;
        for(String key : blocks.keySet()){
            if(blocks.get(key).isSwitchFromYard()){
                yardSwitch = blocks.get(key).getSwitchBlock();
                break;
            }
        }
        Block[] switch_Blocks = new Block[3];
        int BlockCount = 0;
        for(String key : blocks.keySet()){
            if(blocks.get(key).getSwitchBlock()==yardSwitch){
                switch_Blocks[BlockCount] = blocks.get(key);
                BlockCount++;
            }
        }
        
        if(switch_Blocks[0].getSpeedLimit()<switch_Blocks[1].getSpeedLimit() && switch_Blocks[0].getSpeedLimit() < switch_Blocks[2].getSpeedLimit()){
            return switch_Blocks[0];
        }else if(switch_Blocks[1].getSpeedLimit()<switch_Blocks[0].getSpeedLimit() && switch_Blocks[1].getSpeedLimit() < switch_Blocks[2].getSpeedLimit()){
            return switch_Blocks[1];
        }else{
            return switch_Blocks[2];
        }
    }
    
    public boolean addEdge(Block one, Block two){
        return addEdge(one,two, true);
    }
    
    public boolean addEdge(Block from, Block to, boolean OoC){
        if(from.equals(to)){
            System.out.println("They are equal to in hash.");
            return false;
        }
        
        //ensures the Edge is not in the Graph
        
        Edge e = new Edge(from,to,OoC);
        
        if(edges.containsKey(e.hashCode())){
            //System.out.println("edge already contains key.");
            return false;
        }else if(from.containsNeighbor(e) || to.containsNeighbor(e)){
            //System.out.println("One or the other contains Neighbor e");
            return false;
        }
        
        edges.put(e.hashCode(), e);
        from.addNeighbor(e);
        //to.addNeighbor(e);
        return true;
    }
    
    public boolean containsEdge(Edge e){
        if(e.getStartingBlock() == null || e.getEndingBlock() == null){
            return false;
        }
        
        return this.edges.containsKey(e.hashCode());
    }
    
    public boolean containsBlock(Block block){
        return this.blocks.get(block.getLabel()) != null;
    }
    
    public Block getBlock(String line, int BlockNum){
        return blocks.get((line+BlockNum));
    }
    
    public boolean addBlock(Block block, boolean overwriteExisting){
        
        Block current = this.blocks.get(block.getLabel());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }else{
                blocks.put(block.getLabel(), block);
        
                return true;
            }
        }else{
            blocks.put(block.getLabel(), block);
            return true;
        }
            
    }
    
    public boolean addSwitch(Block MasterBlock, Block PrimaryBlock, Block SecondaryBlock){
        Switch realTemp = new Switch(MasterBlock, PrimaryBlock, SecondaryBlock);
        if(this.switches.containsKey(realTemp.hashCode())){
            return false;
        }else{
            switches.put(realTemp.hashCode(), realTemp);
            return true;
        }
        
    }
    
    public Switch getSwitch(Block firstBlock, Block secondBlock){
        for(Integer key : switches.keySet()){
            Switch TestSwitch = switches.get(key);
            if(TestSwitch.contains(firstBlock) && TestSwitch.contains(secondBlock)){
                return TestSwitch;
            }
        }
        return null;
    }
    
    public void addToSection(Block newBlock){
        if(newBlock==null){
            return;
        }
        String section_Name = newBlock.getSection();
  
        for(Section value : sections.values()){
            if(value.getSectionName().equals(section_Name)){
                value.addBlockToSection(newBlock);
                return;
            }
        }       
        
        Section newSection = new Section(section_Name);
        newSection.addBlockToSection(newBlock);
        sections.put(newSection.hashCode(), newSection);
        
        
    }
    
    @Override
    public String toString(){
        return this.TrackName;
    }
    
    public Section getSection(String requestedSection){
        return sections.get(requestedSection.hashCode());
    }
    
    public ArrayList<Section> getSections(){
        String[] sectionNames = new String[sections.size()];
        // Go through all sections and create string of their names for UI
        return null;
    }
      
    public Set<String> BlockKeys(){
        return this.blocks.keySet();
    }
    
    public Set<Edge> getEdges(){
        return new HashSet<>(this.edges.values());
    }
}
