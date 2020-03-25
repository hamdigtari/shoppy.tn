
package InteractionDB;
import java.sql.*;
import utils.ConnexionDB;
import Entities.Ticket;
/**
 *
 * @author os
 */
    


public class Interaction_Points {
    
    
	public static boolean ajouter( Ticket t) { //temporary -> arg = Ticket
		try {
			Connection c = ConnexionDB.getConnection();
			PreparedStatement s = c.prepareStatement("insert into tickets (portfolio_id, montant, date_exp) values(?,?,?)");
			s.setInt(1, t.getPortfolio_id());
			s.setInt(2, t.getMontant());
			Date d=new Date(System.currentTimeMillis());
			s.setDate(3, d);
			s.executeUpdate(); //insertion + nombre de ligne insérées
			
			c.close();
			
			return true;
		}
		catch(SQLException e) {
			return false;
		}
	}

        
        public static boolean supprimer(int id) { //temporary -> arg = Ticket
		try {
			Connection c = ConnexionDB.getConnection();
			PreparedStatement s = c.prepareStatement("delete from tickets where id=?");
			s.setInt(1, id);
			s.executeUpdate(); //insertion + nombre de ligne insérées
			
			c.close();
			
			return true;
		}
		catch(SQLException e) {
			return false;
		}
	}
        
        
        
        
        
        
        public static boolean modifier( Ticket t) { //temporary -> arg = Ticket
		try {
			Connection c = ConnexionDB.getConnection();
			PreparedStatement s = c.prepareStatement("update tickets set portfolio_id=?, montant=?, date_exp=? where id=?");
			s.setInt(1, t.getPortfolio_id());
			s.setInt(2, t.getMontant());
			s.setDate(3, t.getDate_exp());
			s.executeUpdate(); //insertion + nombre de ligne insérées
			
			c.close();
			
			return true;
		}
		catch(SQLException e) {
			return false;
		}
	}
        
        public static ResultSet getAllTickets(){
            ResultSet r = null;
            try {
		Connection c = ConnexionDB.getConnection();
		Statement s = c.createStatement();
		r=s.executeQuery("select * from tickets");
		
	}
		catch(SQLException e) {
			
		}
            
            return r;
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
}

