package mbo;
import java.time.LocalTime;
import java.util.Calendar;

public class time{
    int hr;
    int min;
    int sec;
    
    public static time get10x(time beginTime, int TIMECONST){
        LocalTime l = LocalTime.now();
        time militaryTime = null;
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
    
    // Given time t, outputs time as "12:01:12 PM"
    public static String stringTime(time t){
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
    /*
     *   increments time when passed to function
     *   increments by inc in format hhmmss
     *   returns int endtime in format hhmmss
     */       
    public int increment(time t,int inc){
        int endtime=0;
        //get present time
        LocalTime l = LocalTime.now();
        int seconds=    l.getSecond();
        int minutes=    l.getMinute();
        int hours=      l.getHour();
        //break increment
        int iSeconds=   inc%100;
        int iMinutes=   inc%10000;
        int iHours=     inc%1000000;
        //add increment
        int eSeconds=seconds+iSeconds;
        if (eSeconds>=60){
            eSeconds=eSeconds-60;
            minutes++;
        }
        int eMinutes=minutes+iMinutes;
        if (eMinutes>=60){
            eMinutes=eMinutes-60;
            hours++;
        }
        int eHours=hours+iHours;
        if(eHours>=24){
            eHours=eHours-24;
        }
        
        return endtime;
    }
    public static time getTimeNow(){
        time n=new time();
        LocalTime l = LocalTime.now();
        n.sec=    l.getSecond();
        n.min=    l.getMinute();
        n.hr=      l.getHour();
        return n;
    }
    
    /*
    put in 2 times and figure out if a is before b
    if a is before b:return 1
    if a is after b: return -1
    if a=b return 0;
    assumes a and b are within 6 hours of each other 
       NOT FINISHED
    
    NO
    */
    public int getFirst(time a, time b){
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
            
}
