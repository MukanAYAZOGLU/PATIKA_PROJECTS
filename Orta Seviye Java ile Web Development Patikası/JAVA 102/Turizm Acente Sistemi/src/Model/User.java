package Model;

import Support.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {

    private int id;
    private String  name;
    private String  surname;
    private String  userName;
    private String  mail;
    private String   phone;
    private String  password;
    private String  userType;


    public User(int id, String name, String surname, String userName, String mail, String  phone, String password, String userType) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.mail = mail;
        this.phone = phone;
        this.password = password;
        this.userType = userType;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String   getPhone() {
        return phone;
    }

    public void setPhone(String   phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public static ArrayList<User> getUsers(){
        String query="SELECT * FROM user";

        ArrayList<User> users=new ArrayList<>();

        try {
            Statement stmt= DBConnection.getConnection().createStatement();
            ResultSet resulset=stmt.executeQuery(query);
            while (resulset.next()) {

                users.add(match(resulset));
            }
            resulset.close();
            stmt.close();
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean add(String name, String surname, String userName, String mail, String phone, String password, String userType) {

        String query="INSERT INTO user (name, surname, userName, mail, phone, password, userType) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, mail);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, userType);
            if (preparedStatement.executeUpdate()>0) {
                preparedStatement.close();
                return true;
            }else {
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean update(int id, String name, String surname, String userName, String mail, String phone, String password, String userType) {


        String query="UPDATE user SET name=?, surname=?, userName=?, mail=?, phone=?, password=?, userType=? WHERE id=?";

        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, mail);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, userType);
            preparedStatement.setInt(8,id);
            if (preparedStatement.executeUpdate()>0) {
                preparedStatement.close();
                return true;
            }else {
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static User getUser(int id) {
        String query="SELECT * FROM user WHERE id=?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultset=preparedStatement.executeQuery();
            if (resultset.next()) {
                return match(resultset);

            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean delete(int id) {
        String query="DELETE FROM user WHERE id=?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate()>0) {
                preparedStatement.close();
                return true;
            }else {
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<User> search(String name, String surname, String userName, String type) {
        String query="SELECT * FROM user WHERE name LIKE '%{{name}}%' AND surname LIKE '%{{surname}}%' AND userName LIKE '%{{userName}}%' ";
        ArrayList<User> users=new ArrayList<>();

        query=query.replace("{{name}}", name);
        query=query.replace("{{surname}}", surname);
        query=query.replace("{{userName}}", userName);

        if (type!=null){

            query+= "AND userType= '"+type+"' ";


        }

        try {
            Statement statement=DBConnection.getConnection().createStatement();
            ResultSet resultset=statement.executeQuery(query);
            while (resultset.next()) {
                users.add(match(resultset));
            }
            resultset.close();
            statement.close();
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static User match(ResultSet resultSet) throws SQLException {

        int id=resultSet.getInt("id");
        String name=resultSet.getString("name");
        String surname=resultSet.getString("surname");
        String userName=resultSet.getString("userName");
        String mail=resultSet.getString("mail");
        String  phone=resultSet.getString("phone");
        String password=resultSet.getString("password");
        String userType=resultSet.getString("userType");

        return new User(id,name,surname,userName,mail,phone,password,userType);

    }

}
