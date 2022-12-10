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
}
