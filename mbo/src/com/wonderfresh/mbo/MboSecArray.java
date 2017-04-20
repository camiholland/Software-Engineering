/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.mbo;

import com.wonderfresh.commons.Block;
import com.wonderfresh.commons.Section;
import com.wonderfresh.commons.TrackGraph;
import java.util.ArrayList;

/**
 *
 * @author angie
 */
public class MboSecArray{
    
    
     static mboSection[] get(int track, TrackGraph gr, TrackGraph red){
        ArrayList<Block> Included_Blocks;
        boolean checkStation=false;
        String stationName="  ";
        int time=0,itter,total=0;
        mboSection[] greenSections=new mboSection[28];
        mboSection[] redSections=new mboSection[28];
        double len=0, lowspeed=100;  //1 for green
        //red
        if (track==0){/**********RED**************/
                 Section A=new Section("A");
                    checkStation=false;
                    A=gr.getSection("A");
                    redSections[0].ID=A.getSectionName();
                    redSections[0].lowBlock=A.getLowestBlock().getBlockNum();
                    redSections[0].highBlock=A.getHighestBlock().getBlockNum();
                    Included_Blocks=A.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[0].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[0].length=len;
                    redSections[0].lengthFromStation=len-redSections[0].lengthToStation;
                    redSections[0].maxSpeed=lowspeed;
                    redSections[0].numBlocks=total;
                    redSections[0].station=stationName;
                    
                Section B=new Section("B");
                    checkStation=false;
                    B=gr.getSection("B");
                    redSections[1].ID=B.getSectionName();
                    redSections[1].lowBlock=B.getLowestBlock().getBlockNum();
                    redSections[1].highBlock=B.getHighestBlock().getBlockNum();
                    Included_Blocks=B.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[1].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[1].length=len;
                    redSections[1].lengthFromStation=len-redSections[1].lengthToStation;
                    redSections[1].maxSpeed=lowspeed;
                    redSections[1].numBlocks=total;
                    redSections[1].station=stationName;
                           
            Section C=new Section("C");
                    checkStation=false;
                    C=gr.getSection("C");
                    redSections[2].ID=C.getSectionName();
                    redSections[2].lowBlock=C.getLowestBlock().getBlockNum();
                    redSections[2].highBlock=C.getHighestBlock().getBlockNum();
                    Included_Blocks=C.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[2].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[2].length=len;
                    redSections[2].lengthFromStation=len-redSections[2].lengthToStation;
                    redSections[2].maxSpeed=lowspeed;
                    redSections[2].numBlocks=total;
                    redSections[2].station=stationName;
                    
              Section D=new Section("D");
                    checkStation=false;
                    D=gr.getSection("D");
                    redSections[3].ID=D.getSectionName();
                    redSections[3].lowBlock=D.getLowestBlock().getBlockNum();
                    redSections[3].highBlock=D.getHighestBlock().getBlockNum();
                    Included_Blocks=D.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[3].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[3].length=len;
                    redSections[3].lengthFromStation=len-redSections[3].lengthToStation;
                    redSections[3].maxSpeed=lowspeed;
                    redSections[3].numBlocks=total;
                    redSections[3].station=stationName;
                    
             Section E=new Section("E");
                    checkStation=false;
                    E=gr.getSection("E");
                    redSections[4].ID=E.getSectionName();
                    redSections[4].lowBlock=E.getLowestBlock().getBlockNum();
                    redSections[4].highBlock=E.getHighestBlock().getBlockNum();
                    Included_Blocks=E.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[4].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[4].length=len;
                    redSections[4].lengthFromStation=len-redSections[4].lengthToStation;
                    redSections[4].maxSpeed=lowspeed;
                    redSections[4].numBlocks=total;
                    redSections[4].station=stationName;
                    
              Section F=new Section("F");
                    checkStation=false;
                    F=gr.getSection("F");
                    redSections[5].ID=F.getSectionName();
                    redSections[5].lowBlock=F.getLowestBlock().getBlockNum();
                    redSections[5].highBlock=F.getHighestBlock().getBlockNum();
                    Included_Blocks=F.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[5].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[5].length=len;
                    redSections[5].lengthFromStation=len-redSections[5].lengthToStation;
                    redSections[5].maxSpeed=lowspeed;
                    redSections[5].numBlocks=total;
                    redSections[5].station=stationName;
             Section G=new Section("G");
                    checkStation=false;
                    G=gr.getSection("G");
                    redSections[6].ID=G.getSectionName();
                    redSections[6].lowBlock=G.getLowestBlock().getBlockNum();
                    redSections[6].highBlock=G.getHighestBlock().getBlockNum();
                    Included_Blocks=G.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[6].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[6].length=len;
                    redSections[6].lengthFromStation=len-redSections[6].lengthToStation;
                    redSections[6].maxSpeed=lowspeed;
                    redSections[6].numBlocks=total;
                    redSections[6].station=stationName;
            Section H=new Section("H");
                    checkStation=false;
                    H=gr.getSection("H");
                    redSections[7].ID=H.getSectionName();
                    redSections[7].lowBlock=H.getLowestBlock().getBlockNum();
                    redSections[7].highBlock=H.getHighestBlock().getBlockNum();
                    Included_Blocks=H.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[7].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[7].length=len;
                    redSections[7].lengthFromStation=len-redSections[7].lengthToStation;
                    redSections[7].maxSpeed=lowspeed;
                    redSections[7].numBlocks=total;
                    redSections[7].station=stationName;
              Section I=new Section("I");
                    checkStation=false;
                    I=gr.getSection("I");
                    redSections[8].ID=I.getSectionName();
                    redSections[8].lowBlock=I.getLowestBlock().getBlockNum();
                    redSections[8].highBlock=I.getHighestBlock().getBlockNum();
                    Included_Blocks=I.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[8].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[8].length=len;
                    redSections[8].lengthFromStation=len-redSections[8].lengthToStation;
                    redSections[8].maxSpeed=lowspeed;
                    redSections[8].numBlocks=total;
                    redSections[8].station=stationName;       
            
            Section J=new Section("J");
                    checkStation=false;
                    J=gr.getSection("J");
                    redSections[9].ID=J.getSectionName();
                    redSections[9].lowBlock=J.getLowestBlock().getBlockNum();
                    redSections[9].highBlock=J.getHighestBlock().getBlockNum();
                    Included_Blocks=J.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[9].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[9].length=len;
                    redSections[9].lengthFromStation=len-redSections[9].lengthToStation;
                    redSections[9].maxSpeed=lowspeed;
                    redSections[9].numBlocks=total;
                    redSections[9].station=stationName;//J_[9]
            Section K=new Section("K");
                    checkStation=false;
                    K=gr.getSection("K");
                    redSections[10].ID=K.getSectionName();
                    redSections[10].lowBlock=K.getLowestBlock().getBlockNum();
                    redSections[10].highBlock=K.getHighestBlock().getBlockNum();
                    Included_Blocks=K.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[10].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[10].length=len;
                    redSections[10].lengthFromStation=len-redSections[10].lengthToStation;
                    redSections[10].maxSpeed=lowspeed;
                    redSections[10].numBlocks=total;
                    redSections[10].station=stationName;//K_[10]
                      Section V=new Section("V");
                    checkStation=false;
                    V=gr.getSection("V");
                    redSections[11].ID=V.getSectionName();
                    redSections[11].lowBlock=V.getLowestBlock().getBlockNum();
                    redSections[11].highBlock=V.getHighestBlock().getBlockNum();
                    Included_Blocks=V.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[11].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[11].length=len;
                    redSections[11].lengthFromStation=len-redSections[11].lengthToStation;
                    redSections[11].maxSpeed=lowspeed;
                    redSections[11].numBlocks=total;
                    redSections[11].station=stationName;//V_[11]        
             Section L=new Section("L");
                    checkStation=false;
                    L=gr.getSection("L");
                    redSections[12].ID=L.getSectionName();
                    redSections[12].lowBlock=L.getLowestBlock().getBlockNum();
                    redSections[12].highBlock=L.getHighestBlock().getBlockNum();
                    Included_Blocks=L.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[12].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[12].length=len;
                    redSections[12].lengthFromStation=len-redSections[12].lengthToStation;
                    redSections[12].maxSpeed=lowspeed;
                    redSections[12].numBlocks=total;
                    redSections[12].station=stationName;//L_[12]       
             Section M=new Section("M");
                    checkStation=false;
                    M=gr.getSection("M");
                    redSections[13].ID=M.getSectionName();
                    redSections[13].lowBlock=M.getLowestBlock().getBlockNum();
                    redSections[13].highBlock=M.getHighestBlock().getBlockNum();
                    Included_Blocks=M.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[13].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[13].length=len;
                    redSections[13].lengthFromStation=len-redSections[13].lengthToStation;
                    redSections[13].maxSpeed=lowspeed;
                    redSections[13].numBlocks=total;
                    redSections[13].station=stationName;//M_[13]       
            Section N=new Section("N");
                    checkStation=false;
                    N=gr.getSection("N");
                    redSections[14].ID=N.getSectionName();
                    redSections[14].lowBlock=N.getLowestBlock().getBlockNum();
                    redSections[14].highBlock=N.getHighestBlock().getBlockNum();
                    Included_Blocks=N.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[14].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[14].length=len;
                    redSections[14].lengthFromStation=len-redSections[14].lengthToStation;
                    redSections[14].maxSpeed=lowspeed;
                    redSections[14].numBlocks=total;
                    redSections[14].station=stationName;//N_[14]        
           Section O=new Section("O");
                    checkStation=false;
                    O=gr.getSection("O");
                    redSections[15].ID=O.getSectionName();
                    redSections[15].lowBlock=O.getLowestBlock().getBlockNum();
                    redSections[15].highBlock=O.getHighestBlock().getBlockNum();
                    Included_Blocks=O.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[15].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[15].length=len;
                    redSections[15].lengthFromStation=len-redSections[15].lengthToStation;
                    redSections[15].maxSpeed=lowspeed;
                    redSections[15].numBlocks=total;
                    redSections[15].station=stationName;//O_[15]
                    
            Section P=new Section("P");
                    checkStation=false;
                    P=gr.getSection("P");
                    redSections[16].ID=P.getSectionName();
                    redSections[16].lowBlock=P.getLowestBlock().getBlockNum();
                    redSections[16].highBlock=P.getHighestBlock().getBlockNum();
                    Included_Blocks=P.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[16].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[16].length=len;
                    redSections[16].lengthFromStation=len-redSections[16].lengthToStation;
                    redSections[16].maxSpeed=lowspeed;
                    redSections[16].numBlocks=total;
                    redSections[16].station=stationName;//F_[16]        
            Section Q=new Section("Q");
                    checkStation=false;
                    Q=gr.getSection("Q");
                    redSections[17].ID=Q.getSectionName();
                    redSections[17].lowBlock=Q.getLowestBlock().getBlockNum();
                    redSections[17].highBlock=Q.getHighestBlock().getBlockNum();
                    Included_Blocks=Q.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[17].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[17].length=len;
                    redSections[17].lengthFromStation=len-redSections[17].lengthToStation;
                    redSections[17].maxSpeed=lowspeed;
                    redSections[17].numBlocks=total;
                    redSections[17].station=stationName;//Q_[17]
                    
            Section R=new Section("R");
                    checkStation=false;
                    R=gr.getSection("R");
                    redSections[18].ID=R.getSectionName();
                    redSections[18].lowBlock=R.getLowestBlock().getBlockNum();
                    redSections[18].highBlock=R.getHighestBlock().getBlockNum();
                    Included_Blocks=R.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[18].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[18].length=len;
                    redSections[18].lengthFromStation=len-redSections[18].lengthToStation;
                    redSections[18].maxSpeed=lowspeed;
                    redSections[18].numBlocks=total;
                    redSections[18].station=stationName;//D_[18]
                    
                    
            Section S=new Section("S");
                    checkStation=false;
                    S=gr.getSection("S");
                    redSections[19].ID=S.getSectionName();
                    redSections[19].lowBlock=S.getLowestBlock().getBlockNum();
                    redSections[19].highBlock=S.getHighestBlock().getBlockNum();
                    Included_Blocks=S.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[19].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[19].length=len;
                    redSections[19].lengthFromStation=len-redSections[19].lengthToStation;
                    redSections[19].maxSpeed=lowspeed;
                    redSections[19].numBlocks=total;
                    redSections[19].station=stationName;//S_[19]
                    
            Section T=new Section("T");
                    checkStation=false;
                    T=gr.getSection("T");
                    redSections[20].ID=T.getSectionName();
                    redSections[20].lowBlock=T.getLowestBlock().getBlockNum();
                    redSections[20].highBlock=T.getHighestBlock().getBlockNum();
                    Included_Blocks=T.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[20].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[20].length=len;
                    redSections[20].lengthFromStation=len-redSections[20].lengthToStation;
                    redSections[20].maxSpeed=lowspeed;
                    redSections[20].numBlocks=total;
                    redSections[20].station=stationName;//B_[20]
                    
            Section U=new Section("U");
                    checkStation=false;
                    U=gr.getSection("U");
                    redSections[21].ID=U.getSectionName();
                    redSections[21].lowBlock=U.getLowestBlock().getBlockNum();
                    redSections[21].highBlock=U.getHighestBlock().getBlockNum();
                    Included_Blocks=U.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // redSections=redSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                redSections[21].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    redSections[21].length=len;
                    redSections[21].lengthFromStation=len-redSections[21].lengthToStation;
                    redSections[21].maxSpeed=lowspeed;
                    redSections[21].numBlocks=total;
                    redSections[21].station=stationName;//U_[21]  
                    return redSections;
            
        }
        else{ /**********GREEN**************/
 
 /**  yard -k-l-m-n-o-p-q-n-r-s-t-u-v-w-x-y-z-f-e-d-c-b-a-d-e-f-g-h-i-(j-continue//zz-yard(leaving) or yy(coming in))**/
            
            
             Section K=new Section("K");
                    checkStation=false;
                    K=gr.getSection("K");
                    greenSections[0].ID=K.getSectionName();
                    greenSections[0].lowBlock=K.getLowestBlock().getBlockNum();
                    greenSections[0].highBlock=K.getHighestBlock().getBlockNum();
                    Included_Blocks=K.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[0].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[0].length=len;
                    greenSections[0].lengthFromStation=len-greenSections[0].lengthToStation;
                    greenSections[0].maxSpeed=lowspeed;
                    greenSections[0].numBlocks=total;
                    greenSections[0].station=stationName;
                    
                Section L=new Section("L");
                    checkStation=false;
                    L=gr.getSection("L");
                    greenSections[1].ID=L.getSectionName();
                    greenSections[1].lowBlock=L.getLowestBlock().getBlockNum();
                    greenSections[1].highBlock=L.getHighestBlock().getBlockNum();
                    Included_Blocks=L.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[1].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[1].length=len;
                    greenSections[1].lengthFromStation=len-greenSections[1].lengthToStation;
                    greenSections[1].maxSpeed=lowspeed;
                    greenSections[1].numBlocks=total;
                    greenSections[1].station=stationName;
                           
            Section M=new Section("M");
                    checkStation=false;
                    M=gr.getSection("M");
                    greenSections[2].ID=M.getSectionName();
                    greenSections[2].lowBlock=M.getLowestBlock().getBlockNum();
                    greenSections[2].highBlock=M.getHighestBlock().getBlockNum();
                    Included_Blocks=M.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[2].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[2].length=len;
                    greenSections[2].lengthFromStation=len-greenSections[2].lengthToStation;
                    greenSections[2].maxSpeed=lowspeed;
                    greenSections[2].numBlocks=total;
                    greenSections[2].station=stationName;
                    
              Section N=new Section("N");
                    checkStation=false;
                    N=gr.getSection("N");
                    greenSections[3].ID=N.getSectionName();
                    greenSections[3].lowBlock=N.getLowestBlock().getBlockNum();
                    greenSections[3].highBlock=N.getHighestBlock().getBlockNum();
                    Included_Blocks=N.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[3].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[3].length=len;
                    greenSections[3].lengthFromStation=len-greenSections[3].lengthToStation;
                    greenSections[3].maxSpeed=lowspeed;
                    greenSections[3].numBlocks=total;
                    greenSections[3].station=stationName;
                    
             Section O=new Section("O");
                    checkStation=false;
                    O=gr.getSection("O");
                    greenSections[4].ID=O.getSectionName();
                    greenSections[4].lowBlock=O.getLowestBlock().getBlockNum();
                    greenSections[4].highBlock=O.getHighestBlock().getBlockNum();
                    Included_Blocks=O.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[4].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[4].length=len;
                    greenSections[4].lengthFromStation=len-greenSections[4].lengthToStation;
                    greenSections[4].maxSpeed=lowspeed;
                    greenSections[4].numBlocks=total;
                    greenSections[4].station=stationName;
                    
              Section P=new Section("P");
                    checkStation=false;
                    P=gr.getSection("P");
                    greenSections[5].ID=P.getSectionName();
                    greenSections[5].lowBlock=P.getLowestBlock().getBlockNum();
                    greenSections[5].highBlock=P.getHighestBlock().getBlockNum();
                    Included_Blocks=P.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[5].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[5].length=len;
                    greenSections[5].lengthFromStation=len-greenSections[5].lengthToStation;
                    greenSections[5].maxSpeed=lowspeed;
                    greenSections[5].numBlocks=total;
                    greenSections[5].station=stationName;
             Section Q=new Section("Q");
                    checkStation=false;
                    Q=gr.getSection("Q");
                    greenSections[6].ID=Q.getSectionName();
                    greenSections[6].lowBlock=Q.getLowestBlock().getBlockNum();
                    greenSections[6].highBlock=Q.getHighestBlock().getBlockNum();
                    Included_Blocks=Q.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[6].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[6].length=len;
                    greenSections[6].lengthFromStation=len-greenSections[6].lengthToStation;
                    greenSections[6].maxSpeed=lowspeed;
                    greenSections[6].numBlocks=total;
                    greenSections[6].station=stationName;
                      Section R=new Section("R");
                    checkStation=false;
                    R=gr.getSection("R");
                    greenSections[7].ID=R.getSectionName();
                    greenSections[7].lowBlock=R.getLowestBlock().getBlockNum();
                    greenSections[7].highBlock=R.getHighestBlock().getBlockNum();
                    Included_Blocks=R.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[7].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[7].length=len;
                    greenSections[7].lengthFromStation=len-greenSections[7].lengthToStation;
                    greenSections[7].maxSpeed=lowspeed;
                    greenSections[7].numBlocks=total;
                    greenSections[7].station=stationName;
              Section S=new Section("S");
                    checkStation=false;
                    S=gr.getSection("S");
                    greenSections[8].ID=S.getSectionName();
                    greenSections[8].lowBlock=S.getLowestBlock().getBlockNum();
                    greenSections[8].highBlock=S.getHighestBlock().getBlockNum();
                    Included_Blocks=S.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[8].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[8].length=len;
                    greenSections[8].lengthFromStation=len-greenSections[8].lengthToStation;
                    greenSections[8].maxSpeed=lowspeed;
                    greenSections[8].numBlocks=total;
                    greenSections[8].station=stationName;       
            
            Section T=new Section("T");
                    checkStation=false;
                    T=gr.getSection("T");
                    greenSections[9].ID=T.getSectionName();
                    greenSections[9].lowBlock=T.getLowestBlock().getBlockNum();
                    greenSections[9].highBlock=T.getHighestBlock().getBlockNum();
                    Included_Blocks=T.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[9].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[9].length=len;
                    greenSections[9].lengthFromStation=len-greenSections[9].lengthToStation;
                    greenSections[9].maxSpeed=lowspeed;
                    greenSections[9].numBlocks=total;
                    greenSections[9].station=stationName;//T_[9]
            Section U=new Section("U");
                    checkStation=false;
                    U=gr.getSection("U");
                    greenSections[10].ID=U.getSectionName();
                    greenSections[10].lowBlock=U.getLowestBlock().getBlockNum();
                    greenSections[10].highBlock=U.getHighestBlock().getBlockNum();
                    Included_Blocks=U.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[10].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[10].length=len;
                    greenSections[10].lengthFromStation=len-greenSections[10].lengthToStation;
                    greenSections[10].maxSpeed=lowspeed;
                    greenSections[10].numBlocks=total;
                    greenSections[10].station=stationName;//U_[10]
                      Section V=new Section("V");
                    checkStation=false;
                    V=gr.getSection("V");
                    greenSections[11].ID=V.getSectionName();
                    greenSections[11].lowBlock=V.getLowestBlock().getBlockNum();
                    greenSections[11].highBlock=V.getHighestBlock().getBlockNum();
                    Included_Blocks=V.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[11].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[11].length=len;
                    greenSections[11].lengthFromStation=len-greenSections[11].lengthToStation;
                    greenSections[11].maxSpeed=lowspeed;
                    greenSections[11].numBlocks=total;
                    greenSections[11].station=stationName;//V_[11]        
             Section W=new Section("W");
                    checkStation=false;
                    W=gr.getSection("W");
                    greenSections[12].ID=W.getSectionName();
                    greenSections[12].lowBlock=W.getLowestBlock().getBlockNum();
                    greenSections[12].highBlock=W.getHighestBlock().getBlockNum();
                    Included_Blocks=W.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[12].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[12].length=len;
                    greenSections[12].lengthFromStation=len-greenSections[12].lengthToStation;
                    greenSections[12].maxSpeed=lowspeed;
                    greenSections[12].numBlocks=total;
                    greenSections[12].station=stationName;//W_[12]       
             Section X=new Section("X");
                    checkStation=false;
                    X=gr.getSection("X");
                    greenSections[13].ID=X.getSectionName();
                    greenSections[13].lowBlock=X.getLowestBlock().getBlockNum();
                    greenSections[13].highBlock=X.getHighestBlock().getBlockNum();
                    Included_Blocks=X.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[13].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[13].length=len;
                    greenSections[13].lengthFromStation=len-greenSections[13].lengthToStation;
                    greenSections[13].maxSpeed=lowspeed;
                    greenSections[13].numBlocks=total;
                    greenSections[13].station=stationName;//X_[13]       
            Section Y=new Section("Y");
                    checkStation=false;
                    Y=gr.getSection("Y");
                    greenSections[14].ID=Y.getSectionName();
                    greenSections[14].lowBlock=Y.getLowestBlock().getBlockNum();
                    greenSections[14].highBlock=Y.getHighestBlock().getBlockNum();
                    Included_Blocks=Y.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[14].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[14].length=len;
                    greenSections[14].lengthFromStation=len-greenSections[14].lengthToStation;
                    greenSections[14].maxSpeed=lowspeed;
                    greenSections[14].numBlocks=total;
                    greenSections[14].station=stationName;//Y_[14]        
           Section Z=new Section("Z");
                    checkStation=false;
                    Z=gr.getSection("Z");
                    greenSections[15].ID=Z.getSectionName();
                    greenSections[15].lowBlock=Z.getLowestBlock().getBlockNum();
                    greenSections[15].highBlock=Z.getHighestBlock().getBlockNum();
                    Included_Blocks=Z.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[15].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[15].length=len;
                    greenSections[15].lengthFromStation=len-greenSections[15].lengthToStation;
                    greenSections[15].maxSpeed=lowspeed;
                    greenSections[15].numBlocks=total;
                    greenSections[15].station=stationName;//Z_[15]
                    
            Section F=new Section("F");
                    checkStation=false;
                    F=gr.getSection("F");
                    greenSections[16].ID=F.getSectionName();
                    greenSections[16].lowBlock=F.getLowestBlock().getBlockNum();
                    greenSections[16].highBlock=F.getHighestBlock().getBlockNum();
                    Included_Blocks=F.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[16].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[16].length=len;
                    greenSections[16].lengthFromStation=len-greenSections[16].lengthToStation;
                    greenSections[16].maxSpeed=lowspeed;
                    greenSections[16].numBlocks=total;
                    greenSections[16].station=stationName;//F_[16]        
            Section E=new Section("E");
                    checkStation=false;
                    E=gr.getSection("E");
                    greenSections[17].ID=E.getSectionName();
                    greenSections[17].lowBlock=E.getLowestBlock().getBlockNum();
                    greenSections[17].highBlock=E.getHighestBlock().getBlockNum();
                    Included_Blocks=E.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[17].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[17].length=len;
                    greenSections[17].lengthFromStation=len-greenSections[17].lengthToStation;
                    greenSections[17].maxSpeed=lowspeed;
                    greenSections[17].numBlocks=total;
                    greenSections[17].station=stationName;//E_[17]
                    
            Section D=new Section("D");
                    checkStation=false;
                    D=gr.getSection("D");
                    greenSections[18].ID=D.getSectionName();
                    greenSections[18].lowBlock=D.getLowestBlock().getBlockNum();
                    greenSections[18].highBlock=D.getHighestBlock().getBlockNum();
                    Included_Blocks=D.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[18].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[18].length=len;
                    greenSections[18].lengthFromStation=len-greenSections[18].lengthToStation;
                    greenSections[18].maxSpeed=lowspeed;
                    greenSections[18].numBlocks=total;
                    greenSections[18].station=stationName;//D_[18]
                    
                    
            Section C=new Section("C");
                    checkStation=false;
                    C=gr.getSection("C");
                    greenSections[19].ID=C.getSectionName();
                    greenSections[19].lowBlock=C.getLowestBlock().getBlockNum();
                    greenSections[19].highBlock=C.getHighestBlock().getBlockNum();
                    Included_Blocks=C.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[19].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[19].length=len;
                    greenSections[19].lengthFromStation=len-greenSections[19].lengthToStation;
                    greenSections[19].maxSpeed=lowspeed;
                    greenSections[19].numBlocks=total;
                    greenSections[19].station=stationName;//C_[19]
                    
            Section B=new Section("B");
                    checkStation=false;
                    B=gr.getSection("B");
                    greenSections[20].ID=B.getSectionName();
                    greenSections[20].lowBlock=B.getLowestBlock().getBlockNum();
                    greenSections[20].highBlock=B.getHighestBlock().getBlockNum();
                    Included_Blocks=B.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[20].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[20].length=len;
                    greenSections[20].lengthFromStation=len-greenSections[20].lengthToStation;
                    greenSections[20].maxSpeed=lowspeed;
                    greenSections[20].numBlocks=total;
                    greenSections[20].station=stationName;//B_[20]
                    
            Section A=new Section("A");
                    checkStation=false;
                    A=gr.getSection("A");
                    greenSections[21].ID=A.getSectionName();
                    greenSections[21].lowBlock=A.getLowestBlock().getBlockNum();
                    greenSections[21].highBlock=A.getHighestBlock().getBlockNum();
                    Included_Blocks=A.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[21].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[21].length=len;
                    greenSections[21].lengthFromStation=len-greenSections[21].lengthToStation;
                    greenSections[21].maxSpeed=lowspeed;
                    greenSections[21].numBlocks=total;
                    greenSections[21].station=stationName;//A_[21]        
            Section G=new Section("G");
                    checkStation=false;
                    G=gr.getSection("G");
                    greenSections[22].ID=G.getSectionName();
                    greenSections[22].lowBlock=G.getLowestBlock().getBlockNum();
                    greenSections[22].highBlock=G.getHighestBlock().getBlockNum();
                    Included_Blocks=G.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[22].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[22].length=len;
                    greenSections[22].lengthFromStation=len-greenSections[22].lengthToStation;
                    greenSections[22].maxSpeed=lowspeed;
                    greenSections[22].numBlocks=total;
                    greenSections[22].station=stationName;//G_[22]
                    
            Section H=new Section("H");
                    checkStation=false;
                    H=gr.getSection("H");
                    greenSections[23].ID=H.getSectionName();
                    greenSections[23].lowBlock=H.getLowestBlock().getBlockNum();
                    greenSections[23].highBlock=H.getHighestBlock().getBlockNum();
                    Included_Blocks=H.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[23].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[23].length=len;
                    greenSections[23].lengthFromStation=len-greenSections[23].lengthToStation;
                    greenSections[23].maxSpeed=lowspeed;
                    greenSections[23].numBlocks=total;
                    greenSections[23].station=stationName;//H_[23]        
            Section I=new Section("I");
                    checkStation=false;
                    I=gr.getSection("I");
                    greenSections[24].ID=I.getSectionName();
                    greenSections[24].lowBlock=I.getLowestBlock().getBlockNum();
                    greenSections[24].highBlock=I.getHighestBlock().getBlockNum();
                    Included_Blocks=I.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[24].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[24].length=len;
                    greenSections[24].lengthFromStation=len-greenSections[24].lengthToStation;
                    greenSections[24].maxSpeed=lowspeed;
                    greenSections[24].numBlocks=total;
                    greenSections[24].station=stationName;//I_[24]        
           
            Section J=new Section("J");
                    checkStation=false;
                    J=gr.getSection("J");
                    greenSections[25].ID=J.getSectionName();
                    greenSections[25].lowBlock=J.getLowestBlock().getBlockNum();
                    greenSections[25].highBlock=J.getHighestBlock().getBlockNum();
                    Included_Blocks=J.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[25].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[25].length=len;
                    greenSections[25].lengthFromStation=len-greenSections[25].lengthToStation;
                    greenSections[25].maxSpeed=lowspeed;
                    greenSections[25].numBlocks=total;
                    greenSections[25].station=stationName;//J_[25]
            Section YY=new Section("YY");
                    checkStation=false;
                    YY=gr.getSection("YY");
                    greenSections[26].ID=YY.getSectionName();
                    greenSections[26].lowBlock=YY.getLowestBlock().getBlockNum();
                    greenSections[26].highBlock=YY.getHighestBlock().getBlockNum();
                    Included_Blocks=YY.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[26].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[26].length=len;
                    greenSections[26].lengthFromStation=len-greenSections[26].lengthToStation;
                    greenSections[26].maxSpeed=lowspeed;
                    greenSections[26].numBlocks=total;
                    greenSections[26].station=stationName;//YY_[26]
            Section ZZ=new Section("ZZ");
                    checkStation=false;
                    ZZ=gr.getSection("ZZ");
                    greenSections[27].ID=ZZ.getSectionName();
                    greenSections[27].lowBlock=ZZ.getLowestBlock().getBlockNum();
                    greenSections[27].highBlock=ZZ.getHighestBlock().getBlockNum();
                    Included_Blocks=ZZ.getBlockList();
                    total=Included_Blocks.size();
                    for(itter=0;itter<total;itter++){
                       // greenSections=greenSections.addBlock()
                        len=Included_Blocks.get(itter).getBlockLength()+len;
                        if (lowspeed>Included_Blocks.get(itter).getSpeedLimit()){
                            lowspeed=Included_Blocks.get(itter).getSpeedLimit();
                            checkStation=Included_Blocks.get(itter).isStation();
                            if(checkStation){
                                greenSections[27].lengthToStation=len;
                                stationName=Included_Blocks.get(itter).getStation();
                            }
                        }
                    }
                    greenSections[27].length=len;
                    greenSections[27].lengthFromStation=len-greenSections[27].lengthToStation;
                    greenSections[27].maxSpeed=lowspeed;
                    greenSections[27].numBlocks=total;
                    greenSections[27].station=stationName;//ZZ_[27]
            return redSections;
            
            
        }    
    }
   
}
