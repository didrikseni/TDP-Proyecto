package Level;

import Main.Game;
import PowerUp.PowerUp;

public interface PowerUpFactory {

	public PowerUp getPotion(int x, int y, Game game);
	public PowerUp getFreeze(int x, int y, Game game);
	public PowerUp getShield(int x, int y, Game game);
	public PowerUp getShield2(int x, int y, Game game);
	public PowerUp getShieldInvunerable(int x, int y, Game game);
	public PowerUp getWeapon(int x, int y, Game game);
	public PowerUp getWeapon2(int x, int y, Game game);
	public PowerUp getMissile(int x, int y, Game game);
	
}
