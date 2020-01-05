/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.dao;

import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author skrotex
 */
public class curriculumDAO {

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

    public static void updateCV(HashMap<String, Object> updateMap) {
        PreparedStatement stmt = null;
        Connection con = getConnection();
        String query;
        try {
            for (Map.Entry<String, Object> entry : updateMap.entrySet()) {
                String key = entry.getKey();
                switch (key) {
                    case "situacion_laboral":
                        query = "update curriculums set situacion_laboral=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("situacion_laboral"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "formacion_academica":
                        query = "update curriculums set formacion_academica=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("formacion_academica"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "universidad":
                        query = "update curriculums set universidad=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("universidad"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "intereses_profesionales":
                        query = "update curriculums set intereses_profesionales=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("intereses_profesionales"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "experiencia_cientifica":
                        query = "update curriculums set experiencia_cientifica=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("experiencia_cientifica"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "produccion_cientifica":
                        query = "update curriculums set logros_cientificos=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("produccion_cientifica"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "nombre":
                        query = "update usuarios set nombre=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("nombre"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "apellidos":
                        query = "update usuarios set apellidos=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("apellidos"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "fecha_nacimiento":
                        query = "update usuarios set fecha_nacimiento=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("fecha_nacimiento"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "correo_electronico":
                        query = "update usuarios set correo_electronico=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("correo_electronico"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "telefono":
                        query = "update usuarios set telefono=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("telefono"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "password":
                        query = "update usuarios set password=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setString(1, (String) updateMap.get("password"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                    case "imagen":
                        query = "update usuarios set imagen=? where id=?";
                        stmt = con.prepareStatement(query);
                        stmt.setBinaryStream(1, (InputStream) updateMap.get("imagen"));
                        stmt.setInt(2, Integer.parseInt((String) updateMap.get("id")));
                        stmt.executeUpdate();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createCurriculum(HashMap<String, Object> updateMap) {
        PreparedStatement stmt;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement("insert into curriculums (user_id, situacion_laboral, "
                    + "formacion_academica, universidad, intereses_profesionales, experiencia_cientifica, "
                    + "logros_cientificos) values (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, (String) updateMap.get("id"));
            stmt.setString(2, (String) updateMap.get("situacion_laboral"));
            stmt.setString(3, (String) updateMap.get("formacion_academica"));
            stmt.setString(4, (String) updateMap.get("universidad"));
            stmt.setString(5, (String) updateMap.get("intereses_profesionales"));
            stmt.setString(6, (String) updateMap.get("experiencia_cientifica"));
            stmt.setString(7, (String) updateMap.get("produccion_cientifica"));
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static HashMap<String, Object> queryByUserID(int UserID) {
        HashMap<String, Object> res = null;
        Statement stmt;
        Connection con = getConnection();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select usuarios.nombre, usuarios.apellidos, "
                    + "usuarios.fecha_nacimiento, usuarios.correo_electronico, usuarios.imagen, "
                    + "curriculums.situacion_laboral, curriculums.formacion_academica, "
                    + "curriculums.universidad, curriculums.intereses_profesionales, "
                    + "curriculums.experiencia_cientifica, curriculums.logros_cientificos "
                    + "from usuarios, curriculums where usuarios.id = " + UserID
                    + " and usuarios.id = curriculums.user_id");
            rs.next();
            String nombre = rs.getString("usuarios.nombre");
            String apellidos = rs.getString("usuarios.apellidos");
            String fecha_nacimiento = rs.getString("usuarios.fecha_nacimiento");
            String correo_electronico = rs.getString("usuarios.correo_electronico");
            Blob imagen = rs.getBlob("usuarios.imagen");
            String situacion_laboral = rs.getString("curriculums.situacion_laboral");
            String formacion_academica = rs.getString("curriculums.formacion_academica");
            String universidad = rs.getString("curriculums.universidad");
            String intereses_profesionales = rs.getString("curriculums.intereses_profesionales");
            String experiencia_cientifica = rs.getString("curriculums.experiencia_cientifica");
            String produccion_cientifica = rs.getString("curriculums.logros_cientificos");
            res = new HashMap<String, Object>();
            res.put("nombre", nombre);
            res.put("apellidos", apellidos);
            res.put("fecha_nacimiento", fecha_nacimiento);
            res.put("correo_electronico", correo_electronico);
            res.put("imagen", imagen);
            res.put("situacion_laboral", situacion_laboral);
            res.put("formacion_academica", formacion_academica);
            res.put("universidad", universidad);
            res.put("intereses_profesionales", intereses_profesionales);
            res.put("experiencia_cientifica", experiencia_cientifica);
            res.put("produccion_cientifica", produccion_cientifica);
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

}
