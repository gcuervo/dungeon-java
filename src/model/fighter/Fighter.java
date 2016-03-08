package model.fighter;

import model.board.Content;
import model.fighter.level.Level;

public interface Fighter extends Content {

	public boolean isAlive();
	
	public void injured(int value);
	
	public void heal(int value);
	
	public void healFull();

	public int getStrength();
	
	public void stronger(int value);
	
	public int getHealth();
	
	public int getMaxHealth();
	
	public Level getLevel();
	
	public boolean hasMaxLevel();
	
	public void addExperience(int value) ;
	
	public int getExperience();
	
	public int getMaxExperience();
}
