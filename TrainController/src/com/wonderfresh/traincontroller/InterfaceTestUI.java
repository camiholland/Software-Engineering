/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller;

/**
 *
 * @author Austin
 */
public class InterfaceTestUI extends javax.swing.JPanel {

    TrainControllerInterfaceImpl trains;
    

    public InterfaceTestUI(TrainControllerInterfaceImpl trains) {
        initComponents();
        
        this.trains = trains;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SpeedText = new javax.swing.JTextField();
        AuthText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SpeedAndAuthButton = new javax.swing.JButton();
        SpeedLimitText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SpeedLimitButton = new javax.swing.JButton();
        DoorsText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        LeftButton = new javax.swing.JButton();
        RightButton = new javax.swing.JButton();
        RealSpeedText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SpeedButton = new javax.swing.JButton();
        TempText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TempButton = new javax.swing.JButton();
        LightsText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        LightsButton = new javax.swing.JButton();
        ACText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ACButton = new javax.swing.JButton();
        HeatText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        HeatButton = new javax.swing.JButton();
        StationText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BeaconButton = new javax.swing.JButton();
        StationDoorsText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        DistanceText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        BrakeButton = new javax.swing.JButton();
        PowerButton = new javax.swing.JButton();

        jLabel1.setText("Speed:");

        jLabel2.setText("Auth:");

        SpeedAndAuthButton.setText("SetSpeedAndAuth");
        SpeedAndAuthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpeedAndAuthButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Speed Limit:");

        SpeedLimitButton.setText("SetSpeedLimit");
        SpeedLimitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpeedLimitButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Doors:");

        LeftButton.setText("Left");
        LeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftButtonActionPerformed(evt);
            }
        });

        RightButton.setText("Right");
        RightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Real Speed:");

        SpeedButton.setText("SetSpeed");
        SpeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpeedButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Temperature:");

        TempButton.setText("SetTemperature");
        TempButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TempButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Lights:");

        LightsButton.setText("SetLights");
        LightsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LightsButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("AC:");

        ACButton.setText("SetAC");
        ACButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Heat:");

        HeatButton.setText("SetHeat");
        HeatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeatButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Station:");

        BeaconButton.setText("SendBeaconInfo");
        BeaconButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeaconButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("Doors:");

        jLabel12.setText("Distance:");

        BrakeButton.setText("FailBrake");
        BrakeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrakeButtonActionPerformed(evt);
            }
        });

        PowerButton.setText("FailPower");
        PowerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PowerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BrakeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DistanceText)
                            .addComponent(StationDoorsText)
                            .addComponent(StationText)
                            .addComponent(HeatText, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(ACText)
                            .addComponent(LightsText)
                            .addComponent(TempText)
                            .addComponent(RealSpeedText)
                            .addComponent(DoorsText)
                            .addComponent(SpeedLimitText)
                            .addComponent(SpeedText)
                            .addComponent(AuthText))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(SpeedButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LeftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(RightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(SpeedAndAuthButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SpeedLimitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TempButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LightsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ACButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HeatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BeaconButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(PowerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SpeedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AuthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(SpeedAndAuthButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpeedLimitText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(SpeedLimitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoorsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(LeftButton)
                    .addComponent(RightButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RealSpeedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(SpeedButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TempText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(TempButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LightsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(LightsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ACText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(ACButton))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HeatText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(HeatButton))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StationDoorsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(BeaconButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DistanceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BrakeButton)
                    .addComponent(PowerButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SpeedAndAuthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpeedAndAuthButtonActionPerformed
        int speed = Integer.parseInt(SpeedText.getText());
        double auth = Double.parseDouble(AuthText.getText());
        
        trains.setSpeedAndAuth(speed, auth, 1);
    }//GEN-LAST:event_SpeedAndAuthButtonActionPerformed

    private void SpeedLimitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpeedLimitButtonActionPerformed
        int speed = Integer.parseInt(SpeedLimitText.getText());
        
        trains.setSpeedLimit(speed, 1);
    }//GEN-LAST:event_SpeedLimitButtonActionPerformed

    private void LeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftButtonActionPerformed
        int status = Integer.parseInt(DoorsText.getText());
        
        trains.setLeftDoors(status,1);
    }//GEN-LAST:event_LeftButtonActionPerformed

    private void RightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightButtonActionPerformed
        int status = Integer.parseInt(DoorsText.getText());
        
        trains.setRightDoors(status,1);
    }//GEN-LAST:event_RightButtonActionPerformed

    private void SpeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpeedButtonActionPerformed
        double speed = Double.parseDouble(RealSpeedText.getText());
        
        trains.setSpeed(speed,1);
    }//GEN-LAST:event_SpeedButtonActionPerformed

    private void TempButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TempButtonActionPerformed
        int temp = Integer.parseInt(TempText.getText());
        
        trains.setTemperature(temp,1);
    }//GEN-LAST:event_TempButtonActionPerformed

    private void LightsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LightsButtonActionPerformed
        int status = Integer.parseInt(LightsText.getText());
        
        trains.setLights(status,1);
    }//GEN-LAST:event_LightsButtonActionPerformed

    private void ACButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACButtonActionPerformed
        int status = Integer.parseInt(ACText.getText());
        
        trains.setAirConditioning(status,1);
    }//GEN-LAST:event_ACButtonActionPerformed

    private void HeatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeatButtonActionPerformed
        int status = Integer.parseInt(HeatText.getText());
        
        trains.setHeating(status,1);
    }//GEN-LAST:event_HeatButtonActionPerformed

    private void BeaconButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeaconButtonActionPerformed
        int doors = Integer.parseInt(StationDoorsText.getText());
        
        boolean door = true;
        
        if (doors == 1) {
            door = false;
        }
        
        String station = StationText.getText();
        int distance = Integer.parseInt(DistanceText.getText());
        
        trains.sendBeaconInfo(door, distance, station, 1);
    }//GEN-LAST:event_BeaconButtonActionPerformed

    private void BrakeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrakeButtonActionPerformed
        trains.failBrake(1);
    }//GEN-LAST:event_BrakeButtonActionPerformed

    private void PowerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerButtonActionPerformed
        trains.failPower(1);
    }//GEN-LAST:event_PowerButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACButton;
    private javax.swing.JTextField ACText;
    private javax.swing.JTextField AuthText;
    private javax.swing.JButton BeaconButton;
    private javax.swing.JButton BrakeButton;
    private javax.swing.JTextField DistanceText;
    private javax.swing.JTextField DoorsText;
    private javax.swing.JButton HeatButton;
    private javax.swing.JTextField HeatText;
    private javax.swing.JButton LeftButton;
    private javax.swing.JButton LightsButton;
    private javax.swing.JTextField LightsText;
    private javax.swing.JButton PowerButton;
    private javax.swing.JTextField RealSpeedText;
    private javax.swing.JButton RightButton;
    private javax.swing.JButton SpeedAndAuthButton;
    private javax.swing.JButton SpeedButton;
    private javax.swing.JButton SpeedLimitButton;
    private javax.swing.JTextField SpeedLimitText;
    private javax.swing.JTextField SpeedText;
    private javax.swing.JTextField StationDoorsText;
    private javax.swing.JTextField StationText;
    private javax.swing.JButton TempButton;
    private javax.swing.JTextField TempText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}