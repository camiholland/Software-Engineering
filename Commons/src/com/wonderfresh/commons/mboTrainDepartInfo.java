/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.commons;

/**
 *
 * @author angie
 * //change to String Station and String for trainID and time
 */
public class mboTrainDepartInfo {
    
    public String station="-", station2="-",station3="-";
    public String trainIDAndDepart=" Nothing to Show "; // Train 1 : Departing 1:19 pm
    public mboTrainDepartInfo info[];
    
    public mboTrainDepartInfo(){
         }
    
    public mboTrainDepartInfo[] setmboTrainDepartInfo(String station, int ID, String departTime){
        mboTrainDepartInfo info[]=new mboTrainDepartInfo[100];
        
        
        return info;
    }
    public mboTrainDepartInfo[] getmboTrainDepartInfo(String station){
        mboTrainDepartInfo info[]=new mboTrainDepartInfo[10];
        return info;
    }
}
