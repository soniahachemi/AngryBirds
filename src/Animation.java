import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Animation {

	private Decor d;
	double t;

	
	public Animation(Decor d1){
		d=d1;
		for(Oiseau o : d.getOiseaux()){
			if(!o.aFiniVol()){
				if(Main.compteur!=9) trajectoireParabole(o);
				else trajectoireSinusoidale(o);
			}
		}
	}
	
	public void trajectoireParabole(Oiseau o){
		t=0;
		double vitesse = 40+new Random().nextInt(80);
		double angle = 30+new Random().nextInt(60);
		
		long delay = 1000; // On commence dans 1 seconde
		long period = 30; // Répéter toutes les 50 ms
		Timer timer = new Timer(); 
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
					new Animation(d);

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

	
	
	public void trajectoireSinusoidale(Oiseau o){
		t=0;
		long delay = 1000; // On commence dans 1 seconde
		long period = 60; // Répéter toutes les 50 ms
		Timer timer = new Timer(); 
		TimerTask timerTask = new TimerTask(){	
			public void run()  { 
				t+=0.01;
				o.setCoord(coordSinus(t));
				d.ajouterPoint(o.getCoord());
				
				double t2 = t+0.002;
				o.setProchaineCoord(coordSinus(t2));
				while(o.getCoord().distance(o.getProchaineCoord()) < o.getTaille()/2 + 10){
					t2+=0.002;
					o.setProchaineCoord(coordSinus(t2));
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
				if(o.get_X()>d.getLargeur()+o.getTaille() || t>=15000){
					Main.compteur++;
					if(Main.compteur==10) o.finirVol();
					d.viderPointsTraj();
					timer.cancel();
					new Animation(d);

				}
				
		}
		};
		timer.scheduleAtFixedRate(timerTask,delay, period);
		}
	
	// Renvoi les coordonnes en fonction du temps la vitesse et l'angle
	Coord coordSinus(double t){
		int xEch = (int)(t*30*d.getEchelle());
		int yEch=(int)(+120-(80*Math.sin(50*t))+d.getHauteurLP());
		return new Coord(xEch,yEch);

	}
	
	
}
