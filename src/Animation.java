
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Classe Animation, g�rant les diff�rentes trajectoires de l'oiseau
 * @author Quentin  Spinnewyn
 *
 */
public class Animation {

	private Decor d;
	double t;
	
	double vitesse,angle;

	/**
	 * Constructeur
	 * @param d1 : decor
	 */
	
	public Animation(Decor d1,double v,double a){
		d=d1;
		vitesse =v;
		angle=a;
		for(Oiseau o : d.getOiseaux()){
			if(!o.aFiniVol()){
				if(Main.compteur!=9) trajectoireParabole(o);
				//else trajectoireSinusoidale(o);
			}
		}
	}
	
	
	/**
	 * Methode pour la trajectoire de la parabole
	 * Fonctionne grace a vitesse et angle
	 * Utilisation d'un timer
	 * @param o
	 */
	public void trajectoireParabole(final Oiseau o){
		t=0;
		
		long delay = 0; // On commence dans 1 seconde
		long period = 30; // R�p�ter toutes les 50 ms
		final Timer timer = new Timer(); 
		TimerTask timerTask = new TimerTask(){	
			public void run()  { 
				t+=0.01;
				o.setCoord(coordParabole(t,vitesse,angle));
				d.ajouterPoint(o.getCoord());
				
				double t2 = t+0.002;
				o.setProchaineCoord(coordParabole(t2,vitesse,angle));
				while(o.getCoord().distance(o.getProchaineCoord()) < o.getTaille()/2 + 10){
					t2+=0.002;
					o.setProchaineCoord(coordParabole(t2,vitesse,angle));
				}
				for(Cible c : d.getCibles()){
					int distanceX = c.get_X() - o.get_X();
					if(distanceX <0) distanceX*=-1;
					int distanceY = c.get_Y() - o.get_Y();
					if(distanceY <0) distanceY*=-1;
					if(distanceX < (c.getTaille()/2 + o.getTaille()/2) && distanceY < (c.getTaille()/2 + o.getTaille()/2)  )
						c.toucher();
				}
				d.repaint();
				if(o.get_Y()<=0+o.getTaille()/2 || t>=15000){
					Main.compteur++;
					if(Main.compteur==10) o.finirVol();
					d.viderPointsTraj();
					timer.cancel();
					//new Animation(d,vitesse,angle);

				}
				
		}
		};
		timer.scheduleAtFixedRate(timerTask,delay, period);
		}
	
	// Renvoi les coordonnes en fonction du temps la vitesse et l'angle
	Coord coordParabole(double t,double vitesse,double angle){
		double rad = Math.toRadians(angle);
		double x = vitesse*Math.cos(rad)*t;
		int xEch = (int)(x*d.getEchelle());
		
		double truc = xEch /(vitesse*Math.cos(rad));
		final double G =9.81;
		 
		double y = (-(G/2))*truc*truc + vitesse*Math.sin(rad)*truc ;
		int yEch=(int)(y+d.getHauteurLP());
		return new Coord(xEch,yEch);

	}

	
	
	
	
}
