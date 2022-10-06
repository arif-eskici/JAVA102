package com.patikadev.Model;

import com.patikadev.Helper.DBConnect;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String uname;
    private String pass;
    private String type;

    public User () {}

    public User(int id, String uname, String pass, String type) {
        this.id = id;
        this.uname = uname;
        this.pass = pass;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        User obj;
        try {
            Statement st = DBConnect.getInstance().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static boolean add (int id, String uname, String pass, String type ) {

        String sql = "INSERT INTO users (id, uname, pass, type) VALUES (?,?,?,?)";

        User findUser = User.getFetch(uname, id);
        if (findUser != null) {
            Helper.showMsg("Bu kullanıcı adı veya id daha önceden kullanılmış. Lütfen farklı bir değer girin!");
            return false;
        }

        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(sql);
            pr.setInt(1, id);
            pr.setString(2, uname);
            pr.setString(3, pass);
            pr.setString(4, type);

            int response  = pr.executeUpdate();
            if (response == -1) {
                Helper.showMsg("error");
            }
            return response != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static User getFetch (String uname, int id) {
        User obj = null;
        String sql1 = "SELECT * FROM users WHERE uname  = ?";
        String sql2 = "SELECT * FROM users WHERE id = ?";
        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(sql1);
            pr.setString(1, uname);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }

            PreparedStatement pr2 = DBConnect.getInstance().prepareStatement(sql2);
            pr2.setInt(1, id);
            ResultSet rs2 = pr2.executeQuery();
            if (rs2.next()) {
                obj = new User();
                obj.setId(rs2.getInt("id"));
                obj.setUname(rs2.getString("uname"));
                obj.setPass(rs2.getString("pass"));
                obj.setType(rs2.getString("type"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static User getFetch (int id) {
        User obj = null;
        String sql2 = "SELECT * FROM users WHERE id = ?";
        try {
            PreparedStatement pr2 = DBConnect.getInstance().prepareStatement(sql2);
            pr2.setInt(1, id);
            ResultSet rs2 = pr2.executeQuery();
            if (rs2.next()) {
                obj = new User();
                obj.setId(rs2.getInt("id"));
                obj.setUname(rs2.getString("uname"));
                obj.setPass(rs2.getString("pass"));
                obj.setType(rs2.getString("type"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static User getFetch (String uname, String pass) {
        User obj = null;
        String sql = "SELECT * FROM users WHERE uname = ? AND pass = ?";
        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(sql);
            pr.setString(1, uname);
            pr.setString(2, pass);

            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                switch (rs.getString("type")) {
                    case "operator":
                        obj = new Operator();
                        break;
                    default:
                        obj = new User();
                }
                obj.setId(rs.getInt("id"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    public static boolean delete (int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        ArrayList<Course> courseList = Course.getListByUser(id);
        for (Course c : courseList) {
            Course.delete(c.getId());

        }
        try {
            PreparedStatement  pr = DBConnect.getInstance().prepareStatement(sql);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean update (int id, String uname, String pass, String type) {
        String sql = "UPDATE users SET  uname = ?, pass = ?, type = ? WHERE id = ?";
        User findUser = User.getFetch(uname, id);
        if (findUser != null && findUser.getId() != id) {
            Helper.showMsg("Bu kullanıcı adı daha önceden eklenmiş. Lütfen farklı bir değer girin!");
            return false;
        }
        try {
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(sql);
            pr.setString(1, uname);
            pr.setString(2, pass);
            pr.setString(3, type );
            pr.setInt(4, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<User> searchUserList (String sql) {
        ArrayList<User> userList = new ArrayList<>();
        User obj;
        try {
            Statement st = DBConnect.getInstance().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static String searchQuery (String uname, String type) {
        String sql = "SELECT * From users WHERE uname ILIKE '%{{uname}}%'";
        sql = sql.replace("{{uname}}", uname);
        if (!type.isEmpty()) {
            sql += " AND type = '{{type}}'";
            sql = sql.replace("{{type}}", type);
        }
        return sql;
    }
}
