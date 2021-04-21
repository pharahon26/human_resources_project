package ui;

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
    private JLabel passwordErrTxt;
    private JLabel usernameErrTxt;
    public MainManager mainManager;
    private boolean inList = false;
    List<User> users;
    private final DefaultListModel<User> userModel = new DefaultListModel<>();

    public UserSreen(MainManager mainManager) {
        this.mainManager = mainManager;

        relaod();

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

    private void relaod(){
        // get the user list from the main manager
        users = mainManager.getAllUser();

        // configure list and combo box
        userModel.removeAllElements();
        userModel.addAll(users);
        userListView.setModel(userModel);
    }

    private void clearLabel(){
        usernameTxt.setText("");
        passwordTxt.setText("");
        clearErrorLabel();
    }

    private void clearErrorLabel(){
        usernameErrTxt.setText("");
        passwordErrTxt.setText("");
    }

    private boolean verifieText(String username, String password ){
        boolean valid = true;
        if (username.trim().length() < 4){
            usernameErrTxt.setText("Username should have at least 4 characters");
            valid = false;
        }
        else if (password.trim().length() < 4){
            passwordErrTxt.setText("Password should have at least 4 characters");
            valid = false;
        }
         else {
            for (User user : users){
                if (user.getUsername().equals(username.trim())){
                    usernameErrTxt.setText("Username already taken");
                    valid = false;
                }
            }
        }
        return valid;
    }


    // add a user to the database
    private void addUser(){
        clearErrorLabel();
        String username = usernameTxt.getText();
        String password = passwordTxt.getText();
        if(verifieText(username, password)){
            User u = new User(username, password);
            mainManager.insertUser(u);
            relaod();
            clearLabel();
        }
    }

    // update a user to the database
    private void updateUser(){
        clearErrorLabel();
        User temp = userListView.getSelectedValue();
        String username = usernameTxt.getText();
        String password = passwordTxt.getText();
        if(verifieText(username, password)){
            User u = new User(temp.getId(), usernameTxt.getText(), passwordTxt.getText());
            mainManager.updateUser(u);
            relaod();
            clearLabel();
        }
    }

    // add a user to the database
    private void deteteUser(){
        User temp = userListView.getSelectedValue();
        mainManager.deleteUser(temp.getId());
        relaod();
        clearLabel();
    }
}
