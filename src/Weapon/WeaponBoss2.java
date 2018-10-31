package Weapon;

import java.awt.Point;

import Main.Game;
import Shot.BossShot2;
import Shot.Shot;

public class WeaponBoss2 extends Weapon {
	private static int dy = -5;

	public WeaponBoss2(Game g) {
		super(g);
	}

	@Override
	public void shoot(Point pos) {
		Shot s1 = new BossShot2(pos.x + 50, pos.y, dy, game);
		Shot s2 = new BossShot2(pos.x + 50, pos.y, -dy, game);
		dy += 1;
		if (dy == 4 ) {
			dy = -dy;
		}
		game.addEntity(s1);
		game.addEntity(s2);
	}

}
