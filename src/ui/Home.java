package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JButton manageUsersButton;
    private JButton manageEmployeesButton;
    private JButton managePositionsButton;
    public JPanel homeView;
    private JPanel mainView;
    private JButton manageVacancyButton;

    EmployeeScreen employeeScreen = new EmployeeScreen();
    UserSreen userSreen = new UserSreen();
    PosteScreen posteScreen = new PosteScreen();
    VacancyScreen vacancyScreen = new VacancyScreen();


    public Home() {
        mainView.add("employee",employeeScreen.employeeView);
        mainView.add("user",userSreen.userView);
        mainView.add("poste",posteScreen.posteView);
        mainView.add("vacancy",vacancyScreen.vacancyView);

        homeView.setBorder(new EmptyBorder(5, 10, 10, 10));
        mainView.setBorder(new EmptyBorder(10, 10, 10, 10));



//        mainView.setUI(employeeScreen.employeeView.getUI());
//        mainView.updateUI();
        manageUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(mainView.getLayout());
                cl.show(mainView, "user");
            }
        });

        manageEmployeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(mainView.getLayout());
                cl.show(mainView, "employee");
            }
        });

        managePositionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(mainView.getLayout());
                cl.show(mainView, "poste");
            }
        });

        manageVacancyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(mainView.getLayout());
                cl.show(mainView, "vacancy");
            }
        });


    }
}
