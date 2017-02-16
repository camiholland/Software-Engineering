
package mbo;

import java.awt.event.ActionEvent;


public class ui extends javax.swing.JFrame {
    //MY VARIABLES
    public String[] closedTrack= new String[100];
    public String time;
    public int drivers;
    public int redPass;
    public int greenPass;
    public int getData=0;
    
    
    public ui( ) {
        initComponents();
        
    }

    public void setClosedTrack(int i, String s){
        closedTrack[i]=s;
    }
    public void setTime(String s){
        time=s;
        
    }
    @SuppressWarnings("unchecked")                        
    public void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        numberOfDrivers = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        greenText = new javax.swing.JTextField();
        redText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        generateButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        displayWorkers = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        trainScheduleDisplay = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        trainDetails1 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        trainDetails2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayClosedTrack = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        clockLabel = new javax.swing.JLabel();
        clock = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passengerCount = new javax.swing.JTextField();
        mboLabel = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel4.setText("Enter number of Drivers for the week :");
        numberOfDrivers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { }
        });
        jLabel5.setText("Enter the number of passengers for the Green Train:");
         greenText.setText("1000");
         greenText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {}
        });
         redText.setText("1500");
        redText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {}
        });

        jLabel6.setText("Enter the number of passengers for the Red Train:");
        generateButton.setText("Generate");
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(redText, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(greenText)
                            .addComponent(numberOfDrivers)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberOfDrivers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greenText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(redText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jTabbedPane1.addTab("Generate Schedule", jPanel2);
        displayWorkers.setModel(new javax.swing.table.DefaultTableModel(
            new String [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Worker ID", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {return types [columnIndex];  }
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        jScrollPane4.setViewportView(displayWorkers);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 897, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Driver Schedule", jPanel5);

        trainScheduleDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0011", "5:00AM","5:00AM","5:00AM", "5:00AM", "5:00AM","5:00AM", "5:00AM"}, 
                {"0011", "6:00AM","6:00AM","6:00AM", "6:00AM", "6:00AM","6:00AM", "6:00AM"},
                {"0012", "6:30AM","6:30AM","6:30AM", "6:30AM", "6:30AM","---", "---"},
                 {"0011", "7:00AM","7:00AM","7:00AM", "7:00AM", "7:00AM","7:00AM", "7:00AM"},
                 {"0012", "7:30AM","7:30AM","7:30AM", "7:30AM", "7:30AM","---", "---"},
                  {"0011", "8:00AM","8:00AM","8:00AM", "8:00AM", "8:00AM","8:00AM", "8:00AM"},
                  {"0012", "8:30AM","8:30AM","8:30AM", "8:30AM", "8:30AM","---", "---"},
                   {"0011", "9:00AM","9:00AM","9:00AM", "9:00AM", "9:00AM","9:00AM", "9:00AM"},
                  {"0012", "9:30AM","9:30AM","9:30AM", "9:30AM", "9:30AM","---", "---"},
                   {"0011", "10:00AM","10:00AM","10:00AM", "10:00AM", "10:00AM","10:00AM", "10:00AM"},
                  {"0012", "10:30AM","10:30AM","10:30AM", "10:30AM", "10:30AM","---", "---"},
                {"0011", "11:00AM","11:00AM","11:00AM", "11:00AM", "11:00AM","11:00AM", "11:00AM"},
                  {"0012", "11:30AM","11:30AM","11:30AM", "11:30AM", "11:30AM","---", "---"},
                 {"0011", "12:00PM","12:00PM","12:00PM", "12:00PM", "12:00PM","12:00PM", "12:00PM"},
                  {"0012", "12:30PM","12:30PM","12:30PM", "12:30PM", "12:30PM","---", "---"},
                  {"0011", "1:00PM","1:00PM","1:00PM", "1:00PM", "1:00PM","1:00PM", "1:00PM"},
                  {"0012", "1:30PM","1:30PM","1:30PM", "1:30PM", "1:30PM","---", "---"}, 
                   {"0011", "2:00PM","2:00PM","2:00PM", "2:00PM", "2:00PM","2:00PM", "2:00PM"},
                  {"0012", "2:30PM","2:30PM","2:30PM", "2:30PM", "2:30PM","---", "---"}, 
                   {"0011", "3:00PM","3:00PM","3:00PM", "3:00PM", "3:00PM","3:00PM", "3:00PM"},
                  {"0012", "3:30PM","3:30PM","3:30PM", "3:30PM", "3:30PM","---", "---"},
                   {"0011", "4:00PM","4:00PM","4:00PM", "4:00PM", "4:00PM","4:00PM", "4:00PM"},
                  {"0012", "4:30PM","4:30PM","4:30PM", "4:30PM", "4:30PM","---", "---"},
                {"0011", "5:00PM","5:00PM","5:00PM", "5:00PM", "5:00PM","5:00PM", "5:00PM"}, 
                {"0011", "6:00PM","6:00PM","6:00PM", "6:00PM", "6:00PM","6:00PM", "6:00PM"},
                {"0012", "6:30PM","6:30PM","6:30PM", "6:30PM", "6:30PM","---", "---"},
                 {"0011", "7:00PM","7:00PM","7:00PM", "7:00PM", "7:00PM","7:00PM", "7:00PM"},
                 {"0012", "7:30PM","7:30PM","7:30PM", "7:30PM", "7:30PM","---", "---"},
                  {"0011", "8:00PM","8:00PM","8:00PM", "8:00PM", "8:00PM","8:00PM", "8:00PM"},
                  {"0012", "8:30PM","8:30PM","8:30PM", "8:30PM", "8:30PM","---", "---"},
                   {"0011", "9:00PM","9:00PM","9:00PM", "9:00PM", "9:00PM","9:00PM", "9:00PM"},
                  {"0012", "9:30PM","9:30PM","9:30PM", "9:30PM", "9:30PM","---", "---"},
                   {"0011", "10:00PM","10:00PM","10:00PM", "10:00PM", "10:00PM","10:00PM", "10:00PM"},
                  {"0012", "10:30PM","10:30PM","10:30PM", "10:30PM", "10:30PM","---", "---"},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Train ID", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(trainScheduleDisplay);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Green- Yard", "Green- Pioneer", "Green- Edgebrook", "Green- Whited", "Green- South Bank", "Green- Central", "Green- Inglewood", "Green- Overbrook", "Green- Glenbury", "Green- Dormont", "Green- Mt. Lebanon", "Green- Poplar", "Green- Castle Shannon", "Red- YARD", "Red- Shadyside", "Red- Herron Ave.", "Red- Swissvale", "Red- Penn Station", "Red- Steel Plaza", "Red- First Ave.", "Red- Station Square", "Red- South Hill Junct.", " " }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(691, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(422, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Train Schedule", jPanel6);

        jLabel7.setText("Green Trains:");

        jLabel8.setText("Red Trains:");

        trainDetails1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Train ID", "Location", "Speed", "Authority", "Passengers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane8.setViewportView(trainDetails1);

        trainDetails2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Train ID", "Location", "Speed", "Authority", "Passengers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane9.setViewportView(trainDetails2);

        displayClosedTrack.setModel(new javax.swing.table.DefaultTableModel(
            new String [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},  
                {null},
                {null},
                {null},  
                {null}
            },
            new String [] {
                "Closed Tracks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(displayClosedTrack);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Track Details", jPanel8);

        clockLabel.setText("Time:");
        clock.setText("");
        clock.setEditable(false);
        clock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockActionPerformed(evt);
            }
        });

        jLabel2.setText("Total Daily Passengers:");

        passengerCount.setText("               3,456");
        passengerCount.setEditable(false);
        passengerCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passengerCountActionPerformed(evt);
            }
        });
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }

            private void generateButtonActionPerformed(ActionEvent evt) {
                String s=redText.getText();
                int i=Integer.parseInt(s);
                redPass=i; 
                s=greenText.getText();
                i=Integer.parseInt(s);
                greenPass=i;
                s=numberOfDrivers.getText();
                i=Integer.parseInt(s);
                drivers=i;
                    if(drivers>0){
                        if (redPass>0){
                            if (greenPass>0){
                                getData=1;
                            }
                        }
                    }
                }
        });
        
        
        
        mboLabel.setText("MBO & Scheduler");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(mboLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(passengerCount, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(clockLabel)
                .addGap(1, 1, 1)
                .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clockLabel)
                    .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(mboLabel)
                    .addComponent(passengerCount))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    
    
    public void clockActionPerformed(java.awt.event.ActionEvent evt) {}                                           

    public void passengerCountActionPerformed(java.awt.event.ActionEvent evt) {}                                           

    public void redTextActionPerformed(java.awt.event.ActionEvent evt) {}                                           

    public void numberOfDriversActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String s=numberOfDrivers.getText();
        
        int i=Integer.parseInt(s);
        drivers=i;    
        
    }   
    

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
            java.util.logging.Logger.getLogger(ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    public javax.swing.JTable displayClosedTrack;
    public javax.swing.JTable displayWorkers;
    public javax.swing.JTable trainScheduleDisplay;
    public javax.swing.JButton generateButton;
    public javax.swing.JComboBox jComboBox1;
    public javax.swing.JLabel clockLabel;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel mboLabel;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTextField clock;
    public javax.swing.JTextField passengerCount;
    public javax.swing.JTextField numberOfDrivers;
    public javax.swing.JTextField greenText;
    public javax.swing.JTextField redText;
    public javax.swing.JTable trainDetails1;
    public javax.swing.JTable trainDetails2;
    // End of variables declaration    
   
    
     
}

