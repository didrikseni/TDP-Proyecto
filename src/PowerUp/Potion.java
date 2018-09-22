package PowerUp;

import Entity.Player;
import Game.Game;
import Visitor.Visitor;

public class Potion extends PowerUp {

	protected Potion(int x, int y, Game g) {
		super(x, y, g);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPowerUp(Player player) {
		player.setPotion();
	}

}
