package Shot;

import Entity.Entity;
import Main.Game;

public abstract class Shot extends Entity {
	protected int damage;
	
	public Shot(int x, int y, Game g) {
		super(x, y, 4, g);
		rectangle.height = height = 30; 
		rectangle.width = width = 10;
	}

	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {	
		this.damage = damage; 
	}
	
}
