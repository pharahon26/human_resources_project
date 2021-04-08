package repositories.database;


import models.User;

public class UserDAO {

    public static String getSQLSchema(){
        /** Return the schema for the database **/
        return "CREATE TABLE IF NOT EXISTS users (\n"
                + " id integer PRIMARY KEY,\n"
                + " username text NOT NULL,\n"
                + " password text NOT NULL\n"
                + ");";
    }

    public static String insertUser(User user){
        /** Return the insert schema for the database **/
        String sql = "INSERT INTO users(id, username, password) VALUES("
                + user.getId() + ","
                + user.getUsername() + ","
                + user.getPassword() + ""
                + ")";
        return  sql;
    }

    public static String updateUser(User user){
        /** Return the insert schema for the database **/
        String sql = "UPDATE users SET\n"
                + "id = " + user.getId() + ","
                + "username = " + user.getId() + ","
                + "password = " + user.getId() + "\n"
                + "WHERE id =" + user.getId()
                + ";";
        return  sql;
    }

    public static String deleteUser(int userId){
        /** Return the insert schema for the database **/
        String sql = "DELETE FROM users \n"
                + "WHERE id =" + userId
                + ";";
        return  sql;
    }

    public static String getUser(int userId){
        return  "SELECT * FROM users WHERE id = "+ userId;
    }
}
