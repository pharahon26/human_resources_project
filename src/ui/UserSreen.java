package ui;

import models.Poste;
import models.User;
import repositories.manager.MainManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UserSreen {
    public JPanel userView;
    private JList<User> userListView;
    private JTextField usernameTxt;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTextField passwordTxt;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JLabel usersLabel;
    public MainManager mainManager;
    private boolean inList = false;

    public UserSreen(MainManager mainManager) {
        this.mainManager = mainManager;

        // get the user list from the main manager
        List<User> users = mainManager.getAllUser() ;

        // configure list and combo box
        DefaultListModel<User> userModel = new DefaultListModel<>();
        userModel.addAll(users);
        userListView.setModel(userModel);

        // button listener update
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });
        // button listener add
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });
        // button listener delete
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deteteUser();
            }
        });
        // list listener
        userListView.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(userListView.getSelectedValue() != null){
                    User temp = userListView.getSelectedValue();
                    String u = String.valueOf(temp.getUsername());
                    String p = String.valueOf(temp.getPassword());
                    usernameTxt.setText(u);
                    passwordTxt.setText(p);
                }
            }
        });

        // // mouse listener
        userListView.addMouseListener(new MouseAdapter() {
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

        userView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click " + inList);
                super.mouseClicked(e);
                if (!inList) {
                    userListView.clearSelection();
                    passwordTxt.setText("");
                    usernameTxt.setText("");
                }

            }
        });
    }

    // add a user to the database
    private void addUser(){

        User u = new User(usernameTxt.getText(), passwordTxt.getText());
        mainManager.insertUser(u);
    }

    // update a user to the database
    private void updateUser(){
        User temp = userListView.getSelectedValue();

        User u = new User(usernameTxt.getText(), passwordTxt.getText());
        mainManager.updateUser(u);
    }

    // add a user to the database
    private void deteteUser(){
        User temp = userListView.getSelectedValue();
        mainManager.deleteUser(temp.getId());
    }
}
