/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.mysql.MySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author nbabu
 */
public class TrainDirectory {
    private ArrayList<Train> trainDirectory = new ArrayList<>();
    public ArrayList<Train> getTrainList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from trains;");
            while(rs.next())
            {
              int trainId = rs.getInt(1);
              int fromCityId = rs.getInt(2);
              int toCityId = rs.getInt(3);              
              ResultSet rs1 = MySql.selectQuery("select city_name from cities where id = " + fromCityId + ";");
              rs1.next();
              String fromCityName = rs1.getString(1);
              City fromCity = new City(fromCityId, fromCityName);
              ResultSet rs2 = MySql.selectQuery("select city_name from cities where id = " + toCityId + ";");
              rs2.next();
              String toCityName = rs2.getString(1);
              City toCity = new City(toCityId, toCityName);
              LocalTime dt = LocalTime.parse(rs.getString(4));
              LocalTime at = LocalTime.parse(rs.getString(5));            
              LocalDate travelDate = LocalDate.parse(rs.getString(6));
              double fare = rs.getDouble(7);
              Train train = new Train(trainId, fromCity, toCity, dt, at,travelDate, fare);
              trainDirectory.add(train);
            }
            return trainDirectory;
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
    
    public static int addTrain(Train t)
    {
        try
        {
            MySql.createConn();  
            int trainId = t.getId();
            int fromCityId = t.getFromCity().getCityId();
            int toCityId = t.getToCity().getCityId();
            String departureTime = t.getDepartureTime().toString();
            String arrivalTime = t.getArrivalTime().toString();
            double fare = t.getFare();
            LocalDate ld = t.getTravelDate();
            String travelDate = "" + ld;
            int res = MySql.insertUpdateQuery("insert into trains values(" + trainId + "," + fromCityId + "," + toCityId + "," + "\'" + departureTime + "\'" + "," + "\'" + arrivalTime + "\'" + "," + "\'" + travelDate + "\'" + "," + fare + ");");
            System.out.println(res);
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
    
     public static int updateTrain(Train t, int position)
    {
        try
        {
            MySql.createConn();  
             int trainId = t.getId();
            int fromCityId = t.getFromCity().getCityId();
            int toCityId = t.getToCity().getCityId();
            String departureTime = t.getDepartureTime().toString();
            String arrivalTime = t.getArrivalTime().toString();
            double fare = t.getFare();
            LocalDate ld = t.getTravelDate();
            String travelDate = "" + ld;
            int res = MySql.insertUpdateQuery("update trains set id = " + trainId + "," + "from_city = " + fromCityId + "," + "to_city = " + toCityId + "," + "departure_time = " + "\'" + departureTime + "\'" + "," + "arrival_time = " + "\'" + arrivalTime + "\'" + "," + "travel_date = " + "\'" + travelDate + "\'" + "," + "fare = " +  fare + " where id = " + position +";");
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
     
     public static int deleteTrain(int trainId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from trains where id = " + trainId + ";");
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
