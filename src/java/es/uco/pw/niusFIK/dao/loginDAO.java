/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
/**
 *
 * @author janthonyo
 */
public class loginDAO {
    
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
        
    public static boolean checkLogin(String email, String passwd) {
        boolean status = false;
        PreparedStatement ps = null;
        Connection con = getConnection();
        try{
            ps = con.prepareStatement(  
                "select * from usuarios where usuarios.correo_electronico=? "
                        + "and usuarios.password=?");  
                ps.setString(1,email);  
                ps.setString(2,passwd);
                
            ResultSet rs=ps.executeQuery();  
            status=rs.next();  
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    // Hacer queryByLogin 
}
