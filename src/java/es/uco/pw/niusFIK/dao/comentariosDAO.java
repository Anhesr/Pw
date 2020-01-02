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
 * @author Felipe
 */
public class comentariosDAO {
    
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
    
    public static ArrayList<Hashtable<String, String>> loadComments(int idP) {
        ArrayList<Hashtable<String, String>> result = null;
        Hashtable<String, String> res = null;
        PreparedStatement ps = null;   
        Connection con = getConnection();
        
        try {
            result = new ArrayList<Hashtable<String, String>>();
	    ps = con.prepareStatement("select nombre, apellidos, cuerpo, fecha_publicacion from comentarios where idpublicacion = ?;");
            ps.setString(1,Integer.toString(idP));  
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                res = new Hashtable<String, String>();
                res.put("nombre", rs.getString("nombre"));
                res.put("apellidos", rs.getString("apellidos"));
                res.put("cuerpo", rs.getString("cuerpo"));
                res.put("fecha_publicacion", rs.getString("fecha_publicacion"));
                result.add(res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public static ArrayList<Hashtable<String, String>> userByID(int ID){
        ArrayList<Hashtable<String, String>> result = null;
        Hashtable<String, String> res = null;
        PreparedStatement ps = null; 
        Connection con = getConnection();
        try {
        ps = con.prepareStatement("select nombre, apellidos from usuarios where id = ?;");
        ps.setString(1,Integer.toString(ID));
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        res = new Hashtable<String, String>();
        String name = rs.getString("nombre");
        String apell = rs.getString("apellidos");
        res.put("nombre", name);
        res.put("apellido", apell);
        result.add(res);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    public static void publicarComentario(int idPublicacion, String nombre, String apellidos, String cuerpo, String fecha){
        PreparedStatement ps = null;
        Connection con = getConnection();
        try {
        ps = con.prepareStatement("insert into comentarios(idPublicacion, id,"
                + "nombre, apellidos, cuerpo, fecha_publicacion) values "
                + "(?,NULL,\"?\",\"?\",\"?\",?);");
        ps.setString(1,Integer.toString(idPublicacion));
        ps.setString(2,nombre);
        ps.setString(3,apellidos);
        ps.setString(4,cuerpo);
        ps.setString(5,fecha);
        
        ps.executeUpdate();
        
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}