import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbcConnection {

    public static void main(String[] args) {
        // Database connection parameters
        String dbURL = "jdbc:mysql://localhost:3306/gcu_db?useSSL=false&serverTimezone=UTC";
        String dbUser = "root"; // Replace with your MySQL username
        String dbPass = "shiv9925"; // Replace with your MySQL password

        // Try connecting to the database
        try {
            // Load and register MySQL JDBC driver (not needed for newer MySQL Connector/J versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to MySQL database
            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Successfully connected to the database.");
            } else {
                System.out.println("Failed to connect to the database.");
            }

        } catch (ClassNotFoundException e) {
            // Handle JDBC driver not found error
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle connection failure or SQL exceptions
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
