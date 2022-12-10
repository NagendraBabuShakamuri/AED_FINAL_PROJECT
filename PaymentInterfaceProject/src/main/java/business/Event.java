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
public class Event {
    private int id;
    private String eventName;
    private City eventCity;
    private LocalTime startTime;
    private LocalTime endTime;    
    private double fare;
    private LocalDate eventDate; 
    
    public Event(int id, String eventName, City eventCity, LocalTime startTime, LocalTime endTime, double fare, LocalDate eventDate) {
        this.id = id;
        this.eventName = eventName;
        this.eventCity = eventCity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fare = fare;
        this.eventDate = eventDate;
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public City getEventCity() {
        return eventCity;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public double getFare() {
        return fare;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }
}
