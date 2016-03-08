package model.element;

import model.board.Content;
import model.fighter.Fighter;

public class Wall implements Content{

	@Override
	public boolean canWalkOver() {
		return false;
	}

	@Override
	public Content interact(Fighter hero) {
		return this;
	}
}
