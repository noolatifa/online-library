

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
import java.util.ArrayList;
import java.util.List;

import bib.models.Emprunt;
import connexion_DB.ConnexionDB;

/**
 * Servlet implementation class ListerHistoriqueServlet
 */
public class ListerHistoriqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerHistoriqueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailUtilisateur = (String) request.getSession().getAttribute("email");
        List<Emprunt> emprunts = historiqueEmprunts(emailUtilisateur);
        request.setAttribute("historiqueEmprunts", emprunts);
        request.getRequestDispatcher("/bibliotheque.jsp").forward(request, response);
        
        
        
      /*  response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String emailUtilisateur = (String) request.getSession().getAttribute("email");
        List<Emprunt> emprunts = historiqueEmprunts(emailUtilisateur);

        out.println("<html>");
        out.println("<head><title>Historique des emprunts</title></head>");
        out.println("<body>");

        if (emprunts != null && !emprunts.isEmpty()) {
            out.println("<h1>Historique des emprunts :</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>Titre</th><th>Date d'emprunt</th><th>Date de retour</th></tr>");

            for (Emprunt emprunt : emprunts) {
                out.println("<tr>");
                out.println("<td>" + emprunt.getIdLivre() + "</td>");
                out.println("<td>" + emprunt.getDateEmprunt() + "</td>");
                out.println("<td>" + emprunt.getDateRetour() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        } else {
            out.println("<p>Aucun emprunt dans l'historique.</p>");
        }

        out.println("</body>");
        out.println("</html>");*/
    }
        
    

    private List<Emprunt> historiqueEmprunts(String emailUtilisateur) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Emprunt> emprunts = new ArrayList<>();

        try {
            connexion = ConnexionDB.obtenirConnexion();
            String requete = "SELECT * FROM Emprunts WHERE id_utilisateur = (select id_utilisateur from utilisateurs where email = ? );";
            preparedStatement = connexion.prepareStatement(requete);
            preparedStatement.setString(1, emailUtilisateur);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Emprunt emprunt = new Emprunt();
                emprunt.setIdLivre(resultSet.getInt("id_livre"));
                emprunt.setDateEmprunt(resultSet.getDate("date_emprunt"));
                emprunt.setDateRetour(resultSet.getDate("date_retour"));
                emprunts.add(emprunt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fermerRessources(resultSet, preparedStatement, connexion);
        }

        return emprunts;
    }
    
    
    


    
    
    
    private void fermerRessources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connexion) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connexion != null) {
                ConnexionDB.fermerConnexion();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
