package model.fighter;

import model.board.Content;
import model.element.Sword;
import model.fighter.level.LevelEnemies;

public class Golem extends FighterEnemy implements Content {
	private final double SALUD = 1.35; 
	private final double FUERZA = 1;
	
	public Golem(LevelEnemies aLevel) {
		super(aLevel);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Content changeFor() {
		return new Sword(this.getStrength());
	}
	
	@Override
	public int getStrength() {
		return (int) Math.floor(super.getStrength()*FUERZA);
	}
	@Override
	public int getMaxHealth() {
		return (int)Math.floor(super.getMaxHealth()*SALUD);
	}
	@Override
	public void heal(int value) {
		//exception
	}
}
