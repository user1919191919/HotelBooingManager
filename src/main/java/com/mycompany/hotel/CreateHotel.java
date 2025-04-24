/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class CreateHotel extends javax.swing.JFrame {

    
    public CreateHotel() {
        initComponents();
        Reset();
        Connect();
        setLocationRelativeTo(null);
    }

    private void Reset(){
        UsernameTb.setText("");
        PasswordTb.setText("");
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @SuppressWarnings("unchecked")
    
    public void Connect() {
    try {
            // Загружаем драйвер PostgreSQL
            Class.forName("org.postgresql.Driver");
            
            // Подключаемся к базе данных
            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/beksultanfinal",
                "postgres", 
                "postgres"
            );
            
            // Сообщаем об успешном подключении
            System.out.println("Connected to the database successfully!");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WelcomeHotel.class.getName()).log(Level.SEVERE, "PostgreSQL JDBC Driver not found!", ex);
        } catch (SQLException ex) {
            Logger.getLogger(WelcomeHotel.class.getName()).log(Level.SEVERE, "Database connection failed!", ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        UsernameTb = new javax.swing.JTextField();
        PasswordTb = new javax.swing.JPasswordField();
        LogoutBtn = new javax.swing.JButton();
        SigninBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Create User");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Candara Light", 1, 21)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Candara Light", 1, 21)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));
        jPanel1.add(UsernameTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 160, 30));
        jPanel1.add(PasswordTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 160, 30));

        LogoutBtn.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(0, 0, 204));
        LogoutBtn.setText("Logout");
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });
        jPanel1.add(LogoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 80, 30));

        SigninBtn.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        SigninBtn.setForeground(new java.awt.Color(0, 0, 204));
        SigninBtn.setText("Sign in");
        SigninBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SigninBtnActionPerformed(evt);
            }
        });
        jPanel1.add(SigninBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 80, 30));

        ResetBtn.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        ResetBtn.setForeground(new java.awt.Color(0, 0, 204));
        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ResetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, -10, 500, 560));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Candara Light", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Hotel");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Candara Light", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Booking");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Candara Light", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Manager");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
       Reset();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void SigninBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SigninBtnActionPerformed
       if(UsernameTb.getText().isEmpty() || PasswordTb.getPassword().length == 0){
            JOptionPane.showMessageDialog(this, "Please fill in all fields ! ");
        }else if (PasswordTb.getPassword().length < 5){
            JOptionPane.showMessageDialog(this, "Password must have minimum 5 symbols! ");
            return;
        }else if(UsernameTb.getText().length() < 5){
            JOptionPane.showMessageDialog(this, "Username must have minimum 5 symbols! ");
            return;
        }else {
            String user =  UsernameTb.getText();
            String pwd = new String(PasswordTb.getPassword());
            
            try {
                
                
                
                if (con == null) {
                JOptionPane.showMessageDialog(this, "Database connection is not established!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
                
               PreparedStatement check = con.prepareStatement("SELECT COUNT(*) FROM users WHERE \"name\" = ?");
               check.setString(1, user);
               ResultSet rs = check.executeQuery();
               rs.next();
               int count = rs.getInt(1);
               check.close();
               
               if (count > 0) {
                   JOptionPane.showMessageDialog(this, "Given username was taken!");
                   return;
               }       
              
                PreparedStatement add = con.prepareStatement("INSERT INTO users  (\"name\", \"password\") VALUES (?, ?)");
                 add.setString(1, user);
                 add.setString(2, pwd);

            

            int k = add.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "User Created Successfully!");
            Reset();
            new LoginHotel().setVisible(true);
            this.dispose();
            
            
            
            add.close(); // Closing the statement to free resources
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
          }
        }
    }//GEN-LAST:event_SigninBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        new LoginHotel().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutBtnActionPerformed

    
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JPasswordField PasswordTb;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton SigninBtn;
    private javax.swing.JTextField UsernameTb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
