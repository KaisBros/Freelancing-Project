package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:freelance_management.db");
                System.out.println("Kết nối thành công!");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Kết nối thất bại!");
                e.printStackTrace();
            } /*finally {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }*/
        }
        return conn;
    }
}
