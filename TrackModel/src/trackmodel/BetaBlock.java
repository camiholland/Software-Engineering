/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trackmodel;
import java.util.ArrayList;
/**
 * This class models a Track Block as a vertex in a graph.
 * @author kwc12
 */
public class BetaBlock {
    private ArrayList<BetaEdge> neighborhood;
    final private String line;
    private String Section;
    final private int BlockNum;
    private double BlockLength;
    private double BlockGrade;
    private int SpeedLimit;
    private String Infrastructure;
    private String SwitchBlock;
    private String ArrowDirection;
    
    // Fields not yet implemented in the ExcelToJavaGraph() function in TrackModel
    private boolean Underground;
    private boolean Crossing;
   
    public BetaBlock(String line, String Section, double num, double length, double grade, double speed, String infra, String sblock, String Arrow){
        this.line = line;
        this.Section = Section;
        this.BlockNum = (int)num;
        this.BlockLength = length;
        this.BlockGrade = grade;
        this.SpeedLimit = (int)speed;
        this.Infrastructure = infra;
        this.SwitchBlock = sblock;
        this.ArrowDirection = Arrow;
        this.neighborhood = new ArrayList<>();
    }
    
    public String getLine(){
        return this.line;
    }
    
    public String getSection(){
        return this.Section;
    }
    
    public int getBlockNum(){
        return this.BlockNum;
    }
    
    public double getBlockLength(){
        return this.BlockLength;
    }
    
    public double getBlockGrade(){
        return this.BlockGrade;
    }
    
    public int getSpeedLimit(){
        return this.SpeedLimit;
    }
    
    public String getInfraStructure(){
        return this.Infrastructure;
    }
    
    public String getSwitchBlock(){
        return this.SwitchBlock;
    }
    
    public String getArrowDirection(){
        return this.ArrowDirection;
    }
    
    public void addInfraStructure(String infra){
        this.Infrastructure = infra;
    }
    
    public void addSwitchBlock(String sblock){
        this.SwitchBlock = sblock;
    }
    
    public void addArrowDirection(String arrow){
        this.ArrowDirection = arrow;
    }
    
    public void addNeighbor(BetaEdge edge){
        if(this.neighborhood.contains(edge)){
            return;
        }
        this.neighborhood.add(edge);
    }
    
    public boolean containsNeighbor(BetaEdge other){
        return this.neighborhood.contains(other);
    }
    
    public BetaEdge getNeighbor(int index){
        return this.neighborhood.get(index);
    }
    
    public void removeNeighbor(BetaEdge e){
        this.neighborhood.remove(e);
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
                + Infrastructure + "\t\t" + SwitchBlock + "\t\t" + ArrowDirection;
    }
    
    @Override
    public int hashCode(){
        return this.line.hashCode();
    }
    
    @Override
    public boolean equals(Object other){
        if(!(other instanceof BetaBlock)){
            return false;
        }
        
        BetaBlock v = (BetaBlock)other;
        
        return this.getLabel().equals(v.getLabel());
    }
    
    public ArrayList<BetaEdge> getNeighbors(){
        return new ArrayList<>(this.neighborhood);
    }

    
    
    
    //////////////Needs to be set in other function ExceltoJavaGraph();
    
    /*
     * @parameter dark - True if underground, false if not
     * @return void
    */
    public void setUnderground(boolean dark){
            this.Underground = dark;
    }
    
    public boolean isUnderground(){
        return this.Underground;
    }
    
    public void setCrossing(boolean itCrosses){
        this.Crossing = itCrosses;
    }
    
    public boolean isCrossing(){
        return this.Crossing;
    }
    
}
