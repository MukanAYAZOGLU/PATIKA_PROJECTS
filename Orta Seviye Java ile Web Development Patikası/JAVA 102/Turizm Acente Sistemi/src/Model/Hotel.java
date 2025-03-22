package Model;

import Support.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Hotel {


    private int id;
    private String name;
    private String pensionType;
    private String feature;
    private int star;
    private String phone;
    private String mail;
    private String region;
    private String city;
    private String address;




    public Hotel(int id, String name, String pensionType, String feature, int star, String phone, String mail, String region, String city, String address ) {
        this.id = id;
        this.name = name;
        this.pensionType = pensionType;
        this.feature = feature;
        this.star = star;
        this.phone = phone;
        this.mail = mail;
        this.region = region;
        this.city = city;
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

    public String getPensionType() {
        return pensionType;
    }

    public void setPensionType(String pensionType) {
        this.pensionType = pensionType;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public static ArrayList<Hotel> getAll() {

        String query="SELECT * FROM hotel";
        ArrayList<Hotel> hotels = new ArrayList<>();

        try {
            Statement stmt=DBConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()) {

                hotels.add(match(rs));

            }
            rs.close();
            stmt.close();
            return hotels;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean add(String name, String pensionType, String feature, int star, String phone, String mail, String region, String city, String address ){

        String query="INSERT INTO hotel (name, pensionType, feature, star, phone, mail, region, city, address ) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement= DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,pensionType);
            preparedStatement.setString(3,feature);
            preparedStatement.setInt(4,star);
            preparedStatement.setString(5,phone);
            preparedStatement.setString(6,mail);
            preparedStatement.setString(7,region);
            preparedStatement.setString(8,city);
            preparedStatement.setString(9,address);

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

    public static ArrayList<Hotel> search(String name, String pensionType, String star, String region, String city){
        String query="SELECT * FROM hotel WHERE name LIKE '%{{name}}%' ";
        ArrayList<Hotel> hotels = new ArrayList<>();

        query=query.replace("{{name}}",name);

        if (star!=null){
            query+="AND star = '"+star+"' ";
        }

        if (pensionType!=null){
            query+="AND pensionType LIKE '%{{pensionType}}%' ";
            query=query.replace("{{pensionType}}",pensionType);

        }

        if (region!=null) {
            query += "AND region =  '" + region + "'  ";
        }

        if (city!=null) {
            query += "AND city =  '"+city+"'  ";
        }



        try {
            Statement statement=DBConnection.getConnection().createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){

                hotels.add(match(rs));
            }
            rs.close();
            statement.close();
            return hotels;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Hotel getHotel(int id) {
        String query="SELECT * FROM hotel WHERE id=?";
        Hotel hotel=null;
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){

                hotel=match(rs);
            }
            rs.close();
            preparedStatement.close();
            return hotel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(int id, String name, String pensionType, String feature, int star, String phone, String mail, String region, String city, String address) {
        String query="UPDATE hotel SET name=?, pensionType=?, feature=?, star=?, phone=?, mail=?, region=?, city=?, address=? WHERE id=?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,pensionType);
            preparedStatement.setString(3,feature);
            preparedStatement.setInt(4,star);
            preparedStatement.setString(5,phone);
            preparedStatement.setString(6,mail);
            preparedStatement.setString(7,region);
            preparedStatement.setString(8,city);
            preparedStatement.setString(9,address);
            preparedStatement.setInt(10,id);
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

    public static boolean delete(int id) {
        String query="DELETE FROM hotel WHERE id=?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,id);
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

    public static Hotel getHotel(String name){
        String query="SELECT * FROM hotel WHERE name=?";
        Hotel hotel=null;
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1,name);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                hotel=match(rs);
            }
            rs.close();
            preparedStatement.close();
            return hotel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public static Hotel match(ResultSet resultSet) throws SQLException {

        int id=resultSet.getInt("id");
        String name=resultSet.getString("name");
        String pensionType=resultSet.getString("pensionType");
        String feature=resultSet.getString("feature");
        int star=resultSet.getInt("star");
        String phone=resultSet.getString("phone");
        String mail=resultSet.getString("mail");
        String region=resultSet.getString("region");
        String city=resultSet.getString("city");
        String address=resultSet.getString("address");


        return new Hotel(id,name,pensionType,feature,star,phone,mail,region,city,address);

    }



}
