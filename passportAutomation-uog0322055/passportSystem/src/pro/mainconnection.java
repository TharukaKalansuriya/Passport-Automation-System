package pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mainconnection {
    
	Connection conn;
	public void establishConnection() {
        String username = "root";
        String pwd = "1234";
        String dbname = "passportAutomation";

        try {
            // Assign the value to the class-level variable
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, username, pwd);
            System.out.println("DB Connection Success!!");
        } catch (SQLException e) {
            System.out.println("DB Connection Failed!!");
            System.out.println(e);
        }
    }

    // Add a getter method to retrieve the connection
    public Connection getConnection() {
        return conn;
    }
}