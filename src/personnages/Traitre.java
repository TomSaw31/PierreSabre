package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;
	private Random rand = new Random();

	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traitre et mon niveau de traitrise est : " + niveauTraitrise + ". Chut !");
	}

	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentCommercant = commercant.getArgent();
			int argentRanconner = argentCommercant / 5;
			commercant.perdreArgent(argentRanconner);
			niveauTraitrise++;
			gagnerArgent(argentRanconner);
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer! Donne moi " + argentRanconner
					+ " sous ou gare à toi!");
			commercant.parler("Tout de suite grand " + getNom() + ".");
		} else {
			parler("Mince je ne peux plus ranconner personne sinon un samourai risque de me demasquer !");
		}
	}

	public void faireLeGentil() {
		if (nbConnaissances < 1) {
			listerConnaissances();
		} else {
			int randIndex = rand.nextInt(nbConnaissances);
			Humain humain = memoire[randIndex];
			int don = getArgent() / 20;
			String nomAmi = humain.getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			humain.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			humain.parler("Merci " + nom + ". Vous êtes quelqu'un de bien.");
			if (niveauTraitrise > 1) {
				niveauTraitrise--;
			}
		}
	}
}
