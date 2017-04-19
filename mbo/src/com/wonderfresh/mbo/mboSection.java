
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
    
    
    
    public mboSection[] newSection(mboSection[] sections,String secID, double secLength, double secMaxSpeed, int secNumBlocks, int secNumStation, Block[] secBlocks, String secNextID){
        mboSection[] sectionArray=sections;
        ID=secID;
        length=secLength;
        maxSpeed=secMaxSpeed;
        numBlocks=secNumBlocks;
        blockStation=secNumStation;
        nextID=secNextID;
        blocks=secBlocks;
        return sectionArray;
    }
    public mboSection[] addBlock(mboSection[] sections, String section, int blockNum , Block block){
        mboSection[] sectionArray=sections;
        
        
        return sectionArray;
    }
    
    
}
