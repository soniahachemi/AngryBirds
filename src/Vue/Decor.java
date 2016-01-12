package Vue;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Builder.Builder;
import Controlleur.Coord;
import Controlleur.Gravite;
import Controlleur.LancePierre;
import Graphique.Menu;
import Main.Main;
import Modele.Cible;
import Modele.Oiseau;

/**
 * Classe DecorDef Herite de Decor
 * 
 * @author Groupe L5
 *
 */
public class Decor extends JPanel implements Observer {

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
	// booleen drag (sera utile pour la suite avec les animations)
	private boolean drag = false;

	private double angle, vitesse;
	
	JLabel affScore;
	
	
	private int score;

	public int getScore() {
		return score;
	}




	public void setScore(int score) {
		this.score = score;
	}

	private Oiseau oiseauSurLP;

	/**
	 * Constructeur DecorDef
	 * 
	 * @param d
	 * @param ech
	 * @param hautSol
	 * @param posDebTraj
	 * @param hautLP
	 */
	public Decor(int l, int h, int hautSol, int posDebTraj, int hautLP) {
		setLayout(null);

		cibles = new ArrayList<Cible>();
		oiseaux = new ArrayList<Oiseau>();
		pointsTraj = new ArrayList<Coord>();

		largeur = l;

		hauteur = h;

		hauteurSol = hautSol;

		hauteurLP = hautLP;

		posDep = posDebTraj;
		score = 0;
		affScore = new JLabel(""+score);
		affScore.setFont(new Font("",Font.BOLD,30));
		affScore.setBounds(10,10,200,100);

		plan = new Plan(new Coord(posDep, hauteur - hauteurSol));
		this.setRequestFocusEnabled(true);
		this.requestFocus();
		repaint();
	
	
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseMoved(MouseEvent arg0) {
			}

			// Drag and drop
			public void mouseDragged(MouseEvent arg0) {
				if (oiseauSurLP != null && !oiseauSurLP.isFlying() && !oiseauSurLP.aFiniVol()) {
					Coord coord = plan.concret_Plan(new Coord(arg0.getX(), arg0.getY()));
					int dist = new Coord(0, hauteurLP).distance(coord);
					if (dist < 120) {
						oiseauSurLP.setCoord(coord);
						repaint();
						vitesse = dist + 20;
						angle = 0;
						double tan = 0;
						if (oiseauSurLP.get_X() <= 0 && oiseauSurLP.get_Y() <= hauteurLP) {
							double coteOppose = hauteurLP - oiseauSurLP.get_Y();
							double coteAdj = -oiseauSurLP.get_X();
							tan = coteOppose / coteAdj;
							angle = Math.toDegrees(Math.atan(tan));

						}
						if (oiseauSurLP.get_X() < 0 && oiseauSurLP.get_Y() > hauteurLP) {
							double coteOppose = oiseauSurLP.get_Y() - hauteurLP;
							double coteAdj = -oiseauSurLP.get_X();
							tan = coteOppose / coteAdj;
							angle = -Math.toDegrees(Math.atan(tan));

						}
						if (oiseauSurLP.get_X() > 0 && oiseauSurLP.get_Y() > hauteurLP) {
							double coteOppose = oiseauSurLP.get_Y() - hauteurLP;
							double coteAdj = oiseauSurLP.get_X();
							tan = coteOppose / coteAdj;
							angle = Math.toDegrees(Math.atan(tan)) + 180;
						}
						if (oiseauSurLP.get_X() >= 0 && oiseauSurLP.get_Y() <= hauteurLP) {
							double coteOppose = oiseauSurLP.get_X();
							double coteAdj = hauteurLP - oiseauSurLP.get_Y();
							tan = coteOppose / coteAdj;
							angle = 90 + Math.toDegrees(Math.atan(tan));
						}
						Coord coord2 = LancePierre.prochCoordDroite(25, oiseauSurLP.getCoord(),
								new Coord(0, hauteurLP + oiseauSurLP.getTaille() / 2));
						oiseauSurLP.setProchaineCoord(coord2);
						drag = true;
					}
				}
			}
		});
		this.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent me) {
				// recuperation drag
				if (drag) {
					if (oiseauSurLP != null && !oiseauSurLP.isFlying() && !oiseauSurLP.aFiniVol()) {
						lancePierre();

					}
					drag = false;
				}

			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
			}

		});
		
		
		JButton jouer = new JButton("Retour au menu");
		jouer.setBounds(760,30,200,80);
		jouer.setFont(new Font("", Font.ITALIC, 18));
		jouer.setForeground(Color.BLACK);
		jouer.setFocusPainted(false);
		jouer.setContentAreaFilled(false);
		jouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				Main.getFenetre().changerFond(new Menu());
			}
		});
		add(jouer);
		
		JButton restart = new JButton("Rejouer");
		restart.setBounds(560,30,200,80);
		restart.setFont(new Font("", Font.ITALIC, 18));
		restart.setForeground(Color.BLACK);
		restart.setFocusPainted(false);
		restart.setContentAreaFilled(false);
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				Decor decor = new Decor(Main.getFenetre().getContentPane().getWidth(),Main.getFenetre().getContentPane().getHeight(),40,125,100);
				decor.ajouterOiseau(new Oiseau(decor));
				decor.ajouterOiseau(new Oiseau(decor));
				decor.ajouterOiseau(new Oiseau(decor));

				Builder b = new Builder(decor);
				b.tour();
				new Gravite(decor);
				Main.getFenetre().changerFond(decor);
			}
		});
		add(restart);
		
		
		add(affScore);
		
		}
		
		
	

	public Oiseau oiseauSurLP() {
		for (Oiseau o : oiseaux) {
			if (!o.aFiniVol()) {
				oiseauSurLP = o;
				o.placerSurLP();
				return o;
			}
		}
		return null;
	}

	public void lancePierre() {
		new LancePierre(oiseauSurLP, this, vitesse, angle);
		oiseauSurLP.fly();
	}

	/**
	 * Retourne le plan
	 */
	public Plan getPlan() {
		return plan;
	}

	/**
	 * Methode paintComponent
	 */
	@Override
	public void paintComponent(Graphics g) {

		score=0;
		
		g.setColor(new Color(91,158,238));
		g.fillRect(0, 0, largeur, hauteur);
		g.setColor(new Color(103,198,55));
		g.fillRect(0, hauteur-hauteurSol, largeur, hauteurSol);
		g.setColor(new Color(138,104,44));
		g.fillRect(posDep-10, hauteur-hauteurSol-hauteurLP,20, hauteurLP);

		// placement oiseau
		for (Oiseau o : oiseaux) {
			g.setColor(Color.yellow);
			Coord coordPos = plan.plan_Concret(o.getCoord());
			g.fillOval(coordPos.getX() - o.getTaille() / 2, coordPos.getY() - o.getTaille() / 2, o.getTaille(),
					o.getTaille());
			Coord coordPos2 = plan.plan_Concret(o.getProchaineCoord());
			g.drawLine(coordPos.getX(), coordPos.getY(), coordPos2.getX(), coordPos2.getY());
		}

		// placement cibles
			for(Cible c : cibles){
				if(c.estTouche()) score+=3;
				affScore.setText(""+score);
				if(score>=20){
					affScore.setText("Gagné !");
					oiseaux.clear();
				}
				c.dessin(g);
			
			}
			try{
				for(Coord c : pointsTraj){
				g.setColor(Color.black);
				g.fillOval(plan.plan_Concret(c).getX(), plan.plan_Concret(c).getY(), 2, 2);
				}
			}catch(Exception e){
				
			}

		if (oiseauSurLP != null) {
			int dist = new Coord(0, hauteurLP).distance(oiseauSurLP.getCoord());
			if (dist < 120) {
				Graphics2D g2 = (Graphics2D) (g);
				g2.setStroke(new BasicStroke(8));
				g2.setColor(new Color(238, 201, 0));
				Coord co = plan.plan_Concret(oiseauSurLP.getCoord());
				Coord cl = plan.plan_Concret(new Coord(0, hauteurLP));
				g2.draw(new Line2D.Float(co.getX(), co.getY(), cl.getX(), cl.getY()));
			} else if (dist > 200) {
				Graphics2D g2 = (Graphics2D) (g);
				g2.setStroke(new BasicStroke(8));
				g2.setColor(new Color(238, 201, 0));
				Coord cl = plan.plan_Concret(new Coord(0, hauteurLP));
				g2.draw(new Line2D.Float(cl.getX() - 10, cl.getY() + 20, cl.getX(), cl.getY()));
			}
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
		for (Cible c : cibles) {
			if (c.getCoord().distance(new Coord(x, y)) < (c.getTaille() / 2 + taille / 2))
				return false;
		}
		return true;
	}

	/**
	 * Gagne si la cible est touchee
	 */
	public boolean gagne() {
		for (Cible c : cibles) {
			if (!c.estTouche())
				return false;
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
		c.addObserver(this);
		cibles.add(c);
	}

	/**
	 * Ajoute l oiseau
	 */
	public void ajouterOiseau(Oiseau o) {
		// TODO Auto-generated method stub
		oiseaux.add(o);
		o.addObserver(this);
		if (oiseauSurLP == null) {
			oiseauSurLP = o;
			o.placerSurLP();
		}
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

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		repaint();
	}
}
