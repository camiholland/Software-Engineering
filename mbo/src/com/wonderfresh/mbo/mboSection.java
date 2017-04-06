
package com.wonderfresh.mbo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class mboSection {
    
    
    String ID;
    double length;
    double maxSpeed;
    int numBlocks;
    int numStation;
    mboBlock[] blocks;
    String nextID;
    
    
    public mboSection[] newSection(mboSection[] sections,String secID, double secLength, double secMaxSpeed, int secNumBlocks, int secNumStation, mboBlock[] secBlocks, String secNextID){
        mboSection[] sectionArray=sections;
        ID=secID;
        length=secLength;
        maxSpeed=secMaxSpeed;
        numBlocks=secNumBlocks;
        numStation=secNumStation;
        nextID=secNextID;
        blocks=new mboBlock[10];
        return sectionArray;
    }
    public mboSection[] addBlock(mboSection[] sections, String section, int blockNum , mboBlock block){
        mboSection[] sectionArray=sections;
        
        
        return sectionArray;
    }
    
    
}
