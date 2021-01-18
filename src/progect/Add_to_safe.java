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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author midom
 */
public class Add_to_safe extends javax.swing.JFrame {

    private String Monney;
    private String Comment;

    
    String Date;
    String Uname;
    private String query;
    Connection conct;
    Statement stmt;
    ResultSet RS;
    int InBalance = 0;
    static int OutBalance = 0;
    static int Total;
   
   

    public Add_to_safe() {
        initComponents();
        try{
            conct = Connect.connect();
            stmt = conct.createStatement();
            query = "SELECT `Total` FROM `ashry cool`.`out safe` order by id desc limit 1;";
            RS = stmt.executeQuery(query);
            if (RS.next()) {
                OutBalance = Integer.parseInt(RS.getString(1));
            }
             query = "SELECT `Total` FROM `ashry cool`.`in safe` order by id desc limit 1;";
            RS = stmt.executeQuery(query);
            if (RS.next()) {
                InBalance = Integer.parseInt(RS.getString(1));
            }
            Total = InBalance - OutBalance;
            
        }catch(SQLException e){JOptionPane.showMessageDialog(null,e.getMessage());}
        Date date = new Date();
        SimpleDateFormat SD = new SimpleDateFormat("dd/MM/yyyy");
        Date = SD.format(date);
        jLabel6.setVisible(false);
        AddBTN1.setVisible(false);
       

    }

    public Add_to_safe(int x) {
        initComponents();
        Date date = new Date();
        SimpleDateFormat SD = new SimpleDateFormat("dd/MM/yyyy");
        Date = SD.format(date);
        jLabel1.setVisible(false);
        AddBTN.setVisible(false);
        CommentText.setText("مبلغ تامين");
        try{
            conct = Connect.connect();
            stmt = conct.createStatement();
            query = "SELECT `Total` FROM `ashry cool`.`out safe` order by id desc limit 1;";
            RS = stmt.executeQuery(query);
            if (RS.next()) {
                OutBalance = Integer.parseInt(RS.getString(1));
            }
             query = "SELECT `Total` FROM `ashry cool`.`in safe` order by id desc limit 1;";
            RS = stmt.executeQuery(query);
            if (RS.next()) {
                InBalance = Integer.parseInt(RS.getString(1));
            }
            Total = InBalance - OutBalance;
            
        }catch(SQLException e){JOptionPane.showMessageDialog(null,e.getMessage());}
    }

    public void Add() {
        Monney = MonneyText.getText();
        Comment = CommentText.getText();
        int x = Integer.parseInt(MonneyText.getText());
        Uname = Password.Uname;
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            query = "SELECT `Total` FROM `ashry cool`.`in safe` order by id desc limit 1;";
            RS = stmt.executeQuery(query);
            if (RS.next()) {
                InBalance = Integer.parseInt(RS.getString(1));
            }
            InBalance =InBalance +x;
            //main_frame.Total = InBalance + x;
            query = "INSERT INTO `ashry cool`.`in safe` (`Items`, `Prise`, `Date`, `User name`,`Total`) VALUES"
                    + " ('" + Comment + "', '" + Monney + "', '" + Date + "', '" + Uname + "','" + InBalance + "');";
            stmt.execute(query);
            JOptionPane.showMessageDialog(null, "Monney added");
            MonneyText.setText(null);

            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void Add2() {
        Monney = MonneyText.getText();
        Comment = CommentText.getText();
        int x = Integer.parseInt(MonneyText.getText());
        Uname = Password.Uname;
        
        if(Integer.parseInt(MonneyText.getText()) > Total){
            JOptionPane.showMessageDialog(null,"Not enough money");
            MonneyText.setText(null);
            dispose();
        }else{
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            query = "SELECT `Total` FROM `ashry cool`.`out safe` order by id desc limit 1;";
            RS = stmt.executeQuery(query);
            if (RS.next()) {
                OutBalance = Integer.parseInt(RS.getString(1));
            }
            OutBalance += x;
            query = "INSERT INTO `ashry cool`.`out safe` (`Items`, `Prise`, `Date`, `User name`,`Total`) VALUES ('" + Comment + "', '" + Monney + "', '" + Date + "', '" + Uname + "','" + OutBalance + "');";
            stmt.execute(query);
            query = "SELECT `Total` FROM `ashry cool`.`in safe` order by id desc limit 1;";
            RS = stmt.executeQuery(query);
            RS.next();
            InBalance =InBalance +x;
           
            JOptionPane.showMessageDialog(null, "The amount has been disbursed");
            MonneyText.setText(null);
            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        AddBTN1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AddBTN = new javax.swing.JButton();
        CommentText = new javax.swing.JTextField();
        MonneyText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        AddBTN1.setBackground(new java.awt.Color(0, 204, 0));
        AddBTN1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddBTN1.setForeground(new java.awt.Color(0, 0, 102));
        AddBTN1.setText("Cash");
        AddBTN1.setToolTipText("");
        AddBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBTN1ActionPerformed(evt);
            }
        });
        jPanel1.add(AddBTN1);
        AddBTN1.setBounds(50, 300, 114, 41);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("صرف رصيد");
        jLabel6.setToolTipText("");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(308, 13, 122, 29);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Money-Safe-icon.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 90, 140, 150);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("اضافة رصيد");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(308, 13, 129, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("المبلغ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(692, 88, 50, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ملاحظات");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(665, 190, 77, 22);

        AddBTN.setBackground(new java.awt.Color(0, 204, 0));
        AddBTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddBTN.setForeground(new java.awt.Color(0, 0, 102));
        AddBTN.setText("Add");
        AddBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBTNActionPerformed(evt);
            }
        });
        jPanel1.add(AddBTN);
        AddBTN.setBounds(50, 300, 114, 41);

        CommentText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CommentText.setText("رصيد افتتاحى");
        CommentText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CommentTextMouseClicked(evt);
            }
        });
        jPanel1.add(CommentText);
        CommentText.setBounds(208, 183, 439, 35);

        MonneyText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        MonneyText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MonneyTextMouseClicked(evt);
            }
        });
        jPanel1.add(MonneyText);
        MonneyText.setBounds(497, 85, 150, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OLO2ED011.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 840, 460);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(772, 424));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MonneyTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MonneyTextMouseClicked
        // TODO add your handling code here:
        jTextField2.setText(null);
    }//GEN-LAST:event_MonneyTextMouseClicked

    private void CommentTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CommentTextMouseClicked
        // TODO add your handling code here:
        CommentText.setText(null);
    }//GEN-LAST:event_CommentTextMouseClicked

    private void AddBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBTNActionPerformed
        // TODO add your handling code here:
        Add();

    }//GEN-LAST:event_AddBTNActionPerformed

    private void AddBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBTN1ActionPerformed
        // TODO add your handling code here:
        Add2();
    }//GEN-LAST:event_AddBTN1ActionPerformed

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
            java.util.logging.Logger.getLogger(Add_to_safe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_to_safe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_to_safe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_to_safe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_to_safe(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBTN;
    private javax.swing.JButton AddBTN1;
    private javax.swing.JTextField CommentText;
    private javax.swing.JTextField MonneyText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
