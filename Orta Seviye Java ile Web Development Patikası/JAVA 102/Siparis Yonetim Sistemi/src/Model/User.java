package Model;

import Support.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {


    private int id;
    private String name;
    private String email;
    private String password;


    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        String query = "SELECT * FROM users";

        try {
            Statement stmt = DBConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                users.add(new User(id, name, email, password));
            }

            rs.close();
            stmt.close();
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static ArrayList<User> getUsersByQuery(String name, String email) {
        ArrayList<User> users = new ArrayList<>();

        String query = "SELECT * FROM users WHERE name LIKE '%{{name}}%' AND email LIKE '%{{email}}%'";

        query=query.replace("{{name}}",name);
        query=query.replace("{{email}}",email);

        try {
            Statement stmt = DBConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String namee = rs.getString("name");
                String emaill = rs.getString("email");
                String password = rs.getString("password");
                users.add(new User(id, namee, emaill, password));
            }

            rs.close();
            stmt.close();
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static User getUser(String email, String password) {
        String query="SELECT * FROM user WHERE email=? AND password=?";
        User user=null;
        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1,email);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                user = new User(id, name, email, password);
            }
            rs.close();
            stmt.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
