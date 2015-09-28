import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{

	public Fenetre(){
		this.setSize(this.getToolkit().getScreenSize());
		this.setUndecorated(true);
		//this.setSize(500,500);
		this.setVisible(true);
	}
	
	public void changerFond(JPanel fond){
		this.getContentPane().removeAll();
		revalidate();
		this.setContentPane(fond);
		//this.getContentPane().repaint();
		this.revalidate();
	}
}
