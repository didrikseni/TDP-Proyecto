package Level;

import Main.Game;
import PowerUp.PowerUp;
import PowerUp.PowerUpFreeze;
import PowerUp.PowerUpMissile;
import PowerUp.PowerUpPotion;
import PowerUp.PowerUpShield;
import PowerUp.PowerUpShield_2;
import PowerUp.PowerUpShieldInvunerable;
import PowerUp.PowerUpWeapon_1;
import PowerUp.PowerUpWeapon_2;

public class FactoryPowerUp implements PowerUpFactory {
	
	@Override
	public PowerUp getPotion(int x, int y, Game game) {
		return new PowerUpPotion(x,y,game);
	}

	@Override
	public PowerUp getFreeze(int x, int y, Game game) {
		if (PowerUpFreeze.hasInstance()) 
			return null;
		return PowerUpFreeze.getInstance(x, y, game);
	}

	@Override
	public PowerUp getShield(int x, int y, Game game) {
		return new PowerUpShield(x,y,game);
	}

	@Override
	public PowerUp getShield2(int x, int y, Game game) {
		return new PowerUpShield_2(x, y, game);
	}

	@Override
	public PowerUp getShieldInvunerable(int x, int y, Game game) {
		return PowerUpShieldInvunerable.getInstance(x, y, game);
	}

	@Override
	public PowerUp getWeapon(int x, int y, Game game) {
		return new PowerUpWeapon_1(x, y, game);
	}

	@Override
	public PowerUp getWeapon2(int x, int y, Game game) {
		return new PowerUpWeapon_2(x, y, game);
	}

	@Override
	public PowerUp getMissile(int x, int y, Game game) {
		return new PowerUpMissile(x, y, game);
	}
	
}
