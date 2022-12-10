/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author nbabu
 */
public class Admin {
    private int id;
    private String role;
    private String userName;    
    private String password;

    public Admin(int id, String role, String userName, String password) {
        this.id = id;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
}
