
import java.util.Random;


public class Cible{

	private Coord coord;
	private boolean touche;
	private int taille;
	
	public Cible(Decor d){
		touche = false;
		taille = (int)Math.floor(0.6*d.getEchelle());
		
		int x = d.getposDep()+ new Random().nextInt(d.getLargeur()-d.getposDep());
		int y = d.getHauteurSol()+taille/2 + new Random().nextInt(d.getHauteur()-d.getHauteurSol()-taille/2);
		while(!d.placeLibre(x, y, taille)){
			x = d.getposDep()+ new Random().nextInt(d.getLargeur()-d.getposDep());
			y = taille/2 + new Random().nextInt(d.getHauteur()-taille/2);
		}
		this.coord = new Coord(x,y);
		d.getCibles().add(this);
	}
	public Cible(Decor d, Coord c){
		touche = false;
		taille = (int)Math.floor(0.6*d.getEchelle());
		this.coord = c;
		if(d.placeLibre(coord.getX(), coord.getY(), taille))d.getCibles().add(this);
	}
	public Cible(Decor d, Coord c, int t){
		touche = false;
		taille = (int)Math.floor(t*d.getEchelle());
		this.coord = c;
		if(d.placeLibre(coord.getX(), coord.getY(), taille))d.getCibles().add(this);
	}
	public Coord getCoord(){
		return coord;
	}
	public int get_X(){
		return coord.getX();
	}
	public void set_X(int x){
		coord.setX(x);
	}
	public int get_Y(){
		return coord.getY();
	}
	public void set_Y(int y){
		coord.setY(y);
	}
	public int getTaille(){
		return taille;
	}
	public boolean estTouche(){
		return touche;
	}
	public void toucher(){
		touche = true;
	}
}
