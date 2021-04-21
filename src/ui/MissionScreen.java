package ui;


import models.Employee;
import models.Mission;
import repositories.manager.MainManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MissionScreen {
    public MainManager mainManager;
    public JPanel missionView;
    private JTable mission_Table;
    private JComboBox<Employee> employeeComboBox;
    private JLabel monthLabel;
    private JSpinner monthSpinner;
    private JSpinner daySpinner;
    private JLabel yearLabel;
    private JSpinner yearSpinner;
    private JLabel dayLabel;
    private JLabel employeeLabel;
    private JLabel startingDay;
    private JLabel endingDay;
    private JButton deleteButton;
    private JButton addButton;
    private JButton updateButton;
    private JLabel endMonthLabel;
    private JSpinner endMonthSpinner;
    private JSpinner endDaySpinner;
    private JSpinner endYearSpinner;
    private JLabel endYearLabel;
    private JLabel endDayLabel;
    private JLabel errorTxt;
    private int employeeId;


    public MissionScreen(MainManager mainManager) {
        this.mainManager = mainManager;
        List<Mission> missons = mainManager.getAllMission();
        String[] collumnNames = {"Firstname", "Lastname", "position", "start date", "end date"};

        List<Employee> employees = mainManager.getAllEmployee();
        Employee fill = new Employee("","","", LocalDate.now());
        fill.setTitle("");
        employeeComboBox.addItem(fill);
        for(Employee e: employees){
            employeeComboBox.addItem(e);
        }
        DefaultTableModel tableModel = new DefaultTableModel(collumnNames,missons.size());
        mission_Table.setModel(tableModel);

        String[] monthStrings = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; //get month names
        SpinnerListModel startMonthModel = new SpinnerListModel(monthStrings);
        SpinnerListModel endMonthModel = new SpinnerListModel(monthStrings);
        SpinnerModel yearModel = new SpinnerNumberModel(2021, //initial value
                2021, //min
                2121,  //max
                1);
        SpinnerModel endYearModel = new SpinnerNumberModel(2021, //initial value
                2021, //min
                2121, //max
                1);

        SpinnerModel dayModel = new SpinnerNumberModel(1, //initial value
                1, //min
                31, //max
                1);
        SpinnerModel endDayModel = new SpinnerNumberModel(1, //initial value
                1, //min
                31, //max
                1);

        monthSpinner.setModel(startMonthModel);
        endMonthSpinner.setModel(endMonthModel);
        daySpinner.setModel(dayModel);
        endDaySpinner.setModel(endDayModel);
        yearSpinner.setModel(yearModel);
        endYearSpinner.setModel(endYearModel);

        employeeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Employee emp = (Employee) employeeComboBox.getSelectedItem();
                if (emp != null){
                    employeeId = emp.getId();
                }
            }
        });

    }
}
