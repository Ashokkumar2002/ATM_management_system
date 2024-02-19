import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnect {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String password = "12345678";
        return DriverManager.getConnection(url,username,password);

    }
}
