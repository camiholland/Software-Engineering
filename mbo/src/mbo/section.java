
package mbo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class section {
    String ID;
    int numBlocks;
    int length;
    block[] blocks;
    String station;
    int stationLocation;
    String nextID;
    
    
    public section[] getSections(char line){
        section track[]=new section[100];
        //get file
        String file;
        if (line=='g'){ file = "green.txt";}
        else{file = "red.txt"; }        
        FileReader in = null;
        try{in = new FileReader(file); }
        catch (FileNotFoundException FNF){ System.out.println("Exception: file not found"); }
        Scanner infile = new Scanner(in);   
        
        
        
        return track;
    }
    public String getNext(char line){
        String s=null;
        return s;
        
    }
    
    
}
