package Controlleur;



/**
 * Classe coord aidant l'oiseau, et les cibles
 * @author Groupe L5
 *
 */
public class Coord {
	
	private int x,y;
	

	/**
	 * Constructeur
	 * @param x1
	 * @param y1
	 */
	public Coord(int x1, int y1){
		this.x = x1;;
		this.y = y1;
	}
	
	/**
	 * Getter X
	 * @return x
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Getter y
	 * @return y
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * Setter X
	 * @param x1
	 */
	public void setX(int x1){
		x = x1;
	}
	
	/**
	 * Setter Y
	 * @param y1
	 */
	public void setY(int y1){
		y = y1;
	}
	
	/**
	 * Methode equals
	 * @param c
	 * @return c.gety & c.getx
	 */
	public boolean equals(Coord c){
		return this.y== c.getY() && this.x == c.getX();
	}
	
	/**
	 * Methode distance
	 * @param c
	 * @return distance
	 */
	public int distance(Coord c){
		int distanceX = c.getX() - x;
		if(distanceX <0) distanceX*=-1;
		int distanceY = c.getY() - y;
		if(distanceY <0) distanceY*=-1;
		return (int)Math.sqrt(distanceX*distanceX + distanceY*distanceY);
	}

	public Coord somme(Coord vect) {
		// TODO Auto-generated method stub
		return new Coord(x+vect.getX(),y+vect.getY());
	}
	public Coord inverse(){
		return new Coord(x*-1,y*-1);
	}

	public Coord diff(Coord vect) {
		// TODO Auto-generated method stub
		return new Coord(x-vect.getX(),y-vect.getY());
	}

}
