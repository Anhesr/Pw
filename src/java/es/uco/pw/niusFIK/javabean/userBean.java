/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uco.pw.niusFIK.javabean;

import java.io.Serializable;

/**
 *
 * @author janthonyo
 */
public class userBean implements java.io.Serializable {
    
    private String idUser = "";
    private String idCurriculum = "";
    private String uName = "";
    
    public userBean() { }
    
    public void setIdUser(String idUser){
        this.idUser = idUser;    }
    
    public String getIdUser() {return idUser;}
    
    public void setIdCurriculum(String idCurriculum){
        this.idCurriculum = idCurriculum;}
    
    public String getIdCurriculum() {return idCurriculum;}
    
    public void setUserName(String name){
        this.uName = name;}
    
    public String getUserName() {return uName;}
}