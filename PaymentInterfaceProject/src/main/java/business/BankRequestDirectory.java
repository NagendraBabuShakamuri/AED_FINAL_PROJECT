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
public class BankRequestDirectory {
    private ArrayList<BankRequest> bankRequestDirectory = new ArrayList<>();
    public ArrayList<BankRequest> getBankRequestList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from bank_requests;");
            while(rs.next())
            {
              int id = rs.getInt(1);
              int userId = rs.getInt(2);
              int bankId = rs.getInt(3);
              String accountHolder = rs.getString(4);
              long accountNumber = rs.getLong(5);
              String status = rs.getString(6);
              ResultSet rs1 = MySql.selectQuery("select * from banks where id = " + bankId + ";");
              rs1.next();
              String bankName = rs1.getString(2);
              String routingNumber = rs1.getString(3);
              Bank bank = new Bank(bankId, bankName, routingNumber);
              ResultSet rs2 = MySql.selectQuery("select * from users where userid = " + userId + ";");
              rs2.next();
              int userid = rs2.getInt(1);
              String userName = rs2.getString(2);
              String email = rs2.getString(3);
              long mobile = rs2.getLong(4);
              String password = rs2.getString(5);
              double balance = rs2.getDouble(7);
              User user = new User(userid, userName, email, mobile, password, balance);
              BankRequest br = new BankRequest(id, user, bank, accountHolder, accountNumber, status);
              bankRequestDirectory.add(br);
            }
            return bankRequestDirectory;
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
    public static int updateStatusToInProgress(int requestId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("update bank_requests set status = " + "\'" + "In Progress" + "\'"  + " where id = " + requestId +";");
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
    public static int updateStatusToApproved(BankAccount ba, int requestId)
    {
        try
        {
            MySql.createConn();
            int res = BankAccountDirectory.addBankAccount(ba);
            MySql.createConn();
            if(res > 0)
            {
              int res1 = MySql.insertUpdateQuery("update bank_requests set status = " + "\'" + "Approved" + "\'"  + " where id = " + requestId +";");
              if(res1 > 0)
              {
                return res;
              }
              else
                return 0;
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
    public static int updateStatusToDenied(int requestId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("update bank_requests set status = " + "\'" + "Denied" + "\'"  + " where id = " + requestId +";");
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
