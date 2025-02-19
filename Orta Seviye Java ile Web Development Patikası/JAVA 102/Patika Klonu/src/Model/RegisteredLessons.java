package Model;

import Support.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RegisteredLessons {


    private int id;
    private String  lessonName;
    private String  studentName;


    public RegisteredLessons(int id, String studentName, String lessonName) {
        this.id = id;
        this.lessonName = lessonName;
        this.studentName = studentName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }



    public static ArrayList<RegisteredLessons> getRegisteredLessons() {

        String query = "SELECT * FROM registeredLessons";
        ArrayList<RegisteredLessons> registeredLessons = new ArrayList<>();
        RegisteredLessons registeredLesson = null;

        try {
            Statement stat = DBConnector.getConnection().createStatement();
            ResultSet resultSet = stat.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String studentName = resultSet.getString("studentName");
                String lessonName = resultSet.getString("lessonName");
                registeredLesson = new RegisteredLessons(id,studentName, lessonName);
                registeredLessons.add(registeredLesson);
            }

            resultSet.close();
            stat.close();
            return registeredLessons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean add(String studentName, String lessonName) {
        String query="INSERT INTO registeredLessons (studentName,lessonName) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, studentName);
            preparedStatement.setString(2, lessonName);
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

    public static boolean delete(String lessonaName){

        String query="DELETE FROM registeredLessons WHERE lessonName=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, lessonaName);
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

    public static RegisteredLessons getFetchByLessonName(User user){
        String query="SELECT * FROM registeredLessons WHERE studentName=? ";
        RegisteredLessons registeredLesson=null;

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                int id=resultSet.getInt("id");
                String stName = resultSet.getString("studentName");
                String lesName = resultSet.getString("lessonName");
                registeredLesson = new RegisteredLessons(id,stName, lesName);
                resultSet.close();
                preparedStatement.close();
                return registeredLesson;

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
