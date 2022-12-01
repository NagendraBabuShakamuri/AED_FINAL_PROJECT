/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.time.LocalDate;

/**
 *
 * @author nbabu
 */
public class BusBookings {
    private int id;
    private User user;
    private Bus bus;
    private int seatNumber;
    private LocalDate bookingDate;
    private LocalDate travelDate;    
    private String passengerName;
    private String passengerMobile;
    
    public BusBookings(int id, User user, Bus bus, int seatNumber, LocalDate bookingDate, LocalDate travelDate, String passengerName, String passengerMobile) {
        this.id = id;
        this.user = user;
        this.bus = bus;
        this.seatNumber = seatNumber;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.passengerName = passengerName;
        this.passengerMobile = passengerMobile;
    }
    
    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Bus getBus() {
        return bus;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPassengerMobile() {
        return passengerMobile;
    }
}
