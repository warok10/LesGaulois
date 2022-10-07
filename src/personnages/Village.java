package personnages;

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
		public static void main(String[]args) {
			Village village=new Village("Village des Irréductibles",30);
			//Gaulois gaulois = village.trouverHabitant(30);
			//On obtirnt cette erreur car la taille du tableau est inferieur a l'entier en parametre de trouverHabitant
			Gaulois chef = new Gaulois("Abraracourcix",6); 
			chef.ajouterHabitant(chef); 
			Gaulois Asterix=new Gaulois("Asterix",8); 
			Asterix.ajouterHabitant(Asterix); 
			Gaulois gaulois = village.trouverHabitant(1); 
			System.out.println(gaulois);
		}
}


