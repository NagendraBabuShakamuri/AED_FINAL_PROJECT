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
public class BankDirectory {
    private static ArrayList<Bank> bankDirectory = new ArrayList<>();
    public static ArrayList<Bank> getBankList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from banks;");
            while(rs.next())
            {
              int id = Integer.parseInt(rs.getString(1));
              String bankName = rs.getString(2);
              String routingNumber = rs.getString(3);
              Bank bank = new Bank(id, bankName, routingNumber);
              bankDirectory.add(bank);
            }
            return bankDirectory;
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
