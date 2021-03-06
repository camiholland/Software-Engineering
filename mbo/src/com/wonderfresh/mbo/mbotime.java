package com.wonderfresh.mbo;




public class mbotime{
    int hr;
    int min;
    int sec;
    
/*
 * Given time t, outputs time as "12:01:12 PM"
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
 * output           :   12:00A-8:30P    /**
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
 * output           :   12:00A-8:30P    /**
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
 * output           :   12:00A-8:30P    /**
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