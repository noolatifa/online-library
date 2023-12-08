<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
</head>
<body>

<%
    // Recuperation de la session existante
    HttpSession sessionex = request.getSession(true);

    if (sessionex != null && sessionex.getAttribute("email") != null) {
        String userEmail = (String) sessionex.getAttribute("email");
%>

    <h1>Bienvenue <%= userEmail %> !</h1>
     <form action="bibliotheque.jsp" method="get">
        <button type="submit">Accéder à la bibliothèque</button>
    </form>

<%
    } else {
%>

    <h1>Bienvenue Invité !</h1>

<%
    }
%>

</body>
</html>
