package Level;

import java.util.Random;
import Main.Game;
import PowerUp.PowerUp;
import PowerUp.PowerUpFreeze;
import PowerUp.PowerUpMissile;
import PowerUp.PowerUpPotion;
import PowerUp.PowerUpShield;
import PowerUp.PowerUpShield2;
import PowerUp.PowerUpShieldInvunerable;
import PowerUp.PowerUpWeapon_1;
import PowerUp.PowerUpWeapon_2;

public class ConcretePowerUpFactory implements PowerUpFactory {
	private Random rnd;

	public ConcretePowerUpFactory() {
		rnd = new Random();
	}

	@Override
	public PowerUp getPowerUp(int x, int y, Game game) {
		int i = rnd.nextInt(100);
		PowerUp powerUp = null;
		if (i < 20) {
			powerUp = new PowerUpWeapon_1(x, y, game);
		} else if (i < 40) {
			powerUp = new PowerUpWeapon_2(x, y, game);
		} else if (i < 60) {
			powerUp = new PowerUpPotion(x, y, game);
		} else if (i < 80) {
			powerUp = new PowerUpShield(x, y, game);
		} else if (i < 97) {
			powerUp = new PowerUpShield2(x, y, game);
		} else if (i < 98) {
			powerUp = new PowerUpMissile(x, y, game);
		} else if (i < 99) {
			powerUp = PowerUpShieldInvunerable.getInstance(x, y, game);
		} else if (i < 100 && !PowerUpFreeze.hasInstance()) {
			powerUp = PowerUpFreeze.getInstance(x, y, game);
		}
		return powerUp;
	}
	
}
