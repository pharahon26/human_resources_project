package ui;

import repositories.manager.MainManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Home {
    private JButton manageUsersButton;
    private JButton manageEmployeesButton;
    private JButton managePositionsButton;
    public JPanel homeView;
    private JPanel mainView;
    private JButton manageVacancyButton;
    private JTabbedPane homeTabbedPane;
    public MainManager mainManager;
    static JFrame frame = new JFrame("Humain ressources");


    EmployeeScreen employeeScreen;
    UserSreen userSreen;
    PosteScreen posteScreen;
    VacancyScreen vacancyScreen;
    MissionScreen missionScreen;


    public Home(MainManager mainManager) {
        this.mainManager = mainManager;
        employeeScreen = new EmployeeScreen(mainManager);
        userSreen = new UserSreen(mainManager);
        posteScreen = new PosteScreen(mainManager);
        vacancyScreen = new VacancyScreen(mainManager);
        missionScreen = new MissionScreen(mainManager);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(900, 600);
        frame.setVisible(true);


        homeTabbedPane.add("Employees",employeeScreen.employeeView);
        homeTabbedPane.add("Users",userSreen.userView);
        homeTabbedPane.add("Positions",posteScreen.posteView);
        homeTabbedPane.add("Missions",missionScreen.missionView);
        homeTabbedPane.add("Vacancies",vacancyScreen.vacancyView);


        homeView.setBorder(new EmptyBorder(5, 10, 10, 10));
        mainView.setBorder(new EmptyBorder(10, 10, 10, 10));

        frame.setContentPane(mainView);

//        manageUsersButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout cl = (CardLayout)(mainView.getLayout());
//                cl.show(mainView, "user");
//            }
//        });
//
//        manageEmployeesButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout cl = (CardLayout)(mainView.getLayout());
//                cl.show(mainView, "employee");
//            }
//        });
//
//        managePositionsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout cl = (CardLayout)(mainView.getLayout());
//                cl.show(mainView, "poste");
//            }
//        });
//
//        manageVacancyButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CardLayout cl = (CardLayout)(mainView.getLayout());
//                cl.show(mainView, "vacancy");
//            }
//        });


    }
}
