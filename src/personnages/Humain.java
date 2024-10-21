package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	public Humain(String nom, String boisson_favorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boisson_favorite;
		this.argent = argent;
	}

	public void gagnerArgent(int gain) {
		argent = getArgent() + gain;
	}

	public void perdreArgent(int perte) {
		argent = getArgent() - perte;
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + getNom() + " et j'aime boire du " + boissonFavorite + ".");
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}
	
	public String acheter(String bien, int prix) {
		if (getArgent() >= prix) {
			parler("J'ai " + getArgent() + " sous en poche. Je vais pouvoir m'offrir " +  bien + " à " + prix + " sous.");
			perdreArgent(prix);
			return bien;
		} else {
			parler("Je n'ai plus que " + getArgent() + " sous en poche. Je ne peux même pas m'offrir " +  bien + " à " + prix + " sous.");
			return null;
		}
	}

	public void parler(String parole) {
		System.out.println("(" + getNom() + ") - " + parole);
	}


}
