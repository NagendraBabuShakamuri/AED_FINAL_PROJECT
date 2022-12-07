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
public class MobileServiceProviderDirectory {
    private ArrayList<MobileServiceProvider> mSPDirectory = new ArrayList<>();
    public ArrayList<MobileServiceProvider> getMSPList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from mob_service_providers;");
            while(rs.next())
            {
              int mspId = rs.getInt(1);
              String mspName = rs.getString(2);
              MobileServiceProvider msp = new MobileServiceProvider(mspId, mspName);
              mSPDirectory.add(msp);
            }
            return mSPDirectory;
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
    public static int addMSP(MobileServiceProvider msp)
    {
        try
        {
            MySql.createConn();  
            int mspId = msp.getId();
            String mspName = msp.getProviderName();
            int res = MySql.insertUpdateQuery("insert into mob_service_providers values(" + mspId + "," + "\'" + mspName + "\'" + ");");
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
    public static int updateMSP(MobileServiceProvider msp, int position)
    {
        try
        {
            MySql.createConn();  
            int mspId = msp.getId();
            String mspName = msp.getProviderName();
            int res = MySql.insertUpdateQuery("update mob_service_providers set id = " + mspId + ", provider_name = " + "\'" + mspName + "\'" + " where id = " + position + ";");
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
    public static int deleteMSP(int mspId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from mob_service_providers where id = " + mspId + ";");
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
    public static int getMSPId(String mspName)
    {
      try
      {
        MySql.createConn();
        String query = "select id from mob_service_providers where provider_name = " + "\'" + mspName + "\'" + ";";
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
