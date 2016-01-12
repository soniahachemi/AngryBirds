package Builder;

import Modele.Cible;
import Vue.Decor;

public class Builder {
	
	private Decor decor;
	
	public Builder(Decor d){
		decor = d;
	}
	
	public void tour(){
		
		//for(int i=1;i<2;i++){
			//Premiere ligne d obstacles par defaut 
			Cible c = new Cible(decor);
			c.set_X(decor.getposDep()+100);
			c.set_Y(c.getTaille()/2);
			decor.ajouterCible(c);
			Cible c2 = new Cible(decor);
			c2.set_X(decor.getposDep()+100);
			c2.set_Y(c.getTaille()+c2.getTaille()/2);
			decor.ajouterCible(c2);
			Cible c3 = new Cible(decor);
			c3.set_X(decor.getposDep()+100);
			c3.set_Y(c2.get_Y()+c2.getTaille());
			decor.ajouterCible(c3);
			
			//Deuxieme ligne d obstacles par defaut 
			Cible c4 = new Cible(decor);
			c4.set_X(decor.getposDep()+200);
			c4.set_Y(c4.getTaille()/2);
			decor.ajouterCible(c4);
			Cible c5 = new Cible(decor);
			c5.set_X(decor.getposDep()+200);
			c5.set_Y(c4.getTaille()+c5.getTaille()/2);
			decor.ajouterCible(c5);
			Cible c6 = new Cible(decor);
			c6.set_X(decor.getposDep()+200);
			c6.set_Y(c5.get_Y()+c5.getTaille());
			decor.ajouterCible(c6);
			Cible c7 = new Cible(decor);
			c7.set_X(decor.getposDep()+200);
			c7.set_Y(c6.get_Y()+c6.getTaille());
			decor.ajouterCible(c7);
			
			
		//}
	}
	
}
