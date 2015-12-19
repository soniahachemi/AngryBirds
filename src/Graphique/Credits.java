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
public class Credits extends JPanel{

	/**
	 * Constructeur
	 * @param l
	 * @param h
	 * Defini toute l interface presente dans la fenetre des credits
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel titre;
	
	public Credits() {

		setLayout(null);
		titre = new JLabel("Credits");
		titre.setBounds(50,25,500,30);
		titre.setFont(new Font("", Font.BOLD, 25));
		titre.setForeground(Color.BLUE);
		add(titre);
		
	}
	
}
