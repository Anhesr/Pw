/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.dao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	    ps = con.prepareStatement("select id, idusuario, nombre, apellidos, cuerpo, fecha_publicacion from comentarios where idpublicacion = ?;");
            ps.setString(1,Integer.toString(idP));  
            
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                res = new Hashtable<String, String>();
                String idusuario = Integer.toString(rs.getInt("idusuario"));
                res.put("idusuario", idusuario);
                String id = Integer.toString(rs.getInt("id"));
                res.put("id", id);
                res.put("nombre", rs.getString("nombre"));
                res.put("apellidos", rs.getString("apellidos"));
                res.put("cuerpo", rs.getString("cuerpo"));
                String fechaAux = rs.getString("fecha_publicacion");
                String fecha = fechaAux.substring(0, fechaAux.length()-5);
                res.put("fecha_publicacion", fecha); 
                result.add(res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public static Hashtable<String, String> DatosUser(int ID){
        Hashtable<String, String> res = null;
        PreparedStatement ps = null;
        Connection con = getConnection();
        try {
        ps = con.prepareStatement(  
                "select * from usuarios where usuarios.id=? ");  
                ps.setString(1,Integer.toString(ID));  
                
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
            res.put("nombre", nombre);
            res.put("apellidos", apellidos);
            res.put("user", usuario);
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
    public static void publicarComentario(int idusuario, int idPublicacion, String nombre, String apellidos, String cuerpo, String fecha){
        Connection con = getConnection();
        try {
        String sentencia = "insert into comentarios(idusuario, idPublicacion, id, nombre, apellidos,"
                + " cuerpo, fecha_publicacion) values (" + Integer.toString(idusuario) +","+ Integer.toString(idPublicacion) 
                + ",NULL,'"+nombre+"','"+apellidos+"',"+cuerpo+",'"+fecha+"');";
        Statement statement = con.createStatement();
        statement.executeUpdate(sentencia);
        
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void EliminarComentarioByID(int id){
        int result = 0;
        PreparedStatement ps = null;
        Connection con = getConnection();
        try {
            ps = con.prepareStatement("delete from comentarios where id = ?;");
            ps.setString(1, Integer.toString(id));
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}