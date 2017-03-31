package mbo;
import java.time.LocalTime;
import java.util.Calendar;

public class mbotime{
    int hr;
    int min;
    int sec;
    
    public static mbotime get10x(mbotime beginTime, int TIMECONST){
        LocalTime l = LocalTime.now();
        mbotime militaryTime = null;
        //b for beginning time
        int bSeconds=   beginTime.sec;
        int bMinutes=   beginTime.min;
        int bHours=     beginTime.hr;
        //get present time
        int seconds=    l.getSecond();
        int minutes=    l.getMinute();
        int hours=      l.getHour();
        //variable declaration for elapsed variables
        int eSeconds=   0;
        int eMinutes=   0;
        int eHours=     0;
        //present time - start time = time elapsed
        //seconds
        if(seconds<bSeconds){
            eSeconds=(seconds+60-bSeconds);
            if(eMinutes>0){
                eMinutes--;
            }
        } 
        //minutes
        if(minutes<bMinutes){
            eMinutes=eMinutes+(minutes+60-bMinutes);
            eHours--;
        }
        else{eMinutes=eMinutes+minutes-bMinutes;} 
        //hours
        if(hours<bHours){eHours=eHours+(hours+12)-bHours;}
        else {eHours=eHours+hours-bHours;}
        //time elapsed * 10
        eSeconds=eSeconds*10;
        eMinutes=eMinutes*10;
        eHours=eHours*10;

        //add time elapsed to start time
        seconds=bSeconds+eSeconds;
        while (seconds>60){
            seconds=seconds-60;
            eMinutes=eMinutes+1;
        }
        while (minutes>60){
            minutes=minutes-60;
            eHours++;
        }
        minutes=eMinutes+bMinutes;
        hours=eHours+bHours;
        if (hours>12){
            hours=hours-12;
        }
        //return military time
        militaryTime.hr=eHours;
        militaryTime.min=eMinutes;
        militaryTime.sec=eSeconds;


        return militaryTime;
    }
/**
 * Given time t, outputs time as "12:01:12 PM"
 * 
 */    
    public static String stringTime(mbotime t){
        String ampm;
        int hour;
        if(t.hr>12){hour=t.hr-12;}
            else{hour=t.hr; }
        if (t.hr>=12){ampm="PM"; }
            else{ampm="AM";}
        String h,m,s;
        if(hour<10){h="0"+hour;}
            else{h=""+hour;}
        if(t.min<10){m="0"+t.min;}
            else{m=""+t.min;}
        
        
        
        if(t.sec<10){s="0"+t.sec;}
            else{s=""+t.sec;}
        String tString=" "+h+":"+m+":"+s+" "+ampm+" " ;
        return tString;
    }
/**
 *   increments time when passed to function
 *   increments by inc in format hhmmss
 *   returns int endtime in format hhmmss
 */       
    public mbotime increment(mbotime start,int inc){
        mbotime t=new mbotime();
        t=start;
        mbotime end=new mbotime();
        int seconds=   t.sec;
        int minutes=   t.min;
        int hours=     t.hr;
        
        //break increment
        int add=inc;
        hours=hours+inc/60;
        minutes=minutes+inc%60;
        
        if (minutes>=60){
            minutes=minutes-60;
            hours++;
        }
        if (hours>=24){
            hours=hours-12;
        }
        end.hr=hours;
        end.min=minutes;
        end.sec=0;
       // System.out.println("Start:"+t.toString()+"    inc:"+inc+"   end:"+end.toString() );
        return end;
    }
    public static mbotime getTimeNow(){
        mbotime n=new mbotime();
        LocalTime l = LocalTime.now();
        n.sec=    l.getSecond();
        n.min=    l.getMinute();
        n.hr=      l.getHour();
        return n;
    }
    
/**
 *  -NOT DONE_
 *   put in 2 times and figure out if a is before b
 *   if a is before b:return 1
 *   if a is after b: return -1
 *   if a=b return 0;
 *   assumes a and b are within 6 hours of each other   
 *  
 */
    public int getFirst(mbotime a, mbotime b){
        int x;
        if (a.hr<b.hr){
            if (a.hr<18 && b.hr>a.hr){
                return 1;
            }
            if(a.hr<18 && b.hr<a.hr){
               return -1;
            }
        }
       return 0;
    }
/**
 * -DONE-
 * public String scheduleTime(time t)
 * 
 * takes time t and outputs time t to time t+8.5 hours for scheduling purposes
 * 
 * example input    :   time=0
 * output           :   12:00A-8:30P    /**
 * -DONE-
 * public String scheduleTime(time t)
 * 
 * takes time t and outputs time t to time t+8.5 hours for scheduling purposes
 * 
 * example input    :   time=0
 * output           :   12:00A-8:30P    
 */    
    
    public String scheduleTime(mbotime t){
        mbotime end=new mbotime();
        String ampm,ampm1,m,h;
 //Special case time between 12:00 AM and 12:59 AM
        if (t.hr<1){
            int tempMin = 0;
            int tempHour=8;
            if (t.min>30){
                tempMin=t.min-30;
                tempHour++;
            }
            if (t.min<30){ tempMin=t.min+30; }
            return "12:00A-"+tempHour+":"+tempMin+"";
        }
  //start      
        end.hr=t.hr+8;
        if (end.hr>24){end.hr-=24;}
        int hour;
        if(t.hr>12){hour=t.hr-12;}
            else{hour=t.hr; }
        if (t.hr>12){ampm="P"; }
            else{ampm="A";}
        if(hour<10){h=""+hour;}
            else{h=""+hour;}
        if(t.min<10){m="0"+t.min;}
            else{m=""+t.min;}
//end time
        end.min=t.min+30;
        if (end.hr>24){
            end.hr=end.hr-24;
        }
        String h1,m1;
        if (end.min>=60){
            end.min-=60;
            end.hr++;
        }
        if (end.hr>12){ampm1="P"; }
            else{ampm1="A";}
        if(end.hr>12){hour=end.hr-12;}
            else{hour=end.hr; }
        if(end.hr>12){hour=end.hr-12;}
        h1=""+hour;
        if(end.min<10){m1="0"+end.min;}
            else{m1=""+end.min;}
        String tString=""+h+":"+m+""+ampm+"-"+h1+":"+m1+""+ampm1+"";
        return tString;
    }
            
}
