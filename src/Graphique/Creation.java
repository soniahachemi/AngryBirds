package Graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlleur.Coord;
import Controlleur.Gravite;
import Main.Main;
import Modele.Cible;
import Modele.Oiseau;
import Vue.Decor;
/**
 * Le mode creation permet de creer son decor
 * En cliquant sur le decor, une nouvelle cible apparait.
 * Il suffit ensuite de cliquer sur jouer pour commencer la partie
 * @author Soso
 *
 */
public class Creation extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Decor decor;
	private JLabel l1;
	
	
	public Creation(){
		this.setLayout(null);
		decor = new Decor(Main.getFenetre().getContentPane().getWidth(),Main.getFenetre().getContentPane().getHeight(),40,125,100);
		new Gravite(decor,this);
		this.requestFocus();
		this.addMouseListener(new MouseListener() {
			//Cible c;
			public void mouseClicked(MouseEvent arg0) {}

			public void mouseEntered(MouseEvent arg0) {}

			public void mouseExited(MouseEvent arg0) {}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Cible c = new Cible(decor);
				c.setCoord(decor.getPlan().concret_Plan(new Coord(arg0.getX(),arg0.getY())));
				decor.ajouterCible(c);
				repaint();
				}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//if(c!=null)
			}
		});
	JButton jouer = new JButton("Jouer");
	jouer.setBounds(760,30,200,80);
	jouer.setFont(new Font("", Font.CENTER_BASELINE, 20));
	jouer.setForeground(Color.RED);
	jouer.setFocusPainted(false);
	jouer.setContentAreaFilled(false);
	jouer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0){
			decor.ajouterOiseau(new Oiseau(decor));
			decor.ajouterOiseau(new Oiseau(decor));
			Main.getFenetre().changerFond(decor);
		}
	});
	add(jouer);
	
	l1 = new JLabel("Disposez les obstacles ou vous voulez, puis cliquez sur jouer :)");
	l1.setBounds(100,50,900,45);
	l1.setFont(new Font("", Font.PLAIN, 20));
	l1.setForeground(Color.DARK_GRAY);
	add(l1);
	
	
	}	
	
	
	public void paintComponent(Graphics g) {

		g.setColor(new Color(91,158,238));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(103,198,55));
		g.fillRect(0, getHeight()-decor.getHauteurSol(), getWidth(), decor.getHauteurSol());
		g.setColor(new Color(138,104,44));
		g.fillRect(decor.getposDep()-10, getHeight()-decor.getHauteurSol()-decor.getHauteurLP(),20, decor.getHauteurLP());
	
		for(Cible c : decor.getCibles()){
			c.dessin(g);
		}
	
	}
	
}
