import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class Oiseau extends JPanel{

	private Coord coord;
	private int largeur, hauteur;
	
	public Oiseau(){
		this.coord = new Coord(0,Constante.hauteurLP+(hauteur/2));
		largeur = 1*Constante.echelle;
		hauteur = 1*Constante.echelle;
	}
	public Oiseau(int l, int h){
		this.coord = new Coord(0,100);
		largeur = l;
		hauteur = h;
	}

	public void placer(Plan plan) {
		setBounds(plan.plan_Concret(coord).getX()-(largeur/2),plan.plan_Concret(coord).getY()-(hauteur/2),largeur,hauteur);
	}

	public void setX(int i) {
		coord.setX(i);
	}

	public void setY(int i) {
		coord.setY(i);
	}

	public Coord getCoord() {
		return coord;
	}
	public void paintComponent(Graphics g){
		
		g.setColor(Color.red);
		g.fillOval(0, 0, largeur, hauteur);
		g.setColor(Color.black);
		g.fillOval(largeur/2, hauteur/2, 5, 5);
	}
}
