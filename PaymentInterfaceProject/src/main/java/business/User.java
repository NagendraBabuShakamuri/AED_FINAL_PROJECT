/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author nbabu
 */
public class User {
    private String userName;
    private String email;
    private long mobile;
    private String password;
    public User(String userName, String email, long mobile, String password)
    {
      this.userName = userName;
      this.email = email;
      this.mobile = mobile;
      this.password = password;
    }    
}
