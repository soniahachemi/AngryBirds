package Controlleur;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import Modele.Cible;
import Modele.Oiseau;
import Vue.Decor;

public class Gravite {

	Decor decor;
	JPanel creation;
	
	public Gravite(Decor d){
		decor = d;
		gravite();
	}
	public Gravite(Decor d,JPanel j){
		decor = d;
		creation=j;
		gravite();
	}
	
	public static boolean estPose(Cible c,Decor d){
		if(c.get_Y()<=c.getTaille()/2 ) return true;
		else{
			for(Cible c2 : d.getCibles()){
				if(!c2.getCoord().equals(c.getCoord())){
					if(Math.abs(c2.get_X()-c.get_X()) <= c.getTaille()/2+c2.getTaille()/2 ){
						if(c2.get_Y()> c.get_Y() && c2.get_Y()<= c.get_Y()+c.getTaille()/2+c2.getTaille()/2) return true;
						else if(c.get_Y()<= c2.get_Y()+c2.getTaille()/2+c.getTaille()/2) return true;
					}
				}
			}
			for(Oiseau c2 : d.getOiseaux()){
				if(!c2.getCoord().equals(c.getCoord())){
					if(Math.abs(c2.get_X()-c.get_X()) <= c.getTaille()/2+c2.getTaille()/2 ){
						if(c2.get_Y()> c.get_Y() && c2.get_Y()<= c.get_Y()+c.getTaille()/2+c2.getTaille()/2) return true;
						else if(c.get_Y()<= c2.get_Y()+c2.getTaille()/2+c.getTaille()/2) return true;
					}
				}
			}
			
			
			
		}
		return false;
	}
	
	public static boolean estStable(Decor d){
		for(Cible c : d.getCibles())
			if(!estPose(c, d)) return false;
		return true;
	}
	
	
	public static boolean estPoseSur(Cible dessus,Cible dessous){
		if(dessus.equals(dessous))return false;
		if(dessus.get_Y()<dessous.get_Y()) return false;
		if(dessus.get_Y()-dessous.get_Y() <= dessus.getTaille()/2 + dessous.getTaille()/2){
			if(Math.abs(dessus.get_X()-dessous.get_X())<= dessus.getTaille()/2 + dessous.getTaille()/2 ) return true;
		}
	return false;
	}
	
	
	public void gravite(){
	final Timer timer = new Timer(); 
	TimerTask timerTask = new TimerTask(){	
		@Override
		public void run()  { 
			for(Cible c : decor.getCibles()){
				if(!estPose(c,decor)) c.set_Y(c.get_Y()-1);
				c.setAngle(c.getAngle()+ estStable(c,decor));
				c.set_X(c.get_X()+estStable(c,decor));
			}
			if(creation!=null) creation.repaint(); 
		}
	};
	timer.scheduleAtFixedRate(timerTask,0,2);
	
	}
	
	public static int estStable(Cible c,Decor d) {
		for(Cible c2 : d.getCibles()){
			if(estPoseSur(c, c2)){
				if(c.get_X()<c2.get_X()) return -1;
				else if (c.get_X()>c2.get_X()) return +1;
			}
		}
		return 0;
	}
	
}
