import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JPanel{
	
	private JPanel el;
	private JLabel lab;
	private JButton jouer, options,credits,quitter;
	
	
	
	public void paintComponent(Graphics g){
		removeAll();
		setLayout(null);
		
		try {
			BufferedImage img = ImageIO.read(new File("img/bg.jpg"));	
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e){
			return;
		}  
		
		if(el==null) el = new JPanel();
		el.setLayout(new GridLayout(4,1,0,getHeight()/15));
		el.setBackground(new Color(0,0,0,0));
		el.setBounds(2*getWidth()/3, getHeight()/4, getWidth()/3-30, 3*getHeight()/4-10);
		
		if(lab==null) lab = new JLabel("Angry Birds");
		lab.setForeground(new Color(255,215,0));
		lab.setFont(new java.awt.Font("Comic Sans Ms",10,50));
		lab.setBounds(getWidth()/4, 10, getWidth()/2, getHeight()/4);
		add(lab);
		
		
		if(jouer==null){ jouer = new JButton("Jouer");
		}
		jouer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		el.add(jouer);
		
		if(options==null) options = new JButton("Options");
		options.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		el.add(options);
		if(credits==null) credits = new JButton("Credits");
		credits.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Main.getFenetre().changerFond(new Credits());

			}
			
		});
		
		el.add(credits);
		if(quitter==null) quitter = new JButton("quitter");
		quitter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		el.add(quitter);
		add(el);
		revalidate();

	}
}
