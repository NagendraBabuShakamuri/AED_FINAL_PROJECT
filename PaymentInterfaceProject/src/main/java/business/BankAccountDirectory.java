/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.mysql.MySql;
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
}
