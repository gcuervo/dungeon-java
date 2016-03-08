package view;

import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import model.board.Cell;
import model.board.Content;
import model.element.Armor;
import model.element.ArmorHero;
import model.element.AttackBonus;
import model.element.Blood;
import model.element.HealthBonus;
import model.element.HealthPotion;
import model.element.Sword;
import model.element.SwordHero;
import model.element.Wall;
import model.fighter.Fighter;
import model.fighter.Goblin;
import model.fighter.Golem;
import model.fighter.Hero;
import model.fighter.Serpent;

public class ImageManager {
	
	private Map<String, Image> images = new HashMap<String, Image>();
	
	public ImageManager() {
		initImages();
	}

	public void initImages() {
		try{
			images.put(Hero.class.getName(), ImageUtils.loadImage("resources/heroBase.png"));
			images.put(Cell.class.getName(), ImageUtils.loadImage("resources/floor.png"));
			images.put(Wall.class.getName(), ImageUtils.loadImage("resources/wall.png"));
			images.put(Goblin.class.getName(), ImageUtils.loadImage("resources/goblin.png"));
			images.put(Golem.class.getName(), ImageUtils.loadImage("resources/golem.png"));
			images.put(Serpent.class.getName(), ImageUtils.loadImage("resources/Serpent.png"));
			images.put(Armor.class.getName(), ImageUtils.loadImage("resources/armor.png"));
			images.put(Blood.class.getName(), ImageUtils.loadImage("resources/blood.png"));
			images.put(Sword.class.getName(), ImageUtils.loadImage("resources/sword.png"));
			images.put(Armor.class.getName(), ImageUtils.loadImage("resources/armor.png"));
			images.put(ArmorHero.class.getName(), ImageUtils.loadImage("resources/heroArmor.png"));
			images.put(HealthPotion.class.getName(), ImageUtils.loadImage("resources/healthPotion.png"));
			images.put(HealthBonus.class.getName(), ImageUtils.loadImage("resources/healthbonus.png"));
			images.put(HealthPotion.class.getName(), ImageUtils.loadImage("resources/healthPotion.png"));
			images.put(AttackBonus.class.getName(), ImageUtils.loadImage("resources/attackbonus.png"));
			images.put(SwordHero.class.getName(), ImageUtils.loadImage("resources/heroBase.png"));
			images.put("FOG", ImageUtils.loadImage("resources/fog.png"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Image get(Cell cell) {
		if (cell.hasContent()) {
			Content content = cell.getContent();
			if (content instanceof Fighter) {
				Fighter fighter = (Fighter) content;
				Image image = ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(fighter.getClass().getName()));
				return ImageUtils.drawString(image, String.valueOf(fighter.getLevel().getValue()), Color.YELLOW);
			} else {
				return ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(cell.getContent().getClass().getName()));
			}
		} else {
			return images.get(cell.getClass().getName());
		}
		
	}
	
	public Image get(String key) {
		return images.get(key);
	}
}
