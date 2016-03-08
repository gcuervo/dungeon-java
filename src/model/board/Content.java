package model.board;

import model.fighter.Fighter;

public interface Content {
	
	public boolean canWalkOver();
	
	public Content interact(Fighter hero);
	
}