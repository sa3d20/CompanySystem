/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author midom
 */
public class Search_2 extends javax.swing.JFrame {

    Connection conct;
    Statement stmt;
    String Query;
    ResultSet RS;
    int row;
    static String CustomerName;
    static String CustomerPhone;
    static String CustomerID;
    static String EmployeeID;
    static String EmployeeName;
    static String EmployeePhone;
    static String CustomerMoney;
    static int EmployeeSalary;
    static int EmployeeSalary2;
    static String EmployeeIncontives;
    static int Money;

    public Search_2() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        SearchBTN_2.setVisible(false);
        jScrollPane2.setVisible(false);
        EmployeeIDLable.setVisible(false);
        EmployeeIDText.setVisible(false);
        SearchBTN_4.setVisible(false);
        jScrollPane4.setVisible(false);
        SearchBTN_3.setVisible(false);
        jScrollPane3.setVisible(false);
    }

    public Search_2(int s) {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        SearchBTN_1.setVisible(false);
        jScrollPane1.setVisible(false);
        CustomerIDLable.setVisible(false);
        CustomerIDText.setVisible(false);
        SearchBTN_4.setVisible(false);
        jScrollPane4.setVisible(false);
        SearchBTN_3.setVisible(false);
        jScrollPane3.setVisible(false);

    }

    public Search_2(double x) {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        SearchBTN_2.setVisible(false);
        jScrollPane2.setVisible(false);
        SearchBTN_4.setVisible(false);
        jScrollPane4.setVisible(false);
        SearchBTN_1.setVisible(false);
        jScrollPane1.setVisible(false);
        CustomerIDLable.setVisible(false);
        CustomerIDText.setVisible(false);
    }

    public Search_2(float x) {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        SearchBTN_2.setVisible(false);
        jScrollPane2.setVisible(false);
        SearchBTN_3.setVisible(false);
        jScrollPane3.setVisible(false);
        SearchBTN_1.setVisible(false);
        jScrollPane1.setVisible(false);
        CustomerIDLable.setVisible(false);
        CustomerIDText.setVisible(false);
    }

    public void fillCustomerList() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT `ID`,`Name`,`Money` FROM `customers` where `Id`=\"" + CustomerIDText.getText() + "\";";
            RS = stmt.executeQuery(Query);
            jTable1.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void fillEmployeeList() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT `ID`,`Name`,`Phone` FROM `employees` where `Id`=\"" + EmployeeIDText.getText() + "\";";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void fillEmployeeList(int x) {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT `ID`,`Name`,`Phone` FROM `employees` where `Id`=\"" + EmployeeIDText.getText() + "\";";
            RS = stmt.executeQuery(Query);
            jTable3.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
     public void fillEmployeeList(double x) {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT `ID`,`Name`,`Phone` FROM `employees` where `Id`=\"" + EmployeeIDText.getText() + "\";";
            RS = stmt.executeQuery(Query);
            jTable4.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    

    public void getCustomerInfo() {
        try {
            row = jTable1.getSelectedRow();
            String TableClick = (jTable1.getModel().getValueAt(row, 0).toString());
            stmt = conct.createStatement();
            Query = "select * from `customers` where ID = '" + TableClick + "'";
            stmt = conct.prepareStatement(Query);
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                CustomerName = RS.getString("Name");
                CustomerPhone = RS.getString("Phone");
                CustomerID = RS.getString("ID");
                CustomerMoney = RS.getString("Money");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void getEmployeeInfo() {

        row = jTable2.getSelectedRow();
        String TableClick = (jTable2.getModel().getValueAt(row, 0).toString());
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `ashry cool`.employees WHERE `Id` = '" + TableClick + "';";
            stmt = conct.prepareStatement(Query);
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                EmployeeName = RS.getString("Name");
                EmployeePhone = RS.getString("Phone");
                EmployeeID = RS.getString("ID");
                EmployeeSalary = Integer.parseInt(RS.getString("Salary"));
                EmployeeSalary2 = Integer.parseInt(RS.getString("Incontives"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void getEmployeeInfo(int x) {

        row = jTable3.getSelectedRow();
        String TableClick = (jTable3.getModel().getValueAt(row, 0).toString());
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `ashry cool`.employees WHERE `Id` = '" + TableClick + "';";
            stmt = conct.prepareStatement(Query);
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                EmployeeName = RS.getString("Name");
                EmployeePhone = RS.getString("Phone");
                EmployeeID = RS.getString("ID");
                EmployeeSalary = Integer.parseInt(RS.getString("Salary"));
                EmployeeSalary2 = Integer.parseInt(RS.getString("Incontives"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    
     public void getEmployeeInfo(double x) {

        row = jTable4.getSelectedRow();
        String TableClick = (jTable4.getModel().getValueAt(row, 0).toString());
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `ashry cool`.employees WHERE `Id` = '" + TableClick + "';";
            stmt = conct.prepareStatement(Query);
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                EmployeeName = RS.getString("Name");
                EmployeePhone = RS.getString("Phone");
                EmployeeID = RS.getString("ID");
                EmployeeSalary = Integer.parseInt(RS.getString("Salary"));
                EmployeeSalary2 = Integer.parseInt(RS.getString("Incontives"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    

    public void getIncontives() {

        row = jTable2.getSelectedRow();
        String TableClick = (jTable2.getModel().getValueAt(row, 0).toString());
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "Select `Total` FROM `service` WHERE `Employee id` = '" + TableClick + "' order by `Service id` desc limit 1";
            stmt = conct.prepareStatement(Query);
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                EmployeeIncontives = RS.getString(1);
            }
            Money = EmployeeSalary + Integer.parseInt(EmployeeIncontives);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void getIncontives(int x) {

        row = jTable3.getSelectedRow();
        String TableClick = (jTable3.getModel().getValueAt(row, 0).toString());
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "Select `Total` FROM `service` WHERE `Employee id` = '" + TableClick + "' order by `Service id` desc limit 1";
            stmt = conct.prepareStatement(Query);
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                EmployeeIncontives = RS.getString(1);
            }
            Money = Integer.parseInt(EmployeeIncontives);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
     public void getIncontives(double x) {

        row = jTable4.getSelectedRow();
        String TableClick = (jTable4.getModel().getValueAt(row, 0).toString());
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "Select `Total` FROM `service` WHERE `Employee id` = '" + TableClick + "' order by `Service id` desc limit 1";
            stmt = conct.prepareStatement(Query);
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                EmployeeIncontives = RS.getString(1);
            }
            Money = Integer.parseInt(EmployeeIncontives);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        EmployeeIDLable = new javax.swing.JLabel();
        EmployeeIDText = new javax.swing.JTextField();
        SearchBTN_2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SearchBTN_1 = new javax.swing.JButton();
        CustomerIDLable = new javax.swing.JLabel();
        CustomerIDText = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        SearchBTN_3 = new javax.swing.JButton();
        SearchBTN_4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1102, 693));

        jPanel1.setLayout(null);

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(40, 210, 1020, 350);

        EmployeeIDLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EmployeeIDLable.setForeground(new java.awt.Color(240, 240, 240));
        EmployeeIDLable.setText("رقم الموظف (ID)");
        EmployeeIDLable.setToolTipText("");
        jPanel1.add(EmployeeIDLable);
        EmployeeIDLable.setBounds(910, 120, 148, 22);

        EmployeeIDText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EmployeeIDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeIDTextActionPerformed(evt);
            }
        });
        jPanel1.add(EmployeeIDText);
        EmployeeIDText.setBounds(800, 120, 89, 29);

        SearchBTN_2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SearchBTN_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start-Menu-Search-icon.png"))); // NOI18N
        SearchBTN_2.setText("Search");
        SearchBTN_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBTN_2ActionPerformed(evt);
            }
        });
        jPanel1.add(SearchBTN_2);
        SearchBTN_2.setBounds(160, 110, 150, 50);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 210, 1020, 350);

        SearchBTN_1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SearchBTN_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start-Menu-Search-icon.png"))); // NOI18N
        SearchBTN_1.setText("Search");
        SearchBTN_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBTN_1ActionPerformed(evt);
            }
        });
        jPanel1.add(SearchBTN_1);
        SearchBTN_1.setBounds(160, 110, 150, 50);

        CustomerIDLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CustomerIDLable.setForeground(new java.awt.Color(240, 240, 240));
        CustomerIDLable.setText("رقم العميل (ID)");
        jPanel1.add(CustomerIDLable);
        CustomerIDLable.setBounds(920, 110, 137, 32);

        CustomerIDText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(CustomerIDText);
        CustomerIDText.setBounds(800, 110, 90, 29);

        jTable3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(40, 210, 1020, 350);

        SearchBTN_3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SearchBTN_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start-Menu-Search-icon.png"))); // NOI18N
        SearchBTN_3.setText("Search");
        SearchBTN_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBTN_3ActionPerformed(evt);
            }
        });
        jPanel1.add(SearchBTN_3);
        SearchBTN_3.setBounds(160, 110, 150, 50);

        SearchBTN_4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SearchBTN_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start-Menu-Search-icon.png"))); // NOI18N
        SearchBTN_4.setText("Search");
        SearchBTN_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBTN_4ActionPerformed(evt);
            }
        });
        jPanel1.add(SearchBTN_4);
        SearchBTN_4.setBounds(160, 110, 150, 50);

        jTable4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(40, 210, 1020, 350);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OLO2ED011.jpg"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(-30, -40, 1130, 730);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1108, 659));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchBTN_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBTN_1ActionPerformed
        // TODO add your handling code here:
        fillCustomerList();
        getCustomerInfo();
        getIncontives();

    }//GEN-LAST:event_SearchBTN_1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        getCustomerInfo();

        new Customer_Paid().setVisible(true);
        this.dispose();


    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        getEmployeeInfo();
        getIncontives();
        new Customer_Report(1.5).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable2MouseClicked

    private void SearchBTN_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBTN_2ActionPerformed
        // TODO add your handling code here:
        fillEmployeeList();

    }//GEN-LAST:event_SearchBTN_2ActionPerformed

    private void EmployeeIDTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeIDTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmployeeIDTextActionPerformed

    private void SearchBTN_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBTN_3ActionPerformed
        // TODO add your handling code here:
        fillEmployeeList(1);
    }//GEN-LAST:event_SearchBTN_3ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        getEmployeeInfo(1);
        getIncontives(1);
        new Salary().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable3MouseClicked

    private void SearchBTN_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBTN_4ActionPerformed
        // TODO add your handling code here:
        fillEmployeeList(1.5);
    }//GEN-LAST:event_SearchBTN_4ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        getEmployeeInfo(1.5);
        getIncontives(1.5);
        new Employee_service(1.5).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable4MouseClicked

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
            java.util.logging.Logger.getLogger(Search_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search_2(1.5f).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerIDLable;
    private javax.swing.JTextField CustomerIDText;
    private javax.swing.JLabel EmployeeIDLable;
    private javax.swing.JTextField EmployeeIDText;
    private javax.swing.JButton SearchBTN_1;
    private javax.swing.JButton SearchBTN_2;
    private javax.swing.JButton SearchBTN_3;
    private javax.swing.JButton SearchBTN_4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
