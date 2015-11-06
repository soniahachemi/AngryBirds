
import java.util.Random;

/**
 * Classe cible, gerant les differents obstacles presents sur la carte
 * @author Quentin  Spinnewyn
 *
 */
public class Cible{

	private Coord coord;
	private boolean touche;
	private int taille;
	
	
	/**
	 * Constructeur
	 * @param d : decor
	 */
	public Cible(Decor d){
		touche = false;
		taille = (int)Math.floor(0.6*d.getEchelle());
		
		//calcule les coords des cibles en random sur la carte
		int x = d.getposDep()+ new Random().nextInt(d.getLargeur()-d.getposDep());
		int y = taille/2 + new Random().nextInt(d.getHauteur()-taille/2);
		while(!d.placeLibre(x, y, taille)){
			x = d.getposDep()+ new Random().nextInt(d.getLargeur()-d.getposDep());
			y = taille/2 + new Random().nextInt(d.getHauteur()-taille/2);
		}
		this.coord = new Coord(x,y);
		d.getCibles().add(this);
	}
	
	
	/**
	 * Methode getCoord
	 * @return coord
	 */
	public Coord getCoord(){
		return coord;
	}
	
	/**
	 * Methode getX
	 * @return coord.getX
	 */
	public int get_X(){
		return coord.getX();
	}
	
	/**
	 * Methode setX
	 * @param x
	 */
	public void set_X(int x){
		coord.setX(x);
	}
	
	/**
	 * Methode getY
	 * @return coord.getY
	 */
	public int get_Y(){
		return coord.getY();
	}
	
	/**
	 * Methode setY
	 * @param y
	 */
	public void set_Y(int y){
		coord.setY(y);
	}
	
	/**
	 * Methode getTaille
	 * @return taille
	 */
	public int getTaille(){
		return taille;
	}
	
	/**
	 * Methode estTouche
	 * @return touche
	 */
	public boolean estTouche(){
		return touche;
	}
	
	/**
	 * Methode toucher
	 */
	public void toucher(){
		touche = true;
	}
}
