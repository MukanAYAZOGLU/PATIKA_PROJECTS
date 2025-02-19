package Model;

import Support.DBConnector;
import Support.Support;

import java.awt.image.DataBuffer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String  name;
    private String  userName;
    private String  password;
    private String  eposta;
    private String  userType;
    private String  language;


    public User(int id, String name, String userName, String password, String eposta, String userType, String language) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.eposta = eposta;
        this.userType = userType;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String geteposta() {
        return eposta;
    }

    public void seteposta(String eposta) {
        this.eposta = eposta;
    }

    public static ArrayList<User> getUsers() {

        ArrayList<User> users = new ArrayList<>();

        String query = "SELECT * FROM user";

        User obj;

        try {
            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String eposta = resultSet.getString("eposta");
                String userType = resultSet.getString("userType");
                String language = resultSet.getString("language");
                obj = new User(id, name, userName, password, eposta, userType, language);
                users.add(obj);

            }

            resultSet.close();
            statement.close();

            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean addUser(String name, String userName, String password, String eposta, String userType, String language) {

        String query = "INSERT INTO user (name,userName,password,eposta, userType,language) VALUES (?,?,?,?,?,?)";
        String searchQuery= "SELECT * FROM user";


        try {

            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(searchQuery);

            while (resultSet.next()) {

                if (resultSet.getString("userName").equals(userName)) {

                    Support.giveMessage("This user name already exists");
                    return false;
                }
            }



            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, eposta);
            preparedStatement.setString(5, userType);
            preparedStatement.setString(6, language);



            if(preparedStatement.executeUpdate()<0) {

                Support.giveMessage("hata");
                return false;


            } else {
                Support.giveMessage("başarı");
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean deleteUser(int id) {

        String query = "DELETE FROM user WHERE id=?";

        for(User user : getUsers() ) {

            if(user.getId()==id) {

                try {
                    PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
                    preparedStatement.setInt(1, id);

                    if(preparedStatement.executeUpdate()<0) {

                        return false;


                    } else {
                        return true;

                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


            }

        }

        return false;



    }

    public static boolean updateUser(int id, String name, String userName, String password, String eposta, String userType,String language){


        String query= "UPDATE user SET name=?, userName=?, password=?, eposta=?, userType=?, language=? WHERE id=?";


        User user=getFetchByUserName(userName);

        if (user!=null && user.getId()!=id) {

            Support.giveMessage("Kullanıcı mevcuttur !");

            return false;

        }else {

            if (!userType.equals("OPERATOR") && !userType.equals("EDUCATOR") && !userType.equals("STUDENT")) {

                Support.giveMessage("Tanımlanamayan kullanıcı tipi");

                return false;

            }else if (!language.equals("C") && !language.equals("C++") && !language.equals("C#") && !language.equals("JAVA") && !language.equals("JAVASCRIPT") && !language.equals("PYTHON") && !language.equals("KOTLIN") && !language.equals("HTML") && !language.equals("PHP") && !language.isEmpty()) {

                Support.giveMessage("Tanımlanamayan yazılım dili");

                return false;

            }

                else {

                try {
                    PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, userName);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, eposta);
                    preparedStatement.setString(5, userType);
                    preparedStatement.setString(6, language);
                    preparedStatement.setInt(7, id);

                    return preparedStatement.executeUpdate()>0;

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }




            }





        }


    }

    public static User getFetchByUserName(String userName) {

        String query= "SELECT * FROM user WHERE userName=?";
        User obj=null;

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, userName);


            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String eposta = resultSet.getString("eposta");
                String userType = resultSet.getString("userType");
                String language = resultSet.getString("language");
                obj = new User(id, name, userName, password,eposta, userType, language);

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

    public static boolean getFetchByID(int id) {



        for(User user : getUsers() ) {
            if(user.getId()==id) {
                return true;
            }

        }
        return false;


    }
    public static User getFetchByIDReturnEducator(int id) {

        String quert="SELECT * FROM user WHERE id=?";


        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(quert);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() && resultSet.getString("userType").equals("EDUCATOR")) {
                int ID  =resultSet.getInt("id");
                String name = resultSet.getString("name");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String eposta = resultSet.getString("eposta");
                String userType = resultSet.getString("userType");
                String language = resultSet.getString("language");
                return new User(ID, name, userName, password,eposta, userType, language);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;


    }


    public static String  searchByQuery(String name, String userName,String eposta,String type, String language){

        String query="SELECT * FROM user WHERE name LIKE '%{{name}}%' AND userName LIKE '%{{userName}}%' AND eposta LIKE '%{{eposta}}%'";

        query=query.replace("{{name}}", name);
        query=query.replace("{{userName}}", userName);
        query=query.replace("{{eposta}}", eposta);

        if (!type.isEmpty()) {

            query+="AND userType LIKE '%{{type}}%'";

            query=query.replace("{{type}}", type);
        }

        if (!language.isEmpty()) {
            query+="AND language LIKE '%{{language}}%'";
            query=query.replace("{{language}}", language);
        }


        return query;




    }

    public static boolean getFetchByEducatorName(String name) {

        String query="SELECT * FROM user WHERE name=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

            if (resultSet.getString("userType").equals("EDUCATOR")) {

                return true;

            }else return false;


            }
            else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static String getFetchByIDReturnEducatorName(int id) {
        String query="SELECT * FROM user WHERE id=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                if (resultSet.getString("userType").equals("EDUCATOR")) {
                    return resultSet.getString("name");
                } else return null;

            } return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getFetchByUserID(int userID) {
        String query="SELECT * FROM user WHERE id=?";
        User obj=null;
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String eposta=resultSet.getString("eposta");
                String userType = resultSet.getString("userType");
                String language = resultSet.getString("language");
                obj = new User(id, name, userName, password, eposta, userType, language);
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

    public static User getFetchByUserNameAndPassword(String name, String password) {

        User obj=null;
        String query="SELECT * FROM user WHERE userName=? AND password=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String uName = resultSet.getString("name");
                String userName=resultSet.getString("userName");
                String uPassword=resultSet.getString("password");
                String eposta=resultSet.getString("eposta");
                String userType=resultSet.getString("userType");
                String language=resultSet.getString("language");
                obj = new User(id, uName, userName, uPassword, eposta, userType, language);
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

    public static User getFetchByEPostaAndPassword(String eposta, String password) {

            User obj=null;

            String query="SELECT * FROM user WHERE eposta=? AND password=?";

        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, eposta);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String uName = resultSet.getString("name");
                String userName=resultSet.getString("userName");
                String uPassword=resultSet.getString("password");
                String posta=resultSet.getString("eposta");
                String userType=resultSet.getString("userType");
                String language=resultSet.getString("language");
                obj = new User(id, uName, userName, uPassword, posta, userType, language);
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

    public static int getFetchByNameReturnID(String name) {
        String query="SELECT * FROM user WHERE name=?";
        try {
            PreparedStatement preparedStatement=DBConnector.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                resultSet.close();
                preparedStatement.close();
                return id;
            }else {
                resultSet.close();
                preparedStatement.close();
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
