package ui;

import models.Employee;
import models.Poste;
import repositories.manager.MainManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.List;

public class PosteScreen {
    private JList<Poste> posteList;
    private JTextField titleFieldTextField;
    private JButton updateButton;
    private JTextField salaryTextField;
    private JTextField workTimeTextField;
    private JButton deleteButton;
    private JLabel titleFieldLabel;
    private JLabel workTimeFieldLabel;
    private JLabel salaryFieldLabel;
    private JLabel superiorFieldLabel;
    private JLabel infriorFieldLabel;
    public JPanel posteView;
    private JButton addButton;
    private JLabel positionsLabel;
    private JComboBox<Poste> posteInf;
    private JComboBox<Poste> posteSup;
    public MainManager mainManager;
    private int posteSupId = 0;
    private int posteInfId = 0;
    private boolean inList = false;

    public PosteScreen(MainManager mainManager) {
        this.mainManager = mainManager;
        // get the poste list from the main manager
        List<Poste> postes = mainManager.getAllPoste() ;

        // configure list and combo box
        DefaultListModel<Poste> posteModel = new DefaultListModel<>();
        posteModel.addAll(postes);
        posteList.setModel(posteModel);
        posteSup.addItem(new Poste());
        posteInf.addItem(new Poste());
        for(Poste p : postes){
            posteSup.addItem(p);
            posteInf.addItem(p);
        }

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detetePoste();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePoste();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPoste();
            }
        });

        posteList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if(posteList.getSelectedValue() != null){
                    Poste temp = posteList.getSelectedValue();
                    if(temp.getUpPosteId()>=1){
                        for (Poste t: postes){
                            if(t.getId() == temp.getUpPosteId()){
                                posteSup.setSelectedItem(t);
                            }
                        }
                    }
                    if(temp.getDownPosteId()>=1){
                        for (Poste t: postes){
                            if(t.getId() == temp.getDownPosteId()){
                                posteInf.setSelectedItem(t);
                            }
                        }
                    }
                    String s = String.valueOf(temp.getSalary());
                    String w = String.valueOf(temp.getWorkTimeHoursByDay());
                    titleFieldTextField.setText(temp.getTitle());
                    salaryTextField.setText(s);
                    workTimeTextField.setText(w);
                }

            }
        });

        posteInf.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Poste tempInf = (Poste) posteInf.getSelectedItem();
                posteInfId = tempInf.getId();
            }
        });
        posteSup.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Poste tempSup = (Poste) posteSup.getSelectedItem();
                posteSupId = tempSup.getId();
            }
        });

        posteList.addMouseListener(new MouseAdapter() {
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
        posteView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click " + inList);
                super.mouseClicked(e);
                if (!inList) {
                    posteList.clearSelection();
                    titleFieldTextField.setText("");
                    salaryTextField.setText("");
                    workTimeTextField.setText("");
                    posteInf.setSelectedIndex(0);
                    posteSup.setSelectedIndex(0);
                    System.out.println("click out");
                }

            }
        });
    }

    // add a poste to the database
    private void addPoste(){


        Poste p = new Poste(posteSupId, posteInfId, Double.parseDouble(salaryTextField.getText()), titleFieldTextField.getText(), Integer.parseInt(workTimeTextField.getText()) );
        mainManager.insertPoste(p);
    }

    // update a poste to the database
    private void updatePoste(){
        Poste temp = posteList.getSelectedValue();

        Poste p = new Poste( temp.getId(),posteSupId, posteInfId, Double.parseDouble(salaryTextField.getText()), titleFieldTextField.getText(), Integer.parseInt(workTimeTextField.getText()) );
        mainManager.updatePoste(p);
    }

    // add a poste to the database
    private void detetePoste(){
        Poste temp = posteList.getSelectedValue();
        mainManager.deletePoste(temp.getId());
    }

}
