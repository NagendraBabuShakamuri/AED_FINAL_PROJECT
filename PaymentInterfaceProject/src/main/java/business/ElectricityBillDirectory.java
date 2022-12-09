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
public class ElectricityBillDirectory {
    private ArrayList<ElectricityBill> electricityBillDirectory = new ArrayList<>();
    public ArrayList<ElectricityBill> getElectricityBillList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from electricity_bill;");
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
              int totalKWatts = rs.getInt(4);
              double amount = rs.getDouble(5);
              LocalDate dueDate = LocalDate.parse(rs.getString(6));
              String status = rs.getString(7);
              ElectricityBill eb = new ElectricityBill(id, user, billingDate, totalKWatts, amount, dueDate, status);
              electricityBillDirectory.add(eb);
            }
            return electricityBillDirectory;
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
    public static int addElectricityBill(ElectricityBill eb)
    {
        try
        {
            MySql.createConn();
            int userId = eb.getUser().getId();
            String billingDate = eb.getBillingDate().toString();
            int totalKWatts = eb.getTotalKWatts();
            double amount = eb.getAmount();
            String dueDate = eb.getDueDate().toString();
            String status = eb.getStatus();
            int res = MySql.insertUpdateQuery("insert into electricity_bill(userid, billing_date, total_kwatts, amount, due_date, status) values(" + userId + "," + "\'" + billingDate + "\'" + "," + totalKWatts + "," + amount + "," + "\'" + dueDate + "\'" + "," + "\'" + status + "\'" + ");");
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
