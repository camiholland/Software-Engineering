
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo;
import com.wonderfresh.commons.Time;
/**
 *
 * @author angie
 */
public class driverSchedule {
    int driverID[] =new int[50];
    mbotime[][] monday=new mbotime[7][2];
    mbotime[][] tuesday=new mbotime[7][2];
    mbotime[][] wednesday=new mbotime[7][2];
    mbotime[][] thursday=new mbotime[7][2];
    mbotime[][] friday=new mbotime[7][2];
    mbotime[][] saturday=new mbotime[7][2];
    mbotime[][] sunday=new mbotime[7][2];
    String[][] arr=new String[50][8];
    
    public driverSchedule getSchedule(int drivers, boolean shift[][],int timeBetween){
        //make shift fill boolean 
        driverSchedule ds=new driverSchedule();
        int driverNumShifts=0;
        String s=null;
        int shifts=drivers*5; //total shifts to schedule
        int shiftsPerDay=shifts/7+1; //shifts per day
        int timeBetweenShifts=(24*60)/shiftsPerDay; //time between people scheduled
        timeBetweenShifts-=timeBetweenShifts%5;
        mbotime start = new mbotime();
                start.hr=0;
                start.min=0;
                start.sec=0;
        String[][] covered=new String[7][shiftsPerDay];
        int i=0;
        int j=0;
        
        //fill array with shifts that need to be covered
        for(i=0;i<shiftsPerDay;i++){
            for(j=0;j<7;j++){
                s= start.scheduleTime(start);
               // System.out.println("s: "+s+"   J: "+j+"    shiftsPerDay:  "+shiftsPerDay);
                covered[j][i]=s;
            }
            mbotime next=new mbotime();
            next=start.increment(start,timeBetweenShifts);
            start=next;
        }
        //give driver first 5 shifts avail. Change shifts to nul after
       int temp=0,k = 0,tempID=0;
       int driverIDnum=1001;
       j=0;
       
       
       //add driver id nums
       for(i=0;i<drivers;i++){
           this.arr[i][0]=Integer.toString(driverIDnum);
            driverIDnum++;
       }
       
       while (k<shifts){
            //find a driver for every shift
            for(i=0;i<shiftsPerDay;i++){
                
                
                for(j=0;j<7;j++){
                    //System.out.println(""+tempID);
                    //check for end
                    if (covered[j][i]==null){//break if empty
                        i=shiftsPerDay++;
                        k=shifts+1;
                        j=7;
                        break;
                    }
                    
                    else{
                            //System.out.println(" covered "+covered[j][i]);
                            this.arr[tempID][j+1]=covered[j][i];
                            
                     //System.out.println("a");
                        shifts++;
                        temp++;
                        
                        if (temp==5){//rest count for driver
                            //System.out.println("temp==5");
                            tempID++;
                            temp=0;
                        }
                        if (tempID>=drivers){
                            //System.out.println("break 1");
                            j=8;
                            tempID++;
                            i=shiftsPerDay+100;
                            k=shifts++;
                            return ds;
                        }
                    }
                }
        }
            
            
        }
        
        
    return ds;
    }
    
}
