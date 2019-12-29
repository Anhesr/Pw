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
    
    private String uID;
    private String uName;
    private String uLogin;
    private String cvID;
    
    public userBean() { }
    
    public void setIdUser(String idUser){
        this.uID = idUser;    }
    
    public String getIdUser() {return uID;}
    
    public void setIdCurriculum(String idCurriculum){
        this.cvID = idCurriculum;}
    
    public String getIdCurriculum() {return cvID;}
    
    public void setUserName(String name){
        this.uName = name;}
    
    public String getUserName() {return uName;}
    
    public void setUserLogin(String login){
        this.uLogin = login;}
    
    public String getUserLogin() {return uLogin;}
}