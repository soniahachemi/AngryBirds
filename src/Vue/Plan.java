package Vue;

import Controlleur.Coord;

/**
 * Un plan est un objet repr�sentant un Plan, tel qu'on a l'habitude d'en rencontrer.
 * Les coordonnees du point d'origine sont (0,0) dans le plan
 * mais sont differentes dans le JPanel contenant le plan.
 * Par exemple, dans un JPanel de 500x500, on peut creer un Plan dont l'origine
 * se trouve aux coordonn�es(50,400) , en bas � gauche donc.
 * Les x augmentent de gauche � droite et les y de bas en haut.
 * Chaque coordonn�es "concr�tes" du JPanel poss�de donc un equivalent dans le plan 
 * @author Groupe L5
 */
public class Plan {

	// Les coordonnees "concretes" du point d'origine
	private final Coord coordOrigin;
	
	/**
	 * Constructeur
	 * @param coord
	 */
	public Plan(Coord coord){
		this.coordOrigin = coord;
	}
	
	/**
	 * Retourne les coordonnes d origine
	 * @return
	 */
	public Coord getCoordOrigin(){
		return this.coordOrigin;
	}
	
	/**
	 * Retourne x des coords d origine
	 * @return
	 */
	public int getXOrigin(){
		return this.coordOrigin.getX();
	}
	
	/**
	 * Retourne y des coords d origine
	 * @return
	 */
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
