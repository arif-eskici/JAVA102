package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnect {
    public static final String DB_URL = "jdbc:postgresql://localhost/dvdrental";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "12345";

    public static void main(String[] args) throws SQLException {
        Connection connect = null;
        String stSql = "UPDATE film SET title = 'Ace naberr' WHERE film_id = 2";
        String prSql = "UPDATE film SET title = ? WHERE film_id = ?";
        String sql = "SELECT * FROM film";
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //Statement st = connect.createStatement();
            //st.executeQuery(stSql);

            PreparedStatement pr = connect.prepareStatement(prSql);
            pr.setInt(2, 2); 
            pr.setString(1, "İnek ŞABAN");     
            pr.executeUpdate();     

            //st.close();
            connect.close();
            pr.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
