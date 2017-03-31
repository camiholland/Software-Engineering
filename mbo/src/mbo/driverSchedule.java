
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
                System.out.println("s: "+s+"   J: "+j+"    shiftsPerDay:  "+shiftsPerDay);
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
        
        
        
        //make string array
        /*
        int id=1001;
        driverSchedule d=new driverSchedule();
        for (i=0;i<50;i++){
            j=0;
            d.arr[i][j]=Integer.toString(id);
            id=id++;
            for(j=1;j<8;j++){
                d.arr[i][j]=" ("+i+","+j+")";
                
            }
        }
        
        return d;
        
        /*
        
        
        //if one cover first rush hour-- start at 6am-2:30pm (mon-friday)
        d=new driverSchedule();
        d.driverID[0]=1000;
        start.hr=6;
        start.min=0;
        start.sec=0;
        end.hr=2;
        end.min=30;
        end.sec=0;
        d.monday[0][0]=start;
        d.monday[0][1]=end;
        d.tuesday[0][0]=start;
        d.tuesday[0][1]=end;
        d.wednesday[0][0]=start;
        d.wednesday[0][1]=end;
        d.thursday[0][0]=start;
        d.thursday[0][1]=end;
        d.friday[0][0]=start;
        d.friday[0][1]=end;
        //if only 2 cover rush hours
        
        if (drivers>=2){
            d.driverID[1]=1001;
            start=new time();
            start.hr=14;
            start.min=30;
            start.sec=0;
            end=new time();
            end.hr=23;
            end.min=0;
            end.sec=0;
            d.monday[1][0]=start;
            d.monday[1][1]=end;
            d.tuesday[1][0]=start;
            d.tuesday[1][1]=end;
            d.wednesday[1][0]=start;
            d.wednesday[1][1]=end;
            d.thursday[1][0]=start;
            d.thursday[1][1]=end;
            d.friday[1][0]=start;
            d.friday[1][1]=end;
        }
        if (drivers>=3){ //add some weekend days
            d.driverID[2]=1002;
            start=new time();
            start.hr=23;
            start.min=0;
            start.sec=0;
            end=new time();
            end.hr=7;
            end.min=30;
            end.sec=0;
            d.monday[2][0]=start;
            d.monday[2][1]=end;
            d.tuesday[2][0]=start;
            d.tuesday[2][1]=end;
            d.wednesday[2][0]=start;
            d.wednesday[2][1]=end;
            start.hr=6;
            start.min=0;
            start.sec=0;
            end.hr=2;
            end.min=30;
            end.sec=0;
            d.saturday[2][0]=start;
            d.saturday[2][1]=end;
            d.sunday[2][0]=start;
            d.sunday[2][1]=end;
        }
        
        
        return d;
    */
    return ds;
    }
    
}
