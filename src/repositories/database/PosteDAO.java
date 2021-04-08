package repositories.database;

import models.Poste;

public class PosteDAO {

    public static String getSQLSchema(){
        /** Return the schema for the database **/
        return "CREATE TABLE IF NOT EXISTS postes (\n"
                + " id integer PRIMARY KEY,\n"
                + " title text NOT NULL,\n"
                + " salary realn\n"
                + " workTimeHoursByDay integer,\n"
                + " upPosteId integer FOREIGN KEY,\n"
                + " downPosteId integer FOREIGN KEY,\n"
                + " FOREIGN KEY (upPosteId) REFERENCES postes (upPosteId), \n"
                + " FOREIGN KEY (downPosteId) REFERENCES po,tes (downPosteId) \n"
                + ");";
    }

    public static String insertPoste(Poste poste){
        /** Return the insert schema for the database **/
        String sql = "INSERT INTO postes(id, upPosteId, downPosteId, title, salary, workTimeHoursByDay) VALUES("
                + poste.getId() + ","
                + poste.getUpPosteId() + ","
                + poste.getDownPosteId() + ","
                + poste.getTitle() + ","
                + poste.getSalary() + ","
                + poste.getWorkTimeHoursByDay() + ","
                + ");";
        return  sql;
    }

    public static String updatePoste(Poste poste){
        /** Return the insert schema for the database **/
        String sql = "UPDATE postes SET\n"
                + "id = " + poste.getId() + ","
                + "upPosteId = " + poste.getUpPosteId() + ","
                + "downPosteId = " + poste.getDownPosteId() + ","
                + "title = " + poste.getTitle() + ","
                + "salary = " + poste.getSalary() + ","
                + "workTimeHoursByDay = " + poste.getWorkTimeHoursByDay() + ",\n"
                + "WHERE id =" + poste.getId()
                + ";";
        return  sql;
    }

    public static String deletePoste(int posteId){
        /** Return the insert schema for the database **/
        String sql = "DELETE FROM postes \n"
                + "WHERE id =" + posteId
                + ";";
        return  sql;
    }

    public static String getposte(int posteId){
        return  "SELECT * FROM postes WHERE id = "+ posteId;
    }

    public static String getAllPostes(){
        return  "SELECT * FROM postes";
    }



}
