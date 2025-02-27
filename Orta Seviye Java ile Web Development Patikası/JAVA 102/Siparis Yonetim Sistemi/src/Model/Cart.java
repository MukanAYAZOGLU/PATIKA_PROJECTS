package Model;

import Support.DBConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cart {


    private int id;
    private int customerID;
    private int productID;
    private int price;
    private String  date;
    private String note;
    private Customer customer=Customer.getCustomer(customerID);
    private Product product;


    public Cart(int id, int customerID, int productID, int price, String  date, String note) {
        this.id = id;
        this.customerID = customerID;
        this.productID = productID;
        this.price = price;
        this.date = date;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String  getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public static boolean addCart(int customerID, int productID, int price, String  date, String  note) {
        String query="INSERT INTO cart (customerID, productID, price, date, note) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement= DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, customerID);
            preparedStatement.setInt(2, productID);
            preparedStatement.setInt(3, price);
            preparedStatement.setString(4, date);
            preparedStatement.setString(5, note);
            if(preparedStatement.executeUpdate()>0){
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

    public static ArrayList<Cart> getCarts() {
        String query="SELECT * FROM cart ";

        ArrayList<Cart> carts=new ArrayList<>();

        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){

                carts.add(matchThem(resultSet));
            }
            resultSet.close();
            preparedStatement.close();
            return carts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



    public static Cart matchThem(ResultSet resultSet) throws SQLException {
        int id=resultSet.getInt("id");
        int customerID=resultSet.getInt("customerID");
        int productID=resultSet.getInt("productID");
        int price=resultSet.getInt("price");
        String date=resultSet.getString("date");
        String note=resultSet.getString("note");

        Cart cart=new Cart(id,customerID,productID,price,date,note);
        return cart;
    }



}
