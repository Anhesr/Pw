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
        Statement stmt = null;
        Connection con = getConnection();
        try {
            result = new ArrayList<Hashtable<String, String>>();
            stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("select usuarios.nombre, usuarios.apellidos, publicaciones.id, "
                    + "publicaciones.nombre, publicaciones.cuerpo, publicaciones.fecha_publicacion, publicaciones.visitas "
                    + "from usuarios, publicaciones where usuarios.id = " + UserID + 
                    " and publicaciones.autor_id = " + UserID);
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
    
    public static void publicarPublicacion(int id, int autor_id, String nombre, String cuerpo, String fecha, int visitas){
        Statement stmt = null;
        Connection con = getConnection();
        try {
        ResultSet rs = stmt.executeQuery("insert into publicaciones(id, autor_id, nombre,"
                + "cuerpo, fecha_publicacion, visitas) values "
                + "("+Integer.toString(id)+","+Integer.toString(autor_id)+","+nombre+","+cuerpo+","+fecha+","+Integer.toString(visitas)+")");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static int idPublicacionDisponible(){
        int result = 0;
        Statement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("select max(id) from publicaciones");
            rs.next();
            result = 1 + (Integer.parseInt(rs.getString("max(id)")));
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public static void ActualizarVisita(int idP){
        int result = 0;
        Statement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("select visitas from publicaciones where id = " + idP);
            rs.next();
            result = 1 + (Integer.parseInt(rs.getString("visitas")));
            ResultSet fin = stmt.executeQuery("update publicaciones set visitas = " + result 
                    + "where id = " + idP);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}