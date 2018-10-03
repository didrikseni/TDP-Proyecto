package PowerUp;

import Entity.Player;
import Main.Game;
import Visitor.Visitor;

public class ProtectionField extends PowerUp {

	protected ProtectionField(int x, int y, Game g) {
		super(x, y, g);
	}

	@Override
	public void accept(Visitor v) {
		
	}

	@Override
	public void addPowerUp(Player player) {
		
	}

}
