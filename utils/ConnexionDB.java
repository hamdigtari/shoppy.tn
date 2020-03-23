package utils;
import java.sql.*;
import com.mysql.*;
public class ConnexionDB {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		return conn!=null?conn:getConnection("pidev","pidev","/|*v3aMx%U");
	}
	
	private static Connection getConnection(String db, String user, String password) {
		try {
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pidev",user,password);
	}
		catch(SQLException e) {
			System.out.println("ERROR : Couldn't connect to DB");
		}
	
		return conn;

	}
}
