package com.wonderfresh.interfaces;

import com.wonderfresh.commons.mboTrain;
import com.wonderfresh.commons.mboTrainDepartInfo;

/**
 * @author Angela Hoeltje
 * 
 * Interface for all communications from MBO
 * Implementations of these methods are in System com.wonderfresh.interfaces MboInterfaceImpl
 * 
 */
public interface MboInterface {
    void setClosedBlocks(int block, String description);
    String[] getClosedBlocks();
    mboTrain[] setDispatchedTrain(int trainID, double speed, double authority,mboTrain[] array);
    mboTrain[] setUpdatedSpeedAuthority(int trainID, double speed, double authority, mboTrain[] array);
    mboTrain[] setLocation(int blockNum, int metersIn,int ID);
    mboTrain[] getLocation(mboTrain[] array);
    mboTrainDepartInfo[] setTrainDepartInfo(String station,String trainIDandDepartTime,mboTrainDepartInfo[] info);
    mboTrain[] getDispatchedTrain();
    mboTrain[] getUpdatedSpeedAuthority();
    mboTrainDepartInfo[] getTrainDepartInfo();
    
}
