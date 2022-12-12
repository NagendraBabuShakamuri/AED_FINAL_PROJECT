/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package business;

import business.mysql.MySql;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nbabu
 */
public class MobileActivePlans {
    private ArrayList<MobileActivePlan> mobileActivePlansDirectory = new ArrayList<>();
    public static ResultSet getMobileActivePlans(int userId)
    {
      try
      {
        MySql.createConn();
        String query = "select * from mobile_active_plans where user_id = " + userId + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
    public static ResultSet getPrice(int planId)
    {      
      try
      {
        MySql.createConn();
        String query = "select price from mobile_plans where id = " + planId + ";";
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
