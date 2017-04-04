package com.wonderfresh.mbo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author angie
 */

/**
 *
 * @author angie
 */
public class trainSchedule {
   
     int driverID[] =new int[50];
    mbotime[][] monday=new mbotime[7][2];
    mbotime[][] tuesday=new mbotime[7][2];
    mbotime[][] wednesday=new mbotime[7][2];
    mbotime[][] thursday=new mbotime[7][2];
    mbotime[][] friday=new mbotime[7][2];
    mbotime[][] saturday=new mbotime[7][2];
    mbotime[][] sunday=new mbotime[7][2];
    mbotime[][] timearr=new mbotime[50][8];
    String[][] arr=new String[50][8];
    
    
    public trainSchedule getTrainSchedule(int d, driverSchedule ds){
        trainSchedule t=new trainSchedule();
        int hours=d*40;
        int drivers=d;
        if (d<=0){
            System.out.println("\nNot Adequate number of drivers\n");
            return t=null;
        }
        
        return t;
    }
    
    public trainSchedule incrementTrainSchedule(trainSchedule ts, int incrementedMins, int incrementedSeconds){
        trainSchedule temp=new trainSchedule();
        
        int i=0, j=0;
        
        /**
 *   increments time when passed to function
 *   increments by inc in format hhmmss
 *   returns int endtime in format hhmmss
 * public mbotime increment(mbotime start,int inc){
 */   
        int increment=incrementedMins*100+incrementedSeconds;
        
        for (i=0;i<50;i++){//increment rows
            for(j=0;j<8;j++){//increment columns
                temp.timearr[i][j]=ts.timearr[i][j].increment(ts.timearr[i][j],increment);
            }
        }
       
        
        return temp;
    }
        
    

}
