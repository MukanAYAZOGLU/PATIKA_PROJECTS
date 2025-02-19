package Model;

import Support.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {


    private int id;
    private String contentTitle;
    private String contentDescription;
    private String link;
    private String lessonName;
    private String educatorName;


    public Content(int id, String contentTitle, String contentDescription, String link, String lessonName, String educatorName) {
        this.id = id;
        this.contentTitle = contentTitle;
        this.contentDescription = contentDescription;
        this.link = link;
        this.lessonName = lessonName;
        this.educatorName = educatorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public static ArrayList<Content> getContents() {

        String query = "SELECT * FROM content";
        ArrayList<Content> contents = new ArrayList<Content>();
        Content obj;

        try {
            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String contentTitle = resultSet.getString("contentTitle");
                String contentDescription = resultSet.getString("contentDescription");
                String link = resultSet.getString("link");
                String lessonName = resultSet.getString("lessonName");
                String educatorName = resultSet.getString("educatorName");
                obj = new Content(id, contentTitle, contentDescription, link, lessonName, educatorName);
                contents.add(obj);
            }


            resultSet.close();
            statement.close();
            return contents;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Content> searchByQuery(String contentTitle, String lessonName) {

        String query = "SELECT * FROM content WHERE lessonName LIKE '%{{lessonName}}%' AND contentTitle LIKE '%{{contentTitle}}%'";

        query = query.replace("{{lessonName}}", lessonName);
        query = query.replace("{{contentTitle}}", contentTitle);

        ArrayList<Content> contents = new ArrayList<Content>();
        Content obj;

        try {
            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String contTitle = resultSet.getString("contentTitle");
                String contentDescription = resultSet.getString("contentDescription");
                String link = resultSet.getString("link");
                String lesName = resultSet.getString("lessonName");
                String educatorName = resultSet.getString("educatorName");
                obj = new Content(id, contTitle, contentDescription, link, lesName, educatorName);
                contents.add(obj);
            }

            resultSet.close();
            statement.close();
            return contents;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean addContent(String cTitle, String cDecription, String lInk, String lesName, String educatorName) {

        String query = "INSERT INTO content (contentTitle, contentDescription, link, lessonName, educatorName) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, cTitle);
            preparedStatement.setString(2, cDecription);
            preparedStatement.setString(3, lInk);
            preparedStatement.setString(4, lesName);
            preparedStatement.setString(5, educatorName);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            } else return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean deleteContent(int id) {
        String query = "DELETE FROM content WHERE id = ?";

        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            } else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteContent(String  educatorName) {
        String query = "DELETE FROM content WHERE educatorName = ?";

        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, educatorName);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            } else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(int id, String cTitle, String cDecription, String lInk, String lesName) {

        String query = "UPDATE content SET contentTitle=?, contentDescription=?, link=?, lessonName=? WHERE id=?";

        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, cTitle);
            preparedStatement.setString(2, cDecription);
            preparedStatement.setString(3, lInk);
            preparedStatement.setString(4, lesName);
            preparedStatement.setInt(5, id);
            if (preparedStatement.executeUpdate() > 0) {
                preparedStatement.close();
                return true;
            } else {
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean update(int id, String cTitle, String cDecription, String lInk, String lesName,String educatorName) {

        String query = "UPDATE content SET contentTitle=?, contentDescription=?, link=?, lessonName=?, educatorName=? WHERE id=?";

        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, cTitle);
            preparedStatement.setString(2, cDecription);
            preparedStatement.setString(3, lInk);
            preparedStatement.setString(4, lesName);
            preparedStatement.setString(5, educatorName);
            preparedStatement.setInt(6, id);
            if (preparedStatement.executeUpdate() > 0) {
                preparedStatement.close();
                return true;
            } else {
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static Content getFetcByID(int id) {
        String query = "SELECT * FROM content WHERE id=?";
        Content obj;

        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String contentTitle = resultSet.getString("contentTitle");
                String contentDescription = resultSet.getString("contentDescription");
                String link = resultSet.getString("link");
                String lessonName = resultSet.getString("lessonName");
                String educatorName = resultSet.getString("educatorName");
                obj = new Content(id, contentTitle, contentDescription, link, lessonName, educatorName);

                resultSet.close();
                preparedStatement.close();

                return obj;
            } else {

                resultSet.close();
                preparedStatement.close();

                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Content> getFetcByEducatorName(String  educatorName) {
        String query = "SELECT * FROM content WHERE educatorName=?";
        Content obj;

        ArrayList<Content> contents = new ArrayList<Content>();

        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, educatorName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String contentTitle = resultSet.getString("contentTitle");
                String contentDescription = resultSet.getString("contentDescription");
                String link = resultSet.getString("link");
                String lessonName = resultSet.getString("lessonName");
                String edutName = resultSet.getString("educatorName");
                obj = new Content(id, contentTitle, contentDescription, link, lessonName, edutName);
                contents.add(obj);


            }

            resultSet.close();
            preparedStatement.close();

            return contents;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Content getFetcByCTitle(String title) {
        String query = "SELECT * FROM content WHERE contentTitle = ?";
        Content obj;
        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String contentTitle = resultSet.getString("contentTitle");
                String contentDescription = resultSet.getString("contentDescription");
                String link = resultSet.getString("link");
                String lessonName = resultSet.getString("lessonName");
                String educatorName = resultSet.getString("educatorName");

                obj = new Content(id, contentTitle, contentDescription, link, lessonName, educatorName);

                resultSet.close();
                preparedStatement.close();
                return obj;

            } else {
                resultSet.close();
                preparedStatement.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Content getFetcByLessonName(String lessonName) {
        String query = "SELECT * FROM content WHERE lessonName = ?";
        Content obj;
        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, lessonName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String contentTitle = resultSet.getString("contentTitle");
                String contentDescription = resultSet.getString("contentDescription");
                String link = resultSet.getString("link");
                String lesName = resultSet.getString("lessonName");
                String educatorName = resultSet.getString("educatorName");

                obj = new Content(id, contentTitle, contentDescription, link, lesName, educatorName);

                resultSet.close();
                preparedStatement.close();
                return obj;

            } else {
                resultSet.close();
                preparedStatement.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getFetchByIDReturnCTitle(int id) {
        String query = "SELECT * FROM content WHERE id = ?";


        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                return resultSet.getString("contentTitle");

            } else return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean deleteByLessonName(String lessonName) {
        String query = "DELETE FROM content WHERE lessonName = ?";
        try {
            PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, lessonName);
            if (preparedStatement.executeUpdate() > 0) {
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






}