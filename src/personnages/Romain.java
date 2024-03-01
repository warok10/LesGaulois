package personnages;

public class Romain {
	private String nom;
	private int force;
	Equipement equipements[] = new Equipement[2];
	int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		assert force > 0 : "la force d'un Romain est toujours positive.";
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

	private void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est bien protegé !");
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possede deja un " + equipement + " !");
			}
		default:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + ".");
			}
			nbEquipement++;
		}

	}

	public void recevoirCoup(int forceCoup) {
		int forceInitiale = force;
		assert force > 0 : "la force d'un Romain est positive.";
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert forceInitiale > force : "la force d'un Romain a diminué.";
	}

	public static void main(String[] agrs) {
		Romain romain = new Romain("romain", 8);
		Romain minus = new Romain("minus", 6);
		minus.getForce();
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		romain.prendreParole();
		romain.parler("Bonjour");
		romain.recevoirCoup(2);
	}
}
