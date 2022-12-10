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
public class MovieBookingDirectory {
    private ArrayList<MovieBooking> movieBookingDirectory = new ArrayList<>();
    public ArrayList<MovieBooking> getMovieBookingList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from movie_bookings;");
            while(rs.next())
            {
              int id = rs.getInt(1);
              int userId = rs.getInt(2);              
              ResultSet rs1 = MySql.selectQuery("select * from users where userid = " + userId + ";");
              rs1.next();
              int userid = rs1.getInt(1);
              String userName = rs1.getString(2);
              String email = rs1.getString(3);
              long mobile = rs1.getLong(4);
              String password = rs1.getString(5);
              double balance = rs1.getDouble(7);
              User user = new User(userid, userName, email, mobile, password, balance);
              
              int screenId = rs.getInt(3);
              Theatre theatre = null;
              Movie movie = null;
              LocalDate movieDate = null;
              LocalTime movieTime = null;
              double price = 0;
              ScreenDirectory sd = new ScreenDirectory();
              for(Screen s: sd.getScreenList())
              {
                if(s.getId() == screenId)
                {
                  theatre = s.getTheatre();
                  movie = s.getMovie();
                  movieDate = s.getMovieDate();
                  movieTime = s.getMovieTime();
                  price = s.getPrice();
                }
              }
              MySql.createConn();
              Screen screen = new Screen(screenId, theatre, movie, movieDate, movieTime, price);
              int seatNumber = rs.getInt(4);
              LocalDate bookingDate = LocalDate.parse(rs.getString(5));
              MovieBooking mb = new MovieBooking(id, user, screen, seatNumber, bookingDate);
              movieBookingDirectory.add(mb);
            }
            return movieBookingDirectory;
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
    public static int addMovieBooking(MovieBooking mb)
    {
        try
        {
            MySql.createConn();
            int userId = mb.getUser().getId();
            int screenId = mb.getScreen().getId();
            int seatNumber = mb.getSeatNumber();
            int res = MySql.insertUpdateQuery("insert into movie_bookings(user_id, screen_id, seat_number, booking_date) values(" + userId + "," + screenId + "," + seatNumber + ","  + "CURDATE()" + ");");
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
    public static int deleteMovieBooking(int bookingId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from movie_bookings where id = " + bookingId + ";");
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
    public static int seatFilled(int screenId, int seatNumber)
    {
        try
        {
            MySql.createConn();
            String query = "select count(*) from movie_bookings where screen_id = " + screenId + " and seat_number = " + seatNumber + ";";
            ResultSet rs = MySql.selectQuery(query);
            rs.next();
            if(rs.getInt(1) > 0)
            {
              return 1;
            }
            else
                return 0;
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
    }
}
