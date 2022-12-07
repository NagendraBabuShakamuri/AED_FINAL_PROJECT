/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author nbabu
 */
public class MobilePlan {
    private int id;
    private MobileServiceProvider mobileServiceProvider;
    private String planName;
    private String data;
    private String calls;
    private int validity;
    private double price;

    public MobilePlan(int id, MobileServiceProvider mobileServiceProvider, String planName, String data, String calls, int validity, double price) {
        this.id = id;
        this.mobileServiceProvider = mobileServiceProvider;
        this.planName = planName;
        this.data = data;
        this.calls = calls;
        this.validity = validity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public MobileServiceProvider getMobileServiceProvider() {
        return mobileServiceProvider;
    }

    public String getPlanName() {
        return planName;
    }

    public String getData() {
        return data;
    }

    public String getCalls() {
        return calls;
    }

    public int getValidity() {
        return validity;
    }

    public double getPrice() {
        return price;
    }
    
}
