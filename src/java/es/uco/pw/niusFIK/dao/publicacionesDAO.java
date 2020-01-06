/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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
            con = DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i72saraf", "i72saraf", "poketo");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static ArrayList<HashMap<String, String>> getRecomendations() {
        ArrayList<HashMap<String, String>> result = 
                new ArrayList<HashMap<String, String>>();
        HashMap<String, String> res;
        PreparedStatement ps;
        Connection con = getConnection();
        try {
            result = new ArrayList<HashMap<String, String>>();
            ps = con.prepareStatement("select usuarios.nombre, usuarios.apellidos, publicaciones.id, "
                    + "publicaciones.nombre, publicaciones.cuerpo, publicaciones.fecha_publicacion, "
                    + "publicaciones.visitas from usuarios, publicaciones "
                    + "where usuarios.id = publicaciones.autor_id order by publicaciones.visitas desc");


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("publicaciones.id");
                String autor = rs.getString("usuarios.nombre") + " " + rs.getString("usuarios.apellidos");
                String nombre = rs.getString("publicaciones.nombre");
                String cuerpo = rs.getString("publicaciones.cuerpo");
                String fecha = rs.getString("publicaciones.fecha_publicacion");
                String visitas = rs.getString("publicaciones.visitas");
                res = new HashMap<String, String>();
                res.put("id", id);
                res.put("autor", autor);
                res.put("nombre", nombre);
                res.put("cuerpo", cuerpo);
                res.put("fecha", fecha);
                res.put("visitas", visitas);
                result.add(res);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return result;
    }
    
    /*
    public static ArrayList<Hashtable<String, String>> queryByUserID(int UserID)
    
    Esta funcion devuelve un vector con las publicaciones y datos de un usuario
    en concreto predeterminado por su id pasadolo como el parametro "UserID".
    */
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

            ps.setString(1, Integer.toString(UserID));
            ps.setString(2, Integer.toString(UserID));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("publicaciones.id");
                String autor = rs.getString("usuarios.nombre") + " " + rs.getString("usuarios.apellidos");
                String nombre = rs.getString("publicaciones.nombre");;
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
    
    /*
    public static ArrayList<Hashtable<String, String>> loadPublication(int id)
    
    Esta funcion devuelve un vector con los parametros que nos interesan
    a la hora de mostrar y utilizar en una publicación seleccionada por 
    la id que le hemos pasado en el parametro "id"
    */
    public static ArrayList<Hashtable<String, String>> loadPublication(int id) {
        ArrayList<Hashtable<String, String>> result = null;
        Hashtable<String, String> res = null;
        PreparedStatement ps = null;
        Connection con = getConnection();

        try {
            result = new ArrayList<Hashtable<String, String>>();
            ps = con.prepareStatement("select autor_id, nombre, cuerpo from publicaciones where id = ?;");
            ps.setString(1, Integer.toString(id));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res = new Hashtable<String, String>();
                String autorID = Integer.toString(rs.getInt("autor_id"));
                res.put("autor_id", autorID);
                res.put("nombre", rs.getString("nombre"));
                res.put("cuerpo", rs.getString("cuerpo"));
                result.add(res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    /*
    public static int publicarPublicacion(int autor_id, String nombre, String cuerpo, String fecha, int visitas)
    
    Esta funcion crea en la base de datos una dupla en la tabla publicaciones
    con los siguientes parametros pasados. La id de la publicación no se pasa
    ya que es a NULL debido al autoincremento que le hemos proporcionado.
    
    Devuelve la id de la publicación recién creada para acceder a ella,
    ya que a la hora de ir a su enlace la necesitamos como parametro
    */
    public static int publicarPublicacion(int autor_id, String nombre, String cuerpo, String fecha, int visitas) {  
        Connection con = getConnection();
        PreparedStatement ps = null;
        int id = 0;
        try {
        String sentencia = "insert into publicaciones(id, autor_id, nombre,"
                    + "cuerpo, fecha_publicacion, visitas)"
                + " values (NULL,"+ Integer.toString(autor_id) + ",'"+ nombre
                + "',"+cuerpo+",'"+fecha+"'," + Integer.toString(visitas) + ");";
        Statement statement = con.createStatement();
        statement.executeUpdate(sentencia);
        
        ps = con.prepareStatement("SELECT id FROM publicaciones WHERE fecha_publicacion = "
                + "(SELECT max( fecha_publicacion )FROM publicaciones );");
        ResultSet rs = ps.executeQuery();

        rs.next();
        id = (Integer.parseInt(rs.getString("id")));
        
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    /*
    public static void ActualizarVisita(int idP)
    
    Como su propio nombre indica actualiza la visita sumandole 1 a la publicacion
    con la correspondiente id pasada en el parametro "idP". Es decir, esta funcion
    se activa cada vez que se accede a dicha publicacion, 
    para llevar un conteo y mostrar las recomendaciones
    */
    public static void ActualizarVisita(int idP) {
        int result = 0;
        PreparedStatement ps = null;
        Connection con = getConnection();
        try {
            ps = con.prepareStatement("select visitas from publicaciones where id = ?;");
            ps.setString(1, Integer.toString(idP));
            ResultSet rs = ps.executeQuery();

            rs.next();
            result = 1 + (Integer.parseInt(rs.getString("visitas")));

            ps = null;
            ps = con.prepareStatement("update publicaciones set visitas = ? where id = ?;");
            ps.setString(1, Integer.toString(result));
            ps.setString(2, Integer.toString(idP));
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /*
    public static void EliminarPublicacionByID(int idP)
    
    Esta funcion elimina la publicacion con la correspondiente id pasada
    en el parametro "idP". Esta funcion se entrará cada vez que el usuario
    autor de una publicacion desee eliminar dicha publicación
    */
    public static void EliminarPublicacionByID(int idP){
        int result = 0;
        PreparedStatement ps = null;
        Connection con = getConnection();
        try {
            ps = con.prepareStatement("delete from publicaciones where id = ?;");
            ps.setString(1, Integer.toString(idP));
            ps.executeUpdate();
            ps=null;
            ps = con.prepareStatement("delete from comentarios where idpublicacion = ?;");
            ps.setString(1, Integer.toString(idP));
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /*
    public static ArrayList<Hashtable<String, String>> AllPublicationExceptYou(int idUser)
    
    Esta funcion devuelve un vector con todas las publicaciones excepto las del usuario actual.
    El parametro "idUser" es la id del usuario actual.
    */
    public static ArrayList<Hashtable<String, String>> AllPublicationExceptYou(int idUser){
        ArrayList<Hashtable<String, String>> result = null;
        Hashtable<String, String> res = null;
        PreparedStatement ps = null;
        Connection con = getConnection();

        try {
            result = new ArrayList<Hashtable<String, String>>();
            ps = con.prepareStatement("select usuarios.nombre, usuarios.apellidos, "
                    + "publicaciones.id, publicaciones.nombre, publicaciones.fecha_publicacion "
                    + "from publicaciones, usuarios where usuarios.id = publicaciones.autor_id "
                    + "and publicaciones.autor_id != ? order by publicaciones.fecha_publicacion desc;");
            ps.setString(1, Integer.toString(idUser));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("usuarios.nombre");
                String apellidos = rs.getString("usuarios.apellidos");
                String id = rs.getString("publicaciones.id");
                String titulo = rs.getString("publicaciones.nombre");
                String fechaAux = rs.getString("fecha_publicacion");
                String fecha = fechaAux.substring(0, fechaAux.length()-5);
                res = new Hashtable<String, String>();
                res.put("nombre", nombre);
                res.put("apellidos", apellidos);
                res.put("id", id);
                res.put("titulo", titulo);
                res.put("fecha", fecha);
                result.add(res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

}
