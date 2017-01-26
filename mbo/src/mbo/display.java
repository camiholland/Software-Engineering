package mbo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angie
 */
public class display {
    JPanel pane = new JPanel();
    
    public display(){
    }
    public static int initialize() throws FileNotFoundException{
     //get schedule
        int StartTime,time1,time2;               //used for clock; 6 digits HHMMSS;
        int i=1,loop=1;  
        
        Schedule gSchedule[]=Schedule.getSchedule("green");
        Schedule rSchedule[]=Schedule.getSchedule("red");
        Schedule schedule[]=Schedule.getSchedule("both");
        
        LocalTime l = LocalTime.now();
        int seconds=    l.getSecond();
        int minutes=    l.getMinute();
        int hours=      l.getHour();
        if(hours>12){hours=hours-12;}
        StartTime=seconds+(minutes*100)+(hours*10000);
        time.printTime(StartTime);
        String currentTime=time.stringTime(StartTime);
        //while(loop==1){      
        int scheduleCounter=0;
        int scheduleList[]=new int[10];
        Schedule queue[]=new Schedule[10];  
        for(i=0;i<96;i++){
            if(schedule[i].hour==hours){
                if(schedule[i].min>=minutes){
                    if (schedule[i].active==true){
                        queue[0]=schedule[i];
                        scheduleList[0]=i;
                        scheduleCounter++;
                        while (scheduleCounter!=10){
                            System.out.println("\n"+i);
                            i++;
                            if (schedule[i].active==true){
                                queue[scheduleCounter]=schedule[i];
                                scheduleList[scheduleCounter]=i;
                                scheduleCounter++;
                            }
                        }
                        if(scheduleCounter==10){i=100;}
                    }
                }
            }
        }
        
            return StartTime;
        }//end initialize
    
    
    
}
