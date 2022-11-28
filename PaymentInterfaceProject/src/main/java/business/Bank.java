/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author nbabu
 */
public class Bank {
    private int id;
    private String name;
    private String routingNumber;
    public Bank(int id, String name, String routingNumber)
    {
      this.id = id;
      this.name = name;
      this.routingNumber = routingNumber;
    }
    public int getId()
    {
      return id;
    }
    public String getName()
    {
      return name;
    }
    public String getRoutingNumber()
    {
      return routingNumber;
    }
}
