/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author midom
 */
public class add_user extends javax.swing.JFrame {

    static String Name;
    static String Phone ;
    static String UserName ;
    static String Password;
    static Object Usertype ;
    Connection conct;
    Statement stmt;
    public add_user() {
       this.setResizable(false);
        initComponents();
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
    
    //-----------------------------------------------------------------------

        
    }
    public void getInformation(){
        Name = NameText.getText() ;
        Phone = PhoneText.getText();
        UserName = UserText.getText();
        Password = PasswordText1.getText();
        Usertype = UserType.getSelectedItem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        PhoneText = new javax.swing.JTextField();
        UserType = new javax.swing.JComboBox();
        NameText = new javax.swing.JTextField();
        UserText = new javax.swing.JTextField();
        PasswordText1 = new javax.swing.JPasswordField();
        PasswordText2 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add User");

        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Exit");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(660, 360, 110, 31);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 0));
        jLabel9.setText("The password is samed");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(250, 300, 190, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("The password is not the same");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(250, 300, 220, 17);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-list-add-user-icon.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(540, 360, 110, 33);

        PhoneText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(PhoneText);
        PhoneText.setBounds(250, 120, 160, 28);

        UserType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UserType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select....", "Admin", "Manger", "Employee", "Accountant", "Driver", " " }));
        jPanel1.add(UserType);
        UserType.setBounds(250, 320, 250, 28);

        NameText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(NameText);
        NameText.setBounds(250, 60, 430, 30);

        UserText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(UserText);
        UserText.setBounds(250, 170, 160, 28);

        PasswordText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PasswordText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordText1ActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordText1);
        PasswordText1.setBounds(250, 220, 250, 28);

        PasswordText2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PasswordText2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordText2MouseClicked(evt);
            }
        });
        PasswordText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordText2ActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordText2);
        PasswordText2.setBounds(250, 270, 250, 28);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Confirm password");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 270, 170, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Password");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 220, 90, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("User type");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 320, 100, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("User name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 170, 110, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Phone");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 120, 60, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 60, 60, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OLO2ED0.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(809, 466));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordText1ActionPerformed

    private void PasswordText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordText2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_PasswordText2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!PasswordText1.getText().equals(PasswordText2.getText()))
            jLabel8.setVisible(true);
        
        if(UserType.getSelectedItem().equals("Select...."))
            JOptionPane.showMessageDialog(null,"Select user type");
        else{
        Name = NameText.getText() ;
        Phone = PhoneText.getText();
        UserName = UserText.getText();
        Password = PasswordText1.getText();
        Usertype = UserType.getSelectedItem();
        //mysql Connection-------------------------------------------------------
            try{
        conct = Connect.connect();
        stmt = conct.createStatement();
        String Query = "INSERT INTO `ashry cool`.`users` ( `Name`, `Phone`, `User name`, `Password`, `Usertype`) VALUES ( '"+Name+"', '"+Phone+"', '"+UserName+"', '"+Password+"', '"+Usertype+"');";
        stmt.execute(Query);
        JOptionPane.showMessageDialog(null, "User added");
        NameText.setText(null);
        PhoneText.setText(null);
        UserText.setText(null);
        PasswordText1.setText(null);
        PasswordText2.setText(null);
        UserType.setSelectedItem("Select....");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            
    } 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static int getTEXT_CURSOR() {
        return TEXT_CURSOR;
    }

    private void PasswordText2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordText2MouseClicked
        // TODO add your handling code here:
        jLabel8.setVisible(false);
        PasswordText2.setText(null);
    }//GEN-LAST:event_PasswordText2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(add_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_user().setVisible(true);
            }
        });
       
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NameText;
    private javax.swing.JPasswordField PasswordText1;
    private javax.swing.JPasswordField PasswordText2;
    private javax.swing.JTextField PhoneText;
    private javax.swing.JTextField UserText;
    private javax.swing.JComboBox UserType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}