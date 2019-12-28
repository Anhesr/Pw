/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.dao;

import es.uco.pw.niusFIK.dao.loginDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
/**
 *
 * @author janthonyo
 */
public class registroDAO {
    
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
    
    /*
    public static boolean insertUserData(Hashtable<String, String> data)
    {
        INSERT INTO `usuarios` (`ID`, `CURRICULUM_ID`, `NOMBRE`, `APELLIDOS`, 
        `FECHA_NACIMIENTO`, `CORREO_ELECTRONICO`, `TELEFONO`, `USUARIO`, 
        `PASSWORD`, `IMAGEN`) 
        VALUES (NULL, '', 'Juana', 'Juanes Juancho', '2019-12-12', 'prueba2@gmail.com', 
        '123456789', 'juanita', '4321', '/assets/img/perfil.jpg');
        
    }
    */
}
