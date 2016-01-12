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
			if(!c2.getCoord().equals(c.getCoord())){
				if(Math.abs(c2.get_X()-c.get_X()) <= c.getTaille()/2+c2.getTaille()/2 ){
					if(c2.get_Y()> c.get_Y() && c2.get_Y()<= c.get_Y()+c.getTaille()/2+c2.getTaille()/2){
						if(c.get_X()<c2.get_X()) return -1;
						else if(c.get_X()>c2.get_X())return +1;
					}
					else if(c.get_Y()<= c2.get_Y()+c2.getTaille()/2+c.getTaille()/2){
						if(c.get_X()<c2.get_X()) return -1;
						else if(c.get_X()>c2.get_X())return +1;
					}
				}
			}
		}
		for(Oiseau c2 : d.getOiseaux()){
			/*if(Math.abs(c2.get_X()-c.get_X()) <= c.getTaille()/2+c2.getTaille()/2 ){
					if(c2.get_Y()> c.get_Y() && c2.get_Y()<= c.get_Y()+c.getTaille()/2+c2.getTaille()/2){
						if(c.get_X()<c2.get_X()) return -1;
						else if(c.get_X()>c2.get_X())return +1;
					}
					else if(c.get_Y()<= c2.get_Y()+c2.getTaille()/2+c.getTaille()/2){
						if(c.get_X()<c2.get_X()) return -1;
						else if(c.get_X()>c2.get_X())return +1;
					}
				}*/
			if(c.getCoord().distance(c2.getCoord())<= c.getTaille()/2 + c.getTaille()/2){
				if(c2.get_X()<c.get_X())return -1;
				else return 1;
			}
		}
		
		
		return 0;
	}
	
}
