package com.patikadev.Model;

import com.patikadev.Helper.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {
    private int id;
    private String pname;

    public Patika(int id, String pname) {
        this.id = id;
        this.pname = pname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public static ArrayList<Patika> getList() {
        ArrayList<Patika> patikaList = new ArrayList<>();
        Patika obj;

        try {
            Statement st = DBConnect.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patika");
            while (rs.next()) {
                obj = new Patika(rs.getInt("id"), rs.getString("pname"));
                patikaList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patikaList;
    }

    public static boolean add (String pname) {
        String sql = "INSERT INTO patika (pname) VALUES (?)";
        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(sql);
            pr.setString(1, pname);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update (int id, String pname) {
        String sql = "UPDATE patika SET pname = ? WHERE id = ?";
        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(sql);
            pr.setString(1, pname);
            pr.setInt(2, id);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Patika getFetch (int id) {
        Patika obj = null;
        String sql = "SELECT * FROM patika WHERE id = ?";

        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(sql);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Patika(rs.getInt("id"), rs.getString("pname"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static boolean delete (int id) {
        String sql = "DELETE FROM patika WHERE id = ?";
        ArrayList<Course> courseList = Course.getList();
        for (Course obj : courseList) {
            if(obj.getPatika().getId() == id) {
                Course.delete(obj.getId());
            }
        }
        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(sql);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
           throwables.printStackTrace();
        }
        return true;
    }

}
