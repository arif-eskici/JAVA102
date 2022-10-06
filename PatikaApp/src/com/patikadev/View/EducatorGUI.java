package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Educator;
import com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JButton btn_logout;
    private JPanel wbottom;
    private JTable tbl_education;
    private JTextField fld_edu_name;
    private JTextField fld_edu_length;
    private JTextField fld_educator;
    private JButton btn_add;
    private DefaultTableModel mdl_edu_list;
    private Object[] row_edu_list;

    public EducatorGUI () {
        add(wrapper);
        setSize(500,400);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        mdl_edu_list = new DefaultTableModel() {};
        Object[] col_edu_list = {"ID", "Eğitim Adı", "Eğitim Süresi", "Eğitim Sorumlusu"};
        mdl_edu_list.setColumnIdentifiers(col_edu_list);
        row_edu_list = new Object[col_edu_list.length];
        loadEducatorModel();

        tbl_education.setModel(mdl_edu_list);
        tbl_education.getColumnModel().getColumn(0).setMaxWidth(30);
        tbl_education.getTableHeader().setReorderingAllowed(false);

        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI login = new LoginGUI();
        });

        btn_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_edu_name) || Helper.isFieldEmpty(fld_edu_length) || Helper.isFieldEmpty(fld_educator)) {
                Helper.showMsg("fill");
            } else {
                Educator.add(fld_edu_name.getText(), fld_edu_length.getText(), fld_educator.getText());
                Helper.showMsg("done");
                loadEducatorModel();
                fld_edu_name.setText(null);
                fld_edu_length.setText(null);
            }
        });
    }

    private void loadEducatorModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_education.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Educator obj : Educator.getList()) {
            i = 0;
            row_edu_list [i++] = obj.getId();
            row_edu_list [i++] = obj.getEduName();
            row_edu_list [i++] = obj.getEduLength();
            row_edu_list [i++] = obj.getEducator();
            mdl_edu_list.addRow(row_edu_list);
        }
    }

    public static void main(String[] args) {
        EducatorGUI ed = new EducatorGUI();
    }
}
