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
    void addToDailyPassengers(int passengers);
    void setPassengersOnTrain(int trainID, int currentPassengers);
    void setMboMode(boolean mode);//true=mbo mode on : false = mbo mode off
    void initialize();
    void setClosedBlocks(int block, String description, String line);
    void setOpenBlocks(int block,String description, String line);
    String[][] getClosedBlocks();
    void setDispatchedTrain(int trainID, double speed, double authority,mboTrain[] array);
    void setUpdatedSpeedAuthority(int trainID, double speed, double authority, mboTrain[] array);
    void setLocation(int ID, int blockNum, int metersIn, boolean line);
    void setSpeedAuthorityPassengerCount(int ID, double speed, double authority, int passengers);
    mboTrain[] getLocation();
    void setTrainDepartInfo(String station,String trainIDandDepartTime,mboTrainDepartInfo[] info, int id);
    mboTrainDepartInfo[] getTrainDepartInfo();
    mboTrain[] getDispatchedTrain();
    mboTrain[] getUpdatedSpeedAuthority();
    void setAuthority(int trainID, double authority);
    mboTrain[] getAuthority(mboTrain[] mbotrains);
    public int getDailyPassengers();
    
    
    
}
