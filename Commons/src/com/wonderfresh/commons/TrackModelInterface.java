package com.wonderfresh.commons;

public interface TrackModelInterface{
        
        /**
         * The Track Model is organized in several layers.
         * TrackModel has two TrackLines, Each TrackLine has
         * Blocks, Sections, Edges and Switches. Different information can
         * be taken from each.
         * @return an implementation of the chosen track model
         */
	public TrackModel getTrackModel();
        
        /**
         * If a new train needs to be sent out, a block must be initialized
         * on a given track line.
         * @param line referring to the line which the train wants to go on.
         * @return The first block of the given line the user chose.
         */
        public PublicBlock initBlock(String line);
        
        /**
         * Honestly not sure about this one, but probably just passing on to the 
         * communications controller instantaneously?
         * @param Distance length of track train is allowed to cover
         * @return true if successfully sent, false if not
         */
        public boolean setAuthority(int Distance);
        
        /**
         * This method will send the set point speed to the communications module.
         * @param speed at which the train should travel for the given authority
         * @return true if the speed sent successfully, false otherwise
         */
        public boolean setSetPointSpeed(int speed);
        
        public boolean setCrossing(String line, int BlockNum, boolean open);
        
        //public void setCrossingLights(PublicBlock crossingBlock, int code);
        
        public boolean isSectionOccupied(String line, String Section);
        
        public boolean isBlockOccupied(String line, int blockNum);
}