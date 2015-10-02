
public class Animation extends Thread{

	private Oiseau o;
	private Decor d;
	private double vitesse,angle;
	
	public Animation(Oiseau o1, Decor d1, double vitesse1, double angle1){
		o=o1;
		d=d1;
		vitesse=vitesse1;
		angle=angle1;
	}
	
	public void run(){
		long t=0;
		while(t<100000){
			try{
				o.placer(d.getPlan());
				Main.getFenetre().revalidate();
				double rad = Math.toRadians(angle);
				o.setX((int)((vitesse*Math.cos(rad))*t));
				o.setY((int)((-(1/2)*9.81*Math.sqrt(t)+(vitesse*Math.sin(rad)*t))+Constante.hauteurLP));
				sleep(10);
				t+=10;
			}catch(Exception e){
				
			}
		}
	}
}
