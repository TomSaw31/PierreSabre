package personnages;

public class Commercant extends Humain {
	
	
	
	public Commercant(String nom, int argent) {
		super(nom, "th�", argent);
	}

	public int seFaireExtorquer() {
		parler("J�ai tout perdu! Le monde est trop injuste.");
		int argent_perdu = getArgent();
		perdreArgent(argent_perdu);
		return argent_perdu;
	}
	
	public void recevoir(int argent) {
		parler(argent + " sous ! Je te remercie g�n�reux donateur!");
		gagnerArgent(argent);
	}
}
