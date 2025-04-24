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


public class LoginHotel extends javax.swing.JFrame {

    
    public LoginHotel() {
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

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        UsernameTb = new javax.swing.JTextField();
        PasswordTb = new javax.swing.JPasswordField();
        CreateBtn = new javax.swing.JButton();
        LoginBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(51, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Candara Light", 1, 21)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Candara Light", 1, 21)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        UsernameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameTbActionPerformed(evt);
            }
        });
        jPanel1.add(UsernameTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 160, 30));
        jPanel1.add(PasswordTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 160, 30));

        CreateBtn.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        CreateBtn.setForeground(new java.awt.Color(0, 0, 204));
        CreateBtn.setText("Create");
        CreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CreateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 80, 30));

        LoginBtn.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(0, 0, 204));
        LoginBtn.setText("Login");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        jPanel1.add(LoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 80, 30));

        ResetBtn.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        ResetBtn.setForeground(new java.awt.Color(0, 0, 204));
        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ResetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 90, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 490, 550));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Candara Light", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Hotel");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, 40));

        jLabel2.setFont(new java.awt.Font("Candara Light", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Booking");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Candara Light", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Manager");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameTbActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
       Reset();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
        new CreateHotel().setVisible(true);
        this.dispose();;
    }//GEN-LAST:event_CreateBtnActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
    
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

            if (user.equals("admin") && pwd.equals("admin")) {                
                new HotelManagerAdmin().setVisible(true);
                this.dispose();
            }

            try {
               String sql = "SELECT * FROM users WHERE \"name\" = ? AND \"password\" = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1,user);
                pst.setString(2,pwd);
                rs = pst.executeQuery();

                boolean found = false;

                while (rs.next()) {
                    String uname = rs.getString("name");
                    String password = rs.getString("password");

                    if (user.equals(uname) && pwd.equals(password)) {
                        found = true;
                        break;
                    }
                }

                // if user exists and password is correct it gives access to the program
                if (found) {
                    new BookingHotel().setVisible(true);
                    this.dispose();
                } else {
                    Reset();
                    JOptionPane.showMessageDialog(this, "Username or Password is incorrect!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }     
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateBtn;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPasswordField PasswordTb;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JTextField UsernameTb;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
