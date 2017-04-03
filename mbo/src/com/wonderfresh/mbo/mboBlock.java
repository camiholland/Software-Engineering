
package com.wonderfresh.mbo;

public class mboBlock {
    int ID;
    double length;
    double speed;
    String Station;
    int IDnextBlock; 
  
    public static mboBlock[] makeBlock(int numBlocks){
        mboBlock b=new mboBlock();
        mboBlock blocks[]=new mboBlock[numBlocks];
        return blocks;
    }
}
