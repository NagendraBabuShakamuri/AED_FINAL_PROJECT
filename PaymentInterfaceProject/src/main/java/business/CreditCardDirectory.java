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
public class CreditCardDirectory {
    private ArrayList<CreditCard> creditCardDirectory = new ArrayList<>();
    public ArrayList<CreditCard> getCreditCardList()
    {
        try
        {
            MySql.createConn();           
            ResultSet rs = MySql.selectQuery("select * from credit_cards;");
            while(rs.next())
            {
              int id = Integer.parseInt(rs.getString(1));
              String cardType = rs.getString(2);
              CreditCard creditCard = new CreditCard(id, cardType);
              creditCardDirectory.add(creditCard);
            }
            return creditCardDirectory;
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
    public static int addCard(CreditCard c)
    {
        try
        {
            MySql.createConn();  
            int cardId = c.getId();
            String cardType = c.getType();
            int res = MySql.insertUpdateQuery("insert into credit_cards values(" + cardId + "," + "\'" + cardType + "\'" +  ");");
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
    public static int updateCard(CreditCard c, int position)
    {
        try
        {
            MySql.createConn();  
            int cardId = c.getId();
            String cardType = c.getType();
            int res = MySql.insertUpdateQuery("update credit_cards set id = " + cardId + "," + "type = " + "\'" + cardType + "\'" + " where id = " + position + ";");
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
    public static int deleteCard(int cardId)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from credit_cards where id = " + cardId + ";");
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
    public static ResultSet getCreditCards()
    {
      try
      {
        MySql.createConn();
        String query = "select * from credit_cards;";
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
