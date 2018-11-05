package Weapon;

import java.awt.Point;
import Main.Game;
import Shot.PowerUp2Shot;
import Shot.Shot;
import Sound.SoundMananger;

public class WeaponSecondPowerUp extends Weapon {
	
	public WeaponSecondPowerUp(Game g) {
		super(g);
	}

	@Override
	public void shoot(Point pos) {
		Shot s1 = new PowerUp2Shot(pos.x + 15, pos.y, true, game);
		Shot s2 = new PowerUp2Shot(pos.x + 15, pos.y, false, game);
		game.addEntity(s1);
		game.addEntity(s2);
		new SoundMananger("laser.wav").playSound();
	}

}
