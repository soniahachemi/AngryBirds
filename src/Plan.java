/**
 * Un plan est un objet représentant un Plan, tel qu'on a l'habitude d'en rencontrer.
 * Les coordonnees du point d'origine sont (0,0) dans le plan
 * mais sont differentes dans le JPanel contenant le plan.
 * Par exemple, dans un JPanel de 500x500, on peut creer un Plan dont l'origine
 * se trouve aux coordonnées(50,400) , en bas à gauche donc.
 * Les x augmentent de gauche à droite et les y de bas en haut.
 * Chaque coordonnées "concrètes" du JPanel possède donc un equivalent dans le plan 
 *
 */
public class Plan {

	// Les coordonnees "concretes" du point d'origine
	private final Coord coordOrigin;
	
	public Plan(Coord coord){
		this.coordOrigin = coord;
	}
	public Coord getCoordOrigin(){
		return this.coordOrigin;
	}
	public int getXOrigin(){
		return this.coordOrigin.getX();
	}
	public int getYOrigin(){
		return this.coordOrigin.getY();
	}
	
	/**
	 * Traduit des coordonnees du plan en coordonnees "concretes"
	 * @return
	 */
	public Coord plan_Concret(Coord coordPlan){
		return new Coord(coordPlan.getX()+getXOrigin(), getYOrigin()-coordPlan.getY());
	}
	/**
	 * Traduit des coordonnees "concretes" en coordonnees du plan
	 * @return
	 */
	public Coord concret_Plan(Coord coordConc){
		return new Coord(coordConc.getX()-getXOrigin(), getYOrigin()-coordConc.getY());
	}
	
}
