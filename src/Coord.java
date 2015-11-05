
public class Coord {
	
	private int x,y;
	
	public Coord(int x1, int y1){
		this.x = x1;;
		this.y = y1;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x1){
		x = x1;
	}
	public void setY(int y1){
		y = y1;
	}
	public boolean equals(Coord c){
		return this.y== c.getY() && this.x == c.getX();
	}
	public int distance(Coord c){
		int distanceX = c.getX() - x;
		if(distanceX <0) distanceX*=-1;
		int distanceY = c.getY() - y;
		if(distanceY <0) distanceY*=-1;
		return (int)Math.sqrt(distanceX*distanceX + distanceY*distanceY);
	}

}
