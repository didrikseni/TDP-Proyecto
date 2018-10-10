package Weapon;

import java.awt.Point;
import Main.Game;
import Shot.PowerUp1Shot;
import Shot.Shot;

public class WeaponFirstPowerUp extends Weapon {
	
	public WeaponFirstPowerUp(Game g) {
		super(g);
	}

	@Override
	public void shoot(Point pos) {
		Shot s1 = new PowerUp1Shot(pos.x, pos.y, -2, game);
		Shot s2 = new PowerUp1Shot(pos.x, pos.y, 2, game);
		game.addEntity(s1);
		game.addEntity(s2);
	}

}
