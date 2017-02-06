/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trackmodel;
/**
 *
 * @author Kevin Carr
 */
public interface TrackToCircuitInterface extends TrackModelInterface{
    public int getSetPointSpeed();
    public int getSetAuthority();
    public boolean isTrainPresent(int block);
}
