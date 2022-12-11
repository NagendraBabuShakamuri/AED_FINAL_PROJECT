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
public class BankAccountDirectory {
    private ArrayList<BankAccount> bankAccountDirectory = new ArrayList<>();
    public static int addBankAccount(BankAccount ba)
    {
        try
        {
            MySql.createConn();
            int userId = ba.getUser().getId();
            int bankId = ba.getBank().getId();
            String accountHolder = ba.getAccountHolder();
            long accountNumber = ba.getAccountNumber();
            double balance = ba.getAccountBalance();
            int res = MySql.insertUpdateQuery("insert into bank_accounts(user_id, bank_id, account_holder, account_number, acc_balance) values(" + userId + "," + bankId + "," + "\'" + accountHolder + "\'" + "," + "\'" + accountNumber + "\'" + ","  + balance + ");");
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
    public static int deleteBankAccount(String removeBankAcc)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from bank_accounts  where account_number = " + "\'" + removeBankAcc + "\'" + ";");
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
    public static ResultSet getMoneyTransfers(String userName)
    {
      try
      {
        MySql.createConn();
        String query = "select amount, date from transfer_money where sender = " + "\'" + userName + "\'" + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
    public static ResultSet getAccountNumbers(int userId)            
    {
      try
      {
        MySql.createConn();
        String query = "select account_number from bank_accounts where user_id = " + userId + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
    public static ResultSet accountNumberExists(String accNumber)
    {
      try
      {
        MySql.createConn();
        String query = "select count(*) from bank_accounts where account_number = " + "\'" + accNumber + "\';";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
    public static ResultSet availableBalance(int userId, String accountNumber)
    {
      try
      {
        MySql.createConn();
        String query = "select acc_balance from bank_accounts where user_id = " + userId + " and account_number = " + "\'" + accountNumber + "\'" + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
    public static int updateAvailableBalance(double available_bal, int userId, String accountNumber)
    {
      try
      {
        MySql.createConn();
        String query = "update bank_accounts set acc_balance = " + available_bal + " where user_id = " + userId + " and account_number = " + "\'" + accountNumber + "\'" + ";";
        int res = MySql.insertUpdateQuery(query);
        return res;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return 0;
      }
    }
    public static int addMoneyToBank(double money, String accountNumber)
    {
      try
      {
        MySql.createConn();
        String query = "update bank_accounts set acc_balance = acc_balance + " + money + " where account_number = " + "\'" + accountNumber + "\'" + ";";
        int res = MySql.insertUpdateQuery(query);
        return res;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return 0;
      }
    }
}
