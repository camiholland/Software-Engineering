package com.wonderfresh.commons;

/**
 *
 * @author angie
 */
public class mboTrain {
    
    public int block;
    public int metersInBlock;
    public int number;
    public double speed;
    public double authority;
    public String color;
    public String departureTime;
    public String bound;
    public int AMPM;
    public int hour;
    public int minutes;
    
    public mboTrain (int num, double spd, double auth, String col, int departHour, int departMin){
        
        number=num;
        speed=spd;
        authority=auth;
        color=col;
        bound="out";
    
    }
    public String getDepartureTime(){
        return this.departureTime;
    
    }
    public int getNumber(){
        return this.number;
    }
    public double getSpeed(){
        return this.speed;
    }
    public double getAuthority(){
        return this.authority;
    }
    public int getHour(){
        return this.hour;
    }
    public int getMinutes(){
        return this.minutes;
    }
    public void outputTrain(){
        System.out.println(  "--------------------------------------");
        System.out.println(  "Train Number/Line:   "+this.number+" "+this.color);
        System.out.printf(   "Departure Time:      "+this.departureTime);
        System.out.printf(   "\nSpeed:               %.2f\n",this.speed);
        System.out.printf(   "Authority:           %.2f\n\n",this.authority);
    }
}