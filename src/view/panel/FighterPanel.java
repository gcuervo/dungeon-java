package view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import model.fighter.Fighter;
import view.ImageManager;

public class FighterPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Fighter fighter;
	private JProgressBar healthBar;
	private ImageManager imgManager;
	
	
	public FighterPanel(Color color, Fighter fighter, ImageManager imgManager){
		setBackground(color);
		this.setPreferredSize(new Dimension(200, 150));
		this.fighter = fighter;
		this.imgManager = imgManager;
		setLayout(null);
		healthBar = new JProgressBar(0, fighter.getMaxHealth());
		healthBar.setForeground(Color.RED);
		healthBar.setBounds(80,48,100,15);
		healthBar.setStringPainted(true);
		healthBar.setValue(fighter.getHealth());
		this.add(healthBar);
		this.setVisible(false);
	}
	
	public void refreshData() {
		healthBar.setMaximum(fighter.getMaxHealth());
		healthBar.setValue(fighter.getHealth());
		
		healthBar.setString(fighter.getHealth() + "/" + fighter.getMaxHealth());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		final int fontSize=13;
		Font plain=new Font("Arial", Font.PLAIN, fontSize);
		g.setFont(plain);
		g.drawImage(imgManager.get(fighter.getClass().getName()), 10, 5, null);
		g.drawString("Health: ", 10, 60);
		g.drawString("Strengh: " + fighter.getStrength(), 10, 80);
		g.drawString("Level: " + fighter.getLevel().getValue(), 10, 100);
		
	}
	
	protected Fighter getFighter() {
		return fighter;
	}
	
	public void setFighter(Fighter fighter) {
		this.fighter = fighter;
	}

}
