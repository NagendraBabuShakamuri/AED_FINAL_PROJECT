/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
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
public class TheatreDirectory {
    private ArrayList<Theatre> theatreDirectory = new ArrayList<>();
    public ArrayList<Theatre> getTheatreList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from theatres;");
            while(rs.next())
            {
              int id = Integer.parseInt(rs.getString(1));
              String theatreName = rs.getString(2);
              int cityId = rs.getInt(3);
              CityDirectory cd = new CityDirectory();
              String cityName = "";
              for(City c: cd.getCityList())
              {
                if(c.getCityId() == cityId)
                {
                  cityName = c.getCityName();
                }
              }
              City city = new City(cityId, cityName);
              Theatre theatre = new Theatre(id, theatreName, city);
              theatreDirectory.add(theatre);
            }
            return theatreDirectory;
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

    public static int addTheatre(Theatre t)
    {
        try
        {
            MySql.createConn();  
            int theatreId = t.getId();
            String theatreName = t.getTheatreName();
            int theatreCityId = t.getCity().getCityId();

            int res = MySql.insertUpdateQuery("insert into theatres values(" + theatreId + "," + "\'" + theatreName + "\'" + ","+ theatreCityId +");");
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
    
    public static int updateTheatre(Theatre t, int position)
    {
        try
        {
            MySql.createConn();  
            int theatreId = t.getId();
            String theatreName = t.getTheatreName();
            int theatreCityId = t.getCity().getCityId();
            
            int res = MySql.insertUpdateQuery("update theatres set id = " + theatreId +  ", theatre_name = " + "\'" + theatreName + "\'" + "," + "city_id = " + theatreCityId + " where id = " + position +";");
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
    
     public static int deleteTheatre(int theatreId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from theatres where id = " + theatreId + ";");
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
     
    public static int getTheatreId(String theatreName)
    {
      try
      {
        MySql.createConn();
        String query = "select id from theatres where theatre_name = " + "\'" + theatreName + "\'" + ";";
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
