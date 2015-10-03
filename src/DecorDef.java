import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public class DecorDef extends Decor {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int echelle;
	private final Plan plan; 

	private ArrayList<Cible> cibles;
	
	// hauteur en px
	private final int hauteur;	
	// largeur en px
	private final int largeur;
	// hauteur du sol en px
	private final int hauteurSol;
	// position de depart des trajectoires en px
	private final int posDep;
	// hauteur du lancepierre en px
	private final int hauteurLP;
	
	
	// hauteur en metres
	private final double hauteurM;
	// largeur en metres
	private final double largeurM;
	// hauteur du sol en metres
	private final double hauteurSolM;
	// position de depart des trajectoires en metres
	private final double posDepM;
	// hauteur du lancepierre en metre
	private final double hauteurLPM;
		
	

	public DecorDef(Dimension d,int ech,double hautSol,double posDebTraj,double hautLP){
		setLayout(null);
		echelle = ech;
		
		cibles = new ArrayList<Cible>();
		
		largeur = (int)d.getWidth();
		largeurM = largeur/echelle;
		
		hauteur = (int)d.getHeight();
		hauteurM = hauteur/echelle;
		
		hauteurSolM = hautSol;
		hauteurSol = (int)(hauteurSolM*echelle);

		hauteurLPM = hautLP;
		hauteurLP = (int)(hauteurLPM*echelle);
		
		posDepM = posDebTraj;
		posDep = (int)(posDepM*echelle);
		
		plan = new Plan(new Coord(posDep,hauteur-hauteurSol)); 
	}
	
	public Plan getPlan(){
		return plan;
	}
	
	public void paintComponent(Graphics g){
		
		g.setColor(new Color(91,158,238));
		g.fillRect(0, 0, largeur, hauteur);
		g.setColor(new Color(103,198,55));
		g.fillRect(0, hauteur-hauteurSol, largeur, hauteurSol);
		g.setColor(new Color(138,104,44));
		g.fillRect(posDep-10, hauteur-hauteurSol-hauteurLP,20, hauteurLP);
		g.setColor(Color.black);
		int d = this.getWidth() - echelle -20;
		g.drawLine(d,20,d,20+echelle);
		g.drawLine(d,20+echelle,d+echelle,20+echelle);

		revalidate();
	}

	public int getHauteurLP() {
		return hauteurLP;
	}

	public int getEchelle() {
		return echelle;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		// TODO Auto-generated method stub
		return hauteur;
	}

	public int getHauteurSol() {
		// TODO Auto-generated method stub
		return hauteurSol;
	}

	public int getposDep() {
		// TODO Auto-generated method stub
		return posDep;
	}

	public double getLargeurM() {
		// TODO Auto-generated method stub
		return largeurM;
	}

	public double getHauteurM() {
		// TODO Auto-generated method stub
		return hauteurM;
	}

	public double getHauteurSolM() {
		// TODO Auto-generated method stub
		return hauteurSolM;
	}

	public double getposDepM() {
		// TODO Auto-generated method stub
		return posDepM;
	}

	public double getHauteurLPM() {
		// TODO Auto-generated method stub
		return hauteurLPM;
	}

	@Override
	public ArrayList<Cible> getCibles() {
		// TODO Auto-generated method stub
		return cibles;
	}

	@Override
	public boolean placeLibre(int x, int y, int l, int h) {
		// TODO Auto-generated method stub
		for(Cible c : cibles){
			if(x +l > c.get_X() && x < (c.get_X() + c.getLargeur()) 
			&& y+h > c.get_Y() && y < ( c.get_Y() + c.getHauteur()))
				return false;
		}
		return true;
	}
	
	public boolean gagne(){
		for(Cible c : cibles){
			if(!c.estTouche()) return false;
		}
		return true;
	}
}
