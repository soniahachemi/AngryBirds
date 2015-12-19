package Graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlleur.ControlleurCible;
import Main.Main;
import Modele.Cible;
import Modele.Oiseau;
import Vue.DecorDef;


/**
 * Classe menu : partie graphique 
 * @author Groupe L5
 *
 */
public class Menu extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Image img;
	protected JLabel titre, soustitre, image;
	protected JButton jouer, regles, credits, options;
	
	
	/**
	 * Constructeur
	 * @param l
	 * @param h
	 * Defini toute l interface presente dans la fenetre menu
	 */
	public Menu(){

		super();
		setLayout(null);
		
		//this.setResizable(false);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		titre = new JLabel("Bienvenue sur Angry Birds !");
		titre.setBounds(50,25,500,30);
		titre.setFont(new Font("", Font.BOLD, 22));
		titre.setForeground(Color.BLUE);
		add(titre);
		
		soustitre = new JLabel("Groupe L5");
		soustitre.setBounds(800,25,500,30);
		soustitre.setFont(new Font("", Font.ITALIC, 20));
		soustitre.setForeground(Color.DARK_GRAY);
		add(soustitre);
		
		jouer = new JButton("Jouer");
		jouer.setBounds(110,180,200,60);
		jouer.setFont(new Font("", Font.CENTER_BASELINE, 15));
		jouer.setForeground(Color.RED);
		
		jouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				DecorDef decor = new DecorDef(Main.getFenetre().getContentPane().getWidth(),Main.getFenetre().getContentPane().getHeight(),40,125,100);
				decor.ajouterOiseau(new Oiseau(decor));
				decor.ajouterOiseau(new Oiseau(decor));
				for(int i=0;i<10;i++){
					Cible c = new Cible(decor);
					decor.ajouterCible(c);
				}
				new ControlleurCible(decor);
				Main.getFenetre().changerFond(decor);
			}
		});
		add(jouer);
		
		regles = new JButton("Règles du jeu");
		regles.setBounds(110,250,200,60);
		regles.setFont(new Font("", Font.CENTER_BASELINE, 15));
		regles.setForeground(Color.RED);
		add(regles);
		
		credits = new JButton("Crédits");
		credits.setBounds(110,320,200,60);
		credits.setFont(new Font("",Font.CENTER_BASELINE, 15));
		credits.setForeground(Color.RED);
		
		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
			    Main.getFenetre().changerFond(new Credits());
			}
		});
		 
		add(credits);
		
		options = new JButton("Options");
		options.setBounds(110,390,200,60);
		options.setFont(new Font("",Font.CENTER_BASELINE, 15));
		options.setForeground(Color.RED);
		add(options);
			
	}
	

	public void paintComponent(Graphics g){
		try {
			BufferedImage img = ImageIO.read(new File("img/fd.jpg"));	// (A)
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); // Pour que la position et les dimensions de l'image concordent avec celles du fond
		} catch (IOException e){}
	}
	
	

	
	
	
}
