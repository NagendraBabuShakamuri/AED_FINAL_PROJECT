/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author nbabu
 */
public class Train {
    private int id;
    private City fromCity;
    private City toCity;
    private String departureTime;
    private String arrivalTime;
    private LocalDate travelDate;
    private double fare;

    public Train(int id, City fromCity, City toCity, String departureTime, String arrivalTime, LocalDate travelDate, double fare) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.travelDate = travelDate;
        this.fare = fare;
    }

    public int getId() {
        return id;
    }

    public City getFromCity() {
        return fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public double getFare() {
        return fare;
    }

  
}
