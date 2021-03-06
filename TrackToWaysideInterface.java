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
public interface TrackToWaysideInterface extends TrackToCircuitInterface{
    //Method will set speed that can be sent to track circuit
	public boolean setSpeed(int speed);
	//Method that will set the authority (distance) the train is able to travel to track circuit
	public boolean setAuthority(int dist);
	
	/*
	 *The settings of the track lights will be decided by the wayside controller and can be changed
	 *using this method.
	 *
	 *@param block		Block number for more specific location
	 *@param direction	True means alphabetical order, False means reverse alphabetical, check map for reference
	 *@param light		True for green (open), false for red (closed)
	 *@return			True, if light succesfully changes. False, if no change occurs.
	*/
	public boolean setLights(int block, boolean direction, boolean light);
	
	/*
	 *The railroad crossing can be turned on or off with this method.
	 *
	 *@param open	True for closing of the road to let train pass, false to open crossing for cars.
	 *@return		True if succesfully changed, false otherwise.
	 */
	public boolean setCrossing(boolean open);
	
}
