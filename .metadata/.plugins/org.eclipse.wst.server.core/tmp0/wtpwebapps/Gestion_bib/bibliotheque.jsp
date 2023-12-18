<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bibliothèque</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap">

</head>
<body>
    <div class="container">
    
    <%
    // Recuperation de la session existante
    HttpSession sessionex = request.getSession(true);

    if (sessionex != null && sessionex.getAttribute("email") != null) {
        String userEmail = (String) sessionex.getAttribute("email");
%>

    <h1 style="font-size: 20px;text-align:center;margin:20px;color:#39b2cd">Bienvenue <%= userEmail %> !</h1>
  
<%
    } else {
%>

    <h1>Bienvenue Invité !</h1>

<%
    }
%>
    
        <h1>Ajout de Livre</h1>
       
        <form action="AjoutLivreServlet" method="post">
            <div class="row">
                <div class="column">
                    <label for="Titre">Titre : </label>
                    <input type="text" name="titre"  id="titre" placeholder="Titre">
                </div>
                <div class="column">
                    <label for="Auteur">Auteur :</label>
                    <input type="text" name="auteur" id="Auteur"  placeholder="Auteur">
                </div>
            </div>
            <div class="row">
                <div class="column">
                    <label for="Genre">Genre :</label>
                    <input type="text" name="genre" id="Genre" placeholder="Genre">
                </div>
                <div class="column">
                    <label for="contact">Exemplaires disponibles:</label>
                    <input type="number"  name="exemplaires" id="contact" placeholder="0">
                </div>
            </div>
            <input id="bt" type="submit" value="Ajouter Livre">
            
        </form>
        <br>
        <br>
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
         <h1>Recherche de Livre</h1>
         <br>
        <form action="RechercheLivreServlet" method="post">
            <div class="row">
                <div class="column">
                    <label for="critere">Critère de recherche : </label>
                    <input type="text" name="critere" name="critere"  id="critere" placeholder="Critère de recherche">
                    
                </div>
            </div>
        <input id="bt1" type="submit" value="Rechercher Livre">

        </form>
        
        
        
        <%
        // Récupérer les résultats de la recherche depuis la session
        List<Livre> resultatsRecherche = (List<Livre>) session.getAttribute("resultatsRecherche");
        if (resultatsRecherche != null && !resultatsRecherche.isEmpty()) {
    %>
        <br>
        <h3>Résultats de la recherche :</h3>
        <br>
        <br>
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
            <br>
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
        <br>
        <br>
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
<br>
        <h1>Emprunt de Livre</h1>
    <form action="EmpruntServlet" method="post">
        <div class="row">
            <div class="column">
                <label for="livre">Sélectionner un livre : </label>
                <select name="livre" id="livre" required>
                    <option value="" disabled selected>Sélectionner un livre</option>
                    <% for (Livre livre : livresDisponibles) { %>
                        <option value="<%= livre.getTitre() %>"><%= livre.getTitre() %></option>
                    <% } %>
                </select>
            </div>
            
        </div>
        <div class="row">
            <div class="column">
                <label for="datePrise">Date de prise :</label>
                <input type="date" name="datePrise" id="datePrise" placeholder="datePrise">
            </div>
            <div class="column">
                <label for="dateRetour">Date de retour :</label>
                <input type="date"  name="dateRetour" id="dateRetour" placeholder="dateRetour">
            </div>
        </div>
        <input type="hidden" name="emailUtilisateur" value="<%= emailUtilisateur %>">
        <input id="bt" type="submit" value="Emprunter">

    </form>
    
    <%
    // Récupérer l'utilisateur connecté depuis la session
    if (emailUtilisateur == null || emailUtilisateur.isEmpty()) {
        // Rediriger vers la page d'authentification si l'utilisateur n'est pas connecté
        response.sendRedirect("authentification.jsp");
    }

    // Récupérer la liste des livres disponibles depuis la bd
    //List<Emprunt> HistoriqueE = historiqueEmprunts();
%>
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
   
   

    <br>
    
     
    <div>
    
    <h1>Historique des Emprunts</h1>
 		<br>
       	 <br>
<%
    List<Emprunt> historiqueEmprunts = (List<Emprunt>) request.getAttribute("historiqueEmprunts");

    if (historiqueEmprunts != null && !historiqueEmprunts.isEmpty()) {
%>

    <table border="1">
        <tr>
            <th>Titre</th>
            <th>Date d'emprunt</th>
            <th>Date de retour</th>
        </tr>

        <% for (Emprunt emprunt : historiqueEmprunts) { %>
            <tr>
                <td><%= emprunt.getIdLivre() %></td>
                <td><%= emprunt.getDateEmprunt() %></td>
                <td><%= emprunt.getDateRetour() %></td>
            </tr>
        <%  }%>

    </table>

<%
    }else {
%>

<br>
    <p>Aucun emprunt dans l'historique.</p>
<br>
<%
    }
    
%>

<form  action="ListerHistoriqueServlet" method="post">
<button type="submit" id="bt3" >Lister Historique de vos Emprunts</button>

</form>



<div>

    <h1>Déconnexion</h1>
    <form action="LogoutServlet" method="post">
        <button  type="submit" id="bt">Se déconnecter</button>
    </form>
</div>
    </div>
  
   </div> 	

</body>
</html>
<STYLE>
    *,
*:before,
*:after{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
    font-family: "Poppins",sans-serif;
    font-weight: 500;
}
body{
    height: 100vh;
    background: #f8f8f8;
}
.container{
    background-color: #ffffff;
    max-height: 1000%;
    width: 70%;
    min-width: 430px;
    padding: 35px 50px;
    transform: translate();
    position: relative;
    left: 190px;
    top: 10%;
    border-radius: 10px;
    box-shadow: 20px 20px 30px 25px rgba(1,0,1,0.15);
}
h1{
    font-size: 30px;
   
    color: #1c093c;
}
h3{
    font-size: 15px;
   
    color: #e02929;
}
p{
    position: relative;
    margin: auto;
    width: 100%;
    text-align: center;
    color: #606060;
    font-size: 14px;
    font-weight: 400;
}
form{
    width: 100%;
    position: relative;
    margin: 30px auto 0 auto;
}
.row{
    width: 100%;
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(300px,1fr));
    grid-gap: 20px 30px;
    margin-bottom: 20px;
}
label{
    color: #1c093c;
    font-size: 14px;
}
textarea,
input{
    width: 100%;
    font-weight: 400;
    padding: 8px 10px;
    border-radius: 5px;
    border: 1.2px solid #c4cae0;
    margin-top: 5px;
}
textarea{
    resize: none;
}
textarea:focus,
input:focus{
    outline: none;
    border-color: #6f6df4;
}
#bt{
    border: none;
    padding: 10px 20px;
    background: #39b2cd;
   
    color: #ffffff;
    border-radius: 3px;
}
#bt1{
    border: none;
    padding: 10px 20px;
      background: #39b2cd;

    color: #ffffff;
    border-radius: 3px;
}
#bt3{
    border: none;
    padding: 10px 20px;
      background: #39b2cd;
width :100%;
    color: #ffffff;
    border-radius: 3px;
}
table{
 width: 100%; 
 border-collapse: collapse;
 border-spacing: 0;
 box-shadow: 0 2px 15px rgba(64,64,64,.7);
 border-radius: 12px 12px 0 0;
 overflow: hidden;

}
td , th{
 padding: 5px 5px;
 text-align: center;
 

}
th{
 background: #39b2cd;
 color: #fafafa;
 font-family: 'Open Sans',Sans-serif;
 font-weight: 200;
 text-transform: uppercase;

}
tr{
 width: 70%;
 background-color: #fafafa;
 font-family: 'Montserrat', sans-serif;
}
tr:nth-child(even){
 background-color: #eeeeee;
}
/* Style de base pour le menu déroulant */
#livre {
    width: 200px; /* Ajustez la largeur selon vos préférences */
    padding: 8px;
    font-size: 14px;
    border: black;
}

/* Style pour les options du menu déroulant */
#livre option {
    font-size: 14px;
}


 * {
            font-family: 'Poppins', sans-serif;
            /* Add other styles as needed */
        }
</STYLE>