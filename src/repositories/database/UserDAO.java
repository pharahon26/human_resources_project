package repositories.database;


import models.User;

public class UserDAO {
    public static final String USER_TABLE = "users";

    public static String getSQLSchema(){
        /** Return the schema for the database **/
        return "CREATE TABLE IF NOT EXISTS "+USER_TABLE+" ("
                + " id integer PRIMARY KEY AUTOINCREMENT,"
                + " username text NOT NULL,"
                + " password text NOT NULL"
                + ");";
    }

    public static String insertUser(User user){
        /** Return the insert schema for the database **/
        return "INSERT INTO "+ USER_TABLE +"(username, password) VALUES ('"
                + user.getUsername() + "','"
                + user.getPassword() + "'"
                + ")";
    }

    public static String updateUser(User user){
        /** Return the insert schema for the database **/
        String sql = "UPDATE "+ USER_TABLE +" SET\n"
                + "username = '" + user.getUsername() + "',"
                + "password = '" + user.getPassword() + "'\n"
                + "WHERE id =" + user.getId()
                + ";";
        return  sql;
    }

    public static String deleteUser(int userId){
        /** Return the insert schema for the database **/
        String sql = "DELETE FROM "+USER_TABLE+" \n"
                + "WHERE id =" + userId
                + ";";
        return  sql;
    }

    public static String getUser(int userId){
        return  "SELECT * FROM "+USER_TABLE+" WHERE id = "+ userId;
    }

    public static String connectUser(String username){
        return  "SELECT * FROM "+USER_TABLE+" WHERE username = '"+ username +"'";
    }

    public static String getAllUser(){
        return  "SELECT * FROM " + USER_TABLE;
    }


}
