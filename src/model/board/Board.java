package model.board;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import model.element.Blood;
import model.element.MoveListener;
import model.element.Sword;
import model.fighter.FighterHero;
import model.fighter.Hero;

public abstract class Board {
	
	public static final int SIZE = 12;
	
	private Cell[][] g = new Cell[SIZE][SIZE];
	private Point heroPosition;
	private Set<MoveListener> listeners = new HashSet<MoveListener>();
	
	public Board() {
		initialize();
	}
	

	public void initialize() {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				g[y][x] = new Cell();
			}
		}
		setContents();
		heroPosition = getHeroInitPosition(); 
		g[heroPosition.y][heroPosition.x].setContent(new Hero(new FighterHero()));
		cleanFog(heroPosition);
	}	

	public void heroMove(Move move) {
		if (getHero().isAlive()) {
			Point newPosition = new Point(heroPosition.x + move.getX(), heroPosition.y + move.getY());
	
			if (newPosition.x >= 0 && newPosition.y >= 0 && newPosition.x < SIZE && newPosition.y < SIZE) {
				if (g[newPosition.y][newPosition.x].canWalkOver()) {
					g[newPosition.y][newPosition.x].onWalk(getHero());
					g[heroPosition.y][heroPosition.x].removeContent();
					heroPosition = newPosition;
					cleanFog(heroPosition);
					listenerMoved(listeners);
					// llamar aca el metodo privado de recorrido de listeners
				} else if (g[newPosition.y][newPosition.x].canInteract()) {
					listenerMoved(listeners);
					g[newPosition.y][newPosition.x].interact(getHero());
					if ((g[newPosition.y][newPosition.x].getContent() instanceof Blood) || (g[newPosition.y][newPosition.x].getContent() instanceof Sword)) {
						reduceNumberOfEnemies();
					}
				}
			}
		}
	}
	
	private void cleanFog(Point p){
		for (int i = p.y-1; i <= p.y+1; i++) {
			for (int j = p.x-1; j <= p.x+1 ; j++) {
				if (i>=0 && i<SIZE && j>=0 && j<SIZE) {
					if (g[i][j].hasFog()) {
						g[i][j].removeFog();
						getHero().heal(getHero().getLevel().getValue());
					}
				}
			}
		}
	}
	
	// Metodo para recorrer el set de listener y pasarles el heroMoves()
	private void listenerMoved(Set<MoveListener> listeners){
		for(MoveListener listener: listeners){
			listener.heroMoves();
		}
	}
	
	public Set<MoveListener> getListeners(){
		return this.listeners;
	}
	
	public Point getHeroPosition(){
		return heroPosition;
	}
	
	public Cell get(int x, int y) {
		return g[y][x];
	}
	
	public Hero getHero() {
		return (Hero) g[heroPosition.y][heroPosition.x].getContent();
	}

	protected Cell[][] g(){
		return g;
	}
	
	// aca tengo que hacer el add listener
	
	protected abstract void setContents();

	protected abstract Point getHeroInitPosition();
	
	public abstract boolean gameOver();
	
	public abstract boolean playerWon();
	
	public abstract void reduceNumberOfEnemies();
}
