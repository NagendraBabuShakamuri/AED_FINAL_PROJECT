/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.mysql;

/**
 *
 * @author nbabu
 */
import java.sql.*;
public class MySql {
    private static final String HOSTNAME = "aedproj.cg6eixfazzzp.us-east-1.rds.amazonaws.com/";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "DevShubhamNagendra";
    private static Connection conn;
    public static void createConn()
    {
      try
      {
        conn = DriverManager.getConnection("jdbc:mysql://" + HOSTNAME,USERNAME, PASSWORD);
        Statement st = conn.createStatement();
        st.executeUpdate("use payDB");
//        ResultSet rs = stmt.executeQuery("select * from registration");
//        while(rs.next())  
//          System.out.println(rs.getString(1)+ "  " + rs.getString(2) + "  " + rs.getString(3)); 
      }
      catch(SQLException ex)
      {
        System.out.println(ex);
      }
    }
    public static ResultSet selectQuery(String query)
    {
      try
      {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
      }
      catch(SQLException ex)
      {
        System.out.println(ex);
        return null;
      }      
    }
    public static int insertUpdateQuery(String query)
    {
      try
      {
        Statement st = conn.createStatement();
        int num = st.executeUpdate(query);
        return num;
      }
      catch(SQLException ex)
      {
        System.out.println(ex);
        return -1;
      }      
    }
    public static void shutDownConn()
    {
      try
      {
        if(conn != null)
          conn.close();
      } 
      catch(SQLException ex)
      {
        System.out.println(ex);
      }
    }
    public static void main(String[] args)
    {
      createConn();
      ResultSet rs = selectQuery("select * from users;");
      try
      {
        while(rs.next())
          System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
      }
      catch(SQLException ex)
      {
        System.out.println(ex);
      }
      finally
      {
        shutDownConn();
        System.out.println("Connection Ended..");
      }      
    }
}
