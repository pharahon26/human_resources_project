package ui;

import repositories.manager.MainManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class Connexion {
    private JTextField passwordTextField;
    private JTextField usernameTextField;
    private JButton connectButton;
    private JLabel usernameFieldLabel;
    private JLabel passwordFieldLabel;
    public JPanel connexionView;
    public MainManager mainManager;



    public Connexion(MainManager mainManager) {

        this.mainManager = mainManager;

//        final Home.homeInterface hi = homeInterface.;
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainManager.connectUser(usernameTextField.getText(), passwordTextField.getText());
                Home home = new Home(mainManager);
            }
        });


    }
}
