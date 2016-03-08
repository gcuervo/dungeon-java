package model.board.level;

import java.awt.Point;

import model.board.Board;
import model.element.Armor;
import model.element.AttackBonus;
import model.element.HealthBonus;
import model.element.HealthPotion;
import model.element.Wall;
import model.fighter.Goblin;
import model.fighter.Golem;
import model.fighter.Serpent;
import model.fighter.level.LevelEnemies;

public class GameLevelX extends Board{
	private int enemies = 5;
	
	@Override
	protected void setContents() {
		get(1,6).setContent(addGoblin(1));
		get(6,2).setContent(addGoblin(1));
		
		get(7,7).setContent(new Serpent(new LevelEnemies(2)));
		get(1,3).setContent(new Golem(new LevelEnemies(3)));
		get(8,3).setContent(new Golem(new LevelEnemies(3)));
		get(1,10).setContent(new Serpent(new LevelEnemies(1)));
		get(0,1).setContent(new AttackBonus(4));
		get(0,2).setContent(new HealthBonus(3));
		get(0,3).setContent(new HealthPotion());
		get(0,0).setContent(new Armor());
		// ponemos las paredes 
		get(2,6).setContent(new Wall());
		get(3,6).setContent(new Wall());
		get(4,6).setContent(new Wall());
		get(5,6).setContent(new Wall());
		get(8,6).setContent(new Wall());
		get(9,6).setContent(new Wall());
		get(10,6).setContent(new Wall());
		get(11,6).setContent(new Wall());
		get(8,0).setContent(new Wall());
		get(8,1).setContent(new Wall());
		get(8,2).setContent(new Wall());
		get(8,4).setContent(new Wall());
		get(8,5).setContent(new Wall());
		get(8,8).setContent(new Wall());
		get(7,8).setContent(new Wall());
		get(7,9).setContent(new Wall());
		get(7,10).setContent(new Wall());
		get(7,11).setContent(new Wall());
		get(7,8).setContent(new Wall());
		get(7,8).setContent(new Wall());
		get(9,8).setContent(new Wall());
		get(10,8).setContent(new Wall());
		
	}
	
	public Goblin addGoblin(final int level){
		Goblin goblin = new Goblin(new LevelEnemies(level));
		getListeners().add(goblin);
		return goblin;
	}
	
	public void reduceNumberOfEnemies(){
		enemies--;
	}

	@Override
	protected Point getHeroInitPosition() {
		return new Point(3,2);
	}

	@Override
	public boolean gameOver() {
		return !getHero().isAlive() || playerWon();
	}

	@Override
	public boolean playerWon() {
		return enemies == 0;
	}
}
