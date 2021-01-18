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
import net.proteanit.sql.DbUtils;

/**
 *
 * @author midom
 */
public class Employee_service extends javax.swing.JFrame {

    /**
     * Creates new form CustomerService
     */
    Connection conct;
    Statement stmt;
    String Query;
    ResultSet RS;
    String Date;
    int InBalance = 0;
    int x, y;
    int TotalPrice;
    int TotalPaid;
    int TotalService;
    int result;

    public Employee_service() {
        initComponents();
        jLabel1.setText(Search.CustomerName);
        jLabel2.setText(Search.CustomerPhone);
        EmployeePanal.setVisible(false);
        Date date = new Date();
        SimpleDateFormat SD = new SimpleDateFormat("dd/MM/yyyy");
        Date = SD.format(date);
        AddCombo();
    }

    public Employee_service(double x) {

        initComponents();
        jLabel9.setText(Search_2.EmployeeName);
        jLabel10.setText(Search_2.EmployeePhone);
        CustomerPanal.setVisible(false);
        jLabel12.setVisible(false);
        jTextField5.setVisible(false);
        jLabel13.setVisible(false);
        jTextField6.setVisible(false);
        jButton2.setVisible(false);
        jLabel11.setVisible(false);
        Date date = new Date();
        SimpleDateFormat SD = new SimpleDateFormat("dd/MM/yyyy");
        Date = SD.format(date);
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `service` where `Employee id`=\"" + Search_2.EmployeeID + "\";";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public Employee_service(int x) {
        initComponents();
        jLabel9.setText(Search.EmployeeName);
        jLabel10.setText(Search.EmployeePhone);
        CustomerPanal.setVisible(false);
        jLabel18.setVisible(false);
        jLabel19.setVisible(false);
        jTextField7.setVisible(false);
        jLabel20.setVisible(false);
        jTextField8.setVisible(false);
        jButton3.setVisible(false);
        Date date = new Date();
        SimpleDateFormat SD = new SimpleDateFormat("dd/MM/yyyy");
        Date = SD.format(date);
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();
            Query = "SELECT * FROM `service` where `Employee id`=\"" + Search.EmployeeID + "\";";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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

    public void getItems() {
        String Id = jComboBox1.getSelectedItem().toString();
        if (Id == "0") {
            OrderName.setText("صيانة");
            OrderAmount.setText("1");

        } else {
            try {
                conct = Connect.connect();
                stmt = conct.createStatement();
                Query = "SELECT * FROM `categories` WHERE `ID`= '" + Id + "'";
                RS = stmt.executeQuery(Query);
                if (RS.next()) {
                    OrderName.setText(RS.getString("Name"));
                    OrderPrise.setText(RS.getString("Prise"));
                }
                OrderAmount.setText("1");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }

    public void Add() {
        try {
            String comment = "Order to " + Search.CustomerName;
            x = Integer.parseInt(OrderPaid.getText());
            y = Integer.parseInt(PriseAll.getText());
            conct = Connect.connect();

            stmt = conct.createStatement();
            //----------------------------------------- add to safe list ------------------------------------------------------------------------------------
            Query = "SELECT `Total` FROM `ashry cool`.`in safe` order by id desc limit 1;";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                InBalance = Integer.parseInt(RS.getString(1));
            }
            InBalance = InBalance + x;
            String Money = Integer.toString(InBalance);
            Query = "INSERT INTO `ashry cool`.`in safe` (`Items`, `Prise`, `Date`, `User name`,`Total`) VALUES"
                    + " ('" + comment + "', '" + OrderPaid.getText() + "', '" + Date + "', '" + Password.Uname + "','" + Money + "');";
            stmt.execute(Query);
            //-------------------------------------------------- update on customer list ------------------------------------------------------------------------------------------------------

            Query = "SELECT `Total Price` FROM `ashry cool`.`customers` WHERE ID = '" + Search.CustomerID + "' ;";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                TotalPrice = Integer.parseInt(RS.getString(1));
            }
            TotalPrice = TotalPrice + y;

            Query = "UPDATE `ashry cool`.`customers` SET `Total Price` = '" + Integer.toString(TotalPrice) + "' WHERE (`ID` = '" + Search.CustomerID + "');";
            stmt.execute(Query);

            Query = "SELECT `Total Paid` FROM `ashry cool`.`customers` WHERE ID = '" + Search.CustomerID + "' ";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                TotalPaid = Integer.parseInt(RS.getString(1));
            }
            TotalPaid = TotalPaid + x;

            Query = "UPDATE `ashry cool`.`customers` SET `Total Paid` = '" + Integer.toString(TotalPaid) + "' WHERE (`ID` = '" + Search.CustomerID + "');";
            stmt.execute(Query);
            int z = TotalPrice - TotalPaid;

            Query = "UPDATE `ashry cool`.`customers` SET `Money` = '" + Integer.toString(z) + "' WHERE (`ID` = '" + Search.CustomerID + "');";
            stmt.execute(Query);

            //------------------------------------------------- add to Order list -------------------------------------------------------------------------
            Query = "INSERT INTO `ashry cool`.`orders` (`Customer Id`, `Order name`, `Order amount`, `Order price`, `Order discount`, `Order paid`, `Order non paid`) VALUES"
                    + " ('" + Search.CustomerID + "', '" + OrderName.getText() + "', '" + OrderAmount.getText() + "', '" + PriseAll.getText() + "'"
                    + ", '" + OrderDiscount.getText() + "', '" + OrderPaid.getText() + "', '" + OrderNONPaid.getText() + "');";
            stmt.execute(Query);

            JOptionPane.showMessageDialog(null, "Order added");
            OrderAmount.setText("0.0");
            OrderName.setText(null);
            OrderDiscount.setText("0.0");
            OrderNONPaid.setText("0.0");
            OrderPaid.setText("0.0");
            OrderPrise.setText("0.0");
            PriseAll.setText("0.0");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void Add2() {
        String Select = jComboBox1.getSelectedItem().toString();
        try {
            String comment = "Order to " + Search.CustomerName;
            x = Integer.parseInt(OrderPaid.getText());
            y = Integer.parseInt(PriseAll.getText());
            conct = Connect.connect();

            stmt = conct.createStatement();
            //----------------------------------------- add to safe list ------------------------------------------------------------------------------------
            Query = "SELECT `Total` FROM `ashry cool`.`in safe` order by id desc limit 1;";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                InBalance = Integer.parseInt(RS.getString(1));
            }
            InBalance = InBalance + x;
            String Money = Integer.toString(InBalance);
            Query = "INSERT INTO `ashry cool`.`in safe` (`Items`, `Prise`, `Date`, `User name`,`Total`) VALUES"
                    + " ('" + comment + "', '" + OrderPaid.getText() + "', '" + Date + "', '" + Password.Uname + "','" + Money + "');";
            stmt.execute(Query);
            //-------------------------------------------------- update on customer list ------------------------------------------------------------------------------------------------------

            Query = "SELECT `Total Price` FROM `ashry cool`.`customers` WHERE ID = '" + Search.CustomerID + "' ;";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                TotalPrice = Integer.parseInt(RS.getString(1));
            }
            TotalPrice = TotalPrice + y;

            Query = "UPDATE `ashry cool`.`customers` SET `Total Price` = '" + Integer.toString(TotalPrice) + "' WHERE (`ID` = '" + Search.CustomerID + "');";
            stmt.execute(Query);

            Query = "SELECT `Total Paid` FROM `ashry cool`.`customers` WHERE ID = '" + Search.CustomerID + "' ";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                TotalPaid = Integer.parseInt(RS.getString(1));
            }
            TotalPaid = TotalPaid + x;

            Query = "UPDATE `ashry cool`.`customers` SET `Total Paid` = '" + Integer.toString(TotalPaid) + "' WHERE (`ID` = '" + Search.CustomerID + "');";
            stmt.execute(Query);
            int z = TotalPrice - TotalPaid;

            Query = "UPDATE `ashry cool`.`customers` SET `Money` = '" + Integer.toString(z) + "' WHERE (`ID` = '" + Search.CustomerID + "');";
            stmt.execute(Query);

            //------------------------------------------------- add to Order list -------------------------------------------------------------------------
            Query = "INSERT INTO `ashry cool`.`orders` (`Customer Id`, `Order name`, `Order amount`, `Order price`, `Order discount`, `Order paid`, `Order non paid`) VALUES"
                    + " ('" + Search.CustomerID + "', '" + OrderName.getText() + "', '" + OrderAmount.getText() + "', '" + PriseAll.getText() + "'"
                    + ", '" + OrderDiscount.getText() + "', '" + OrderPaid.getText() + "', '" + OrderNONPaid.getText() + "');";
            stmt.execute(Query);

            //-----------------------------------------------------------------------------------------------------------------------------------------------
            Query = "SELECT `Number` FROM `categories` WHERE `ID` = '" + Select + "'";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                result = Integer.parseInt(RS.getString(1));
            }
            result -= Integer.parseInt(OrderAmount.getText());

            Query = "update `categories` set `number` = '" + result + "' where `id`= '" + Select + "';";
            stmt = conct.prepareStatement(Query);
            stmt.execute(Query);

            JOptionPane.showMessageDialog(null, "Order added");
            OrderAmount.setText("0.0");
            OrderName.setText(null);
            OrderDiscount.setText("0.0");
            OrderNONPaid.setText("0.0");
            OrderPaid.setText("0.0");
            OrderPrise.setText("0.0");
            PriseAll.setText("0.0");
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

        CustomerPanal = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        PriseAll = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        OrderAmount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        OrderDiscount = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        OrderName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        OrderPrise = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        OrderPaid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        OrderNONPaid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        EmployeePanal = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        CustomerPanal.setLayout(null);

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox1MousePressed(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        CustomerPanal.add(jComboBox1);
        jComboBox1.setBounds(750, 140, 120, 28);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("رقم الخدمة");
        jLabel21.setToolTipText("");
        CustomerPanal.add(jLabel21);
        jLabel21.setBounds(900, 140, 135, 29);

        PriseAll.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        PriseAll.setText("0");
        PriseAll.setEnabled(false);
        PriseAll.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                PriseAllCaretUpdate(evt);
            }
        });
        PriseAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PriseAllMouseClicked(evt);
            }
        });
        CustomerPanal.add(PriseAll);
        PriseAll.setBounds(540, 310, 126, 35);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("الكمية");
        CustomerPanal.add(jLabel17);
        jLabel17.setBounds(950, 260, 80, 35);

        OrderAmount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        OrderAmount.setText("0");
        OrderAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderAmountMouseClicked(evt);
            }
        });
        CustomerPanal.add(OrderAmount);
        OrderAmount.setBounds(750, 260, 126, 35);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ok-icon.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        CustomerPanal.add(jButton1);
        jButton1.setBounds(700, 550, 130, 50);

        OrderDiscount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        OrderDiscount.setText("0");
        OrderDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderDiscountMouseClicked(evt);
            }
        });
        CustomerPanal.add(OrderDiscount);
        OrderDiscount.setBounds(750, 370, 126, 35);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("الخصم");
        CustomerPanal.add(jLabel16);
        jLabel16.setBounds(950, 370, 80, 35);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("اضافة خدمات للعملاء");
        CustomerPanal.add(jLabel8);
        jLabel8.setBounds(20, 30, 240, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("5558585");
        CustomerPanal.add(jLabel1);
        jLabel1.setBounds(600, 20, 410, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        CustomerPanal.add(jLabel2);
        jLabel2.setBounds(850, 60, 168, 28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("اسم الخدمة");
        jLabel3.setToolTipText("");
        CustomerPanal.add(jLabel3);
        jLabel3.setBounds(900, 200, 135, 29);

        OrderName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CustomerPanal.add(OrderName);
        OrderName.setBounds(470, 200, 401, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("السعر");
        CustomerPanal.add(jLabel4);
        jLabel4.setBounds(960, 310, 68, 35);

        OrderPrise.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        OrderPrise.setText("0");
        OrderPrise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderPriseMouseClicked(evt);
            }
        });
        CustomerPanal.add(OrderPrise);
        OrderPrise.setBounds(750, 310, 126, 35);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("المدفوع");
        CustomerPanal.add(jLabel5);
        jLabel5.setBounds(940, 430, 89, 35);

        OrderPaid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        OrderPaid.setText("0");
        OrderPaid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderPaidMouseClicked(evt);
            }
        });
        OrderPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderPaidActionPerformed(evt);
            }
        });
        CustomerPanal.add(OrderPaid);
        OrderPaid.setBounds(750, 430, 126, 35);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("الباقى");
        CustomerPanal.add(jLabel6);
        jLabel6.setBounds(950, 480, 71, 35);

        OrderNONPaid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        OrderNONPaid.setText("0");
        OrderNONPaid.setEnabled(false);
        OrderNONPaid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderNONPaidMouseClicked(evt);
            }
        });
        OrderNONPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderNONPaidActionPerformed(evt);
            }
        });
        CustomerPanal.add(OrderNONPaid);
        OrderNONPaid.setBounds(750, 480, 126, 35);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        CustomerPanal.add(jScrollPane1);
        jScrollPane1.setBounds(12, 235, 452, 360);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OLO2ED011.jpg"))); // NOI18N
        CustomerPanal.add(jLabel7);
        jLabel7.setBounds(0, 0, 1100, 660);

        getContentPane().add(CustomerPanal);
        CustomerPanal.setBounds(0, 0, 1070, 630);

        EmployeePanal.setLayout(null);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ok-icon.png"))); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        EmployeePanal.add(jButton2);
        jButton2.setBounds(450, 300, 130, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        EmployeePanal.add(jLabel9);
        jLabel9.setBounds(778, 30, 250, 34);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        EmployeePanal.add(jLabel10);
        jLabel10.setBounds(738, 82, 290, 34);

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("اضافة حوافز الموظفين");
        EmployeePanal.add(jLabel11);
        jLabel11.setBounds(30, 30, 280, 29);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("الحوافز / البدلات");
        EmployeePanal.add(jLabel12);
        jLabel12.setBounds(830, 160, 183, 35);

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField5.setText("حوافز");
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        EmployeePanal.add(jTextField5);
        jTextField5.setBounds(360, 160, 402, 34);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("المبلغ");
        EmployeePanal.add(jLabel13);
        jLabel13.setBounds(940, 220, 65, 29);

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField6.setText("0.0");
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        EmployeePanal.add(jTextField6);
        jTextField6.setBounds(640, 220, 117, 35);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        EmployeePanal.add(jScrollPane2);
        jScrollPane2.setBounds(30, 370, 980, 230);

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("خصم رصيد من موظف");
        EmployeePanal.add(jLabel18);
        jLabel18.setBounds(30, 30, 280, 29);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("ملاحظات");
        EmployeePanal.add(jLabel19);
        jLabel19.setBounds(910, 160, 110, 35);

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField7.setText("خصم");
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        EmployeePanal.add(jTextField7);
        jTextField7.setBounds(360, 160, 402, 34);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("المبلغ");
        EmployeePanal.add(jLabel20);
        jLabel20.setBounds(940, 220, 65, 29);

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField8.setText("0.0");
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
        });
        EmployeePanal.add(jTextField8);
        jTextField8.setBounds(640, 220, 117, 35);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ok-icon.png"))); // NOI18N
        jButton3.setText("Discount");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        EmployeePanal.add(jButton3);
        jButton3.setBounds(450, 300, 130, 40);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OLO2ED011.jpg"))); // NOI18N
        EmployeePanal.add(jLabel14);
        jLabel14.setBounds(0, 0, 1100, 650);

        getContentPane().add(EmployeePanal);
        EmployeePanal.setBounds(0, 0, 1060, 630);

        setSize(new java.awt.Dimension(1060, 658));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id = jComboBox1.getSelectedItem().toString();
        if (id == "0") {
            Add();
        } else {
            Add2();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PriseAllCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_PriseAllCaretUpdate
        // -----------------------TODO add your handling code here:

    }//GEN-LAST:event_PriseAllCaretUpdate

    private void PriseAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PriseAllMouseClicked
        // TODO add your handling code here:
        int x = Integer.parseInt(OrderAmount.getText());
        int z, y = Integer.parseInt(OrderPrise.getText());
        z = x * y;
        PriseAll.setText(Integer.toString(z));
    }//GEN-LAST:event_PriseAllMouseClicked

    private void OrderAmountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderAmountMouseClicked
        // TODO add your handling code here:
        OrderAmount.setText(null);
    }//GEN-LAST:event_OrderAmountMouseClicked

    private void OrderPriseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderPriseMouseClicked
        // TODO add your handling code here:
        OrderPrise.setText(null);
    }//GEN-LAST:event_OrderPriseMouseClicked

    private void OrderDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderDiscountMouseClicked
        // TODO add your handling code here:
        OrderDiscount.setText(null);
    }//GEN-LAST:event_OrderDiscountMouseClicked

    private void OrderPaidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderPaidMouseClicked
        // TODO add your handling code here:
        OrderPaid.setText(null);
    }//GEN-LAST:event_OrderPaidMouseClicked

    private void OrderNONPaidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderNONPaidMouseClicked
        // TODO add your handling code here:

        int x = Integer.parseInt(PriseAll.getText());
        int z;
        int y = Integer.parseInt(OrderPaid.getText());
        int a = Integer.parseInt(OrderDiscount.getText());
        z = x - y - a;
        OrderNONPaid.setText(Integer.toString(z));
    }//GEN-LAST:event_OrderNONPaidMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();

            Query = "SELECT * FROM `service` where `Employee id`=\"" + Search.EmployeeID + "\";";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));

            //---------------------------------------------------------------------------------------------------------------------------------
            Query = "Select `Total` FROM `service` WHERE `Employee id` = '" + Search.EmployeeID + "' order by `Service id` desc limit 1";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                TotalService = Integer.parseInt(RS.getString(1));
            }
            TotalService += Integer.parseInt(jTextField6.getText());

            Query = "INSERT INTO `ashry cool`.`service` (`Employee id`, `Service name`, `Price`,`Total`) VALUES"
                    + " ('" + Search.EmployeeID + "', '" + jTextField5.getText() + "', '" + jTextField6.getText() + "','" + TotalService + "');";
            stmt.execute(Query);

            Query = "SELECT * FROM `service` where `Employee id`=\"" + Search.EmployeeID + "\";";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        jTextField6.setText(null);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        // TODO add your handling code here:
        jTextField6.setText(null);
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        // TODO add your handling code here:
        jTextField5.setText(null);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        // TODO add your handling code here:
        jTextField8.setText(null);
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            conct = Connect.connect();
            stmt = conct.createStatement();

            Query = "SELECT * FROM `service` where `Employee id`=\"" + Search_2.EmployeeID + "\";";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));

            //---------------------------------------------------------------------------------------------------------------------------------
            Query = "Select `Total` FROM `service` WHERE `Employee id` = '" + Search_2.EmployeeID + "' order by `Service id` desc limit 1";
            RS = stmt.executeQuery(Query);
            if (RS.next()) {
                TotalService = Integer.parseInt(RS.getString(1));
            }
            TotalService -= Integer.parseInt(jTextField8.getText());

            Query = "INSERT INTO `ashry cool`.`service` (`Employee id`, `Service name`, `Price`,`Total`) VALUES"
                    + " ('" + Search_2.EmployeeID + "', '" + jTextField7.getText() + "', '" + jTextField8.getText() + "','" + TotalService + "');";
            stmt.execute(Query);

            Query = "SELECT * FROM `service` where `Employee id`=\"" + Search_2.EmployeeID + "\";";
            RS = stmt.executeQuery(Query);
            jTable2.setModel(DbUtils.resultSetToTableModel(RS));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        jTextField8.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
        getItems();
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1MousePressed

    private void jComboBox1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseMoved
        // TODO add your handling code here:
        getItems();
    }//GEN-LAST:event_jComboBox1MouseMoved

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
        // TODO add your handling code here:
        getItems();
    }//GEN-LAST:event_jComboBox1MouseEntered

    private void jComboBox1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseExited
        // TODO add your handling code here:
        getItems();
    }//GEN-LAST:event_jComboBox1MouseExited

    private void OrderNONPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderNONPaidActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_OrderNONPaidActionPerformed

    private void OrderPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderPaidActionPerformed

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
            java.util.logging.Logger.getLogger(Employee_service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee_service().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CustomerPanal;
    private javax.swing.JPanel EmployeePanal;
    private javax.swing.JTextField OrderAmount;
    private javax.swing.JTextField OrderDiscount;
    private javax.swing.JTextField OrderNONPaid;
    private javax.swing.JTextField OrderName;
    private javax.swing.JTextField OrderPaid;
    private javax.swing.JTextField OrderPrise;
    private javax.swing.JTextField PriseAll;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
