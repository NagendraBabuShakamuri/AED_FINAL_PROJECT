/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author nbabu
 */
public class AddressRequest {
    private int id;
    private User user;
    private String apartment;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String status;

    public AddressRequest(int id, User user, String apartment, String street, String city, String state, String zipCode, String status) {
        this.id = id;
        this.user = user;
        this.apartment = apartment;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getApartment() {
        return apartment;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStatus() {
        return status;
    }
    
}
