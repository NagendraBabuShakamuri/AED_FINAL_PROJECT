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
public class AddressRequestDirectory {
    private ArrayList<AddressRequest> addressRequestDirectory = new ArrayList<>();
    public ArrayList<AddressRequest> getAddressRequestList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from address_requests;");
            while(rs.next())
            {
              int id = rs.getInt(1);
              int userId = rs.getInt(2);
              String apartment = rs.getString(3);
              String street = rs.getString(4);
              String city = rs.getString(5);
              String state = rs.getString(6);
              String zipCode = rs.getString(7);
              String status = rs.getString(8);
              ResultSet rs1 = MySql.selectQuery("select * from users where userid = " + userId + ";");
              rs1.next();
              int userid = rs1.getInt(1);
              String userName = rs1.getString(2);
              String email = rs1.getString(3);
              long mobile = rs1.getLong(4);
              String password = rs1.getString(5);
              double balance = rs1.getDouble(7);
              User user = new User(userid, userName, email, mobile, password, balance);
              AddressRequest ar = new AddressRequest(id, user, apartment, street, city, state, zipCode, status);
              addressRequestDirectory.add(ar);
            }
            return addressRequestDirectory;
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
    public static int updateStatusToInProgress(int requestId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("update address_requests set status = " + "\'" + "In Progress" + "\'"  + " where id = " + requestId +";");
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
    public static int updateStatusToApproved(Address a, int requestId)
    {
        try
        {
            MySql.createConn();
            int res = AddressDirectory.addAddress(a);
            MySql.createConn();
            if(res > 0)
            {
              int res1 = MySql.insertUpdateQuery("update address_requests set status = " + "\'" + "Approved" + "\'"  + " where id = " + requestId +";");
              if(res1 > 0)
              {
                return res;
              }
              else
                return 0;
            }
            else
            {
              int res2 = AddressDirectory.updateAddress(a);
              MySql.createConn();
              if(res2 > 0)
              {
                int res1 = MySql.insertUpdateQuery("update address_requests set status = " + "\'" + "Approved" + "\'"  + " where id = " + requestId +";");
                if(res1 > 0)
                {
                  return res1;
                }
                else
                  return 0;
              }
              return 0; 
            }                         
        }
        catch(Exception ex)
        {
          return 0;
        }
        finally
        {
          MySql.shutDownConn();
        }
    }
    public static int updateStatusToDenied(int requestId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("update address_requests set status = " + "\'" + "Denied" + "\'"  + " where id = " + requestId +";");
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
