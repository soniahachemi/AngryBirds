/**
 * Classe Oiseau
 * @author Quentin  Spinnewyn
 *
 */
public class Oiseau {

	// coord par rapport au plan
	private Coord coord;
	private int taille;
	
	private Coord prochaineCoord = new Coord(0,0);
	
	private boolean aFiniVol=false;
	
	/**
	 * Constructeur
	 * @param d
	 */
	public Oiseau(DecorDef d){
		taille = 25;
		this.coord = new Coord(0,d.getHauteurLP()+(taille/2));
		prochaineCoord = new Coord(25,d.getHauteurLP()+(taille/2));
	}

	/**
	 * Setter X
	 * @param i
	 */
	public void set_X(int i) {
		coord.setX(i);
	}
	
	/**
	 * Retourne coord.getX
	 * @return
	 */
	public int get_X() {
		return coord.getX();
	}

	/**
	 * Setter Y
	 * @param i
	 */
	public void set_Y(int i) {
		coord.setY(i);
	}
	
	/**
	 * Retourne coord.getY
	 * @return
	 */
	public int get_Y() {
		return coord.getY();
	}
	
	/**
	 * Retourne coord
	 * @return
	 */
	public Coord getCoord() {
		return coord;
	}
	
	/**
	 * Setter coord
	 * @param c
	 */
	public void setCoord(Coord c) {
		this.coord = c;
	}
	
	/**
	 * Retourne les prochaines coords
	 * @return
	 */
	public Coord getProchaineCoord(){
		return this.prochaineCoord;
	}
	
	/**
	 * Setter prochaines coords
	 * @param c
	 */
	public void setProchaineCoord(Coord c){
		prochaineCoord = c;
	}
	
	/**
	 * Retourne la taille
	 * @return
	 */
	public int getTaille(){
		return taille;
	}
	
	/**
	 * Retourne fin vol
	 * @return
	 */
	public boolean aFiniVol(){
		return aFiniVol;
	}
	
	/**
	 * Methode finir le vol
	 */
	public void finirVol(){
		aFiniVol=true;
	}
}
