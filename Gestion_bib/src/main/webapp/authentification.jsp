<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authentification</title>
</head>
<body>
    <h1>Authentification</h1>
    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <% if (errorMessage != null && !errorMessage.isEmpty()) { %>
        <p style="color: red;"><%= errorMessage %></p>
    <% } %>
    <form action="AuthentificationServlet" method="post">
        Email: <input type="text" name="email" required><br>
        Mot de passe: <input type="password" name="motDePasse" required><br>
        <input type="submit" value="Se Connecter">
    </form>
</body>
</html>
