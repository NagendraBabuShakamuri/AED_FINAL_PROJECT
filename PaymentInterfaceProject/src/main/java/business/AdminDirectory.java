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
public class AdminDirectory {
    private ArrayList<Admin> adminDirectory = new ArrayList<>();
    public ArrayList<Admin> getAdminList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from admin;");
            while(rs.next())
            {
              int id = rs.getInt(1);
              String roleName = rs.getString(2);
              String userName = rs.getString(3);
              String password = rs.getString(4);
              Admin admin = new Admin(id, roleName, userName, password);
              adminDirectory.add(admin);
            }
            return adminDirectory;
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
    public static int addAdmin(Admin admin)
    {
        try
        {
            MySql.createConn();
            int adminId = admin.getId();
            String role = admin.getRole();            
            String userName = admin.getUserName();
            String password = admin.getPassword();
            int res = MySql.insertUpdateQuery("insert into admin(id, role, user_name, password) values(" + adminId + "," + "\'" + role + "\'" + "," + "\'" + userName + "\'" + "," + "\'" + password + "\'" + ");");
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
    public static int updateAdmin(Admin admin, int position)
    {
        try
        {
            MySql.createConn();  
            int adminId = admin.getId();
            String role = admin.getRole();            
            String userName = admin.getUserName();
            String password = admin.getPassword();
            int res = MySql.insertUpdateQuery("update admin set id = " + adminId + "," + "role = " + "\'" + role + "\'" + "," + "user_name = " + "\'" + userName + "\'" + "," + "password = " + "\'" + password + "\'" + " where id = " + position + ";");
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
    public static int deleteAdmin(int adminId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from admin where id = " + adminId + ";");
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
