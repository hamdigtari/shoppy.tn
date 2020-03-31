package hamdigtar.crudAccount;

import hamdigtar.DB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountService {
    private static AccountService accountServiceInstance;
//    private final Connection cn = DBConnection.con;
    Connection cn = DBConnection.con;

    private AccountService(){}

    public static AccountService getInstance() {   //Singleton Design Pattern
        if (accountServiceInstance==null)
        {
            accountServiceInstance = new AccountService();
        }
        return accountServiceInstance;
    }

    public List<Account> getAllAccounts()
    {

        List<Account> list = new ArrayList<>();
        int count = 0;

        String query="select * from fos_user ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){

                Account r = new Account();
String a =rs.getString(2) ;
                r.setName(a);
            //    r.setNom(rs.getString(4));
                r.setAge(rs.getString(3));
                r.setPassword(rs.getString(8));

              //  r.setDescription(rs.getString(5));
           //     r.setPrix(rs.getDouble(6));
              //  if (rs.getString(12)=="1")
                r.setJob("Admin");

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




    public boolean addAccount(Account account) throws SQLException
    {
        System.out.println(account.getName() + " " + account.getJob());

        PreparedStatement pst = cn.prepareStatement("INSERT INTO fos_user "
                + "(username, email, password)"
                + "VALUES (?,?,?)");

        try
        {
            System.out.println("adding account" + account);
            pst.setString(1,account.getUsername());
            pst.setString(2,account.getEmail());
            pst.setString(3,account.getPassword());
         //   pst.setString(4,account.getJob());

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

    public boolean deleteAccount(Account account)
    {
        String query = "DELETE FROM fos_user WHERE id=?";
        try
        {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, account.getId());
            pst.executeUpdate();
            System.out.println("Deletion successful !");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }


    public boolean updateAccount(Account account)
    {
        System.out.println(account);
        String query = "UPDATE fos_user SET username=? , email=? , password=? ) WHERE id=?";
        try {
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(4,account.getId());

            pst.setString(1,account.getUsername());
            pst.setString(2,account.getEmail());
            pst.setString(3,account.getPassword());


            System.out.println(pst);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return true;
        }
        return false;
    }





}

