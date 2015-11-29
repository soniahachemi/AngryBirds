
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Classe Animation, g�rant les diff�rentes trajectoires de l'oiseau
 * @author Quentin  Spinnewyn
 *
 */
public class LancePierre {

	private DecorDef d;
	double t;
	
	double vitesse,angle;

	/**
	 * Constructeur
	 * @param d1 : decor
	 */
	
	public LancePierre(Oiseau o,DecorDef d1,double v,double a){
		d=d1;
		vitesse =v;
		angle=a;
		lancePierre(o);
	}
	
	
	/**
	 * Methode pour la trajectoire de la parabole
	 * Fonctionne grace a vitesse et angle
	 * Utilisation d'un timer
	 * @param o
	 */
	public void lancePierre(final Oiseau o){
		t=0;
		final Timer timer = new Timer(); 
		TimerTask timerTask = new TimerTask(){	
			public void run()  { 
				t+=1;
				if(o.getCoord().distance(new Coord(0,d.getHauteurLP()+o.getTaille()/2)) >0){
					o.setCoord(prochCoordDroite((int)t,o.getCoord(),new Coord(0,d.getHauteurLP()+o.getTaille()/2)));
					o.setProchaineCoord(prochCoordDroite((int)t+10,o.getCoord(),new Coord(0,d.getHauteurLP()+o.getTaille()/2)));
					d.repaint();
				}
				else {
					timer.cancel();
					new Animation(o,d,vitesse,angle);
				}
			}
		};
		timer.scheduleAtFixedRate(timerTask,0,5);
		}
	

	static Coord prochCoordDroite(int t,Coord dep, Coord arr){
		Coord p = arr;
		
		while(p.distance(dep)>t){
			if(Math.abs(p.getX()-dep.getX()) >Math.abs(p.getY()-dep.getY())){
				if(p.getX()>dep.getX()) p.setX(p.getX()-1);
				else p.setX(p.getX()+1);
			}
			else {
				if(p.getY()>dep.getY()) p.setY(p.getY()-1);
				else p.setY(p.getY()+1);
			}
		}
		return p;

	}


	
	
	
	
}
