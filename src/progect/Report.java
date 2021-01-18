/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progect;

import java.awt.AWTException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.MissingFormatArgumentException;
import javax.swing.JTable;

/**
 *
 * @author midom
 */
public class Report extends javax.swing.JFrame {

    Connection conct;
    Statement stmt;
    String Query;
    ResultSet RS;
    String TableClick;
    String id;
    int row;

    public Report() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        fillCustomerList();
        DeleteEmployee1.setVisible(false);
        // DeleteCustomer.enable(false);

    }

    public Report(int x) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        fillEmployeeList();
        DeleteCustomer.setVisible(false);
        DeleteEmployee1.enable(false);

    }

    public Report(float x) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        fillCarList();
        DeleteCustomer.setVisible(false);
        DeleteEmployee1.setVisible(false);

    }

    public Report(double x) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        fillStoreList();
        DeleteCustomer.setVisible(false);
        DeleteEmployee1.setVisible(false);

    }

    public Report(int x, int y) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        fillOutSafeList();
        DeleteCustomer.setVisible(false);
        DeleteEmployee1.setVisible(false);

    }

    public Report(int x, double y) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        fillInSafeList();
        DeleteCustomer.setVisible(false);
        DeleteEmployee1.setVisible(false);

    }

    public void fillCustomerList() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `customers`;";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void fillEmployeeList() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `employees`;";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void fillCarList() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `car services`;";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void fillStoreList() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `categories`;";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void fillOutSafeList() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `out safe`;";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void fillInSafeList() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `in safe`;";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void DeleteCustomer() {
        JOptionPane.showMessageDialog(null, "Do you want to delet this customer");
        try {
            Query = "delete from customers where id = '" + id + "' ";
            conct = Connect.connect();
            stmt = conct.prepareStatement(Query);
            stmt.execute(Query);
            JOptionPane.showMessageDialog(null, "Customer deleted");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        fillCustomerList();

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
        DeleteEmployee1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        DeleteCustomer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        DeleteEmployee1.setBackground(new java.awt.Color(255, 0, 0));
        DeleteEmployee1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DeleteEmployee1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Close-2-icon.png"))); // NOI18N
        DeleteEmployee1.setText("Delete employee");
        DeleteEmployee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEmployee1ActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteEmployee1);
        DeleteEmployee1.setBounds(820, 650, 220, 33);

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print-icon.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(157, 645, 127, 33);

        jButton2.setBackground(new java.awt.Color(51, 0, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(12, 645, 127, 33);

        DeleteCustomer.setBackground(new java.awt.Color(255, 0, 0));
        DeleteCustomer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DeleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Close-2-icon.png"))); // NOI18N
        DeleteCustomer.setText("Delete customer");
        DeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCustomerActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteCustomer);
        DeleteCustomer.setBounds(820, 650, 220, 33);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setRowHeight(20);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 1040, 620);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1098, 764));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        try {

            row = jTable2.getSelectedRow();
            TableClick = (jTable2.getModel().getValueAt(row, 0).toString());
            stmt = conct.createStatement();
            Query = "select * from `customers` where ID = '" + TableClick + "'";

            stmt = conct.prepareStatement(Query);
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                id = RS.getString("ID");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void DeleteEmployee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEmployee1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Do you want to delet this Employee");
        try {
            conct = Connect.connect();
            Query = "DELETE FROM `ashry cool`.`employees` WHERE (`Id` = '" + id + "');";
            stmt = conct.prepareStatement(Query);
            stmt.execute(Query);
            Query = "DELETE FROM `ashry cool`.`service` WHERE (`Employee id` = '" + id + "');";

            JOptionPane.showMessageDialog(null, "employee deleted");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        fillEmployeeList();
    }//GEN-LAST:event_DeleteEmployee1ActionPerformed

    private void DeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCustomerActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Do you want to delet this customer");
        try {
            conct = Connect.connect();
            Query = "delete from customers where id = '" + id + "' ";
            stmt = conct.prepareStatement(Query);
            stmt.execute(Query);
            Query = "DELETE FROM `ashry cool`.`orders` WHERE (`Customer Id` = '" + id + "');";
            stmt = conct.prepareStatement(Query);
            stmt.execute(Query);

            JOptionPane.showMessageDialog(null, "Customer deleted");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        fillCustomerList();
    }//GEN-LAST:event_DeleteCustomerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("page{0,number,integer}");
        try{
            jTable2.print(JTable.PrintMode.FIT_WIDTH,header,footer);
            JOptionPane.showMessageDialog(null, "print done");
        
        }catch(java.awt.print.PrinterException e){System.err.format("can not print %s %n", e.getMessage() );}


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteCustomer;
    private javax.swing.JButton DeleteEmployee1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
