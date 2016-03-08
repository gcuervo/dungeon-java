package model.test;

import static org.junit.Assert.*;


import model.board.Content;
import model.element.ArmorHero;
import model.element.Blood;
import model.element.Sword;
import model.fighter.FighterEnemy;
import model.fighter.FighterHero;
import model.fighter.Goblin;
import model.fighter.Golem;
import model.fighter.Hero;
import model.fighter.Serpent;
import model.fighter.level.LevelEnemies;

import org.junit.Assert;
import org.junit.Test;

public class FighterTest2 {
	@Test
	public void iniParamHero(){
		FighterHero f = new FighterHero();
		
		Assert.assertTrue(f.getLevel().getValue()==1);
		Assert.assertTrue(f.getHealth()==10);
		Assert.assertTrue(f.getStrength()==5);
		Assert.assertTrue(f.getMaxHealth()==10);
	}

	@Test
	public void testFight() {

		Hero f = new Hero(new FighterHero());
		FighterEnemy e = new Goblin(new LevelEnemies(1));
		FighterEnemy go = new Golem(new LevelEnemies(4));
		FighterEnemy se = new Serpent(new LevelEnemies(1));
			
		while (e.isAlive()&&f.isAlive()) {
			e.interact(f);
		}
		Assert.assertTrue(f.isAlive());
		Assert.assertFalse(e.isAlive());
		
		while (se.isAlive()&&f.isAlive()) {
			se.interact(f);
		}
		Assert.assertFalse(f.isAlive());
		Assert.assertTrue(se.isAlive());

		f.healFull();
		
		while (f.isAlive() && go.isAlive()) {
			go.interact(f);
		}

		Assert.assertFalse(f.isAlive());
		Assert.assertTrue(go.isAlive());

	}

	@Test
	public void golemTest(){
		ArmorHero armorH = new ArmorHero(new Hero(new FighterHero()));
		Golem golem = new Golem(new LevelEnemies(1));
		int injValue = golem.getMaxHealth() - armorH.getStrength(); 
		
		golem.injured(injValue);
		Assert.assertTrue(golem.getHealth() == (golem.getMaxHealth()-injValue));
		
		Content sword = golem.interact(armorH);
		Assert.assertTrue(sword instanceof  Sword);
		Assert.assertTrue(((Sword)sword).getValue() == golem.getLevel().getStrength());
		
	}
	
	@Test
	public void serptentDeath(){
		Hero hero = new Hero(new FighterHero());
		Serpent serpent = new Serpent(new LevelEnemies(1));
		int injValue = serpent.getMaxHealth() - hero.getStrength();
		
		serpent.injured(injValue);
		Assert.assertTrue(serpent.getHealth() == (serpent.getMaxHealth()-injValue));
		
		Content blood = serpent.interact(hero);
		Assert.assertTrue(blood instanceof  Blood);
		
		
	}
	

	
}
