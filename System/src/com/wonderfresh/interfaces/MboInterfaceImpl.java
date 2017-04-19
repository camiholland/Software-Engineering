/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.interfaces;
import com.wonderfresh.commons.mboTrain;
import com.wonderfresh.commons.mboTrainDepartInfo;

/**
 *
 * @author angie
 */
public class MboInterfaceImpl implements MboInterface {

/**
 *ewfwe
 * @author angie
 */
    String[] closedBlocks;
    mboTrain[] array;
    mboTrainDepartInfo[] info;
    
    public MboInterfaceImpl(){
       
    }
    public void initializeTrainArray(){
        mboTrain[] mytrains= new mboTrain[100];
        int i;
        for (i=0;i<100;i++){
            mboTrain a = new mboTrain();
            mytrains[i]=a;
            //System.out.println("i="+i);
            mytrains[i].metersInBlock=-1;
            mytrains[i].block=-1;
            mytrains[i].id=0;//0 in id for unused train
        }
        this.array=mytrains;
        
    }
    
    void setClosedBlocks(String[] closed){
        this.closedBlocks=closed;
    }
    @Override
    public String[] getClosedBlocks(){
        return closedBlocks;
    }
    
    @Override
    public mboTrain[] setDispatchedTrain(int trainID, double speed, double authority,mboTrain[] array){
        this.array[trainID].speed=speed;
        this.array[trainID].authority=authority;
        return this.array;
    }
    @Override
    public mboTrain[] setUpdatedSpeedAuthority(int trainID, double speed, double authority, mboTrain[] array){
        
        return this.array;
    }
    @Override
    public mboTrainDepartInfo[] setTrainDepartInfo(String station,String trainIDandDepartTime,mboTrainDepartInfo[] info, int id){
        this.info[id].station=station;
        this.info[id].trainIDAndDepart=trainIDandDepartTime;
        return this.info;
    }
    @Override
    public mboTrain[] getDispatchedTrain(){
        
        return this.array;
    }
    @Override
    public mboTrain[] getUpdatedSpeedAuthority(){
        return this.array;
    }
    @Override
    public mboTrainDepartInfo[] getTrainDepartInfo(){
        return info;
    }

    @Override
    public void setClosedBlocks(int block, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        this.array[ID].authority=authority;
        this.array[ID].number=passengers;
    }
    

 
}


