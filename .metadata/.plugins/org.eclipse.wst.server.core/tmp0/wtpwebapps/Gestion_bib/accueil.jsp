<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap">
    
</head>
<body>

<%
    // Recuperation de la session existante
    HttpSession sessionex = request.getSession(true);

    if (sessionex != null && sessionex.getAttribute("email") != null) {
        String userEmail = (String) sessionex.getAttribute("email");
%>

    <h1>Bienvenue <%= userEmail %> !</h1>
    

<%
    } else {
%>

    <h1>Bienvenue Invité !</h1>

<%
    }
%>

</body>
</html>
