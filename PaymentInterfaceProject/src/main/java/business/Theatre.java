/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package business;

/**
 *
 * @author nbabu
 */
public class Theatre {
    private int id;
    private String theatreName;
    private City city;

    public Theatre(int id, String theatreName, City city) {
        this.id = id;
        this.theatreName = theatreName;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public City getCity() {
        return city;
    }        
}
