package utils;
import java.sql.*;
import java.util.Calendar;


public class InterractionDB_points {
	public static boolean ajouterpoints( int userid,  int points) {
		try {
			Connection c = ConnexionDB.getConnection();
			PreparedStatement s = c.prepareStatement("insert into points values(?,?,?");
			s.setInt(1, 1);
			s.setInt(2, 500);
			Date d; Calendar cc;
			s.setDate(3, d, cc);
			int i = s.executeUpdate(); //insertion + nombre de ligne insérées
			
			c.close();
			
			return true;
		}
		catch(SQLException e) {
			return false;
		}
	}

}
