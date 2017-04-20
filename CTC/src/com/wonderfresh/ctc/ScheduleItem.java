package com.wonderfresh.ctc;

//@author Sarah

import com.wonderfresh.commons.Block;

public class ScheduleItem {
    
    //the train being scheduled
    int trainID;
    Block currBlock;
    Block prevBlock;
    String currLine;
    double currDistance;
    
    //predictions about the train
    Block nextBlock;
    String nextLine;
    
    //suggestions scheduled for this train
    double speed, authority;
    Block destination;

    
    public ScheduleItem() {
        
    }
    
}
