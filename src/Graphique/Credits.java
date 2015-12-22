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

import Main.Main;



	/**
	 * Classe Credits
	 * presente les membres du groupe, copyright etc
	 */
public class Credits extends JPanel{

	/**
	 * Constructeur
	 * Defini toute l interface presente dans la fenetre des credits
	 */
	private static final long serialVersionUID = 1L;
	protected Image img;
	protected JLabel titre, cred1, cred2, cred3, cred4, cred5, cred6, copyr;
	protected JButton prec;
	
	public Credits() {

		//this.setBackground(Color.LIGHT_GRAY);
		
		setLayout(null);
		titre = new JLabel("Credits");
		titre.setBounds(50,25,500,32);
		titre.setFont(new Font("", Font.BOLD, 30));
		titre.setForeground(Color.GREEN);
		add(titre);
		
		prec = new JButton("Retour");
		prec.setBounds(50,500,90,30);
		prec.setFont(new Font("", Font.ITALIC, 15));
		prec.setForeground(Color.BLUE);
		prec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
			    Main.getFenetre().changerFond(new Menu());
			}
		});
		add(prec);
		
		cred1 = new JLabel("Jeu Angry Birds cree dans le cadre du DUT Informatique.");
		cred1.setBounds(100,80,900,45);
		cred1.setFont(new Font("", Font.PLAIN, 35));
		cred1.setForeground(Color.DARK_GRAY);
		add(cred1);
		
		cred2 = new JLabel("L'implementation de courbes est ici proposee, et permet");
		cred2.setBounds(100,140,900,45);
		cred2.setFont(new Font("", Font.PLAIN, 35));
		cred2.setForeground(Color.DARK_GRAY);
		add(cred2);
		
		cred3 = new JLabel("a l'utilisateur d'utiliser le jeu facilement, notamment");
		cred3.setBounds(100,200,900,45);
		cred3.setFont(new Font("", Font.PLAIN, 35));
		cred3.setForeground(Color.DARK_GRAY);
		add(cred3);
		
		cred4 = new JLabel("grâce au systeme du Drag & Drop (voir les regles du jeu).");
		cred4.setBounds(100,260,900,45);
		cred4.setFont(new Font("", Font.PLAIN, 35));
		cred4.setForeground(Color.DARK_GRAY);
		add(cred4);
		
		cred5 = new JLabel("** Developpe par Hachemi Sonia (chef de projet), Spinnewyn Quentin,");
		cred5.setBounds(100,320,900,45);
		cred5.setFont(new Font("", Font.ITALIC, 18));
		cred5.setForeground(Color.blue);
		add(cred5);
		
		cred6 = new JLabel("Rocchia Tom et Dupriez Alexandre. Nous constituons le groupe L5. **");
		cred6.setBounds(100,370,900,45);
		cred6.setFont(new Font("", Font.ITALIC, 18));
		cred6.setForeground(Color.blue);
		add(cred6);
		
		copyr = new JLabel("Copyright Groupe L5 - Tous droits reserves");
		copyr.setBounds(700, 520, 290, 20);
		copyr.setFont(new Font("",Font.ITALIC, 12));
		copyr.setForeground(Color.WHITE);
		add(copyr);
	}
	
	public void paintComponent(Graphics g){
		try {
			BufferedImage img = ImageIO.read(new File("img/fd.jpg"));	// (A)
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); // Pour que la position et les dimensions de l'image concordent avec celles du fond
		} catch (IOException e){}
	}
	
}
