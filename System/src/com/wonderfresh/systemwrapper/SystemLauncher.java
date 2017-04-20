/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.systemwrapper;

import com.wonderfresh.commons.Time;
import com.wonderfresh.traincontroller.model.TrainController;
import com.wonderfresh.traincontroller.model.Trains;
import com.wonderfresh.trainmodel.TrainModel;
import com.wonderfresh.trainmodel.Train;
import com.wonderfresh.mbo.Mbo;
import com.wonderfresh.commons.TrackSimulator;
import com.wonderfresh.ctc.CTC;
import com.wonderfresh.trackcontroller.TrackController;

/**
 *
 * @author Austin
 */
public class SystemLauncher extends javax.swing.JFrame {
    
    private Trains trainControllers;
    private Train trainModels;
    private Mbo mbo;
    private TrackSimulator trackSimulator;
    private Time time;
    private CTC ctc;
    private TrackController trackController;
    
    /**
     * Creates new form SystemLauncher
     * @param trainControllers
     * @param trainModels
     */
    public SystemLauncher(Trains trainControllers, Train trainModels, Mbo mbo, CTC ctc, TrackController trackController) {
        this.trainControllers = trainControllers;
        this.trainModels = trainModels;
        this.mbo=mbo;
        this.trackSimulator = TrackSimulator.getInstance();
        this.ctc = ctc;
        this.trackController = trackController;
        initComponents();
        time = Time.getInstance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        TrainIDText = new javax.swing.JTextField();
        TrainIDLabel = new javax.swing.JLabel();
        LaunchModelButton = new javax.swing.JButton();
        LaunchControllerButton = new javax.swing.JButton();
        CTCButton = new javax.swing.JButton();
        CommunicationsButton = new javax.swing.JButton();
        TrackControllerButton = new javax.swing.JButton();
        TrackModelButton = new javax.swing.JButton();
        MBOButton = new javax.swing.JButton();
        SpeedButton = new javax.swing.JButton();
        SpeedText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Lucida Grande", 0, 26)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Wonderfresh Train System");
        Title.setToolTipText("");

        TrainIDText.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        TrainIDLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        TrainIDLabel.setLabelFor(TrainIDText);
        TrainIDLabel.setText("TrainID:");

        LaunchModelButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        LaunchModelButton.setText("Model");
        LaunchModelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaunchModelButtonActionPerformed(evt);
            }
        });

        LaunchControllerButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        LaunchControllerButton.setText("Controller");
        LaunchControllerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaunchControllerButtonActionPerformed(evt);
            }
        });

        CTCButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        CTCButton.setText("CTC");
        CTCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CTCButtonActionPerformed(evt);
            }
        });

        CommunicationsButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        CommunicationsButton.setText("Communications");
        CommunicationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommunicationsButtonActionPerformed(evt);
            }
        });

        TrackControllerButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        TrackControllerButton.setText("Track Controller");
        TrackControllerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrackControllerButtonActionPerformed(evt);
            }
        });

        TrackModelButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        TrackModelButton.setText("Track Model");
        TrackModelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrackModelButtonActionPerformed(evt);
            }
        });

        MBOButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        MBOButton.setText("MBO");
        MBOButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBOButtonActionPerformed(evt);
            }
        });

        SpeedButton.setText("Set Clock");
        SpeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpeedButtonActionPerformed(evt);
            }
        });

        SpeedText.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TrainIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TrainIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CTCButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CommunicationsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TrackControllerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TrackModelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(MBOButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LaunchModelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SpeedText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SpeedButton)
                                    .addComponent(LaunchControllerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CTCButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CommunicationsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TrackControllerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TrackModelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MBOButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TrainIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TrainIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LaunchModelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LaunchControllerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpeedButton)
                    .addComponent(SpeedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LaunchModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaunchModelButtonActionPerformed
        int trainID;
        
        try {
            trainID = Integer.parseInt(TrainIDText.getText());
        } catch(NumberFormatException ex) {
            System.out.println("Train id entered incorrectly.");
            return;
        }
        
        TrainModel train = trainModels.getTrain(trainID);
        
        if(train == null) {
            return;
        }
            
        train.launchUI();
    }//GEN-LAST:event_LaunchModelButtonActionPerformed

    private void LaunchControllerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaunchControllerButtonActionPerformed

        int trainID;
        
        try {
            trainID = Integer.parseInt(TrainIDText.getText());
        } catch(NumberFormatException ex) {
            System.out.println("Train id entered incorrectly.");
            return;
        }
        
        TrainController train = trainControllers.getTrainController(trainID);
        
        if(train == null) {
            return;
        }
            
        train.launchUI();
        
    }//GEN-LAST:event_LaunchControllerButtonActionPerformed

    private void CTCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CTCButtonActionPerformed
        ctc.launchUI();
    }//GEN-LAST:event_CTCButtonActionPerformed

    private void CommunicationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommunicationsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CommunicationsButtonActionPerformed

    private void TrackControllerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrackControllerButtonActionPerformed
        trackController.setVisible();
    }//GEN-LAST:event_TrackControllerButtonActionPerformed

    private void TrackModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrackModelButtonActionPerformed
        trackSimulator.launchUI();
    }//GEN-LAST:event_TrackModelButtonActionPerformed

    private void MBOButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBOButtonActionPerformed
        mbo.launchUI();
    }//GEN-LAST:event_MBOButtonActionPerformed

    private void SpeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpeedButtonActionPerformed
        int speed = 0;
        
        try {
            speed = Integer.parseInt(SpeedText.getText());
        } catch(Exception ex) {
            System.out.println("error parsing int");
            return;
        }
        
        if (speed < 0 || speed > 100) {
            System.out.println("out of bounds time speed");
        }
        
        time.setSpeed(speed);
    }//GEN-LAST:event_SpeedButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CTCButton;
    private javax.swing.JButton CommunicationsButton;
    private javax.swing.JButton LaunchControllerButton;
    private javax.swing.JButton LaunchModelButton;
    private javax.swing.JButton MBOButton;
    private javax.swing.JButton SpeedButton;
    private javax.swing.JTextField SpeedText;
    private javax.swing.JLabel Title;
    private javax.swing.JButton TrackControllerButton;
    private javax.swing.JButton TrackModelButton;
    private javax.swing.JLabel TrainIDLabel;
    private javax.swing.JTextField TrainIDText;
    // End of variables declaration//GEN-END:variables
}