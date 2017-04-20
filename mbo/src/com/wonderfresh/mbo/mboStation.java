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
    mboStation next=null;
    double authorityToNext=-1;
    double authorityToYard=-1;
    double speedToNext=-1;
    
    public mboStation(){
        
    }
    public void addStation(int block, String name,mboStation next, double authorityToNext, double authorityToYard, double speedToNext){
        this.block=block;
        this.name=name;
        this.authorityToNext=authorityToNext;
        this.authorityToYard=authorityToYard;
        this.speedToNext=speedToNext;
        return;
    }
    public mboStation[] initGreenStations(){
        mboStation[] list=new mboStation[14];
        int i=0;
        for(i=0;i<14;i++){
            list[i].addStation(block, name, next, authorityToNext, authorityToYard, speedToNext);
        }
        list[0].name="yard";
        list[1].name="GLENBURY";//K
        list[2].name="DORMONT";//L
        list[3].name="MT LEBANON";//N
        list[4].name="POPLAR";//O
        list[5].name="CASTLE SHANNON";//P
        list[6].name="OVERBROOK";//W
     /*   list[7].name="";//F
        list[8].name=
        list[9].name=
        list[10].name=
        list[11].name=
        list[12].name=
        list[13].name=
       */         
                
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
    
}
