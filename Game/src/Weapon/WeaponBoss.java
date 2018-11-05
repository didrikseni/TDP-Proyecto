package Weapon;

import java.awt.Point;
import Main.Game;
import Shot.BossShot;
import Shot.Shot;

public class WeaponBoss extends Weapon {

	public WeaponBoss(Game game) {
		super(game);
	}

	@Override
	public void shoot(Point pos) {
		Shot s1 = new BossShot(pos.x + 50, pos.y, true, game);
		Shot s2 = new BossShot(pos.x + 50, pos.y, false, game);
		game.addEntity(s1);
		game.addEntity(s2);
	}

}
