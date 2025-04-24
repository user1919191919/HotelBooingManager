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

public class BookingHotel extends javax.swing.JFrame {

    private int selectedId = -1;
    public BookingHotel() {
        initComponents();
        Reset();
        Connect();
        DisplayRooms();
    }
    Connection Con;
    Statement St;
    ResultSet Rs;

    private void Reset(){
        NameTb.setText("");
        PhonenumberTb.setText("");
        RoomnumberTb.setText("");
        RoomtypeCb.setSelectedIndex(-1);
        CapacityCb.setSelectedIndex(-1);
        inDate.setDate(null);
        outDate.setDate(null);
        TotaldaysTb.setText("");
        TotalpriceTb.setText("");
       
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
     
     
   
       private void DisplayRooms() {
    try {
        St = Con.createStatement();
        Rs = St.executeQuery("SELECT \"id\", \"Room number\", \"Type\", \"Capacity\", \"Price\", \"Availability\", \"Floor\" FROM rooms");

        // Создаем кастомную модель таблицы
        DefaultTableModel model = new DefaultTableModel(
            new String[] { "id", "Room number", "Type", "Capacity", "Price", "Availability", "Floor" }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Все ячейки нередактируемы
            }
        };

        // Заполняем модель данными из ResultSet
        while (Rs.next()) {
            model.addRow(new Object[] {
                Rs.getString("id"), // Сохраняем id, но позже скроем столбец
                Rs.getString("Room number"),
                Rs.getString("Type"),
                Rs.getString("Capacity"),
                Rs.getString("Price"),
                Rs.getString("Availability"),
                Rs.getString("Floor")
            });
        }

        // Устанавливаем модель для таблицы
        RoomsTable2.setModel(model);

        // Скрываем столбец id
        RoomsTable2.getColumnModel().getColumn(0).setMinWidth(0);
        RoomsTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        RoomsTable2.getColumnModel().getColumn(0).setWidth(0);

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Ошибка при загрузке номеров: " + e.getMessage());
    }
}
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        HotelTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NameTb = new javax.swing.JTextField();
        PhonenumberTb = new javax.swing.JTextField();
        inDate = new com.toedter.calendar.JDateChooser();
        outDate = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        TotalpriceTb = new javax.swing.JTextField();
        PriceBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        TotaldaysTb = new javax.swing.JTextField();
        DaysBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        RoomnumberTb = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        RoomtypeCb = new javax.swing.JComboBox<>();
        CapacityCb = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        RoomsTable2 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BookBtn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 780, 360));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("BOOKING MANAGER");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Guest Name");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone number");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Check-in Date");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Check-out Date");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));
        jPanel2.add(NameTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, -1));
        jPanel2.add(PhonenumberTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 120, -1));

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
        jPanel2.add(inDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 150, -1));

        outDate.setFont(new java.awt.Font("Apple LiGothic", 1, 14)); // NOI18N
        jPanel2.add(outDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 150, -1));

        jLabel9.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Price");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, -1, -1));
        jPanel2.add(TotalpriceTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 80, -1));

        PriceBtn.setText("P");
        PriceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceBtnActionPerformed(evt);
            }
        });
        jPanel2.add(PriceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 30, -1));

        jLabel11.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total Days");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, -1, -1));
        jPanel2.add(TotaldaysTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 70, -1));

        DaysBtn.setText("D");
        DaysBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaysBtnActionPerformed(evt);
            }
        });
        jPanel2.add(DaysBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 30, -1));

        jLabel12.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Room number");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));
        jPanel2.add(RoomnumberTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, -1));

        jLabel13.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Room Type");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        RoomtypeCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Twin", "Triple", "Quad", "Family", "Suite", " " }));
        jPanel2.add(RoomtypeCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 110, -1));

        CapacityCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        jPanel2.add(CapacityCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 50, -1));

        RoomsTable2.setBackground(new java.awt.Color(204, 204, 255));
        RoomsTable2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        RoomsTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        RoomsTable2.setRowHeight(25);
        RoomsTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoomsTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(RoomsTable2);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1000, 490));

        jLabel15.setFont(new java.awt.Font("Candara Light", 1, 22)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Rooms List");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BookBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BookBtn.setText("Book");
        BookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookBtnActionPerformed(evt);
            }
        });
        jPanel3.add(BookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 130, 50));

        jLabel16.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Capacity");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("log out");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 270, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HotelTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HotelTableMouseClicked

    }//GEN-LAST:event_HotelTableMouseClicked

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

    
    java.util.Date checkIn,checkOut;
    java.sql.Date sqlCheckIn, sqlCheckOut;
    private void BookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookBtnActionPerformed
        if (NameTb.getText().isEmpty() || PhonenumberTb.getText().isEmpty() ||
        RoomnumberTb.getText().isEmpty() || RoomtypeCb.getSelectedIndex() == -1 ||
        CapacityCb.getSelectedIndex() == -1 || inDate.getDate() == null ||
        outDate.getDate() == null || TotaldaysTb.getText().isEmpty() ||
        TotalpriceTb.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields!");
        return;
    }

    // Проверка корректности номера комнаты
    String roomNumberText = RoomnumberTb.getText();
    try {
        int roomNumber = Integer.parseInt(roomNumberText);
        if (roomNumber < 100 || roomNumber > 400) {
            JOptionPane.showMessageDialog(this, "Room number must be between 100 and 400!");
            RoomnumberTb.setText("");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Room number must be a valid integer!");
        RoomnumberTb.setText("");
        return;
    }

    try {
        // Проверка статуса комнаты
        String checkQuery = "SELECT \"Availability\" FROM rooms WHERE \"Room number\" = ?";
        PreparedStatement checkStmt = Con.prepareStatement(checkQuery);
        checkStmt.setString(1, roomNumberText);
        ResultSet checkRs = checkStmt.executeQuery();
        if (checkRs.next()) {
            String availability = checkRs.getString("Availability");
            if ("Booked".equals(availability)) {
                JOptionPane.showMessageDialog(this, "This room is already booked!");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Room not found!");
            return;
        }
        checkStmt.close();
        checkRs.close();

        // Получаем даты из компонентов
        java.util.Date checkIn = inDate.getDate();
        java.util.Date checkOut = outDate.getDate();

        // Преобразуем в SQL-формат
        java.sql.Date sqlCheckIn = new java.sql.Date(checkIn.getTime());
        java.sql.Date sqlCheckOut = new java.sql.Date(checkOut.getTime());

        
        // Подготовка SQL-запроса для вставки бронирования
        PreparedStatement add = Con.prepareStatement(
            "INSERT INTO bookings (\"name\", \"phonenumber\", \"roomnumber\", \"roomtype\", \"capacity\", \"indate\", \"outdate\", \"totaldays\", \"totalprice\") " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );

        add.setString(1, NameTb.getText());
        add.setString(2, PhonenumberTb.getText());
        add.setString(3, roomNumberText);
        add.setString(4, RoomtypeCb.getSelectedItem().toString());
        add.setString(5, CapacityCb.getSelectedItem().toString());
        add.setDate(6, sqlCheckIn);
        add.setDate(7, sqlCheckOut);
        add.setString(8, TotaldaysTb.getText());
        add.setString(9, TotalpriceTb.getText());

        // Выполнение вставки
        int k = add.executeUpdate();

        // Обновление статуса комнаты на Booked
        String updateQuery = "UPDATE rooms SET \"Availability\" = 'Booked' WHERE \"Room number\" = ?";
        PreparedStatement updateStmt = Con.prepareStatement(updateQuery);
        updateStmt.setString(1, roomNumberText);
        updateStmt.executeUpdate();
        updateStmt.close();

        JOptionPane.showMessageDialog(this, "Booking saved successfully!");
        Reset();
        DisplayRooms(); // Обновляем таблицу, чтобы показать новый статус комнаты

        add.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to record booking: " + e.getMessage());
    }

    }//GEN-LAST:event_BookBtnActionPerformed

    private void RoomsTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoomsTable2MouseClicked
        DefaultTableModel model = (DefaultTableModel)RoomsTable2.getModel(); //Connecting to table
        int MyIndex = RoomsTable2.getSelectedRow(); 
        if(MyIndex >= 0){
        selectedId = Integer.parseInt(model.getValueAt(MyIndex,0).toString());
        RoomnumberTb.setText(model.getValueAt(MyIndex, 1).toString());
        RoomtypeCb.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
        CapacityCb.setSelectedItem(model.getValueAt(MyIndex, 3).toString());
        
        
       
        RoomnumberTb.setEditable(false);
        RoomtypeCb.setEnabled(false);
        CapacityCb.setEnabled(false);
        
        
        }
    }//GEN-LAST:event_RoomsTable2MouseClicked

    private void inDateAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_inDateAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_inDateAncestorMoved

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
      new LoginHotel().setVisible(true);
        this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BookBtn;
    private javax.swing.JComboBox<String> CapacityCb;
    private javax.swing.JButton DaysBtn;
    private javax.swing.JTable HotelTable;
    private javax.swing.JTextField NameTb;
    private javax.swing.JTextField PhonenumberTb;
    private javax.swing.JButton PriceBtn;
    private javax.swing.JTextField RoomnumberTb;
    private javax.swing.JTable RoomsTable2;
    private javax.swing.JComboBox<String> RoomtypeCb;
    private javax.swing.JTextField TotaldaysTb;
    private javax.swing.JTextField TotalpriceTb;
    private com.toedter.calendar.JDateChooser inDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser outDate;
    // End of variables declaration//GEN-END:variables
}
