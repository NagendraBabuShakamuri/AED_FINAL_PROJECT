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
 * @author shubhamjain
 */
public class MovieDirectory {
    private ArrayList<Movie> movieDirectory = new ArrayList<>();
public ArrayList<Movie> getMovieList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from movies;");
            while(rs.next())
            {
              int movieId = rs.getInt(1);
              String movieName = rs.getString(2);
              int movieCityId = rs.getInt(3);
              ResultSet rs1 = MySql.selectQuery("select city_name from cities where id = " + movieCityId + ";");
              rs1.next();
              String movieCityName = rs1.getString(1);
              City eventCity = new City(movieCityId, movieCityName);
              
              String st = rs.getString(4);
              String et = rs.getString(5);
              double fare = rs.getDouble(6);
              LocalDate travelDate = LocalDate.parse(rs.getString(7));
              Movie movie = new Movie(movieId, movieName, eventCity, st, et, fare, travelDate);
              movieDirectory.add(movie);
            }
            return movieDirectory;
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

public static int addMovie(Movie m)
    {
        try
        {
            MySql.createConn();  
            int movieId = m.getId();
            String movieName = m.getMovieName();
            int movieCityId = m.getMovieCity().getCityId();
            String startTime = m.getStartTime();
            String endTime = m.getEndTime();
            double fare = m.getFare();
            LocalDate ld = m.getMovieDate();
            String movieDate = "" + ld;
            int res = MySql.insertUpdateQuery("insert into movies values(" + movieId + "," + "\'" + movieName + "\'" + "," + movieCityId + "," + "\'" + startTime + "\'" + "," + "\'" + endTime + "\'" + "," + fare + "," + "\'" + movieDate + "\'" + ");");
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

  public static int updateMovie(Movie m, int position)
    {
        try
        {
            MySql.createConn();  
            int movieId = m.getId();
            String movieName = m.getMovieName();
            int movieCityId = m.getMovieCity().getCityId();
            String startTime = m.getStartTime();
            String endTime = m.getEndTime();
            double fare = m.getFare();
            LocalDate ld = m.getMovieDate();
            String movieDate = "" + ld;
            int res = MySql.insertUpdateQuery("update movies set id = " + movieId + "," + "movie_name = " + "\'" + movieName + "\'" + "," + "city_id = " + movieCityId +  "," + "start_at = " + "\'" + startTime + "\'" + "," + "end_at = " + "\'" + endTime + "\'" + "," + "price = " + fare + "," + "movie_date = " + "\'" + movieDate + "\'" + " where id = " + position +";");
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
  
  public static int deleteMovie(int movieId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from movies where id = " + movieId + ";");
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
