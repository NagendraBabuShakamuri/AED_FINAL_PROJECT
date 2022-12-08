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
}
