/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo;

/**
 *
 * @author angie
 */
class mboTrackModel {
    private static TrackGraph RedLine;
    private static TrackGraph GreenLine;
    private static int RedCount;
    private static int GreenCount;
    private String dataFile;
    private static int temp = 50;
    
    public mboTrackModel(){
        mboTrackModel.RedLine = new TrackGraph();
        mboTrackModel.GreenLine = new TrackGraph();
        mboTrackModel.RedCount = 0;
        mboTrackModel.GreenCount = 0;
    }
}
