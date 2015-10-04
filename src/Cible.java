import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;


public class Cible extends JPanel{

	private static final long serialVersionUID = 1L;
	private Coord coord;
	private boolean touche;
	private int hauteur,largeur;
	
	public Cible(Decor d){
		touche = false;
		largeur = (int)Math.floor(0.6*d.getEchelle());
		hauteur = (int)Math.floor(0.6*d.getEchelle());
		int x = d.getposDep()+ new Random().nextInt(d.getLargeur()-d.getposDep());
		int y = hauteur/2 + new Random().nextInt(d.getHauteur()-hauteur/2);
		while(!d.placeLibre(x, y, largeur, hauteur)){
			x = d.getposDep()+ new Random().nextInt(d.getLargeur()-d.getposDep());
			y = hauteur/2 + new Random().nextInt(d.getHauteur()-hauteur/2);
		}
		this.coord = new Coord(x,y);
		d.getCibles().add(this);
	}
	public Cible(int l, int h){
		touche = false;
	}
	
	public Coord getCoord(){
		return coord;
	}
	public int get_X(){
		return coord.getX();
	}
	public void set_X(int x){
		coord.setX(x);
	}
	public int get_Y(){
		return coord.getY();
	}
	public void set_Y(int y){
		coord.setY(y);
	}
	public void placer(Plan plan) {
		int xV = plan.plan_Concret(coord).getX()-(largeur/2);
		int yV = plan.plan_Concret(coord).getY()-(hauteur/2);
		setBounds(xV,yV,largeur,hauteur);
	}
	public void paintComponent(Graphics g){
		if(!touche) g.setColor(Color.blue);
		else g.setColor(Color.red);
		g.fillOval(0, 0, this.getWidth(), this.getHeight());
	}
	public int getLargeur() {
		// TODO Auto-generated method stub
		return largeur;
	}
	public int getHauteur() {
		// TODO Auto-generated method stub
		return hauteur;
	}
	public boolean estTouche(){
		return touche;
	}
	public void toucher(){
		touche = true;
		repaint();
	}
}
