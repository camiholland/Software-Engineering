/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.trackcontroller;

import javax.swing.ListModel;

/**
 *
 * @author obkeel
 */
public abstract class PLCRunner extends Thread {
    
    public abstract String[] getSections();
    
    public abstract String[] getBlocks();
    
    public abstract String getLine();
    
    public abstract void setJListModel(ListModel lm);
    
    public abstract void print(String s);
}
