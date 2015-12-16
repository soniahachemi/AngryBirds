package Graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.Fenetre;
import Main.Main;


/**
 * Classe menu : partie graphique 
 * @author Groupe L5
 *
 */
public class Menu extends JFrame{

	
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
	public Menu(int l, int h){
		//f = new Fenetre(1024,576);
		super();
		JPanel p = new JPanel();
		p.setLayout(null);
		
		this.setSize(l,h);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		titre = new JLabel("Bienvenue sur Angry Birds !");
		titre.setBounds(50,25,500,30);
		titre.setFont(new Font("", Font.BOLD, 22));
		titre.setForeground(Color.BLUE);
		p.add(titre);
		
		soustitre = new JLabel("Groupe L5");
		soustitre.setBounds(800,25,500,30);
		soustitre.setFont(new Font("", Font.ITALIC, 20));
		soustitre.setForeground(Color.DARK_GRAY);
		p.add(soustitre);
		
		jouer = new JButton("Jouer");
		jouer.setBounds(390,200,200,60);
		jouer.setFont(new Font("", Font.CENTER_BASELINE, 15));
		jouer.setForeground(Color.RED);
		/*
		jouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				new Main();
			}
		});*/
		p.add(jouer);
		
		regles = new JButton("Règles du jeu");
		regles.setBounds(390,270,200,60);
		regles.setFont(new Font("", Font.CENTER_BASELINE, 15));
		regles.setForeground(Color.RED);
		p.add(regles);
		
		credits = new JButton("Crédits");
		credits.setBounds(390,340,200,60);
		credits.setFont(new Font("",Font.CENTER_BASELINE, 15));
		credits.setForeground(Color.RED);
		p.add(credits);
		
		options = new JButton("Options");
		options.setBounds(390,410,200,60);
		options.setFont(new Font("",Font.CENTER_BASELINE, 15));
		options.setForeground(Color.RED);
		p.add(options);
		

		this.add(p);
		this.setVisible(true);

	}
	
	
	
	private void setContentPane(Image image2) {
		// TODO Auto-generated method stub
		
	}


/*
		//Fond du menu
		public void paintComponent(Graphics g) throws IOException {
				img = ImageIO.read(new File("ressources"+File.separator+"fond.jpeg"));
				g.drawImage(img, 0, 0, this);
		}
	*/
	
	
	
	
}
