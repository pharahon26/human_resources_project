package repositories.manager;

import models.Employee;
import models.Poste;
import models.User;
import models.Vaccancy;
import repositories.database.HRDatabase;

import java.util.List;


public class MainManager {
    HRDatabase database = null;
    User currentUser = null;

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
    // get User
    public User connectUser(String username, String password) {
        currentUser = database.connectUser(username, password);
        return currentUser;
    }

    // get all USER
    public List<User> getAllUser() {
        return database.getAllUser();
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
    public void deletePoste(int posteId) {
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


    /** VACANCY OPERATIONS **/

    // insert vacancy
    public void insertVacancy(Vaccancy Vacancy) {
        database.insertVaccancy(Vacancy);
    }

    // update Vacancy
    public void updateVacancy(Vaccancy Vacancy) {
        database.updateVaccancy(Vacancy);
    }

    // delete Vacancy
    public void deleteVacancy(int vacancyId) {
       database.deleteVaccancy(vacancyId);
    }

    // get Vacancy
    public Vaccancy getVacancye(int vacancyId) {
       return database.getVaccancy(vacancyId);
    }

    // get all Vacancies
    public List<Vaccancy> getAllVacancy() {
       return database.getAllVaccancy();
    }



}
