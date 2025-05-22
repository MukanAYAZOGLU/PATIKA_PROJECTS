package Model;

import Support.DBConnection;
import Support.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Product {

    private int id;
    private String name;
    private String code;
    private int price;
    private int stock;

    public Product(int id, String name, String code, int price, int stock) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.stock = stock;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static ArrayList<Product> getProducts(){

        String query="SELECT * FROM product";
        ArrayList<Product> products=new ArrayList<>();

        try {
            Statement statement= DBConnection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                products.add(matchThem(resultSet));
            }
            resultSet.close();
            statement.close();
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean add(String name, String code, int price, int stock){
        String query="INSERT INTO product (name, code, price, stock) VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,code);
            preparedStatement.setInt(3,price);
            preparedStatement.setInt(4,stock);
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

    public static ArrayList<Product> search(String name, String code, Item isStock){

        String query="SELECT * FROM product WHERE name LIKE '%{{name}}%' AND code LIKE '%{{code}}%' ";


        query=query.replace("{{name}}",name);
        query=query.replace("{{code}}",code);


        if (isStock!=null){

            if (isStock.getKey()==0){
                query+="AND stock =0";

            }else query+="AND stock >0";
        }



        try {
            Statement statement=DBConnection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            ArrayList<Product> products=new ArrayList<>();
            while (resultSet.next()){
                products.add(matchThem(resultSet));
            }
            resultSet.close();
            statement.close();
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean delete(int id){
        String query="DELETE FROM product WHERE id=?";

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

    public static Product getProduct(int id) {
        Product product = null;
        String query = "SELECT * FROM product WHERE id=?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                product = matchThem(resultSet);
            }
            resultSet.close();
            preparedStatement.close();
            return product;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean update(int id, String name, String code, int price, int stock){
        String query="UPDATE product SET name=?, code=?, price=?, stock=?  WHERE id=?";

        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,code);
            preparedStatement.setInt(3,price);
            preparedStatement.setInt(4,stock);
            preparedStatement.setInt(5,id);
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







    public static Product matchThem(ResultSet resultSet) throws SQLException {
        int id=resultSet.getInt("id");
        String name=resultSet.getString("name");
        String code=resultSet.getString("code");
        int price=resultSet.getInt("price");
        int stock=resultSet.getInt("stock");

        Product product=new Product(id,name,code,price,stock);
        return product;
    }


}
