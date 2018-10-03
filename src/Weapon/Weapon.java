package Weapon;

import java.awt.Point;
import Main.Game;

public abstract class Weapon {
	protected Game game;
	
	public Weapon(Game g) {
		game = g;
	}
	
	public abstract void shoot(Point pos);

}
