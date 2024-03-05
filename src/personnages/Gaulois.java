package personnages;



public class Gaulois {	
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
public int getForce() {
	return force;
}
	public void parler(String texte) {
		System.out.println(prendreParole() + "ï¿½ " + texte + "ï¿½");
	}


	public String prendreParole() {
		return "Le gaulois " + nom + " : ";

		}


	public void frapper(Romain romain) {
		Equipement []trophees;
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		trophees = romain.recevoirCoup((force / 3) *
		effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,
		nbTrophees++) {
		trophees[nbTrophees] = trophees[i];
		}
		}


	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		System.out.println("Merci Druide, je sens que ma force ï¿½ " + forcePotion + " fois dï¿½cuplï¿½e");

	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
		Romain romain = new Romain("Minus", 6);
		asterix.parler("Bonjour !");
		asterix.frapper(romain);
		asterix.prendreParole();
		asterix.frapper(romain);
		asterix.boirePotion(7);

	}
}
