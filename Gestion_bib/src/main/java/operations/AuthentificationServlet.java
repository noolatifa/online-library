package operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connexion_DB.ConnexionDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = ConnexionDB.obtenirConnexion();

            if (connexion != null) {
                // vérifier si l user est déjà authentifié
                HttpSession session = request.getSession();

                if (session != null && session.getAttribute("email") != null) {
                    // si user est dejàà authetifié --> redirect page d'accueil
                    response.sendRedirect("accueil.jsp");
                    return;
                }

                String requete = "SELECT * FROM Utilisateurs WHERE email = ? AND mot_de_passe = ?";
                preparedStatement = connexion.prepareStatement(requete);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, motDePasse);

                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // L'authentification done
                    // invalidation de la session existante 
                    session.invalidate();

                    // création d'une nouvelle session
                    session = request.getSession(true);
                    session.setAttribute("email", email);

                    // redirection vers la page d'accueil
                    response.sendRedirect("accueil.jsp");
                } else {
                    // echec de l'authentification
                   // ConnexionDB.fermerConnexion();
                    request.setAttribute("errorMessage", "Échec de l'authentification. Veuillez vérifier votre email et mot de passe.");
                    request.getRequestDispatcher("authentification.jsp").forward(request, response);
                    
                }
            } else {
                // La connexion à la base de données a échoué
                request.setAttribute("errorMessage", "Connexion à la base de données a échoué!");
                request.getRequestDispatcher("authentification.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur lors de la connexion à la base de données!");
            request.getRequestDispatcher("authentification.jsp").forward(request, response);
        } finally {
            fermerRessources(resultSet, preparedStatement);
            
        }

        out.close();
    }

    private void fermerRessources(ResultSet resultSet, PreparedStatement preparedStatement) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
