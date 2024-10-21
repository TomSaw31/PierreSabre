package personnages;

public class Yakuza extends Humain {
	private int reputation = 0;
	private String clan;

	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}

	public String getClan() {
		return clan;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int gain = victime.seFaireExtorquer();
		gagnerArgent(gain);
		parler("J’ai piqué les " + gain + " sous de " + victime.getNom() + " , ce qui me fait " + getArgent()
				+ " sous dans ma\r\n" + "poche. Hi ! Hi !");
	}

	public int perdre() {
		int perte = getArgent();
		parler("J’ai perdu mon duel et mes " + getArgent() + " sous, snif... J'ai déshonoré le clan de " + getClan());
		perdreArgent(perte);
		reputation--;
		return perte;
	}

	public void gagner(int gain) {
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + getClan()
				+ "? Je l'ai dépouillé de ses " + gain + " sous.");
		reputation++;
		gagnerArgent(gain);
	}

	public int getReputation() {
		return reputation;
	}

}
