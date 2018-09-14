package Shot;

import Entity.Entity;
import Game.Game;

public class Shot extends Entity {
	//Attributes
	protected int damage;
	
	public Shot(int x, int y, Game g) {
		super(x, y, 20, g);
	}
	
}
