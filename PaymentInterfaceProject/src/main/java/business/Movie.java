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
public class Movie {
    private int id;
    private String movieName;
    private City movieCity;
    private String startTime;
    private String endTime;    
    private double fare;
    private LocalDate movieDate;

    public Movie(int id, String movieName, City movieCity, String startTime, String endTime, double fare, LocalDate movieDate) {
        this.id = id;
        this.movieName = movieName;
        this.movieCity = movieCity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fare = fare;
        this.movieDate = movieDate;
    }

    public int getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public City getMovieCity() {
        return movieCity;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public double getFare() {
        return fare;
    }

    public LocalDate getMovieDate() {
        return movieDate;
    }
    
    
    
}
