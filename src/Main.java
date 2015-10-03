
public class Main {

	private static Fenetre f;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f = new Fenetre(1000,500);
		//System.out.println(f.getContentPane().getSize());
		Decor decor = new DecorDef(f.getContentPane().getSize(),50,1,1,1.7);
		f.changerFond(decor);

		
		Oiseau o = new Oiseau(decor);
		decor.add(o);
		o.placer(decor.getPlan());

		f.revalidate();
		
		Runnable a = new Animation(o,decor,50,40.0);
		new Thread(a).start();
	}

	public static Fenetre getFenetre(){
		return f;
		
	}
}
