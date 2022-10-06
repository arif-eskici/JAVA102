package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_uname;
    private JPasswordField fld_pass;
    private JButton btn_login;

    public LoginGUI () {
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_uname) || Helper.isFieldEmpty(fld_pass)) {
                Helper.showMsg("fill");
            } else {
                User u = User.getFetch(fld_uname.getText(), fld_pass.getText());
                if (u == null) {
                    Helper.showMsg("Kullanıcı Bulunamadı !");
                } else {
                    switch (u.getType()) {
                        case "operator":
                            OperatorGUI opGUI = new OperatorGUI((Operator) u);
                            break;
                        case "educator":
                            EducatorGUI edGUI = new EducatorGUI();
                            break;
                        case "student":
                            StudentGUI stGUI = new StudentGUI();
                            break;
                    }
                    dispose();

                }

            }

        });
    }

    public static void main(String[] args) {
        LoginGUI login = new LoginGUI();
    }
}
