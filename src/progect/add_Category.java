/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.Clock.system;
import javax.swing.JOptionPane;

/**
 *
 * @author midom
 */
public class add_Category extends javax.swing.JFrame {

    private String Name;
    private String Number;
    private String Prise;
    private String MetterNumber;
    private String MetterPrise;
    Connection conct;
    Statement stmt;
    String Query;
    ResultSet RS;
    String Date;
    String id;

    public add_Category() {

        initComponents();
        this.setResizable(false);
        jTextField1.enable(false);
        AddCombo();

    }

    public void AddCombo() {
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `categories`";
            RS = stmt.executeQuery(Query);
            while (RS.next()) {
                String items = RS.getString("ID");
                jComboBox1.addItem(items);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void fill() {
        id = jComboBox1.getSelectedItem().toString();
        if (id == "0") {
            jTextField1.enable(true);
            jTextField1.setText(null);
            CategoryText.setText(null);
            CategoryPriseText.setText(null);
            NumberText.setText(null);

        } else {
            jTextField1.enable(false);
            try {
                conct = Connect.connect();
                stmt = conct.createStatement();
                Query = "SELECT * FROM `categories` WHERE `ID`= '" + id + "'";
                RS = stmt.executeQuery(Query);
                if (RS.next()) {
                    jTextField1.setText(RS.getString("ID"));
                    CategoryText.setText(RS.getString("Name"));
                    CategoryPriseText.setText(RS.getString("Prise"));
                    NumberText.setText(RS.getString("Number"));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public void Add() {
        Name = CategoryText.getText();
        Number = NumberText.getText();
        Prise = CategoryPriseText.getText();

        //mysql Connection-------------------------------------------------------
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "INSERT INTO `ashry cool`.`categories` (`ID`,`Name`, `Number`, `Prise`) VALUES ('"+jTextField1.getText()+"','" + Name + "', '" + Number + "', '" + Prise + "');";
            stmt.execute(Query);
            JOptionPane.showMessageDialog(null, "Category added");
            jTextField1.setText(null);
            CategoryText.setText(null);
            NumberText.setText(null);
            CategoryPriseText.setText(null);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
    
    public void update(){
        try{
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "UPDATE `ashry cool`.`categories` SET `Name` = '"+CategoryText.getText()+"', `Number` = '"+NumberText.getText()+"', `Prise` = '"+CategoryPriseText.getText()+"' WHERE (`ID` = '"+id+"');";
            stmt.execute(Query);
            JOptionPane.showMessageDialog(null, "Category updated");
        }catch(SQLException e){JOptionPane.showMessageDialog(null, e.getMessage());}
    
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
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addBT = new javax.swing.JButton();
        exitBT = new javax.swing.JButton();
        CategoryText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NumberText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CategoryPriseText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("اضافة اصناف");

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("اضافة اصناف");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(330, 40, 150, 40);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0" }));
        jComboBox1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jComboBox1MouseMoved(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(510, 140, 60, 28);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("رقم الصنف");
        jLabel6.setToolTipText("");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(660, 190, 150, 30);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(470, 190, 100, 30);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID");
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(660, 130, 150, 30);

        addBT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addBT.setForeground(new java.awt.Color(0, 102, 0));
        addBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Drive-Floppy-blue-icon.png"))); // NOI18N
        addBT.setText("Add");
        addBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTActionPerformed(evt);
            }
        });
        jPanel1.add(addBT);
        addBT.setBounds(200, 510, 120, 40);

        exitBT.setBackground(new java.awt.Color(204, 0, 0));
        exitBT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exitBT.setText("Exit");
        exitBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTActionPerformed(evt);
            }
        });
        jPanel1.add(exitBT);
        exitBT.setBounds(50, 510, 100, 40);

        CategoryText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel1.add(CategoryText);
        CategoryText.setBounds(220, 250, 350, 35);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("اسم الصنف");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(660, 250, 150, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("سعر الوحدة");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(650, 400, 150, 29);

        NumberText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel1.add(NumberText);
        NumberText.setBounds(410, 330, 160, 35);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("العدد");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(730, 340, 90, 29);

        CategoryPriseText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CategoryPriseText.setText("0.0");
        CategoryPriseText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoryPriseTextMouseClicked(evt);
            }
        });
        CategoryPriseText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryPriseTextActionPerformed(evt);
            }
        });
        jPanel1.add(CategoryPriseText);
        CategoryPriseText.setBounds(410, 400, 160, 35);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OLO2ED011.jpg"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 0, 880, 620);

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

        setSize(new java.awt.Dimension(863, 634));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBTActionPerformed
        // TODO add your handling code here:
       id = jComboBox1.getSelectedItem().toString();
       if(id == "0"){
           Add();
       }else{update();}
    }//GEN-LAST:event_addBTActionPerformed

    private void exitBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitBTActionPerformed

    private void CategoryPriseTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryPriseTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryPriseTextActionPerformed

    private void CategoryPriseTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryPriseTextMouseClicked
        // TODO add your handling code here:
        CategoryPriseText.setText(null);
    }//GEN-LAST:event_CategoryPriseTextMouseClicked

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
        fill();
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseMoved
        // TODO add your handling code here:
        fill();
    }//GEN-LAST:event_jComboBox1MouseMoved

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
            java.util.logging.Logger.getLogger(add_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_Category().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CategoryPriseText;
    private javax.swing.JTextField CategoryText;
    private javax.swing.JTextField NumberText;
    private javax.swing.JButton addBT;
    private javax.swing.JButton exitBT;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
