package Graphique;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Credits extends JFrame{

	
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
