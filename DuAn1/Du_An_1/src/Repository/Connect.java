/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADmin
 */
public class Connect {
     public static final String USERNAME = "sa";
    public static final String PASSWORD = "0334921271";
    public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=du_An1;encrypt=true;trustServerCertificate=true;";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnectDAO() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        Connect conn = new Connect();
         Connection connection = getConnectDAO();
        if (connection != null) {
            System.out.println("Ket noi thanh cong");
        } else {
            System.out.println("Ket noi khong thanh cong");
        }
    }
}
