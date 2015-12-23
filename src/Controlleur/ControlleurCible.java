package Controlleur;

import java.util.Timer;
import java.util.TimerTask;

import Modele.Cible;
import Vue.DecorDef;


/**
 * Classe ControlleurCible, g�rant les diff�rentes trajectoires des cibles
 * @author Groupe L5
 *
 */
public class ControlleurCible {

	/**
	 * Constructeur
	 * @param d1 : decor
	 */
	
	double t = 0;
	boolean b = false;
	
	public ControlleurCible(DecorDef d1){
		trajectoireCible(d1,b);
	}
	
	
	/**
	 * Methode pour la trajectoire de la parabole
	 * Fonctionne grace a vitesse et angle
	 * Utilisation d'un timer
	 * @param o
	 */
	public void trajectoireCible(final DecorDef d,final boolean b){
		final Timer timer = new Timer(); 
		TimerTask timerTask = new TimerTask(){	
			@Override
			public void run()  { 
				t+=0.1;
				if(t>10){
					timer.cancel();
					rejouer(d);
				}
				else{ 
					for(Cible c : d.getCibles()){
						c.setAngle(c.getAngle()+1);
					}
					d.repaint();
				}
			}
		};
		timer.scheduleAtFixedRate(timerTask,0,10);
	}
	
	public void rejouer(DecorDef d){
		t=0;
		b=!b;
		trajectoireCible(d,b);
	}
}
