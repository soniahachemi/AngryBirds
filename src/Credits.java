import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Credits extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel labelprincipal, titre;
	JButton retour;
	
	public void paintComponent(Graphics g){
		removeAll();
		g.setColor(new Color(170,136,188));
		g.fillRect(0, 0, getWidth(), getHeight());
		setLayout(null);	
		
		//BOUTON RETOUR
		if(retour==null) retour=new JButton("Retour");
		retour.setFont(new Font("", Font.BOLD, 35));
		retour.setForeground(Color.BLACK);
		retour.setBounds(this.getWidth()/3,3*this.getHeight()/4,this.getWidth()/3,this.getHeight()/4);
		retour.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Main.getFenetre().changerFond(new Menu());
			}
			
		});
		
		this.add(retour);
		
		
		//LABEL TITRE CREDITS
		if(titre==null) titre=new JLabel("Credits");
		titre.setFont(new Font("", Font.CENTER_BASELINE, 55));
		titre.setForeground(Color.white);
		titre.setBounds(this.getWidth()/3,0,this.getWidth()/3,this.getHeight()/4);
		this.add(titre);
		
		
		//LABEL CREDITS
		if(labelprincipal==null) labelprincipal=new JLabel("<html>Projet Angry Birds, realise dans le cadre de <br>l IUT Informatique de VDA. <br> Cree par Sonia Hachemi ; Quentin Spinnewyn ; <br> Tom Rocchia ; Alexandre Dupriez </html>");
		labelprincipal.setBounds(this.getWidth()/3,this.getHeight()/4,this.getWidth()/3,this.getHeight()/2);
		labelprincipal.setFont(new Font("", Font.BOLD, 15));
		labelprincipal.setForeground(Color.white);
		this.add(labelprincipal);
		
		revalidate();
		
	}
	
}
