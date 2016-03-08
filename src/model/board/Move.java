package model.board;

public enum Move {
	
	UP(-1,0), DOWN(1,0), LEFT(0,-1), RIGHT(0,1);
	
	private int dx;
	private int dy;
	
	private Move(int x, int y){
		this.dx = x;
		this.dy = y;
	}

	public int getX(){
		return dx;
	}
	
	public int getY(){
		return dy;
	}
}
	