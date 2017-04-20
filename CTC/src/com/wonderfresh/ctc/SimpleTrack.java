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
    
    //internal representation of track
    //necessary because the display table swaps lines
    //0 is green, 1 is red
    //block id, open, setspeed, authority, speed limit, crossing, light
    int[][] blockids;
    boolean[][] blockopenarray;
    double[][] currsetspeeds;
     double[][] currauthorities;
    double[][] speedlimits;
    boolean[][] crossings;
    boolean[][] lights;
    
    
    public SimpleTrack() {
        
    }
    
    public void loadTrack() {
        tracksimulator=TrackSimulator.getInstance();
        mytrack=tracksimulator.getTrack();
        redLine=mytrack.getRedLine();
        greenLine=mytrack.getGreenLine();
        //blocks are numbered starting at 1
    }
}
