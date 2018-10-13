package PowerUp;

import Entity.Player;
import Main.Game;
import Visitor.Visitor;

public class PowerUpWeapon_2 extends PowerUp {

	protected PowerUpWeapon_2(int x, int y, Game g) {
		super(x, y, g);
	}

	@Override
	public void accept(Visitor v) {
		
	}

	@Override
	public void addPowerUp(Player player) {
		
	}

}
