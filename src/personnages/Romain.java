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
		String texte = "le soldat ";
		switch (nbEquipement) {
		case 1:
			System.out.println( texte + nom + " est bien protegé !");
		case 2:
			if (equipements[0] == equipement) {
				System.out.println(texte + nom + " possede deja un " + equipement + " !");
			}
		default:
			if (equipements[0] != equipement) {
				System.out.println(texte + nom + " s'equipe avec un " + equipement + ".");
			}
			nbEquipement++;
		}

	}

	public int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if ((nbEquipement != 0)) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;i++) {
		if ((equipements[i] != null &&
		equipements[i].equals(Equipement.BOUCLIER))) {
		resistanceEquipement += 8;
		} else {
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
		}
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
		
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force==0)
				parler("Aïe");
		else 
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			// post condition la force a diminuée
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
