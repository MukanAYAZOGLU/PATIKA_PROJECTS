package Support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private final String DB_URL = "jdbc:mysql://localhost:3306/tourismAgencySystem";
    private final String DB_USER = "patika";
    private final String DB_PASSWORD = "MySqlPatika.?0";


    Connection con=null;

    public Connection connectDB() {


        try {
            con= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;


    }


    public static Connection getConnection() {
        DBConnection dbc=new DBConnection();
        return dbc.connectDB();
    }







}
