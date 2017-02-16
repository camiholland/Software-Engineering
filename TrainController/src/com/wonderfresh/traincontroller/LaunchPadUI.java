/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller;

import com.wonderfresh.traincontroller.model.TrainController;
import com.wonderfresh.traincontroller.model.Trains;

/**
 *
 * @author Austin
 */
public class LaunchPadUI extends javax.swing.JFrame {

    public Trains trains;
    
    /**
     * Creates new form LaunchPadUI
     * @param trains
     */
    public LaunchPadUI(Trains trains) {
        this.trains = trains;
        
        
        //initComboBox();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LaunchComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LaunchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LaunchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jLabel1.setText("Train ID:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("Train Controller Launcher");

        LaunchButton.setText("Launch UI");
        LaunchButton.setToolTipText("");
        LaunchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaunchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LaunchButton)
                    .addComponent(LaunchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LaunchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LaunchButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LaunchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaunchButtonActionPerformed
        int trainID = Integer.parseInt((String)LaunchComboBox.getSelectedItem());

        trains.getTrainController(trains.getTrainControllerIndex(trainID)).launchUI();
    }//GEN-LAST:event_LaunchButtonActionPerformed

    public void initComboBox() {
        int size = trains.size();
        
        System.out.println(size);
        
        for (int i = 0; i < size; i++) {
            int id = trains.getTrainController(i).getTrainId();
            LaunchComboBox.addItem(String.format("%d",id));
        }
    }
    
    public void addTrain(int id) {
        LaunchComboBox.addItem(String.format("%d",id));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LaunchButton;
    private javax.swing.JComboBox<String> LaunchComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
