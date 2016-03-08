package model.element;

import model.board.Content;
import model.fighter.Fighter;

public class HealthBonus extends ValuableElements {

	public HealthBonus(int aValue) {
		super(aValue);
	}
	@Override
	public Content interact(Fighter hero){
		hero.heal(super.getValue());
		return hero;
	}
}
