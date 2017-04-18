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
    
    /**
     * This function provides the user with the first block of the respective track line
     * @return a Block
     */
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
    
    /**
     * For TrackModel only. Will add an edge to the graph from Block 'one' to
     * Block 'two'. Will set to open automatically.
     * @param one block to extend edge from
     * @param two block to extend edge to
     * @return true if successfully added to graph, false otherwise
     */
    public boolean addEdge(Block one, Block two){
        return addEdge(one,two, true);
    }
    
    /**
     * For TrackModel only. Will add an edge to the graph from Block 'from' to
     * Block 'to'. Can set to open or closed with the parameter OoC.
     * @param from the Block to extend the edge from 
     * @param to the Block to extend the edge to
     * @param OoC true if edge is open, false if closed.
     * @return true if successfully added, false otherwise
     */
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
    
    /**
     * Checks to see if an edge is contained within the graph
     * @param e the edge to search for
     * @return true if the edge exists, false if it doesn't
     */
    public boolean containsEdge(Edge e){
        if(e.getStartingBlock() == null || e.getEndingBlock() == null){
            return false;
        }
        
        return this.edges.containsKey(e.hashCode());
    }
    
    /**
     * Checks to see if a block is contained within the graph
     * @param block to search the graph for
     * @return true if it exists, false if not
     */
    public boolean containsBlock(Block block){
        return this.blocks.get(block.getLabel()) != null;
    }
    
    /**
     * Get a specific block from the specified graph
     * @param line a redundant argument, but should indicate the line to look in
     * @param BlockNum the number of the block to search
     * @return a Block if found, null if it doesn't exist
     */
    public Block getBlock(String line, int BlockNum){
        return blocks.get((line+BlockNum));
    }
    
    /**
     * Find out the number of blocks that make up the graph.
     * @return an integer of the number of blocks
     */
    public int getNumBlocks(){
        return blocks.size();
    }
    
    /**
     * For TrackModel use only. Adds a block to the graph.
     * @param block to add to graph
     * @param overwriteExisting true to overwrite a block with an equivalent label, false to not overwrite if an equivalent block exists
     * @return true if successfully added, false otherwise
     */
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
    
    /**
     * For TrackModel use only. Add a switch to the track graph.
     * @param MasterBlock 
     * @param PrimaryBlock
     * @param SecondaryBlock
     * @return 
     */
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
        ArrayList<Section> sectionList = new ArrayList<>();
        for(Section value : sections.values()){
            sectionList.add(value);
        }
        return sectionList;
    }
    
    /**
     * Get all the blocks in the graph in form of arrayList
     * @return ArrayList of Block type
     */
    public ArrayList<Block> getBlocks(){
        ArrayList<Block> blockList = new ArrayList<>();
        for(Block value : blocks.values()){
            blockList.add(value);
        }
        return blockList;
    }
    
    public ArrayList<Block> getOccupiedBlocks(){
        ArrayList<Block> blockList = new ArrayList<>();
        for(Block value : blocks.values()){
            if(value.isOccupied()){
                blockList.add(value);
            }
        }
        return blockList;
    }
      
    public Set<String> BlockKeys(){
        return this.blocks.keySet();
    }
    
    public Set<Edge> getEdges(){
        return new HashSet<>(this.edges.values());
    }
}
