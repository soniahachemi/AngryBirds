package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe Fenetre
 * Herite de JFrame
 * @author Groupe L5
 *
 */
public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * @param l
	 * @param h
	 */
	public Fenetre(int l, int h){
		this.setSize(l,h);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Changement de fond
	 * @param fond
	 */
	public void changerFond(JPanel fond) {
		setContentPane(fond);
		revalidate();
	}
}
