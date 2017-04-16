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
    
    public String getSignal(){
        return station+distance;
    }
}
