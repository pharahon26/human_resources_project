package repositories.database;

import models.Vaccancy;

public class VaccancyDAO {
    public static final String VACANCY_TABLE = "vaccancy";

    public static String getSQLSchema(){
        /** Return the schema for the database **/
        return "CREATE TABLE IF NOT EXISTS "+VACANCY_TABLE+" (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " employee_id integer,\n"
                + " starting_date integer,\n"
                + " end_date integer,\n"
                + " FOREIGN KEY (employee_id) REFERENCES employees (id) \n"
                + ");";
    }

    public static String insertVaccancy(Vaccancy vaccancy){
        /** Return the insert schema for the database **/
        String sql = "INSERT INTO "+VACANCY_TABLE+"(employee_id, starting_date, end_date) VALUES ("
                + vaccancy.getEmployee_id() + ","
                + vaccancy.getStarting_date() + "',"
                + vaccancy.getEnd_date()
                + ");";
        return  sql;
    }

    public static String updateVaccancy(Vaccancy vaccancy){
        /** Return the insert schema for the database **/
        String sql = "UPDATE "+VACANCY_TABLE+" SET\n"
                + "employee_id = " + vaccancy.getEmployee_id() + ","
                + "starting_date = " + vaccancy.getStarting_date() + ","
                + "end_date = " + vaccancy.getEnd_date() + ",\n"
                + "WHERE id =" + vaccancy.getId()
                + ";";
        return  sql;
    }

    public static String deleteVaccancy(int vaccancyId){
        /** Return the insert schema for the database **/
        String sql = "DELETE FROM "+VACANCY_TABLE+" \n"
                + "WHERE id =" + vaccancyId
                + ";";
        return  sql;
    }

    public static String getVaccancy(int vaccancyId){
        return  "SELECT * FROM "+VACANCY_TABLE+" WHERE id = "+ vaccancyId;
    }

    public static String getAllVaccancy(){
        return  "SELECT * FROM " + VACANCY_TABLE;
    }



}
