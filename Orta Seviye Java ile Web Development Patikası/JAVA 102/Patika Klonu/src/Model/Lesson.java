package Model;

import Support.DBConnector;
import Support.Support;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Lesson {

private int lessonID;
private String lessonName;
private String educatorName;
private String patikaName;
private String language;


    public Lesson(int lessonID, String lessonName,  String educatorName, String patikaName, String language) {
        this.lessonID = lessonID;
        this.lessonName = lessonName;
        this.educatorName = educatorName;
        this.patikaName = patikaName;
        this.language = language;
    }


    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getEducatorName() {
        return educatorName;
    }

    public void setEducatorName(String educatorName) {
        this.educatorName = educatorName;
    }

    public String getPatikaName() {
        return patikaName;
    }

    public void setPatikaName(String patikaName) {
        this.patikaName = patikaName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public static ArrayList<Lesson> getLessons() {
        ArrayList<Lesson> lessons = new ArrayList<>();

        String query = "SELECT * FROM lesson";

        Lesson obj;

        try {
            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int lessonID = resultSet.getInt("lessonID");
                String lessonName = resultSet.getString("lessonName");
                String educatorName = resultSet.getString("educatorName");
                String patikaName = resultSet.getString("patikaName");
                String language = resultSet.getString("language");
                obj=new Lesson(lessonID, lessonName, educatorName, patikaName, language);
                lessons.add(obj);
            }

            resultSet.close();
            statement.close();
            return lessons;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static ArrayList<Lesson> getLessonsByPatikaName(String patikaName) {
        ArrayList<Lesson> lessons = new ArrayList<>();

        String query = "SELECT * FROM lesson WHERE patikaName = ?";

        Lesson obj;

        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, patikaName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int lessonID = resultSet.getInt("lessonID");
                String lessonName = resultSet.getString("lessonName");
                String educatorName = resultSet.getString("educatorName");
                String patName = resultSet.getString("patikaName");
                String language = resultSet.getString("language");
                obj=new Lesson(lessonID, lessonName, educatorName, patName, language);
                lessons.add(obj);
            }

            resultSet.close();
            preparedStatement.close();
            return lessons;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean addLesson(String lessonName, String educatorName, String patikaName, String language) {

        String query="INSERT INTO lesson (lessonName, educatorName,patikaName,language) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);

            preparedStatement.setString(1,lessonName);
            preparedStatement.setString(2,educatorName);
            preparedStatement.setString(3,patikaName);
            preparedStatement.setString(4,language);


            if(preparedStatement.executeUpdate()<0) {

                return false;
            } else {
                preparedStatement.close();

                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Lesson> searchByQuery(String lessonName, String language) {
    String query="SELECT * FROM lesson WHERE lessonName LIKE '%{{lessonName}}%' AND language LIKE '%{{language}}%' ";

        query=query.replace("{{lessonName}}",lessonName);
        query=query.replace("{{language}}",language);


        ArrayList<Lesson> lessons=new ArrayList<>();
        Lesson obj;

        try {
            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("lessonID");
                String name = resultSet.getString("lessonName");
                String educatorName = resultSet.getString("educatorName");
                String patikaName = resultSet.getString("patikaName");
                String lang=resultSet.getString("language");
                obj=new Lesson(id, name, educatorName, patikaName, lang);
                lessons.add(obj);


            }
            resultSet.close();
            statement.close();
            return lessons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    public static ArrayList<Lesson> getLessonsByQuery(String query) {

        ArrayList<Lesson> lessons = new ArrayList<>();

        try {
            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int lessonID = resultSet.getInt("lessonID");
                String lessonName = resultSet.getString("lessonName");
                String educatorName = resultSet.getString("educatorName");
                String patikaName = resultSet.getString("patikaName");
                String language = resultSet.getString("language");
                lessons.add(new Lesson(lessonID,lessonName,educatorName,patikaName,language));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return lessons;

    }

    public static boolean getFetchByLessonName(String lessonName) {

        String query="SELECT * FROM lesson WHERE lessonName=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1,lessonName);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteLesson(int lessonID) {
        String query="DELETE FROM lesson WHERE lessonID=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,lessonID);
            if(preparedStatement.executeUpdate()<0) {
                return false;
            }else return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean deleteByEducatorName(String name) {
        String query="DELETE FROM lesson WHERE educatorName=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1,name);
            if(preparedStatement.executeUpdate()<0) {
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

    public static boolean deleteByPatikaName(String name) {

        String query="DELETE FROM lesson WHERE patikaName=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1,name);
            if(preparedStatement.executeUpdate()<0) {
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

    public static boolean getFetchByLessonID(int lessonID) {

        String query="SELECT * FROM lesson WHERE lessonID=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,lessonID);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Lesson getFetchByIDReturnLesson(int lessonID) {
        String query="SELECT * FROM lesson WHERE lessonID=?";

        Lesson obj;

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,lessonID);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {

                int id=resultSet.getInt("lessonID");
                String lessonName = resultSet.getString("lessonName");
                String educatorName = resultSet.getString("educatorName");
                String patikaName = resultSet.getString("patikaName");
                String language = resultSet.getString("language");
                obj=new Lesson(id,lessonName,educatorName,patikaName,language);
                return obj;

            } return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Lesson getFetchByName(String lessonName){
        String query="SELECT * FROM lesson WHERE lessonName=?";
        Lesson obj;
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1,lessonName);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id=resultSet.getInt("lessonID");
                String lessName=resultSet.getString("lessonName");
                String educatorName=resultSet.getString("educatorName");
                String patikaName=resultSet.getString("patikaName");
                String language=resultSet.getString("language");
                obj=new Lesson(id,lessName,educatorName,patikaName,language);
                resultSet.close();
                preparedStatement.close();
                return obj;

            }else {
                resultSet.close();
                preparedStatement.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean updateLesson(int id,String lessonName, String educatorName, String patikaName, String language) {

        String query="UPDATE lesson SET lessonName=?, educatorName=?, patikaName=?, language=? WHERE lessonID=?";
        
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1,lessonName);
            preparedStatement.setString(2,educatorName);
            preparedStatement.setString(3,patikaName);
            preparedStatement.setString(4,language);
            preparedStatement.setInt(5,id);
            if(preparedStatement.executeUpdate()<0) {
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

    public static boolean delete(String lessonName) {
        String query="DELETE FROM lesson WHERE lessonName=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1,lessonName);
            if(preparedStatement.executeUpdate()<0) {
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

    public static Lesson getFetchByPatikaName(String patikaName){
        String query="SELECT * FROM lesson WHERE patikaName=?";
        Lesson obj;
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1,patikaName);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id=resultSet.getInt("lessonID");
                String lessName=resultSet.getString("lessonName");
                String educatorName=resultSet.getString("educatorName");
                String patName=resultSet.getString("patikaName");
                String language=resultSet.getString("language");
                obj=new Lesson(id,lessName,educatorName,patName,language);
                resultSet.close();
                preparedStatement.close();
                return obj;

            }else {
                resultSet.close();
                preparedStatement.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Lesson getFetchByEducatorName(String educatorName){
        String query="SELECT * FROM lesson WHERE educatorName=?";
        Lesson obj;
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1,educatorName);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id=resultSet.getInt("lessonID");
                String lessName=resultSet.getString("lessonName");
                String educName=resultSet.getString("educatorName");
                String patName=resultSet.getString("patikaName");
                String language=resultSet.getString("language");
                obj=new Lesson(id,lessName,educName,patName,language);
                resultSet.close();
                preparedStatement.close();
                return obj;

            }else {
                resultSet.close();
                preparedStatement.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }











}
