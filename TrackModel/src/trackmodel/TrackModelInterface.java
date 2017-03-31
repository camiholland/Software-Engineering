package trackmodel;

public interface TrackModelInterface{
	public TrackModel getTrackModel();
        
        public void setDepartureTime(String station, String time);
        
        public PublicBlock initBlock(String line);
        
        public boolean setAuthority(int Distance);
        
        public int getAuthority();
        
        public boolean setSetPointSpeed(int Distance);
        
        public int getSetPointSpeed();
        
        public boolean setCrossing(PublicBlock crossingBlock, boolean open);
        
        public void setCrossingLights(PublicBlock crossingBlock, int code);
}