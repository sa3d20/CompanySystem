/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author midom
 */
public class add_employee extends javax.swing.JFrame {

    private String ID;
    private String Name;
    private String Phone;
    private String Salary;
    private String Incentives;
    Connection conct;
    Statement stmt;

    public add_employee() {
        this.setResizable(false);
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

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        IDText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PhoneText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SalaryText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        IncentivesText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("اضافة موظف");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(null);

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(30, 480, 123, 45);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("رقم الموظف (ID)");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(758, 54, 197, 29);

        IDText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTextActionPerformed(evt);
            }
        });
        jPanel1.add(IDText);
        IDText.setBounds(631, 57, 89, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("الاسم (رباعى)");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(790, 131, 165, 29);

        NameText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextActionPerformed(evt);
            }
        });
        jPanel1.add(NameText);
        NameText.setBounds(141, 134, 579, 29);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("رقم التليفون");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(817, 219, 138, 29);

        PhoneText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PhoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTextActionPerformed(evt);
            }
        });
        jPanel1.add(PhoneText);
        PhoneText.setBounds(520, 222, 200, 29);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("المرتب الاساسى");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(763, 298, 192, 29);

        SalaryText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SalaryText.setText("0.00");
        SalaryText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalaryTextMouseClicked(evt);
            }
        });
        SalaryText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaryTextActionPerformed(evt);
            }
        });
        jPanel1.add(SalaryText);
        SalaryText.setBounds(627, 301, 93, 29);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("الاضافات");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(860, 380, 96, 29);

        IncentivesText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IncentivesText.setText("0.00");
        IncentivesText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IncentivesTextMouseClicked(evt);
            }
        });
        IncentivesText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncentivesTextActionPerformed(evt);
            }
        });
        jPanel1.add(IncentivesText);
        IncentivesText.setBounds(627, 380, 93, 29);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Drive-Floppy-blue-icon.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(190, 480, 123, 45);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OLO2ED011.jpg"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 1020, 620);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(985, 623));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IDTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDTextActionPerformed

    private void NameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextActionPerformed

    private void PhoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTextActionPerformed

    private void SalaryTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaryTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalaryTextActionPerformed

    private void IncentivesTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncentivesTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IncentivesTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ID = IDText.getText();
        Name = NameText.getText();
        Phone = PhoneText.getText();
        Salary = SalaryText.getText();
        Incentives = IncentivesText.getText();
        //mysql Connection-------------------------------------------------------
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            String Query = "INSERT INTO `ashry cool`.`employees` (`ID`, `Name`, `Phone`, `Salary`,`Incontives`) VALUES ('" + ID + "', '" + Name + "', '" + Phone + "', '" + Salary + "','" + Incentives + "');";
            stmt.execute(Query);
            Query = "INSERT INTO `ashry cool`.`service` (`Employee id`,`Service name`, `Price`, `Total`) VALUES ('" + ID + "','حوافز', '" + Incentives + "', '" + Incentives + "');";
            stmt.execute(Query);
            JOptionPane.showMessageDialog(null, "Employee added");
            IDText.setText(null);
            NameText.setText(null);
            PhoneText.setText(null);
            SalaryText.setText(null);
            IncentivesText.setText(null);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SalaryTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalaryTextMouseClicked
        // TODO add your handling code here:
        SalaryText.setText(null);
    }//GEN-LAST:event_SalaryTextMouseClicked

    private void IncentivesTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncentivesTextMouseClicked
        // TODO add your handling code here:
        IncentivesText.setText(null);

    }//GEN-LAST:event_IncentivesTextMouseClicked

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
            java.util.logging.Logger.getLogger(add_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_employee().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDText;
    private javax.swing.JTextField IncentivesText;
    private javax.swing.JTextField NameText;
    private javax.swing.JTextField PhoneText;
    private javax.swing.JTextField SalaryText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
