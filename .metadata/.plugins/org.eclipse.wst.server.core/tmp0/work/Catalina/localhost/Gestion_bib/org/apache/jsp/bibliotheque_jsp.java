/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.1
 * Generated at: 2023-12-13 14:30:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import bib.models.Livre;
import bib.models.Emprunt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connexion_DB.ConnexionDB;

public final class bibliotheque_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {


    

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
    
  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.sql.SQLException");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("bib.models.Livre");
    _jspx_imports_classes.add("bib.models.Emprunt");
    _jspx_imports_classes.add("connexion_DB.ConnexionDB");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Bibliothèque</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("    \r\n");
      out.write("    ");

    // Recuperation de la session existante
    HttpSession sessionex = request.getSession(true);

    if (sessionex != null && sessionex.getAttribute("email") != null) {
        String userEmail = (String) sessionex.getAttribute("email");

      out.write("\r\n");
      out.write("\r\n");
      out.write("    <h1 style=\"font-size: 20px;text-align:center;margin:20px;color:#39b2cd\">Bienvenue ");
      out.print( userEmail );
      out.write(" !</h1>\r\n");
      out.write("  \r\n");

    } else {

      out.write("\r\n");
      out.write("\r\n");
      out.write("    <h1>Bienvenue Invité !</h1>\r\n");
      out.write("\r\n");

    }

      out.write("\r\n");
      out.write("    \r\n");
      out.write("        <h1>Ajout de Livre</h1>\r\n");
      out.write("       \r\n");
      out.write("        <form action=\"AjoutLivreServlet\" method=\"post\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"column\">\r\n");
      out.write("                    <label for=\"Titre\">Titre : </label>\r\n");
      out.write("                    <input type=\"text\" name=\"titre\"  id=\"titre\" placeholder=\"Titre\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"column\">\r\n");
      out.write("                    <label for=\"Auteur\">Auteur :</label>\r\n");
      out.write("                    <input type=\"text\" name=\"auteur\" id=\"Auteur\"  placeholder=\"Auteur\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"column\">\r\n");
      out.write("                    <label for=\"Genre\">Genre :</label>\r\n");
      out.write("                    <input type=\"text\" name=\"genre\" id=\"Genre\" placeholder=\"Genre\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"column\">\r\n");
      out.write("                    <label for=\"contact\">Exemplaires disponibles:</label>\r\n");
      out.write("                    <input type=\"number\"  name=\"exemplaires\" id=\"contact\" placeholder=\"0\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <input id=\"bt\" type=\"submit\" value=\"Ajouter Livre\">\r\n");
      out.write("            \r\n");
      out.write("        </form>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        ");

        // Recuperer le statut de l'ajout du livre depuis la session
        Boolean ajoutLivreSuccess = (Boolean)session.getAttribute("ajoutLivreSuccess");
        if (ajoutLivreSuccess != null) {
            if (ajoutLivreSuccess) {
    
      out.write("\r\n");
      out.write("                <p style=\"color: green;\">Livre ajouté avec succès !</p>\r\n");
      out.write("    ");

            } else {
    
      out.write("\r\n");
      out.write("                <p style=\"color: red;\">Échec de l'ajout du livre. Veuillez réessayer.</p>\r\n");
      out.write("    ");

            }
            // Supprimer l'attribut de session après l'affichage pour éviter la répétition du message
            session.removeAttribute("ajoutLivreSuccess");
        }
    
      out.write("\r\n");
      out.write("         <h1>Recherche de Livre</h1>\r\n");
      out.write("         <br>\r\n");
      out.write("        <form action=\"RechercheLivreServlet\" method=\"post\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"column\">\r\n");
      out.write("                    <label for=\"critere\">Critère de recherche : </label>\r\n");
      out.write("                    <input type=\"text\" name=\"critere\" name=\"critere\"  id=\"critere\" placeholder=\"Critère de recherche\">\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        <input id=\"bt1\" type=\"submit\" value=\"Rechercher Livre\">\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        ");

        // Récupérer les résultats de la recherche depuis la session
        List<Livre> resultatsRecherche = (List<Livre>) session.getAttribute("resultatsRecherche");
        if (resultatsRecherche != null && !resultatsRecherche.isEmpty()) {
    
      out.write("\r\n");
      out.write("        <br>\r\n");
      out.write("        <h3>Résultats de la recherche :</h3>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <table border=\"1\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Titre</th>\r\n");
      out.write("                <th>Auteur</th>\r\n");
      out.write("                <th>Genre</th>\r\n");
      out.write("                <th>Exemplaires disponibles</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

                for (Livre livre : resultatsRecherche) {
            
      out.write("\r\n");
      out.write("            <br>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>");
      out.print( livre.getTitre() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( livre.getAuteur() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( livre.getGenre() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( livre.getExemplairesDisponibles() );
      out.write(" exemplaires disponibles</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        ");

        // Supprimer les résultats de la session après l'affichage
        session.removeAttribute("resultatsRecherche");
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    // Récupérer l'utilisateur connecté depuis la session
    String emailUtilisateur = (String) session.getAttribute("email");
    if (emailUtilisateur == null || emailUtilisateur.isEmpty()) {
        // Rediriger vers la page d'authentification si l'utilisateur n'est pas connecté
        response.sendRedirect("authentification.jsp");
    }

    // Récupérer la liste des livres disponibles depuis la bd
    List<Livre> livresDisponibles = obtenirLivresDisponibles();

      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("        <h1>Emprunt de Livre</h1>\r\n");
      out.write("    <form action=\"EmpruntServlet\" method=\"post\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"column\">\r\n");
      out.write("                <label for=\"livre\">Sélectionner un livre : </label>\r\n");
      out.write("                <select name=\"livre\" id=\"livre\" required>\r\n");
      out.write("                    <option value=\"\" disabled selected>Sélectionner un livre</option>\r\n");
      out.write("                    ");
 for (Livre livre : livresDisponibles) { 
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print( livre.getTitre() );
      out.write('"');
      out.write('>');
      out.print( livre.getTitre() );
      out.write("</option>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                </select>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"column\">\r\n");
      out.write("                <label for=\"datePrise\">Date de prise :</label>\r\n");
      out.write("                <input type=\"date\" name=\"datePrise\" id=\"datePrise\" placeholder=\"datePrise\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"column\">\r\n");
      out.write("                <label for=\"dateRetour\">Date de retour :</label>\r\n");
      out.write("                <input type=\"date\"  name=\"dateRetour\" id=\"dateRetour\" placeholder=\"dateRetour\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <input type=\"hidden\" name=\"emailUtilisateur\" value=\"");
      out.print( emailUtilisateur );
      out.write("\">\r\n");
      out.write("        <input id=\"bt\" type=\"submit\" value=\"Emprunter\">\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("    \r\n");
      out.write("    ");

    // Récupérer l'utilisateur connecté depuis la session
    if (emailUtilisateur == null || emailUtilisateur.isEmpty()) {
        // Rediriger vers la page d'authentification si l'utilisateur n'est pas connecté
        response.sendRedirect("authentification.jsp");
    }

    // Récupérer la liste des livres disponibles depuis la bd
    //List<Emprunt> HistoriqueE = historiqueEmprunts();

      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("    <br>\r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("    <div>\r\n");
      out.write("    \r\n");
      out.write("    <h1>Historique des Emprunts</h1>\r\n");
      out.write(" 		<br>\r\n");
      out.write("       	 <br>\r\n");

    List<Emprunt> historiqueEmprunts = (List<Emprunt>) request.getAttribute("historiqueEmprunts");

    if (historiqueEmprunts != null && !historiqueEmprunts.isEmpty()) {

      out.write("\r\n");
      out.write("\r\n");
      out.write("    <table border=\"1\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>Titre</th>\r\n");
      out.write("            <th>Date d'emprunt</th>\r\n");
      out.write("            <th>Date de retour</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("        ");
 for (Emprunt emprunt : historiqueEmprunts) { 
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print( emprunt.getIdLivre() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( emprunt.getDateEmprunt() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( emprunt.getDateRetour() );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        ");
  }
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");

    }else {

      out.write("\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("    <p>Aucun emprunt dans l'historique.</p>\r\n");
      out.write("<br>\r\n");

    }
    

      out.write("\r\n");
      out.write("\r\n");
      out.write("<form  action=\"ListerHistoriqueServlet\" method=\"post\">\r\n");
      out.write("<button type=\"submit\" id=\"bt3\" >Lister Historique de vos Emprunts</button>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("\r\n");
      out.write("    <h1>Déconnexion</h1>\r\n");
      out.write("    <form action=\"LogoutServlet\" method=\"post\">\r\n");
      out.write("        <button  type=\"submit\" id=\"bt\">Se déconnecter</button>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("    </div>\r\n");
      out.write("  \r\n");
      out.write("   </div> 	\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("<STYLE>\r\n");
      out.write("    *,\r\n");
      out.write("*:before,\r\n");
      out.write("*:after{\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("    font-family: \"Poppins\",sans-serif;\r\n");
      out.write("    font-weight: 500;\r\n");
      out.write("}\r\n");
      out.write("body{\r\n");
      out.write("    height: 100vh;\r\n");
      out.write("    background: #f8f8f8;\r\n");
      out.write("}\r\n");
      out.write(".container{\r\n");
      out.write("    background-color: #ffffff;\r\n");
      out.write("    max-height: 1000%;\r\n");
      out.write("    width: 70%;\r\n");
      out.write("    min-width: 430px;\r\n");
      out.write("    padding: 35px 50px;\r\n");
      out.write("    transform: translate();\r\n");
      out.write("    position: relative;\r\n");
      out.write("    left: 190px;\r\n");
      out.write("    top: 10%;\r\n");
      out.write("    border-radius: 10px;\r\n");
      out.write("    box-shadow: 20px 20px 30px 25px rgba(1,0,1,0.15);\r\n");
      out.write("}\r\n");
      out.write("h1{\r\n");
      out.write("    font-size: 30px;\r\n");
      out.write("   \r\n");
      out.write("    color: #1c093c;\r\n");
      out.write("}\r\n");
      out.write("h3{\r\n");
      out.write("    font-size: 15px;\r\n");
      out.write("   \r\n");
      out.write("    color: #e02929;\r\n");
      out.write("}\r\n");
      out.write("p{\r\n");
      out.write("    position: relative;\r\n");
      out.write("    margin: auto;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    color: #606060;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    font-weight: 400;\r\n");
      out.write("}\r\n");
      out.write("form{\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    position: relative;\r\n");
      out.write("    margin: 30px auto 0 auto;\r\n");
      out.write("}\r\n");
      out.write(".row{\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    display: grid;\r\n");
      out.write("    grid-template-columns: repeat(auto-fit, minmax(300px,1fr));\r\n");
      out.write("    grid-gap: 20px 30px;\r\n");
      out.write("    margin-bottom: 20px;\r\n");
      out.write("}\r\n");
      out.write("label{\r\n");
      out.write("    color: #1c093c;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("textarea,\r\n");
      out.write("input{\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    font-weight: 400;\r\n");
      out.write("    padding: 8px 10px;\r\n");
      out.write("    border-radius: 5px;\r\n");
      out.write("    border: 1.2px solid #c4cae0;\r\n");
      out.write("    margin-top: 5px;\r\n");
      out.write("}\r\n");
      out.write("textarea{\r\n");
      out.write("    resize: none;\r\n");
      out.write("}\r\n");
      out.write("textarea:focus,\r\n");
      out.write("input:focus{\r\n");
      out.write("    outline: none;\r\n");
      out.write("    border-color: #6f6df4;\r\n");
      out.write("}\r\n");
      out.write("#bt{\r\n");
      out.write("    border: none;\r\n");
      out.write("    padding: 10px 20px;\r\n");
      out.write("    background: #39b2cd;\r\n");
      out.write("   \r\n");
      out.write("    color: #ffffff;\r\n");
      out.write("    border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write("#bt1{\r\n");
      out.write("    border: none;\r\n");
      out.write("    padding: 10px 20px;\r\n");
      out.write("      background: #39b2cd;\r\n");
      out.write("\r\n");
      out.write("    color: #ffffff;\r\n");
      out.write("    border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write("#bt3{\r\n");
      out.write("    border: none;\r\n");
      out.write("    padding: 10px 20px;\r\n");
      out.write("      background: #39b2cd;\r\n");
      out.write("width :100%;\r\n");
      out.write("    color: #ffffff;\r\n");
      out.write("    border-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write("table{\r\n");
      out.write(" width: 100%; \r\n");
      out.write(" border-collapse: collapse;\r\n");
      out.write(" border-spacing: 0;\r\n");
      out.write(" box-shadow: 0 2px 15px rgba(64,64,64,.7);\r\n");
      out.write(" border-radius: 12px 12px 0 0;\r\n");
      out.write(" overflow: hidden;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("td , th{\r\n");
      out.write(" padding: 5px 5px;\r\n");
      out.write(" text-align: center;\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("th{\r\n");
      out.write(" background: #39b2cd;\r\n");
      out.write(" color: #fafafa;\r\n");
      out.write(" font-family: 'Open Sans',Sans-serif;\r\n");
      out.write(" font-weight: 200;\r\n");
      out.write(" text-transform: uppercase;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("tr{\r\n");
      out.write(" width: 70%;\r\n");
      out.write(" background-color: #fafafa;\r\n");
      out.write(" font-family: 'Montserrat', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("tr:nth-child(even){\r\n");
      out.write(" background-color: #eeeeee;\r\n");
      out.write("}\r\n");
      out.write("/* Style de base pour le menu déroulant */\r\n");
      out.write("#livre {\r\n");
      out.write("    width: 200px; /* Ajustez la largeur selon vos préférences */\r\n");
      out.write("    padding: 8px;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    border: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Style pour les options du menu déroulant */\r\n");
      out.write("#livre option {\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" * {\r\n");
      out.write("            font-family: 'Poppins', sans-serif;\r\n");
      out.write("            /* Add other styles as needed */\r\n");
      out.write("        }\r\n");
      out.write("</STYLE>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
