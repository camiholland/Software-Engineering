/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wonderfresh.commons;
//import java.util.ArrayList;
//import com.wonderfresh.trackmodelUI.TrackModelUI;

import java.util.Iterator;
import java.util.Set;


/**
 *
 * @author kwc12
 */
public class TrackSimulator {
    private static TrackModel MainTrack;
    private static int lastTemp = 0;
    private static int Authority;
    private TrackModelUI gui=null;
    private static TrackSimulator instance = null;
    
    private TrackSimulator(){
        
    }
    
    public static TrackSimulator getInstance(){
        if(instance==null){
            instance = new TrackSimulator();
            instance.setNewTrack("Track Layout & Vehicle Data vF1.xlsx");
            TrackModel tempTrack = instance.getTrack();
            TrackGraph redGraph = tempTrack.getRedLine();
            
            Block firstBlock = redGraph.init();
            System.out.println(firstBlock.getLabel()+" "+firstBlock.getBlockLength()+" "+firstBlock.getBlockGrade()+" "+firstBlock.getArrowDirection()+" "+firstBlock.getSwitchBlock());
            
        }
        return instance;
    }
    
    public void launchUI(){
        gui = new TrackModelUI(); // GUI gui = new GUI() as well
       // gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
   
    
//    public static void run() throws Exception{
//        //dataFile = "Track Layout & Vehicle Data vF1.xlsx";
//        // GUI EVENTS
//        java.awt.EventQueue.invokeLater(new Runnable(){
//            @Override
//            public void run(){
//                new TrackModelUI().setVisible(true);
//                
//            }
//        });
//    }
//    
    public TrackModel getTrack(){
        return MainTrack;
    }
    
    public String setNewTrack(String newFile){
        MainTrack = new TrackModel();
            
            try{
                MainTrack.setDataFile(newFile);
                MainTrack.ExcelToJavaGraph();
                System.out.println("Just Ran ExcelToJavaGraph");
            }catch(Exception e){
                System.out.println("Failure!!");
                return "(Excel to Graph did not run properly.";
            }
       
        return "";
    }
    
    /**
     * Will set up the first block on a line for a new train
     * @param line the name of the line the train should be instantiated on
     * @return the first block of the track
     */
    public static Block initBlock(String line){
        TrackGraph tempTrack;
        if(line.equals("Red")){
            tempTrack = MainTrack.getRedLine();
        }else if(line.equals("Green")){
            tempTrack = MainTrack.getGreenLine();
        }else{
            return null;
        }
        return tempTrack.init();
    }
    
    public static boolean setAuthority(String line, int block, int Distance){
        Authority = Distance;
        return true;
    }

    
    public static boolean setSetPointSpeed(String line, int block, int speed){
        if(line.equals("Red")){
            instance.getTrack().getRedLine().getBlock("Red", block).setSetPointSpeed(speed);
            return true;
        }else if(line.equals("Green")){
            instance.getTrack().getGreenLine().getBlock("Green", block).setSetPointSpeed(speed);
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean setCrossing(String line, int BlockNum, boolean open){
        TrackGraph tempTrack;
        if(line.equals("Red")){
            tempTrack = MainTrack.getRedLine();
        }else{
            tempTrack = MainTrack.getGreenLine();
        }
        Block crossingBlock = tempTrack.getBlock(line, BlockNum);
        if(crossingBlock.isCrossing()){
            crossingBlock.openCrossingToCars(open);
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isSectionOccupied(String line, String Section){
        TrackGraph tempTrack;
        if(line.equals("Red")){
            tempTrack = MainTrack.getRedLine();
        }else{
            tempTrack = MainTrack.getGreenLine();
        }
        Section chosen_Section = tempTrack.getSection(Section);
        try{
            return chosen_Section.isOccupied();
        }catch(NullPointerException e){
            return false;
        }
    }
    
    public static boolean isBlockOccupied(String line, int blockNum){
        TrackGraph tempTrack;
        if(line.equals("Red")){
            tempTrack = MainTrack.getRedLine();
        }else{
            tempTrack = MainTrack.getGreenLine();
        }
        Block chosen_Block = tempTrack.getBlock(line, blockNum);
        return chosen_Block.isOccupied();
    }
    
    /**
     * The Wayside controller is expected to have a detailed understanding of the track 
     * when calling these functions.
     * @param line for choosing the track the switch resides on
     * @param BlockNum1 should be a block at a switch the Wayside Controller wishes to connect
     * @param BlockNum2 should be a block at the same switch as the the first Block.
     * @return true if successful, false if not a switch that includes both blocks
     */
    public static boolean setSwitch(String line, int BlockNum1, int BlockNum2){
        TrackGraph tempTrack;
        switch (line) {
            case "Red":
                tempTrack = MainTrack.getRedLine();
                break;
            case "Green":
                tempTrack = MainTrack.getGreenLine();
                break;
            default:
                return false;
        }
        Block testBlock1 = tempTrack.getBlock(line, BlockNum1);
        Block testBlock2 = tempTrack.getBlock(line, BlockNum2);
        Switch tempSwitch = tempTrack.getSwitch(testBlock1, testBlock2);
        if(tempSwitch==null){
            return false;
        }else{
            tempSwitch.SetSwitchTo(testBlock1, testBlock2);
            return true;
        }
    }
    
    public static int getTemp(){
        return lastTemp;
    }
}
