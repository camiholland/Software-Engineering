
package com.wonderfresh.mbo;

import com.wonderfresh.commons.Block;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class mboSection {
    
    
    String ID="0";
    double length=0;
    double maxSpeed=0;
    int numBlocks=0;
    int blockStation=0;
    Block[] blocks=new Block[20];   //MAX 20 BLOCKS PER SECTION
    String nextID="0";
    int lowBlock=-1;
    int highBlock=-1;
    boolean hasStation=false;
    String station="";
    double lengthToStation=-1;
    double lengthFromStation=-1;
    
    public mboSection(){
        
    }
    
    public mboSection[] newSection(mboSection[] sections,String secID,  double secMaxSpeed, int secNumBlocks, int secNumStation, Block[] secBlocks, String secNextID){
        mboSection[] sectionArray=sections;
        ID=secID;
        //length=secLength;
        maxSpeed=secMaxSpeed;
        numBlocks=secNumBlocks;
        blockStation=secNumStation;
        nextID=secNextID;
        blocks=secBlocks;
        return sectionArray;
    }
    public mboSection[] addLowHigh(mboSection[] sec,String section, int low, int high, int numBlocks){
        int i=0;
        for(i=0;i<numBlocks;i++){
            if(sec[i].ID!=null){
                if(sec[i].ID.compareToIgnoreCase(section)==0){
                    sec[i].lowBlock=low;
                    sec[i].highBlock=high;}
                }
          }
        return sec;
    }
    public mboSection[] addBlock(mboSection[] sections, String section, int blockNum , Block block){
        mboSection[] sectionArray=sections;
        
        
        return sectionArray;
    }
    
    
}
