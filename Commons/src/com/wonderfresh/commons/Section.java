/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wonderfresh.commons;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author kwc12
 */
public class Section {
    private String Section_Name;
    private String High_BlockNum_ArrowDirection;
    private Block High_Block;
    private String Low_BlockNum_ArrowDirection;
    private Block Low_Block;
    private ArrayList<Block> Included_Blocks;
    
   /**
    * This constructor takes the name that you want the section to be known as.
    * Suggested that you used the Section that the first block is a part of.
    * Try: ChosenBlock.getSection() as new parameter
    * @param name New name to the section.
    */
   public Section(String name){
       this.Section_Name = name;
   }
   
   /**
    * This function will add an additional block to the given section.
    * @param newBlock Block that you wish to add to the section.
    * @return true if successfully added, false if section already contains the block.
    */
   public boolean addBlockToSection(Block newBlock){
       if(!Included_Blocks.contains(newBlock)){
           if(Included_Blocks.isEmpty()){
               this.Section_Name = newBlock.getSection();
           }
           Included_Blocks.add(newBlock);
           if(Low_Block!=null){
                if(newBlock.getBlockNum()<=Low_Block.getBlockNum()){
                    Low_Block = newBlock;
                    Low_BlockNum_ArrowDirection = Low_Block.getArrowDirection();
                }
           }else{
               Low_Block = newBlock;
               Low_BlockNum_ArrowDirection = Low_Block.getArrowDirection();
           }
           if(High_Block!=null){
               if(newBlock.getBlockNum()>=High_Block.getBlockNum()){
                   High_Block = newBlock;
                   High_BlockNum_ArrowDirection = High_Block.getArrowDirection();
               }
           }else{
               High_Block = newBlock;
               High_BlockNum_ArrowDirection = High_Block.getArrowDirection();
           }
           return true;
       }else{
           return false;
       }
   }
   
   /**
    * This function will search through the blocks that make it up and check for occupancy.
    * @return true if train present, false otherwise
    */
   public boolean isOccupied(){
       Iterator<Block> SectionSifter = this.Included_Blocks.iterator();
       while(SectionSifter.hasNext()){
           Block nextBlock = SectionSifter.next();
           if(nextBlock.isOccupied()){
               return true;
           }
       }
       return false;
   }
   
   /**
    * A String combining the Arrow Directions at the lowest and highest block numbers is returned.
    * @return Arrow Direction
    */
   public String getArrowDirection(){
       if(this.Included_Blocks.size()==1){
           return this.Low_BlockNum_ArrowDirection;
       }
       return this.Low_BlockNum_ArrowDirection + this.High_BlockNum_ArrowDirection;
   }
   
   /**
    * The Arrow Direction of the lowest block number is returned.
    * @return Arrow Direction
    */
   public String getStartArrow(){
       if(this.Included_Blocks.size()==1){
           String temp = this.Low_BlockNum_ArrowDirection;
           if(temp.startsWith("Tail")){
               return "Tail";
           }
           else{
               return "Head";
           }
       }
       return this.Low_BlockNum_ArrowDirection;
   }
   
   /**
    * The Arrow Direction of the highest block number is returned.
    * @return Arrow Direction
    */
   public String getEndArrow(){
       if(this.Included_Blocks.size()==1){
           String temp = this.Low_BlockNum_ArrowDirection;
           if(temp.endsWith("Tail")){
               return "Tail";
           }else{
               return "Head";
           }
       }
       return this.High_BlockNum_ArrowDirection;
   }
   
   /**
    * Return the letter name of the given section
    * @return name of section
    */
   public String getSectionName(){
       return this.Section_Name;
   }
   
   /**
    * An ArrayList containing all of the blocks that reside within the chosen 
    * Section will be returned. 
    * @return an ArrayList of the blocks that make up the section
    */
   public ArrayList<Block> getBlockList(){
       return this.Included_Blocks;
   }
   
   public int getSize(){
       return this.Included_Blocks.size();
   }
   /**
    * 
    * @return 
    */
    @Override
   public int hashCode(){
       return this.Section_Name.hashCode();
   }
   
   @Override
   public boolean equals(Object other){
       if(!(other instanceof Section)){
           return false;
       }
       
       Section v = (Section)other;
       
       return this.Section_Name.equals(v.Section_Name);
   }
}
