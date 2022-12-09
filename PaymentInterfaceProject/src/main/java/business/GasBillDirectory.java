/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package business;

import business.mysql.MySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author nbabu
 */
public class GasBillDirectory {
    private ArrayList<GasBill> gasBillDirectory = new ArrayList<>();
    public ArrayList<GasBill> getGasBillList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from gas_bill;");
            while(rs.next())
            {
              int id = rs.getInt(1);
              String userId = rs.getString(2);
              ResultSet rs1 = MySql.selectQuery("select * from users where userid = " + userId + ";");
              rs1.next();
              int userid = rs1.getInt(1);
              String userName = rs1.getString(2);
              String email = rs1.getString(3);
              long mobile = rs1.getLong(4);
              String password = rs1.getString(5);
              double balance = rs1.getDouble(7);
              User user = new User(userid, userName, email, mobile, password, balance);
              LocalDate billingDate = LocalDate.parse(rs.getString(3));
              int totalGallons = rs.getInt(4);
              double amount = rs.getDouble(5);
              LocalDate dueDate = LocalDate.parse(rs.getString(6));
              String status = rs.getString(7);
              GasBill gb = new GasBill(id, user, billingDate, totalGallons, amount, dueDate, status);
              gasBillDirectory.add(gb);
            }
            return gasBillDirectory;
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
    public static int addGasBill(GasBill gb)
    {
        try
        {
            MySql.createConn();
            int userId = gb.getUser().getId();
            String billingDate = gb.getBillingDate().toString();
            int totalGallons = gb.getTotalGallons();
            double amount = gb.getAmount();
            String dueDate = gb.getDueDate().toString();
            String status = gb.getStatus();
            int res = MySql.insertUpdateQuery("insert into gas_bill(userid, billing_date, total_gallons, amount, due_date, status) values(" + userId + "," + "\'" + billingDate + "\'" + "," + totalGallons + "," + amount + "," + "\'" + dueDate + "\'" + "," + "\'" + status + "\'" + ");");
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
