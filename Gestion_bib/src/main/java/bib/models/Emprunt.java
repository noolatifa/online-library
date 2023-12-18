package bib.models;
import java.util.Date;

public class Emprunt {
	    private int idEmprunt;
	    private int idUtilisateur;
	    private int idLivre;
	    private Date dateEmprunt;
	    private Date dateRetour;
	    private String statut;
	    private String titreLivre; 

	    // Getters
	    public int getIdEmprunt() {
	        return idEmprunt;
	    }

	    public int getIdUtilisateur() {
	        return idUtilisateur;
	    }

	    public int getIdLivre() {
	        return idLivre;
	    }

	    public Date getDateEmprunt() {
	        return dateEmprunt;
	    }

	    public Date getDateRetour() {
	        return dateRetour;
	    }

	    public String getStatut() {
	        return statut;
	    }

	    // Setters
	    public void setIdEmprunt(int idEmprunt) {
	        this.idEmprunt = idEmprunt;
	    }

	    public void setIdUtilisateur(int idUtilisateur) {
	        this.idUtilisateur = idUtilisateur;
	    }

	    public void setIdLivre(int idLivre) {
	        this.idLivre = idLivre;
	    }

	    public void setDateEmprunt(Date dateEmprunt) {
	        this.dateEmprunt = dateEmprunt;
	    }

	    public void setDateRetour(Date dateRetour) {
	        this.dateRetour = dateRetour;
	    }

	    public void setStatut(String statut) {
	        this.statut = statut;
	    }
	    public void setTitreLivre(String titreLivre) {
	        this.titreLivre = titreLivre;
	    }
}
