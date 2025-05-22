package Model;

import Support.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class Reservation {



    private int id;
    private String nameSurname;
    private String   TC;
    private int roomID;
    private int hotelID;
    private String hotelName;
    private String contactPersonName;
    private String   contactTC;
    private String mail;
    private String phone;
    private String note;
    private Date entryDate;
    private Date releaseDate;
    private String region;
    private String city;
    private String roomType;
    private double price;


    public Reservation(int id,String   TC, String nameSurname, String   contactTC,String contactPersonName, String mail, String phone, String note,double price,Date entryDate, Date releaseDate, int roomID, int hotelID, String hotelName ,String  roomType, String region, String city) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.TC = TC;
        this.roomID = roomID;
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.contactPersonName = contactPersonName;
        this.contactTC = contactTC;
        this.mail = mail;
        this.phone = phone;
        this.note = note;
        this.entryDate = entryDate;
        this.releaseDate = releaseDate;
        this.region=region;
        this.city=city;
        this.roomType=roomType;
        this.price=price;


    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String   getTC() {
        return TC;
    }

    public void setTC(String   TC) {
        this.TC = TC;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String   getContactTC() {
        return contactTC;
    }

    public void setContactTC(String   contactTC) {
        this.contactTC = contactTC;
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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static boolean deleteByHotelID(int hotelID) {
        String query="DELETE FROM reservation WHERE hotelID = ?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, hotelID);
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

    public static boolean delete(int id) {
        String query="DELETE FROM reservation WHERE id = ?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
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


    public static ArrayList<Reservation> getReservations() {
        ArrayList<Reservation> reservations = new ArrayList<>();
        String query="SELECT * FROM reservation";

        try {
            Statement stmt= DBConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                reservations.add(match(rs));
            }
            rs.close();
            stmt.close();
            return reservations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Reservation getReservationByHotelID(int hotelID){
        String query="SELECET * FROM reservation WHERE hotelID = ?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, hotelID);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                return match(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Reservation getReservation(int id){
        String query="SELECT * FROM reservation WHERE id = ?";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                return match(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Reservation> search(String nameSurname, String hotelName,String note, String roomType, String region, String city) {

        ArrayList<Reservation> reservations = new ArrayList<>();

        String query="SELECT * FROM reservation WHERE nameSurname LIKE '%{{nameSurname}}%' AND hotelName LIKE '%{{hotelName}}%' AND note LIKE '%{{note}}%' ";

        //AND entryDate<=? AND releaseDate>=?

        query=query.replace("{{nameSurname}}",nameSurname);
        query=query.replace("{{hotelName}}",hotelName);
        query=query.replace("{{note}}",note);


        if (roomType!=null) {
            query+=" AND roomType = '"+roomType+"' ";
        }

        if (region!=null) {
            query+=" AND region = '"+region+"' ";
        }

        if (city!=null) {
            query+=" AND city = '"+city+"' ";
        }


        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            //preparedStatement.setString(1, entry);
            //preparedStatement.setString(2, release);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                reservations.add(match(rs));
            }
            rs.close();
            preparedStatement.close();
            return reservations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean add(String   TC, String nameSurname, String   contactTC,String contactPersonName, String mail, String phone, String note,double price,Date entryDate, Date releaseDate, int roomID, int hotelID, String hotelName ,String  roomType, String region, String city){

        String query="INSERT INTO reservation (TC ,nameSurname,contactTC ,contactPersonName,mail ,phone,note, price,entryDate,releaseDate ,roomID,hotelID, hotelName,roomType ,region, city) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, TC);
            preparedStatement.setString(2, nameSurname);
            preparedStatement.setString(3, contactTC);
            preparedStatement.setString(4, contactPersonName);
            preparedStatement.setString(5, mail);
            preparedStatement.setString(6, phone);
            preparedStatement.setString(7, note);
            preparedStatement.setDouble(8, price);
            preparedStatement.setDate(9, entryDate);
            preparedStatement.setDate(10, releaseDate);
            preparedStatement.setInt(11, roomID);
            preparedStatement.setInt(12, hotelID);
            preparedStatement.setString(13, hotelName);
            preparedStatement.setString(14, roomType);
            preparedStatement.setString(15, region);
            preparedStatement.setString(16, city);


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



    public static Reservation match (ResultSet resultSet) throws SQLException {

        int id=resultSet.getInt("id");
        String nameSurname=resultSet.getString("nameSurname");
        String  TC=resultSet.getString("TC");
        int roomID=resultSet.getInt("roomID");
        int hotelID=resultSet.getInt("hotelID");
        String hotelName=resultSet.getString("hotelName");
        String contactPersonName=resultSet.getString("contactPersonName");
        String contactTC=resultSet.getString( "contactTC");
        String mail=resultSet.getString("mail");
        String phone=resultSet.getString("phone");
        String note=resultSet.getString("note");
        Date entryDate=resultSet.getDate("entryDate");
        Date releaseDate=resultSet.getDate("releaseDate");
        String roomType=resultSet.getString("roomType");
        String region=resultSet.getString("region");
        String city=resultSet.getString("city");
        double price=resultSet.getDouble("price");

        return new Reservation(id, TC, nameSurname, contactTC, contactPersonName, mail, phone,note,price,entryDate, releaseDate, roomID ,hotelID, hotelName,roomType,region,city );




    }

}
