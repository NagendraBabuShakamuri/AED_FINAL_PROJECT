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
public class UserDirectory {
    private ArrayList<User> userDirectory = new ArrayList<>();
    public ArrayList<User> getUserList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from users;");
            while(rs.next())
            {
              int userId = rs.getInt(1);
              String userName = rs.getString(2);
              String email = rs.getString(3);
              long mobile = rs.getLong(4);
              String password = rs.getString(5);
              double balance = rs.getDouble(7);
              User user = new User(userId, userName, email, mobile, password, balance);
              userDirectory.add(user);
            }
            return userDirectory;
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
    public static int addUser(User user)
    {
        try
        {
            MySql.createConn();
            String userName = user.getUserName();
            String email = user.getEmail();
            String mobile = String.valueOf(user.getMobile());
            String password = user.getPassword();
            int res = MySql.insertUpdateQuery("insert into users(username, email, mobile, password) values(" + "\'" + userName + "\'" +"," + "\'" + email + "\'" + "," + "\'" + mobile + "\'" + ","  + "\'" + password + "\'" + ");");
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
    public static int updateUser(User user, int position)
    {
        try
        {
            MySql.createConn();  
            String userName = user.getUserName();
            String email = user.getEmail();
            String mobile = String.valueOf(user.getMobile());
            String password = user.getPassword();
            int res = MySql.insertUpdateQuery("update users set username = " + "\'" + userName + "\'" +  ", email =  " + "\'" + email + "\'" + ", mobile =  " + "\'" + mobile + "\'" + ", password = " + "\'" + password + "\'" + " where userid = " + position + ";");
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
    public static int updateBalance(int userId, double amount)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("update users set balance = " + amount + " where userid = " + userId + ";");
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
    public static ResultSet getUserId(String userName)
    {
      try
      {
        MySql.createConn();
        String query = "select userid from users where username = " + "\'" + userName + "\'" + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }      
    }
    public static ResultSet getUserIdNameEmail()
    {
      try
      {
        MySql.createConn();
        String query = "select userid, username, email from users;";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }      
    }
    public static int addMoney(double money, String userName)
    {
      try
      {
        MySql.createConn();
        String query = "update users set balance = balance + " + money + " where username = " + "\'" + userName + "\'" + ";";
        int res = MySql.insertUpdateQuery(query);
        return res;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return 0;
      }      
    }
    public static ResultSet getBalance(String userName)
    {
      try
      {
        MySql.createConn();
        String query = "select balance from users where username = " + "\'" + userName + "\'" + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }      
    }
    public static ResultSet getMobileBalance(String userName)
    {
      try
      {
        MySql.createConn();
        String query = "select mobile, balance from users where username = " + "\'" + userName + "\'" + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }      
    }
    public static ResultSet getUserName(String mobile)
    {
      try
      {
        MySql.createConn();
        String query = "select username from users where mobile = " + "\'" + mobile + "\'" + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }      
    }
    public static int deductMoney(double money, String userName)
    {
      try
      {
        MySql.createConn();
        String query = "update users set balance = balance - " + money + " where username = " + "\'" + userName + "\'" + ";";
        int res = MySql.insertUpdateQuery(query);
        return res;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return 0;
      }      
    }
    public static int deductMoneyMobile(double money, String mobile)
    {
      try
      {
        MySql.createConn();
        String query = "update users set balance = balance + " + money + " where mobile = " + "\'" + mobile + "\'" + ";";
        int res = MySql.insertUpdateQuery(query);
        return res;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return 0;
      }      
    }
    public static int insertTransaction(String sender, String receiver, double amount)
    {
      try
      {
        MySql.createConn();
        String query = "INSERT INTO transfer_money(sender, receiver, amount) values(" + "\'" + sender + "\'" + "," + "\'" + receiver + "\'" + "," + amount + ");";
        int res = MySql.insertUpdateQuery(query);
        return res;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return 0;
      }      
    }
    public static ResultSet getUtilityTransactions(String userName)
    {
      try
      {
        MySql.createConn();
        String query = "select * from utility_transaction where username = " + "\'" + userName + "\'" + ";";
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
