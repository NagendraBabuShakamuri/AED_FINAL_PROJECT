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
public class TrainBookings {
    private int id;
    private User user;
    private Train train;
    private LocalDate bookingDate;
    private LocalDate travelDate;
    private String ageGroup;
    private double actualFare;
    public TrainBookings(int id, User user, Train train, LocalDate bookingDate, LocalDate travelDate, String ageGroup, double actualFare) {
        this.id = id;
        this.user = user;
        this.train = train;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.ageGroup = ageGroup;
        this.actualFare = actualFare;
    }
    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Train getTrain() {
        return train;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public double getActualFare() {
        return actualFare;
    }
    
}
