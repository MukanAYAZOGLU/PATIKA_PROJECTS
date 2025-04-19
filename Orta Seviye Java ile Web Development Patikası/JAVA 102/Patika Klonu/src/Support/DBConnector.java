package Support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {


    private Connection con;


    public Connection connectDB()  {

        try {
            this.con= DriverManager.getConnection(Support.DB_URL, Support.DB_USER_NAME, Support.DB_PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.con;


    }

    public static Connection getConnection() {
        DBConnector db = new DBConnector();
        return db.connectDB();
    }

}
