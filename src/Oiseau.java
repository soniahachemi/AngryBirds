/**
 * Classe Oiseau
 * @author Quentin  Spinnewyn
 *
 */
public class Oiseau {

	// coord par rapport au plan
	private Coord coord,prochaineCoord;
	private int taille;
	private DecorDef decor;
	private boolean isFlying=false;
	private boolean aFiniVol;
	
	/**
	 * Constructeur
	 * @param d
	 */
	public Oiseau(DecorDef d){
		decor=d;
		taille = 25;
		this.coord = new Coord(-taille/2-40,taille/2);
		prochaineCoord = new Coord(-taille/2-20,taille/2);
		aFiniVol=false;
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
	public boolean isFlying(){
		return isFlying;
	}
	
	/**
	 * Methode finir le vol
	 */
	public void fly(){
		isFlying=true;
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
		isFlying=false;
	}

	public void placerSurLP() {
		// TODO Auto-generated method stub
		this.setCoord(new Coord(0,decor.getHauteurLP()+taille/2));
		this.setProchaineCoord(new Coord(20,decor.getHauteurLP()+taille/2));
	}
}
