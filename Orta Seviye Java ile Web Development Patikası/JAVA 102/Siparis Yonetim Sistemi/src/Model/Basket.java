package Model;


import Support.DBConnection;

import javax.naming.ldap.PagedResultsControl;
import javax.swing.text.html.HTMLDocument;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Stack;

public class Basket {

    private int id;
    private int productID;
    private Product product;


    public Basket(int id, int productID) {
        this.id = id;
        this.productID = productID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }


    public Product getProduct() {
        return Product.getProduct(productID);
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public static boolean add(int productID) {
        String query = "INSERT INTO basket (productID) values (?)";

        try {
            PreparedStatement preparedStatement= DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, productID);
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

    public static Basket getByProductID(int productID) {

        String query = "SELECT * FROM basket WHERE productID = ?";

        Basket basket = null;

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, productID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                basket = new Basket(resultSet.getInt("id"), resultSet.getInt("productID"));
            }
            resultSet.close();
            preparedStatement.close();
            return basket;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Basket> getAll() {
        String query = "SELECT * FROM basket";
        ArrayList<Basket> baskets = new ArrayList<>();

        try {
            Statement statement=DBConnection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                baskets.add(new Basket(resultSet.getInt("id"), resultSet.getInt("productID")));
            }
            resultSet.close();
            statement.close();
            return baskets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteAll(){
        String query="DELETE FROM basket";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            if (preparedStatement.executeUpdate()>0){
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
}
