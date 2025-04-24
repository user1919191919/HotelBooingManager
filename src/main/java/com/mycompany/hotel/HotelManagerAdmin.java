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


public class HotelManagerAdmin extends javax.swing.JFrame {
    private int selectedId = -1;
    
   
    public HotelManagerAdmin() {
        initComponents();
        Reset();
        Connect();
        DisplayRooms();
    }
    
    Connection Con;
    Statement St;
    ResultSet Rs;

    private void Reset(){
        RoomnumberTb.setText("");
        RoomtypeCb.setSelectedIndex(-1);
        CapacityCb.setSelectedIndex(-1);
        PriceTb.setText("");
        AvaiCb.setSelectedIndex(-1);
        FloorCb.setSelectedIndex(-1);
    }
    
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
     
     
      private void DisplayRooms(){
   
        try{
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT \"id\", \"Room number\", \"Type\", \"Capacity\", \"Price\", \"Availability\", \"Floor\" FROM rooms");
            RoomsTable.setModel(DbUtils.resultSetToTableModel(Rs));
            RoomsTable.getColumnModel().getColumn(0).setMinWidth(0);
            RoomsTable.getColumnModel().getColumn(0).setMaxWidth(0);
            RoomsTable.getColumnModel().getColumn(0).setWidth(0);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        HotelTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        HotelTable3 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        HotelTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        HotelTable1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        BookingBtn = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Manager>");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, -1));

        jLabel3.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Booking");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Logout");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Candara Light", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Manage Hotel Rooms");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        HotelTable.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        HotelTable.setForeground(new java.awt.Color(255, 255, 255));
        HotelTable.setModel(new javax.swing.table.DefaultTableModel(
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
        HotelTable.setRowHeight(25);
        HotelTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HotelTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(HotelTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 190, 770, 360));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Manager>");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, -1));

        jLabel7.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Booking");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Logout");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Manager>");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, -1));

        jLabel12.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("Booking");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Logout");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 153));
        jLabel16.setText("Manager>");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, -1));

        jLabel17.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 153));
        jLabel17.setText("Booking");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel18.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 153));
        jLabel18.setText("Logout");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 550));

        jPanel8.setBackground(new java.awt.Color(0, 0, 153));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jLabel20.setFont(new java.awt.Font("Candara Light", 1, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Manage Hotel Rooms");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        HotelTable3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        HotelTable3.setForeground(new java.awt.Color(255, 255, 255));
        HotelTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        HotelTable3.setRowHeight(25);
        HotelTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HotelTable3MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(HotelTable3);

        jPanel8.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 190, 770, 360));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 770, 550));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 550));

        jPanel6.setBackground(new java.awt.Color(0, 0, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jLabel15.setFont(new java.awt.Font("Candara Light", 1, 30)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Manage Hotel Rooms");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        HotelTable2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        HotelTable2.setForeground(new java.awt.Color(255, 255, 255));
        HotelTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        HotelTable2.setRowHeight(25);
        HotelTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HotelTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(HotelTable2);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 190, 770, 360));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 770, 550));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 550));

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Candara Light", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Manage Hotel Rooms");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        HotelTable1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        HotelTable1.setForeground(new java.awt.Color(255, 255, 255));
        HotelTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        HotelTable1.setRowHeight(25);
        HotelTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HotelTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(HotelTable1);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 190, 770, 360));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 770, 550));

        jLabel21.setText("jLabel21");

        jLabel22.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 153));
        jLabel22.setText("Manager>");

        jLabel23.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 153));
        jLabel23.setText("Booking");

        jLabel24.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 153));
        jLabel24.setText("Logout");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 720, 590));

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

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       
    }//GEN-LAST:event_jLabel4MouseClicked

    private void HotelTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HotelTableMouseClicked
        
    }//GEN-LAST:event_HotelTableMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
       
    }//GEN-LAST:event_jLabel8MouseClicked

    private void HotelTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HotelTable1MouseClicked
        
    }//GEN-LAST:event_HotelTable1MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        
    }//GEN-LAST:event_jLabel13MouseClicked

    private void HotelTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HotelTable2MouseClicked
        
    }//GEN-LAST:event_HotelTable2MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
       
    }//GEN-LAST:event_jLabel18MouseClicked

    private void HotelTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HotelTable3MouseClicked
       
    }//GEN-LAST:event_HotelTable3MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
       
    }//GEN-LAST:event_jLabel24MouseClicked

    private void LogoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseClicked
       new WelcomeHotel().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_LogoutBtnMouseClicked

    private void RoomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoomsTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)RoomsTable.getModel(); //Connecting to table
        int MyIndex = RoomsTable.getSelectedRow(); 
        if(MyIndex >= 0){
        selectedId = Integer.parseInt(model.getValueAt(MyIndex,0).toString());
        RoomnumberTb.setText(model.getValueAt(MyIndex, 1).toString());
        RoomtypeCb.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
        CapacityCb.setSelectedItem(model.getValueAt(MyIndex, 3).toString());
        PriceTb.setText(model.getValueAt(MyIndex, 4).toString());
        AvaiCb.setSelectedItem(model.getValueAt(MyIndex, 5).toString());
        FloorCb.setSelectedItem(model.getValueAt(MyIndex, 6).toString());
        }
    }//GEN-LAST:event_RoomsTableMouseClicked

    private void RoomtypeCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomtypeCbActionPerformed
       
    }//GEN-LAST:event_RoomtypeCbActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        if (RoomnumberTb.getText().isEmpty() || RoomtypeCb.getSelectedIndex()==-1 || 
            CapacityCb.getSelectedIndex()==-1 || PriceTb.getText().isEmpty() || 
            AvaiCb.getSelectedIndex()==-1 || FloorCb.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(this, "Please fill in an all fields!");
            return;
        }
        String roomNumberText = RoomnumberTb.getText();
        int roomNumber = Integer.parseInt(roomNumberText);
        if( roomNumber < 100 || roomNumber > 400){
            JOptionPane.showMessageDialog(this, "Room number is incorrect!");
            RoomnumberTb.setText("");
            return;
        }
        
            
       try {
      PreparedStatement add = Con.prepareStatement(
        "INSERT INTO rooms (\"Room number\",\"Type\",\"Capacity\",\"Price\",\"Availability\",\"Floor\")" +
        "VALUES(?,?,?,?,?,?)"
        );

       add.setString(1,RoomnumberTb.getText());
       add.setString(2,RoomtypeCb.getSelectedItem().toString());
       add.setString(3,CapacityCb.getSelectedItem().toString());
       add.setString(4,PriceTb.getText());
       add.setString(5,AvaiCb.getSelectedItem().toString());
       add.setString(6,FloorCb.getSelectedItem().toString());
       
       
       int k = add.executeUpdate();
       JOptionPane.showMessageDialog(this, "Feedback saved successfully!");
       Reset();
       DisplayRooms();
       
       } catch(Exception e){
       JOptionPane.showMessageDialog(this, "Failed to record");
       e.printStackTrace();
     
       }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        if (selectedId == -1) { 
        JOptionPane.showMessageDialog(this, "Please select a room to delete!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    String Query = "DELETE FROM rooms WHERE \"id\" = ?";
    try {
        PreparedStatement pst = Con.prepareStatement(Query);
        pst.setInt(1, selectedId);
        int k = pst.executeUpdate(); 
        if (k == 1) {
            JOptionPane.showMessageDialog(this, "The room has been successfully deleted!");
            Reset();
            selectedId = -1;
            DisplayRooms();
        } else {
            JOptionPane.showMessageDialog(this, "Room not found or could not be deleted!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        pst.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        if (RoomnumberTb.getText().isEmpty() || RoomtypeCb.getSelectedIndex()==-1 || 
            CapacityCb.getSelectedIndex()==-1 || PriceTb.getText().isEmpty() || 
            AvaiCb.getSelectedIndex()==-1 || FloorCb.getSelectedIndex()==-1) {

    JOptionPane.showMessageDialog(this, "Please select the room to be updated!", "Input Error", JOptionPane.ERROR_MESSAGE);
    return;
}
        if(selectedId == -1){
        JOptionPane.showMessageDialog(this, "Please select the room to be updated!", "Input Error", JOptionPane.ERROR_MESSAGE);
    return;
        
        }
    
        String Room = RoomnumberTb.getText().trim();
        String Type = RoomtypeCb.getSelectedItem().toString();
        String Cap = CapacityCb.getSelectedItem().toString(); // Сохраняем как строку
        String Price = PriceTb.getText().trim(); // Сохраняем как строку
        String Avai = AvaiCb.getSelectedItem().toString();
        String Floor = FloorCb.getSelectedItem().toString();

    String Query = "UPDATE rooms SET \"Room number\" = ?, \"Type\" = ?, \"Capacity\" = ?, \"Price\" = ?, \"Availability\" = ?, \"Floor\" = ? WHERE \"id\" = ?";

    try {
        PreparedStatement pst = Con.prepareStatement(Query);
        pst.setString(1, Room);
        pst.setString(2, Type);
        pst.setString(3, Cap);  // Убедитесь, что сохраняете как строку
        pst.setString(4, Price); // Убедитесь, что сохраняете как строку
        pst.setString(5, Avai);
        pst.setString(6, Floor);
        pst.setInt(7, selectedId); // id остаётся числовым, потому что это, скорее всего, integer

    int k = pst.executeUpdate();

    if (k == 1) {
        JOptionPane.showMessageDialog(this, "The room has been successfully updated!");
        Reset();
        DisplayRooms();
    } else {
        JOptionPane.showMessageDialog(this, "Record failed to update!");
    }
    pst.close();
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Database error occurred!", "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void BookingBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookingBtnMouseClicked
        new BookingHotelAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BookingBtnMouseClicked

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HotelManagerAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AvaiCb;
    private javax.swing.JLabel BookingBtn;
    private javax.swing.JComboBox<String> CapacityCb;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JComboBox<String> FloorCb;
    private javax.swing.JTable HotelTable;
    private javax.swing.JTable HotelTable1;
    private javax.swing.JTable HotelTable2;
    private javax.swing.JTable HotelTable3;
    private javax.swing.JLabel LogoutBtn;
    private javax.swing.JTextField PriceTb;
    private javax.swing.JTextField RoomnumberTb;
    private javax.swing.JTable RoomsTable;
    private javax.swing.JComboBox<String> RoomtypeCb;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}





 

/*try {                                                                                                  //qq                   
        
         Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/beksultanfinal", // исправлено "jdbc"
                "postgres", // логин
                "postgres"  // пароль
            );

        
        String sql = "SELECT COUNT(*) FROM rooms WHERE \"Availability\" = 'Available'";
        PreparedStatement pst = conn.prepareStatement(sql); 
        ResultSet rs = pst.executeQuery();

        
        if (rs.next()) {
            int count = rs.getInt(1);
            JOptionPane.showMessageDialog(this, "Количество available rooms: " + count);
        }

       
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ошибка при подключении к базе: " + e.getMessage());
    }
    */ 
