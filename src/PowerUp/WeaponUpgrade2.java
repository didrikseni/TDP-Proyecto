package PowerUp;

import Entity.Player;
import Game.Game;
import Visitor.Visitor;

public class WeaponUpgrade2 extends PowerUp {

	protected WeaponUpgrade2(int x, int y, Game g) {
		super(x, y, g);
	}

	@Override
	public void accept(Visitor v) {
		
	}

	@Override
	public void addPowerUp(Player player) {
		
	}

}
