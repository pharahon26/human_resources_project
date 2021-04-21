package repositories.database;

import models.Mission;
import models.Vaccancy;

public class MissionDAO {
    public static final String MISSION_TABLE = "mission";

    public static String getSQLSchema(){
        /** Return the schema for the database **/
        return "CREATE TABLE IF NOT EXISTS "+ MISSION_TABLE +" (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " employee_id integer,\n"
                + " starting_date integer,\n"
                + " end_date integer,\n"
                + " FOREIGN KEY (employee_id) REFERENCES employees (id) \n"
                + ");";
    }

    public static String insertMission(Mission mission){
        /** Return the insert schema for the database **/
        String sql = "INSERT INTO "+ MISSION_TABLE +"(employee_id, starting_date, end_date) VALUES ("
                + mission.getEmployee_id() + ","
                + mission.getStarting_date() + ","
                + mission.getEnd_date()
                + ");";
        return  sql;
    }

    public static String updateMission(Mission mission){
        /** Return the insert schema for the database **/
        String sql = "UPDATE "+ MISSION_TABLE +" SET\n"
                + "employee_id = " + mission.getEmployee_id() + ","
                + "starting_date = " + mission.getStarting_date() + ","
                + "end_date = " + mission.getEnd_date() + ",\n"
                + "WHERE id =" + mission.getId()
                + ";";
        return  sql;
    }

    public static String deleteMission(int missionId){
        /** Return the insert schema for the database **/
        String sql = "DELETE FROM "+ MISSION_TABLE +" \n"
                + "WHERE id =" + missionId
                + ";";
        return  sql;
    }

    public static String getMission(int missionId){
        return  "SELECT * FROM "+ MISSION_TABLE +" WHERE id = "+ missionId;
    }

    public static String getAllMission(){
        return  "SELECT * FROM " + MISSION_TABLE;
    }



}
