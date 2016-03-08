package view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.board.Content;
import model.element.Valuable;
import view.ImageManager;

public class ElementPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ImageManager imgManager;
	private Content content;
	
	
	public ElementPanel(Color color, Content content, ImageManager imgManager){
		setBackground(color);
		this.setPreferredSize(new Dimension(200, 150));
		this.content = content;
		this.imgManager = imgManager;
		setLayout(null);
		this.setVisible(false);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		final int fontSize=13;
		Font plain=new Font("Arial", Font.PLAIN, fontSize);
		g.setFont(plain);
		g.drawImage(imgManager.get(content.getClass().getName()), 10, 5, null);
		if (content instanceof Valuable) {
			g.drawString("Value: " + ((Valuable)content).getValue(), 10, 60);
		}
		
	}

	public Content getContent() {
		return content;
	}
	
	public void setContent(Content content) {
		this.content = content;
	}

}
