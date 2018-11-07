package Weapon;

import java.awt.Point;
import Entity.Player;
import Main.Game;
import Shot.Shot;
import Shot.TrackerShot;

public class WeaponEnemyTracker extends Weapon {

	public WeaponEnemyTracker(Game g) {
		super(g);
	}

	@Override
	public void shoot(Point pos) {
		Shot s = new TrackerShot(pos.x + 15, pos.y, game, Player.getInstance(0, 0, game));
		game.addEntity(s);
	}

}
