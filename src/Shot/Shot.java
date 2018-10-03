package Shot;

import Entity.Entity;
import Main.Game;

public abstract class Shot extends Entity {
	//Attributes
	protected int damage;
	
	public Shot(int x, int y, Game g) {
		super(x, y, 4, g);
	}

	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {	
		this.damage = damage; 
	}
	
}
