/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author nbabu
 */
public class MobileServiceProvider {
    private int id;
    private String providerName;

    public MobileServiceProvider(int id, String providerName) {
        this.id = id;
        this.providerName = providerName;
    }

    public int getId() {
        return id;
    }

    public String getProviderName() {
        return providerName;
    }
    
}
