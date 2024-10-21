package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}

	public void donner(Commercant beneficiaire) {
		int don = getArgent()/10;
		parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
		beneficiaire.parler(don + " sous ! Je te remercie généreux donateur!");
		perdreArgent(don);
		beneficiaire.gagnerArgent(don);
	}

}
