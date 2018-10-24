package Weapon;

import java.awt.Point;
import Main.Game;
import Shot.PowerUp1Shot;
import Shot.Shot;
import Sound.SoundMananger;

public class WeaponFirstPowerUp extends Weapon {

	public WeaponFirstPowerUp(Game g) {
		super(g);
	}

	@Override
	public void shoot(Point pos) {
		Shot s1 = new PowerUp1Shot(pos.x + 5, pos.y, game);
		Shot s2 = new PowerUp1Shot(pos.x + 25, pos.y, game);
		game.addEntity(s1);
		game.addEntity(s2);
		new SoundMananger("laser.wav").playSound();
	}

}
