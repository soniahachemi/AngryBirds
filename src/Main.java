/**
 * Classe principale : MAIN
 * @author Quentin  Spinnewyn
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
		f.setTitle("Projet tuteuré - Angry Birds - Groupe L5");
		DecorDef decor = new DecorDef(f.getContentPane().getWidth(),f.getContentPane().getHeight(),80,125,100);
		f.changerFond(decor);
		decor.ajouterOiseau(new Oiseau(decor));
		decor.ajouterOiseau(new Oiseau(decor));

		for(int i=0;i<10;i++){
			Cible c = new Cible(decor);
			decor.ajouterCible(c);
		}
		//	new Animation(decor);
	}

	/**
	 * Retourne la fenetre
	 * @return
	 */
	public static Fenetre getFenetre(){
		return f;
		
	}
}
