package com.wonderfresh.mbo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author angie
 */

/**
 *
 * @author angie
 */
public class trainSchedule {
    String number;
    String[] monday;
    String[] tuesday;
    String[] wednesday;
    String[] thursday;
    String[] friday;
    String[] Saturday;
    String[] Sunday;
    
    public trainSchedule getTrainSchedule(int d){
        trainSchedule t=new trainSchedule();
        int hours=d*40;
        int drivers=d;
        if (d<=0){
            System.out.println("\nNot Adequate number of drivers\n");
            return t=null;
        }
        
        return t;
    }
    


}
