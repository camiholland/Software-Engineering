/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.interfaces;

/**
 *
 * @author Austin
 */
public class Interfaces {
    
    private static TrainModelAPI trainModelAPI = null;
    private static TrainControllerInterface trainControllerInterface = null;
    
    /*
    private static TrackModelInterface trainModelInterface = null;
    private static TrackControllerInterface trackControllerInterface = null;
    private static MBOInterface mboInterface = null;
    private static CTCInterface ctcInterface = null;
    private static CommunicationsInterface communicationsInterface = null;
    */
    
    public static void setTrainModelInterface(TrainModelAPI api) {
        trainModelAPI = api;
    }
    
    public static TrainModelAPI getTrainModelInterface() {
        
        if (trainModelAPI == null) {
            trainModelAPI = new TestingTrainModelAPI();
        }
        
        return trainModelAPI;
    }
    
    
    public static void setTrainControllerInterface(TrainControllerInterface api) {
        trainControllerInterface = api;
    }
    
    public static TrainControllerInterface getTrainControllerInterface() {
        
        if (trainControllerInterface == null) {
            trainControllerInterface = new TestingTrainControllerInterface();
        }
        
        return trainControllerInterface;
    }
    
    /*
    public static void setTrackModelInterface(TrackModelInterface api) {
        trackModelInterface = api;
    }
    
    public static TrackModelInterface getTrackModelInterface() {
        
        if (trackModelInterface == null) {
            trackModelInterface = new TestingTrackModelInterface();
        }
        
        return trackModelInterface;
    }
    
    public static void setTrackControllerInterface(TrackControllerInterface api) {
        trackControllerInterface = api;
    }
    
    public static TrackControllerInterface getTrackControllerInterface() {
        
        if (trackControllerInterface == null) {
            trackControllerInterface = new TestingTrackControllerInterface();
        }
        
        return trackControllerInterface;
    }
    
    public static void setMBOInterface(MBOInterface api) {
        mboInterface = api;
    }
    
    public static MBOInterface getMBOInterface() {
        
        if (mboInterface == null) {
            mboInterface = new TestingMBOInterface();
        }
        
        return mboInterface;
    }
    
    public static void setCTCInterface(CTCInterface api) {
        ctcInterface = api;
    }
    
    public static CTCInterface getCTCInterface() {
        
        if (ctctInterface == null) {
            ctcInterface = new TestingCTCInterface();
        }
        
        return ctcInterface;
    }
    
    public static void setCommunicationsInterface(CommunicationsInterface api) {
        communicationsInterface = api;
    }
    
    public static CommunicationsInterface getComunicationsInterface() {
        
        if (communicationsInterface == null) {
            communicationsInterface = new TestingCommunicationsInterface();
        }
        
        return communicationsInterface;
    }
    */
    
}
