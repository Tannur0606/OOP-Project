import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5433/online_store";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2006";
    private static Connection instance;

    private DatabaseConnection() {}

    // Get the instance of the connection (singleton pattern)
    public static Connection getInstance() {
        if (instance == null) {
            try {
                instance = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connected to PostgreSQL database!");
            } catch (SQLException e) {
                System.out.println("Error code: " + e.getErrorCode());
                System.out.println("SQLState: " + e.getSQLState());
                e.printStackTrace();
                throw new RuntimeException("Database connection failed: " + e.getMessage(), e);
            }
        }
        return instance;
    }

    // Optional: You can keep this method to explicitly close the connection when your app ends
    public static void closeConnection() {
        if (instance != null) {
            try {
                // Only close connection when the application terminates
                instance.close();
                System.out.println("Connection closed successfully!");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
