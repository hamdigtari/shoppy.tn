package projet;

import utils.ConnexionDB;
import java.sql.*;



public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		try {
		Connection c = ConnexionDB.getConnection();
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("select * from users");
		while (r.next()){
			System.out.println(r.getString(2));
		}
		c.close();
	}
		catch(SQLException e) {
			
		}
	}

}
