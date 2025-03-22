package Model;

import Support.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Price {


    private int id;
    private int hotelID;
    private double ultraAll;
    private double allThings;
    private double roomBreakfast;
    private double fullBoard;
    private double halfBoard;
    private double onlyBed;
    private double FullCreditExcpAlcohol;



    public Price(int id, int hotelID,double ultraAll, double allThings, double roomBreakfast, double fullBoard, double halfBoard, double onlyBed, double fullCreditExcpAlcohol) {
        this.id = id;
        this.hotelID = hotelID;
        this.ultraAll = ultraAll;
        this.allThings = allThings;
        this.roomBreakfast = roomBreakfast;
        this.fullBoard = fullBoard;
        this.halfBoard = halfBoard;
        this.onlyBed = onlyBed;
        FullCreditExcpAlcohol = fullCreditExcpAlcohol;

    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUltraAll() {
        return ultraAll;
    }

    public void setUltraAll(double ultraAll) {
        this.ultraAll = ultraAll;
    }

    public double getAllThings() {
        return allThings;
    }

    public void setAllThings(double allThings) {
        this.allThings = allThings;
    }

    public double getRoomBreakfast() {
        return roomBreakfast;
    }

    public void setRoomBreakfast(double roomBreakfast) {
        this.roomBreakfast = roomBreakfast;
    }

    public double getFullBoard() {
        return fullBoard;
    }

    public void setFullBoard(double fullBoard) {
        this.fullBoard = fullBoard;
    }

    public double getHalfBoard() {
        return halfBoard;
    }

    public void setHalfBoard(double halfBoard) {
        this.halfBoard = halfBoard;
    }

    public double getOnlyBed() {
        return onlyBed;
    }

    public void setOnlyBed(double onlyBed) {
        this.onlyBed = onlyBed;
    }

    public double getFullCreditExcpAlcohol() {
        return FullCreditExcpAlcohol;
    }

    public void setFullCreditExcpAlcohol(double fullCreditExcpAlcohol) {
        FullCreditExcpAlcohol = fullCreditExcpAlcohol;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public static ArrayList<Price> getPrices() {
        ArrayList<Price> prices = new ArrayList<>();
        String query="SELECT * FROM price";
        try {
            Statement statement= DBConnection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query);

            while (resultSet.next()) {

                prices.add(match(resultSet));

            }
            resultSet.close();
            statement.close();
            return prices;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Price getPrice(int hotelID) {
        String query="SELECT * FROM price WHERE hotelID=?";

        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, hotelID);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                return match(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean add(int hotelID, double ultraAll, double allThings, double roomBreakfast, double fullBoard, double halfBoard, double onlyBed, double fullCreditExcpAlcohol){

        String query="INSERT INTO price (hotelID,ultraAll, allThings, roomBreakfast, fullBoard, halfBoard, onlyBed, fullCreditExcpAlcohol) VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, hotelID);
            preparedStatement.setDouble(2, ultraAll);
            preparedStatement.setDouble(3, allThings);
            preparedStatement.setDouble(4, roomBreakfast);
            preparedStatement.setDouble(5, fullBoard);
            preparedStatement.setDouble(6, halfBoard);
            preparedStatement.setDouble(7, onlyBed);
            preparedStatement.setDouble(8, fullCreditExcpAlcohol);
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


    public static boolean update(int hotelID, double ultraAll, double allThings, double roomBreakfast, double fullBoard, double halfBoard, double onlyBed, double fullCreditExcpAlcohol) {

        String query="UPDATE price SET ultraAll=?, allThings=?, roomBreakfast=?, fullBoard=?, halfBoard=?, onlyBed=?, fullCreditExcpAlcohol=? WHERE hotelID=?";

        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setDouble(1, ultraAll);
            preparedStatement.setDouble(2, allThings);
            preparedStatement.setDouble(3, roomBreakfast);
            preparedStatement.setDouble(4, fullBoard);
            preparedStatement.setDouble(5, halfBoard);
            preparedStatement.setDouble(6, onlyBed);
            preparedStatement.setDouble(7, fullCreditExcpAlcohol);
            preparedStatement.setInt(8, hotelID);
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




    public static Price match(ResultSet resultSet) throws SQLException {

        int id=resultSet.getInt("id");
        int hotelID=resultSet.getInt("hotelID");
        double ultraAll=resultSet.getDouble("ultraAll");
        double allThings=resultSet.getDouble("allThings");
        double roomBreakfast=resultSet.getDouble("roomBreakfast");
        double fullBoard=resultSet.getDouble("fullBoard");
        double halfBoard=resultSet.getDouble("halfBoard");
        double onlyBed=resultSet.getDouble("onlyBed");
        double fullCreditExcpAlcohol=resultSet.getDouble("fullCreditExcpAlcohol");



        return new Price(id, hotelID, ultraAll, allThings, roomBreakfast, fullBoard, halfBoard, onlyBed, fullCreditExcpAlcohol);

    }


}
