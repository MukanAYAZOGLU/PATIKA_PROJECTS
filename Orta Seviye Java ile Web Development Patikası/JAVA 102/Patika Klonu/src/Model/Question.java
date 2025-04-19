package Model;

import Support.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Question {



    private int id;
    private String  question;
    private String  optionA;
    private String  optionB;
    private String  optionC;
    private String  optionD;
    private String  trueAnswer;
    private String  contentTitle;
    private String  lessonName;
    private String  educatorName;


    public Question(int id, String question, String optionA, String optionB, String optionC, String optionD, String trueAnswer, String contentTitle, String lessonName, String  educatorName) {
        this.id = id;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.trueAnswer = trueAnswer;
        this.contentTitle = contentTitle;
        this.lessonName = lessonName;
        this.educatorName = educatorName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
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
        lessonName = lessonName;
    }

    public String getEducatorName() {
        return educatorName;
    }

    public void setEducatorName(String educatorName) {
        this.educatorName = educatorName;
    }

    public static ArrayList<Question> getQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        String query="SELECT * FROM question";
        Question obj;
        try {
            Statement statement= DBConnector.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String question=resultSet.getString("question");
                String optionA=resultSet.getString("optionA");
                String optionB=resultSet.getString("optionB");
                String optionC=resultSet.getString("optionC");
                String optionD=resultSet.getString("optionD");
                String trueAnswer=resultSet.getString("trueAnswer");
                String contentTitle=resultSet.getString("contentTitle");
                String lessonName=resultSet.getString("lessonName");
                String educatorName=resultSet.getString("educatorName");

                obj=new Question(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,lessonName,educatorName);
                questions.add(obj);

            }
            resultSet.close();
            statement.close();
            return questions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Question getFetchBYID(int id){

        Question obj=null;
        String query="SELECT * FROM question WHERE id=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {

                String  question=resultSet.getString("question");
                String  optionA=resultSet.getString("optionA");
                String  optionB=resultSet.getString("optionB");
                String  optionC=resultSet.getString("optionC");
                String  optionD=resultSet.getString("optionD");
                String  trueAnswer=resultSet.getString("trueAnswer");
                String  contentTitle=resultSet.getString("contentTitle");
                String  LessonName=resultSet.getString("LessonName");
                String educatorName=resultSet.getString("educatorName");

                obj=new Question(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,LessonName,educatorName);

                resultSet.close();
                preparedStatement.close();
                return obj;

            }else{
                resultSet.close();
                preparedStatement.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static Question getFetchBYQUestion(String  ques){

        Question obj=null;
        String query="SELECT * FROM question WHERE question=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, ques);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id=resultSet.getInt("id");
                String  question=resultSet.getString("question");
                String  optionA=resultSet.getString("optionA");
                String  optionB=resultSet.getString("optionB");
                String  optionC=resultSet.getString("optionC");
                String  optionD=resultSet.getString("optionD");
                String  trueAnswer=resultSet.getString("trueAnswer");
                String  contentTitle=resultSet.getString("contentTitle");
                String  LessonName=resultSet.getString("LessonName");
                String educatorName=resultSet.getString("educatorName");

                obj=new Question(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,LessonName,educatorName);

                resultSet.close();
                preparedStatement.close();
                return obj;

            }else{
                resultSet.close();
                preparedStatement.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static Question getFetchBYContentTitle(String  contentTitle){

        Question obj=null;
        String query="SELECT * FROM question WHERE contentTitle=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, contentTitle);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id=resultSet.getInt("id");
                String  question=resultSet.getString("question");
                String  optionA=resultSet.getString("optionA");
                String  optionB=resultSet.getString("optionB");
                String  optionC=resultSet.getString("optionC");
                String  optionD=resultSet.getString("optionD");
                String  trueAnswer=resultSet.getString("trueAnswer");
                String  contTitle=resultSet.getString("contentTitle");
                String  LessonName=resultSet.getString("LessonName");
                String educatorName=resultSet.getString("educatorName");

                obj=new Question(id,question,optionA,optionB,optionC,optionD,trueAnswer,contTitle,LessonName,educatorName);

                resultSet.close();
                preparedStatement.close();
                return obj;

            }else{
                resultSet.close();
                preparedStatement.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static ArrayList<Question> searchByQuestion(String question) {
        ArrayList<Question> questions = new ArrayList<>();
        Question obj;
        String query="SELECT * FROM question WHERE question LIKE  '%{{question}}%'";

        query=query.replace("{{question}}", question);


        try {
            Statement statement= DBConnector.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String ques=resultSet.getString("question");
                String optionA=resultSet.getString("optionA");
                String optionB=resultSet.getString("optionB");
                String optionC=resultSet.getString("optionC");
                String optionD=resultSet.getString("optionD");
                String trueAnswer=resultSet.getString("trueAnswer");
                String contentTitle=resultSet.getString("contentTitle");
                String lessonName=resultSet.getString("lessonName");
                String educatorName=resultSet.getString("educatorName");

                obj=new Question(id,ques,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,lessonName,educatorName);
                questions.add(obj);
            }
            resultSet.close();
            statement.close();
            return questions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean addQuestion(String question, String optionA, String optionB, String optionC, String optionD, String trueAnswer, String contentTitle, String lessonName,String educatorName) {

        String query="INSERT INTO question (question, optionA,  optionB, optionC,  optionD, trueAnswer, contentTitle, lessonName, educatorName) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, optionA);
            preparedStatement.setString(3, optionB);
            preparedStatement.setString(4, optionC);
            preparedStatement.setString(5, optionD);
            preparedStatement.setString(6, trueAnswer);
            preparedStatement.setString(7, contentTitle);
            preparedStatement.setString(8, lessonName);
            preparedStatement.setString(9,educatorName);
            if (preparedStatement.executeUpdate()>0) {
                return true;
            }else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean delete(int id){
        String query = "DELETE FROM question WHERE id=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
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

    public static boolean delete(String educatorName){
        String query = "DELETE FROM question WHERE educatorName=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, educatorName);
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

    public static boolean deleteByContentTİtle(String contentTitle){
        String query = "DELETE FROM question WHERE contentTitle=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, contentTitle);
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


    public static boolean delete(String contentTitle, String lessonName) {
        String query="DELETE FROM question WHERE contentTitle=? AND lessonName=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, contentTitle);
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

    public static boolean update(int id, String question, String optionA, String optionB, String optionC, String optionD, String trueAnswer, String contentTitle, String lessonName, String educatorName) {

        String query="UPDATE question SET question=?, optionA=?, optionB=?, optionC=?, optionD=?, trueAnswer=?, contentTitle=?, lessonName=?, educatorName=? WHERE id=?";


                try {
                    PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
                    preparedStatement.setString(1, question);
                    preparedStatement.setString(2, optionA);
                    preparedStatement.setString(3, optionB);
                    preparedStatement.setString(4, optionC);
                    preparedStatement.setString(5, optionD);
                    preparedStatement.setString(6, trueAnswer);
                    preparedStatement.setString(7, contentTitle);
                    preparedStatement.setString(8, lessonName);
                    preparedStatement.setString(9, educatorName);
                    preparedStatement.setInt(10, id);
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

    public static ArrayList<Question> search(String lessonName, String  contentTitle){

        Question obj=null;
        String query="SELECT * FROM question WHERE lessonName=? AND contentTitle=?";

        ArrayList<Question> questions=new ArrayList<Question>();

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, lessonName);
            preparedStatement.setString(2, contentTitle);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id=resultSet.getInt("id");
                String  ques=resultSet.getString("question");
                String  optionA=resultSet.getString("optionA");
                String  optionB=resultSet.getString("optionB");
                String  optionC=resultSet.getString("optionC");
                String  optionD=resultSet.getString("optionD");
                String  trueAnswer=resultSet.getString("trueAnswer");
                String  contTitle=resultSet.getString("contentTitle");
                String  LessonName=resultSet.getString("LessonName");
                String educatorName=resultSet.getString("educatorName");

                obj=new Question(id,ques,optionA,optionB,optionC,optionD,trueAnswer,contTitle,LessonName,educatorName);
                questions.add(obj);

            }

            resultSet.close();
            preparedStatement.close();
            return questions;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static ArrayList<Question> searchLike(String question, String contentTitle,String lessonName){
        Question obj=null;
        ArrayList<Question> questions=new ArrayList<Question>();

        String query="SELECT * FROM question WHERE question LIKE '%{{question}}%' AND contentTitle LIKE '%{{contentTitle}}%' AND lessonName LIKE '%{{lessonName}}%'";


        query=query.replace("{{question}}",question);
        query=query.replace("{{lessonName}}",lessonName);
        query=query.replace("{{contentTitle}}",contentTitle);





        try {
            Statement statement=DBConnector.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String  ques=resultSet.getString("question");
                String  optionA=resultSet.getString("optionA");
                String  optionB=resultSet.getString("optionB");
                String  optionC=resultSet.getString("optionC");
                String  optionD=resultSet.getString("optionD");
                String  trueAnswer=resultSet.getString("trueAnswer");
                String  contTitle=resultSet.getString("contentTitle");
                String  LessonName=resultSet.getString("LessonName");
                String educatorName=resultSet.getString("educatorName");

                obj=new Question(id,ques,optionA,optionB,optionC,optionD,trueAnswer,contTitle,LessonName,educatorName);
                questions.add(obj);
            }
            resultSet.close();
            statement.close();
            return questions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean deleteByLessonName(String lessonName){
        String query="DELETE FROM question WHERE lessonName=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, lessonName);
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

    public static boolean deleteByContentTitle(String contentTitle){
        String query="DELETE FROM question WHERE contentTitle=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, contentTitle);
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

    public static Question getFetchBYLessonName(String  lesName){

        Question obj=null;
        String query="SELECT * FROM question WHERE lessonName=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, lesName);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id=resultSet.getInt("id");
                String  question=resultSet.getString("question");
                String  optionA=resultSet.getString("optionA");
                String  optionB=resultSet.getString("optionB");
                String  optionC=resultSet.getString("optionC");
                String  optionD=resultSet.getString("optionD");
                String  trueAnswer=resultSet.getString("trueAnswer");
                String  contentTitle=resultSet.getString("contentTitle");
                String  LessonName=resultSet.getString("LessonName");
                String educatorName=resultSet.getString("educatorName");

                obj=new Question(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,LessonName,educatorName);

                resultSet.close();
                preparedStatement.close();
                return obj;

            }else{
                resultSet.close();
                preparedStatement.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }






}
