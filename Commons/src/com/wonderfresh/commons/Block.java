/*
 * @author Kevin Carr
 * @team Wonderfresh
 */

package com.wonderfresh.commons;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import static org.apache.commons.lang3.StringUtils.split;
import java.util.Iterator;

/**
 *
 * @author kwc12
 */
public class Block {
    private ArrayList<Edge> neighborhood;
    final private String line;
    final private String Section;
    final private int BlockNum;
    final private double BlockLength;
    final private double BlockGrade;
    final private int SpeedLimit;
    final private int SwitchBlock;
    final private boolean SwitchToYard;
    final private boolean SwitchFromYard;
    final private String ArrowDirection;
    final private boolean Underground;
    final private boolean Crossing;
    private boolean CrossingOpenToCars;
    private boolean Station_status;
    final private String Station;
    private int PeopleAtStation;
    private boolean Occupied;
     public boolean closed;
   
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
        this.Underground = infra.contains("UNDERGROUND");
        
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
        this.SwitchToYard = infra.contains("SWITCH") && infra.contains("TO") && infra.contains("YARD");
        
        this.SwitchFromYard = infra.contains("SWITCH") && infra.contains("FROM") && infra.contains("YARD");
        
        this.Crossing = infra.contains("RAILWAY CROSSING");
        
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
            this.PeopleAtStation = (int) (Math.random() * 301);
            
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
     * Saves a boolean value, true if block is a switch to the yard, false otherwise.
     * @return true for switch, false otherwise
     */
    public boolean isSwitchToYard(){
        return this.SwitchToYard;
    }
    
    /**
     * Saves a boolean value, true if block is a switch from the yard, false otherwise.
     * @return true for switch, false otherwise
     */
    public boolean isSwitchFromYard(){
        return this.SwitchFromYard;
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
    
    // Public Block stuff//////////////
    
    public boolean hasBeacon(){
        return false;
    }
    
    public String getBeaconSignal(){
        return "this is a beacon signal";
    }
    
    /**
     * The train model can use this function to move to the next block and see
     * its attributes. The implementer of this method is responsible for holding 
     * a block that holds the previous block that the train was on. This will be passed
     * into this method every time it is called. Previous Block should be instantiated with null.
     * @param prevBlock the block that preceded this current block
     * @return The next Public Block on the line.
     */
    public Block getNextBlock(Block prevBlock){
        // First if the block is the first block, if prevBlock is null then move to the next block.
        // If current block is switch, next block in switch.
        // If current block isn't switch or first block, take the difference in block num for direction and find the next block
        
        Block newBlock;
        Block tempBlock = null;
        Edge tempEdge;
        
        if(prevBlock==null){
            ArrayList<Edge> neighbors = this.getNeighbors();
            Iterator<Edge> neighborIterator = neighbors.iterator();
            if(neighbors.isEmpty()){
                System.out.println("The array list is empty.");
            }
            if(neighborIterator.hasNext()){
                tempEdge = neighborIterator.next();
                tempBlock = tempEdge.getEndingBlock();
            }
            newBlock = tempBlock;
            return newBlock;
            
        }else{
                    
            ArrayList<Edge> neighbors = this.getNeighbors();
            Iterator<Edge> neighborIterator = neighbors.iterator();
            while(neighborIterator.hasNext()){
                tempEdge = neighborIterator.next();
                if(tempEdge.getStatus()){
                    tempBlock = tempEdge.getEndingBlock();
                    if((tempBlock.getBlockNum()-prevBlock.getBlockNum())!=0){
                        break;
                    }
                }
            }
            newBlock = tempBlock;
            
            return newBlock;
            
        }
    }
    
    public int getNumPeopleAtStation(){
        return PeopleAtStation;
    }
    
    public boolean takePeopleAtStation(int NumPeopleToTake){
        if(isStation()){
            
        }
        return true;
    }
   public boolean closeBlock(){
        return this.closed=true;
    }
    public boolean openBlock(){
        return this.closed=false;
    }
}
