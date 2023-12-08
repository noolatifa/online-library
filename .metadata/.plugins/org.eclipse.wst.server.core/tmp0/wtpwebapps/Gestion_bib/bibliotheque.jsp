<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bib.models.Livre" %>
<%@ page import="bib.models.Emprunt" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="connexion_DB.ConnexionDB" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bibliothèque</title>
</head>
<body>
    <h2>Ajout de Livre</h2>

    <form action="AjoutLivreServlet" method="post">
        Titre: <input type="text" name="titre" required><br>
        Auteur: <input type="text" name="auteur" required><br>
        Genre: <input type="text" name="genre" required><br>
        Exemplaires disponibles: <input type="number" name="exemplaires" required><br>
        <input type="submit" value="Ajouter Livre">
    </form>

    <%
        // Recuperer le statut de l'ajout du livre depuis la session
        Boolean ajoutLivreSuccess = (Boolean)session.getAttribute("ajoutLivreSuccess");
        if (ajoutLivreSuccess != null) {
            if (ajoutLivreSuccess) {
    %>
                <p style="color: green;">Livre ajouté avec succès !</p>
    <%
            } else {
    %>
                <p style="color: red;">Échec de l'ajout du livre. Veuillez réessayer.</p>
    <%
            }
            // Supprimer l'attribut de session après l'affichage pour éviter la répétition du message
            session.removeAttribute("ajoutLivreSuccess");
        }
    %>

   <h2>Recherche de Livre</h2>
    <form action="RechercheLivreServlet" method="post">
        Critère de recherche: <input type="text" name="critere" required><br>
        <input type="submit" value="Rechercher Livre">
    </form>

 <%
    // Récupérer les résultats de la recherche depuis la session
    List<Livre> resultatsRecherche = (List<Livre>) session.getAttribute("resultatsRecherche");
    if (resultatsRecherche != null && !resultatsRecherche.isEmpty()) {
%>
    <h3>Résultats de la recherche :</h3>
    <table border="1">
        <tr>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Genre</th>
            <th>Exemplaires disponibles</th>
        </tr>
        <%
            for (Livre livre : resultatsRecherche) {
        %>
            <tr>
                <td><%= livre.getTitre() %></td>
                <td><%= livre.getAuteur() %></td>
                <td><%= livre.getGenre() %></td>
                <td><%= livre.getExemplairesDisponibles() %> exemplaires disponibles</td>
            </tr>
        <%
            }
        %>
    </table>
<%
        // Supprimer les résultats de la session après l'affichage
        session.removeAttribute("resultatsRecherche");
    }
%>


<%
    // Récupérer l'utilisateur connecté depuis la session
    String emailUtilisateur = (String) session.getAttribute("email");
    if (emailUtilisateur == null || emailUtilisateur.isEmpty()) {
        // Rediriger vers la page d'authentification si l'utilisateur n'est pas connecté
        response.sendRedirect("authentification.jsp");
    }

    // Récupérer la liste des livres disponibles depuis la bd
    List<Livre> livresDisponibles = obtenirLivresDisponibles();
%>

 <h2>Emprunt de Livre</h2>

    <form action="EmpruntServlet" method="post">
        <label for="livre">Sélectionner un livre :</label>
        <select name="livre" id="livre" required>
            <option value="" disabled selected>Sélectionner un livre</option>
            <% for (Livre livre : livresDisponibles) { %>
                <option value="<%= livre.getTitre() %>"><%= livre.getTitre() %></option>
            <% } %>
        </select>
        <br>

        <label for="datePrise">Date de prise :</label>
        <input type="date" name="datePrise" id="datePrise" required><br>

        <label for="dateRetour">Date de retour :</label>
        <input type="date" name="dateRetour" id="dateRetour" required><br>

        <input type="hidden" name="emailUtilisateur" value="<%= emailUtilisateur %>">
        <input type="submit" value="Emprunter">
    </form>


    <%-- Fonction pour obtenir la liste des livres disponibles --%>
    <%!
        private List<Livre> obtenirLivresDisponibles() {
    	 Connection connexion = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         List<Livre> livres = new ArrayList<>();

         try {
             connexion = ConnexionDB.obtenirConnexion();

             // Sélectionner les livres avec au moins un exemplaire disponible
             String requete = "SELECT * FROM Livres WHERE exemplaires_disponibles > 0";
             preparedStatement = connexion.prepareStatement(requete);
             resultSet = preparedStatement.executeQuery();

             while (resultSet.next()) {
                 Livre livre = new Livre();
                 livre.setTitre(resultSet.getString("titre"));
                 livre.setAuteur(resultSet.getString("auteur"));
                 livre.setGenre(resultSet.getString("genre"));
                 livre.setExemplairesDisponibles(resultSet.getInt("exemplaires_disponibles"));

                 livres.add(livre);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             fermerRessources(resultSet, preparedStatement, connexion);
         }

         return livres;
     }
    
    

     private void fermerRessources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connexion) {
         try {
             if (resultSet != null) {
                 resultSet.close();
             }
             if (preparedStatement != null) {
                 preparedStatement.close();
             }
             /*if (connexion != null) {
                 ConnexionDB.fermerConnexion();
             }*/
         } catch (SQLException e) {
             e.printStackTrace();
         }
    
     }
    %>
    
   

    

</body>
</html>
