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

import Builder.Builder;
import Controlleur.ControlleurCible;
import Main.Main;
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
	protected JLabel titre, soustitre, image, copyr;
	protected JButton jouer, regles, credits, options;
	
	
	/**
	 * Constructeur
	 * Defini toute l interface presente dans la fenetre menu
	 */
	public Menu(){

		super();
		setLayout(null);
		
		//this.setResizable(false);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		titre = new JLabel("Bienvenue sur Angry Birds !");
		titre.setBounds(50,25,500,35);
		titre.setFont(new Font("", Font.BOLD, 32));
		titre.setForeground(Color.GREEN);
		add(titre);
		
		soustitre = new JLabel("Groupe L5");
		soustitre.setBounds(750,30,500,30);
		soustitre.setFont(new Font("", Font.ITALIC, 20));
		soustitre.setForeground(Color.DARK_GRAY);
		add(soustitre);
		
		jouer = new JButton("Jouer");
		jouer.setBounds(110,160,200,60);
		jouer.setFont(new Font("", Font.CENTER_BASELINE, 20));
		jouer.setForeground(Color.RED);
		jouer.setFocusPainted(false);
		jouer.setContentAreaFilled(false);
		jouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				DecorDef decor = new DecorDef(Main.getFenetre().getContentPane().getWidth(),Main.getFenetre().getContentPane().getHeight(),40,125,100);
				decor.ajouterOiseau(new Oiseau(decor));
				decor.ajouterOiseau(new Oiseau(decor));
				Builder b = new Builder(decor);
				b.tour();
				Main.getFenetre().changerFond(decor);
				new ControlleurCible(decor);
			}
		});
		add(jouer);
		
		regles = new JButton("Regles du jeu");
		regles.setBounds(110,230,200,60);
		regles.setFont(new Font("", Font.CENTER_BASELINE, 20));
		regles.setForeground(Color.RED);
		regles.setFocusPainted(false);
		regles.setContentAreaFilled(false);
		regles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
			    Main.getFenetre().changerFond(new Regles());
			    
			}
		});
		add(regles);
		
		credits = new JButton("Credits");
		credits.setBounds(700,160,200,60);
		credits.setFont(new Font("",Font.CENTER_BASELINE, 20));
		credits.setForeground(Color.RED);
		credits.setFocusPainted(false);
		credits.setContentAreaFilled(false);
		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
			    Main.getFenetre().changerFond(new Credits());
			    
			}
		});
		add(credits);
		
		options = new JButton("Options");
		options.setBounds(700,230,200,60);
		options.setFont(new Font("",Font.CENTER_BASELINE, 20));
		options.setForeground(Color.RED);
		options.setFocusPainted(false);
		options.setContentAreaFilled(false);
		add(options);
			
		
		copyr = new JLabel("Copyright Groupe L5 - Tous droits reserves");
		copyr.setBounds(700, 520, 290, 20);
		copyr.setFont(new Font("",Font.ITALIC, 12));
		copyr.setForeground(Color.WHITE);
		add(copyr);
	}
	

	@Override
	public void paintComponent(Graphics g){
		try {
			BufferedImage img = ImageIO.read(new File("img/fd.jpg"));	// (A)
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); // Pour que la position et les dimensions de l'image concordent avec celles du fond
		} catch (IOException e){}
	}
	
}
