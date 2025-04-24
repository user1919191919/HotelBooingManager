/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hotel;

import java.io.File;
import java.io.FileWriter; // Library to export data 
import java.io.IOException; // Error handling
import java.sql.Connection; // Library to connect sql
import java.sql.DriverManager; // Library to connect db
import java.sql.Statement; // Library to prepare requests 
import java.sql.PreparedStatement; // Library to prepare secure requests
import java.sql.ResultSet; // Keeps result of request SELECT (Table with data)
import java.sql.SQLException; //Error handling
import javax.swing.JOptionPane; // To show pop-up windows
import javax.swing.table.DefaultTableModel; // Library to work with JTable
import net.proteanit.sql.DbUtils;


public class BookingHotelAdmin extends javax.swing.JFrame {
        private int selectedId = -1;
    public BookingHotelAdmin() {
        initComponents();
       
        Connect();
        DisplayBookings();
    }
    Connection Con;
    Statement St;
    ResultSet Rs;
    
    
    
     private void Connect() {
        try {
            Class.forName("org.postgresql.Driver"); // Загружаем драйвер
            Con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/beksultanfinal", // исправлено "jdbc"
                "postgres", // логин
                "postgres"  // пароль
            );
            System.out.println("Connected to the database successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("PostgreSQL JDBC Driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection to the database failed.");
        }
    }

   private void DisplayBookings(){
   
    try {
        St = Con.createStatement();
        Rs = St.executeQuery("SELECT \"id\", \"name\", \"phonenumber\", \"roomnumber\", \"roomtype\", \"capacity\", \"indate\", \"outdate\", \"totaldays\", \"totalprice\" FROM bookings");
        RoomsTable1.setModel(DbUtils.resultSetToTableModel(Rs));

        // Скрытие первого столбца (id)
        RoomsTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        RoomsTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        RoomsTable1.getColumnModel().getColumn(0).setMinWidth(0);
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading bookings: " + e.getMessage());
    
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        BookingBtn = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        RoomsTable = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        RoomnumberTb = new javax.swing.JTextField();
        PriceTb = new javax.swing.JTextField();
        CapacityCb = new javax.swing.JComboBox<>();
        AvaiCb = new javax.swing.JComboBox<>();
        RoomtypeCb = new javax.swing.JComboBox<>();
        FloorCb = new javax.swing.JComboBox<>();
        SaveBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        RoomsTable1 = new javax.swing.JTable();
        Update1Btn = new javax.swing.JButton();
        Delete1Btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NameTb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PhonenumberTb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inDate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        outDate = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        TotaldaysTb = new javax.swing.JTextField();
        DaysBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        TotalpriceTb = new javax.swing.JTextField();
        PriceBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        RoomnumberTb1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        RoomtypeCb1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        BookingBtn1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        CapacityCb1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel25.setText("Manager>");
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 120, -1));

        BookingBtn.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        BookingBtn.setText("Booking");
        BookingBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookingBtnMouseClicked(evt);
            }
        });
        jPanel10.add(BookingBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        LogoutBtn.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(0, 0, 153));
        LogoutBtn.setText("Logout");
        LogoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutBtnMouseClicked(evt);
            }
        });
        jPanel10.add(LogoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));
        jPanel9.setForeground(new java.awt.Color(0, 0, 153));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Candara Light", 1, 30)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Manage Hotel Rooms");
        jPanel9.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        RoomsTable.setBackground(new java.awt.Color(204, 204, 255));
        RoomsTable.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        RoomsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Room Number", "Room Type", "Capacity", "Price per Night", "Availability", "Floor"
            }
        ));
        RoomsTable.setRowHeight(25);
        RoomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoomsTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(RoomsTable);

        jPanel9.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 720, 370));

        jLabel29.setFont(new java.awt.Font("Candara Light", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Room Number");
        jPanel9.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, -1));

        jLabel30.setFont(new java.awt.Font("Candara Light", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Room Type");
        jPanel9.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        jLabel31.setFont(new java.awt.Font("Candara Light", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Capacity");
        jPanel9.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jLabel32.setFont(new java.awt.Font("Candara Light", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Price per Night");
        jPanel9.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        jLabel33.setFont(new java.awt.Font("Candara Light", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Availability");
        jPanel9.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel34.setFont(new java.awt.Font("Candara Light", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Floor");
        jPanel9.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));
        jPanel9.add(RoomnumberTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));
        jPanel9.add(PriceTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 100, -1));

        CapacityCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", " " }));
        jPanel9.add(CapacityCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        AvaiCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Booked", " " }));
        jPanel9.add(AvaiCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        RoomtypeCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Twin", "Triple", "Quad", "Family", "Suite", " " }));
        RoomtypeCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomtypeCbActionPerformed(evt);
            }
        });
        jPanel9.add(RoomtypeCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 90, -1));

        FloorCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", " " }));
        jPanel9.add(FloorCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });
        jPanel9.add(SaveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });
        jPanel9.add(UpdateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));

        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        jPanel9.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Candara Light", 1, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Booking List");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        RoomsTable1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        RoomsTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Phone Number", "Room N", "Room T", "Capacity", "inDate", "outDate", "Total Days", "Total Price"
            }
        ));
        RoomsTable1.setRowHeight(25);
        RoomsTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoomsTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(RoomsTable1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 880, 250));

        Update1Btn.setText("Update");
        Update1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update1BtnActionPerformed(evt);
            }
        });
        jPanel1.add(Update1Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, -1, -1));

        Delete1Btn.setText("Delete");
        Delete1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete1BtnActionPerformed(evt);
            }
        });
        jPanel1.add(Delete1Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, -1, -1));

        jLabel1.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Guest Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));
        jPanel1.add(NameTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 110, -1));

        jLabel4.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone number");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        PhonenumberTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhonenumberTbActionPerformed(evt);
            }
        });
        jPanel1.add(PhonenumberTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 110, -1));

        jLabel7.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Check-in Date");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        inDate.setFont(new java.awt.Font("Apple LiGothic", 1, 14)); // NOI18N
        inDate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                inDateAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(inDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 140, -1));

        jLabel8.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Check-out Date");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        outDate.setFont(new java.awt.Font("Apple LiGothic", 1, 14)); // NOI18N
        jPanel1.add(outDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 140, -1));

        jLabel11.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total Days");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));
        jPanel1.add(TotaldaysTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 100, -1));

        DaysBtn.setText("D");
        DaysBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaysBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DaysBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 30, -1));

        jLabel9.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Price");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, -1, -1));
        jPanel1.add(TotalpriceTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 90, -1));

        PriceBtn.setText("P");
        PriceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceBtnActionPerformed(evt);
            }
        });
        jPanel1.add(PriceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 30, -1));

        jLabel12.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Room number");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));
        jPanel1.add(RoomnumberTb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 110, -1));

        jLabel13.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Capacity");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, -1, -1));

        RoomtypeCb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Twin", "Triple", "Quad", "Family", "Suite", " " }));
        jPanel1.add(RoomtypeCb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 90, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel26.setText("Manager");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, -1));

        BookingBtn1.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        BookingBtn1.setText("Booking>");
        BookingBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookingBtn1MouseClicked(evt);
            }
        });
        jPanel3.add(BookingBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 300));

        jLabel14.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Room Type");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        CapacityCb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        jPanel1.add(CapacityCb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Log out");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BookingBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookingBtnMouseClicked
        new BookingHotelAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BookingBtnMouseClicked

    private void LogoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseClicked
        new WelcomeHotel().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutBtnMouseClicked

    private void RoomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoomsTableMouseClicked
      
    }//GEN-LAST:event_RoomsTableMouseClicked

    private void RoomtypeCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomtypeCbActionPerformed

    }//GEN-LAST:event_RoomtypeCbActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
       
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
      
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void BookingBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookingBtn1MouseClicked
        new BookingHotelAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BookingBtn1MouseClicked

    private void PriceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceBtnActionPerformed
        try {
            // Проверка, что даты заезда и выезда не равны null
            if (inDate.getDate() == null || outDate.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Please select both check-in and check-out dates.");
                return;
            }

            // Получаем номер комнаты из поля ввода
            String roomNumber = RoomnumberTb.getText().trim(); // Получаем номер комнаты из поля ввода
            if (roomNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a room number.");
                return;
            }

            // Получаем даты заезда и выезда
            java.util.Date checkIn = inDate.getDate();
            java.util.Date checkOut = outDate.getDate();

            // Преобразуем их в java.sql.Date
            java.sql.Date sqlCheckIn = new java.sql.Date(checkIn.getTime());
            java.sql.Date sqlCheckOut = new java.sql.Date(checkOut.getTime());

            // Рассчитываем разницу в миллисекундах и переводим в дни
            long diffInMillis = sqlCheckOut.getTime() - sqlCheckIn.getTime();
            long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);

            // Проверяем, что дата выезда позже даты заезда
            if (diffInDays <= 0) {
                JOptionPane.showMessageDialog(this, "Check-out date must be after check-in date.");
                return;
            }

            // Подключаемся к базе данных и получаем цену за ночь для выбранной комнаты
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/beksultanfinal", "postgres", "postgres");
            String query = "SELECT \"Price\" FROM rooms WHERE \"Room number\" = ?"; // Ищем по номеру комнаты
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, roomNumber); // Устанавливаем номер комнаты из текстового поля
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int pricePerDay = rs.getInt("Price"); // Извлекаем цену за день из базы данных

                // Рассчитываем общую стоимость
                int totalPrice = (int) diffInDays * pricePerDay;
                TotalpriceTb.setText(String.valueOf(totalPrice)); // Выводим сумму в текстбокс
            } else {
                JOptionPane.showMessageDialog(this, "Room not found in the database.");
            }

            conn.close(); // Закрываем соединение с базой данных

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while calculating the price.");
        }
    }//GEN-LAST:event_PriceBtnActionPerformed

    private void DaysBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaysBtnActionPerformed
        try {
            // Проверка, что даты заезда и выезда не равны null
            if (inDate.getDate() == null || outDate.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Please select both check-in and check-out dates.");
                return;
            }

            // Получаем даты заезда и выезда
            java.util.Date checkIn = inDate.getDate();
            java.util.Date checkOut = outDate.getDate();

            // Преобразуем их в java.sql.Date
            java.sql.Date sqlCheckIn = new java.sql.Date(checkIn.getTime());
            java.sql.Date sqlCheckOut = new java.sql.Date(checkOut.getTime());

            // Рассчитываем разницу в миллисекундах и переводим в дни
            long diffInMillis = sqlCheckOut.getTime() - sqlCheckIn.getTime();
            long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);

            // Проверяем, что дата выезда позже даты заезда
            if (diffInDays <= 0) {
                JOptionPane.showMessageDialog(this, "Check-out date must be after check-in date.");
                return;
            }

            // Выводим количество дней пребывания в текстбокс
            TotaldaysTb.setText(String.valueOf(diffInDays));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while calculating the stay duration.");
        }
    }//GEN-LAST:event_DaysBtnActionPerformed

    private void inDateAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_inDateAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_inDateAncestorMoved

    private void PhonenumberTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhonenumberTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhonenumberTbActionPerformed

    private void Delete1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete1BtnActionPerformed
        if (selectedId == -1) {
        JOptionPane.showMessageDialog(this, "Please select a booking to delete!");
        return;
    }

    try {
        String deleteQuery = "DELETE FROM bookings WHERE \"id\" = ?";
        PreparedStatement deleteStmt = Con.prepareStatement(deleteQuery);
        deleteStmt.setInt(1, selectedId);

        int rowsAffected = deleteStmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Booking deleted successfully!");
            selectedId = -1;
            DisplayBookings();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete booking!");
        }
        deleteStmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error deleting booking: " + e.getMessage());
    }
    }//GEN-LAST:event_Delete1BtnActionPerformed

    private void Update1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update1BtnActionPerformed
           
    if (selectedId == -1) {
        JOptionPane.showMessageDialog(this, "Please select a booking to update!");
        return;
    }

    if (NameTb.getText().isEmpty() || PhonenumberTb.getText().isEmpty() ||
        RoomnumberTb1.getText().isEmpty() || RoomtypeCb1.getSelectedIndex() == -1 ||
        CapacityCb1.getSelectedIndex() == -1 || inDate.getDate() == null ||
        outDate.getDate() == null || TotaldaysTb.getText().isEmpty() ||
        TotalpriceTb.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields!");
        return;
    }

    String roomNumberText = RoomnumberTb1.getText();
    try {
        int roomNumber = Integer.parseInt(roomNumberText);
        if (roomNumber < 100 || roomNumber > 400) {
            JOptionPane.showMessageDialog(this, "Room number must be between 100 and 400!");
            RoomnumberTb1.setText("");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Room number must be a valid integer!");
        RoomnumberTb1.setText("");
        return;
    }

    try {
        java.util.Date checkIn = inDate.getDate();
        java.util.Date checkOut = outDate.getDate();
        java.sql.Date sqlCheckIn = new java.sql.Date(checkIn.getTime());
        java.sql.Date sqlCheckOut = new java.sql.Date(checkOut.getTime());

        String updateQuery = "UPDATE bookings SET \"name\" = ?, \"phonenumber\" = ?, \"roomnumber\" = ?, \"roomtype\" = ?, \"capacity\" = ?, \"indate\" = ?, \"outdate\" = ?, \"totaldays\" = ?, \"totalprice\" = ? WHERE \"id\" = ?";
        PreparedStatement updateStmt = Con.prepareStatement(updateQuery);
        updateStmt.setString(1, NameTb.getText());
        updateStmt.setString(2, PhonenumberTb.getText());
        updateStmt.setString(3, roomNumberText);
        updateStmt.setString(4, RoomtypeCb1.getSelectedItem().toString());
        updateStmt.setString(5, CapacityCb1.getSelectedItem().toString());
        updateStmt.setDate(6, sqlCheckIn);
        updateStmt.setDate(7, sqlCheckOut);
        updateStmt.setString(8, TotaldaysTb.getText());
        updateStmt.setString(9, TotalpriceTb.getText());
        updateStmt.setInt(10, selectedId);

        int rowsAffected = updateStmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Booking updated successfully!");
            DisplayBookings();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update booking!");
        }
        updateStmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating booking: " + e.getMessage());
    }

    }//GEN-LAST:event_Update1BtnActionPerformed
    java.util.Date checkIn,checkOut;
    java.sql.Date sqlCheckIn, sqlCheckOut;
    private void RoomsTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoomsTable1MouseClicked
       
   
   DefaultTableModel model = (DefaultTableModel) RoomsTable1.getModel();
    int selectedRow = RoomsTable1.getSelectedRow();
    if (selectedRow >= 0) {
        selectedId = Integer.parseInt(model.getValueAt(selectedRow, 0).toString()); // id
        NameTb.setText(model.getValueAt(selectedRow, 1).toString()); // name
        PhonenumberTb.setText(model.getValueAt(selectedRow, 2).toString()); // phonenumber
        RoomnumberTb1.setText(model.getValueAt(selectedRow, 3).toString()); // roomnumber
        RoomtypeCb1.setSelectedItem(model.getValueAt(selectedRow, 4).toString()); // roomtype
        CapacityCb1.setSelectedItem(model.getValueAt(selectedRow, 5).toString()); // capacity
        try {
            java.sql.Date inDateValue = java.sql.Date.valueOf(model.getValueAt(selectedRow, 6).toString()); // indate
            java.sql.Date outDateValue = java.sql.Date.valueOf(model.getValueAt(selectedRow, 7).toString()); // outdate
            inDate.setDate(inDateValue);
            outDate.setDate(outDateValue);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Error parsing dates: " + e.getMessage());
        }
        TotaldaysTb.setText(model.getValueAt(selectedRow, 8).toString()); // totaldays
        TotalpriceTb.setText(model.getValueAt(selectedRow, 9).toString()); // totalprice
    }


    }//GEN-LAST:event_RoomsTable1MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
                                             
        new HotelManagerAdmin().setVisible(true);
        this.dispose();
         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new LoginHotel().setVisible(true);
        this.dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(BookingHotelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingHotelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingHotelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingHotelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingHotelAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AvaiCb;
    private javax.swing.JLabel BookingBtn;
    private javax.swing.JLabel BookingBtn1;
    private javax.swing.JComboBox<String> CapacityCb;
    private javax.swing.JComboBox<String> CapacityCb1;
    private javax.swing.JButton DaysBtn;
    private javax.swing.JButton Delete1Btn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JComboBox<String> FloorCb;
    private javax.swing.JLabel LogoutBtn;
    private javax.swing.JTextField NameTb;
    private javax.swing.JTextField PhonenumberTb;
    private javax.swing.JButton PriceBtn;
    private javax.swing.JTextField PriceTb;
    private javax.swing.JTextField RoomnumberTb;
    private javax.swing.JTextField RoomnumberTb1;
    private javax.swing.JTable RoomsTable;
    private javax.swing.JTable RoomsTable1;
    private javax.swing.JComboBox<String> RoomtypeCb;
    private javax.swing.JComboBox<String> RoomtypeCb1;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTextField TotaldaysTb;
    private javax.swing.JTextField TotalpriceTb;
    private javax.swing.JButton Update1Btn;
    private javax.swing.JButton UpdateBtn;
    private com.toedter.calendar.JDateChooser inDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private com.toedter.calendar.JDateChooser outDate;
    // End of variables declaration//GEN-END:variables
}
