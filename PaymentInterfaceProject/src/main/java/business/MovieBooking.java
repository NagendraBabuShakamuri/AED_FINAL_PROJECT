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
public class MovieBooking {
    private int id;
   private User user;
   private Screen screen;
   private int seatNumber;
   private LocalDate bookinDate;

    public MovieBooking(int id, User user, Screen screen, int seatNumber, LocalDate bookinDate) {
        this.id = id;
        this.user = user;
        this.screen = screen;
        this.seatNumber = seatNumber;
        this.bookinDate = bookinDate;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Screen getScreen() {
        return screen;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public LocalDate getBookinDate() {
        return bookinDate;
    }
   
}
