package model.element;

import model.board.Content;
import model.fighter.Fighter;

public class HealthPotion implements Content {
	
	//me pareció mejor que esta clase no fuese un ValuableElement porque no tiene un valor definido,
	//depende del nivel en el que se encuentre el heroe. pero no estoy del todo segura
	
	public HealthPotion() {
	}

	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		hero.healFull();
		return hero;
	}

}
