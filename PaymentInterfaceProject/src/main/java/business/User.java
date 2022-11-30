/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.time.LocalDateTime;

/**
 *
 * @author nbabu
 */
public class User {
    private String userName;
    private String email;
    private long mobile;
    private String password;
    private double wallet_balance;
    public User(String userName, String email, long mobile, String password)
    {
      this.userName = userName;
      this.email = email;
      this.mobile = mobile;
      this.password = password;
    }
    public String getUserName()
    {
      return userName;
    }
    public String getEmail()
    {
      return email;
    }
    public long getMobile()
    {
      return mobile;
    }
    public String getPassword()
    {
      return password;
    }
    public double getWalletBalance()
    {
      return wallet_balance;
    }
    public void createUser()
    {
      
    }
    public void updateUser()
    {
      
    }
    public void deleteUser()
    {
      
    }
}
