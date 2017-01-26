/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author angie
 */
public class Schedule {
    String line;
    int hour;
    int min;
    boolean active;
    public static Schedule[] getSchedule(String s) throws FileNotFoundException{
    
            Schedule[] a=new Schedule[96];
            int i;
            
            String file= "schedule.txt";
            FileReader scheduleReader = null;
            try{
                scheduleReader = new FileReader(file); 
            }
            catch (FileNotFoundException FNF){ 
                System.out.println("Schedule file not properly uploaded"); 
            }
            Scanner in = new Scanner(scheduleReader); 
            
            
            //Load schedule from document
                for (i=0;i<96;i++){
                    Schedule temp=new Schedule();
                    int hour=in.nextInt();
                    temp.hour=hour;
                    int min=in.nextInt();
                    temp.min=min;
                    String line=in.next();
                    temp.line=line;
                    temp.active=true;
                    a[i]=temp;
                }
            return a;
     }
    public static String printSchedule(Schedule a){
        
        String h,m;
        if (a.hour<10){ h="0"+a.hour;}
        else{h=""+a.hour;}
        if(a.min<10){m="0"+a.min;}
        else{m=""+a.min;}
        String s=("Line: "+a.line+"\t\tDeparture Time: "+h+":"+m);
        return s;
    }
}
