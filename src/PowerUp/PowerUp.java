package PowerUp;

import Entity.Entity;
import Entity.Player;
import Game.Game;
import Main.GUI;
import Visitor.VisitorPowerUp;

public abstract class PowerUp extends Entity {
	
	protected PowerUp(int x, int y, Game g) {
		super(x, y, 5, g);
		visitor = new VisitorPowerUp(this);
	}
	
	public void update() {
		int gy = GUI.getInstance().getAlto();
		pos.y += speed;
		if(pos.y > (gy - height - 30)) {game.imDead(this); }
		this.updateGraphics();
	}

	public abstract void addPowerUp(Player player);
	
}
