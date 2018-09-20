package Shot;

import Entity.Entity;
import Game.Game;
import Visitor.Visitor;

public abstract class Shot extends Entity {
	//Attributes
	protected int damage;
	
	public Shot(int x, int y, Game g) {
		super(x, y, 20, g);
	}

	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {	
		this.damage = damage; 
	}
	
}
