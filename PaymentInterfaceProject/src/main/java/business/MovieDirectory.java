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
}
