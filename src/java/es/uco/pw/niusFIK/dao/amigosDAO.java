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
 * @author bixde
 */
public class amigosDAO {
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
    public static ArrayList<Hashtable<String, String>> friendsByID(int ID){
        ArrayList<Hashtable<String, String>> result=null;
        Hashtable<String, String> res = null;
        Connection con = getConnection();
         Statement stmt = null;
        try {
            result = new ArrayList<Hashtable<String, String>>();
            stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("select amigos.id_amigo "
                     + "from amigos where amigos.id_usuario = " + ID);
            while (rs.next()) {
                String idAmigo = rs.getString("amigos.id_amigo");
                res = new Hashtable<String, String>();
                res.put("idAmigo", idAmigo);
                result.add(res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return result;
    }
    public static void insertUserFriend(String UserID, String FriendID)
    {
        PreparedStatement ps = null;
        Connection con = getConnection();
        try{
            ps = con.prepareStatement(  
                "INSERT INTO amigos (ID_USUARIO, ID_AMIGO,"
              + "VALUES (?,?)");   
            
                ps.setString(1,UserID);
                ps.setString(2,FriendID);
                
                ps.executeUpdate();
                
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void deleteUserFriend(String UserID, String FriendID)
    {
        PreparedStatement ps = null;
        Connection con = getConnection();
        try{
            ps = con.prepareStatement(  
                "DELETE FROM amigos WHERE amigos.id_usuario = " 
                + UserID + "AND amigos.id_amigo = " + FriendID);
            ps.executeUpdate();
                
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Hashtable<String, String>> friendsNameByID(int ID){
        ArrayList<Hashtable<String, String>> result=null;
        Hashtable<String, String> res = null;
        Connection con = getConnection();
         Statement stmt = null;
        try {
            result = new ArrayList<Hashtable<String, String>>();
            stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("select amigos.id_amigo "
                     + "from amigos where amigos.id_usuario = " + ID);
            while (rs.next()) {
                String idAmigo = rs.getString("amigos.id_amigo");
                stmt = con.createStatement();
                
                ResultSet resu = stmt.executeQuery("select usuarios.nombre "
                     + "from usuarios where usuarios.id = " + idAmigo);
                
                String nombreAmigo = resu.getString("usuarios.nombre");
                
                res = new Hashtable<String, String>();
                res.put("NombreAmigo", nombreAmigo);
                result.add(res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return result;
    }
    public static String friendIDByName(String name){
        String idAmigo=null;
        Connection con = getConnection();
         Statement stmt = null;
        try {
            stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("select usuarios.id "
                     + "from usuarios where usuarios.nombre = " + name);
            
            idAmigo = rs.getString("usuarios.id");
              
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return idAmigo;
    }
}
