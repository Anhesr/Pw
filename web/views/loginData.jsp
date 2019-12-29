<%-- 
    Document   : loginData
    Created on : 29 dic. 2019, 3:42:13
    Author     : janthonyo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Hashtable"%>
<%@page import="es.uco.pw.niusFIK.dao.loginDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Untitled</title>
    </head>
    <body>
        <%Hashtable<String, String> data = (Hashtable<String, String>) request.getAttribute("data");%>
        <jsp:useBean id="usuario" class="es.uco.pw.niusFIK.javabean.userBean"/>
        <jsp:setProperty name="usuario" property="idUser"       value="<%=data.get(\"id\")%>"/>
        <jsp:setProperty name="usuario" property="idCurriculum" value="<%=data.get(\"cv_id\")%>"/>
        <jsp:setProperty name="usuario" property="uName"        value="<%=data.get(\"nombre\")%>"/>
        <jsp:setProperty name="usuario" property="uLogin"       param="<%=data.get(\"user\")%>"/>
    </body>
</html>
