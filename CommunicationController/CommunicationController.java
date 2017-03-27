/**
 *
 * @author Kayla
 */
public interface CommunicationController {
    
    //for use by the CTC office only --  use to send data to communication controller
    public void incomingCTCOutgoingTrackCtrl(double speed, double authority, String trainID);
    
    //for use by Track Controller only -- use to send data to communication controller
    public void incomingTrackCtrlOutgoingCTC(String blockID, boolean railwayStatus, boolean lightsStatus, boolean switchesStatus, boolean occupancyStatus);
    
    //for use by Track Model only -- use to send data to track circuit
    public void incomingTrackModelOutgoingTrackCircuit(double speed, double authority, String blockID);
}
