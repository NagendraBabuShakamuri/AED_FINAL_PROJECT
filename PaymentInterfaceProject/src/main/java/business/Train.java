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
    private String fromCity;
    private String toCity;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalDate travelDate;
    private double fare;
    public Train(int id, String fromCity, String toCity, LocalTime departureTime, LocalTime arrivalTime, double fare)
    {
      this.id = id;
      this.fromCity = fromCity;
      this.toCity = toCity;
      this.departureTime = departureTime;
      this.arrivalTime = arrivalTime;
      this.fare = fare;
    }

    public int getId() {
        return id;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public double getFare() {
        return fare;
    }    
}
