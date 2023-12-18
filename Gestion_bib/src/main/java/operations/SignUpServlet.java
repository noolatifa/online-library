package operations;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connexion_DB.ConnexionDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = ConnexionDB.obtenirConnexion();

            if (connexion != null) {
                String requete = "INSERT INTO Utilisateurs (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?, ?)";
                preparedStatement = connexion.prepareStatement(requete);
                preparedStatement.setString(1, nom);
                preparedStatement.setString(2, prenom);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, motDePasse);

                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    out.println("<p>Utilisateur inscrit avec succès!</p>");
                    response.sendRedirect("authentification.jsp"); 
                } else {
                    out.println("<p>Erreur lors de l'inscription de l'utilisateur.</p>");
                }
            } else {
                out.println("<p>Connexion à la base de données a échoué!</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Erreur lors de la connexion à la base de données!</p>");
        } finally {
            fermerRessources(null, preparedStatement);
        }

        out.close();
    }

    private void fermerRessources(Connection connexion, PreparedStatement preparedStatement) {
        try {
            if (connexion != null) {
                connexion.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
