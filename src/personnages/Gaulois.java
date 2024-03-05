package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

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
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	public String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		romain.recevoirCoup((force / 3) * effetPotion);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		System.out.println("Merci Druide, je sens que ma force � " + forcePotion + " fois d�cupl�e");

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
