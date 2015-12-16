package Graphique;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



	/**
	 * Classe Credits
	 * presente les membres du groupe, copyright etc
	 */
public class Credits extends JFrame{

	/**
	 * Constructeur
	 * @param l
	 * @param h
	 * Defini toute l interface presente dans la fenetre des credits
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel titre;
	
	public Credits(int l, int h) {
		
		super();
		JPanel p = new JPanel();
		p.setLayout(null);
		
		this.setSize(l,h);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		titre = new JLabel("Credits");
		titre.setBounds(50,25,500,30);
		titre.setFont(new Font("", Font.BOLD, 25));
		titre.setForeground(Color.BLUE);
		p.add(titre);
		
	}
	
}
