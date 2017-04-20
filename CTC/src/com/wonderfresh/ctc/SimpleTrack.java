package com.wonderfresh.ctc;

import com.wonderfresh.commons.Block;
import com.wonderfresh.commons.TrackGraph;
import com.wonderfresh.commons.TrackModel;
import com.wonderfresh.commons.TrackSimulator;

 //@author Sarah
public class SimpleTrack {
    TrackSimulator tracksimulator;
    TrackModel mytrack;
    TrackGraph redLine;
    TrackGraph greenLine;
    
    public SimpleTrack() {
        
    }
    
    public void loadTrack() {
        int i;
        
//        Block greenBlocks[];
//        Block redBlocks[];
        
        tracksimulator=TrackSimulator.getInstance();
        mytrack=tracksimulator.getTrack();
        redLine=mytrack.getRedLine();
        greenLine=mytrack.getGreenLine();
        
        //get separate blocks for each line
//        greenBlocks = new Block[mytrack.getGreenCount()];
//        for (i=0;i<mytrack.getGreenCount();i++) {
//            greenBlocks[i] = greenLine.getBlock("green", i);
//        }
//        
//        redBlocks = new Block[mytrack.getGreenCount()];
//        for (i=0;i<mytrack.getGreenCount();i++) {
//            redBlocks[i] = greenLine.getBlock("green", i);
//        }
    }
}
