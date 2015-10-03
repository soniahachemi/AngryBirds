import javax.swing.JOptionPane;


public class Main {

	private static Fenetre f;
	
	public static void main(String[] args) {
		f = new Fenetre(Constante.LARGEURDF,Constante.HAUTEURDF);
		
		Decor decor = new DecorDef(f.getContentPane().getSize(),50,1,1,1.7);
		f.changerFond(decor);

		
		Oiseau o = new Oiseau(decor);
		decor.add(o);
		
		Cible c = new Cible(decor);
		decor.add(c);
		c.placer(decor.getPlan());
		
			o.set_X(0);
			o.set_Y(decor.getHauteurLP());
			o.placer(decor.getPlan());
	
			double vitesse,angle;
			
			try{
			    vitesse = Double.parseDouble(JOptionPane.showInputDialog(null,"Choisissez une vitesse : "));
			    angle = Double.parseDouble(JOptionPane.showInputDialog(null, "Choisissez un angle ;"));
			}catch(Exception e){
				vitesse = 80;
				angle = 40;
			}
	
			f.revalidate();
			
			Runnable a = new Animation(o,decor,vitesse,angle);
			new Thread(a).start();
	}

	public static Fenetre getFenetre(){
		return f;
		
	}
}
