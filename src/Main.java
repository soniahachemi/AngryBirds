
public class Main {

	private static Fenetre f;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f = new Fenetre();
		Decor decor = new Decor();
		f.changerFond(decor);

		
		Oiseau o = new Oiseau();
		decor.add(o);
		o.placer(decor.getPlan());

		f.revalidate();
		
		Runnable a = new Animation(o,decor,1,30.0);
		new Thread(a).start();
	}

	public static Fenetre getFenetre(){
		return f;
		
	}
}
