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
	Cible cible;
	
	
	public ControlleurCible(DecorDef d1,Cible c){
		cible =c;
		trajectoireCible(c,d1,b);
		
	}
	
	
	/**
	 * Methode pour la trajectoire de la parabole
	 * Fonctionne grace a vitesse et angle
	 * Utilisation d'un timer
	 * @param o
	 */
	public void trajectoireCible(final Cible c,final DecorDef d,final boolean b){
		final Timer timer = new Timer(); 
		TimerTask timerTask = new TimerTask(){	
			@Override
			public void run()  { 
				t+=1;
				if(t>10){
					timer.cancel();
				}
				else{ 
						c.setAngle(c.getAngle()+1);
						c.set_X(c.get_X()+1);
					d.repaint();
				}
			}
		};
		timer.scheduleAtFixedRate(timerTask,0,50);
	}
}
