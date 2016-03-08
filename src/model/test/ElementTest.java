package model.test;

import model.element.Armor;
import model.element.AttackBonus;
import model.element.HealthBonus;
import model.element.HealthPotion;
import model.element.Sword;
import model.element.SwordHero;
import model.fighter.FighterEnemy;
import model.fighter.FighterHero;
import model.fighter.Goblin;
import model.fighter.Hero;
import model.fighter.level.LevelEnemies;

import org.junit.Assert;
import org.junit.Test;

public class ElementTest {

	@Test
	public void PotionTest() {
		Hero hero = new Hero(new FighterHero());
		HealthPotion potionH = new HealthPotion();
		FighterEnemy e = new Goblin(new LevelEnemies(1));

		while (e.isAlive()&& hero.isAlive()) {
			e.interact(hero);
		}
		Assert.assertFalse(hero.getMaxHealth() == hero.getHealth());
		potionH.interact(hero);
		Assert.assertTrue(hero.getMaxHealth() == hero.getHealth());

	}

	@Test
	public void HealthBonusTest() {

		int value = 3;
		Hero hero = new Hero(new FighterHero());
		HealthBonus healthB = new HealthBonus(value);
		FighterEnemy goblin = new Goblin(new LevelEnemies(2));
		int injValue = hero.getMaxHealth() - goblin.getStrength();
				
		Assert.assertTrue(healthB.getValue()==value);
		
		goblin.interact(hero);
		Assert.assertTrue(hero.getHealth() == injValue);
		healthB.interact(hero);
		Assert.assertTrue(hero.getHealth() == (injValue + healthB.getValue()));
		healthB.interact(hero);
		Assert.assertTrue(hero.getHealth() == hero.getMaxHealth());

	}

	@Test
	public void HealthPotionTest() {

		Hero hero = new Hero(new FighterHero());
		HealthPotion h = new HealthPotion();

		FighterEnemy e = new Goblin(new LevelEnemies(2));

		while (e.isAlive()&&hero.isAlive()) {
			e.interact(hero);
		}
		Assert.assertFalse(hero.getHealth() == hero.getMaxHealth());
		h.interact(hero);
		Assert.assertTrue(hero.getHealth() == hero.getMaxHealth());

	}

	@Test
	public void ArmorTest() {

		Hero hero = new Hero(new FighterHero());
		Armor a = new Armor();
		FighterEnemy e = new Goblin(new LevelEnemies(3));

		e.interact(hero);
		
		Assert.assertTrue(hero.getHealth() == 2);

		Hero aH= (Hero)a.interact(new Hero(new FighterHero()));
		e.interact(aH);
		
		Assert.assertTrue(aH.getHealth() == 5);
	}

	@Test
	public void SwordTest() {
		Hero hero = new Hero(new FighterHero());
		FighterEnemy goblin = new Goblin(new LevelEnemies(3));
		Sword s = new Sword(5);
		int healthG;
		while (hero.isAlive()&& goblin.isAlive()) {
			goblin.interact(hero);
		}
		Assert.assertFalse(hero.isAlive());
		healthG = goblin.getHealth();
		
		Hero sH = (Hero)s.interact(new Hero(new FighterHero()));
		Assert.assertTrue(sH instanceof SwordHero);

		goblin.interact(sH);
		Assert.assertTrue(goblin.getHealth()== (healthG-sH.getLevel().getStrength()- s.getValue()));
	
	}

	@Test
	public void AttackBonusTest(){
		AttackBonus aB = new AttackBonus(6);
		Hero hero = new Hero(new FighterHero());
		Goblin goblin = new Goblin(new LevelEnemies(2));
		
		aB.interact(hero);
		goblin.interact(hero);
		
		Assert.assertTrue((goblin.getMaxHealth()-goblin.getHealth()) == (hero.getLevel().getStrength()+aB.getValue()));
	
		
	}
}
