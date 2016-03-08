package model.element;

import model.board.Content;
import model.fighter.Fighter;

public class AttackBonus extends ValuableElements {

	public AttackBonus(int aValue) {
		super(aValue);
	}
	
	@Override
	public Content interact(Fighter hero){
		hero.stronger(getValue());
		return hero;
	}
}
