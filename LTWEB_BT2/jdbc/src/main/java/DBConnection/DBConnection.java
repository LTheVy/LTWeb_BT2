package DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ltweb";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "1234";
    private static Connection con;
    
    public static Connection getConnection() throws IOException {
        con = null;
        try {
        	DriverManager.registerDriver(new Driver());
            con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void main(String[] args) {
        try {
            Connection c = getConnection();
            if (c == null) {
                System.out.println("Something wrong");
            } else {
                System.out.println("ok");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
