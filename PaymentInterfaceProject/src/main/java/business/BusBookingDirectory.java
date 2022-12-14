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
public class BusBookingDirectory {
    private ArrayList<Bus> busBookingDirectory = new ArrayList<>();    
    public static ResultSet getBusBookings(int userId)
    {
      try
      {
        MySql.createConn();
        String query = "select * from bus_bookings where user_id = " + userId + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
    public static ResultSet getFare(int busId)
    {      
      try
      {
        MySql.createConn();
        String query = "select fare from buses where id = " + busId + ";";
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
