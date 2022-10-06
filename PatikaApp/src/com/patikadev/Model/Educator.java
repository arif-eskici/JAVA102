package com.patikadev.Model;

import com.patikadev.Helper.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Educator {

    private int id;
    private String eduName;
    private String eduLength;
    private String educator;

    public Educator() { }

    public Educator(int id, String eduName, String eduLength, String educator) {
        this.id = id;
        this.eduName = eduName;
        this.eduLength = eduLength;
        this.educator = educator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    public String getEduLength() {
        return eduLength;
    }

    public void setEduLength(String eduLength) {
        this.eduLength = eduLength;
    }

    public String getEducator() {
        return educator;
    }

    public void setEducator(String educator) {
        this.educator = educator;
    }

    public static ArrayList<Educator> getList() {
        ArrayList<Educator> eduList = new ArrayList<>();
        String sql = "SELECT * FROM education";
        Educator obj;
        try {
            Statement st = DBConnect.getInstance().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obj = new Educator();
                obj.setId(rs.getInt("id"));
                obj.setEduName(rs.getString("eduName"));
                obj.setEduLength(rs.getString("eduLength"));
                obj.setEducator(rs.getString("educator"));
                eduList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return eduList;
    }

    public static boolean add (String eduName, String eduLength, String educator) {
        String sql = "INSERT INTO education (eduName, eduLength, educator) VALUES (?, ?, ?)";
        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(sql);
            pr.setString(1, eduName);
            pr.setString(2, eduLength);
            pr.setString(3, educator);
            return pr.executeUpdate() != -1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
