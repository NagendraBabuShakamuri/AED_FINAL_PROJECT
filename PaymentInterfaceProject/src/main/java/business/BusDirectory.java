/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.mysql.MySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author nbabu
 */
public class BusDirectory {
    private ArrayList<Bus> busDirectory = new ArrayList<>();
    public ArrayList<Bus> getBusList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from buses;");
            while(rs.next())
            {
              int busId = rs.getInt(1);
              String busName = rs.getString(2);
              int fromCityId = rs.getInt(3);
              int toCityId = rs.getInt(4);              
              ResultSet rs1 = MySql.selectQuery("select city_name from cities where id = " + fromCityId + ";");
              rs1.next();
              String fromCityName = rs1.getString(1);
              City fromCity = new City(fromCityId, fromCityName);
              ResultSet rs2 = MySql.selectQuery("select city_name from cities where id = " + toCityId + ";");
              rs2.next();
              String toCityName = rs2.getString(1);
              City toCity = new City(toCityId, toCityName);
              String dt = rs.getString(5);
              String at = rs.getString(6);
              double fare = rs.getDouble(7);
              LocalDate travelDate = LocalDate.parse(rs.getString(8));
              Bus bus = new Bus(busId, busName, fromCity, toCity, dt, at, fare, travelDate);
              busDirectory.add(bus);
            }
            return busDirectory;
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
    public static int addBus(Bus b)
    {
        try
        {
            MySql.createConn();  
            int busId = b.getId();
            String busName = b.getBusName();
            int fromCityId = b.getFromCity().getCityId();
            int toCityId = b.getToCity().getCityId();
            String departureTime = b.getDepartureTime();
            String arrivalTime = b.getArrivalTime();
            double fare = b.getFare();
            LocalDate ld = b.getTravelDate();
            String travelDate = "" + ld;
            int res = MySql.insertUpdateQuery("insert into buses values(" + busId + "," + "\'" + busName + "\'" + "," + fromCityId + "," + toCityId + "," + "\'" + departureTime + "\'" + "," + "\'" + arrivalTime + "\'" + "," + fare + "," + "\'" + travelDate + "\'" + ");");
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
    public static int updateBus(Bus b, int position)
    {
        try
        {
            MySql.createConn();  
            int busId = b.getId();
            String busName = b.getBusName();
            int fromCityId = b.getFromCity().getCityId();
            int toCityId = b.getToCity().getCityId();
            String departureTime = b.getDepartureTime();
            String arrivalTime = b.getArrivalTime();
            double fare = b.getFare();
            LocalDate ld = b.getTravelDate();
            String travelDate = "" + ld;
            int res = MySql.insertUpdateQuery("update buses set id = " + busId + "," + "bus_name = " + "\'" + busName + "\'" + "," + "from_city = " + fromCityId + "," + "to_city = " + toCityId + "," + "start_at = " + "\'" + departureTime + "\'" + "," + "reach_at = " + "\'" + arrivalTime + "\'" + "," + "fare = " + fare + "," + "travel_date = " + "\'" + travelDate + "\'" + " where id = " + position +";");
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
    public static int deleteBus(int busId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from buses where id = " + busId + ";");
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
