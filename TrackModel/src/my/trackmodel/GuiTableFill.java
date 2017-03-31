/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.trackmodel;

import java.io.File;
import javax.swing.JFileChooser;
import trackmodel.BetaBlock;
import trackmodel.TrackGraph;

/**
 *
 * @author kwc12
 */
public class GuiTableFill {
    // When Tables were set up in gui, this code chose the file and filled the table with all the blocks info
    /*private void OpenActionPerformed(java.awt.event.ActionEvent evt) {                                     
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        NotificationField.setText(filename);
        try{
            
            try{
                newTrack.setDataFile(filename);
                newTrack.ExcelToJavaGraph();
            }catch(Exception e){
                NotificationField.setText("(Excel to Graph did not run properly.");
            }
            Object[][] Line;
            Object[][] Specs;
            BetaBlock extractLine;
            int numLine = 2;
            int k;
            for(k=0;k<numLine;k++){
                int theRealCount;
                if(k==0){
                    theRealCount = newTrack.getRedCount();
                }else{
                    theRealCount = newTrack.getGreenCount();
                }
                Line = new Object[theRealCount][8];
                Specs = new Object[theRealCount][7];
                TrackGraph theRealGraph;
                if(k==0){
                    theRealGraph = newTrack.getRedLine();
                }else{
                    theRealGraph = newTrack.getGreenLine();
                }
                System.out.println("About to add data to array.");
                String Name;
                int i;
                for(i = 0; i< theRealCount;i++){
                    if(k==0){
                        Name = "Red"+(i+1);
                    }else{
                        Name = "Green"+(i+1);
                    }
                    System.out.println(Name);
                    extractLine = theRealGraph.getBlock(Name);
                    System.out.println(extractLine.getLabel());
                    Line[i][0] = extractLine.getLine();
                    Line[i][1] = extractLine.getSection();
                    Line[i][2] = (Integer)extractLine.getBlockNum();
                    Line[i][3] = null;
                    Line[i][4] = null;
                    Line[i][5] = null;
                    Line[i][6] = (Integer)extractLine.getSpeedLimit();
                    Line[i][7] = extractLine.getInfraStructure();
                    Specs[i][0] = extractLine.getLine();
                    Specs[i][1] = extractLine.getSection();
                    Specs[i][2] = (Integer)extractLine.getBlockNum();
                    Specs[i][3] = (Double)extractLine.getBlockLength();
                    Specs[i][4] = (Double)extractLine.getBlockGrade();
                    Specs[i][5] = extractLine.getSwitchBlock();
                    Specs[i][6] = extractLine.getArrowDirection();
                }
                if(k==0){
                    RedLineTable.setModel(new javax.swing.table.DefaultTableModel(
                    Line,
                    new String [] {
                        "Line", "Section", "Block #", "Presence Detection", "Signal Lights Normal", "Signal Lights Reverse", "Speed Limit (mph)", "Infrastructure"
                        }
                    ));
                    RedSpecsTable.setModel(new javax.swing.table.DefaultTableModel(
                    Specs,
                    new String [] {
                        "Line", "Section", "Block Number", "Block Length (ft)", "Block Grade (%)", "Switch Block", "Arrow Direction"
                        }
                    ));
                }else{
                    GreenLineTable.setModel(new javax.swing.table.DefaultTableModel(
                    Line,
                    new String [] {
                        "Line", "Section", "Block #", "Presence Detection", "Signal Lights Normal", "Signal Lights Reverse", "Speed Limit (mph)", "Infrastructure"
                        }
                    ));
                    GreenSpecsTable.setModel(new javax.swing.table.DefaultTableModel(
                    Specs,
                    new String [] {
                        "Line", "Section", "Block Number", "Block Length (ft)", "Block Grade (%)", "Switch Block", "Arrow Direction"
                        }
                    ));
                }
            }
            
            
        }catch(Exception e){
            NotificationField.setText("File isn't formatted correctly.");
        }
        
    }    */
}
