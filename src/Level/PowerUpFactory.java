package Level;

import Main.Game;
import PowerUp.PowerUp;

public interface PowerUpFactory {

	public PowerUp getPowerUp(int x, int y, Game game);
	
}
