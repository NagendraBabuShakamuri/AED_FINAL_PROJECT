/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author nbabu
 */
public class CreditCardRequest {
    private int id;
    private User user;
    private CreditCard creditCard;
    private String cardHolder;
    private long cardNumber;
    private String cardExpiry;
    private int cardCVC;
    private String status;

    public CreditCardRequest(int id, User user, CreditCard creditCard, String cardHolder, long cardNumber, String cardExpiry, int cardCVC, String status) {
        this.id = id;
        this.user = user;
        this.creditCard = creditCard;
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCVC = cardCVC;
        this.status = status;
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

    public String getStatus() {
        return status;
    }
    
}
