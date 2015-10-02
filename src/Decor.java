import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Decor extends JPanel {
	
	private final Plan plan;

	public Decor(){
		setLayout(null);
		plan = new Plan(new Coord(Constante.debTrajX,Constante.hauteur-Constante.hauteurSol));
	}
	
	public Plan getPlan(){
		return this.plan;
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(0, 0, Constante.largeur, Constante.hauteur);
		g.setColor(Color.green);
		g.fillRect(0, Constante.hauteur - Constante.hauteurSol, Constante.largeur, Constante.hauteurSol);
		g.setColor(Color.BLACK);
		g.fillRect(Constante.debTrajX-10, Constante.hauteur-Constante.hauteurSol-Constante.hauteurLP,20, Constante.hauteurLP);
	}
}
