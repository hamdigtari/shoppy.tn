package hamdigtar.DB;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.*;
 import java.util.logging.Logger;

public class DBConnection {
    // load and register JDBC driver for MySQL



    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String DB_NAME = "test_db";

    public static Connection con;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("connection failed hh!");
        }
    }

    public static int checkLogin(String username, String password) {
        Connection con = DBConnection.con;
        if(con == null)
            return -1;

        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setString(1, username);
            prest.setString(2, password);

            ResultSet rs = prest.executeQuery();

            while(rs.next()) {
                return 0;
            }

        } catch(SQLException se) {
            //se.printStackTrace();
            System.out.println("SQL Error !");
        }

        return 1;
    }

}

