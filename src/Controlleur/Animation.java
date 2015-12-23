package Controlleur;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Modele.Cible;
import Modele.Oiseau;
import Vue.DecorDef;


/**
 * Classe Animation, g�rant les diff�rentes trajectoires de l'oiseau
 * @author Groupe L5
 *
 */
public class Animation {

	private DecorDef d;
	double t;
	
	double vitesse,angle;

	/**
	 * Constructeur
	 * @param d1 : decor
	 */
	
	public Animation(Oiseau o,DecorDef d1,double v,double a){
		d=d1;
		vitesse =v;
		angle=a;
		trajectoireParabole(o);
	}
	
	
	/**
	 * Methode pour la trajectoire de la parabole
	 * Fonctionne grace a vitesse et angle
	 * Utilisation d'un timer
	 * @param o
	 */
	public void trajectoireParabole(final Oiseau o){
		t=0;
		if(angle<91 && angle>89) angle = (new Random().nextBoolean())? 91 : 89;
		final Timer timer = new Timer(); 
		TimerTask timerTask = new TimerTask(){	
			@Override
			public void run()  { 
				t+=0.015;
				o.setCoord(coordParabole(t,vitesse,angle,0,d.getHauteurLP()));
				double t2 = t+0.002;
				o.setProchaineCoord(coordParabole(t2,vitesse,angle,0,d.getHauteurLP()));
				while(o.getCoord().distance(o.getProchaineCoord()) < o.getTaille()/2 + 10){
					t2+=0.002;
					o.setProchaineCoord(coordParabole(t2,vitesse,angle,0,d.getHauteurLP()));
				}
				for(Cible c : d.getCibles()){
					if(c.getCoord().distance(o.getCoord()) <= (c.getTaille()/2 + o.getTaille()/2)){
						c.toucher();
						new ControlleurCible(d);
					}
				}
				d.repaint();
				if(o.get_Y()<=0+o.getTaille()/2 || t>=8000){
					o.finirVol();
					d.viderPointsTraj();
					timer.cancel();
					d.oiseauSurLP();
			}
			
			}
		};
		timer.scheduleAtFixedRate(timerTask,0,1);
	}
	
	
	// Renvoi les coordonnes en fonction du temps la vitesse et l'angle
	static Coord coordParabole(double t,double vitesse,double anglen,int posDepX,int posDepY){
		double rad = Math.toRadians(anglen);
		double x = vitesse*Math.cos(rad)*t +posDepX;
		
		
		double truc = x /(vitesse*Math.cos(rad));
		final double G =9.81;
		 
		double y = (-(G/2))*truc*truc + vitesse*Math.sin(rad)*truc +posDepY;
		return new Coord((int)x, (int)y);

	}
	
}
