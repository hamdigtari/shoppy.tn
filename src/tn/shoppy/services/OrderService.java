/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.shoppy.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import tn.shoppy.model.Order;
import tn.shoppy.model.Shop;
import tn.shoppy.utils.ConnectionDB;

/**
 *
 * @author asus
 */
public class OrderService {
      private static OrderService orderServiceInstance;
    private final Connection cn = ConnectionDB.getCnx();
  
    public boolean DeleteOrder()
    {
        System.out.println("tn.shoppy.services.OrderService.DeleteOrder()");
        return true;
    }
     public static OrderService getInstance() {   //Singleton Design Pattern
        if (orderServiceInstance==null)
        {
            orderServiceInstance = new OrderService();
        }
        return orderServiceInstance ;  
//        return new ShopService();
    }
        
        
    public List<Order> getAllShops() 
    {
        List<Order> list = new ArrayList<>();
        int count = 0;
        
        String query="select * from commande ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                
                Order r = new Order();
                r.setIdCmd(rs.getInt(1));
                r.setTotal(rs.getFloat(2));
                r.setQteTot(rs.getInt(3));
                r.setAdresseLiv(rs.getString(5));
                r.setId_Acheteur(rs.getInt(6));
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
//            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
    /**
     *  This method is used to add a shop to the dataBase. Call it in the
     * ShopController class. 
     * DISCLAIMER: the input checking must be done BEFORE using this methods.
     * @param 
     * @param 
     * @return true if the operation is successful and false otherwise.
     */
    public boolean addOrder(Order order)
    {
        System.out.println(order.getIdCmd() + " " + order.getTotal());

        String query = "INSERT INTO Commande (QteTot,total,adresseLiv) VALUES (?,?)";      
        try
        {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, order.getAdresseLiv());
            pst.setInt(2, order.getQteTot()); 
            pst.setFloat(2, order.getTotal()); 
       
            pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
        //TODO ajouter le false si jamais on veut ajouter une condition d'unicité sur le nom du magasin.
        
    }
      public boolean deleteOrder(Order order)
    {
        String query = "DELETE FROM Commande WHERE id=?";
        try 
        {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, order.getIdCmd());
            pst.executeUpdate();
            System.out.println("suppression ,succes !");
        } 
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
      /* find method */
        public List<Order> findOrders(String input) {  
        HashSet<Order> cleanResult = new HashSet<>();
        List<Order> r1 = findOrdersByQte(input);
        List<Order> r2 = findOrdersByTotal(input);
        List<Order> r3 = findOrdersByID(input);

        if(r1 != null){
            cleanResult.addAll(r1);
        }
        if(r2 != null){
            cleanResult.addAll(r2);
        }
        if(r3 != null){
            cleanResult.addAll(r3);
        }
        List<Order> result = new ArrayList<>(cleanResult);
        return result;
    }
    
public List<Order> findOrdersByQte(String qt) {  
     List<Order> list = new ArrayList<>();
        int count = 0;
        String query="select * from Commande where  convert(QteTot,CHARACTER)  like '%"+qt+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                
                 Order r = new Order();
                r.setIdCmd(rs.getInt(1));
                r.setTotal(rs.getFloat(2));
                r.setQteTot(rs.getInt(3));
                r.setAdresseLiv(rs.getString(4)); 
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
    
    public List<Order> findOrdersByTotal(String total) {
        List<Order> list = new ArrayList<>();
        int count = 0;
        String query = "SELECT * FROM commande WHERE convert(total,CHARACTER) like '%" + total + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                
                 Order r = new Order();
                r.setIdCmd(rs.getInt(1));
                r.setTotal(rs.getFloat(2));
                r.setQteTot(rs.getInt(3));
                r.setAdresseLiv(rs.getString(4)); 
                list.add(r);
                count++;
            }
            if (count == 0) {
                return null;
            } else {
                return list;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
        public List<Order> findOrdersByID(String ID) {
        List<Order> list = new ArrayList<>();
        int count = 0;
        String query = "SELECT * FROM commande WHERE convert(id,CHARACTER) like '%" + ID + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Order r = new Order();
                r.setIdCmd(rs.getInt(1));
                r.setTotal(rs.getFloat(2));
                r.setQteTot(rs.getInt(3));
                r.setAdresseLiv(rs.getString(4)); 
                list.add(r);
                count++;
            }
            if (count == 0) {
                return null;
            } else {
                return list;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
