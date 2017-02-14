

package mbo;
public class closedTrack {
    int blockNum;
    String problem;
    int timeToFix;
    int timeFixed;
    int closingTime;
    String line;
    
    public String[] checkClosures(time t, closedTrack[] c, int test){
        int i,hours,min,sec;
        closedTrack[] closed=new closedTrack[100];
        String[] closedString=new String[100];
        //check time to see if still closed - Remove tracks that are no longer closed
        for(i=0;i<100;i++) {
            if (c[i].problem!=null){
                //check if passed time
                //get present time
                
                
            }
            
        }
        
        return closedString;
    } 
    public String toString(closedTrack t){
        String s="Line:"+line+" Block:"+blockNum+" closed at:"+closingTime+"Problem:"+problem+" time to Fix:"+timeToFix; 
        return s;
    }
}
