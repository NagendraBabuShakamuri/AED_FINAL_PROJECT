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
    private int id;
    private String userName;
    private String email;
    private long mobile;
    private String password;
    private double wallet_balance;

    public User(int id, String userName, String email, long mobile, String password, double wallet_balance) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.wallet_balance = wallet_balance;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public long getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public double getWallet_balance() {
        return wallet_balance;
    }        
}
