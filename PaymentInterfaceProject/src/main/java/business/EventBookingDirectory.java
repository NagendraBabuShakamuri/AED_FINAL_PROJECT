/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package business;

import business.mysql.MySql;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nbabu
 */
public class EventBookingDirectory {
    private ArrayList<Bus> eventBookingDirectory = new ArrayList<>();
    public static ResultSet getEventBookings(int userId)
    {
      try
      {
        MySql.createConn();
        String query = "select * from event_bookings where user_id = " + userId + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
    public static ResultSet getPrice(int eventId)
    {      
      try
      {
        MySql.createConn();
        String query = "select price from events where id = " + eventId + ";";
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
