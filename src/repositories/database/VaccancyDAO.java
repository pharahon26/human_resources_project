package repositories.database;

import models.Vaccancy;

public class VaccancyDAO {

    public static String getSQLSchema(){
        /** Return the schema for the database **/
        return "CREATE TABLE IF NOT EXISTS vaccancy (\n"
                + " id integer PRIMARY KEY,\n"
                + " employee_id integer,\n"
                + " starting_date integer,\n"
                + " end_date integer,\n"
                + " FOREIGN KEY (employee_id) REFERENCES employees (id) \n"
                + ");";
    }

    public static String insertVaccancy(Vaccancy vaccancy){
        /** Return the insert schema for the database **/
        String sql = "INSERT INTO vaccancy(id, employee_id, starting_date, end_date) VALUES ("
                + vaccancy.getId() + ","
                + vaccancy.getEmployee_id() + ","
                + vaccancy.getStarting_date() + "',"
                + vaccancy.getEnd_date()
                + ");";
        return  sql;
    }

    public static String updateVaccancy(Vaccancy vaccancy){
        /** Return the insert schema for the database **/
        String sql = "UPDATE Vaccancy SET\n"
                + "id = " + vaccancy.getId() + ","
                + "employee_id = " + vaccancy.getEmployee_id() + ","
                + "starting_date = " + vaccancy.getStarting_date() + ","
                + "end_date = " + vaccancy.getEnd_date() + ",\n"
                + "WHERE id =" + vaccancy.getId()
                + ";";
        return  sql;
    }

    public static String deleteVaccancy(int vaccancyId){
        /** Return the insert schema for the database **/
        String sql = "DELETE FROM Vaccancy \n"
                + "WHERE id =" + vaccancyId
                + ";";
        return  sql;
    }

    public static String getVaccancy(int vaccancyId){
        return  "SELECT * FROM vaccancy WHERE id = "+ vaccancyId;
    }

    public static String getAllVaccancy(){
        return  "SELECT * FROM vaccancy";
    }



}
