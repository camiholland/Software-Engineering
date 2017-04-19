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
    
    void initializeTrainArray();
    void setClosedBlocks(int block, String description);
    String[] getClosedBlocks();
    mboTrain[] setDispatchedTrain(int trainID, double speed, double authority,mboTrain[] array);
    mboTrain[] setUpdatedSpeedAuthority(int trainID, double speed, double authority, mboTrain[] array);
    void setLocation(int ID, int blockNum, int metersIn, boolean line);
    void setSpeedAuthorityPassengerCount(int ID, double speed, double authority, int passengers);
    mboTrain[] getLocation();
    mboTrainDepartInfo[] setTrainDepartInfo(String station,String trainIDandDepartTime,mboTrainDepartInfo[] info, int id);
    mboTrainDepartInfo[] getTrainDepartInfo();
    mboTrain[] getDispatchedTrain();
    mboTrain[] getUpdatedSpeedAuthority();
    
    
    
}
