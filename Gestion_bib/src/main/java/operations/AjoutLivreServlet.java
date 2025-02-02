package operations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connexion_DB.ConnexionDB;

/**
 * Servlet implementation class AjoutLivreServlet
 */
public class AjoutLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutLivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Récupérer les détails du livre depuis le formulaire
	        String titre = request.getParameter("titre");
	        String auteur = request.getParameter("auteur");
	        String genre = request.getParameter("genre");
	        int exemplairesDisponibles = Integer.parseInt(request.getParameter("exemplaires"));

	        // Ajouter le livre à la base de données
	        Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = ConnexionDB.obtenirConnexion();

	            String requete = "INSERT INTO Livres (titre, auteur, genre, exemplaires_disponibles) VALUES (?, ?, ?, ?)";
	            preparedStatement = connexion.prepareStatement(requete);
	            preparedStatement.setString(1, titre);
	            preparedStatement.setString(2, auteur);
	            preparedStatement.setString(3, genre);
	            preparedStatement.setInt(4, exemplairesDisponibles);

	            preparedStatement.executeUpdate();

	            // Ajouter un attribut de session pour indiquer le succès
	            request.getSession().setAttribute("ajoutLivreSuccess", true);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Gérer l'erreur (redirection vers une page d'erreur, etc.)
	            request.getSession().setAttribute("ajoutLivreSuccess", false);
	        } finally {
	            fermerRessources(preparedStatement, connexion);
	        }

	        // Redirection vers la page d'origine
	        response.sendRedirect("bibliotheque.jsp");
	    }

	    private void fermerRessources(PreparedStatement preparedStatement, Connection connexion) {
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	           /* if (connexion != null) {
	                ConnexionDB.fermerConnexion();
	            }*/
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


