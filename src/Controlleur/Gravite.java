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
	
	public boolean estPose(Cible c){
		if(c.get_Y()<=c.getTaille()/2 ) return true;
		else{
			for(Cible c2 : decor.getCibles()){
				if(!c2.getCoord().equals(c.getCoord())){
					if(Math.abs(c2.get_X()-c.get_X()) <= c.getTaille()/2+c2.getTaille()/2 ){
						if(c2.get_Y()> c.get_Y() && c2.get_Y()<= c.get_Y()+c.getTaille()/2+c2.getTaille()/2) return true;
						else if(c.get_Y()<= c2.get_Y()+c2.getTaille()/2+c.getTaille()/2) return true;
					}
				}
			}
			for(Oiseau c2 : decor.getOiseaux()){
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
				if(!estPose(c)) c.set_Y(c.get_Y()-1);
				c.setAngle(c.getAngle()+ estStable(c));
				c.set_X(c.get_X()+estStable(c));
			}
			if(creation!=null) creation.repaint(); 
		}
	};
	timer.scheduleAtFixedRate(timerTask,0,2);
	
	}
	
	private int estStable(Cible c) {
		for(Cible c2 : decor.getCibles()){
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
		for(Oiseau c2 : decor.getOiseaux()){
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
		
		
		return 0;
	}
	
}
