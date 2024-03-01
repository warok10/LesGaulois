package personnages;

public enum Equipement { 
	CASQUE("casque"),BOUCLIER("bouclier");
	String nom;
	
	
	private Equipement (String nom){
		this.nom=nom;
	}
	public String toString() {
		return nom;
	}
}
