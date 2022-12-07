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
public class TrainDirectory {
    private static ArrayList<Train> trainDirectory = new ArrayList<>();
    public static ArrayList<Train> getTrainList(String from, String to)
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from users;");
            while(rs.next())
            {
              String userName = rs.getString(2);
              String email = rs.getString(3);
              long mobile = Long.parseLong(rs.getString(4));
              String password = rs.getString(5);
//              Train train = new Train(userName, email, mobile, password);
//              trainDirectory.add(user);
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
}
