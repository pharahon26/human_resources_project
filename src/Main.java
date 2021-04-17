import models.Employee;
import models.Poste;
import models.User;
import repositories.manager.MainManager;
import ui.Connexion;
import ui.Home;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main implements Home.homeInterface{

    static JFrame frame = new JFrame("Humain ressources");
    static Home home;

    public static void main(String[] args){
        MainManager mainManager = new MainManager();
//        GregorianCalendar date = new GregorianCalendar(1985, Calendar.AUGUST, 18);
//        String number = "0151838383";
//
//        User user = new User(1, "admin", "admin");
//        Poste poste = new Poste(1, 0, 0, 750000.0, "administrator", 8);
//        Employee employee = new Employee(1, "Sereme", "Habib", number, date.getTimeInMillis(), 1, "Computer scientist", 30);
        // add data une the database
//        mainManager.insertUser(user);
//        mainManager.insertPoste(poste);
//        mainManager.insertEmployee(employee);
        // see the data
//        mainManager.getUser(1);
//        mainManager.getPoste(1);
//        mainManager.getEmployee(1);
//        mainManager.getAllPoste();
//        mainManager.getAllEmployee();
        // insert other data the data

//        User user2 = new User(2, "help", "admin");
//        Poste poste2 = new Poste(2, 1, 0, 550000.0, "helper", 9);
//        Employee employee2 = new Employee(2, "Kabore", "Sam", number, date.getTimeInMillis(), poste2.getId(), "Computer scientist", 30);
//
//        mainManager.insertUser(user2);
//        mainManager.insertPoste(poste2);
//        mainManager.insertEmployee(employee2);
//
//        // delete the data
//        mainManager.getUser(2);
//        mainManager.getPoste(2);
//        mainManager.getEmployee(2);
//        mainManager.getAllPoste();
//        mainManager.getAllEmployee();
//        mainManager.deleteUser(2);
//        mainManager.deletePoste(2);
//        mainManager.deleteEmployee(2);
//        mainManager.getAllPoste();
//        mainManager.getAllEmployee();


        Connexion connexion = new Connexion(mainManager);
        home = new Home(mainManager);
        frame.setContentPane(home.homeView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(900, 600);
        frame.setVisible(true);



        }

    @Override
    public void openHome() {
        frame.setContentPane(home.homeView);
    }
}
