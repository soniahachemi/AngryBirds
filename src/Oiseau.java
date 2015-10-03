import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class Oiseau extends JPanel{

	// coord par rapport au plan
	private Coord coord;
	private int largeur, hauteur;
	
	public Oiseau(Decor d){
		largeur = (int)Math.floor(0.6*d.getEchelle());
		hauteur = (int)Math.floor(0.6*d.getEchelle());
		this.coord = new Coord(0,d.getHauteurLP()+(hauteur/2));
	}
	public Oiseau(Decor d,int l, int h){
		this.coord = new Coord(0,0);
		largeur = (int)Math.floor(l*d.getEchelle());
		hauteur = (int)Math.floor(h*d.getEchelle());
	}

	public void placer(Plan plan) {
		int xV = plan.plan_Concret(coord).getX()-(largeur/2);
		int yV = plan.plan_Concret(coord).getY()-(hauteur/2);
		setBounds(xV,yV,largeur,hauteur);
	}

	public void set_X(int i) {
		coord.setX(i);
	}
	public int get_X() {
		return coord.getX();
	}

	public void set_Y(int i) {
		coord.setY(i);
	}
	public int get_Y() {
		return coord.getY();
	}
	public Coord getCoord() {
		return coord;
	}
	public void paintComponent(Graphics g){
		
		g.setColor(new Color(229,229,100));
		g.fillOval(0, 0, largeur, hauteur);
		g.setColor(Color.black);
		g.fillOval(largeur/2-3, hauteur/2-3, 5, 5);
		g.drawLine(largeur/3, hauteur/4, largeur/2, hauteur/2-4);
		g.setColor(new Color(213,114,56));
		g.fillOval(3*largeur/4, hauteur/3+3, largeur/4, 10);
		
	}
	public int getLargeur() {
		// TODO Auto-generated method stub
		return largeur;
	}
	public int getHauteur() {
		// TODO Auto-generated method stub
		return hauteur;
	}
}
