package operations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bib.models.Livre;
import connexion_DB.ConnexionDB;

/**
 * Servlet implementation class RechercheLivreServlet
 */
public class RechercheLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheLivreServlet() {
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
        // Recuperer le criteria de recherche depuis le formulaire
        String critere = request.getParameter("critere");

        // recherche mel BD
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Livre> resultats = new ArrayList<>();

        try {
            connexion = ConnexionDB.obtenirConnexion();

            String requete = "SELECT * FROM Livres WHERE titre LIKE ? OR auteur LIKE ? OR genre LIKE ?";
            preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, "%" + critere + "%");
            preparedStatement.setString(2, "%" + critere + "%");
            preparedStatement.setString(3, "%" + critere + "%");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Livre livre = new Livre();
                livre.setTitre(resultSet.getString("titre"));
                livre.setAuteur(resultSet.getString("auteur"));
                livre.setGenre(resultSet.getString("genre"));
                livre.setExemplairesDisponibles(resultSet.getInt("exemplaires_disponibles"));

                resultats.add(livre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
          
        } finally {
            fermerRessources(resultSet, preparedStatement, connexion);
        }

        // Stocker les resultats dans la session pour les afficher sur la page JSP
        request.getSession().setAttribute("resultatsRecherche", resultats);

        // Redirection vers la page d'origine
        response.sendRedirect("bibliotheque.jsp");
    }

    private void fermerRessources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connexion) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
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
