/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author shubhamjain
 */
public class Screen {
    private int id;
    private Theatre theatre;
    private Movie movie;
    private LocalDate movieDate;
    private LocalTime movieTime;
    private double price;

    public Screen(int id, Theatre theatre, Movie movie, LocalDate movieDate, LocalTime movieTime, double price) {
        this.id = id;
        this.theatre = theatre;
        this.movie = movie;
        this.movieDate = movieDate;
        this.movieTime = movieTime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDate getMovieDate() {
        return movieDate;
    }

    public LocalTime getMovieTime() {
        return movieTime;
    }

    public double getPrice() {
        return price;
    }
}
