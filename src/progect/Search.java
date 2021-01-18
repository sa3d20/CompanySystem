/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progect;

import java.awt.AWTError;
import java.awt.AWTException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author midom
 */
public class Search extends javax.swing.JFrame {

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
    static String CustomerTotal;
    static String CustomerPaid;

// constractor to show customer search to add service
    public Search() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        jTable1.setVisible(false);
        EmployeeIDLable.setVisible(false);
        EmployeeIDText.setVisible(false);

        SearchBTN_2.setVisible(false);
        jScrollPane2.setVisible(false);
        SearchBTN_4.setVisible(false);
        jScrollPane4.setVisible(false);

    }

    //constractor to show employee search to add service
    public Search(int x) {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        jTable1.setVisible(false);
        CustomerIDLable.setVisible(false);
        CustomerIDText.setVisible(false);

        SearchBTN_1.setVisible(false);
        jScrollPane1.setVisible(false);
        SearchBTN_4.setVisible(false);
        jScrollPane4.setVisible(false);

    }

    //constractor to show customer search to add money
    public Search(double x) {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        jTable1.setVisible(false);
        EmployeeIDLable.setVisible(false);
        EmployeeIDText.setVisible(false);

        SearchBTN_2.setVisible(false);
        jScrollPane2.setVisible(false);
        SearchBTN_1.setVisible(false);
        jScrollPane1.setVisible(false);
        SearchBTN_4.setVisible(false);
        jScrollPane4.setVisible(false);

    }

    //constractor to show customers search to print customers reports
    public Search(double x, int y) {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        jTable1.setVisible(false);
        EmployeeIDLable.setVisible(false);
        EmployeeIDText.setVisible(false);

        SearchBTN_2.setVisible(false);
        jScrollPane2.setVisible(false);
        SearchBTN_1.setVisible(false);
        jScrollPane1.setVisible(false);

    }

    public void fillCustomerList() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT `ID`,`Name`,`Phone` FROM `customers` where `Id`=\"" + CustomerIDText.getText() + "\";";
            RS = stmt.executeQuery(Query);
            jTable1.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void fillCustomerList(int x, int y) {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT `ID`,`Name`,`Phone` FROM `customers` where `Id`=\"" + CustomerIDText.getText() + "\";";
            RS = stmt.executeQuery(Query);
            jTable4.setModel(DbUtils.resultSetToTableModel(RS));
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
                CustomerTotal = RS.getString("Total Price");
                CustomerPaid = RS.getString("Total Paid");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void getCustomerInfo(int x, int y) {
        try {
            row = jTable4.getSelectedRow();
            String TableClick = (jTable4.getModel().getValueAt(row, 0).toString());
            stmt = conct.createStatement();
            Query = "select * from `customers` where ID = '" + TableClick + "'";
            stmt = conct.prepareStatement(Query);
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                CustomerName = RS.getString("Name");
                CustomerPhone = RS.getString("Phone");
                CustomerID = RS.getString("ID");
                CustomerMoney = RS.getString("Money");
                CustomerTotal = RS.getString("Total Price");
                CustomerPaid = RS.getString("Total Paid");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void getEmployeeInfo() {
        try {
            row = jTable2.getSelectedRow();
            String TableClick = (jTable2.getModel().getValueAt(row, 0).toString());
            stmt = conct.createStatement();
            Query = "select * from `Employees` where ID = '" + TableClick + "'";
            stmt = conct.prepareStatement(Query);
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                EmployeeName = RS.getString("Name");
                EmployeePhone = RS.getString("Phone");
                EmployeeID = RS.getString("ID");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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
        SearchBTN_4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SearchBTN_2 = new javax.swing.JButton();
        CustomerIDLable = new javax.swing.JLabel();
        CustomerIDText = new javax.swing.JTextField();
        EmployeeIDLable = new javax.swing.JLabel();
        EmployeeIDText = new javax.swing.JTextField();
        SearchBTN_1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setLayout(null);

        SearchBTN_4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SearchBTN_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start-Menu-Search-icon.png"))); // NOI18N
        SearchBTN_4.setText("Search");
        SearchBTN_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBTN_4ActionPerformed(evt);
            }
        });
        jPanel1.add(SearchBTN_4);
        SearchBTN_4.setBounds(240, 120, 130, 50);

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
        jScrollPane4.setBounds(30, 200, 1040, 320);

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
        jScrollPane2.setBounds(30, 200, 1040, 320);

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
        jScrollPane1.setBounds(30, 200, 1040, 320);

        SearchBTN_2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SearchBTN_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start-Menu-Search-icon.png"))); // NOI18N
        SearchBTN_2.setText("Search");
        SearchBTN_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBTN_2ActionPerformed(evt);
            }
        });
        jPanel1.add(SearchBTN_2);
        SearchBTN_2.setBounds(240, 120, 130, 50);

        CustomerIDLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CustomerIDLable.setForeground(new java.awt.Color(240, 240, 240));
        CustomerIDLable.setText("رقم العميل (ID)");
        jPanel1.add(CustomerIDLable);
        CustomerIDLable.setBounds(930, 120, 137, 32);

        CustomerIDText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(CustomerIDText);
        CustomerIDText.setBounds(820, 120, 90, 29);

        EmployeeIDLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EmployeeIDLable.setForeground(new java.awt.Color(240, 240, 240));
        EmployeeIDLable.setText("رقم الموظف (ID)");
        EmployeeIDLable.setToolTipText("");
        jPanel1.add(EmployeeIDLable);
        EmployeeIDLable.setBounds(930, 120, 148, 22);

        EmployeeIDText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EmployeeIDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeIDTextActionPerformed(evt);
            }
        });
        jPanel1.add(EmployeeIDText);
        EmployeeIDText.setBounds(820, 119, 89, 30);

        SearchBTN_1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SearchBTN_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start-Menu-Search-icon.png"))); // NOI18N
        SearchBTN_1.setText("Search");
        SearchBTN_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBTN_1ActionPerformed(evt);
            }
        });
        jPanel1.add(SearchBTN_1);
        SearchBTN_1.setBounds(240, 120, 130, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OLO2ED011.jpg"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 1100, 690);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1102, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EmployeeIDTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeIDTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmployeeIDTextActionPerformed

    private void SearchBTN_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBTN_1ActionPerformed
        // TODO add your handling code here:
        jTable1.setVisible(true);
        fillCustomerList();
        getCustomerInfo();

    }//GEN-LAST:event_SearchBTN_1ActionPerformed

    private void SearchBTN_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBTN_2ActionPerformed
        // TODO add your handling code here:
        jTable1.setVisible(true);
        fillEmployeeList();
        getEmployeeInfo();
    }//GEN-LAST:event_SearchBTN_2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        getCustomerInfo();
        new Employee_service().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        getEmployeeInfo();
        new Employee_service(1).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        getCustomerInfo(1, 1);
        new Customer_Report().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable4MouseClicked

    private void SearchBTN_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBTN_4ActionPerformed
        // TODO add your handling code here:
        fillCustomerList(1, 1);
        getCustomerInfo(1, 1);
    }//GEN-LAST:event_SearchBTN_4ActionPerformed

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
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);
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
    private javax.swing.JButton SearchBTN_4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
