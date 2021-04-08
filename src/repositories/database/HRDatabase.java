package repositories.database;

import models.Employee;
import models.Poste;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HRDatabase {

    private Connection dbConnection = null;

    public static final String DB_NAME = "human_ressources";
    /// ne pas oublier de changer le path vers celui du projet
    public static final String DB_URL = "jdbc:sqlite:E:/human_resources_project/src/db/human_ressources";

    public HRDatabase() {
        try {
            dbConnection = DriverManager.getConnection(DB_URL);
            if (dbConnection != null) {
                DatabaseMetaData meta = dbConnection.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException  e) {
            System.out.println("error mesage " + e.getMessage());
            System.out.println("A new database has not been created.");
        }
    }

//    public void connect() {
//        try {
//            // Connect the database
//            this.dbConnection = DriverManager.getConnection(DB_URL);
//            if (dbConnection != null) {
//                DatabaseMetaData meta = dbConnection.getMetaData();
//                System.out.println("The driver name is " + meta.getDriverName());
//                System.out.println("A new database has been created.");
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    // close connection
    public void closeConnection() {
        /** don't forget to close de database**/
        try {
            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // create table
    public void createNewTables() {
        // Get the sql statement for the database
        String userTable = UserDAO.getSQLSchema();
        String posteTable = PosteDAO.getSQLSchema();
        String employeeTable = EmployeeDAO.getSQLSchema();
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isUserTableCreated = stmt.execute(userTable);
            if(isUserTableCreated){
                System.out.println("userTable created successfully");
            }
            boolean isPosteTableCreated = stmt.execute(posteTable);
            if(isPosteTableCreated){
                System.out.println("posteTable created successfully");
            }
            boolean isEmployTableCreated = stmt.execute(employeeTable);
            if(isEmployTableCreated){
                System.out.println("employeeTable created successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /** USER OPERATIONS **/

    // insert User
    public void insertUser(User user) {
        // Get the sql statement for the database
        String insert = UserDAO.insertUser(user);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isUserInserted = stmt.execute(insert);
            if(isUserInserted){
                System.out.println("user inserted successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // update user
    public void updateUser(User user) {
        // Get the sql statement for the database
        String update = UserDAO.updateUser(user);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isUserUpdated = stmt.execute(update);
            if(isUserUpdated){
                System.out.println("user updated successfully");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // delete User
    public void deleteUser(int userId) {
        // Get the sql statement for the database
        String delete = UserDAO.deleteUser(userId);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isUserDeleted = stmt.execute(delete);
            if(isUserDeleted){
                System.out.println("user deleted successfully");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // get User
    public User getUser(int userId) {
        // Get the sql statement for the database
        String get = UserDAO.getUser(userId);
        User userGet = new User();
        try{
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(get);
            while (result.next()) {
                userGet = new User(
                        result.getInt("id"),
                        result.getString("username"),
                        result.getString("password")
                );

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userGet;
    }


    /** POSTE OPERATIONS **/

    // insert POSTE
    public void insertPoste(Poste poste) {
        // Get the sql statement for the database
        String insert = PosteDAO.insertPoste(poste);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isPosteInserted = stmt.execute(insert);
            if(isPosteInserted){
                System.out.println("poste inserted successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // update POSTE
    public void updatePoste(Poste poste) {
        // Get the sql statement for the database
        String update = PosteDAO.updatePoste(poste);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isPosteUpdated = stmt.execute(update);
            if(isPosteUpdated){
                System.out.println("poste updated successfully");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // delete POSTE
    public void deleteposte(int posteId) {
        // Get the sql statement for the database
        String delete = PosteDAO.deletePoste(posteId);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isPosteDeleted = stmt.execute(delete);
            if(isPosteDeleted){
                System.out.println("poste deleted successfully");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // get Poste
    public Poste getPoste(int posteId) {
        // Get the sql statement for the database
        String get = PosteDAO.getposte(posteId);
        Poste posteGet = new Poste();
        try{
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(get);
            while (result.next()) {
                posteGet = new Poste(
                        result.getInt("id"),
                        result.getInt("upPosteId"),
                        result.getInt("downPosteId"),
                        result.getDouble("salary"),
                        result.getString("title"),
                        result.getInt("workTimeHoursByDay")
                );

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return posteGet;
    }

    // get Poste
    public List<Poste> getAllPoste() {
        // Get the sql statement for the database
        String get = PosteDAO.getAllPostes();
        List<Poste> posteGet = new ArrayList<>();
        try{
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(get);
            while (result.next()) {
                Poste posteG = new Poste(
                        result.getInt("id"),
                        result.getInt("upPosteId"),
                        result.getInt("downPosteId"),
                        result.getDouble("salary"),
                        result.getString("title"),
                        result.getInt("workTimeHoursByDay")
                );
                posteGet.add(posteG);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return posteGet;
    }



    /** EMPLOYEE OPERATIONS **/

    // insert Employee
    public void insertEmployee(Employee employee) {
        // Get the sql statement for the database
        String insert = EmployeeDAO.insertEmployee(employee);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isEmployeeInserted = stmt.execute(insert);
            if(isEmployeeInserted){
                System.out.println("employee inserted successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // update Employee
    public void updateEmployee(Employee employee) {
        // Get the sql statement for the database
        String update = EmployeeDAO.updateEmployee(employee);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isEmployeeUpdated = stmt.execute(update);
            if(isEmployeeUpdated){
                System.out.println("Employee updated successfully");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // delete Employee
    public void deleteEmployee(int employeeId) {
        // Get the sql statement for the database
        String delete = EmployeeDAO.deleteEmployee(employeeId);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isEmployeeDeleted = stmt.execute(delete);
            if(isEmployeeDeleted){
                System.out.println("Employee deleted successfully");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // get Employee
    public Employee getEmployee(int employeeId) {
        // Get the sql statement for the database
        String get = EmployeeDAO.getEmployee(employeeId);
        Employee employeeGet = new Employee();
        try{
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(get);
            while (result.next()) {
                employeeGet = new Employee(
                        result.getInt("id"),
                        result.getString("lastName"),
                        result.getString("firstName"),
                        result.getInt("phoneNumber"),
                        result.getLong("birthDay"),
                        result.getInt("posteId"),
                        result.getString("title"),
                        result.getInt("vacancy_days_remaining")
                );

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employeeGet;
    }

    // get all Employees
    public List<Employee> getAllEmployees() {
        // Get the sql statement for the database
        String get = EmployeeDAO.getAllEmployees();
        List<Employee> employeeGet = new ArrayList<>();
        try{
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(get);
            while (result.next()) {
                Employee employeeG = new Employee(
                        result.getInt("id"),
                        result.getString("lastName"),
                        result.getString("firstName"),
                        result.getInt("phoneNumber"),
                        result.getLong("birthDay"),
                        result.getInt("posteId"),
                        result.getString("title"),
                        result.getInt("vacancy_days_remaining")
                );
                employeeGet.add(employeeG);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employeeGet;
    }



}
