/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.mbo;

/**
 *
 * @author angie
 */
public class mboStation {
    int block=-1;
    String name="-";
    String next=null;
    double authorityToNext=-1;
    double authorityToYard=-1;
    double speedToNext=-1;
    
    public mboStation(){
        
    }
    public void addStation(int block, String name,String next, double authorityToNext, double authorityToYard, double speedToNext){
        this.block=block;
        this.name=name;
        this.authorityToNext=authorityToNext;
        this.authorityToYard=authorityToYard;
        this.speedToNext=speedToNext;
        return;
    }
    public mboStation[] initGreenStations( mboSection[] gr){
        mboStation[] list=new mboStation[14];
        int i=0;
        for(i=0;i<14;i++){
            list[i].addStation(block, name, next, authorityToNext, authorityToYard, speedToNext);
        }
        
        //set to infinite loop;
        list[0].name="YARD";
            list[0].next="GLENBURY";
            list[0].authorityToNext=100;
            list[0].block=getBlock(list[0].name,"green",gr);
        list[1].name="GLENBURY";//K
            list[1].next="DORMONT";
        list[2].name="DORMONT";//L
            list[2].next="MT LEBANON";
        list[3].name="MT LEBANON";//N
            list[3].next="POPLAR";//O
        list[4].name="POPLAR";//O
            list[4].next="CASTLE SHANNON";//P
        list[5].name="CASTLE SHANNON";//P
            list[5].next="OVERBROOK";//W
        list[6].name="OVERBROOK";//W
            list[6].next="INGLEWOOD";//W
        list[7].name="INGLEWOOD";//W
            list[7].next="CENTRAL";//W
        list[8].name="CENTRAL";//W
            list[8].next="WHITED";//F
        list[9].name="WHITED";//F
            list[9].next="UNIVERSITY OF PITTSBURGH";//D
        list[10].name="UNIVERSITY OF PITTSBURGH";//D
            list[10].next="EDGEBROOK";//C
        list[11].name="EDGEBROOK";//C
            list[11].next="PIONEER";//A
        list[12].name="PIONEER";//A
            list[12].next="GLENBURY";//K
               
                
                return list;
    }
     public mboStation[] initRedStations(){
        mboStation[] list=new mboStation[9];
        int i=0;
        for(i=0;i<14;i++){
            list[i].addStation(block, name, next, authorityToNext, authorityToYard, speedToNext);
        }
        return list;
    }

    private int getBlock(String name, String line, mboSection[] secs) {
        int b=0,low=0,high=0;
        int i;
        for(i=0;i<1000;i++){
            String temp=secs[i].station;
            if (name.compareToIgnoreCase(temp)==0){
                b=secs[i].blockStation;
                low=secs[i].lowBlock;
                high=secs[i].highBlock;
                i=10001;
            }
        
        }
        return b;
        
    }
}
