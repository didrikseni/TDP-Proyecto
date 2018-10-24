package Weapon;

import java.awt.Point;
import Main.Game;
import Shot.EnemyShot;
import Shot.Shot;
import Sound.SoundMananger;

public class WeaponEnemy extends Weapon {

	public WeaponEnemy(Game g) {
		super(g);
	}

	@Override
	public void shoot(Point pos) {
		Shot s = new EnemyShot(pos.x + 15, pos.y, game);
		//Shot s = new TrackerShot(pos.x + 15, pos.y, game, Player.getInstance(0, 0, game));
		game.addEntity(s);
		new SoundMananger("laser.wav").playSound();
	}

}
