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
public class AddressDirectory {
    private ArrayList<Address> addressDirectory = new ArrayList<>();
    public ArrayList<Address> getAddressList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from addresses;");
            while(rs.next())
            {
              int userId = rs.getInt(1);
              String apartment = rs.getString(2);
              String street = rs.getString(3);
              String city = rs.getString(4);
              String state = rs.getString(5);
              String zipCode = rs.getString(6);
              ResultSet rs1 = MySql.selectQuery("select * from users where userid = " + userId + ";");
              rs1.next();
              int userid = rs1.getInt(1);
              String userName = rs1.getString(2);
              String email = rs1.getString(3);
              long mobile = rs1.getLong(4);
              String password = rs1.getString(5);
              double balance = rs1.getDouble(7);
              User user = new User(userid, userName, email, mobile, password, balance);
              Address a = new Address(user, apartment, street, city, state, zipCode);
              addressDirectory.add(a);
            }
            return addressDirectory;
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
    public static int addAddress(Address a)
    {
        try
        {
            MySql.createConn();
            int userId = a.getUser().getId();
            String apartment = a.getApartment();
            String street = a.getStreet();
            String city = a.getCity();
            String state = a.getState();
            String zipCode = a.getZipCode();
            int res = MySql.insertUpdateQuery("insert into addresses(user_id, apartment, street, city, state, zipcode) values(" + userId + "," + "\'" +apartment + "\'" +"," + "\'" + street + "\'" + "," + "\'" + city + "\'" + "," + "\'" + state + "\'" + "," + "\'" + zipCode + "\'" + ");");
            if(res > 0)
            {
              return res;
            }
            else
              return 0;
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
    public static int updateAddress(Address a)
    {
        try
        {
            MySql.createConn();
            int userId = a.getUser().getId();
            String apartment = a.getApartment();
            String street = a.getStreet();
            String city = a.getCity();
            String state = a.getCity();            
            String zipCode = a.getZipCode();
            int res = MySql.insertUpdateQuery("update addresses set apartment = " + "\'" + apartment + "\'" + "," + "street = " + "\'" + street + "\'" + "," + "city = " + "\'" + city + "\'" + "," + "state = " + "\'" + state + "\'" + "," + "zipcode = " + "\'" + zipCode + "\'" + " where user_id = " + userId +";");
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
