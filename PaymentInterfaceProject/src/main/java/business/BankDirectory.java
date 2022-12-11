/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.mysql.MySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nbabu
 */
public class BankDirectory {
    private ArrayList<Bank> bankDirectory = new ArrayList<>();
    public ArrayList<Bank> getBankList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from banks;");
            while(rs.next())
            {
              int id = Integer.parseInt(rs.getString(1));
              String bankName = rs.getString(2);
              String routingNumber = rs.getString(3);
              Bank bank = new Bank(id, bankName, routingNumber);
              bankDirectory.add(bank);
            }
            return bankDirectory;
        }
        catch(SQLException ex)
        {
          System.out.println(ex);
          return null;
        }
        finally
        {
          MySql.shutDownConn();
        }
    }
    public static int addBank(Bank b)
    {
        try
        {
            MySql.createConn();  
            int bankId = b.getId();
            String bankName = b.getName();
            String bankRoutingNumber = b.getRoutingNumber();
            int res = MySql.insertUpdateQuery("insert into banks values(" + bankId + "," + "\'" + bankName + "\'" + "," + "\'" + bankRoutingNumber + "\'" +  ");");
            if(res > 0)
            {
              return res;
            }
            else
                return 0;
        }
        catch(Exception ex)
        {
          System.out.println(ex);
          return 0;
        }
        finally
        {
          MySql.shutDownConn();
        }
    }
    public static int updateBank(Bank b, int position)
    {
        try
        {
            MySql.createConn();  
            int bankId = b.getId();
            String bankName = b.getName();
            String bankRoutingNumber = b.getRoutingNumber();
            int res = MySql.insertUpdateQuery("update banks set id = " + bankId + "," + "name = " + "\'" + bankName + "\'" + "," + "routing_number = " + "\'" + bankRoutingNumber + "\'" + " where id = " + position + ";");
            if(res > 0)
            {
              return res;
            }
            else
                return 0;
        }
        catch(Exception ex)
        {
          System.out.println(ex);
          return 0;
        }
        finally
        {
          MySql.shutDownConn();
        }
    }
    public static int deleteBank(int bankId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from banks where id = " + bankId + ";");
            if(res > 0)
            {
              return res;
            }
            else
                return 0;
        }
        catch(Exception ex)
        {
          System.out.println(ex);
          return 0;
        }
        finally
        {
          MySql.shutDownConn();
        }
    }
    public static ResultSet getBanks()
    {
      try
      {
        MySql.createConn();
        String query = "select * from banks;";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
}
