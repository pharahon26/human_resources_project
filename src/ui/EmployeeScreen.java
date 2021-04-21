package ui;

import models.Employee;
import models.Poste;
import models.User;
import repositories.manager.MainManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.*;

public class EmployeeScreen {
    public JPanel employeeView;
    public JList<Employee> employeeListView;
    private JTextField lastnameTxt;
    private JButton updateButton;
    private JButton deleteButton;
    private JTextField firstnameTxt;
    private JTextField phoneTxt;
    private JTextField professionTxt;
    private JButton addButton;
    private JLabel lastnameLabel;
    private JLabel firstnameLabel;
    private JLabel phoneLabel;
    private JLabel positionLabel;
    private JComboBox<Poste> positionComboBox;
    private JLabel professionLabel;
    private JLabel bithdayLabel;
    private JSpinner monthSpinner;
    private JSpinner yearSpinner;
    private JSpinner daySpinner;
    private JLabel dayLabel;
    private JLabel yearLabel;
    private JLabel monthLabel;
    private JLabel errorTxt;
    public MainManager mainManager;
    public List<Employee> employees;
    public List<Poste> postes;
    private int posteId = 0;
    private int year = 0;
    private int month = 0;
    private int day = 0;
    private boolean inList = false;
    private DefaultListModel<Employee> employeeModel = new DefaultListModel<>();


    public EmployeeScreen(MainManager mainManager) {

        this.mainManager = mainManager;
        employees = new ArrayList<>();
        postes = new ArrayList<>();

        relaod();

        String[] monthStrings = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; //get month names
        SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
        monthSpinner.setModel(monthModel);

        SpinnerModel yearModel = new SpinnerNumberModel(1980, //initial value
                        1980 - 40, //min
                        19980 + 100, //max
                        1);
        SpinnerModel dayModel = new SpinnerNumberModel(1, //initial value
                        1, //min
                        31, //max
                        1);
        daySpinner.setModel(dayModel);
        yearSpinner.setModel(yearModel);

        employeeListView.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(employeeListView.getSelectedValue() != null){
                    Employee temp = employeeListView.getSelectedValue();
                    LocalDate d = temp.getBirthDayDateFormat();
                    String[] monthStrings = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; //get month names
                    for (Poste t: postes){
                        if(t.getId() == temp.getPosteId()){
                            positionComboBox.setSelectedItem(t);
                        }
                    }
                    lastnameTxt.setText(temp.getLastName());
                    firstnameTxt.setText(temp.getFirstName());
                    phoneTxt.setText(temp.getPhoneNumber());
                    professionTxt.setText(temp.getTitle());
                    daySpinner.setValue(d.getDayOfMonth());
                    monthSpinner.setValue(monthStrings[d.getMonthValue()-1]);
                    yearSpinner.setValue(d.getYear());
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmployee();
            }
        });
        positionComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Poste temp = (Poste) positionComboBox.getSelectedItem();
                if(temp != null){
                    posteId = temp.getId();
                }

            }
        });

        // // mouse listener
        employeeListView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                inList = false;
                super.mouseExited(e);
                System.out.println("mouse out");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                inList = true;
                System.out.println("mouse in");
                super.mouseEntered(e);
            }
        });

        employeeView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click " + inList);
                super.mouseClicked(e);
                if (!inList) {
                    employeeListView.clearSelection();
                    lastnameTxt.setText("");
                    firstnameTxt.setText("");
                    phoneTxt.setText("");
                    professionTxt.setText("");
                    positionComboBox.setSelectedIndex(0);
                }

            }
        });
        monthSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String m = (String) monthSpinner.getValue();
                switch (m){
                    case "January" -> month = Calendar.JANUARY;
                    case "February" -> month = Calendar.FEBRUARY;
                    case "March" -> month = Calendar.MARCH;
                    case "April" -> month = Calendar.APRIL;
                    case "May" -> month = Calendar.MAY;
                    case "June" -> month = Calendar.JUNE;
                    case "July" -> month = Calendar.JULY;
                    case "August" -> month = Calendar.AUGUST;
                    case "September" -> month = Calendar.SEPTEMBER;
                    case "October" -> month = Calendar.OCTOBER;
                    case "November" -> month = Calendar.NOVEMBER;
                    case "December" -> month = Calendar.DECEMBER;
                }
            }
        });
        yearSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                year = (int) yearSpinner.getValue();
            }
        });
        daySpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                day = (int) daySpinner.getValue();
            }
        });

    }

    private void relaod(){
        employees = mainManager.getAllEmployee();
        postes = mainManager.getAllPoste();
        employeeModel.removeAllElements();
        employeeModel.addAll(employees);
        employeeListView.setModel(employeeModel);
        positionComboBox.removeAllItems();
        positionComboBox.addItem(new Poste());
        for(Poste p : postes){
            positionComboBox.addItem(p);
        }
    }

    private void clearLabel(){
        lastnameTxt.setText("");
        firstnameTxt.setText("");
        phoneTxt.setText("");
        professionTxt.setText("");
        positionComboBox.setSelectedIndex(0);
        clearErrorLabel();
    }

    private void clearErrorLabel(){
        errorTxt.setText("");
    }

    private boolean verifieText(String lastname, String firstname, String phone, String profession){
        boolean valid = true;
        if (lastname.trim().length() < 1){
            errorTxt.setText("lastname can't be null");
            valid = false;
        }
        else if (firstname.trim().length() < 1){
            errorTxt.setText("firstname can't be null");
            valid = false;
        }
        else if (phone.trim().length() < 10){
            errorTxt.setText("phone not valid");
            valid = false;
        }
        else if (profession.trim().length() < 1){
            errorTxt.setText("insert profession");
            valid = false;
        }
        else if (positionComboBox.getSelectedIndex() == 0){
            errorTxt.setText("Choose a position");
            valid = false;
        }
        return valid;
    }

    // add a employee to the database
    private void addEmployee(){
        clearErrorLabel();
        String lastname = lastnameTxt.getText();
        String firstname = firstnameTxt.getText();
        String phone = phoneTxt.getText();
        String profession = professionTxt.getText();
        if(verifieText(lastname, firstname, phone, profession)){
            LocalDate d = LocalDate.of(year, month, day);
            Employee e = new Employee(lastname, firstname, phone,d.toEpochDay(), posteId, profession, 30);
            mainManager.insertEmployee(e);
            relaod();
            clearLabel();
        }
    }

    // update a employee to the database
    private void updateEmployee(){
        Employee temp = employeeListView.getSelectedValue();
        clearErrorLabel();
        String lastname = lastnameTxt.getText();
        String firstname = firstnameTxt.getText();
        String phone = phoneTxt.getText();
        String profession = professionTxt.getText();
        if(verifieText(lastname, firstname, phone, profession)){
            LocalDate d = LocalDate.of(year, month, day);
            Employee e = new Employee(lastname, firstname, phone, d.toEpochDay(), posteId, profession, temp.getVacancy_days_remaining());
            mainManager.updateEmployee(e);
            relaod();
            clearLabel();
        }
    }

    // delete employee to the database
    private void deleteEmployee(){
        Employee temp = employeeListView.getSelectedValue();
        mainManager.deleteEmployee(temp.getId());
        relaod();
        clearLabel();
    }


}
