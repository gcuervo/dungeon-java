package model.element;

import model.board.Content;
import model.fighter.Fighter;

public abstract class ValuableElements implements Valuable {
	private int value;
	
	public ValuableElements(int aValue) {
		value = aValue;
	}

	@Override
	public boolean canWalkOver() {
		// TODO Auto-generated method stub
		return true;
	}

	//pensar como si queda o se va
	@Override
	public Content interact(Fighter hero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
public int getValue() {
		return value;
	}

}
