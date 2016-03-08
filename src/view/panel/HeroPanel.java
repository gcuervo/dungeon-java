package view.panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JProgressBar;

import model.fighter.Hero;
import view.ImageManager;

public class HeroPanel extends FighterPanel {
	private static final long serialVersionUID = 1L;

	private JProgressBar experienceBar;
	
	public HeroPanel(Color color, Hero hero, ImageManager imgManager) {
		super(color, hero, imgManager);
		
		experienceBar = new JProgressBar(0, hero.getMaxExperience());
		experienceBar.setForeground(Color.GREEN);
		experienceBar.setBounds(80,108,100,15);
		experienceBar.setStringPainted(true);
		experienceBar.setValue(hero.getExperience());
		this.add(experienceBar);
	}
	
	@Override
	public void refreshData() {
		super.refreshData();
		Hero hero = (Hero) getFighter();
		experienceBar.setMaximum(hero.getMaxExperience());
		experienceBar.setValue(hero.getExperience());
		experienceBar.setString(hero.getExperience() + "/" + hero.getMaxExperience());
		experienceBar.setVisible(!hero.hasMaxLevel());
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (!getFighter().hasMaxLevel()) {
			g.drawString("Experience: ", 10, 120);
		}
	}
	
}