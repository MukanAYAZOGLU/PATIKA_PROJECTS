package Model;

import Support.DBConnector;
import Support.Support;
import View.OperatorGUI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {

    private int id;
    private String name;
    private String language;


    public Patika(int id, String name, String language) {
        this.id = id;
        this.name = name;
        this.language = language;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public static ArrayList<Patika> getPatikaList(){
        ArrayList<Patika> patikaList = new ArrayList<>();

        String query = "SELECT * FROM patika";

        Patika patika;

        try {
            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String language = resultSet.getString("language");
                patika = new Patika(id, name, language);
                patikaList.add(patika);

            }

            resultSet.close();
            statement.close();
            return patikaList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public static boolean addPatika(String patika, String language) {

        String query="INSERT INTO patika (name, language) VALUES (?,?)";



        try {

            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);



            preparedStatement.setString(1, patika);
            preparedStatement.setString(2, language);


            if (preparedStatement.executeUpdate() <0) {

                preparedStatement.close();
                return false;

            } else {
                preparedStatement.close();
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean getFetchByName(String name) {

        for(Patika patika  : getPatikaList()) {

            if (patika.getName().equals(name)) {
                return true;
            }

        }

        return false;



    }

    public static boolean deletePatika(String  name) {

        String query="DELETE FROM patika WHERE name=?";


        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);

            if (preparedStatement.executeUpdate() <0) {
                preparedStatement.close();
                return false;
            }
            else {
                preparedStatement.close();
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static String  searchPatika(String name, String language) {

        String query="SELECT * FROM patika WHERE name LIKE '%{{name}}%'";

            query=query.replace("{{name}}", name);


        if (!language.isEmpty()) {
            query+="AND language='"+language+"'";
        }


        return query;



    }

    public static ArrayList<Patika> searchPatikaByQuery(String query) {

        ArrayList<Patika> patikaList = new ArrayList<>();


        try {
            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String language = resultSet.getString("language");

                patikaList.add(new Patika(id, name, language));
            }


            resultSet.close();
            statement.close();
            return patikaList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static Patika getFetchByPatikaName(String name) {

        for(Patika patika : getPatikaList()) {
            if (patika.getName().equals(name)) {
                return patika;
            }
        }
        return null;
    }

    public static boolean updatePatika(int id, String name, String language) {
        String query="UPDATE patika SET name=?, language=? WHERE id=?";



        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, language);
            preparedStatement.setInt(3, id);
            if (preparedStatement.executeUpdate() <0) {
                preparedStatement.close();
                return false;
            }else {
                preparedStatement.close();
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deletePatikaByID(int id) {
        String query="DELETE FROM patika WHERE id=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() <0) {
                preparedStatement.close();
                return false;
            }else {
                preparedStatement.close();
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFetchByIDReturnPatikaName(int id) {


        for(Patika patika : getPatikaList()) {

            if (patika.getId() == id) {
                return patika.getName();
            }
        } return null;
    }


}
