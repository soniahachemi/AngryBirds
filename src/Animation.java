
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Classe Animation, g�rant les diff�rentes trajectoires de l'oiseau
 * @author Quentin  Spinnewyn
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
	
	public Animation(DecorDef d1,double v,double a){
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
		long period = 1; // R�p�ter toutes les 50 ms
		final Timer timer = new Timer(); 
		final int posDepX = 0;
		final int posDepY = d.getHauteurLP();
		TimerTask timerTask = new TimerTask(){	
			public void run()  { 
				t+=0.015;
				
				o.setCoord(coordParabole(t,vitesse,angle,posDepX,posDepY));
				d.ajouterPoint(o.getCoord());
				
				double t2 = t+0.002;
				o.setProchaineCoord(coordParabole(t2,vitesse,angle,posDepX,posDepY));
				while(o.getCoord().distance(o.getProchaineCoord()) < o.getTaille()/2 + 10){
					t2+=0.002;
					o.setProchaineCoord(coordParabole(t2,vitesse,angle,posDepX,posDepY));
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
	static Coord coordParabole(double t,double vitesse,double anglen,int posDepX,int posDepY){
		if(anglen<91 && anglen>89) anglen=91;
		double rad = Math.toRadians(anglen);
		double x = vitesse*Math.cos(rad)*t +posDepX;
		
		
		double truc = x /(vitesse*Math.cos(rad));
		final double G =9.81;
		 
		double y = (-(G/2))*truc*truc + vitesse*Math.sin(rad)*truc ;
		int yEch=(int)(y+posDepY);
		return new Coord((int) x,yEch);

	}

	
	
	
	
}
