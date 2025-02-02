package connexion_DB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Servlet implementation class TestConnexionServlet
 */

public class TestConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();

	        
	        
	        
	        Connection connection = ConnexionDB.obtenirConnexion();

	        if (connection != null) {
	            out.println("<html><body><h2>Connexion à la base de données réussie!</h2></body></html>");

	            // Exemple de requête de sélection
	            try {
	                String sql = "SELECT * FROM Livres";
	                PreparedStatement preparedStatement = connection.prepareStatement(sql);
	                ResultSet resultSet = preparedStatement.executeQuery();

	                while (resultSet.next()) {
	                    out.println("ID Livre : " + resultSet.getInt("id_livre") + "<br>");
	                    out.println("Titre : " + resultSet.getString("titre") + "<br>");
	                    out.println("Auteur : " + resultSet.getString("auteur") + "<br>");
	                }

	            } catch (SQLException e) {
	                e.printStackTrace();
	            } finally {
	              ConnexionDB.fermerConnexion();
		          out.println("<html><body><h2>Connexion à la base de données fermée!</h2></body></html>");

	            }

	        } else {
	            out.println("<html><body><h2>La connexion à la base de données a échoué!</h2></body></html>");
	        }

	        out.close();
	    	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
