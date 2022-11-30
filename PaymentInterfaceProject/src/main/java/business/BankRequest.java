/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author nbabu
 */
public class BankRequest {
    private int id;
    private User user;
    private Bank bank;
    private String accountHolder;
    private long accountNumber;
    private String status;
    public BankRequest(int id, User user, Bank bank, String accountHolder, long accountNumber, String status)
    {
      this.id = id;
      this.user = user;
      this.bank = bank;
      this.accountHolder = accountHolder;
      this.accountNumber = accountNumber;
      this.status = status;
    }
    public int getId()
    {
      return id;
    }
    public User getUser()
    {
      return user;
    }
    public Bank getBank()
    {
      return bank;
    }
    public String getAccountHolder()
    {
      return accountHolder;
    }
    public long getAccountNumber()
    {
      return accountNumber;
    }
    public String getStatus()
    {
      return status;
    }
}
