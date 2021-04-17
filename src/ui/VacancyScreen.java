package ui;

import models.User;
import models.Vaccancy;
import repositories.manager.MainManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VacancyScreen {
    public JPanel vacancyView;
    private JTable currentVacancies;
    private JTextField startDayTextField;
    private JComboBox userComboBox;
    private JTextField endDayTextField;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton addButton;
    private JLabel vacancyLabel;
    private JLabel vacancyLabelTxt;
    private JLabel userLabel;
    private JLabel startingDay;
    private JLabel endingDay;
    public MainManager mainManager;

    public VacancyScreen(MainManager mainManager) {
        this.mainManager = mainManager;

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                mainManager.deleteVacancy();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                mainManager.insertVacancy();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                mainManager.updateVacancy();
            }
        });
    }


    // add a vacancy to the database
//    private void addVacancy(){
//
//        User u = new User(usernameTxt.getText(), passwordTxt.getText());
//        mainManager.insertUser(u);
//    }
//
//    // update a vacancy to the database
//    private void updateVacancy(Vaccancy temp){
//        Vaccancy v = new User(usernameTxt.getText(), passwordTxt.getText());
//        mainManager.updateVacancy(u);
//    }

    // add a poste to the database
    private void deteteVacancy(Vaccancy temp){
        mainManager.deleteVacancy(temp.getId());
    }
}
