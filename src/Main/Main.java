package Main;


import Graphique.Menu;

/**
 * Classe principale : MAIN
 * @author Groupe L5
 *
 */
public class Main {

	private static Fenetre f;
	public static int compteur =0;
	
	/**
	 * Methode void main
	 * @param args
	 */
	public static void main(String[] args) {
		f = new Fenetre(1024,576);
		f.setTitle("Projet tuteure - Angry Birds - Groupe L5");
		f.changerFond(new Menu());
	}

	/**
	 * Retourne la fenetre
	 * @return
	 */
	public static Fenetre getFenetre(){
		return f;
		
	}
}
