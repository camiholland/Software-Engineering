/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.interfaces;
import com.wonderfresh.commons.mboSuggest;
import com.wonderfresh.commons.mboTrain;
import com.wonderfresh.commons.mboTrainDepartInfo;

/**
 *
 * @author angie
 */


public class MboInterfaceImpl implements MboInterface {

    
    String[][] closedBlocks; //[id][0 red || 1 green]
    mboTrain[] array;
    mboSuggest[] suggested;
    mboTrainDepartInfo[] info; 
    boolean mboMode;
    int dailyPassengers;
    
    public MboInterfaceImpl(){
       
    }
    @Override
    public void initialize(){
        mboTrain[] mytrains= new mboTrain[100];
        String[][] closedBlocks=new String[100][2];
        int i;
        for (i=0;i<100;i++){
            closedBlocks[i][0]=null;
            closedBlocks[i][1]=null;
            mboTrain a = new mboTrain();
            mytrains[i]=a;
            //System.out.println("i="+i);
            mytrains[i].metersInBlock=-1;
            mytrains[i].block=-1;
            mytrains[i].id=0;//0 in id for unused train
        }
        this.array=mytrains;
        
        
    }
    
   
    @Override
    public String[][] getClosedBlocks(){
        return closedBlocks;
    }
    
    @Override
    public void setUpdatedSpeedAuthority(int trainID, double speed, double authority){
        this.array=array;
        array[trainID].speed=speed;
        this.array[trainID].authority=authority;
       
    }
    public void setTrainDepartInfo(String station,String trainIDandDepartTime,mboTrainDepartInfo[] info, int id){
        this.info[id].station=station;
        this.info[id].trainIDAndDepart=trainIDandDepartTime;
        
    }
    @Override
    public mboTrain[] getDispatchedTrain(){
        
        return this.array;
    }
    @Override
    public mboTrain[] getUpdatedSpeedAuthority(){
        return this.array;
    }
    public mboTrainDepartInfo[] getTrainDepartInfo(){
        return info;
    }

    @Override
    public void setClosedBlocks(int block, String description, String line) {//0 red- 1 green
        if (line.compareToIgnoreCase("green")==0){
            closedBlocks[block][1]="closed";
        }
        else if(line.compareToIgnoreCase("red")==0){
            closedBlocks[block][0]="closed";
        }
        else{
            System.out.println("MboInterfaceImplementation: setClosedBlocks ERROR: Line must either be \"red\" or \"green\" ");
        }
    }


    @Override
    public void setLocation(int ID, int blockNum, int metersIn, boolean line) {
        if (line==true){
          this.array[ID].color="green";
          }
        else{
            this.array[ID].color="red";}
         this.array[ID].block=blockNum;
         this.array[ID].metersInBlock=metersIn;
         return ;
    }

    @Override
    public mboTrain[] getLocation() {
           return this.array;
    }

    @Override
    public void setSpeedAuthorityPassengerCount(int ID, double speed, double authority, int passengers) {
        this.array[ID].speed=speed;
        //this.array[ID].authority=authority;
        this.array[ID].number=passengers;
    }

    @Override
    public void setAuthority(int trainID, double authority) {
        this.array[trainID].authority=authority;
        
    }

    @Override
    public mboTrain[] getAuthority(mboTrain[] mbotrains) {
        return this.array;
                }

    @Override
    public void setMboMode(boolean mode) {
        if (mode==true){
            mboMode=true;
        }
        else{
            mboMode=false;
        }
    }


    @Override
    public void setOpenBlocks(int block, String description, String line) {//0 red- 1 green
        if (line.compareToIgnoreCase("green")==0){
            closedBlocks[block][1]=null;
        }
        else if(line.compareToIgnoreCase("red")==0){
            closedBlocks[block][0]=null;
        }
        else{
            System.out.println("MboInterfaceImplementation: setOpenBlocks ERROR: Line must either be \"red\" or \"green\" ");
        }
    }
        
        
        
        
    

    @Override
    public void addToDailyPassengers(int passengers) {
       dailyPassengers=dailyPassengers+passengers;

    }

    @Override
    public void setPassengersOnTrain(int trainID, int currentPassengers) {
        array[trainID].numPassengers=currentPassengers;
    }

    public int getDailyPassengers(){
        return dailyPassengers;
    }

    @Override
    public void setTrainDepartInfoGreen(String station, String trainIDandDepartTime, mboTrainDepartInfo[] info, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public mboTrainDepartInfo[] getTrainDepartInfoGreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTrainDepartInfoRed(String station, String trainIDandDepartTime, mboTrainDepartInfo[] info, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public mboTrainDepartInfo[] getTrainDepartInfoRed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDispatchedTrain(int trainID, double speed, double authority, mboTrain[] array) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTrain(int trainID) {
            array[trainID].id=-1;
    }

    @Override
    public void sendSuggestedSpeedAndAuthority(int trainID, double speed, double authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public mboSuggest[] getSuggestedSpeedAndAuthority() {//[100-trainid][Speed][Authority]
       return suggested;
    
    }

   
    

 
}


