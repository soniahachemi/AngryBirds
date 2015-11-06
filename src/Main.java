
public class Main {

	private static Fenetre f;
	public static int compteur =0;
	
	public static void main(String[] args) {
		f = new Fenetre(Constante.LARGEURDF,Constante.HAUTEURDF);
		
		Decor decor = new DecorDef(f.getContentPane().getSize(),50,1,1,1.7);
		f.changerFond(decor);

		
		Oiseau o = new Oiseau(decor);
		decor.ajouterOiseau(o);
		
		for(int i=0;i<10;i++){
			Cible c = new Cible(decor);
			decor.ajouterCible(c);
		}
			new Animation(decor);
	}

	public static Fenetre getFenetre(){
		return f;
		
	}
}
