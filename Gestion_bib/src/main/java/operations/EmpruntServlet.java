package operations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connexion_DB.ConnexionDB;

/**
 * Servlet implementation class EmpruntServlet
 */
public class EmpruntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpruntServlet() {
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String emailUtilisateur = request.getParameter("emailUtilisateur");
        String titreLivre = request.getParameter("livre");
        String datePrise = request.getParameter("datePrise");
        String dateRetour = request.getParameter("dateRetour");

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = ConnexionDB.obtenirConnexion();

            int idUtilisateur = obtenirIdUtilisateurParEmail(emailUtilisateur);

       
            int idLivre = obtenirIdLivreParTitre(titreLivre);

            // Vérifier si le livre est disponible
            if (estLivreDisponible(titreLivre, connexion)) {
            	
                // Mettre à jour la bd pour marquer un livre comme emprunté
                String updateRequete = "UPDATE Livres SET exemplaires_disponibles = exemplaires_disponibles - 1 WHERE titre = ?";
                preparedStatement = connexion.prepareStatement(updateRequete);
                preparedStatement.setString(1, titreLivre);
                preparedStatement.executeUpdate();

                // insertion into la table emprunts de la bd
                String insertRequete = "INSERT INTO Emprunts (id_utilisateur, id_livre, date_emprunt, date_retour, statut) VALUES (?, ?, ?, ?, ?)";
                preparedStatement = connexion.prepareStatement(insertRequete);
                preparedStatement.setInt(1, idUtilisateur);
                preparedStatement.setInt(2, idLivre);
                preparedStatement.setString(3, datePrise);
                preparedStatement.setString(4, dateRetour);
             // Determiner l'etat de l'emprunt
                java.util.Date currentDate = new java.util.Date();
                java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());

                if (sqlCurrentDate.after(java.sql.Date.valueOf(dateRetour))) {

                	preparedStatement.setString(5, "retourné");
                } else if (sqlCurrentDate.after(java.sql.Date.valueOf(datePrise))) {

                	preparedStatement.setString(5, "en cours");
                } else {

                	preparedStatement.setString(5, "réservé");
                }

                preparedStatement.executeUpdate();
                // EMPRUNT DONE AVEC SUCCES
                out.println("<p style='color: green;'>Emprunt réussi. Veuillez noter les dates d'emprunt et de retour.</p>");
            } else {
                // BOOK DOESN'T EXIST
                out.println("<p style='color: red;'>Le livre n'est pas disponible pour l'emprunt.</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // HANDLE ERROR
            out.println("<p style='color: red;'>Erreur lors du processus d'emprunt.</p>");
        } finally {
            fermerRessources(preparedStatement, connexion);
        }

        out.close();
    }

	
	
	private int obtenirIdUtilisateurParEmail(String email) {
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int idUtilisateur = -1;  // Valeur par defaut si l'email n'est pas trouvé

	    try {
	        connexion = ConnexionDB.obtenirConnexion();

	        String requete = "SELECT id_utilisateur FROM Utilisateurs WHERE email = ?";
	        preparedStatement = connexion.prepareStatement(requete);
	        preparedStatement.setString(1, email);

	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            idUtilisateur = resultSet.getInt("id_utilisateur");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    } finally {
	        fermerRessources(preparedStatement, connexion);
	    }

	    return idUtilisateur;
	}

	
	
	
	private int obtenirIdLivreParTitre(String titreLivre) {
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int idLivre = -1;  // Valeur par défaut si le livre n'est pas trouvé

	    try {
	        connexion = ConnexionDB.obtenirConnexion();

	        String requete = "SELECT id_livre FROM Livres WHERE titre = ?";
	        preparedStatement = connexion.prepareStatement(requete);
	        preparedStatement.setString(1, titreLivre);

	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            idLivre = resultSet.getInt("id_livre");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        fermerRessources(preparedStatement, connexion);
	    }

	    return idLivre;
	}

    private boolean estLivreDisponible(String titreLivre, Connection connexion) throws SQLException {
        // Vérifier si le livre est dispo et nb exemplaires >0
        String requete = "SELECT exemplaires_disponibles FROM Livres WHERE titre = ?";
        try (PreparedStatement preparedStatement = connexion.prepareStatement(requete)) {
            preparedStatement.setString(1, titreLivre);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next() && resultSet.getInt("exemplaires_disponibles") > 0;
            }
        }
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
