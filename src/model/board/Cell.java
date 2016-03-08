package model.board;

import model.fighter.Fighter;

public class Cell {
	
	private Content content;
	private boolean hasFog;
	
	public Cell() {
		this.hasFog = true;
	}
	
	public void removeFog() {
		if (hasFog) {
			hasFog = false;
		}
	}
	
	public boolean hasFog() {
		return hasFog;
	}

	public void setContent(Content c) {
		this.content = c;
	}
	
	public boolean hasContent() {
		return content != null;
	}
	
	public Content getContent() {
		return content;
	}
	
	public Content removeContent() {
		Content aux = this.content;
		this.content = null;
		return aux;
	}
	
	public boolean canWalkOver() {
		return content == null || content.canWalkOver();
	}
	
	public void onWalk(Fighter hero){
		if (content != null) {
			content = content.interact(hero);
		} else {
			content = hero;
		}
	}
	
	public boolean canInteract() {
		return content != null;
	}
	
	public void interact(Fighter hero) {
		content = content.interact(hero);
	}
}
