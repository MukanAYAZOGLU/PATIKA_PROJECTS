package Support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final String DB_URL="jdbc:mysql://localhost:3306/customerManage";
    private final String DB_NAME="patika";
    private final String DB_PASSWORD="MySqlPatika.?0";


    private Connection conn;


    public Connection connectDB() {

        try {
            this.conn = DriverManager.getConnection(DB_URL,DB_NAME,DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.conn;


    }


public static Connection getConnection() {
        DBConnection dbConnection = new DBConnection();
        return dbConnection.connectDB();
}


}
