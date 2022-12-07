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
public class Event {
    private int id;
    private String eventName;
    private City eventCity;
    private String startTime;
    private String endTime;    
    private double fare;
    private LocalDate eventDate; 
    
    public Event(int id, String eventName, City eventCity, String startTime, String endTime, double fare, LocalDate eventDate) {
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

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public double getFare() {
        return fare;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }
    
}
