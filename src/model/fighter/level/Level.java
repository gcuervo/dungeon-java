package model.fighter.level;

public abstract class Level {
	
	private int value;
	private int maxLevel;
	
	public Level(int value, int maxLevel) {
		this.value = value;
		this.maxLevel = maxLevel;
	}
	
	public int getValue() {
		return value;
	}
	
	public void levelUp() {
		this.value++;
	}
	
	public int getMaxLevel() {
		return maxLevel;
	}
	
	public abstract int getMaxHealth();

	public abstract int getStrength();
	
	public abstract int getMaxExperience();
}
