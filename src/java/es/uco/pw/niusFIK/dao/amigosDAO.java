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
                "insert into amigos(id_usuario, id_amigo) values(?,?)");   
            
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
                "DELETE FROM amigos WHERE amigos.id_usuario = ? AND amigos.id_amigo = ? ");
            ps.setString(1, UserID);
            ps.setString(2, FriendID);
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
	    ResultSet rs = stmt.executeQuery("Select usuarios.nombre, usuarios.apellidos, amigos.id_amigo from usuarios, amigos " 
                + "where usuarios.id = amigos.id_amigo AND amigos.id_usuario= "+ ID);
            while (rs.next()) {
                String nombreAmigo = rs.getString("usuarios.nombre") + " " + rs.getString("usuarios.apellidos");
                String idAmigo = rs.getString("amigos.id_amigo");
                res = new Hashtable<String, String>();
                res.put("nombreAmigo", nombreAmigo);
                res.put("idAmigo", idAmigo);
                result.add(res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public static boolean checkIfFriends(int userID,int friendID) {
        boolean status = false;
        PreparedStatement ps = null;
        Connection con = getConnection();
        try {
            ps = con.prepareStatement(
                    "select * from amigos where amigos.id_usuario=? AND amigos.id_amigo=? ");
            ps.setString(1, Integer.toString(userID));
            ps.setString(2, Integer.toString(friendID));

            ResultSet rs = ps.executeQuery();
            
            if (Integer.toString(userID).equals(rs.getString("id_usuario")) && Integer.toString(friendID).equals(rs.getString("id_amigo"))) {
                status = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
}
