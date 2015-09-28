
public class Main {

	private static Fenetre f;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f = new Fenetre();
		f.changerFond(new Menu());
	}

	public static Fenetre getFenetre(){
		return f;
		
	}
}
