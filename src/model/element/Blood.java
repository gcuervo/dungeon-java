package model.element;

import model.board.Content;
import model.fighter.Fighter;

public class Blood implements Content {

	public Blood() {
	}

	@Override
	public boolean canWalkOver() {
		return true;
	}
	//Hay que ver si tiene que devolver null o floor, dependiendo de que decidamos para cuando no tiene más contenido
	@Override
	public Content interact(Fighter hero) {
		return hero;
	}
}
