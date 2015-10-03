import javax.swing.JFrame;


public class Fenetre extends JFrame {

	public Fenetre(int l, int h){
		this.setSize(l,h);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void changerFond(Decor decor) {
		// TODO Auto-generated method stub
		setContentPane(decor);
		revalidate();
	}
}
