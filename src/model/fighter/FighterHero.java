package model.fighter;

import model.fighter.level.Level;
import model.fighter.level.LevelHero;
import model.board.Content;

public class FighterHero implements Fighter {
	private int health;
	private int strength;
	private Level level; 
	private int experience;
	
	public FighterHero(int health, int strength, Level level2, int experience){
		this.health = health;
		this.strength = strength;
		this.level = level2;
		this.experience = experience;
	}
	
	public FighterHero(){
		level = new LevelHero();
		health = getMaxHealth();
		strength = level.getStrength();
	}
	
	@Override
	public boolean canWalkOver() {
		return false;
	}

	@Override
	public boolean isAlive() {
		return health != 0;
	}
	@Override
	public void injured(final int value) {
		if ((health -= value) <= 0) {
			health = 0;
		}
	}
	@Override
	public void heal(final int value) {
		if ((health += value) > level.getMaxHealth()) {
			health = level.getMaxHealth();
		}
	}
	@Override
	public void healFull() {
		health = level.getMaxHealth();		
	}
	@Override
	public int getStrength() {
		return strength;
	}
	@Override
	public void stronger(int value) {
		strength += value;
	}
	@Override
	public int getHealth() {
		return health;
	}
	
	@Override
	public int getMaxHealth() {
		return level.getMaxHealth();
	}
	@Override
	public Level getLevel() {
		return level;
	}
	@Override
	public boolean hasMaxLevel() { 
		return getLevel().getValue() == getLevel().getMaxLevel();
	}
	@Override
	public void addExperience(int value) {
		if ((experience += value) >= getMaxExperience()) {
			int additional = experience % getMaxExperience(); 
			level.levelUp();
			health = getMaxHealth();
			setStrenght(level.getStrength());
			experience = 0;
			if (additional != 0) {
				experience = additional;
			}
		}
	}
	@Override
	public int getExperience() {
		return experience;
	}
	
	public void setStrenght(int str){
		strength = str;
	}
	
	@Override
	public int getMaxExperience() {
		return level.getMaxExperience();
	}
	
	
	@Override
	public Content interact(Fighter hero) {
		return null;
	}
}
