import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Classe DecorDef
 * Herite de Decor
 * @author Quentin  Spinnewyn
 *
 */
public class DecorDef extends Decor {
	
	private static final long serialVersionUID = 1L;
	private final int echelle;
	private final Plan plan; 
	private ArrayList<Oiseau> oiseaux;
	private ArrayList<Cible> cibles;
	private ArrayList<Coord> pointsTraj;
	
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
		

	/**
	 * Constructeur DecorDef
	 * @param d
	 * @param ech
	 * @param hautSol
	 * @param posDebTraj
	 * @param hautLP
	 */
	public DecorDef(Dimension d,int ech,double hautSol,double posDebTraj,double hautLP){
		setLayout(null);
		echelle = ech;
		
		cibles = new ArrayList<Cible>();
		oiseaux = new ArrayList<Oiseau>();
		pointsTraj = new ArrayList<Coord>();

		
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
	
	/**
	 * Retourne le plan
	 */
	public Plan getPlan(){
		return plan;
	}
	
	/**
	 * Methode paintComponent
	 */
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

		//placement oiseau
		for(Oiseau o : oiseaux){
			g.setColor(Color.yellow);
			Coord coordPos = plan.plan_Concret(o.getCoord());
			g.fillOval(coordPos.getX()-o.getTaille()/2,coordPos.getY()-o.getTaille()/2, o.getTaille(), o.getTaille());
			Coord coordPos2 = plan.plan_Concret(o.getProchaineCoord());
			g.drawLine(coordPos.getX(), coordPos.getY(),
					coordPos2.getX(), coordPos2.getY());
		}
		
		//placement cibles
		for(Cible c : cibles){
			if(c.estTouche()) g.setColor(Color.red);
			else g.setColor(Color.blue);
			Coord coordPos = plan.plan_Concret(c.getCoord());
			g.fillOval(coordPos.getX()-c.getTaille()/2,coordPos.getY()-c.getTaille()/2, c.getTaille(), c.getTaille());
		}
		
		//placements pointilles trajectoire
		for(Coord point : pointsTraj){
			g.setColor(Color.black);
			Coord coordPos = plan.plan_Concret(point);
			g.fillOval(coordPos.getX()-1,coordPos.getY()-1,2,2);
		}
		
		revalidate();
	}

	/**
	 * Retourne la hauteurLP
	 */
	public int getHauteurLP() {
		return hauteurLP;
	}

	/**
	 * Retourne l echelle
	 */
	public int getEchelle() {
		return echelle;
	}

	/**
	 * Retourne la largeur
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * Retourne la hauteur
	 */
	public int getHauteur() {
		// TODO Auto-generated method stub
		return hauteur;
	}

	/**
	 * Retourne la hauteur sol
	 */
	public int getHauteurSol() {
		// TODO Auto-generated method stub
		return hauteurSol;
	}

	/**
	 * Retourne la position de depart de l oiseau
	 */
	public int getposDep() {
		// TODO Auto-generated method stub
		return posDep;
	}

	/**
	 * Retourne largeurM
	 */
	public double getLargeurM() {
		// TODO Auto-generated method stub
		return largeurM;
	}

	/**
	 * Retourne hauteurM
	 */
	public double getHauteurM() {
		// TODO Auto-generated method stub
		return hauteurM;
	}

	/**
	 * Retourne hauteurSolM
	 */
	public double getHauteurSolM() {
		// TODO Auto-generated method stub
		return hauteurSolM;
	}

	/**
	 * Retourne position depart M
	 */
	public double getposDepM() {
		// TODO Auto-generated method stub
		return posDepM;
	}

	/**
	 * Retourne hauteurLPM
	 */
	public double getHauteurLPM() {
		// TODO Auto-generated method stub
		return hauteurLPM;
	}

	/**
	 * Retourne liste de cibles
	 */
	@Override
	public ArrayList<Cible> getCibles() {
		// TODO Auto-generated method stub
		return cibles;
	}

	/**
	 * Place librement les cibles
	 */
	@Override
	public boolean placeLibre(int x, int y, int taille) {
		// TODO Auto-generated method stub
		for(Cible c : cibles){
				if(c.getCoord().distance(new Coord(x,y)) < (c.getTaille()/2 + taille/2)) 
						return false;
		}
		return true;
	}
	
	/**
	 * Gagne si la cible est touchee
	 */
	public boolean gagne(){
		for(Cible c : cibles){
			if(!c.estTouche()) return false;
		}
		return true;
	}

	/**
	 * Retourne liste oiseau	
	 */
	@Override
	public ArrayList<Oiseau> getOiseaux() {
		// TODO Auto-generated method stub
		return oiseaux;
	}

	/**
	 * Ajoute une cible
	 */
	@Override
	public void ajouterCible(Cible c) {
		// TODO Auto-generated method stub
		cibles.add(c);
	}

	/**
	 * Ajoute l oiseau
	 */
	@Override
	public void ajouterOiseau(Oiseau o) {
		// TODO Auto-generated method stub
		oiseaux.add(o);
	}
	
	/**
	 * Ajout pointilles trajectoire
	 */
	public void ajouterPoint(Coord c) {
		// TODO Auto-generated method stub
		pointsTraj.add(c);
	}
	
	/**
	 * Efface les pointilles de trajectoire
	 */
	public void viderPointsTraj() {
		// TODO Auto-generated method stub
		pointsTraj = new ArrayList<Coord>();
	}
}
