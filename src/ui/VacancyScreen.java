package ui;

import models.Employee;
import models.Poste;
import models.User;
import models.Vaccancy;
import repositories.manager.MainManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class VacancyScreen {
    public JPanel vacancyView;
    private JTable currentVacancies;
    private JComboBox<Employee> emplyeeComboBox;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton addButton;
    private JLabel employeeLabel;
    private JLabel startingDay;
    private JLabel endingDay;
    private JLabel monthLabel;
    private JSpinner monthSpinner;
    private JLabel dayLabel;
    private JSpinner daySpinner;
    private JLabel yearLabel;
    private JSpinner yearSpinner;
    private JLabel endMonthLabel;
    private JSpinner endMonthSpinner;
    private JLabel endDayLabel;
    private JSpinner endDaySpinner;
    private JLabel endYearLabel;
    private JSpinner endYearSpinner;
    private JLabel errorTxt;
    public MainManager mainManager;
    private int employeeId;
    private int startYear = 2021;
    private int startMonth = 0;
    private int startDay = 1;
    private int endYear = 2021;
    private int endMonth = 0;
    private int endDay = 1;

    public VacancyScreen(MainManager mainManager) {
        this.mainManager = mainManager;

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteVacancy();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVacancy();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateVacancy();
            }
        });

        emplyeeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Employee emp = (Employee) emplyeeComboBox.getSelectedItem();
                if (emp != null){
                    employeeId = emp.getId();
                };
            }
        });
        monthSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String m = (String) monthSpinner.getValue();
                switch (m){
                    case "January" -> startMonth = Calendar.JANUARY;
                    case "February" -> startMonth = Calendar.FEBRUARY;
                    case "March" -> startMonth = Calendar.MARCH;
                    case "April" -> startMonth = Calendar.APRIL;
                    case "May" -> startMonth = Calendar.MAY;
                    case "June" -> startMonth = Calendar.JUNE;
                    case "July" -> startMonth = Calendar.JULY;
                    case "August" -> startMonth = Calendar.AUGUST;
                    case "September" -> startMonth = Calendar.SEPTEMBER;
                    case "October" -> startMonth = Calendar.OCTOBER;
                    case "November" -> startMonth = Calendar.NOVEMBER;
                    case "December" -> startMonth = Calendar.DECEMBER;
                }
            }
        });
        endMonthSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String m = (String) monthSpinner.getValue();
                switch (m){
                    case "January" -> endMonth = Calendar.JANUARY;
                    case "February" -> endMonth = Calendar.FEBRUARY;
                    case "March" -> endMonth = Calendar.MARCH;
                    case "April" -> endMonth = Calendar.APRIL;
                    case "May" -> endMonth = Calendar.MAY;
                    case "June" -> endMonth = Calendar.JUNE;
                    case "July" -> endMonth = Calendar.JULY;
                    case "August" -> endMonth = Calendar.AUGUST;
                    case "September" -> endMonth = Calendar.SEPTEMBER;
                    case "October" -> endMonth = Calendar.OCTOBER;
                    case "November" -> endMonth = Calendar.NOVEMBER;
                    case "December" -> endMonth = Calendar.DECEMBER;
                }
            }
        });

        daySpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                startDay = (int) daySpinner.getValue();
            }
        });
        endDaySpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                endDay = (int) endDaySpinner.getValue();
            }
        });

        yearSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                startYear = (int) yearSpinner.getValue();
            }
        });
        endYearSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                endYear = (int) endYearSpinner.getValue();
            }
        });

        emplyeeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
    }

    private Object[][] fillVaccancies(List<Vaccancy> vacancies) {
        String[][] data = new String[vacancies.size()][5];
        System.out.println("fill");
        for (int i =0; i < vacancies.size(); i++) {
            Employee e = mainManager.getEmployee(vacancies.get(i).getEmployee_id());
            data[i][0] = e.getLastName();
            data[i][1] = e.getFirstName();
            data[i][2] = e.getTitle();
            LocalDate d =  LocalDate.ofEpochDay(vacancies.get(i).getStarting_date());
            data[i][3] = d.toString();
            LocalDate de =  LocalDate.ofEpochDay(vacancies.get(i).getEnd_date());
            data[i][4] = de.toString();
        }
        return data;
    }

    private void relaod(){
        List<Vaccancy> vacancies = mainManager.getAllVacancy();
        String[] collumnNames = {"Firstname", "Lastname", "position", "start date", "end date"};

        List<Employee> employees = mainManager.getAllEmployee();
        Employee fill = new Employee("","","", LocalDate.now());
        fill.setTitle("");
        emplyeeComboBox.addItem(fill);
        for(Employee e: employees){
            emplyeeComboBox.addItem(e);
        }

        Object[][] tableData = fillVaccancies(vacancies);
        DefaultTableModel tableModel = new DefaultTableModel(tableData, collumnNames);
        currentVacancies.setModel(tableModel);

        String[] monthStrings = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; //get month names
        SpinnerListModel startMonthModel = new SpinnerListModel(monthStrings);
        SpinnerListModel endMonthModel = new SpinnerListModel(monthStrings);
        monthSpinner.setModel(startMonthModel);
        endMonthSpinner.setModel(endMonthModel);

        SpinnerModel yearModel = new SpinnerNumberModel(2021, //initial value
                2021, //min
                2121, //max
                1);
        SpinnerModel endYearModel = new SpinnerNumberModel(2021, //initial value
                2021, //min
                2121,
                1);

        SpinnerModel dayModel = new SpinnerNumberModel(1, //initial value
                1, //min
                31, //max
                1);
        SpinnerModel endDayModel = new SpinnerNumberModel(1, //initial value
                1, //min
                31, //max
                1);

        daySpinner.setModel(dayModel);
        endDaySpinner.setModel(endDayModel);
        yearSpinner.setModel(yearModel);
        endYearSpinner.setModel(endYearModel);
    }

    private void clearLabel(){
        emplyeeComboBox.setSelectedIndex(0);
        clearErrorLabel();
    }

    private void clearErrorLabel(){
        errorTxt.setText("");
    }

    private boolean verifieField(LocalDate sd, LocalDate ed){
        boolean valid = true;
        Employee e = mainManager.getEmployee(employeeId);
        if (ChronoUnit.DAYS.between(sd, ed) < e.getVacancy_days_remaining()){
            errorTxt.setText("period too long");
            valid = false;
        }
        else if (emplyeeComboBox.getSelectedIndex() == 0){
            errorTxt.setText("Choose an employee");
            valid = false;
        }
        return valid;
    }


    // add a vacancy to the database
    private void addVacancy(){
        LocalDate sd = LocalDate.of(startYear, startMonth, startDay);
        System.out.println(endDay);
        LocalDate ed = LocalDate.of(endYear, endMonth, endDay);
        System.out.println(sd);
        clearErrorLabel();
        if(verifieField(sd, ed)){
            Vaccancy v = new Vaccancy(employeeId, sd.toEpochDay(), ed.toEpochDay());
            mainManager.insertVacancy(v,(int) ChronoUnit.DAYS.between(sd, ed));
            relaod();
            clearLabel();
        }

    }

    // update a vacancy to the database
    private void updateVacancy(){
        Employee temp = mainManager.getEmployee(employeeId);
        LocalDate sd = LocalDate.of(startYear, startMonth, startDay);
        System.out.println(endDay);
        LocalDate ed = LocalDate.of(endYear, endMonth, endDay);
        System.out.println(sd);
        clearErrorLabel();
        if(verifieField(sd, ed)){
            Vaccancy v = new Vaccancy(employeeId, sd.toEpochDay(), ed.toEpochDay());
            v.setId(currentVacancies.getSelectedRow() +1);
            mainManager.updateVacancy(v,(int) ChronoUnit.DAYS.between(sd, ed));
            relaod();
            clearLabel();
        }
    }

    // delete vacancy to the database
    private void deleteVacancy(){
        mainManager.deleteVacancy(currentVacancies.getSelectedRow() +1);
    }

}
