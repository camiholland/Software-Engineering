
package trainsys;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 */
public class track {
    
        String section;
        int block;
        double length;
        double grade;
        double limit;
        String infastructure;
        double elevation;
        double cumElevation;
        int swit;
        String arrow;
        boolean active;
    
    public static track[] getTrack(String color){

        
        int i=1;                //iterator
        String junk=null;       //used for temporary  lines
        
        if(color.equalsIgnoreCase("green")){
            /** 
             * upload green map details from green.txt for green line
             */
            String file= "green.txt";
            FileReader gTrack = null;
            try{gTrack = new FileReader(file); }
            catch (FileNotFoundException FNF){ System.out.println(" Green track file not properly uploaded"); }
            Scanner greenTrack = new Scanner(gTrack);        
            junk=greenTrack.nextLine(); //reads first line of headers and ignores them
            track[] green=new track[154];  
            while(i<153){
                if (!junk.equals("Green")){junk=greenTrack.next();}
                track a=new track();
                a.active=false;
                a.section=greenTrack.next();
                a.block=greenTrack.nextInt();
                a.length=greenTrack.nextDouble();
                a.grade=greenTrack.nextDouble();
                a.limit=greenTrack.nextInt();
                while (!greenTrack.hasNextDouble()){
                    if(a.infastructure==null){ a.infastructure=" "+greenTrack.next();}
                    else{a.infastructure=a.infastructure+" "+greenTrack.next();}
                }
                a.elevation=greenTrack.nextDouble();
                a.cumElevation=greenTrack.nextDouble();
                junk=greenTrack.next();
                if (junk.equals("Switch")){  a.swit=greenTrack.nextInt(); junk=greenTrack.next(); }
                if (junk.equals("HEAD")){a.arrow="HEAD"; }
                if (junk.equals("TAIL")){a.arrow="TAIL"; }
                if (junk.equals("TAIL/HEAD")){a.arrow="TAIL/HEAD"; }
                green[i]=a;
                i++;
            }
            i=1;//reset iterator
            return green;
        }
        /** 
         * upload red map details from red.txt file
         */
        else{
            String file= "red.txt";
            FileReader rTrack = null;
            try{rTrack = new FileReader(file); }
            catch (FileNotFoundException FNF){ System.out.println("Red track file not properly uploaded"); }
            Scanner redTrack = new Scanner(rTrack);
            junk=redTrack.nextLine(); //reads first line of headers and ignores them
            track[] red=new track[78];  
            while(i<78){
                if (!junk.equals("Red")){    junk=redTrack.next();}
                track a=new track();
                a.active=false;
                a.section=redTrack.next();
                a.block=redTrack.nextInt();
                a.length=redTrack.nextDouble();
                a.grade=redTrack.nextDouble();
                a.limit=redTrack.nextInt();
                while (!redTrack.hasNextDouble()){a.infastructure=" "+redTrack.next();}
                a.elevation=redTrack.nextDouble();
                a.cumElevation=redTrack.nextDouble();
                junk=redTrack.next();
                if (junk.equals("Switch")){  a.swit=redTrack.nextInt(); junk=redTrack.next();}
                if (junk.equals("HEAD")){a.arrow="HEAD"; }
                if (junk.equals("TAIL")){a.arrow="TAIL"; }
                if (junk.equals("HEAD/HEAD")){a.arrow="HEAD/HEAD"; }
                red[i]=a;
                i++;
            }
        i=0;//reset iterator
        return red;
        }
        
    }
}
