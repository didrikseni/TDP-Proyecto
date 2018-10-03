package Weapon;

import java.awt.Point;
import Main.Game;
import Shot.PowerUp2Shot;
import Shot.Shot;

public class WeaponSecondPowerUp extends Weapon {
	
	public WeaponSecondPowerUp(Game g) {
		super(g);
	}

	@Override
	public void shoot(Point pos) {
		Shot s = new PowerUp2Shot(pos.x, pos.y, game);
		game.addEntity(s);
	}

}
