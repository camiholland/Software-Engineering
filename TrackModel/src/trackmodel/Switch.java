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
    private Block MasterBlock;
    private Block PrimaryBlock;
    private Block SecondaryBlock;
    private boolean Default = true;
    
    public Switch(Block staticBlock){
        this(staticBlock, null, null);
    }
    
    public Switch(Block staticBlock, Block first, Block second){
        MasterBlock = staticBlock;
        PrimaryBlock = first;
        SecondaryBlock = second;
    }
    
    public void addPrimary(Block first){
        PrimaryBlock = first;
    }
    
    public void addSecondary(Block second){
        SecondaryBlock = second;
    }
    
    /**
     * This function can change the Switches state with a boolean value
     * @param setting should be set to true to put in default state. 
     *                False will result in a non-default state
     * @return true if the state was switched, false if no state switch
     */
    public boolean SetSwitchTo(boolean setting){
        if(Default == setting){
            return false;
        }else if(Default && !setting){
            Default = false;
            return true;
        }else if(!Default && setting){
            Default = true;
            return true;
        }else{
            return true;
        }
    }
        
    public boolean isDefault(){
        return Default;
    }
    
    public boolean contains(Block TestBlock){
        if(TestBlock.equals(MasterBlock)){
            return true;
        }else if(TestBlock.equals(PrimaryBlock)){
            return true;
        }else if(TestBlock.equals(SecondaryBlock)){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        return (MasterBlock.getLabel()+PrimaryBlock.getLabel()+SecondaryBlock.getLabel()).hashCode();
    }
    
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Switch)){
            return false;
        }
        Switch e = (Switch)other;
        
        return e.MasterBlock.equals(this.MasterBlock) && 
                e.PrimaryBlock.equals(this.PrimaryBlock) &&
                e.SecondaryBlock.equals(this.SecondaryBlock);
    }
    
}
