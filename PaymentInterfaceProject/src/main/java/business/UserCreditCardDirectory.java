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
public class UserCreditCardDirectory {
    private ArrayList<UserCreditCard> userCreditCardDirectory = new ArrayList<>();
    public static int addUserCreditCard(UserCreditCard uc)
    {
        try
        {
            MySql.createConn();    
            int userId = uc.getUser().getId();
            int cardId = uc.getCreditCard().getId();
            String cardHolder = uc.getCardHolder();
            long cardNumber = uc.getCardNumber();
            String cardExpiry = uc.getCardExpiry();
            int cardCvc = uc.getCardCVC();            
            double availableCredit = uc.getAvailableCredit();
            int res = MySql.insertUpdateQuery("insert into user_credit_cards(user_id, card_id, card_holder, card_number, card_expiry, card_cvc, available_credit) values(" + userId + "," + cardId + "," + "\'" + cardHolder + "\'" + "," + "\'" + cardNumber + "\'" + "," + "\'" + cardExpiry + "\'" + "," + "\'" + cardCvc + "\'" + "," + availableCredit + ");");
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
    public static int deleteCreditCard(String removeCreditCard)
    {
        try
        {
            MySql.createConn();
            int res = MySql.insertUpdateQuery("delete from user_credit_cards  where card_number = " + "\'" + removeCreditCard + "\'" + ";");
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
    public static ResultSet getCreditCardNumbers(int userId)            
    {
      try
      {
        MySql.createConn();
        String query = "select card_number from user_credit_cards where user_id = " + userId + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
    public static ResultSet creditCardExists(String cardNumber)
    {
      try
      {
        MySql.createConn();
        String query = "select count(*) from user_credit_cards where card_number = " + "\'" + cardNumber + "\';";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
    public static ResultSet availableCredit(int userId, String cardNumber)
    {
      try
      {
        MySql.createConn();
        String query = "select available_credit from user_credit_cards where user_id = " + userId + " and card_number = " + "\'" + cardNumber + "\'" + ";";
        ResultSet rs = MySql.selectQuery(query);
        return rs;
      }
      catch(Exception ex)
      {
        System.out.println(ex);
        return null;
      }
    }
    public static int updateAvailableCredit(double available_credit, int userId, String cardNumber)
    {
      try
      {
        MySql.createConn();
        String query = "update user_credit_cards set available_credit = " + available_credit + " where user_id = " + userId + " and card_number = " + "\'" + cardNumber + "\'" + ";";
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
