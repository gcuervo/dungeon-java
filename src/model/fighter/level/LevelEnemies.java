package model.fighter.level;

public class LevelEnemies extends Level {
	public LevelEnemies(int level) {
		super(level, level); // level enemies no tiene maximo
	}
	@Override
	public int getMaxHealth() {
		return (int) Math.floor(Math.pow(getValue()+3, 2)-10);
	}
	@Override
	public int getStrength() {
		return (int) Math.floor((Math.pow(getValue(),2) + 5 * getValue() ) * 0.5); //falta multiplicarlo 
	}
	@Override
	public int getMaxExperience() {
		throw new EnemyHasNoExperienceException();
	}
}