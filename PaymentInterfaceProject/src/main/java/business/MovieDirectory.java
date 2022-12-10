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
              int id = Integer.parseInt(rs.getString(1));
              String movieName = rs.getString(2);
              Movie movie = new Movie(id, movieName);
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
            int res = MySql.insertUpdateQuery("insert into movies values(" + movieId + "," + "\'" + movieName + "\'" + ");");
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
            int res = MySql.insertUpdateQuery("update movies set id = " + movieId + ", movie_name = " + "\'" + movieName + "\'" + " where id = " + position + ";");
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
      
    public static int getMovieId(String movieName)
    {
      try
      {
        MySql.createConn();
        String query = "select id from movies where movie_name = " + "\'" + movieName + "\'" + ";";
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
