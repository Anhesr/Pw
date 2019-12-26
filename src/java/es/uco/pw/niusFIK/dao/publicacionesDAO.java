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
                    + "publicaciones.nombre, publicaciones.cuerpo, publicaciones.fecha_publicacion "
                    + "from usuarios, publicaciones where usuarios.id = " + UserID + 
                    " and publicaciones.autor_id = " + UserID);
            while (rs.next()) {
                String id = rs.getString("publicaciones.id");
                String autor = rs.getString("usuarios.nombre") + rs.getString("usuarios.apellidos");
                String nombre = rs.getString("publicaciones.nombre");
                String cuerpo = rs.getString("publicaciones.cuerpo");
                String fecha = rs.getString("publicaciones.fecha_publicacion");
                res = new Hashtable<String, String>();
                res.put("id", id);
                res.put("autor", autor);
                res.put("nombre", nombre);
                res.put("cuerpo", cuerpo);
                res.put("fecha", fecha);
                result.add(res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
}