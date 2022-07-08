package banco_agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/agenda","root", "");
        } 
        catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
