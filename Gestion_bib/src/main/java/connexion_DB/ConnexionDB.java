package connexion_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {

    private static Connection connection = null;

    public static Connection obtenirConnexion() {
        if (connection != null) {
            return connection;
            
        } else {
        	
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/Gestion_bib";
                String user = "root";
                String password = "admin";

                connection = DriverManager.getConnection(url, user, password);
                return connection;
                
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void fermerConnexion() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
