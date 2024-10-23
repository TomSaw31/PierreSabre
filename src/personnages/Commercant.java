package personnages;

public class Commercant extends Humain {
	public Commercant(String nom, int argent) {
		super(nom, "th�", argent);
	}

	/**
	 * Retire tout l'argent du commercant
	 * @return
	 */
	public int seFaireExtorquer() {
		parler("J'ai tout perdu! Le monde est trop injuste.");
		int argent_perdu = getArgent();
		perdreArgent(argent_perdu);
		return argent_perdu;
	}
	
	/**
	 * Ajoute de l'argent au commercant
	 * @param argent L'argent ajouté
	 */
	public void recevoir(int argent) {
		parler(argent + " sous ! Je te remercie généreux donateur!");
		gagnerArgent(argent);
	}
}
