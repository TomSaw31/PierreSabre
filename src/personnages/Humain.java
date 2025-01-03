package personnages;

public class Humain {
	protected static final int TAILLE_MEMOIRE = 30;

	private String nom;
	private String boissonFavorite;
	private int argent;
	protected int nbConnaissances = 0;
	protected Humain[] memoire = new Humain[TAILLE_MEMOIRE];

	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	protected void gagnerArgent(int gain) {
		argent = getArgent() + gain;
	}

	protected void perdreArgent(int perte) {
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
			parler("J'ai " + getArgent() + " sous en poche. Je vais pouvoir m'offrir " + bien + " � " + prix
					+ " sous.");
			perdreArgent(prix);
			return bien;
		} else {
			parler("Je n'ai plus que " + getArgent() + " sous en poche. Je ne peux meme pas m'offrir " + bien + " � "
					+ prix + " sous.");
			return null;
		}
	}

	protected void parler(String parole) {
		System.out.println("(" + getNom() + ") - " + parole);
	}

	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}

	private void memoriser(Humain humain) {
		if (nbConnaissances == TAILLE_MEMOIRE) {
			for (int i = 0; i < memoire.length - 1; i++) {
				memoire[i] = memoire[i + 1];
			}
			memoire[nbConnaissances - 1] = humain;
		} else {
			memoire[nbConnaissances] = humain;
			nbConnaissances++;
		}
	}

	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}

	public void listerConnaissances() {
		StringBuilder chaine = new StringBuilder();
		for (int i = 0; i < nbConnaissances; i++) {
			chaine.append(memoire[i].getNom());
			if(i != nbConnaissances - 1) {
				chaine.append(", ");
			}
		}
		if (chaine.length() != 0) {
			parler("Je connais beaucoup de monde dont : " + chaine);
		} else {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		}
	}
}
