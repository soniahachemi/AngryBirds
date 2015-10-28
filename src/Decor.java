import java.util.ArrayList;

import javax.swing.JPanel;

public abstract class Decor extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Renvoie le plan utilisé pour le decor
	 */
	public abstract Plan getPlan();
	
	/**
	 * Retourne l'echelle du plan.
	 * Par exemple si echelle = 50, 1metres sera representé sur 50px
	 * @return
	 */
	public abstract int getEchelle();
	
	public abstract ArrayList<Cible> getCibles();
	
	public abstract boolean placeLibre(int x, int y, int l, int h);
	
	/**
	 * Renvoie la largeur du decor en px
	 */
	public abstract int getLargeur();
	
	/**
	 * Renvoie la hauteur du decor en px
	 */
	public abstract int getHauteur();
	
	/**
	 *	Renvoie la hauteur du sol en px 
	 */
	public abstract int getHauteurSol();
	
	/**
	 * Renvoie la position de depart de la trajectoire des oiseaux
	 * (La distance entre le bord gauche du decor et le lance pierre en px)
	 */
	public abstract int getposDep();
	
	/**
	 * Retourne la hauteur du lance pierre en px
	 */
	public abstract int getHauteurLP();
	
	
	
	
	
	/**
	 * Renvoie la largeur du decor en mètres
	 */
	public abstract double getLargeurM();
	
	/**
	 * Renvoie la hauteur du decor en mètres
	 */
	public abstract double getHauteurM();
	
	/**
	 *	Renvoie la hauteur du sol en mètres 
	 */
	public abstract double getHauteurSolM();
	
	/**
	 * Renvoie la position de depart de la trajectoire des oiseaux
	 * (La distance entre le bord gauche du decor et le lance pierre en mètre)
	 */
	public abstract double getposDepM();
	
	/**
	 * Retourne la hauteur du lance pierre en mètres
	 */
	public abstract double getHauteurLPM();
	

	public abstract boolean gagne();

	public abstract void dessinerBec(Oiseau oiseau);
}
