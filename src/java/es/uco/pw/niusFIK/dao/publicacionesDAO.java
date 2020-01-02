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
 * @author skrotex
 */
public class publicacionesDAO {
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i72saraf","i72saraf","poketo");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    public static ArrayList<Hashtable<String, String>> queryByUserID(int UserID) {
        ArrayList<Hashtable<String, String>> result = null;
        Hashtable<String, String> res = null;
        PreparedStatement ps = null;   
        Connection con = getConnection();
        
        try {
            result = new ArrayList<Hashtable<String, String>>();
	    ps = con.prepareStatement("select usuarios.nombre, usuarios.apellidos, publicaciones.id, "
                    + "publicaciones.nombre, publicaciones.cuerpo, publicaciones.fecha_publicacion, publicaciones.visitas "
                    + "from usuarios, publicaciones where usuarios.id = ? and publicaciones.autor_id = ?;");
            
            ps.setString(1,Integer.toString(UserID));  
            ps.setString(2,Integer.toString(UserID));
   
            ResultSet rs=ps.executeQuery();  
                    
            while (rs.next()) {
                String id = rs.getString("publicaciones.id");
                String autor = rs.getString("usuarios.nombre") + " " + rs.getString("usuarios.apellidos");
                String nombre = rs.getString("publicaciones.nombre");
                String cuerpo = rs.getString("publicaciones.cuerpo");
                String fecha = rs.getString("publicaciones.fecha_publicacion");
                String visitas = rs.getString("publicaciones.visitas");
                res = new Hashtable<String, String>();
                res.put("id", id);
                res.put("autor", autor);
                res.put("nombre", nombre);
                res.put("cuerpo", cuerpo);
                res.put("fecha", fecha);
                res.put("visitas", visitas);
                result.add(res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public static ArrayList<Hashtable<String, String>> loadPublication(int id){
        ArrayList<Hashtable<String, String>> result = null;
        Hashtable<String, String> res = null;
        PreparedStatement ps = null;   
        Connection con = getConnection();
        
        try {
            result = new ArrayList<Hashtable<String, String>>();
	    ps = con.prepareStatement("select nombre, cuerpo from publicaciones where id = ?;");
            ps.setString(1,Integer.toString(id));  
   
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                res = new Hashtable<String, String>();
                res.put("nombre", rs.getString("nombre"));
                res.put("cuerpo", rs.getString("cuerpo"));
                result.add(res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public static void publicarPublicacion(int id, int autor_id, String nombre, String cuerpo, String fecha, int visitas){
        PreparedStatement ps = null;   
        Connection con = getConnection();
        try {
            ps = con.prepareStatement("insert into publicaciones(id, autor_id, nombre,"
                + "cuerpo, fecha_publicacion, visitas) values (?,?,?,?,?,?);");
            
            ps.setString(1,Integer.toString(id));
            ps.setString(2,Integer.toString(autor_id));
            ps.setString(3,nombre);
            ps.setString(4,cuerpo);
            ps.setString(5,fecha);
            ps.setString(6,Integer.toString(visitas));
          
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static int idPublicacionDisponible(){
        int result = 0;
        PreparedStatement ps = null; 
        Connection con = getConnection();
        try {
	    ps = con.prepareStatement("select max(id) from publicaciones;");
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = 1 + (Integer.parseInt(rs.getString("max(id)")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public static void ActualizarVisita(int idP){
        int result = 0;
        PreparedStatement ps = null; 
        Connection con = getConnection();
        try {
            ps = con.prepareStatement("select visitas from publicaciones where id = ?;");
            ps.setString(1,Integer.toString(idP));
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            result = 1 + (Integer.parseInt(rs.getString("visitas")));
            
            ps = null;
            ps = con.prepareStatement("update publicaciones set visitas = ? where id = ?;");
            ps.setString(1,Integer.toString(result));
            ps.setString(2,Integer.toString(idP));
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}