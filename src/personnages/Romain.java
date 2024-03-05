package personnages;

public class Romain {
	private String nom;
	private int force;
	Equipement []equipements = new Equipement[2];
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
		System.out.println(prendreParole() + "ï¿½ " + texte + "ï¿½");
	}

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 1:
			System.out.println("Le soldat " + nom + " est bien protegé !");
		case 2:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possede deja un " + equipement + " !");
			}
		default:
			if (equipements[0] != equipement) {
				System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + ".");
			}
			nbEquipement++;
		}

	}

	public int CalculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;) {
		if ((equipements[i] != null &&
		equipements[i].equals(Equipement.BOUCLIER)) == true) {
		resistanceEquipement += 8;
		} else {
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
		}
		i++;
		}
		texte = texte + resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
		public Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {if (equipements[i] == null) {
		} else {
		equipementEjecte[nbEquipementEjecte] =
		equipements[i];
		nbEquipementEjecte++;
		equipements[i] = null;
		}
		}
		return equipementEjecte;
		}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		switch (force) {
			case 0:
				parler("Aïe");
			default:
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
			break;
			}
			// post condition la force a diminuée
			//assert force < oldForce;
			return equipementEjecte;
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
