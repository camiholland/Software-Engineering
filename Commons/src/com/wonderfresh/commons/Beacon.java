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
    private int side;
    
    public Beacon(String station){
        this.station = station;
    }
    
    public String[] getSignal(){
        String[] newArray = new String[3];
        newArray[0] = this.station;
        newArray[1] = Double.toString(this.distance);
        newArray[2] = Integer.toString(this.side);
        
        return newArray;
    }
    
    public void setStation(String station){
        this.station = station;
    }
    
    private void setDistance(double len){
        this.distance = len;
    }
    
    private void setSide(int n){
        this.side = n;
    }
}
