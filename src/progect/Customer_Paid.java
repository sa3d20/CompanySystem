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
public class Customer_Paid extends javax.swing.JFrame {

    
    Connection conct;
    Statement stmt;
    String Query;
    ResultSet RS;
    String Date;
    int InBalance  = 0;
    int x;
    int y;
    int TotalPrice;
    int TotalPaid;
    
    public Customer_Paid() {
        initComponents();
        this.setResizable(false);
        Date date = new Date();
        SimpleDateFormat SD = new SimpleDateFormat("dd/MM/yyyy");
        Date = SD.format(date);
        fill();
    
    }
    public void fill(){
        CustomerNameLable.setText(Search.CustomerName);
        CustomerPhoneLable.setText(Search.CustomerPhone);
        CustomerMoneyLable.setText(Search.CustomerMoney);
        MonneyText.setText(Search.CustomerMoney);
        CustomerNameLable.setText(Search_2.CustomerName);
        CustomerPhoneLable.setText(Search_2.CustomerPhone);
        CustomerMoneyLable.setText(Search_2.CustomerMoney);
        MonneyText.setText(Search_2.CustomerMoney);
 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CustomerNameLable = new javax.swing.JLabel();
        CustomerPhoneLable = new javax.swing.JLabel();
        CustomerMoneyLable = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        MonneyText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CommentText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        CustomerNameLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CustomerNameLable.setForeground(new java.awt.Color(255, 255, 255));
        CustomerNameLable.setToolTipText("");
        jPanel1.add(CustomerNameLable);
        CustomerNameLable.setBounds(320, 10, 350, 20);

        CustomerPhoneLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CustomerPhoneLable.setForeground(new java.awt.Color(255, 255, 255));
        CustomerPhoneLable.setToolTipText("");
        jPanel1.add(CustomerPhoneLable);
        CustomerPhoneLable.setBounds(420, 50, 240, 20);

        CustomerMoneyLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CustomerMoneyLable.setForeground(new java.awt.Color(255, 0, 0));
        CustomerMoneyLable.setToolTipText("");
        jPanel1.add(CustomerMoneyLable);
        CustomerMoneyLable.setBounds(420, 100, 240, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("المبلغ :-");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(730, 90, 70, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("اسم العميل :-");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(677, 11, 121, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("التليفون :-");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(710, 50, 90, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("المبلغ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(750, 220, 50, 22);

        MonneyText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        MonneyText.setText("0.0");
        MonneyText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MonneyTextMouseClicked(evt);
            }
        });
        jPanel1.add(MonneyText);
        MonneyText.setBounds(560, 220, 150, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ملاحظات");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(730, 280, 77, 22);

        CommentText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CommentText.setText("قسط");
        CommentText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CommentTextMouseClicked(evt);
            }
        });
        jPanel1.add(CommentText);
        CommentText.setBounds(270, 280, 439, 35);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 255, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ok-icon.png"))); // NOI18N
        jButton1.setText("سداد");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(50, 350, 129, 41);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OLO2ED011.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 840, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(847, 446));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MonneyTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MonneyTextMouseClicked
        // TODO add your handling code here:
       MonneyText.setText(null);
    }//GEN-LAST:event_MonneyTextMouseClicked

    private void CommentTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CommentTextMouseClicked
        // TODO add your handling code here:
        CommentText.setText(null);
    }//GEN-LAST:event_CommentTextMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
     if (Integer.parseInt(MonneyText.getText()) > Integer.parseInt(Search_2.CustomerMoney)){
         JOptionPane.showMessageDialog(null,"Monney more than arders");
        MonneyText.setText(null);
     }
     else{
        try{
            conct = Connect.connect();
            stmt = conct.createStatement();
            x = Integer.parseInt(MonneyText.getText());
            //----------------------------------------------------- add to safe list ------------------------------------------------------------------------------
            int money = Integer.parseInt(Search_2.CustomerMoney)-Integer.parseInt(MonneyText.getText());
             Query = "SELECT `Total` FROM `ashry cool`.`in safe` order by id desc limit 1;";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                InBalance = Integer.parseInt(RS.getString(1));
            }
            InBalance =InBalance + Integer.parseInt(MonneyText.getText());
            String Money  = Integer.toString(InBalance);
            Query = "INSERT INTO `ashry cool`.`in safe` (`Items`, `Prise`, `Date`, `User name`,`Total`) VALUES"
                    + " ('" + CommentText.getText() + "', '" + MonneyText.getText() + "', '" + Date + "', '" + Password.Uname + "','" + Money + "');";
            stmt.execute(Query);
            //---------------------------------------------------- add to Customer list -------------------------------------------------------------------------------------
              Query = "SELECT `Total Paid` FROM `ashry cool`.`customers` WHERE ID = '" + Search_2.CustomerID + "' ";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                TotalPaid = Integer.parseInt(RS.getString(1));
            }
            TotalPaid = TotalPaid + x;
            
            Query = "UPDATE `ashry cool`.`customers` SET `Total Paid` = '" + Integer.toString(TotalPaid) + "' WHERE (`ID` = '" + Search_2.CustomerID + "');";
            stmt.execute(Query);
            
             Query = "SELECT `Total Price` FROM `ashry cool`.`customers` WHERE ID = '" + Search_2.CustomerID + "' ;";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                TotalPrice = Integer.parseInt(RS.getString(1));
            }
            
            int z = TotalPrice - TotalPaid;
            Query = "UPDATE `ashry cool`.`customers` SET `Money` = '" + Integer.toString(z) + "' WHERE (`ID` = '" + Search_2.CustomerID + "');";
            stmt.execute(Query);
            //------------------------------------------------------------- add to order list ----------------------------------------------------------------------------
            Query = "INSERT INTO `ashry cool`.`orders` (`Customer Id`, `Order name`, `Order amount`, `Order price`, `Order discount`, `Order paid`, `Order non paid`) VALUES"
                    + " ('" + Search_2.CustomerID + "', '" + CommentText.getText()+ "', '1', '"+MonneyText.getText()+"'"
                    + ", '0', '"+MonneyText.getText()+"', '0');";
            stmt.execute(Query);
            JOptionPane.showMessageDialog(null,"Ok Money added");
            JOptionPane.showMessageDialog(null,money);
            CustomerMoneyLable.setText(Integer.toString(money));
            MonneyText.setText(null);
            this.dispose();
        }catch(SQLException e){JOptionPane.showMessageDialog(null,e.getMessage());}}
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
            java.util.logging.Logger.getLogger(Customer_Paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Paid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Paid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CommentText;
    private javax.swing.JLabel CustomerMoneyLable;
    private javax.swing.JLabel CustomerNameLable;
    private javax.swing.JLabel CustomerPhoneLable;
    private javax.swing.JTextField MonneyText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
