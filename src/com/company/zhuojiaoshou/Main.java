package com.company.zhuojiaoshou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main extends JFrame implements ActionListener {

    private JTextField txtMess = new JTextField();
    private JComboBox cmbUser = new JComboBox();
    private JTextArea txtContent = new JTextArea();

    public Main() {
        this.setSize(300, 400);

        JButton btnSend = new JButton("Send");

        JScrollPane spContent = new JScrollPane(txtContent);

        btnSend.addActionListener(this);

        JPanel panSmall = new JPanel();
        panSmall.setLayout(new GridLayout(1, 2));

        panSmall.add(cmbUser);
        panSmall.add(btnSend);

        JPanel panBig = new JPanel();
        panBig.setLayout(new GridLayout(2, 1));

        panBig.add(txtMess);
        panBig.add(panSmall);

        this.add(panBig, BorderLayout.NORTH);
        this.add(spContent, BorderLayout.SOUTH);

        try {
            File f = new File("ChatHistory.chat");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                txtContent.append(br.readLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // txtMess -> txtContent
        txtContent.append(txtMess.getText() + "\n");

        // txtMess -> ChatHistory
        try {
            File f = new File("ChatHistory.chat");
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(txtMess.getText());

            pw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // clear
        txtMess.setToolTipText("");
    }
}
