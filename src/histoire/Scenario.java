package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain minus = new Romain("Minus", 6);
		Gaulois obelix = new Gaulois("Ob�lix", 6);
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.prendreParole();
		panoramix.parler("Je vais aller preparer une potion");
		panoramix.parler();
		panoramix.booster(obelix);
		obelix.parler("par Bélénos, ce n'est pas juste !");
		asterix.prendreParole();
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU..." );
		asterix.frapper(minus);
		
		
		
	}

}
