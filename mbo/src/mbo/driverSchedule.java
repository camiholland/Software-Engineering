/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo;

/**
 *
 * @author angie
 */
public class driverSchedule {
    int driverID[] ;
    time[][] monday;
    time[][] tuesday;
    time[][] wednesday;
    time[][] thursday;
    time[][] friday;
    time[][] saturday;
    time[][] sunday;
    
    public static driverSchedule getSchedule(int drivers){
        driverSchedule sched=new driverSchedule();
        if (drivers<=4){
            sched=makeSmall(drivers);
            return sched; }
        //else
        return sched;
    }
    public static driverSchedule makeSmall(int drivers){
        //if one cover first rush hour-- start at 6am-2:30pm (mon-friday)
        driverSchedule d=new driverSchedule();
        d.driverID[0]=1000;
        time start=new time();
        start.hr=6;
        start.min=0;
        start.sec=0;
        time end=new time();
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
    }
    
    
    
}
