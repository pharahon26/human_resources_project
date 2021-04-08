package repositories.manager;

import models.Employee;
import models.Poste;
import models.User;
import repositories.database.HRDatabase;

import java.util.List;


public class MainManager {
    HRDatabase database = null;

    public MainManager() {
        database = new HRDatabase();
    }

    public void closeDB(){
        database.closeConnection();
    }

    /** USER OPERATIONS **/

    // insert User
    public void insertUser(User user) {
        database.insertUser(user);
    }

    // update user
    public void updateUser(User user) {
        database.updateUser(user);
    }

    // delete User
    public void deleteUser(int userId) {
        database.deleteUser(userId);
    }

    // get User
    public User getUser(int userId) {
        return database.getUser(userId);
    }


    /** POSTE OPERATIONS **/

    // insert POSTE
    public void insertPoste(Poste poste) {
        database.insertPoste(poste);
    }

    // update POSTE
    public void updatePoste(Poste poste) {
        database.updatePoste(poste);
    }

    // delete POSTE
    public void deleteposte(int posteId) {
        database.deleteposte(posteId);
    }

    // get POSTE
    public Poste getPoste(int posteId) {
        return database.getPoste(posteId);
    }

    // get all POSTE
    public List<Poste> getAllPoste() {
        return database.getAllPoste();
    }



    /** EMPLOYEE OPERATIONS **/

    // insert Employee
    public void insertEmployee(Employee employee) {
        database.insertEmployee(employee);
    }

    // update Employee
    public void updateEmployee(Employee employee) {
        database.insertEmployee(employee);
    }

    // delete Employee
    public void deleteEmployee(int employeeId) {
       database.deleteEmployee(employeeId);
    }

    // get Employee
    public Employee getEmployee(int employeeId) {
       return database.getEmployee(employeeId);
    }

    // get all Employee
    public List<Employee> getAllEmployee() {
       return database.getAllEmployees();
    }



}
