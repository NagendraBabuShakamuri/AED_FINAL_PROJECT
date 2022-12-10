/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package business;

import java.time.LocalDate;

/**
 *
 * @author nbabu
 */
public class GasBill {
    private int id;
    private User user;
    private LocalDate billingDate;
    private int totalGallons;
    private double amount;
    private LocalDate dueDate;
    private String status;
    
    public GasBill(int id, User user, LocalDate billingDate, int totalGallons, double amount, LocalDate dueDate, String status) {
        this.id = id;
        this.user = user;
        this.billingDate = billingDate;
        this.totalGallons = totalGallons;
        this.amount = amount;
        this.dueDate = dueDate;
        this.status = status;
    }    

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getTotalGallons() {
        return totalGallons;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }    
}
