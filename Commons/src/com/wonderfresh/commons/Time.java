/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.commons;

/**
 * A universal singleton time class that runs at normal and 10x speed 
 * 
 * @author Austin
 */
@SuppressWarnings("InitializerMayBeStatic")
public class Time extends Thread{
    
    private static Time instance = null;
    
    //private to defeat other instantiation and remain a singleton
    private Time() {
        speed = 10;
        hr = 0;
        min = 0;
        sec = 0;
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
}
