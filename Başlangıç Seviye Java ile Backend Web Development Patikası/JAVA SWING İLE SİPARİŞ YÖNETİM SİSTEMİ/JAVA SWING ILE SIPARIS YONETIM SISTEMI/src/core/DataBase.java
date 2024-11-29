package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    //signleton design pattern


    private static DataBase instance = null;
    private Connection connection = null;
    private final String DT_URL = "jdbc:mysql://localhost:9000";
    private final String DB_UserName = "root";
    private final String DB_Password = "123!!";


    private DataBase() {

        try {
            this.connection = DriverManager.getConnection(DT_URL, DB_UserName, DB_Password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private Connection getConnection() {
        return connection;
    }


    public static Connection getInstance() {

        try {
            if (instance == null || instance.getConnection().isClosed()) {

                instance=new DataBase();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return instance.getConnection();

    }


}