package model.fighter;

import model.fighter.level.LevelEnemies;

public class Serpent extends FighterEnemy {
	private final double SALUD = 1;
	private final double FUERZA = 1;

	public Serpent(LevelEnemies aLevel) {
		super(aLevel);
		// TODO Auto-generated constructor stub
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
