/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trackmodel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
//import com.wonderfresh.trackmodelUI.TrackModelUI;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Section is max of 21 blocks long
 * 
 * Switch object, accesses values of permanent track and both temp tracks.
 * 
 * @author kwc12
 */
public class TrackModel{
    private static TrackGraph RedLine;
    private static TrackGraph GreenLine;
    private static int RedCount;
    private static int GreenCount;
    private String dataFile;
    private static int temp = 50;
    
    public TrackModel(){
        TrackModel.RedLine = new TrackGraph();
        TrackModel.GreenLine = new TrackGraph();
        TrackModel.RedCount = 0;
        TrackModel.GreenCount = 0;
    }
    
    public int getRedCount(){
        return RedCount;
    }
    
    public int getGreenCount(){
        return GreenCount;
    }
    
    public TrackGraph getRedLine(){
        return RedLine;
    }
    
    public TrackGraph getGreenLine(){
        return GreenLine;
    }
    
    public Section getSection(String line, String Section){
        if(line.equals("Red")){
            return RedLine.getSection(Section);
        }else{
            return GreenLine.getSection(Section);
        }
    }
    
    public void setDataFile(String Address){
        this.dataFile = Address;
    }
    
    /**
     * The current temperature will be multi-threaded and held in the TrackModel
     * @return the current temperature
     */
    public static String getTemp(){
        Random rand = new Random();
        int randTemp = rand.nextInt(((temp+2)-(temp-2)+1)+(temp-2));
        temp = randTemp;
        String StringTemp = String.valueOf(temp);
        return StringTemp;
    }
    static XSSFRow row;
    /**
     * @throws java.lang.Exception
     */
    public void ExcelToJavaGraph()throws Exception {
        //Inside try statement, stream is opened from the chosen data file.
        try (FileInputStream fis = new FileInputStream(new File(dataFile))) {
            // A workbook reference is created from the chosen Excel file.
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            // A spreadsheet object is created to reference the Excel files pages.
            XSSFSheet spreadsheet;
            // Iterator for the rows
            Iterator < Row > rowIterator;
            // Iterator for the columns
            Iterator < Cell > cellIterator;
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////////RED LINE/////////////////////////RED LINE////////////////////RED LINE//////////////////////RED LINE/////////////////////////RED LINE////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            // "spreadsheet" refrences the first sheet of the Excel workbook
            spreadsheet = workbook.getSheetAt(1);
            rowIterator = spreadsheet.iterator();
            row = (XSSFRow) rowIterator.next();
            
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
                            break;
                        case Cell.CELL_TYPE_STRING:
                            String newString = cell.getStringCellValue();
                            ArrayList<Object> temp1 = new ArrayList<>(Arrays.asList(Stringobj));
                            temp1.add(newString);
                            Stringobj = temp1.toArray();                                             // New Object array full of strings
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
                    // Catches the case in which the value of grade is copied from another cell.
                    // Common when grade is 0, thus the value which I initialize it at in the catch block.
                    // The poi tool skips values that aren't hard coded into the Excel sheet.
                    try{
                        speed = intobj[c];
                    }catch(ArrayIndexOutOfBoundsException e){
                        grade = 0.0;
                        speed = intobj[2];
                    }
                    
                    
                    Block tempBlock = new Block(line, Section, num, length, grade, speed, Infrastructure, SwitchBlock, ArrowDirection);
                    if(!RedLine.addBlock(tempBlock, true)){
                        System.out.println("Problem adding block "+tempBlock.getLabel()+" to graph");
                    }
                    RedLine.addToSection(tempBlock);
                    //String sentence = tempBlock.toString();
                    RedCount++;
                    //System.out.println(sentence);
                }

            }   // Loops back up to check for another block
            
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////GREEN LINE//////////////////////////////GREEN LINE//////////////////////////////GREEN LINE/////////////////////////GREEN LINE///////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            // sets up the second spreadsheet in the workbook, expects the green line.
            spreadsheet = workbook.getSheetAt(2);
            rowIterator = spreadsheet.iterator();
            row = (XSSFRow) rowIterator.next();
            cellIterator = row.cellIterator();
            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                String newCol = cell.getStringCellValue();
            }
   
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
                            break;
                        case Cell.CELL_TYPE_STRING:
                            String newString = cell.getStringCellValue();
                            ArrayList<Object> temp2 = new ArrayList<>(Arrays.asList(Stringobj));
                            temp2.add(newString);
                            Stringobj = temp2.toArray();
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
                    
                    
                    Block tempBlock2 = new Block(line, Section, num, length, grade, speed, Infrastructure, SwitchBlock, ArrowDirection);
                    if(!GreenLine.addBlock(tempBlock2, true)){
                        System.out.println("Problem adding block "+ tempBlock2.getLabel()+" to graph.");
                    }
                    GreenLine.addToSection(tempBlock2);
                    //String sentence = tempBlock2.toString();
                    GreenCount++;
                    //System.out.println(sentence);
                }

            }
        }catch(IOException Error){
            System.out.println("Error loading the track model.");
        }
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////CONNECT BLOCKS/////////////////////////CONNECT BLOCKS/////////////////////////////////////CONNECT BLOCKS//////////////////////////CONNECT BLOCKS//////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        /** 
         * Graphs have been filled with all of the vertices (Blocks) that they will need for now.
         * Next is connecting the blocks with edges.
         */
        
       for(int line_no = 0; line_no<2; line_no++){
           
           /**
            * Will be a reference to get a block
            */
           int current_BlockNum_Count = 1;
           /**
            * Will be used to reference a lookahead block
            */
           int secondary_BlockNum_Count;
           /**
            * Reference to the TrackLine in use
            */
           TrackGraph TrackLine_Instance; 
           /**
            * A string describing the color of the TrackLine
            */
           String Track_Color_String;
           /**
            * This variable will be used to describe the limit the loop should go up to
            */
           int LoopLimit;
           
           if(line_no==0){
               
               TrackLine_Instance = RedLine;
               Track_Color_String = "Red";
               LoopLimit = RedCount;
               
           }else{
               
               TrackLine_Instance = GreenLine;
               Track_Color_String = "Green";
               LoopLimit = GreenCount;
               
           }
           // Go through the blocks in order to connect the edges. 
            while(current_BlockNum_Count <= LoopLimit){                 //            `                              <-----------------------||
                                                                                                                                                                         
                /**
                 * Saves the current block count before looking through the upcoming section
                 */
                secondary_BlockNum_Count = current_BlockNum_Count;                                                                                          
                /**
                 * Retrieves the first block using the label created above and referencing the hash table
                 */
                Block Block1 = TrackLine_Instance.getBlock(Track_Color_String, current_BlockNum_Count);                                                        
                                                                                                                                                                         
                /**
                 * Lookahead block initialized.
                 */
                Block Secondary_Block;                                                                                                                                       //
                                                                                                                                                                         //
                if(Block1.getArrowDirection().startsWith("Head")){                                                                                                //
                                                                                                                                                                         //
                    secondary_BlockNum_Count++;                                                                                                                              //
                                                                                                                                                                                                                                                                    
                    /**
                     * Creates a lookahead block
                     */
                    Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String,secondary_BlockNum_Count);                                                                                             
                    
                    if(Secondary_Block!=null){
                        while(Secondary_Block.getArrowDirection().equals("")){
                            TrackLine_Instance.addEdge(Secondary_Block, Block1);
                            // Moves up the first block to the lookahead block position
                            Block1 = Secondary_Block;
                            // Increments the lookahead block count
                            secondary_BlockNum_Count++;
                            
                            // Moves up the loohahead block to the next unseen block
                            Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String, secondary_BlockNum_Count);
                        }
                    }
                    
                    if(Secondary_Block!=null){
                        // The next block can be assumed to still be in order due to no other arrow heads being called.
                        // Even in the case in which the section was only one block long, if the arrow direction began 
                        // with head, it would still lead in this direction.
                        // In the event that the block that the edge leads from is a switch, we will insert those seperately.
                        if(Block1.getSwitchBlock()<0){
                            TrackLine_Instance.addEdge(Secondary_Block, Block1);
                        }

                        if(Block1.getSwitchBlock()<0){
                            // In the case that the section is one block long, the above statement will make a connection to the next section
                            if(!Block1.getArrowDirection().equals("Head/Head") && !Block1.getArrowDirection().equals("Head/Tail")){
                                // One more move forware with the blocks to connect to the next section
                                Block1 = Secondary_Block;
                                secondary_BlockNum_Count++;
                                Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String, secondary_BlockNum_Count);
                                if(Secondary_Block!=null){
                                    TrackLine_Instance.addEdge(Secondary_Block, Block1);
                                }
                            }
                        }
                    }    
                                                                                                                                                                       //
                }else if(Block1.getArrowDirection().startsWith("Tail")){
                    
                    secondary_BlockNum_Count++;
                    Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String, secondary_BlockNum_Count);
                    
                    if(Secondary_Block!=null){
                        while(Secondary_Block.getArrowDirection().equals("")){
                            TrackLine_Instance.addEdge(Block1, Secondary_Block);
                            // Moves up the first block to the lookahead block position
                            Block1 = Secondary_Block;
                            // Increments the lookahead block count
                            secondary_BlockNum_Count++;
                            // Moves up the loohahead block to the next unseen block
                            Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String, secondary_BlockNum_Count);
                        }
                    }
                    
                    if(Secondary_Block!=null){
                        // The next block can be assumed to still be in order due to no other arrow heads being called.
                        // Even in the case in which the section was only one block long, if the arrow direction began 
                        // with tail, it would still lead in the forward direction.
                        // In the event that the block that the edge leads from is a switch, we will insert those seperately.
                        if(Block1.getSwitchBlock()<0){
                            TrackLine_Instance.addEdge(Block1, Secondary_Block);
                        }

                        if(Block1.getSwitchBlock()<0){
                            // In the case that the section is one block long, the above statement will make a connection to the next section
                            if(!Block1.getArrowDirection().equals("Tail/Head")){
                                // One more move forware with the blocks to connect to the next section
                                Block1 = Secondary_Block;
                                secondary_BlockNum_Count++;
                                Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String, secondary_BlockNum_Count);
                                if(Secondary_Block!=null){
                                    TrackLine_Instance.addEdge(Block1, Secondary_Block);
                                }
                            }
                        }
                    }
                }    
                current_BlockNum_Count = secondary_BlockNum_Count;                                                                                                           //
            }
            
            current_BlockNum_Count = LoopLimit;
            
            String BlockString1;
            Block Block1;
            
            while(current_BlockNum_Count > 0){                                  //                                                                  <------------------------||
                                                                                                                                                                         
                /**
                 * Saves the current block count before looking through the upcoming section
                 */
                secondary_BlockNum_Count = current_BlockNum_Count;                                                                                           
                /**
                 * Retrieves the first block using the label created above and referencing the hash table
                 */
                Block1 = TrackLine_Instance.getBlock(Track_Color_String, current_BlockNum_Count);                                                        
                                                                                                                                                                         
                /**
                 * Lookahead block initialized.
                 */
                Block Secondary_Block;                                                                                                                                       //
                                                                                                                                                                         //
                if(Block1.getArrowDirection().endsWith("Head")){                                                                                                //
                                                                                                                                                                         //
                    secondary_BlockNum_Count--;                                                                                                                              //                                                                                              
                    /**
                     * Creates a lookahead block
                     */
                    Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String, secondary_BlockNum_Count);                                                                                             
                    
                    if(Secondary_Block!=null){
                        while(Secondary_Block.getArrowDirection().equals("")){
                            TrackLine_Instance.addEdge(Secondary_Block, Block1);
                            // Moves up the first block to the lookahead block position
                            Block1 = Secondary_Block;
                            // Increments the lookahead block count
                            secondary_BlockNum_Count--;
                            // Moves up the loohahead block to the next unseen block
                            Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String, secondary_BlockNum_Count);
                        }
                    }
                    
                    if(Secondary_Block!=null){
                        // The next block can be assumed to still be in order due to no other arrow heads being called.
                        // Even in the case in which the section was only one block long, if the arrow direction began 
                        // with head, it would still lead in this direction.
                        // In the event that the block that the edge leads from is a switch, we will insert those seperately.
                        if(Block1.getSwitchBlock()<0){
                            TrackLine_Instance.addEdge(Secondary_Block, Block1);
                        }

                        if(Block1.getSwitchBlock()<0){
                            // In the case that the section is one block long, the above statement will make a connection to the next section
                            if(!Block1.getArrowDirection().equals("Head/Head") && !Block1.getArrowDirection().equals("Tail/Head")){
                                // One more move forware with the blocks to connect to the next section
                                Block1 = Secondary_Block;
                                secondary_BlockNum_Count--;
                                Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String, secondary_BlockNum_Count);
                                if(Secondary_Block!=null){
                                    TrackLine_Instance.addEdge(Secondary_Block, Block1);
                                }
                            }
                        }
                    }    
                                                                                                                                                                       //
                }else if(Block1.getArrowDirection().endsWith("Tail")){
                    
                    secondary_BlockNum_Count--;
                    Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String, secondary_BlockNum_Count);
                    
                    if(Secondary_Block!=null){
                        while(Secondary_Block.getArrowDirection().equals("")){
                            TrackLine_Instance.addEdge(Block1, Secondary_Block);
                            // Moves up the first block to the lookahead block position
                            Block1 = Secondary_Block;
                            // Increments the lookahead block count
                            secondary_BlockNum_Count--;
                            // Moves up the loohahead block to the next unseen block
                            Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String, secondary_BlockNum_Count);
                        }
                    }
                    
                    if(Secondary_Block!=null){
                        // The next block can be assumed to still be in order due to no other arrow heads being called.
                        // Even in the case in which the section was only one block long, if the arrow direction began 
                        // with tail, it would still lead in the forward direction.
                        // In the event that the block that the edge leads from is a switch, we will insert those seperately.
                        if(Block1.getSwitchBlock()<0){
                            TrackLine_Instance.addEdge(Block1, Secondary_Block);
                        }

                        if(Block1.getSwitchBlock()<0){
                            // In the case that the section is one block long, the above statement will make a connection to the next section
                            if(!Block1.getArrowDirection().equals("Head/Tail")){
                                // One more move forware with the blocks to connect to the next section
                                Block1 = Secondary_Block;
                                secondary_BlockNum_Count--;
                                Secondary_Block = TrackLine_Instance.getBlock(Track_Color_String, secondary_BlockNum_Count);
                                if(Secondary_Block!=null){
                                    TrackLine_Instance.addEdge(Block1, Secondary_Block);
                                }
                            }
                        }
                    }
                }    
                current_BlockNum_Count = secondary_BlockNum_Count;  
                
            
            }
            
            ///////////////////////////////////////////////////////////////////////////////
            // Add all connections at switches./////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////////////
            
            current_BlockNum_Count = 1;
            int Max_Switch_Num = 0;
            
            // While loop finds highest numbered switch
            while(current_BlockNum_Count <= LoopLimit){
                Block1 = TrackLine_Instance.getBlock(Track_Color_String, current_BlockNum_Count);
                int SwitchNum = Block1.getSwitchBlock();
                if(SwitchNum>=0 && SwitchNum > Max_Switch_Num){
                    Max_Switch_Num = SwitchNum;
                }
                current_BlockNum_Count++;
            }
            
            // A for loop for iterating through the blocks as many times as there are switches            
            for(int i=0; i<Max_Switch_Num; i++){
                
                current_BlockNum_Count = 1;
            
                Block[] blocks_to_be_sorted = new Block[3];
                int s_index = 0;
                
                //Checks for all switch numbers that match the iteration number
                while(current_BlockNum_Count < LoopLimit){
                    Block1 = TrackLine_Instance.getBlock(Track_Color_String, current_BlockNum_Count);
                    if(Block1.getSwitchBlock()==i){
                        blocks_to_be_sorted[s_index] = Block1;
                        s_index++;
                    }
                }
                
                int difference1 = Math.abs(blocks_to_be_sorted[0].getBlockNum()-blocks_to_be_sorted[1].getBlockNum());
                int difference2 = Math.abs(blocks_to_be_sorted[0].getBlockNum()-blocks_to_be_sorted[2].getBlockNum());
                int difference3 = Math.abs(blocks_to_be_sorted[1].getBlockNum()-blocks_to_be_sorted[2].getBlockNum());
                
                Block defaultOne;
                Block defaultTwo;
                Block secondaryBlock;
                // Adds a switch to the track line, but only the secondary block is known, the master and primary are the first two but in no particular order.
                // The Wayside controller will decide the blocks to connect.
                if(difference1<difference2 && difference1 <difference3){
                    TrackLine_Instance.addSwitch(blocks_to_be_sorted[0], blocks_to_be_sorted[1], blocks_to_be_sorted[2]);
                    secondaryBlock = blocks_to_be_sorted[2];
                    defaultOne = blocks_to_be_sorted[0];
                    defaultTwo = blocks_to_be_sorted[1];
                }else if(difference2<difference1 && difference2<difference3){
                    TrackLine_Instance.addSwitch(blocks_to_be_sorted[0], blocks_to_be_sorted[2], blocks_to_be_sorted[1]);
                    secondaryBlock = blocks_to_be_sorted[1];
                    defaultOne = blocks_to_be_sorted[0];
                    defaultTwo = blocks_to_be_sorted[2];
                }else{
                    TrackLine_Instance.addSwitch(blocks_to_be_sorted[1], blocks_to_be_sorted[2], blocks_to_be_sorted[0]);
                    secondaryBlock = blocks_to_be_sorted[0];
                    defaultOne = blocks_to_be_sorted[1];
                    defaultTwo = blocks_to_be_sorted[2];
                }
                
                // Finish adding edges that belong to switch block
        
                TrackLine_Instance.addEdge(defaultOne, defaultTwo, false);
                TrackLine_Instance.addEdge(defaultTwo, defaultOne, false);
                TrackLine_Instance.addEdge(defaultOne, secondaryBlock, false);
                TrackLine_Instance.addEdge(secondaryBlock, defaultOne, false);
                TrackLine_Instance.addEdge(defaultTwo, secondaryBlock, false);
                TrackLine_Instance.addEdge(secondaryBlock, defaultTwo, false);
            }
            
        }
    }
    
}
