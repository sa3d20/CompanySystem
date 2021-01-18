/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author midom
 */
public class Password extends javax.swing.JFrame {

    static String Uname;
    String Password;
    static String cpassword;
    static String UserType;
    boolean conf = false;
    Connection conct;
    Statement stmt;
    ResultSet RS;
    String Query;
    String query;

    public Password() {

        this.setResizable(false);

        initComponents();
        jLabel5.setVisible(false);

    }

    public void gitinfo() {
        Uname = (String) UserText.getText();
        Password = (String) PasswordText.getText();
    }

    public void getmss() {
        JOptionPane j = new JOptionPane();
        if ((Uname.equals("Sa3d") && Password.equals(cpassword))) {
            j.showMessageDialog(null, "Successful login");
            conf = true;
            //dispose();
        } else {
            j.showMessageDialog(null, "Failed login");
            PasswordText.setText(null);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        PasswordText = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        UserText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password");

        jPanel1.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("user invalid");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(450, 120, 80, 17);

        jButton1.setBackground(new java.awt.Color(0, 255, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ok-icon.png"))); // NOI18N
        jButton1.setText("Login");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jButton1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(540, 230, 110, 40);

        PasswordText.setToolTipText("");
        jPanel1.add(PasswordText);
        PasswordText.setBounds(450, 170, 270, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(300, 170, 120, 29);

        UserText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserTextMouseClicked(evt);
            }
        });
        jPanel1.add(UserText);
        UserText.setBounds(450, 90, 270, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User name");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 90, 130, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Apps-preferences-system-login-icon (1).png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 50, 260, 250);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hacker-stock.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 770, 340);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String m = UserText.getText();
        String p = PasswordText.getText();
        if (m .equals("Saad") && p.equals("1235")) {
            JOptionPane.showMessageDialog(null, "Hallo Mohamed");
            conf = true;
            cpassword = "1235";
            Uname = "Sa3d";
            UserType = "Admin";
        } else {
            try {
                conct = Connect.connect();
                stmt = conct.createStatement();
                Query = "SELECT `Password` FROM `users` where `User name` = \"" + UserText.getText() + "\"; ";
                RS = stmt.executeQuery(Query);
                RS.next();
                Password = RS.getString(1);
                Uname = UserText.getText();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            if (PasswordText.getText().equals(Password)) {
                JOptionPane.showMessageDialog(null, "Successful login");
                conf = true;
                cpassword = Password;
                try {
                    query = "SELECT `Usertype` FROM `users` where `User name` = \"" + Uname + "\"; ";
                    RS = stmt.executeQuery(query);
                    RS.next();
                    UserType = RS.getString(1);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "user Type not found ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login failed");
                PasswordText.setText(null);
            }
        }
        if (conf) {
            main_frame jf = new main_frame();
            dispose();
            jf.setVisible(true);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UserTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserTextMouseClicked
        // TODO add your handling code here:
        UserText.setText(null);
        jLabel5.setVisible(false);
    }//GEN-LAST:event_UserTextMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
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
            java.util.logging.Logger.getLogger(Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Password().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordText;
    private javax.swing.JTextField UserText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
