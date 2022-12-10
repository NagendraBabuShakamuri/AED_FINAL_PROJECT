/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author nbabu
 */
public class UserCreditCard {
    private int id;
    private User user;
    private CreditCard creditCard;
    private String cardHolder;
    private long cardNumber;
    private String cardExpiry;
    private int cardCVC;
    private double availableCredit;

    public UserCreditCard(int id, User user, CreditCard creditCard, String cardHolder, long cardNumber, String cardExpiry, int cardCVC, double availableCredit) {
        this.id = id;
        this.user = user;
        this.creditCard = creditCard;
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCVC = cardCVC;
        this.availableCredit = availableCredit;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public int getCardCVC() {
        return cardCVC;
    }

    public double getAvailableCredit() {
        return availableCredit;
    }
    
}
