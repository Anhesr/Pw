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

    public static Hashtable<String, String> queryByUserID(int UserID) {
        Hashtable<String, String> res = null;
        Statement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select usuarios.nombre, usuarios.apellidos, "
                    + "usuarios.correo_electronico, usuarios.imagen,  curriculums.situacion_laboral, "
                    + "curriculums.formacion_academica, curriculums.universidad, "
                    + "curriculums.intereses_profesionales, curriculums.experiencia_cientifica, "
                    + "curriculums.logros_cientificos "
                    + "from usuarios, curriculums where usuarios.id = " + UserID
                    + " and usuarios.curriculum_id = curriculums.id");
            rs.next();
            String nombre = rs.getString("usuarios.nombre");
            String apellidos = rs.getString("usuarios.apellidos");
            String correo_electronico = rs.getString("usuarios.correo_electronico");
            String imagen = rs.getString("usuarios.imagen");
            String situacion_laboral = rs.getString("curriculums.situacion_laboral");
            String formacion_academica = rs.getString("curriculums.formacion_academica");
            String universidad = rs.getString("curriculums.universidad");
            String intereses_profesionales = rs.getString("curriculums.intereses_profesionales");
            String experiencia_cientifica = rs.getString("curriculums.experiencia_cientifica");
            String produccion_cientifica = rs.getString("curriculums.logros_cientificos");
            res = new Hashtable<String, String>();
            res.put("nombre", nombre);
            res.put("apellidos", apellidos);
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

    public static void updateCV(Hashtable<String, String> cv) {
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
