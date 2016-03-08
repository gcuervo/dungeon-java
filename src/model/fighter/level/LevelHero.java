package model.fighter.level;

public class LevelHero extends Level {
	private int SALUD = 10;
	private int FUERZA = 5;
	private int EXPERIENCIA = 5;
	
	public LevelHero() {
		super(1, 20);
	}
	@Override
	public int getMaxHealth() {
		return SALUD*getValue();
	}
	@Override
	public int getStrength() {
		return FUERZA*getValue();
	}
	@Override
	public int getMaxExperience() {
		return EXPERIENCIA*getValue();
	}
	
}
