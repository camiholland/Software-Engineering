/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.commons;

/**
 *
 * @author kwc12
 */
class Beacon {
    private String station;
    private double distance;
    
    public Beacon(String station){
        this.station = station;
    }
    
    public String getSignal(){
        return station+distance;
    }
    
    public void setStation(String station){
        this.station = station;
    }
    
    private void setDistance(double len){
        this.distance = len;
    }
}
