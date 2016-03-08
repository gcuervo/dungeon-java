package model.fighter;

import model.board.Content;
import model.element.Blood;
import model.fighter.level.Level;
import model.fighter.level.LevelEnemies;

public abstract class FighterEnemy implements Fighter {
	private int health;
	private int strength;
	private LevelEnemies level;
	
	public FighterEnemy (LevelEnemies aLevel) {
		level = aLevel;
		strength = level.getStrength();
		health = getMaxHealth();
	}
	@Override
	public boolean canWalkOver() {
		return false;
	}
	@Override
	public Content interact(Fighter hero) {
		hero.injured(getStrength());
		if(hero.isAlive()){
			injured(hero.getStrength());
			if(!isAlive()){
				hero.addExperience(this.getLevel().getValue());
				return changeFor();
			}
		}
		return this;
	}

	//el método se ocupa de devolver el tipo de contenido que debe reemplazar a la instancia cuando esta "desaparece"
	protected Content changeFor(){
		return new Blood();
	}
	
	@Override
	public boolean isAlive() {
		return health != 0;
	}
	@Override
	public void injured(int value) {
		if ((health-=value)<0){
			health = 0;
		}
	}
	
	//este método es necesario para los Goblin, en los otros dos está reecrito y anulado.
	@Override
	public void heal(int value) {
		if((health += value) > getMaxHealth()){
			health = getMaxHealth();
		}
	}
	@Override
	public void healFull() {
		// falta la expecion
	}
	@Override
	public int getStrength() {
		return strength;
	}
	@Override
	public void stronger(int value) {
		if ((strength += value) > level.getStrength()){
			strength = level.getStrength();
		}	
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
		return true;
	}
	@Override
	public void addExperience(int value) {
	}
	@Override
	public int getExperience() {
		return 0;
	}
	@Override
	public int getMaxExperience() {
		return 0;
	}
}
