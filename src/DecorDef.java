import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Classe DecorDef
 * Herite de Decor
 * @author Quentin  Spinnewyn
 *
 */
public class DecorDef extends JPanel {
	
	private static final long serialVersionUID = 1L;
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
	
	
	
	private double angle,vitesse;
		

	/**
	 * Constructeur DecorDef
	 * @param d
	 * @param ech
	 * @param hautSol
	 * @param posDebTraj
	 * @param hautLP
	 */
	public DecorDef(int l, int h,int hautSol,int posDebTraj,int hautLP){
		setLayout(null);
		
		cibles = new ArrayList<Cible>();
		oiseaux = new ArrayList<Oiseau>();
		pointsTraj = new ArrayList<Coord>();

		
		largeur = l;
		
		hauteur = h;
		
		hauteurSol = hautSol;

		hauteurLP = hautLP;
		
		posDep = posDebTraj;
		
		plan = new Plan(new Coord(posDep,hauteur-hauteurSol)); 
		this.setRequestFocusEnabled(true);
		this.requestFocus();
		this.addMouseMotionListener(new MouseMotionListener() {
			
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
			
			}
			
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub

				if(oiseaux.get(0)!=null){
					
					Coord coord = plan.concret_Plan(new Coord(arg0.getX(),arg0.getY()));
					
//					System.out.println(coord.getX()+"   "+coord.getY());
					int dist = new Coord(0,hauteurLP).distance(coord);
					if(dist <120 ){
						oiseaux.get(0).setCoord(coord);
						repaint();
						vitesse = dist+20;
						angle=0;
						double tan=0;
						if(oiseaux.get(0).get_X() <0 && oiseaux.get(0).get_Y()<hauteurLP ){
							double coteOppose = hauteurLP -oiseaux.get(0).get_Y();
							double coteAdj = -oiseaux.get(0).get_X();
							tan = coteOppose/coteAdj;
							angle = Math.toDegrees(Math.atan(tan));
							//System.out.println("premier cas "+angle );
						}
						if(oiseaux.get(0).get_X() <0 && oiseaux.get(0).get_Y()>hauteurLP ){
							double coteOppose = oiseaux.get(0).get_Y()-hauteurLP;
							double coteAdj = -oiseaux.get(0).get_X();
							tan = coteOppose/coteAdj;
							angle = -Math.toDegrees(Math.atan(tan));
							//System.out.println("2 cas "+angle );

						}
						if(oiseaux.get(0).get_X()>0 && oiseaux.get(0).get_Y()>hauteurLP ){
							double coteOppose = oiseaux.get(0).get_Y()-hauteurLP;
							double coteAdj = oiseaux.get(0).get_X();
							tan = coteOppose/coteAdj;
							angle = Math.toDegrees(Math.atan(tan))+180;
							//System.out.println("3 cas angle = "+angle);

						}
						if(oiseaux.get(0).get_X()>0 && oiseaux.get(0).get_Y()<hauteurLP ){
							double coteOppose = hauteurLP-oiseaux.get(0).get_Y();
							double coteAdj = oiseaux.get(0).get_X();
							tan = coteOppose/coteAdj;
							angle = 90+Math.toDegrees(Math.atan(tan));
							//System.out.println("4 cas angle = "+angle);

						}
						Coord coord2 = Animation.coordParabole(0, vitesse, angle, oiseaux.get(0).get_X(), oiseaux.get(0).get_Y());
						System.out.println(oiseaux.get(0).get_X()+","+oiseaux.get(0).get_X()+" bec : "+coord2.getX()+","+coord2.getY());
						oiseaux.get(0).setProchaineCoord(coord2);
					}
				}
			}
		});
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lancePierre();
				//lancerAnim();

			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void lancerAnim(){
		new Animation(this,vitesse,angle);
	}
	public void lancePierre(){
		//new Animation(this,vitesse,angle);
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
			if(new Random().nextBoolean()) g.fillOval(coordPos.getX()-c.getTaille()/2,coordPos.getY()-c.getTaille()/2, c.getTaille(), c.getTaille());
			else g.fillRect(coordPos.getX()-c.getTaille()/2,coordPos.getY()-c.getTaille()/2, c.getTaille(), c.getTaille());
		}
		
		//placements pointilles trajectoire
		/*for(Coord point : pointsTraj){
			g.setColor(Color.black);
			Coord coordPos = plan.plan_Concret(point);
			g.fillOval(coordPos.getX()-1,coordPos.getY()-1,2,2);
		}*/
		
		revalidate();
	}

	/**
	 * Retourne la hauteurLP
	 */
	public int getHauteurLP() {
		return hauteurLP;
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
	 * Retourne liste de cibles
	 */
	public ArrayList<Cible> getCibles() {
		// TODO Auto-generated method stub
		return cibles;
	}

	/**
	 * Place librement les cibles
	 */
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
	public ArrayList<Oiseau> getOiseaux() {
		// TODO Auto-generated method stub
		return oiseaux;
	}

	/**
	 * Ajoute une cible
	 */
	public void ajouterCible(Cible c) {
		// TODO Auto-generated method stub
		cibles.add(c);
	}

	/**
	 * Ajoute l oiseau
	 */
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
