/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.commons;

import java.time.LocalTime;

/**
 * A universal singleton time class that runs at normal to 100x speed 
 * 
 * @author Austin
 */
@SuppressWarnings("InitializerMayBeStatic")
public class Time extends Thread{
    
    private static Time instance = null;
    
    //private to defeat other instantiation and remain a singleton
    private Time() {
        speed = 10;
        
        LocalTime l = LocalTime.now();
        sec=    l.getSecond();
        min=    l.getMinute();
        hr=      l.getHour();
        
    }
    
    public static Time getInstance() {
        if (instance == null) {
            instance = new Time();
            instance.start();
        }
        
        return instance;
    }
    
    private int speed;
    private int hr;
    private int min;
    private int sec;
    
    public int setSpeed(int speed) {
       if (speed < 1 || speed > 100) {
           return -1;
       }
       
       this.speed = speed;
       return 1;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public String getTime() {
        int hour;
        String time = "";
        
        hour = hr % 12;
        if (hour == 0) {
            hour = 12;
        }

        if (hour < 10) {
            time += "0" + hour;
        } else {
            time += hour;
        }
        
        if (min < 10) {
            time += ":0" + min;
        } else {
            time += ":" + min;
        }
        
        if (sec < 10) {
            time += ":0" + sec;
        } else {
            time += ":" + sec;
        }
        
        if (hr < 12) {
            time += "AM";
        } else {
            time += "PM";
        }
        
        
        return time;
    }
    
    @SuppressWarnings("SleepWhileInLoop")
    @Override
    public void run() {
        while(true) {
            
            long timestart = System.currentTimeMillis();
            
            sec++;
            
            if (sec >= 61) {
                min++;
                sec = 0;
            }
            
            if (min >= 61) {
                hr++;
                min = 0;
            }
            
            if (hr >= 24) {
                hr = 0;
            }
            
                        //sleep till one second system time
            try {
                sleep(1000 / speed);
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            //System.out.println(getTime());
            
            
        }
    }
    public static Time getTimeNow(){
        Time n=new Time();
        LocalTime l = LocalTime.now();
        n.sec=    l.getSecond();
        n.min=    l.getMinute();
        n.hr=      l.getHour();
        return n;
    }
    
/**
 *  -NOT DONE_
 *   put in 2 Times and figure out if a is before b
 *   if a is before b:return 1
 *   if a is after b: return -1
 *   if a=b return 0;
 *   assumes a and b are within 6 hours of each other   
 *  
 */
    public int getFirst(Time a, Time b){
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
 * public String scheduleTime(Time t)
 * 
 * takes Time t and outputs Time t to Time t+8.5 hours for scheduling purposes
 * 
 * example input    :   Time=0
 * output           :   12:00A-8:30P    
 */    
    
    public String scheduleTime(Time t){
        Time end=new Time();
        String ampm,ampm1,m,h;
 //Special case Time between 12:00 AM and 12:59 AM
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
//end Time
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
        public static String stringTime(Time t){
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
            
}


