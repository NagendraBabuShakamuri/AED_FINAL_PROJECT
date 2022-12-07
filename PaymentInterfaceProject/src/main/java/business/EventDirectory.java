/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.mysql.MySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author nbabu
 */
public class EventDirectory {
    private ArrayList<Event> eventDirectory = new ArrayList<>();
 public ArrayList<Event> getEventList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from events;");
            while(rs.next())
            {
              int eventId = rs.getInt(1);
              String eventName = rs.getString(2);
              int eventCityId = rs.getInt(3);
              ResultSet rs1 = MySql.selectQuery("select city_name from cities where id = " + eventCityId + ";");
              rs1.next();
              String eventCityName = rs1.getString(1);
              City eventCity = new City(eventCityId, eventCityName);
              
              String dt = rs.getString(4);
              String at = rs.getString(5);
              double fare = rs.getDouble(6);
              LocalDate travelDate = LocalDate.parse(rs.getString(7));
              Event event = new Event(eventId, eventName, eventCity, dt, at, fare, travelDate);
              eventDirectory.add(event);
            }
            return eventDirectory;
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
 
  public static int addEvent(Event e)
    {
        try
        {
            MySql.createConn();  
            int eventId = e.getId();
            String eventName = e.getEventName();
            int eventCityId = e.getEventCity().getCityId();
            String startTime = e.getStartTime();
            String endTime = e.getEndTime();
            double fare = e.getFare();
            LocalDate ld = e.getEventDate();
            String eventDate = "" + ld;
            int res = MySql.insertUpdateQuery("insert into events values(" + eventId + "," + "\'" + eventName + "\'" + "," + eventCityId + "," + "\'" + startTime + "\'" + "," + "\'" + endTime + "\'" + "," + fare + "," + "\'" + eventDate + "\'" + ");");
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
  
   public static int updateEvent(Event e, int position)
    {
        try
        {
            MySql.createConn();  
            int eventId = e.getId();
            String eventName = e.getEventName();
            int eventCityId = e.getEventCity().getCityId();
            String startTime = e.getStartTime();
            String endTime = e.getEndTime();
            double fare = e.getFare();
            LocalDate ld = e.getEventDate();
            String eventDate = "" + ld;
            int res = MySql.insertUpdateQuery("update events set id = " + eventId + "," + "event_name = " + "\'" + eventName + "\'" + "," + "event_city = " + eventCityId +  "," + "start_at = " + "\'" + startTime + "\'" + "," + "end_at = " + "\'" + endTime + "\'" + "," + "price = " + fare + "," + "event_date = " + "\'" + eventDate + "\'" + " where id = " + position +";");
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
   
   public static int deleteEvent(int eventId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from events where id = " + eventId + ";");
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
