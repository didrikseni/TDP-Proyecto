package Weapon;

import java.awt.Point;
import Main.Game;
import Shot.EnemyShot;
import Shot.Shot;

public class WeaponEnemy extends Weapon {

	public WeaponEnemy(Game g) {
		super(g);
	}

	@Override
	public void shoot(Point pos) {
		Shot s = new EnemyShot(pos.x + 15, pos.y, game);
		game.addEntity(s);
	}

}
