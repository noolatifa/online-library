package bib.models;

public class Livre {

	private int idLivre;
	private String titre;
	private String auteur;
	private String genre;
	private int exemplairesDisponibles;

	// Getters
    public int getIdLivre() {
        return idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getGenre() {
        return genre;
    }

    public int getExemplairesDisponibles() {
        return exemplairesDisponibles;
    }

    // Setters
    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setExemplairesDisponibles(int exemplairesDisponibles) {
        this.exemplairesDisponibles = exemplairesDisponibles;
    }

	
}
