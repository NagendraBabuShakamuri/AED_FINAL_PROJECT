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
public class Bus {
    private int id;
    private String busName;
    private City fromCity;
    private City toCity;
    private String departureTime;
    private String arrivalTime;    
    private double fare;
    private LocalDate travelDate;    

    public Bus(int id, String busName, City fromCity, City toCity, String departureTime, String arrivalTime, double fare, LocalDate travelDate) {
        this.id = id;
        this.busName = busName;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fare = fare;
        this.travelDate = travelDate;
    }

    public int getId() {
        return id;
    }

    public String getBusName() {
        return busName;
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
