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
        
        
    public static boolean checkUser(String user){
        boolean status = false;
        PreparedStatement ps = null;
        Connection con = getConnection();
        try{
            ps = con.prepareStatement(  
                "select * from usuarios where usuarios.usuario=? ");  
                ps.setString(1,user);  
                
            ResultSet rs=ps.executeQuery();  
            status=rs.next();  
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    
    public static boolean checkLogin(String user, String passwd) {
        boolean status = false;
        PreparedStatement ps = null;
        Connection con = getConnection();
        try{
            ps = con.prepareStatement(  
                "select * from usuarios where usuarios.usuario=? "
                        + "and usuarios.password=?");  
                ps.setString(1,user);  
                ps.setString(2,passwd);
                
            ResultSet rs=ps.executeQuery();  
            status=rs.next();  
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static Hashtable<String, String> queryByUser(String user){
        Hashtable<String, String> res = null;
        PreparedStatement ps = null;
        Connection con = getConnection();
        try{
            ps = con.prepareStatement(  
                "select * from usuarios where usuarios.usuario=? ");  
                ps.setString(1,user);  
                
            ResultSet rs=ps.executeQuery();  
            
            rs.next();
            String id =        rs.getString("usuarios.id");
            String cv_id =     rs.getString("usuarios.curriculum_id");
            String nombre =    rs.getString("usuarios.nombre");
            String apellidos = rs.getString("usuarios.apellidos");
            String usuario =   rs.getString("usuarios.usuario");
            
            res = new Hashtable<String, String>();
            
            res.put("id", id);
            res.put("cv_id", cv_id);
            res.put("nombre", nombre + apellidos);
            res.put("user", usuario);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
    
    // Hacer queryByLogin 
}
