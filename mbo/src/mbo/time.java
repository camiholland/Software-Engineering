package mbo;
import java.time.LocalTime;
import java.util.Calendar;

public class time{
    public static int get(int beginTime, int TIMECONST){
        LocalTime l = LocalTime.now();
        int militaryTime=0;
        //b for beginning time
        int bSeconds=   beginTime%100;
        int bMinutes=   beginTime%10000;
        int bHours=     beginTime%1000000;
        //get present time
        int seconds=    l.getSecond();
        int minutes=    l.getMinute();
        int hours=      l.getHour();
        //variable declaration for elapsed variables
        int eSeconds=   0;
        int eMinutes=   0;
        int eHours=     0;
        if (TIMECONST==1){ militaryTime=seconds+100*minutes+10000*hours;}
        if (TIMECONST==10){
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
            militaryTime=eSeconds+eMinutes*100+eHours*10000;
            
            
        }
        return militaryTime;
    }
    public static void printTime(int time){
        String t="      "+time;
        //System.out.println("time: "+time+" String t:"+t+ "t.charAt(0)= "+t.charAt(0));
        //System.out.println("length: "+t.length());
        if (t.length()==5){ t="0"+t; }
        System.out.println(t.charAt(0)+""+t.charAt(1)+":"+t.charAt(2)+""+t.charAt(3)+":"+t.charAt(4)+""+t.charAt(5));
    }
    public static String stringTime(int time){
        String ampm;
        if (time>120000){
            time=time-120000;
            ampm="PM";
        }
        else{
            ampm="AM";
        }
        String t=""+time+"        ";
        if (time<100000){
            t="0"+t; 
        }
        
        t=(t.charAt(0)+""+t.charAt(1)+":"+t.charAt(2)+""+t.charAt(3)+":"+t.charAt(4)+""+t.charAt(5)+" "+ampm);
        return t;
    }
}
