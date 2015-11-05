
public class Oiseau {

	// coord par rapport au plan
	private Coord coord;
	private int taille;
	
	private Coord prochaineCoord = new Coord(0,0);
	
	private boolean aFiniVol=false;
	
	public Oiseau(Decor d){
		taille = (int)Math.floor(0.6*d.getEchelle());
		this.coord = new Coord(0,d.getHauteurLP()+(taille/2));
		prochaineCoord = new Coord(25,d.getHauteurLP()+(taille/2));
	}

	public void set_X(int i) {
		coord.setX(i);
	}
	public int get_X() {
		return coord.getX();
	}

	public void set_Y(int i) {
		coord.setY(i);
	}
	public int get_Y() {
		return coord.getY();
	}
	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord c) {
		this.coord = c;
	}
	public Coord getProchaineCoord(){
		return this.prochaineCoord;
	}
	public void setProchaineCoord(Coord c){
		prochaineCoord = c;
	}
	public int getTaille(){
		return taille;
	}
	public boolean aFiniVol(){
		return aFiniVol;
	}
	public void finirVol(){
		aFiniVol=true;
	}
}
