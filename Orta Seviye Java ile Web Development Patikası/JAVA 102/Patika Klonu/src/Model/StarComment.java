package Model;

import Support.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StarComment {


    private int id;
    private String studentName;
    private String contentTitle;
    private String lessonName;
    private int stars;
    private String comment;


    public StarComment(int id, String studentName, String contentTitle, String lessonName, int stars, String comment) {
        this.id = id;
        this.studentName = studentName;
        this.contentTitle = contentTitle;
        this.lessonName = lessonName;
        this.stars = stars;
        this.comment = comment;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }




    public static boolean add (String studentName, String contentTitle, String lessonName, int stars, String comment){

        String query="INSERT INTO starComment  (studentName, contentTitle, lessonName, stars, comment) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement= DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, studentName);
            preparedStatement.setString(2, contentTitle);
            preparedStatement.setString(3, lessonName);
            preparedStatement.setInt(4, stars);
            preparedStatement.setString(5, comment);
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

    public static boolean getFetch(String  studentName, String contentTitle){

        String query="SELECT * FROM starComment WHERE studentName=? AND contentTitle=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, studentName);
            preparedStatement.setString(2, contentTitle);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                resultSet.close();
                preparedStatement.close();
                return true;
            }else {
                resultSet.close();
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
