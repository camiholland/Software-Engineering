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
public class TrainControllerUI extends javax.swing.JFrame {

    /**
     * Creates new form TrainControllerUI
     */
    public TrainControllerUI() {
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

        ACButtons = new javax.swing.ButtonGroup();
        HeatButtons = new javax.swing.ButtonGroup();
        LightsButtons = new javax.swing.ButtonGroup();
        LeftDoorButtons = new javax.swing.ButtonGroup();
        RightDoorButtons = new javax.swing.ButtonGroup();
        ModeButtons = new javax.swing.ButtonGroup();
        CarControlsPane = new javax.swing.JPanel();
        ACLabel = new javax.swing.JLabel();
        ACOn = new javax.swing.JRadioButton();
        ACOff = new javax.swing.JRadioButton();
        ACFail = new javax.swing.JRadioButton();
        HeatLabel = new javax.swing.JLabel();
        HeatOn = new javax.swing.JRadioButton();
        HeatOff = new javax.swing.JRadioButton();
        HeatFail = new javax.swing.JRadioButton();
        LightsLabel = new javax.swing.JLabel();
        LightsOn = new javax.swing.JRadioButton();
        LightsOff = new javax.swing.JRadioButton();
        LightsFail = new javax.swing.JRadioButton();
        LeftDoorLabel = new javax.swing.JLabel();
        LeftDoorOpen = new javax.swing.JRadioButton();
        LeftDoorClosed = new javax.swing.JRadioButton();
        LeftDoorFail = new javax.swing.JRadioButton();
        RightDoorLabel = new javax.swing.JLabel();
        RightDoorOpen = new javax.swing.JRadioButton();
        RightDoorClosed = new javax.swing.JRadioButton();
        RightDoorFail = new javax.swing.JRadioButton();
        IDPane = new javax.swing.JPanel();
        TrainIDLabel = new javax.swing.JLabel();
        TrainIDText = new javax.swing.JTextField();
        RouteIDLabel = new javax.swing.JLabel();
        RouteIDText = new javax.swing.JTextField();
        SpeedLabel = new javax.swing.JLabel();
        SpeedText = new javax.swing.JTextField();
        PowerText = new javax.swing.JTextField();
        PowerLabel = new javax.swing.JLabel();
        ModePane = new javax.swing.JPanel();
        ModeMan = new javax.swing.JRadioButton();
        ModeAuto = new javax.swing.JRadioButton();
        SpeedPane = new javax.swing.JPanel();
        SpeedSlider = new javax.swing.JSlider();
        SetSpeedLabel = new javax.swing.JLabel();
        SetSpeedText = new javax.swing.JTextField();
        StopButton = new javax.swing.JButton();
        BlockLimitPane = new javax.swing.JPanel();
        BlockLimitLabel1 = new javax.swing.JLabel();
        BlockLimitLabel2 = new javax.swing.JLabel();
        BlockLimitText = new javax.swing.JTextField();
        NotificationsPane = new javax.swing.JPanel();
        MovementPane = new javax.swing.JPanel();
        MovementText = new javax.swing.JTextField();
        GainPane = new javax.swing.JPanel();
        KpLabel = new javax.swing.JLabel();
        KiLabel = new javax.swing.JLabel();
        KpText = new javax.swing.JTextField();
        KiText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CarControlsPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Car Controls", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 16))); // NOI18N
        CarControlsPane.setToolTipText("");
        CarControlsPane.setName(""); // NOI18N

        ACLabel.setText("A/C");
        ACLabel.setToolTipText("");

        ACButtons.add(ACOn);
        ACOn.setSelected(true);
        ACOn.setText("On");

        ACButtons.add(ACOff);
        ACOff.setText("Off");

        ACButtons.add(ACFail);
        ACFail.setText("Fail");

        HeatLabel.setText("Heat");
        HeatLabel.setToolTipText("");

        HeatButtons.add(HeatOn);
        HeatOn.setText("On");
        HeatOn.setToolTipText("");

        HeatButtons.add(HeatOff);
        HeatOff.setSelected(true);
        HeatOff.setText("Off");

        HeatButtons.add(HeatFail);
        HeatFail.setText("Fail");

        LightsLabel.setText("Lights");

        LightsButtons.add(LightsOn);
        LightsOn.setSelected(true);
        LightsOn.setText("On");
        LightsOn.setToolTipText("");

        LightsButtons.add(LightsOff);
        LightsOff.setText("Off");

        LightsButtons.add(LightsFail);
        LightsFail.setText("Fail");

        LeftDoorLabel.setText("LeftDoors");

        LeftDoorButtons.add(LeftDoorOpen);
        LeftDoorOpen.setText("Open");
        LeftDoorOpen.setToolTipText("");

        LeftDoorButtons.add(LeftDoorClosed);
        LeftDoorClosed.setSelected(true);
        LeftDoorClosed.setText("Closed");

        LeftDoorButtons.add(LeftDoorFail);
        LeftDoorFail.setText("Fail");

        RightDoorLabel.setText("Right Doors");

        RightDoorButtons.add(RightDoorOpen);
        RightDoorOpen.setText("Open");
        RightDoorOpen.setToolTipText("");

        RightDoorButtons.add(RightDoorClosed);
        RightDoorClosed.setSelected(true);
        RightDoorClosed.setText("Closed");

        RightDoorButtons.add(RightDoorFail);
        RightDoorFail.setText("Fail");

        javax.swing.GroupLayout CarControlsPaneLayout = new javax.swing.GroupLayout(CarControlsPane);
        CarControlsPane.setLayout(CarControlsPaneLayout);
        CarControlsPaneLayout.setHorizontalGroup(
            CarControlsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CarControlsPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CarControlsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CarControlsPaneLayout.createSequentialGroup()
                        .addGroup(CarControlsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CarControlsPaneLayout.createSequentialGroup()
                                .addComponent(HeatOn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HeatOff)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HeatFail))
                            .addGroup(CarControlsPaneLayout.createSequentialGroup()
                                .addComponent(ACOn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ACOff)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ACFail))
                            .addComponent(ACLabel)
                            .addComponent(HeatLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CarControlsPaneLayout.createSequentialGroup()
                        .addGroup(CarControlsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CarControlsPaneLayout.createSequentialGroup()
                                .addComponent(LeftDoorOpen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LeftDoorClosed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LeftDoorFail))
                            .addGroup(CarControlsPaneLayout.createSequentialGroup()
                                .addComponent(RightDoorOpen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RightDoorClosed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RightDoorFail))
                            .addComponent(RightDoorLabel)
                            .addComponent(LeftDoorLabel)
                            .addComponent(LightsLabel)
                            .addGroup(CarControlsPaneLayout.createSequentialGroup()
                                .addComponent(LightsOn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LightsOff)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LightsFail)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        CarControlsPaneLayout.setVerticalGroup(
            CarControlsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CarControlsPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ACLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CarControlsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ACOn)
                    .addComponent(ACOff)
                    .addComponent(ACFail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HeatLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CarControlsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HeatOn)
                    .addComponent(HeatOff)
                    .addComponent(HeatFail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LightsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CarControlsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LightsOn)
                    .addComponent(LightsOff)
                    .addComponent(LightsFail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LeftDoorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CarControlsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LeftDoorOpen)
                    .addComponent(LeftDoorClosed)
                    .addComponent(LeftDoorFail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RightDoorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CarControlsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RightDoorOpen)
                    .addComponent(RightDoorClosed)
                    .addComponent(RightDoorFail)))
        );

        IDPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 16))); // NOI18N

        TrainIDLabel.setText("Train ID:");

        RouteIDLabel.setText("Route ID:");

        SpeedLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        SpeedLabel.setText("Speed:");

        SpeedText.setText("55");

        PowerText.setText("30");

        PowerLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        PowerLabel.setText("Power:");

        javax.swing.GroupLayout IDPaneLayout = new javax.swing.GroupLayout(IDPane);
        IDPane.setLayout(IDPaneLayout);
        IDPaneLayout.setHorizontalGroup(
            IDPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IDPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IDPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RouteIDLabel)
                    .addGroup(IDPaneLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(IDPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PowerLabel)
                            .addComponent(SpeedLabel)))
                    .addComponent(TrainIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(IDPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TrainIDText)
                    .addComponent(SpeedText, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(RouteIDText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PowerText))
                .addContainerGap())
        );
        IDPaneLayout.setVerticalGroup(
            IDPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IDPaneLayout.createSequentialGroup()
                .addGroup(IDPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TrainIDLabel)
                    .addComponent(TrainIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(IDPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RouteIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RouteIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(IDPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpeedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpeedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(IDPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PowerLabel)
                    .addComponent(PowerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        ModePane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mode", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 16))); // NOI18N

        ModeButtons.add(ModeMan);
        ModeMan.setText("Man");

        ModeButtons.add(ModeAuto);
        ModeAuto.setSelected(true);
        ModeAuto.setText("Auto");
        ModeAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModeAutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ModePaneLayout = new javax.swing.GroupLayout(ModePane);
        ModePane.setLayout(ModePaneLayout);
        ModePaneLayout.setHorizontalGroup(
            ModePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ModeMan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModeAuto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ModePaneLayout.setVerticalGroup(
            ModePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModePaneLayout.createSequentialGroup()
                .addGroup(ModePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModeMan)
                    .addComponent(ModeAuto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SpeedPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Set Speed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 16))); // NOI18N

        SpeedSlider.setMaximum(80);
        SpeedSlider.setMinorTickSpacing(5);
        SpeedSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        SpeedSlider.setPaintTicks(true);
        SpeedSlider.setValue(55);

        SetSpeedLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        SetSpeedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SetSpeedLabel.setText("MPH");

        SetSpeedText.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        SetSpeedText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SetSpeedText.setText("55");

        javax.swing.GroupLayout SpeedPaneLayout = new javax.swing.GroupLayout(SpeedPane);
        SpeedPane.setLayout(SpeedPaneLayout);
        SpeedPaneLayout.setHorizontalGroup(
            SpeedPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpeedPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SpeedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SpeedPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SetSpeedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SetSpeedText))
                .addContainerGap())
        );
        SpeedPaneLayout.setVerticalGroup(
            SpeedPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpeedPaneLayout.createSequentialGroup()
                .addComponent(SpeedSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SpeedPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SetSpeedText, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SetSpeedLabel)
                .addGap(85, 85, 85))
        );

        StopButton.setBackground(new java.awt.Color(255, 92, 92));
        StopButton.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        StopButton.setText("Emergency\nStop");
        StopButton.setToolTipText("");
        StopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });

        BlockLimitPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BlockLimitLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        BlockLimitLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BlockLimitLabel1.setText("Block Limit");

        BlockLimitLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        BlockLimitLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BlockLimitLabel2.setText("MPH");

        BlockLimitText.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        BlockLimitText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BlockLimitText.setText("55");

        javax.swing.GroupLayout BlockLimitPaneLayout = new javax.swing.GroupLayout(BlockLimitPane);
        BlockLimitPane.setLayout(BlockLimitPaneLayout);
        BlockLimitPaneLayout.setHorizontalGroup(
            BlockLimitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BlockLimitPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BlockLimitText, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(BlockLimitPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BlockLimitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BlockLimitLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BlockLimitLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        BlockLimitPaneLayout.setVerticalGroup(
            BlockLimitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlockLimitPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BlockLimitLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BlockLimitText, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BlockLimitLabel2)
                .addContainerGap())
        );

        NotificationsPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notifications", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 16))); // NOI18N

        javax.swing.GroupLayout NotificationsPaneLayout = new javax.swing.GroupLayout(NotificationsPane);
        NotificationsPane.setLayout(NotificationsPaneLayout);
        NotificationsPaneLayout.setHorizontalGroup(
            NotificationsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        NotificationsPaneLayout.setVerticalGroup(
            NotificationsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        MovementPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MovementText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MovementText.setText("Running");

        javax.swing.GroupLayout MovementPaneLayout = new javax.swing.GroupLayout(MovementPane);
        MovementPane.setLayout(MovementPaneLayout);
        MovementPaneLayout.setHorizontalGroup(
            MovementPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovementPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MovementText)
                .addContainerGap())
        );
        MovementPaneLayout.setVerticalGroup(
            MovementPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovementPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MovementText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GainPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gain", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 16))); // NOI18N

        KpLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        KpLabel.setText("Kp");

        KiLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        KiLabel.setText("Ki");

        KpText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KpTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GainPaneLayout = new javax.swing.GroupLayout(GainPane);
        GainPane.setLayout(GainPaneLayout);
        GainPaneLayout.setHorizontalGroup(
            GainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GainPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GainPaneLayout.createSequentialGroup()
                        .addComponent(KiLabel)
                        .addGap(18, 18, 18)
                        .addComponent(KiText))
                    .addGroup(GainPaneLayout.createSequentialGroup()
                        .addComponent(KpLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(KpText)))
                .addContainerGap())
        );
        GainPaneLayout.setVerticalGroup(
            GainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GainPaneLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(GainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KpLabel)
                    .addComponent(KpText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KiLabel)
                    .addComponent(KiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CarControlsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NotificationsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MovementPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IDPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ModePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SpeedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BlockLimitPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IDPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NotificationsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MovementPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ModePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BlockLimitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(SpeedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(CarControlsPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(GainPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(StopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StopButtonActionPerformed

    private void ModeAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModeAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModeAutoActionPerformed

    private void KpTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KpTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KpTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrainControllerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrainControllerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrainControllerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrainControllerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrainControllerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ACButtons;
    private javax.swing.JRadioButton ACFail;
    private javax.swing.JLabel ACLabel;
    private javax.swing.JRadioButton ACOff;
    private javax.swing.JRadioButton ACOn;
    private javax.swing.JLabel BlockLimitLabel1;
    private javax.swing.JLabel BlockLimitLabel2;
    private javax.swing.JPanel BlockLimitPane;
    private javax.swing.JTextField BlockLimitText;
    private javax.swing.JPanel CarControlsPane;
    private javax.swing.JPanel GainPane;
    private javax.swing.ButtonGroup HeatButtons;
    private javax.swing.JRadioButton HeatFail;
    private javax.swing.JLabel HeatLabel;
    private javax.swing.JRadioButton HeatOff;
    private javax.swing.JRadioButton HeatOn;
    private javax.swing.JPanel IDPane;
    private javax.swing.JLabel KiLabel;
    private javax.swing.JTextField KiText;
    private javax.swing.JLabel KpLabel;
    private javax.swing.JTextField KpText;
    private javax.swing.ButtonGroup LeftDoorButtons;
    private javax.swing.JRadioButton LeftDoorClosed;
    private javax.swing.JRadioButton LeftDoorFail;
    private javax.swing.JLabel LeftDoorLabel;
    private javax.swing.JRadioButton LeftDoorOpen;
    private javax.swing.ButtonGroup LightsButtons;
    private javax.swing.JRadioButton LightsFail;
    private javax.swing.JLabel LightsLabel;
    private javax.swing.JRadioButton LightsOff;
    private javax.swing.JRadioButton LightsOn;
    private javax.swing.JRadioButton ModeAuto;
    private javax.swing.ButtonGroup ModeButtons;
    private javax.swing.JRadioButton ModeMan;
    private javax.swing.JPanel ModePane;
    private javax.swing.JPanel MovementPane;
    private javax.swing.JTextField MovementText;
    private javax.swing.JPanel NotificationsPane;
    private javax.swing.JLabel PowerLabel;
    private javax.swing.JTextField PowerText;
    private javax.swing.ButtonGroup RightDoorButtons;
    private javax.swing.JRadioButton RightDoorClosed;
    private javax.swing.JRadioButton RightDoorFail;
    private javax.swing.JLabel RightDoorLabel;
    private javax.swing.JRadioButton RightDoorOpen;
    private javax.swing.JLabel RouteIDLabel;
    private javax.swing.JTextField RouteIDText;
    private javax.swing.JLabel SetSpeedLabel;
    private javax.swing.JTextField SetSpeedText;
    private javax.swing.JLabel SpeedLabel;
    private javax.swing.JPanel SpeedPane;
    private javax.swing.JSlider SpeedSlider;
    private javax.swing.JTextField SpeedText;
    private javax.swing.JButton StopButton;
    private javax.swing.JLabel TrainIDLabel;
    private javax.swing.JTextField TrainIDText;
    // End of variables declaration//GEN-END:variables
}