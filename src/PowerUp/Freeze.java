package PowerUp;

import Entity.Player;
import Main.Game;
import Visitor.Visitor;

public class Freeze extends TemporalMagic {

	protected Freeze(int x, int y, Game g) {
		super(x, y, g);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);
	}

	@Override
	public void addPowerUp(Player player) {
		
	}

	@Override
	public void update() {}
	
	@Override
	public void run() {
	
	}

}
