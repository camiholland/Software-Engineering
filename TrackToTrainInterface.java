/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trackmodel;

/**
 *
 * @author kwc12
 */
public interface TrackToTrainInterface extends TrackModelInterface{
    
    public int getWaitingNumber(int block);

    public boolean setWaitingNumber(int block, int PeopleBoardingTrain);
    
}
