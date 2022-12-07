/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.time.LocalDate;

/**
 *
 * @author shubhamjain
 */
public class EventBookings {
     private int id;
    private User user;
    private Event event;
    private int seatPosition;
    private LocalDate bookingDate;
    private LocalDate eventDate;    
    private String customerName;
    private String customerMobile;

    public EventBookings(int id, User user, Event event, int seatPosition, LocalDate bookingDate, LocalDate eventDate, String customerName, String customerMobile) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.seatPosition = seatPosition;
        this.bookingDate = bookingDate;
        this.eventDate = eventDate;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public int getSeatPosition() {
        return seatPosition;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }
    
}
