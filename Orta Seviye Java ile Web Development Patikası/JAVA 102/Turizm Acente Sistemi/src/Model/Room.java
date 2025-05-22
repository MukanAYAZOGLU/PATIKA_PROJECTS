package Model;

import Support.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;


public class Room {

    private int id;
    private int hotelID;
    private String hotelName;
    private int star;
    private String roomType;
    private String pensionType;
    private Double pensionPrice;
    private int bedroomSet;
    private int space;
    private int roomStock;
    private String feature;
    private String region;
    private String city;
    private double priceForChild;
    private double priceForAdult;
    private Date entryDate;
    private Date releaseDate;


    public Room(int id,int hotelID, String hotelName,int star, String roomType, String pensionType,Double pensionPrice,int bedroomSet,int space, int roomStock, String feature,String region,String city, double priceForChild,double priceForAdult,Date entryDate,Date releaseDate) {
        this.id = id;
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.star = star;
        this.roomType = roomType;
        this.pensionType = pensionType;
        this.pensionPrice = pensionPrice;
        this.bedroomSet = bedroomSet;
        this.space = space;
        this.roomStock = roomStock;
        this.feature = feature;
        this.region = region;
        this.city = city;
        this.priceForChild = priceForChild;
        this.priceForAdult=priceForAdult;
        this.entryDate = entryDate;
        this.releaseDate = releaseDate;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getBedroomSet() {
        return bedroomSet;
    }

    public void setBedroomSet(int bedroomSet) {
        this.bedroomSet = bedroomSet;
    }

    public int getRoomStock() {
        return roomStock;
    }

    public void setRoomStock(int roomStock) {
        this.roomStock = roomStock;
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

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getPensionType() {
        return pensionType;
    }

    public void setPensionType(String pensionType) {
        this.pensionType = pensionType;
    }

    public double getPriceForChild() {
        return priceForChild;
    }

    public void setPriceForChild(double priceForChild) {
        this.priceForChild = priceForChild;
    }

    public double getPriceForAdult() {
        return priceForAdult;
    }

    public void setPriceForAdult(double priceForAdult) {
        this.priceForAdult = priceForAdult;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getPensionPrice() {
        return pensionPrice;
    }

    public void setPensionPrice(Double pensionPrice) {
        this.pensionPrice = pensionPrice;
    }

    public static ArrayList<Room> getRooms() {
        String query = "SELECT * FROM room";

        try {
            Statement stmt = DBConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Room> rooms = new ArrayList<>();
            while (rs.next()) {
                rooms.add(match(rs));
            }
            rs.close();
            stmt.close();
            return rooms;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM room WHERE id=?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            if(preparedStatement.executeUpdate()>0) {
                preparedStatement.close();
                return true;
            }else{
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteByHotelID(int hotelID) {
        String query = "DELETE FROM room WHERE hotelID=?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, hotelID);
            if(preparedStatement.executeUpdate()>0) {
                preparedStatement.close();
                return true;
            }else{
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Room getRoom(int id) {
        String query = "SELECT * FROM room WHERE id=?";

            try {
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()) {
                    return match(rs);
                }
                return null;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }



    }

    public static Room getRoom(String  hotelName, String roomType) {
        String query = "SELECT * FROM room WHERE hotelName=? AND roomType=?";

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, hotelName);
            preparedStatement.setString(2, roomType);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                return match(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public static boolean add(int hotelID, String hotelName, int star, String roomType, String pensionType, Double pensionPrice,int bedroomSet, int space,int stock, String feature, String region, String city,double priceForChild,double priceForAdult,Date entryDate,Date releaseDate){

            String query="INSERT INTO room (hotelID, hotelName,star, roomType,pensionType, pensionPrice, bedroomSet,space, stock, feature, region, city,priceForChild, priceForAdult,entryDate, releaseDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement preparedStatement= DBConnection.getConnection().prepareStatement(query);
                preparedStatement.setInt(1,hotelID);
                preparedStatement.setString(2,hotelName);
                preparedStatement.setInt(3,star);
                preparedStatement.setString(4,roomType);
                preparedStatement.setString(5,pensionType);
                preparedStatement.setDouble(6,pensionPrice);
                preparedStatement.setInt(7,bedroomSet);
                preparedStatement.setInt(8,space);
                preparedStatement.setInt(9,stock);
                preparedStatement.setString(10,feature);
                preparedStatement.setString(11,region);
                preparedStatement.setString(12,city);
                preparedStatement.setDouble(13,priceForChild);
                preparedStatement.setDouble(14,priceForAdult);
                preparedStatement.setDate(15, entryDate);
                preparedStatement.setDate(16, releaseDate);


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

    public static boolean update(int id, String roomType,String pensionType, Double pensionPrice,int bedroomSet,int space, int stock, String feature,double priceForChild,double priceForAdult,Date entryDate,Date releaseDate){
        String query="UPDATE room SET  roomType=?, pensionType=?, pensionPrice=?, bedroomSet=?, space=?,stock=?, feature=?,priceForChild=?, priceForAdult=?, entryDate=?, releaseDate=? WHERE id=?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1,roomType);
            preparedStatement.setString(2,pensionType);
            preparedStatement.setDouble(3,pensionPrice);
            preparedStatement.setInt(4,bedroomSet);
            preparedStatement.setInt(5,space);
            preparedStatement.setInt(6,stock);
            preparedStatement.setString(7,feature);
            preparedStatement.setDouble(8,priceForChild);
            preparedStatement.setDouble(9,priceForAdult);
            preparedStatement.setDate(10, entryDate);
            preparedStatement.setDate(11, releaseDate);
            preparedStatement.setInt(12,id);


            if(preparedStatement.executeUpdate()>0) {
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

    public static ArrayList<Room> search(String hotelName,  String star, String roomType, String pensionType, int stock, String bedroomSet,  String region, String city){

        String query="SELECT * FROM room WHERE hotelName LIKE '%{{name}}%' ";
        ArrayList<Room> rooms = new ArrayList<>();


        query=query.replace("{{name}}",hotelName);


        if (star!=null){
            query+="AND star = '"+star+"' ";
        }


        if (roomType!=null){
            query+="AND roomType = '"+roomType+"' ";
        }

        if (pensionType!=null){
            query+="AND pensionType = '"+pensionType+"' ";
        }

        if (bedroomSet!=null) {

            query+="AND bedroomSet = '"+bedroomSet+"' ";

        }


        if (stock>0){

            if (stock==1){
                query+="AND stock <=10  ";
            }else if (stock==2){
                query+="AND stock <=20  ";
            }else if (stock==3){
                query+="AND stock <=30  ";
            }else if (stock==4){
                query+="AND stock <=40  ";
            }else if (stock==5){
                query+="AND stock <=50  ";
            }else if (stock==6){
                query+="AND stock <=60  ";
            }else if (stock==7){
                query+="AND stock <=70  ";
            }else if (stock==8){
                query+="AND stock <=80  ";
            }else if (stock==9){
                query+="AND stock <=90  ";
            }else if (stock==10){
                query+="AND stock <=100  ";
            }

        }

        if (region!=null) {
            query += "AND region =  '"+region+"'  ";
        }



        if (city!=null) {
            query += "AND city =  '"+city+"'  ";
        }


        try {
            Statement statement=DBConnection.getConnection().createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                rooms.add(match(rs));
            }
            rs.close();
            statement.close();
            return rooms;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Room> search(String region, String city, int bedroomSet, Date entryDate, Date releaseDate){

        String query="SELECT * FROM room WHERE bedroomSet>=? AND stock>0 AND entryDate<=? AND releaseDate>=?";
        ArrayList<Room> rooms = new ArrayList<>();



        if (region!=null) {
            query += "AND region =  '"+region+"'  ";
        }


        if (city!=null) {
            query += "AND city =  '"+city+"'  ";
        }


        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,bedroomSet);
            preparedStatement.setDate(2,entryDate);
            preparedStatement.setDate(3,releaseDate);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                rooms.add(match(rs));
            }
            rs.close();
            preparedStatement.close();
            return rooms;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean reduceRoomStock(int  roomID, int roomStock){
        String query="UPDATE room SET stock=? WHERE id = ?";

        try {
                PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
                preparedStatement.setInt(1,roomStock-1);
                preparedStatement.setInt(2,roomID);
                if(preparedStatement.executeUpdate()>0) {
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

    public static boolean increaseRoomStock(int  roomID, int roomStock){
        String query="UPDATE room SET stock=? WHERE id = ?";

        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,roomStock+1);
            preparedStatement.setInt(2,roomID);
            if(preparedStatement.executeUpdate()>0) {
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



    public static Room match(ResultSet resultSet) throws SQLException {

        int id=resultSet.getInt("id");
        int hotelID=resultSet.getInt("hotelID");
        String hotelName=resultSet.getString("hotelName");
        int star=resultSet.getInt("star");
        String roomType=resultSet.getString("roomType");
        String pensionType=resultSet.getString("pensionType");
        Double pensionPrice=resultSet.getDouble("pensionPrice");
        int bedroomSet=resultSet.getInt("bedroomSet");
        int space=resultSet.getInt("space");
        int stock=resultSet.getInt("stock");
        String feature=resultSet.getString("feature");
        String region=resultSet.getString("region");
        String city=resultSet.getString("city");
        double priceForChild=resultSet.getDouble("priceForChild");
        double priceForAdult=resultSet.getDouble("priceForAdult");
        Date entryDate=resultSet.getDate("entryDate");
        Date releaseDate=resultSet.getDate("releaseDate");



        return new Room(id, hotelID, hotelName,star, roomType,pensionType,pensionPrice, bedroomSet, space,stock,feature,region,city,priceForChild,priceForAdult,entryDate,releaseDate);

    }




}
