package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");

	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	public String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public int preparerPotion() {
		Random r = new Random();
		forcePotion = effetPotionMin + r.nextInt(effetPotionMax - effetPotionMin);
		forcePotion = r.nextInt(effetPotionMax);
		return forcePotion;
	}

	public void parler() {
		forcePotion = preparerPotion();
		if (forcePotion > 7) {
			System.out.println("J'ai préparé\r\n" + "une super potion de force " + forcePotion);
		} else {
			System.out.println(
					"Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion);
		}
	}

	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			System.out.println(" Non, Obélix !... Tu n’auras pas de potion\r\n" + "magique ");
		} else
			gaulois.boirePotion(forcePotion);
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.parler();

	}

}
