/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.mysql.MySql;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nbabu
 */
public class TrainBookingDirectory {
    private ArrayList<TrainBooking> trainBookingDirectory = new ArrayList<>();
    public static ResultSet getTrainBookings(int userId)
    {
      try
      {
        MySql.createConn();
        String query = "select * from train_bookings where user_id = " + userId + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
}
