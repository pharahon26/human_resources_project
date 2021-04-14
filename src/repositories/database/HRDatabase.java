package repositories.database;

import models.Employee;
import models.Poste;
import models.User;
import models.Vaccancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HRDatabase {

    private Connection dbConnection = null;

    public static final String DB_NAME = "human_ressources";
    /// ne pas oublier de changer le path vers celui du projet
    public static final String DB_URL = "jdbc:sqlite:E:/human_resources_project/src/db/human_ressources.db";

    public HRDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection(DB_URL);
            if (dbConnection != null) {
                DatabaseMetaData meta = dbConnection.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                createNewTables();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error mesage " + e.getMessage());
            System.out.println("A new database has not been created.");
        }
    }

    // close connection
    public void closeConnection() {
        // don't forget to close de database
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
        String vaccancyTable = VaccancyDAO.getSQLSchema();
        System.out.println("start create tables");
        try(Statement stmt = dbConnection.createStatement()){
            System.out.println("start create table user " + stmt.getMaxFieldSize());
            boolean isUserTableCreated = stmt.execute(userTable);
            System.out.println("create user table result " + isUserTableCreated + " " + stmt.isCloseOnCompletion());
            if(isUserTableCreated){
                System.out.println("userTable created successfully");
            }
        } catch (SQLException e) {
            System.out.println("error from db create user table.");
            System.out.println(e.getMessage());
        }

        try(Statement stmt = dbConnection.createStatement()){
            boolean isPosteTableCreated = stmt.execute(posteTable);
            if(isPosteTableCreated){
                System.out.println("posteTable created successfully");
            }
        } catch (SQLException e) {
            System.out.println("error from db create poste table.");
            System.out.println(e.getMessage());
        }

        try(Statement stmt = dbConnection.createStatement()){
            boolean isEmployTableCreated = stmt.execute(employeeTable);
            if(isEmployTableCreated){
                System.out.println("employeeTable created successfully");
            }
        } catch (SQLException e) {
            System.out.println("error from db create employee table.");
            System.out.println(e.getMessage());
        }

        try(Statement stmt = dbConnection.createStatement()){
            boolean isVaccancyTableCreated = stmt.execute(employeeTable);
            if(isVaccancyTableCreated){
                System.out.println("vaccancyTable created successfully");
            }
        } catch (SQLException e) {
            System.out.println("error from db create vaccancy table.");
            System.out.println(e.getMessage());
        }




    }

    /** USER OPERATIONS **/

    // insert User
    public void insertUser(User user) {
        // Get the sql statement for the database
        System.out.println("Start insert user.");
        String insert = UserDAO.insertUser(user);
        System.out.println("Start insert : " + insert);
        try(Statement stmt = dbConnection.createStatement()){
            boolean isUserInserted = stmt.execute(insert);
            if(isUserInserted){
                System.out.println("user inserted successfully");
            }
        } catch (SQLException e) {
            System.out.println("error from db insert user.");
            System.out.println(e.getMessage());
        }
    }

    // update user
    public void updateUser(User user) {
        // Get the sql statement for the database
        System.out.println("Start update user.");
        String update = UserDAO.updateUser(user);
        System.out.println("Start update : " + update);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isUserUpdated = stmt.execute(update);
            if(isUserUpdated){
                System.out.println("user updated successfully");
            }

        } catch (SQLException e) {
            System.out.println("error from db update user.");
            System.out.println(e.getMessage());
        }
    }

    // delete User
    public void deleteUser(int userId) {
        // Get the sql statement for the database
        System.out.println("Start delete user.");
        String delete = UserDAO.deleteUser(userId);
        System.out.println("Start delete : " + delete);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isUserDeleted = stmt.execute(delete);
            if(isUserDeleted){
                System.out.println("user deleted successfully");
            }

        } catch (SQLException e) {
            System.out.println("error from db delete user.");
            System.out.println(e.getMessage());
        }
    }

    // get User
    public User getUser(int userId) {
        // Get the sql statement for the database
        System.out.println("Start get user.");
        String get = UserDAO.getUser(userId);
        System.out.println("Start get : " + get);
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
            System.out.println("return user: " +  userGet.toString());
        } catch (SQLException e) {
            System.out.println("error from db get user.");
            System.out.println(e.getMessage());
        }
        return userGet;
    }


    /** POSTE OPERATIONS **/

    // insert POSTE
    public void insertPoste(Poste poste) {
        // Get the sql statement for the database
        System.out.println("Start insert poste.");
        String insert = PosteDAO.insertPoste(poste);
        System.out.println("Start insert : " + insert);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isPosteInserted = stmt.execute(insert);
            if(isPosteInserted){
                System.out.println("poste inserted successfully");
            }
        } catch (SQLException e) {
            System.out.println("error from db insert poste.");
            System.out.println(e.getMessage());
        }
    }

    // update POSTE
    public void updatePoste(Poste poste) {
        // Get the sql statement for the database
        System.out.println("Start update poste.");
        String update = PosteDAO.updatePoste(poste);
        System.out.println("Start update : " + update);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isPosteUpdated = stmt.execute(update);
            if(isPosteUpdated){
                System.out.println("poste updated successfully");
            }

        } catch (SQLException e) {
            System.out.println("error from db update poste.");
            System.out.println(e.getMessage());
        }
    }

    // delete POSTE
    public void deleteposte(int posteId) {
        // Get the sql statement for the database
        System.out.println("Start delete poste.");
        String delete = PosteDAO.deletePoste(posteId);
        System.out.println("Start delete : " + delete);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isPosteDeleted = stmt.execute(delete);
            if(isPosteDeleted){
                System.out.println("poste deleted successfully");
            }

        } catch (SQLException e) {
            System.out.println("error from db delete poste.");
            System.out.println(e.getMessage());
        }
    }

    // get Poste
    public Poste getPoste(int posteId) {
        // Get the sql statement for the database
        System.out.println("Start get poste.");
        String get = PosteDAO.getposte(posteId);
        Poste posteGet = new Poste();
        System.out.println("Start get : " + get);
        try{
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(get);
            while (result.next()) {
                posteGet = new Poste(
                        result.getInt("id"),
                        result.getInt("up_poste_id"),
                        result.getInt("down_poste_id"),
                        result.getDouble("salary"),
                        result.getString("title"),
                        result.getInt("work_time_hours_by_day")
                );
                System.out.println("return poste.");
            }
            System.out.println("return poste: " +  posteGet.toString());
        } catch (SQLException e) {
            System.out.println("error from db get poste.");
            System.out.println(e.getMessage());
        }
        return posteGet;
    }

    // get Poste
    public List<Poste> getAllPoste() {
        // Get the sql statement for the database
        System.out.println("Start get all poste.");
        String get = PosteDAO.getAllPostes();
        System.out.println("Start get all : " + get);
        List<Poste> posteGet = new ArrayList<>();
        try{
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(get);
            while (result.next()) {
                Poste posteG = new Poste(
                        result.getInt("id"),
                        result.getInt("up_poste_id"),
                        result.getInt("down_poste_id"),
                        result.getDouble("salary"),
                        result.getString("title"),
                        result.getInt("work_time_hours_by_day")
                );
                posteGet.add(posteG);
            }
            System.out.println("return all postes.");
            for(Poste po : posteGet){
                System.out.println("return poste in list: " +  po.toString());
            }

        } catch (SQLException e) {
            System.out.println("error from db get all poste.");
            System.out.println(e.getMessage());
        }
        return posteGet;
    }



    /** EMPLOYEE OPERATIONS **/

    // insert Employee
    public void insertEmployee(Employee employee) {
        // Get the sql statement for the database
        System.out.println("Start insert employee.");
        String insert = EmployeeDAO.insertEmployee(employee);
        System.out.println("Start insert : " + insert);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isEmployeeInserted = stmt.execute(insert);
            if(isEmployeeInserted){
                System.out.println("employee inserted successfully");
            }
        } catch (SQLException e) {
            System.out.println("error from db insert employee.");
            System.out.println(e.getMessage());
        }
    }

    // update Employee
    public void updateEmployee(Employee employee) {
        System.out.println("Start update employee.");
        // Get the sql statement for the database
        String update = EmployeeDAO.updateEmployee(employee);
        System.out.println("Start update : " + update);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isEmployeeUpdated = stmt.execute(update);
            if(isEmployeeUpdated){
                System.out.println("Employee updated successfully");
            }

        } catch (SQLException e) {
            System.out.println("error from db update employee.");
            System.out.println(e.getMessage());
        }
    }

    // delete Employee
    public void deleteEmployee(int employeeId) {
        System.out.println("Start delete employee.");
        // Get the sql statement for the database
        String delete = EmployeeDAO.deleteEmployee(employeeId);
        System.out.println("Start delete : " + delete);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isEmployeeDeleted = stmt.execute(delete);
            if(isEmployeeDeleted){
                System.out.println("Employee deleted successfully");
            }

        } catch (SQLException e) {
            System.out.println("error from db delete employee.");
            System.out.println(e.getMessage());
        }
    }

    // get Employee
    public Employee getEmployee(int employeeId) {
        // Get the sql statement for the database
        System.out.println("Start get employee.");
        String get = EmployeeDAO.getEmployee(employeeId);
        System.out.println("Start get : " + get);
        Employee employeeGet = new Employee();
        try{
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(get);
            while (result.next()) {
                employeeGet = new Employee(
                        result.getInt("id"),
                        result.getString("lastName"),
                        result.getString("firstName"),
                        result.getString("phoneNumber"),
                        result.getLong("birthDay"),
                        result.getInt("poste_id"),
                        result.getString("title"),
                        result.getInt("vacancy_days_remaining")
                );

            }
            System.out.println("return employee: " +  employeeGet.toString());
        } catch (SQLException e) {
            System.out.println("error from db get employee.");
            System.out.println(e.getMessage());
        }
        return employeeGet;
    }

    // get all Employees
    public List<Employee> getAllEmployees() {
        // Get the sql statement for the database
        System.out.println("Start get all employees.");
        String get = EmployeeDAO.getAllEmployees();
        System.out.println("Start get all : " + get);
        List<Employee> employeeGet = new ArrayList<>();
        try{
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(get);
            while (result.next()) {
                Employee employeeG = new Employee(
                        result.getInt("id"),
                        result.getString("lastName"),
                        result.getString("firstName"),
                        result.getString("phoneNumber"),
                        result.getLong("birthDay"),
                        result.getInt("poste_id"),
                        result.getString("title"),
                        result.getInt("vacancy_days_remaining")
                );
                employeeGet.add(employeeG);
                System.out.println("return all employees.");
            }
            for(Employee emp : employeeGet){
                System.out.println("return employee in list: " +  emp.toString());
            }
        } catch (SQLException e) {
            System.out.println("error from db get all employee.");
            System.out.println(e.getMessage());
        }
        return employeeGet;
    }


    /** VACCANCY OPERATIONS **/

    // insert vaccancy
    public void insertVaccancy(Vaccancy vaccancy) {
        // Get the sql statement for the database
        System.out.println("Start insert vaccancy.");
        String insert = VaccancyDAO.insertVaccancy(vaccancy);
        System.out.println("Start insert : " + insert);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isVaccancyInserted = stmt.execute(insert);
            if(isVaccancyInserted){
                System.out.println("vaccancy inserted successfully");
            }
        } catch (SQLException e) {
            System.out.println("error from db insert vaccancy.");
            System.out.println(e.getMessage());
        }
    }

    // update vaccancy
    public void updateVaccancy(Vaccancy vaccancy) {
        System.out.println("Start update vaccancy.");
        // Get the sql statement for the database
        String update = VaccancyDAO.updateVaccancy(vaccancy);
        System.out.println("Start update : " + update);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isVaccancyUpdated = stmt.execute(update);
            if(isVaccancyUpdated){
                System.out.println("vaccancy updated successfully");
            }

        } catch (SQLException e) {
            System.out.println("error from db update vaccancy.");
            System.out.println(e.getMessage());
        }
    }

    // delete vaccancy
    public void deleteVaccancy(int vaccancyId) {
        System.out.println("Start delete vaccancy.");
        // Get the sql statement for the database
        String delete = VaccancyDAO.deleteVaccancy(vaccancyId);
        System.out.println("Start delete : " + delete);
        try{
            Statement stmt = dbConnection.createStatement();
            boolean isVaccancyDeleted = stmt.execute(delete);
            if(isVaccancyDeleted){
                System.out.println("vaccancy deleted successfully");
            }

        } catch (SQLException e) {
            System.out.println("error from db delete vaccancy.");
            System.out.println(e.getMessage());
        }
    }

    // get vaccancy
    public Vaccancy getVaccancy(int vaccancyId) {
        // Get the sql statement for the database
        System.out.println("Start get vaccancy.");
        String get = VaccancyDAO.getVaccancy(vaccancyId);
        System.out.println("Start get : " + get);
        Vaccancy vaccancyGet = new Vaccancy();
        try{
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(get);
            while (result.next()) {
                vaccancyGet = new Vaccancy(
                        result.getInt("id"),
                        result.getInt("employee_id"),
                        result.getLong("starting_date"),
                        result.getLong("end_date")
                );

            }
            System.out.println("return vaccancy: " +  vaccancyGet.toString());
        } catch (SQLException e) {
            System.out.println("error from db get vaccancy.");
            System.out.println(e.getMessage());
        }
        return vaccancyGet;
    }

    // get all vaccancy
    public List<Vaccancy> getAllVaccancy() {
        // Get the sql statement for the database
        System.out.println("Start get all vaccancy.");
        String get = VaccancyDAO.getAllVaccancy();
        System.out.println("Start get all : " + get);
        List<Vaccancy> vaccancyGet = new ArrayList<>();
        try{
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(get);
            while (result.next()) {
                Vaccancy vaccancyG = new Vaccancy(
                        result.getInt("id"),
                        result.getInt("employee_id"),
                        result.getLong("starting_date"),
                        result.getLong("end_date")
                );
                vaccancyGet.add(vaccancyG);
                System.out.println("return all vaccancy.");
            }
            for(Vaccancy vacc : vaccancyGet){
                System.out.println("return Vaccancy in list: " +  vacc.toString());
            }
        } catch (SQLException e) {
            System.out.println("error from db get all Vaccancy.");
            System.out.println(e.getMessage());
        }
        return vaccancyGet;
    }



}
