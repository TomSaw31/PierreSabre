package personnages;

public class Humain {
	// ===== ATTRIBUTS =====
	/** Le nom de l'humain */
	private String nom;
	/** La boisson favorite de l'humain */
	private String boissonFavorite;
	/** L'argent de l'humain */
	private int argent;

	// ===== CONSTRUCTEURS =====
	/**
	 * Crée un objet de classe humain en fonction d'un nom, une boisson préférée et
	 * l'argent de départ
	 * 
	 * @param nom             Le nom porté par l'humain
	 * @param boissonFavorite La boisson préférée de l'humain
	 * @param argent          La somme d'argent initiale de l'humain
	 */
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	// ===== METHODES =====
	/**
	 * Renvoie le nom de l'humain
	 * 
	 * @return le nom de l'humain
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Renvoie l'argent possédé par l'humain
	 * 
	 * @return l'argent de l'humain
	 */
	public int getArgent() {
		return argent;
	}

	/**
	 * Ajoute la somme d'argent spécifiée à l'argent total possédé par l'humain
	 * 
	 * @param gain La somme d'argent ajoutée
	 */
	protected void gagnerArgent(int gain) {
		argent = getArgent() + gain;
	}

	/**
	 * Retire la somme d'argent spécifiée à l'argent total possédé par l'humain
	 * 
	 * @param perte La somme d'argent retirée
	 */
	protected void perdreArgent(int perte) {
		argent = getArgent() - perte;
	}

	/**
	 * Affiche une présentation de l'humain
	 */
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + getNom() + " et j'aime boire du " + boissonFavorite + ".");
	}

	/**
	 * Réalise un affichage où l'humain boit sa potion favorite
	 */
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}

	/**
	 * Achete le bien specifie si l'humain possede plus d'argent que le prix
	 * spécifé. Realise un affichage en fonction de la possibilité d'achat
	 * 
	 * @param bien Le bien que l'humain cherche à acheter
	 * @param prix Le prix du bien, déduit de l'argent total si l'humain achete le bien
	 * @return Le bien acheté ou null si l'humain n'a pas assez d'argent
	 */
	public String acheter(String bien, int prix) {
		if (getArgent() >= prix) {
			parler("J'ai " + getArgent() + " sous en poche. Je vais pouvoir m'offrir " + bien + " � " + prix
					+ " sous.");
			perdreArgent(prix);
			return bien;
		} else {
			parler("Je n'ai plus que " + getArgent() + " sous en poche. Je ne peux m�me pas m'offrir " + bien + " � "
					+ prix + " sous.");
			return null;
		}
	}

	/**
	 * Affiche une parole de l'humain dans la console, sous la forme : (NOM) -
	 * PAROLE
	 * 
	 * @param parole Les paroles prononcées par l'humain
	 */
	protected void parler(String parole) {
		System.out.println("(" + getNom() + ") - " + parole);
	}

}
