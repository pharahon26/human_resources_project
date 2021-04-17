package repositories.database;

import models.Poste;

public class PosteDAO {
    public static final String POSTE_TABLE = "postes";

    public static String getSQLSchema(){
        /** Return the schema for the database **/
        return "CREATE TABLE IF NOT EXISTS "+POSTE_TABLE+" (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " title text NOT NULL,\n"
                + " salary real,\n"
                + " work_time_hours_by_day integer  NOT NULL,\n"
                + " up_poste_id integer,\n"
                + " down_poste_id integer,\n"
                + " FOREIGN KEY (up_poste_id) REFERENCES postes (id), \n"
                + " FOREIGN KEY (down_poste_id) REFERENCES postes (id) \n"
                + ");";
    }

    public static String insertPoste(Poste poste){
        /** Return the insert schema for the database **/
        String sql = "INSERT INTO "+POSTE_TABLE+"(up_poste_id, down_poste_id, title, salary, work_time_hours_by_day) VALUES ("
                + poste.getUpPosteId() + ","
                + poste.getDownPosteId() + ",'"
                + poste.getTitle() + "',"
                + poste.getSalary() + ","
                + poste.getWorkTimeHoursByDay()
                + ");";
        return  sql;
    }

    public static String updatePoste(Poste poste){
        /** Return the insert schema for the database **/
        String sql = "UPDATE "+POSTE_TABLE+" SET\n"
                + "up_poste_id = " + poste.getUpPosteId() + ","
                + "down_poste_id = " + poste.getDownPosteId() + ","
                + "title = " + poste.getTitle() + ","
                + "salary = " + poste.getSalary() + ","
                + "work_time_hours_by_day = " + poste.getWorkTimeHoursByDay() + ",\n"
                + "WHERE id =" + poste.getId()
                + ";";
        return  sql;
    }

    public static String deletePoste(int posteId){
        /** Return the insert schema for the database **/
        String sql = "DELETE FROM "+POSTE_TABLE+" \n"
                + "WHERE id =" + posteId
                + ";";
        return  sql;
    }

    public static String getposte(int posteId){
        return  "SELECT * FROM "+POSTE_TABLE+" WHERE id = "+ posteId;
    }

    public static String getAllPostes(){
        return  "SELECT * FROM " + POSTE_TABLE;
    }



}
