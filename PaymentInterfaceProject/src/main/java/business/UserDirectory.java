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
    private static ArrayList<User> userDirectory = new ArrayList<>();
    public static ArrayList<User> getUserList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from users;");
            while(rs.next())
            {
              String userName = rs.getString(2);
              String email = rs.getString(3);
              long mobile = Long.parseLong(rs.getString(4));
              String password = rs.getString(5);
              User user = new User(userName, email, mobile, password);
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
}
