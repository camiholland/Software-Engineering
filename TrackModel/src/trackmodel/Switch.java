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
public class Switch {
    private boolean Open = true;
    
    public boolean SwitchTrackTo(boolean setting){
        if(Open && setting){
            return false;
        }else if(Open && !setting){
            Open = false;
            return true;
        }else if(!Open && setting){
            Open = true;
            return true;
        }else{
            return false;
        }
    }
    
    public class TrackToSwitch {
        private boolean Open;
        private int blocknum;
        
        public TrackToSwitch(boolean openValue, int blocknumValue){
            this.Open = openValue;
            this.blocknum = blocknumValue;
        }
        
        public boolean isOpen(){
            if(Open){
                return true;
            }else{
                return false;
            }
        }
        
        public int getBlockNum(){
            return blocknum;
        }
    }
}
