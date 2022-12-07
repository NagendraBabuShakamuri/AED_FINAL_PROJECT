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
public class CityDirectory {
    private ArrayList<City> cityDirectory = new ArrayList<>();
    public ArrayList<City> getCityList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from cities;");
            while(rs.next())
            {
              int cityId = rs.getInt(1);
              String cityName = rs.getString(2);
              City city = new City(cityId, cityName);
              cityDirectory.add(city);
            }
            return cityDirectory;
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
    public static int addCity(City c)
    {
        try
        {
            MySql.createConn();  
            int cityId = c.getCityId();
            String cityName = c.getCityName();
            int res = MySql.insertUpdateQuery("insert into cities values(" + cityId + "," + "\'" + cityName + "\'" + ");");
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
    public static int updateCity(City c, int position)
    {
        try
        {
            MySql.createConn();  
            int cityId = c.getCityId();
            String cityName = c.getCityName();
            int res = MySql.insertUpdateQuery("update cities set id = " + cityId + ", city_name = " + "\'" + cityName + "\'" + " where id = " + position + ";");
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
    public static int deleteCity(int cityId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from cities where id = " + cityId + ";");
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
    public static int getCityId(String cityName)
    {
      try
      {
        MySql.createConn();
        String query = "select id from cities where city_name = " + "\'" + cityName + "\'" + ";";
        ResultSet rs = MySql.selectQuery(query);
        while(rs.next())
        {
          int id = rs.getInt(1);
          return id;
        }
      }
      catch(SQLException ex)
      {
        System.out.println(ex);
        return 0;
      }
      finally
      {
        MySql.shutDownConn();
      }
      return 0;
    }
}
