package personnages;

import java.util.Arrays;

public class Village {
		private String nom;
		private Chef chef;
		private Gaulois[] villageois;
		private int nbVillageois=0;
		public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois=new Gaulois[nbVillageoisMaximum];
		}
		public void ajouterHabitant(Gaulois gaulois) {
			villageois[nbVillageois]=gaulois;
			nbVillageois++;
		}
		public Gaulois trouverHabitant(int n){
			return villageois[n];
				
		}
		
		public void setChef(Chef chef) {
		this.chef = chef;
		}
		public String getNom() {
		return nom;
		}
		
		
		public void afficherVillagois() {
			System.out.println("Dans le village du chef "+chef+" vivent les legendaires gaulois : \n - "+ villageois[0]+ "\n - "+ villageois[1]);
		}
		public static void main(String[]args) {
			Village village=new Village("Village des Irr�ductibles",30);
			//Gaulois gaulois = village.trouverHabitant(30);
			//On obtient cette erreur car la taille du tableau est inferieur a l'entier en parametre de trouverHabitant
			Gaulois chef = new Gaulois("Abraracourcix",6); 
			Gaulois Asterix=new Gaulois("Asterix",8);  
			Gaulois obelix = new Gaulois("Obélix",25);
			//Gaulois gaulois = village.trouverHabitant(1); 
			//System.out.println(gaulois);
			village.ajouterHabitant(Asterix);
			village.ajouterHabitant(obelix);
			village.afficherVillagois();
		}
		
}


