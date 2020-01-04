/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.dao;

import es.uco.pw.niusFIK.dao.loginDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
/**
 *
 * @author janthonyo
 */
public class registroDAO {
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i72saraf", "i72saraf", "poketo");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    
    public static void insertUserData(String name, String lastname, String birthdate, 
                                      String email, String phone, String user, String passwd)
    {
        PreparedStatement ps = null;
        Connection con = getConnection();
        try{
            ps = con.prepareStatement(  
                "insert into usuarios (nombre, apellidos, fecha_nacimiento, "
              + "correo_electronico, telefono, usuario, password) "
              + "values (?,?,?,?,?,?,?)");  
            //           1 2 3 4 5 6 7
                
                ps.setString(1,name);
                ps.setString(2,lastname);
                ps.setString(3,birthdate);
                ps.setString(4,email);
                ps.setString(5,phone);
                ps.setString(6,user);
                ps.setString(7,passwd);
                
                ps.executeUpdate();
                
                System.out.println("Record is inserted into DBUSER table!");
                
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
