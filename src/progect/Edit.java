package progect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Edit extends JFrame {

    Connection conct;
    Statement stmt;
    String Query;
    ResultSet RS;

    public Edit() {
        initComponents();
        fillCustomerList();
        IDText1.setVisible(false);
        PhoneText1.setVisible(false);
        NameText1.setVisible(false);
        SalaryText.setVisible(false);
        IncentivesText.setVisible(false);
        EmployeeID.setVisible(false);
        EmployeeInce.setVisible(false);
        EmployeeName.setVisible(false);
        EmployeePhone.setVisible(false);
        EmployeeSalary.setVisible(false);
        UpdateBTN1.setVisible(false);
        jScrollPane3.setVisible(false);
        
    }
     public Edit(int x) {
        initComponents();
        fillEmpioyeeList();
        IDText.setVisible(false);
        CustomerID.setVisible(false);
        NameText.setVisible(false);
        CustomerName.setVisible(false);
        PhoneText.setVisible(false);
        CustomerPhone.setVisible(false);
        AddressText.setVisible(false);
        CustomerAddress.setVisible(false);
        UpdateBTN.setVisible(false);
        jScrollPane2.setVisible(false);
        jScrollPane1.setVisible(false);
        
        
        
    }

    public void fillCustomerList() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT `ID`,`Name` FROM `customers`;";
            RS = stmt.executeQuery(Query);
            jTable1.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void fillEmpioyeeList() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT `ID`,`Name` FROM `Employees`;";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EmployeeID = new javax.swing.JLabel();
        IDText1 = new javax.swing.JTextField();
        NameText1 = new javax.swing.JTextField();
        EmployeeName = new javax.swing.JLabel();
        EmployeePhone = new javax.swing.JLabel();
        PhoneText1 = new javax.swing.JTextField();
        SalaryText = new javax.swing.JTextField();
        EmployeeSalary = new javax.swing.JLabel();
        EmployeeInce = new javax.swing.JLabel();
        IncentivesText = new javax.swing.JTextField();
        CustomerID = new javax.swing.JLabel();
        IDText = new javax.swing.JTextField();
        CustomerName = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        PhoneText = new javax.swing.JTextField();
        CustomerPhone = new javax.swing.JLabel();
        CustomerAddress = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddressText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        UpdateBTN = new javax.swing.JButton();
        UpdateBTN1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("edite search");
        setPreferredSize(new java.awt.Dimension(1102, 693));
        setResizable(false);
        getContentPane().setLayout(null);

        EmployeeID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EmployeeID.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeID.setText("رقم الموظف (ID)");
        EmployeeID.setToolTipText("");
        getContentPane().add(EmployeeID);
        EmployeeID.setBounds(960, 70, 197, 29);

        IDText1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDText1.setEnabled(false);
        IDText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDText1ActionPerformed(evt);
            }
        });
        getContentPane().add(IDText1);
        IDText1.setBounds(830, 70, 89, 29);

        NameText1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameText1ActionPerformed(evt);
            }
        });
        getContentPane().add(NameText1);
        NameText1.setBounds(509, 150, 410, 29);

        EmployeeName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EmployeeName.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeName.setText("الاسم (رباعى)");
        getContentPane().add(EmployeeName);
        EmployeeName.setBounds(990, 150, 165, 29);

        EmployeePhone.setBackground(new java.awt.Color(255, 255, 255));
        EmployeePhone.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EmployeePhone.setForeground(new java.awt.Color(255, 255, 255));
        EmployeePhone.setText("رقم التليفون");
        getContentPane().add(EmployeePhone);
        EmployeePhone.setBounds(1020, 240, 138, 29);

        PhoneText1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PhoneText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneText1ActionPerformed(evt);
            }
        });
        getContentPane().add(PhoneText1);
        PhoneText1.setBounds(720, 240, 200, 29);

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
        getContentPane().add(SalaryText);
        SalaryText.setBounds(830, 320, 93, 29);

        EmployeeSalary.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EmployeeSalary.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeSalary.setText("المرتب الاساسى");
        getContentPane().add(EmployeeSalary);
        EmployeeSalary.setBounds(960, 320, 192, 29);

        EmployeeInce.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        EmployeeInce.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeInce.setText("الاضافات");
        getContentPane().add(EmployeeInce);
        EmployeeInce.setBounds(1060, 400, 96, 29);

        IncentivesText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IncentivesText.setText("0.00");
        IncentivesText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncentivesTextActionPerformed(evt);
            }
        });
        getContentPane().add(IncentivesText);
        IncentivesText.setBounds(830, 400, 93, 29);

        CustomerID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CustomerID.setForeground(new java.awt.Color(255, 255, 255));
        CustomerID.setText("رقم العميل (ID)");
        getContentPane().add(CustomerID);
        CustomerID.setBounds(970, 70, 182, 29);

        IDText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IDText.setEnabled(false);
        getContentPane().add(IDText);
        IDText.setBounds(880, 70, 60, 28);

        CustomerName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CustomerName.setForeground(new java.awt.Color(255, 255, 255));
        CustomerName.setText("الاسم (رباعى) ");
        getContentPane().add(CustomerName);
        CustomerName.setBounds(980, 150, 172, 29);

        NameText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextActionPerformed(evt);
            }
        });
        getContentPane().add(NameText);
        NameText.setBounds(530, 150, 450, 28);

        PhoneText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PhoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTextActionPerformed(evt);
            }
        });
        getContentPane().add(PhoneText);
        PhoneText.setBounds(710, 240, 271, 28);

        CustomerPhone.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CustomerPhone.setForeground(new java.awt.Color(255, 255, 255));
        CustomerPhone.setText("رقم التليفون");
        getContentPane().add(CustomerPhone);
        CustomerPhone.setBounds(1010, 240, 138, 29);

        CustomerAddress.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CustomerAddress.setForeground(new java.awt.Color(255, 255, 255));
        CustomerAddress.setText("العنوان");
        getContentPane().add(CustomerAddress);
        CustomerAddress.setBounds(1060, 350, 78, 29);

        AddressText.setColumns(20);
        AddressText.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        AddressText.setRows(5);
        jScrollPane1.setViewportView(AddressText);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(480, 350, 500, 40);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(50);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(12, 80, 452, 520);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setRowHeight(50);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(12, 80, 452, 520);

        UpdateBTN.setBackground(new java.awt.Color(0, 102, 102));
        UpdateBTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        UpdateBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Apps-system-software-update-icon.png"))); // NOI18N
        UpdateBTN.setText("Update");
        UpdateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBTNActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateBTN);
        UpdateBTN.setBounds(826, 510, 159, 63);

        UpdateBTN1.setBackground(new java.awt.Color(0, 102, 102));
        UpdateBTN1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        UpdateBTN1.setForeground(new java.awt.Color(0, 153, 0));
        UpdateBTN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Apps-system-software-update-icon.png"))); // NOI18N
        UpdateBTN1.setText("Update");
        UpdateBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBTN1ActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateBTN1);
        UpdateBTN1.setBounds(826, 510, 159, 63);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OLO2ED011.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1270, 660);

        setSize(new java.awt.Dimension(1204, 688));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextActionPerformed

    private void PhoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTextActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try {
            int row = jTable1.getSelectedRow();
            String TableClick = (jTable1.getModel().getValueAt(row, 0).toString());
            stmt = conct.createStatement();
            Query = "select * from `customers` where ID = '" + TableClick + "'";
           stmt = conct.prepareStatement(Query);
           RS = stmt.executeQuery(Query);
           if(RS.next()){
               String add1 = RS.getString("ID");
               IDText.setText(add1);
               String add2 = RS.getString("Name");
               NameText.setText(add2);
               String add3 = RS.getString("Phone");
               PhoneText.setText(add3);
               String add4 = RS.getString("Address");
               AddressText.setText(add4);
               
           }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
    }//GEN-LAST:event_jTable1MouseClicked

    private void UpdateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBTNActionPerformed
        // TODO add your handling code here:
        try {
            int row = jTable1.getSelectedRow();
            String TableClick = (jTable1.getModel().getValueAt(row, 0).toString());
            stmt = conct.createStatement();
            Query = "update `customers` set `Name`='"+NameText.getText()+"',`Phone`='"+PhoneText.getText()+"',`Address`='"+AddressText.getText()+"' where ID = '" + TableClick + "'";
           stmt = conct.prepareStatement(Query);
           stmt.execute(Query);
           }catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
        fillCustomerList();
    }//GEN-LAST:event_UpdateBTNActionPerformed

    private void IDText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDText1ActionPerformed

    private void NameText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameText1ActionPerformed

    private void PhoneText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneText1ActionPerformed

    private void SalaryTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalaryTextMouseClicked
        // TODO add your handling code here:
        SalaryText.setText(null);
    }//GEN-LAST:event_SalaryTextMouseClicked

    private void SalaryTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaryTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalaryTextActionPerformed

    private void IncentivesTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncentivesTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IncentivesTextActionPerformed

    private void UpdateBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBTN1ActionPerformed
        // TODO add your handling code here:
        try {
            int row = jTable2.getSelectedRow();
            String TableClick = (jTable2.getModel().getValueAt(row, 0).toString());
            stmt = conct.createStatement();
            Query = "update `employees` set `Name`='"+NameText1.getText()+"',`Phone`='"+PhoneText1.getText()+"',`Salary`='"+SalaryText.getText()+"',`Incontives`='"+IncentivesText.getText()+"' where ID = '" + TableClick + "'";
           stmt = conct.prepareStatement(Query);
           stmt.execute(Query);
           }catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
        fillEmpioyeeList();
    }//GEN-LAST:event_UpdateBTN1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        try {
            int row = jTable2.getSelectedRow();
            String TableClick = (jTable2.getModel().getValueAt(row, 0).toString());
            stmt = conct.createStatement();
            Query = "select * from `employees` where ID = '" + TableClick + "'";
            stmt = conct.prepareStatement(Query);
            RS = stmt.executeQuery(Query);
            if(RS.next()){
                String add1 = RS.getString("ID");
                IDText1.setText(add1);
                String add2 = RS.getString("Name");
                NameText1.setText(add2);
                String add3 = RS.getString("Phone");
                PhoneText1.setText(add3);
                String add4 = RS.getString("salary");
                SalaryText.setText(add4);
                String add5 = RS.getString("Incontives");
                IncentivesText.setText(add5);

            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit(10).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AddressText;
    private javax.swing.JLabel CustomerAddress;
    private javax.swing.JLabel CustomerID;
    private javax.swing.JLabel CustomerName;
    private javax.swing.JLabel CustomerPhone;
    private javax.swing.JLabel EmployeeID;
    private javax.swing.JLabel EmployeeInce;
    private javax.swing.JLabel EmployeeName;
    private javax.swing.JLabel EmployeePhone;
    private javax.swing.JLabel EmployeeSalary;
    private javax.swing.JTextField IDText;
    private javax.swing.JTextField IDText1;
    private javax.swing.JTextField IncentivesText;
    private javax.swing.JTextField NameText;
    private javax.swing.JTextField NameText1;
    private javax.swing.JTextField PhoneText;
    private javax.swing.JTextField PhoneText1;
    private javax.swing.JTextField SalaryText;
    private javax.swing.JButton UpdateBTN;
    private javax.swing.JButton UpdateBTN1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
