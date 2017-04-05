/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trackmodel;
//import java.util.ArrayList;
//import com.wonderfresh.trackmodelUI.TrackModelUI;

/**
 *
 * @author kwc12
 */
public class TrackSimulator {
    private static TrackModel MainTrack;
    private static int lastTemp = 0;
    private static int Authority;
    private static int Speed;
    
    public static void Run(){
        MainTrack = new TrackModel();
    }
    
    public static void main(String[] args) throws Exception{
        //dataFile = "Track Layout & Vehicle Data vF1.xlsx";
        // GUI EVENTS
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new TrackModelUI().setVisible(true);
                
            }
        });
    }
    
    public static TrackModel getTrack(){
        return MainTrack;
    }
    
    public static String setNewTrack(String newFile){
        MainTrack = new TrackModel();
        try{
            
            try{
                MainTrack.setDataFile(newFile);
                MainTrack.ExcelToJavaGraph();
            }catch(Exception e){
                return "(Excel to Graph did not run properly.";
            }
            
        }catch(Exception e){
            return "File isn't formatted correctly.";
        }
        return "";
    }
    
    public static PublicBlock initBlock(String line){
        TrackGraph tempTrack;
        if(line.equals("Red")){
            tempTrack = MainTrack.getRedLine();
        }else{
            tempTrack = MainTrack.getGreenLine();
        }
        Block a = tempTrack.init();
        PublicBlock b = (PublicBlock)a;
        return b;
    }
    
    public static boolean setNextAuthority(int Distance){
        Authority = Distance;
        return true;
    }
    
    public static int getNextAuthority(){
        return Authority;
    }
    
    public static boolean setNextSetPointSpeed(int speed){
        Speed = speed;
        return true;
    }
    
    public static int getNextSetPointSpeed(){
        return Speed;
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
        return chosen_Section.isOccupied();
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
    
    public boolean setSwitch(String line, int BlockNum1, int BlockNum2, boolean defaultSetting){
        TrackGraph tempTrack;
        if(line.equals("Red")){
            tempTrack = MainTrack.getRedLine();
        }else{
            tempTrack = MainTrack.getGreenLine();
        }
        Block testBlock1 = tempTrack.getBlock(line, BlockNum1);
        Block testBlock2 = tempTrack.getBlock(line, BlockNum2);
        Switch tempSwitch = tempTrack.getSwitch(testBlock1, testBlock2);
        if(tempSwitch==null){
            return false;
        }else{
            tempSwitch.SetSwitchTo(testBlock1, testBlock2, defaultSetting);
            return true;
        }
    }
    
    public static int getTemp(){
        return lastTemp;
    }
}
