package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JButton btn_logout;
    private JTable table1;
    private JComboBox comboBox1;
    private JButton btn_add;
    private JLabel lbl_welcome;

    public StudentGUI (){
        add(wrapper);
        setSize(500,400);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);


        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI login = new LoginGUI();

        });
        btn_add.addActionListener(e -> {
            Helper.showMsg("done");

        });
    }

    public static void main(String[] args) {
        StudentGUI stu = new StudentGUI();
    }
}
