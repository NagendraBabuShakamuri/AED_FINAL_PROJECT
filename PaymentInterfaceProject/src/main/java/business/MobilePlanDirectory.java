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
public class MobilePlanDirectory {
    private ArrayList<MobilePlan> mPDirectory = new ArrayList<>();
    public ArrayList<MobilePlan> getMPList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from mobile_plans;");
            while(rs.next())
            {
              int mpId = rs.getInt(1);
              int providerId = rs.getInt(2);
              ResultSet rs1 = MySql.selectQuery("select provider_name from mob_service_providers where id = " + providerId + ";");
              rs1.next();
              String mspName = rs1.getString(1);
              MobileServiceProvider msp = new MobileServiceProvider(providerId, mspName);
              String planName = rs.getString(3);
              String data = rs.getString(4);
              String calls = rs.getString(5);
              int validity = rs.getInt(6);
              double price = rs.getDouble(7);
              MobilePlan mp = new MobilePlan(mpId, msp, planName, data, calls, validity, price);
              mPDirectory.add(mp);
            }
            return mPDirectory;
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
    public static int addMP(MobilePlan mp)
    {
        try
        {
            MySql.createConn();  
            int mpId = mp.getId();
            int providerId = mp.getMobileServiceProvider().getId();
            String planName = mp.getPlanName();
            String data = mp.getData();
            String calls = mp.getCalls();
            int validity = mp.getValidity();
            double price = mp.getPrice();
            int res = MySql.insertUpdateQuery("insert into mobile_plans values(" + mpId + "," + providerId + "," + "\'" + planName + "\'" + "," + "\'" + data + "\'" + "," + "\'" + calls + "\'" + ","  + validity  + ","  + price + ");");
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
    public static int updateMP(MobilePlan mp, int position)
    {
        try
        {
            MySql.createConn();  
            int mpId = mp.getId();
            int mSPId = mp.getMobileServiceProvider().getId();
            String planName =  mp.getPlanName();
            String data = mp.getData();
            String calls = mp.getCalls();
            int validity = mp.getValidity();
            double price = mp.getPrice();
            int res = MySql.insertUpdateQuery("update mobile_plans set id = " + mpId + "," + "provider_id = " + mSPId + "," + "plan_name = " + "\'" + planName + "\'" + "," + "data = " + "\'" + data + "\'" + "," + "calls = " + "\'" + calls + "\'" + "," + "validity = " + validity + "," + "price = " + price + " where id = " + position +";");
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
    public static int deleteMP(int mpId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from mobile_plans where id = " + mpId + ";");
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
