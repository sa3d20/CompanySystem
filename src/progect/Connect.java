/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author midom
 */
public class Connect {
    private static final String DBuser = "root";
    private static final String DBpass = "";
    private static final String ada = "jdbc:mysql://localhost:3306/ashry cool";
    public static Connection connect() throws SQLException{return DriverManager.getConnection(ada, DBuser, DBpass);}
}
