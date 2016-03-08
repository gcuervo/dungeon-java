package model.element;

import model.fighter.Fighter;
import model.fighter.Hero;

public class SwordHero extends Hero {
	private Sword sword;

	public SwordHero(Fighter fighter, Sword sword) {
		super(fighter);
		this.sword = sword;
	}
	
	public int getStrength(){
		return sword.getValue()+super.getStrength();
	}
	
}
