/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbo;

import java.io.File;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author angie
 */

public class loadTrack {
    static XSSFRow row;
    private static TrackGraph RedLine;
    private static TrackGraph GreenLine;
    private static int RedCount;
    private static int GreenCount;
    private String dataFile;
    private static int temp = 50;
    
    void loadtrack() throws FileNotFoundException, IOException{
      System.out.println("TrackModel is running.");
      String dataFile="data.xlsx";
        int RedCount = 0;
        try (FileInputStream fis = new FileInputStream(new File(dataFile))) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet;
            Iterator < Row > rowIterator;
            Iterator < Cell > cellIterator;
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////////RED LINE/////////////////////////RED LINE////////////////////RED LINE//////////////////////RED LINE/////////////////////////RED LINE////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            spreadsheet = workbook.getSheetAt(1);
            rowIterator = spreadsheet.iterator();
            row = (XSSFRow) rowIterator.next();
            //cellIterator = row.cellIterator();
            /*while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                String newCol = cell.getStringCellValue();
                System.out.print(newCol + " \t");
            }
            System.out.println();*/
            
            
            //RedCount = 0;
            while(rowIterator.hasNext()){
               
                // Each row represents a block
                //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv below are each instantiated value of a block
                String line = "Red";
                String Section;
                double num;
                double length;
                double grade;
                double speed;
                Object[] Stringobj = new Object[]{};
                double[] intobj = new double[] {};
                String Infrastructure = "";
                String SwitchBlock = "";
                String ArrowDirection = "";
                //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                
                row = (XSSFRow) rowIterator.next();
                cellIterator = row.cellIterator();
                while(cellIterator.hasNext()){          // Checks to see if end of row has been reached
                    Cell cell = cellIterator.next();    // Iterates through the row
                    switch(cell.getCellType()){         // Appends the value in the cell to the correct array of its type
                        case Cell.CELL_TYPE_NUMERIC:
                            ArrayList<Double> newDoubleObject = new ArrayList<>(Arrays.asList(ArrayUtils.toObject(intobj)));    // Converts the cell object to a double?
                            newDoubleObject.add(cell.getNumericCellValue());
                            intobj = ArrayUtils.toPrimitive(newDoubleObject.toArray(new Double[]{}));   // New int array
                            //System.out.print(cell.getNumericCellValue()+ " \t\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            String newString = cell.getStringCellValue();
                            ArrayList<Object> temp1 = new ArrayList<>(Arrays.asList(Stringobj));
                            temp1.add(newString);
                            Stringobj = temp1.toArray();                                             // New Object array full of strings
                            //System.out.print(cell.getStringCellValue() + " \t\t");
                            break;
                    }
                }
                
                // This part relies on the track information being put in the exact form in which it was first given
                if(intobj.length > 0 || Stringobj.length > 0){  // First checks to make sure not a null row
                    int i = 0;
                    int StrArrLen = Stringobj.length;
                    if(Stringobj[i].toString().length()>2){
                        line = Stringobj[i].toString();
                        i++;
                    }
                    
                    Section = Stringobj[i].toString();
                    i++;
                    
                    // The infrastructure and switch field aren't always present, so the array must be checked in the reverse order.
                    for(int j = i;j<StrArrLen; j++){
                        if(Stringobj[j].toString().startsWith("Head") || Stringobj[j].toString().startsWith("Tail")){
                            ArrowDirection = Stringobj[j].toString();
                        }else if(Stringobj[j].toString().startsWith("Switch")){
                            SwitchBlock = Stringobj[j].toString();
                        }else{
                            Infrastructure = Stringobj[j].toString();
                        }
                    }
                    
                    int c = 2;
                    num = intobj[0];
                    length = intobj[1];
                    grade = intobj[c];
                    c++;
                    // Still not sure what i'm doing here, need to revise
                    try{
                        speed = intobj[c];
                    }catch(ArrayIndexOutOfBoundsException e){
                        grade = 0.0;
                        speed = intobj[2];
                    }
                    
                    
                    BetaBlock tempBlock = new BetaBlock(line, Section, num, length, grade, speed, Infrastructure, SwitchBlock, ArrowDirection);
                    if(!RedLine.addBlock(tempBlock, true)){
                        System.out.println("Problem adding block "+tempBlock.getLabel()+" to graph");
                    }
                    String sentence = tempBlock.toString();
                    RedCount++;
                    System.out.println(sentence);
                }

            }   // Loops back up to check for another block
            
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////GREEN LINE//////////////////////////////GREEN LINE//////////////////////////////GREEN LINE/////////////////////////GREEN LINE///////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            spreadsheet = workbook.getSheetAt(2);
            rowIterator = spreadsheet.iterator();
            row = (XSSFRow) rowIterator.next();
            cellIterator = row.cellIterator();
            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                String newCol = cell.getStringCellValue();
                //System.out.print(newCol + " \t");
            }
            //System.out.println();
            
            
            
            //GreenCount = 0;
            while(rowIterator.hasNext()){
                
                String line = "Green";
                String Section;
                double num;
                double length;
                double grade;
                double speed;
                Object[] Stringobj = new Object[]{};
                double[] intobj = new double[] {};
                String Infrastructure = "";
                String SwitchBlock = "";
                String ArrowDirection = "";
                
                row = (XSSFRow) rowIterator.next();
                cellIterator = row.cellIterator();
                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch(cell.getCellType()){
                        case Cell.CELL_TYPE_NUMERIC:
                            ArrayList<Double> newDoubleObject = new ArrayList<>(Arrays.asList(ArrayUtils.toObject(intobj)));
                            newDoubleObject.add(cell.getNumericCellValue());
                            intobj = ArrayUtils.toPrimitive(newDoubleObject.toArray(new Double[]{}));
                            //System.out.print(cell.getNumericCellValue()+ " \t\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            String newString = cell.getStringCellValue();
                            ArrayList<Object> temp2 = new ArrayList<>(Arrays.asList(Stringobj));
                            temp2.add(newString);
                            Stringobj = temp2.toArray();
                            //System.out.print(cell.getStringCellValue() + " \t\t");
                            break;
                    }
                }
                
                if(intobj.length > 0 || Stringobj.length > 0){
                    int i = 0;
                    int StrArrLen = Stringobj.length;
                    if(Stringobj[i].toString().length()>2){
                        line = Stringobj[i].toString();
                        i++;
                    }
                    
                    Section = Stringobj[i].toString();
                    i++;
                    
                    for(int j = i;j<StrArrLen; j++){
                        if(Stringobj[j].toString().startsWith("Head") || Stringobj[j].toString().startsWith("Tail")){
                            ArrowDirection = Stringobj[j].toString();
                        }else if(Stringobj[j].toString().startsWith("Switch")){
                            SwitchBlock = Stringobj[j].toString();
                        }else{
                            Infrastructure = Stringobj[j].toString();
                        }
                    }
                    
                    int c = 2;
                    num = intobj[0];
                    length = intobj[1];
                    grade = intobj[c];
                    c++;
                    try{
                        speed = intobj[c];
                    }catch(ArrayIndexOutOfBoundsException e){
                        grade = 0.0;
                        speed = intobj[2];
                    }
                    
                    
                    BetaBlock tempBlock2 = new BetaBlock(line, Section, num, length, grade, speed, Infrastructure, SwitchBlock, ArrowDirection);
                    if(!GreenLine.addBlock(tempBlock2, true)){
                        System.out.println("Problem adding block "+ tempBlock2.getLabel()+" to graph.");
                    }
                    String sentence = tempBlock2.toString();
                    int GreenCount = 0;
                    GreenCount++;
                    System.out.println(sentence);
                }

            }
        }
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////CONNECT BLOCKS/////////////////////////CONNECT BLOCKS/////////////////////////////////////CONNECT BLOCKS//////////////////////////CONNECT BLOCKS//////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        /** 
         * Graphs have been filled with all of the vertices (Blocks) that they will need for now.
         * Next is connecting the blocks with edges.
         */
       int currentRed = 1;
       int innerCountRed; 
       
        while(currentRed <= RedCount){   //Index through blocks to connect with edges            `                              <-----------------------||
            //System.out.println("currentRed = "+currentRed);                                                                                           //
            innerCountRed = currentRed;     // Saves the current block count before looking through upcoming section                                    //
            String RedString1 = "Red"+currentRed; //Creates block label to call                                                                         //
            BetaBlock RedBlock1 = RedLine.getBlock(RedString1); //Retrieves block by label from graph                                                   //
            //System.out.println("RedBlock1: "+RedBlock1.getLabel());
            //System.out.println("RedBlock1: "+RedBlock1.getArrowDirection());
            BetaBlock InnerRedBlock1;                                                                                                                   //
                                                                                                                                                        //
            if(RedBlock1.getArrowDirection().compareTo("Head/Head")==0){                                                                                //
                //System.out.println("@ Head/Head");
                innerCountRed++;                                                                                                                        //
                if(innerCountRed>RedCount){                                                                                                             //
                    break;                                                                                                                              //
                }                                                                                                                                       //
                RedString1 = "Red"+innerCountRed;                                                                                                     //
                InnerRedBlock1 = RedLine.getBlock(RedString1);                                                                                          //
                if(!RedLine.addEdge(InnerRedBlock1, RedBlock1)){                                                                                        //
                    System.out.println("Problem adding edge from "+InnerRedBlock1.getLabel()+" to "+RedBlock1.getLabel());                              //
                }                                                                                                                                       //
                if(!RedLine.addEdge(RedBlock1,InnerRedBlock1)){                                                                                         //
                    System.out.println("Problem adding edge from "+RedBlock1.getLabel()+" to "+InnerRedBlock1.getLabel());                              //
                }                                                                                                                                       //
            }else if(RedBlock1.getArrowDirection().compareTo("Head/Tail")==0){                                                                          //
                //System.out.println("@ Head/Tail");
                innerCountRed++;                                                                                                                        //
                if(innerCountRed>RedCount){                                                                                                             //
                    break;                                                                                                                              //
                }                                                                                                                                       //
                RedString1 = "Red"+innerCountRed++;                                                                                                     //
                InnerRedBlock1 = RedLine.getBlock(RedString1);                                                                                          //
                if(!RedLine.addEdge(InnerRedBlock1, RedBlock1)){                                                                                        //
                    System.out.println("Problem adding edge from "+InnerRedBlock1.getLabel()+" to "+RedBlock1.getLabel());                              //
                }                                                                                                                                       //
            }else if(RedBlock1.getArrowDirection().compareTo("Tail/Head")==0){                                                                          //
                //System.out.println("@ Tail/Head");
                innerCountRed++;                                                                                                                        //
                if(innerCountRed>RedCount){                                                                                                             //
                    break;                                                                                                                              //
                }                                                                                                                                       //
                RedString1 = "Red"+innerCountRed++;                                                                                                     //
                InnerRedBlock1 = RedLine.getBlock(RedString1);                                                                                          //
                if(!RedLine.addEdge(RedBlock1, InnerRedBlock1)){                                                                                        //
                    System.out.println("Problem adding edge from "+RedBlock1.getLabel()+" to "+InnerRedBlock1.getLabel());                              //
                }                                                                                                                                       //
            }else if(RedBlock1.getArrowDirection().compareTo("Head")==0){         // Case in which first block in section has arrow direction of head   //  
                //System.out.println("@ Head");                                                                                                                                        //
                innerCountRed++;    // Faux block count                                                                                                 //
                if(innerCountRed>RedCount){                                                                                                             //
                    break;                                                                                                                              //
                }                                                                                                                                       //
                RedString1 = "Red"+innerCountRed;    // Renames string of block to grab, next in order                                                  //
                InnerRedBlock1 = RedLine.getBlock(RedString1);    //Next consecutive block in graph                                                     //
                                                                                                                                                        //
                int biDirectional = 0;                                                                                                                  //
                                                                                                                                                        //
                //While loop tries to create edges between blocks of section, must implement edges between sections later                               //
                while(InnerRedBlock1.getSection().compareTo(RedBlock1.getSection())==0){ //Checks that section is the same     <=========\\             //            
                        if(!RedLine.addEdge(InnerRedBlock1, RedBlock1)){                                                                 //             //           
                            System.out.println("Problem adding edge from "+InnerRedBlock1.getLabel()+" to "+ RedBlock1.getLabel());      //             //                                                                                                 //
                        }                                                                                                                //             //
                        //System.out.println("Edge added from "+InnerRedBlock1.getLabel()+" to "+RedBlock1.getLabel());
                        RedBlock1 = InnerRedBlock1; //Moves forward a block                                                              //             //  
                        innerCountRed++;    //Count moves up to reset string                                                             //             //
                        if(innerCountRed>RedCount){                                                                                      //             //
                            break;                                                                                                       //             //
                        }                                                                                                                //             //
                        RedString1 = "Red"+innerCountRed;   //Reset label to move up a block                                             //             //
                        InnerRedBlock1 = RedLine.getBlock(RedString1);  //Next block in table                                            //             //
                        if(InnerRedBlock1.getArrowDirection().startsWith("tail")){                                                       //             //
                            if(!RedLine.addEdge(InnerRedBlock1, RedBlock1)){                                                             //             //
                                System.out.println("Problem adding edge from "+InnerRedBlock1.getLabel()+" to "+ RedBlock1.getLabel());  //             //
                            }                                                                                                            //             //
                            RedBlock1 = InnerRedBlock1;                                                                                  //             //
                            innerCountRed++;                                                                                             //             //
                            if(innerCountRed>RedCount){                                                                                  //             //
                                break;                                                                                                   //             //
                            }                                                                                                            // LINKS RED   //
                            RedString1 = "Red"+innerCountRed;                                                                            //BLOCKS AS IF //
                            InnerRedBlock1 = RedLine.getBlock(RedString1);                                                               //START BLOCK  //
                            if(!RedLine.addEdge(InnerRedBlock1, RedBlock1)){                                                             //IS HEAD AND  //
                                System.out.println("Problem adding edge from "+InnerRedBlock1.getLabel()+" to "+ RedBlock1.getLabel());  //CHECKS IF    //
                            }                                                                                                            //BIDIRECTIONAL//
                            biDirectional = 0;                                                                                           //             //
                            break;  //All inner blocks connect correctly, finally to connect sections                                    //LINKS TO NEXT//
                        }else if(InnerRedBlock1.getArrowDirection().startsWith("head")){                                                 //SECTION IN   //
                            if(!RedLine.addEdge(InnerRedBlock1, RedBlock1)){                                                             //BOTH DIRECTS.//
                                System.out.println("Problem adding edge from "+InnerRedBlock1.getLabel()+" to "+ RedBlock1.getLabel());  //             //
                            }                                                                                                            //             //
                            RedBlock1 = InnerRedBlock1;                                                                                  //             //
                            innerCountRed++;                                                                                             //             //
                            if(innerCountRed>RedCount){                                                                                  //             //
                                break;                                                                                                   //             //
                            }                                                                                                            //             //
                            RedString1 = "Red"+innerCountRed;                                                                            //             //
                            InnerRedBlock1 = RedLine.getBlock(RedString1);                                                               //             //
                            if(!RedLine.addEdge(InnerRedBlock1, RedBlock1)){                                                             //             //
                                System.out.println("Problem adding edge from "+InnerRedBlock1.getLabel()+" to "+RedBlock1.getLabel());   //             //
                            }                                                                                                            //             //
                            if(!RedLine.addEdge(RedBlock1, InnerRedBlock1)){                                                             //             //
                                System.out.println("Problem adding edge from "+RedBlock1.getLabel()+" to "+InnerRedBlock1.getLabel());   //             //
                            }                                                                                                            //             //
                            biDirectional = 1;                                                                                           //             //
                            break;                                                                                                       //             //
                        }                                                                                                                //             //
                }//                                                                                                             <========//             //
                if(biDirectional==1){  // Puts in edges for the other direction if bidirectional                                                        //
                    innerCountRed = currentRed; //Returns innerCountRed to currentRed, the block we started with                                        //
                    while(InnerRedBlock1.getSection().compareTo(RedBlock1.getSection())==0){ //Checks that section is the same  <========\\             //            
                        if(!RedLine.addEdge(RedBlock1, InnerRedBlock1)){      //Adds edge in reverse direction                           //             //           
                            System.out.println("Problem adding edge from "+RedBlock1.getLabel()+" to "+ InnerRedBlock1.getLabel());      //     IF      //                                                                                                 //
                        }                                                                                                                //BIDIRECTIONAL//
                        RedBlock1 = InnerRedBlock1; //Moves forward a block                                                              //LINKS IN     //  
                        innerCountRed++;    //Count moves up to reset string                                                             //REVERSE      //
                        if(innerCountRed>RedCount){                                                                                      //             //
                            break;                                                                                                       //             //
                        }                                                                                                                //             //
                        RedString1 = "Red"+innerCountRed;   //Reset label to move up a block                                             //             //
                        InnerRedBlock1 = RedLine.getBlock(RedString1);  //Next block in table                                            //             //
                    }//                                                                                                         <========//             //
                }                                                                                                             //
            }else if(RedBlock1.getArrowDirection().compareTo("Tail")==0){                                                                               //
                //System.out.println("@ Tail");                                                                                                                                        //
                innerCountRed++;    // Faux block count                                                                                                 //
                if(innerCountRed>RedCount){                                                                                                             //
                    break;                                                                                                                              //
                }                                                                                                                                       //
                RedString1 = "Red"+innerCountRed;    // Renames string of block to grab, next in order                                                  //
                InnerRedBlock1 = RedLine.getBlock(RedString1);    //Next consecutive block in graph                                                     //
                int endOfFile = 0;                                                                                                                      //
                                                                                                                                                        //
                while(InnerRedBlock1.getSection().compareTo(RedBlock1.getSection())==0){ //Checks that section is the same      <========\\             //            
                        if(!RedLine.addEdge(RedBlock1, InnerRedBlock1)){      //Adds edge in reverse direction                           //             //           
                            System.out.println("Problem adding edge from "+RedBlock1.getLabel()+" to "+ InnerRedBlock1.getLabel());      //             //                                                                                                 //
                        }                                                                                                                //LINKS BLOCKS //
                        RedBlock1 = InnerRedBlock1; //Moves forward a block                                                              //AS IF START  //  
                        innerCountRed++;    //Count moves up to reset string                                                             //IS A TAIL AND//
                        if(innerCountRed>RedCount){                                                                                      //             //
                            endOfFile = 1;                                                                                               //             //
                            break;                                                                                                       //             //
                        }                                                                                                                //             //
                        RedString1 = "Red"+innerCountRed;   //Reset label to move up a block                                             //END IS A HEAD//
                        InnerRedBlock1 = RedLine.getBlock(RedString1);  //Next block in table                                            //             //
                }                                                                                                                        //LINKS TO NEXT//
                                                                                                                                         //   SECTION   //
                if(endOfFile!=1){                                                                                                        //             //
                    if(!RedLine.addEdge(RedBlock1, InnerRedBlock1)){                                                                     //             //
                        System.out.println("Problem adding edge from "+RedBlock1.getLabel()+" to "+ InnerRedBlock1.getLabel());//<=======//             //
                    }                                                                                                                                   //
                }                                                                                                                                       //
                                                                                                                                                        //
            }                                                                                                                                           //
            currentRed = innerCountRed;                                                                                                                 //
        }                                                               //                                                     <------------------------||
    }

}

