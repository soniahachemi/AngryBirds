package Modele;




import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Random;

import javax.imageio.ImageIO;

import Controlleur.Coord;
import Vue.Decor;

/**
 * Classe cible, gerant les differents obstacles presents sur la carte
 * @author Groupe L5
 *
 */
public class Cible extends Observable{

	private Coord coord;
	private boolean touche;
	private int taille;
	private Coord vect;
	private boolean rond;
	private double angle;
	private Decor decor;
	
	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public boolean isRond() {
		return rond;
	}
	
	public Coord getVect() {
		return vect;
	}


	public void setVect(Coord vect) {
		this.vect = vect;
		setChanged();
		notifyObservers();
	}


	/**
	 * Constructeur
	 * @param d : decor
	 */
	public Cible(Decor d){
		decor = d;
		touche = false;
		taille = 50;
		
		//calcule les coords des cibles en random sur la carte
		int x = d.getposDep()+ new Random().nextInt(d.getLargeur()-d.getposDep());
		int y = taille/2 + new Random().nextInt(d.getHauteur()-taille/2);
		while(!d.placeLibre(x, y, taille)){
			x = d.getposDep()+ new Random().nextInt(d.getLargeur()-d.getposDep());
			y = taille/2 + new Random().nextInt(d.getHauteur()-taille/2);
		}
		this.coord = new Coord(x,y);
		this.vect = new Coord(new Random().nextInt(2),new Random().nextInt(2));
		rond = new Random().nextBoolean();
	}
	
	
	/**
	 * Methode getCoord
	 * @return coord
	 */
	public Coord getCoord(){
		return coord;
	}
	
	/**
	 * Methode getX
	 * @return coord.getX
	 */
	public int get_X(){
		return coord.getX();
	}
	
	/**
	 * Methode setX
	 * @param x
	 */
	public void set_X(int x){
		coord.setX(x);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Methode getY
	 * @return coord.getY
	 */
	public int get_Y(){
		return coord.getY();
	}
	
	/**
	 * Methode setY
	 * @param y
	 */
	public void set_Y(int y){
		coord.setY(y);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Methode getTaille
	 * @return taille
	 */
	public int getTaille(){
		return taille;
	}
	
	/**
	 * Methode estTouche
	 * @return touche
	 */
	public boolean estTouche(){
		return touche;
	}
	
	/**
	 * Methode toucher
	 */
	public void toucher(){
		touche = true;
		setChanged();
		notifyObservers();
	}


	public void setCoord(Coord c) {
		// TODO Auto-generated method stub
		coord=c;
		setChanged();
		notifyObservers();
	}
	public void dessin(Graphics g) {
		
		
		try {
			BufferedImage img = ImageIO.read(new File("img/box.png"));
			AffineTransform tx = new AffineTransform();
		    tx.rotate(Math.toRadians(angle),getTaille() / 2 ,getTaille() / 2);
			//tx.rotate(Math.toRadians(angle), get_X(), get_Y());

		    AffineTransformOp op = new AffineTransformOp(tx,
		        AffineTransformOp.TYPE_BILINEAR);
		    img = op.filter(img, null);
		    
		    Coord coord = decor.getPlan().plan_Concret(new Coord(get_X(),get_Y()));
		    g.drawImage(img, coord.getX()-getTaille()/2 , coord.getY()-getTaille()/2, null);
		   // System.out.println(get_X()+","+get_Y());
			
			} catch (IOException e){}
	}
}
