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
    
    public static ArrayList<Hashtable<String, String>> queryByPublicationID(int PublicationID) {
        ArrayList<Hashtable<String, String>> result = null;
        Hashtable<String, String> res = null;
        Statement stmt = null;
        Connection con = getConnection();
        try {
            result = new ArrayList<Hashtable<String, String>>();
            stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("select comentarios.idPublicacion, comentarios.id"
                    + "comentarios.nombre, comentarios.apellidos, comentarios.cuerpo, comentarios.fecha_publicacion "
                    + "from comentarios where comentarios.idPublicacion = " + PublicationID);
            while (rs.next()) {
                String idPublicacion = rs.getString("comentarios.idPublicacion");
                String autor = rs.getString("comentarios.nombre") + " " + rs.getString("usuarios.apellidos");
                String cuerpo = rs.getString("comentarios.cuerpo");
                String fecha = rs.getString("comentarios.fecha_publicacion");
                res = new Hashtable<String, String>();
                res.put("idPublicacion", idPublicacion);
                res.put("autor", autor);
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