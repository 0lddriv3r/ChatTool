package com.company.zhuojiaoshou;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    private JTextField txtUser = new JTextField();
    private JPasswordField txtPass = new JPasswordField();

    // constructor
    public Login() {
        this.setSize(300, 125);

        JLabel labUser = new JLabel("UserName");
        JLabel labPass = new JLabel("PassWord");

        JButton btnLogin = new JButton("Login");
        JButton btnRegister = new JButton("Register");
        JButton btnCancel = new JButton("Cancel");

        // register event listener
        btnLogin.addActionListener(this);
        btnRegister.addActionListener(this);
        btnCancel.addActionListener(this);

        // set layout of input
        JPanel panInput = new JPanel();
        panInput.setLayout(new GridLayout(2, 2));

        panInput.add(labUser);
        panInput.add(txtUser);

        panInput.add(labPass);
        panInput.add(txtPass);

        // set layout of button
        JPanel panButton = new JPanel();
        panButton.setLayout(new FlowLayout());

        panButton.add(btnLogin);
        panButton.add(btnRegister);
        panButton.add(btnCancel);

        // set layout of frame
        this.setLayout(new BorderLayout());

        this.add(panInput, BorderLayout.NORTH);
        this.add(panButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            String user = txtUser.getText();
            String pass = txtPass.getText();
            if (user.equals("zhuojiaoshou") && pass.equals("LearnJavaWithEva")) {
                Main m = new Main();
                m.setVisible(true);
                this.setVisible(false);
            }
        }
        if (e.getActionCommand().equals("Register")) {
            System.out.println("Register");
        }
        if (e.getActionCommand().equals("Cancel")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
    }
}
