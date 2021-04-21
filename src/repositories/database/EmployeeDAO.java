package repositories.database;

import models.Employee;

public class EmployeeDAO {

    public static final String EMPLOYEE_TABLE = "employees";


    public static String getSQLSchema(){
        /** Return the schema for the database **/
        return "CREATE TABLE IF NOT EXISTS "+EMPLOYEE_TABLE+" (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " lastName text NOT NULL,\n"
                + " firstName text NOT NULL,\n"
                + " title text NOT NULL,\n"
                + " phoneNumber text NOT NULL,\n"
                + " birthDay integer NOT NULL,\n"
                + " poste_id integer,\n"
                + " vacancy_days_remaining integer,\n"
                + " FOREIGN KEY (poste_id) REFERENCES postes (id) \n"
                + ");";
    }

    public static String insertEmployee(Employee employee){
        /** Return the insert schema for the database **/
        String sql = "INSERT INTO "+EMPLOYEE_TABLE+"(lastName, firstName, title, phoneNumber, birthDay, poste_id, vacancy_days_remaining) VALUES ('"
                + employee.getLastName() + "','"
                + employee.getFirstName() + "','"
                + employee.getTitle() + "','"
                + employee.getPhoneNumber() + "',"
                + employee.getBirthDay() + ","
                + employee.getPosteId() + ","
                + employee.getVacancy_days_remaining()
                + ")";
        return  sql;
    }

    public static String updateEmployee(Employee employee){
        /** Return the insert schema for the database **/
        String sql = "UPDATE "+EMPLOYEE_TABLE+" SET\n"
                + "lastName = '" + employee.getLastName() + "',"
                + "firstName = '" + employee.getFirstName() + "',"
                + "title = '" + employee.getTitle() + "',"
                + "phoneNumber = '" + employee.getPhoneNumber() + "',"
                + "birthDay = " + employee.getBirthDay() + ","
                + "poste_id = " + employee.getPosteId() + ","
                + "vacancy_days_remaining = " + employee.getVacancy_days_remaining() + "\n"
                + "WHERE id =" + employee.getId()
                + ";";
        return  sql;
    }

    public static String deleteEmployee(int employeeId){
        /** Return the insert schema for the database **/
        String sql = "DELETE FROM "+EMPLOYEE_TABLE+" \n"
                + "WHERE id =" + employeeId
                + ";";
        return  sql;
    }

    public static String getEmployee(int employeeId){
        return  "SELECT * FROM "+EMPLOYEE_TABLE+" WHERE id = "+ employeeId;
    }

    public static String getAllEmployees(){
        return  "SELECT * FROM " + EMPLOYEE_TABLE;
    }

}
