package Model;

import Support.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Quiz {


    private int id;
    private int questionID;
    private String trueAnswer;
    private String reply;
    private int studentID;

    public Quiz(int id, int questionID, String trueAnswer, String reply, int studentID) {
        this.id = id;
        this.questionID = questionID;
        this.trueAnswer = trueAnswer;
        this.reply = reply;
        this.studentID = studentID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int question) {
        this.questionID = question;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentName(int studentName) {
        this.studentID = studentID;
    }

    public static boolean add(int questionID, String trueAnswer, String reply, int studentID) {
        String query="INSERT INTO quiz (questionID, trueAnswer, reply, studentID) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement= DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,questionID);
            preparedStatement.setString(2,trueAnswer);
            preparedStatement.setString(3,reply);
            preparedStatement.setInt(4,studentID);
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

    public static ArrayList<Quiz> getAllQuiz() {
        String query="SELECT * FROM quiz";
        ArrayList<Quiz> quiz = new ArrayList<>();
        Quiz qu=null;

        try {
            Statement statement=DBConnector.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                int questionID=resultSet.getInt("questionID");
                String trueAnswer=resultSet.getString("trueAnswer");
                String reply=resultSet.getString("reply");
                int studentID=resultSet.getInt("studentID");
                qu=new Quiz(id, questionID, trueAnswer, reply, studentID);
                quiz.add(qu);
            }
            resultSet.close();
            statement.close();
            return quiz;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(int id, String reply) {
        String query="UPDATE quiz SET reply=? WHERE id=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1,reply);
            preparedStatement.setInt(2,id);
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

    public static ArrayList<Quiz> getFetchByStudentID(int id) {

        String query="SELECT * FROM quiz WHERE studentID=?";

        ArrayList<Quiz> quiz = new ArrayList<>();

        Quiz qu;

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int mainID = resultSet.getInt("id");
                int questionID = resultSet.getInt("questionID");
                String trueAnswer = resultSet.getString("trueAnswer");
                String reply = resultSet.getString("reply");
                int studentID = resultSet.getInt("studentID");
                qu = new Quiz(mainID, questionID, trueAnswer, reply, studentID);

                quiz.add(qu);


            }
            resultSet.close();
            preparedStatement.close();
            return quiz;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
