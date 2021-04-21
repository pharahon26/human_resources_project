package ui;

import models.User;
import repositories.manager.MainManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.util.List;

public class Connexion {
    private JTextField passwordTextField;
    private JTextField usernameTextField;
    private JButton connectButton;
    private JLabel usernameFieldLabel;
    private JLabel passwordFieldLabel;
    public JPanel connexionView;
    private JLabel errorLabel;
    public MainManager mainManager;
    static JFrame frame = new JFrame("Connexion");



    public Connexion(MainManager mainManager) {

        this.mainManager = mainManager;

        frame.setContentPane(connexionView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(900, 600);
        frame.setVisible(true);
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = passwordTextField.getText();
                User user = mainManager.connectUser(username);
                if(user.getUsername() == null){
                    errorLabel.setText("User not found");
                }else if(!user.getUsername().equals(username)){
                    errorLabel.setText("Username not found");
                }else if(!user.getPassword().equals(password)){
                    errorLabel.setText("Wrong password");
                }else{
                    frame.dispose();
                    Home home = new Home(mainManager);
                }

            }
        });


    }
}
