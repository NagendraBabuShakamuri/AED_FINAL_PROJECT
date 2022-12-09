/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
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
public class ScreenDirectory {
   private ArrayList<Screen> screenDirectory = new ArrayList<>();
    public ArrayList<Screen> getScreenList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from screens;");
            while(rs.next())
            {
              int id = Integer.parseInt(rs.getString(1));
              int theatreId = rs.getInt(2);              
              String theatreName = "";
              City theatreCity = null;
              TheatreDirectory td = new TheatreDirectory();
              for(Theatre t : td.getTheatreList())
              {
                if(t.getId() == theatreId)
                {
                  theatreName = t.getTheatreName();
                  theatreCity = t.getCity();
                }
              }
              Theatre theatre = new Theatre(theatreId, theatreName, theatreCity);
              int movieId = rs.getInt(3);
              String movieName = "";
              MovieDirectory md = new MovieDirectory();
              for(Movie m: md.getMovieList())
              {
                if(m.getId() == movieId)
                {
                  movieName = m.getMovieName();
                }
              }
              Movie movie = new Movie(movieId, movieName);
              LocalDate movieDate = LocalDate.parse(rs.getString(4));
              LocalTime movieTime = LocalTime.parse(rs.getString(5));
              double price = rs.getDouble(6);
              Screen screen = new Screen(id, theatre, movie, movieDate, movieTime, price);
              screenDirectory.add(screen);
            }
            return screenDirectory;
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
