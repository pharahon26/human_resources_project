package ui;

import models.Poste;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PosteScreen {
    private JTextArea posteScreeTxt;
    private JList<Poste> posteList;
    private JTextField titleFieldTextField;
    private JButton actionButton;
    private JTextField superiorTextField;
    private JTextField inferiorTextField;
    private JTextField salaryTextField;
    private JTextField workTimeTextField;
    private JButton newPosteButton;
    private JLabel titleFieldLabel;
    private JLabel workTimeFieldLabel;
    private JLabel salaryFieldLabel;
    private JLabel superiorFieldLabel;
    private JLabel infriorFieldLabel;
    public JPanel posteView;

    public PosteScreen() {
        newPosteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
