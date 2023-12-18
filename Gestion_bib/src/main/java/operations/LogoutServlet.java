package operations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Rediriger vers la page d'authentification en cas d'accès direct à la servlet
        response.sendRedirect("authentification.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer la session
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Invalider la session
            session.invalidate();
        }

        // Rediriger vers la page d'authentification après la déconnexion
        response.sendRedirect("authentification.jsp");
    }
}