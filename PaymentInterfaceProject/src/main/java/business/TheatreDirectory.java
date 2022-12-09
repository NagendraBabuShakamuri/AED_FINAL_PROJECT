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
}
