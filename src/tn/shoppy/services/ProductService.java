package tn.shoppy.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import tn.shoppy.model.Product;
import tn.shoppy.utils.ConnectionDB;

/**
 *
 * @author anas fattoum
 */
public class ProductService {
    
    private static ProductService productServiceInstance;
    private final Connection cn = ConnectionDB.getCnx();
    
    private ProductService(){}
       
    public static ProductService getInstance() {   //Singleton Design Pattern
        if (productServiceInstance==null)
        {
            productServiceInstance = new ProductService();
        }
        return productServiceInstance;  
    }
    
    public List<Product> getAllProduct() 
    {
        List<Product> list = new ArrayList<>();
        int count = 0;
        
        String query="select * from produit ";
        try{
            PreparedStatement st = (PreparedStatement)  cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                
                Product r = new Product();
                r.setId(rs.getInt(1));
                //id_magasin 2
                r.setNom(rs.getString(4));
                r.setQuantite(rs.getInt(3));
                r.setDescription(rs.getString(5));
                r.setPrix(rs.getDouble(6));
                r.setMarque(rs.getString(7));

                list.add(r);
                count++;
            }
            if(count == 0)
            {
                return null;
            }
            else
            {
               return list;
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
   
    

    public boolean addProduct(Product product) throws SQLException
    {
        System.out.println(product.getNom() + " " + product.getId());
        
        PreparedStatement pst = cn.prepareStatement("INSERT INTO produit VALUES (?,?,?,?,?,?,?,?)");
            
        try
        {
            System.out.println("adding product"+product);
            pst.setInt(1,product.getId());
            pst.setInt(2,product.getId_magasin());
            pst.setInt(3,product.getQuantite());
            pst.setString(4,product.getNom());
            pst.setString(5,product.getDescription());
            pst.setDouble(6,product.getPrix());
            pst.setString(7,product.getMarque());
            pst.setDate(8,product.getUpdated_at());
            
            System.out.println(pst);
            pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            return false;
        }
        return true;        
    }
    
    public boolean deleteProduct(Product product)
    {
        String query = "DELETE FROM Produit WHERE id=?";
        try 
        {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, product.getId());
            pst.executeUpdate();
            System.out.println("Deletion successful !");
        } 
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    
    public boolean updateProduct(Product product)
    {
        System.out.println(product);
        String query = "UPDATE Produit SET nom=?,quantite=?,description=?,prix=?,marque=? WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1,product.getId());
            pst.setInt(2,product.getId_magasin());
            pst.setInt(3,product.getQuantite());
            pst.setString(4,product.getNom());
            pst.setString(5,product.getDescription());
            pst.setDouble(6,product.getPrix());
            pst.setString(7,product.getMarque());
            pst.setDate(8,product.getUpdated_at());
            
            System.out.println(pst);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return true;
        }       
        return false;
    }

    
    
}
