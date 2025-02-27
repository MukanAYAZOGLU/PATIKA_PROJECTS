package Model;

import Support.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Customer {

    private int id;
    private String name;
    private String type;
    private String phone;
    private String email;
    private String address;


    public enum TYPE{
        PERSON,
        COMPANY
    }


    public Customer(int id, String name, String type, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.phone = phone;
        this.email = email;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                customers.add(matchThem(resultSet));
            }
            resultSet.close();
            statement.close();
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Customer getCustomer(int id) {
        Customer customer = null;
        String query = "SELECT * FROM customer WHERE id=?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                customer = matchThem(resultSet);
            }
            return customer;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean delete (int id){
        String query = "DELETE FROM customer WHERE id=?";

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() >0){
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

    public static boolean add (String name, String type, String phone, String mail, String address) {
        String query = "INSERT INTO customer (name,type,phone,mail,address) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, mail);
            preparedStatement.setString(5, address);
            if (preparedStatement.executeUpdate() >0){
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

    public static boolean update (int id, String name, String type, String phone, String mail, String address) {
        String query="UPDATE customer SET name=?,type=?,phone=?,mail=?,address=? WHERE id=?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, mail);
            preparedStatement.setString(5, address);
            preparedStatement.setInt(6, id);
            if (preparedStatement.executeUpdate() >0){
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

    public static Customer getFetchByName(String name){
        Customer customer=null;
        String query="SELECT * FROM customer WHERE name=?";

        try {
            PreparedStatement preparedStatement= DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer=matchThem(resultSet);
            }
            resultSet.close();
            preparedStatement.close();
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Customer> search(String name, Customer.TYPE type) {
        ArrayList<Customer> customers = new ArrayList<>();
        String query="SELECT * FROM customer WHERE name LIKE '%{{name}}%'";


        query=query.replace("{{name}}", name);

        if (type != null) {
            query+=" AND type= '"+type+"' ";

        }


        try {
           Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                customers.add(matchThem(resultSet));
            }
            resultSet.close();
            statement.close();
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Customer matchThem(ResultSet resultSet) throws SQLException {
        int id=resultSet.getInt("id");
        String nameSurname=resultSet.getString("name");
        String ttype=resultSet.getString("type");
        String phone=resultSet.getString("phone");
        String mail=resultSet.getString("mail");
        String address=resultSet.getString("address");

        Customer customer=new Customer(id,nameSurname,ttype,phone,mail,address);
        return customer;
    }

}
