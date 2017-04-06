/*
 * @author Kevin Carr
 * @team Wonderfresh
 */

package com.wonderfresh.trackmodel;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import static org.apache.commons.lang3.StringUtils.split;
import java.lang.Math;

/**
 *
 * @author kwc12
 */
public class Block {
    private ArrayList<Edge> neighborhood;
    private String line;
    private String Section;
    private int BlockNum;
    private double BlockLength;
    private double BlockGrade;
    private int SpeedLimit;
    private int SwitchBlock;
    private boolean StaticBlock;
    private String ArrowDirection;
    private boolean Underground;
    private boolean Crossing;
    private boolean CrossingOpenToCars;
    private boolean Station_status;
    private String Station;
    private int PeopleAtStation;
    private boolean Occupied;
    
    public Block(){
        this.line = "Name of Line";
        this.Section = "Letter of Section";
        this.BlockNum = 0;
        this.BlockLength = 0.0;
        this.BlockGrade = 0.0;
        this.SpeedLimit = 0;
        this.SwitchBlock = 0;
        this.ArrowDirection = "No Current Arrow Direction";
        this.neighborhood = new ArrayList<>();
        this.Station_status = false;
        this.Station = "Not A Station";
        this.Crossing = false;
        this.Underground = false;
        this.PeopleAtStation = 0;
        this.Occupied = false;
    }
   
   /**
     *
     * @param line contains the name of the train line that the block resides in, ( Red or Green )
     * @param Section contains the letter of the track section that the block resides in.
     * @param num contains the the number of the block 
     * @param length contains the length of the block
     * @param grade contains the grade of the block as a double
     * @param speed contains the max allowable speed on the block as an integer
     * @param infra contains the string with any infrastructure components. Will be parsed and individual infrastructure variables will be updated.
     * @param switch_block contains the string the comes from the switch category
     * @param Arrow
     */
    
    public Block(String line, String Section, double num, double length, double grade, double speed, String infra, String switch_block, String Arrow){
        this.line = line;
        this.Section = Section;
        this.BlockNum = (int)num;
        this.BlockLength = length;
        this.BlockGrade = grade;
        this.SpeedLimit = (int)speed;
       
        // Adding the components of the infrastructure
        if(infra.contains("UNDERGROUND")){
            this.Underground = true;
        }else{
            this.Underground = false;
        }
        
        if(!switch_block.equals("")){
            // Regular Expression of any number
            Pattern p = Pattern.compile("\\d+");

            // Matcher that will look through string with given pattern
            Matcher m = p.matcher(switch_block);

            int temp = -1;

            // Loop parses through string while using the pattern matcher
            while(m.find()){

                // If a number is found, sets our temp int val to this number.
                temp = Integer.parseInt(m.group());
            }

            this.SwitchBlock = temp;
                        
        }
        else {
            
            this.SwitchBlock = -1;
            
        }
        
        // If the infrastructure category in the Excel file has SWITCH in it, this means it is the static switch.
        if(infra.contains("SWITCH")){
            this.StaticBlock = true;
        }else{
            this.StaticBlock = false;
        }
        
        if(infra.contains("RAILWAY CROSSING")){
            this.Crossing = true;
        }else{
            this.Crossing = false;
        }
        
        if(infra.contains("STATION")){
            
            String[] s_array = infra.split("\\s+");
            String station = "";
            int a = s_array.length;
            String[] cleaned_array = new String[a];
            boolean station_seen = false;
            boolean underground_seen = false;
            boolean switch_seen = false;
            boolean railway_seen = false;
            boolean crossing_seen = false;
            int p = 0;
            for(int i=0; i<a;i++){
                if(s_array[i].contains("UNDERGROUND") && underground_seen == false) {
                    underground_seen = true;
                }else if (s_array[i].contains("STATION") && station_seen == false){
                    station_seen = true;
                }else if (s_array[i].contains("SWITCH") && switch_seen == false){
                    switch_seen = true;
                }else if (s_array[i].contains("RAILWAY") && railway_seen == false){
                    railway_seen = true;
                }else if (s_array[i].contains("CROSSING") && crossing_seen == false){
                    crossing_seen = true;
                }else{
                    cleaned_array[p] = s_array[i];
                    p++;
                }
            }
            for(int k=0; k<a; k++){
                if(cleaned_array[k]!=null){
                    station = station.concat(cleaned_array[k].replaceAll(";", "")) + " ";
                }
            }
        
            this.Station = station;
            this.PeopleAtStation = (int)Math.random()*301;
            
        }else {
            this.Station = "Not A Station";
        }
        
        this.ArrowDirection = Arrow;
        this.neighborhood = new ArrayList<>();
    }
    
    /**
     * Each block holds a string representing the train line. 
     * @return the line the block is on
     */
    public String getLine(){
        return this.line;
    }
    
    /**
     * Each block holds a string representing the section it resides in.
     * @return the String representing the section of the track the block is on.
     */
    public String getSection(){
        return this.Section;
    }
    
    /**
     * Each block has a unique number on their respective line.
     * @return the block's unique number
     */
    public int getBlockNum(){
        return this.BlockNum;
    }
    
    /**
     * Each block holds a variable with its length.
     * @return the length of the block
     */
    public double getBlockLength(){
        return this.BlockLength;
    }
    
    /**
     * Each block holds a variables with its grade.
     * @return the grade of the block as a double
     */
    public double getBlockGrade(){
        return this.BlockGrade;
    }
    
    /**
     * Each block has a maximum speed that trains can travel on it.
     * @return the speed limit of the block
     */
    public int getSpeedLimit(){
        return this.SpeedLimit;
    }
    
    /**
     * Some blocks are members of a switch. Switches have unique numbers.
     * @return either the number of the switch or -1 if no switch.
     */
    public int getSwitchBlock(){
        return this.SwitchBlock;
    }
    
    /**
     * Saves a boolean value, true if block is a static switch, false otherwise.
     * @return true for switch, false otherwise
     */
    public boolean isStaticBlock(){
        return this.StaticBlock;
    }
    
    /**
     * Saves a boolean value true if block has train on it.
     * @return true for occupied, false otherwise
     */
    public boolean isOccupied(){
        return this.Occupied;
    }
    
    /**
     * Any time a train gets a new block, this function should be called with true.
     * Any time a train leaves a block, this function should be called with false.
     * @param status True if block is now occupied, false if now unoccupied.
     */
    public void setOccupied(boolean status){
        this.Occupied = status;
    }
    
    /**
     * 
     * @return 
     */
    public String getArrowDirection(){
        return this.ArrowDirection;
    }
    
    public void addNeighbor(Edge edge){
        if(this.neighborhood.contains(edge)){
            return;
        }
        this.neighborhood.add(edge);
    }
    
    public boolean containsNeighbor(Edge other){
        return this.neighborhood.contains(other);
    }
    
    public Edge getNeighbor(int index){
        return this.neighborhood.get(index);
    }
    
    public int getNeighborCount(){
        return this.neighborhood.size();
    }
    
    public String getLabel(){
        return this.line + this.BlockNum;
    }
    
    @Override
    public String toString(){
        return line + "\t\t" + Section + "\t\t" + (int)BlockNum + "\t\t" + BlockLength + "\t\t" + BlockGrade + "\t\t" + (int)SpeedLimit + "\t\t" //
                + "\t\t" + SwitchBlock + "\t\t" + ArrowDirection;
    }
    
    @Override
    public int hashCode(){
        return this.getLabel().hashCode();
    }
    
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Block)){
            return false;
        }
        
        Block v = (Block)other;
        
        return this.getLabel().equals(v.getLabel());
    }
    
    public ArrayList<Edge> getNeighbors(){
        return new ArrayList<>(this.neighborhood);
    }
    
    public boolean isUnderground(){
        return this.Underground;
    }
    
    public boolean isCrossing(){
        return this.Crossing;
    }
    
    public void openCrossingToCars(boolean setting){
        this.CrossingOpenToCars = setting;
    }
    
    public boolean isStation(){
        return this.Station_status;
    }
}
