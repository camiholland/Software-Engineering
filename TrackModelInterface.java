public interface TrackModelInterface{
	public Track getTrackModel();
}

public interface TrackCorresponders extends TrackModelInterface{{
	public int getSpeedLimit(int block);
	public int getSetPointSpeed();
	public int getSetAuthority();
	public boolean isTrainPresent(int block);
}

public interface ModelToWayside extends TrackCorresponders{
	//Method will set speed that can be sent to track circuit
	public setSpeed(int speed);
	//Method that will set the authority (distance) the train is able to travel to track circuit
	public setAuthority(int dist);
	
	/*
	 *The settings of the track lights will be decided by the wayside controller and can be changed
	 *using this method.
	 *
	 *@param line		Red/Green line 
	 *@param section	Letter indicating the section of track light is found on.
	 *@param block		Block number for more specific location (might not be necessary)
	 *@param direction	True means alphabetical order, False means reverse alphabetical, check map for reference
	 *@param light		True for green (open), false for red (closed)
	 *@return			True, if light succesfully changes. False, if no change occurs.
	*/
	public boolean setLights(char line, char section, int block, boolean direction, boolean light);
	
	/*
	 *The railroad crossing can be turned on or off with this method.
	 *
	 *@param open	True for closing of the road to let train pass, false to open crossing for cars.
	 *@return		True if succesfully changed, false otherwise.
	 */
	public boolean setCrossing(boolean open);
	
}

public interface TrackToTrain extends TrackModelInterface{
	public int getWaitingNumber(int block);
	public boolean setWaitingNumber(int block, int PeopleBoardingTrain);
}