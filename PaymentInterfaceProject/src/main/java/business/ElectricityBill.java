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
public class ElectricityBill {
    private int id;
    private User user;
    private LocalDate billingDate;
    private int totalKWatts;
    private double amount;
    private LocalDate dueDate;
    private String status;

    public ElectricityBill(int id, User user, LocalDate billingDate, int totalKWatts, double amount, LocalDate dueDate, String status) {
        this.id = id;
        this.user = user;
        this.billingDate = billingDate;
        this.totalKWatts = totalKWatts;
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

    public int getTotalKWatts() {
        return totalKWatts;
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
