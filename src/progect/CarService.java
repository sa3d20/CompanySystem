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
public class CarService extends javax.swing.JFrame {

    private String ServiceName;
    private String ServicePrise;
    private String Query;
    private String query;
    Connection conct;
    Statement stmt;
    String Date;
    String Uname;
    ResultSet RS;
    int OutBalance = 0;
    static int Total;
    int InBalance = 0;

    /**
     * Creates new form CarService
     */
    public CarService() {
        initComponents();
         try{
            conct = Connect.connect();
            stmt = conct.createStatement();
            query = "SELECT `Total` FROM `ashry cool`.`out safe` order by id desc limit 1;";
            RS = stmt.executeQuery(query);
            RS.next();
                OutBalance = Integer.parseInt(RS.getString(1));
            
             query = "SELECT `Total` FROM `ashry cool`.`in safe` order by id desc limit 1;";
            RS = stmt.executeQuery(query);
            RS.next();
                InBalance = Integer.parseInt(RS.getString(1));
            
            Total = InBalance - OutBalance;
            
        }catch(SQLException e){JOptionPane.showMessageDialog(null,e.getMessage());}
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Date date = new Date();
        SimpleDateFormat SD = new SimpleDateFormat("dd/MM/yyyy");
        Date = SD.format(date);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ExitBTN = new javax.swing.JButton();
        AddBTN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        PriseText = new javax.swing.JTextField();
        NameText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add service");

        jPanel1.setLayout(null);

        ExitBTN.setBackground(new java.awt.Color(204, 0, 0));
        ExitBTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ExitBTN.setText("Exit");
        ExitBTN.setToolTipText("");
        ExitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBTNActionPerformed(evt);
            }
        });
        jPanel1.add(ExitBTN);
        ExitBTN.setBounds(50, 290, 110, 40);

        AddBTN.setBackground(new java.awt.Color(0, 255, 0));
        AddBTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Drive-Floppy-blue-icon.png"))); // NOI18N
        AddBTN.setText("Add");
        AddBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBTNActionPerformed(evt);
            }
        });
        jPanel1.add(AddBTN);
        AddBTN.setBounds(190, 290, 110, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("سعر الخدمة ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(600, 210, 150, 29);

        PriseText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PriseText.setText("0.0");
        PriseText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PriseTextMouseClicked(evt);
            }
        });
        jPanel1.add(PriseText);
        PriseText.setBounds(480, 200, 100, 40);

        NameText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(NameText);
        NameText.setBounds(280, 100, 300, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("اضافة خدمة");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(601, 110, 140, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Travel-BMV-icon.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 100, 130, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OLO2ED011.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 820, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBTNActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_ExitBTNActionPerformed

    private void PriseTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PriseTextMouseClicked
        // TODO add your handling code here:
        PriseText.setText(null);
    }//GEN-LAST:event_PriseTextMouseClicked

    private void AddBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBTNActionPerformed
        // TODO add your handling code here:
        ServiceName = NameText.getText();
        ServicePrise = PriseText.getText();
        Uname = Password.Uname;
        int x = Integer.parseInt(PriseText.getText());
       if(Integer.parseInt(PriseText.getText()) > Total){
            JOptionPane.showMessageDialog(null,"Not enough money");
            PriseText.setText(null);
            dispose();
       }else{
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "INSERT INTO `ashry cool`.`car services` (`Service Name`, `Service Prise`,`Date`, `User name`) VALUES ('" + ServiceName + "', '" + ServicePrise + "','" + Date + "','" + Uname + "');";
            stmt.execute(Query);
            query = "SELECT `Total` FROM `ashry cool`.`out safe` order by id desc limit 1;";
            RS = stmt.executeQuery(query);
            if (RS.next()) {
                OutBalance = Integer.parseInt(RS.getString(1));
            }
            OutBalance = OutBalance+ x;
            query = "INSERT INTO `ashry cool`.`out safe` (`Items`, `Prise`, `Date`, `User name`,`Total`) VALUES ('" + ServiceName + "', '" + ServicePrise + "', '" + Date + "', '" + Uname + "','" +OutBalance+ "');";
            stmt.execute(query);
            JOptionPane.showMessageDialog(null, "Service added");
            NameText.setText(null);
            PriseText.setText(null);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       }
    }//GEN-LAST:event_AddBTNActionPerformed

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
            java.util.logging.Logger.getLogger(CarService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarService().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBTN;
    private javax.swing.JButton ExitBTN;
    private javax.swing.JTextField NameText;
    private javax.swing.JTextField PriseText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
