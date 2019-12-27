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
public class publicaciones {
    
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
    
    public static ArrayList<Hashtable<String, String>> queryByAutorID(int autorID) {
        ArrayList<Hashtable<String, String>> result = null;
        Hashtable<String, String> res = null;
        Statement stmt = null;
        Connection con = getConnection();
        try {
            result = new ArrayList<Hashtable<String, String>>();
            stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("select autor, nombre, cuerpo from publicaciones where autor_id = " + autorID);
            while(rs.next()) {
                String autor = rs.getString("autor");
                String nombre = rs.getString("nombre");
                String cuerpo = rs.getString("cuerpo");
                res = new Hashtable<String, String>();
                res.put("autor", autor);
                res.put("nombre", nombre);
                res.put("cuerpo", cuerpo);
                result.add(res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
}