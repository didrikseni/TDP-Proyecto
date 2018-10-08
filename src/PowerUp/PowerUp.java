package PowerUp;

import Entity.Entity;
import Entity.Player;
import Main.GUI;
import Main.Game;
import Visitor.VisitorPowerUp;

public abstract class PowerUp extends Entity {
	
	protected PowerUp(int x, int y, Game g) {
		super(x, y, 2, g);
		visitor = new VisitorPowerUp(this);
	}
	
	public void update() {
		int gy = GUI.getInstance().getAlto();
		rectangle.y += speed;
		if(rectangle.y > (gy - height - 30)) {game.deadEntity(this); }
		this.updateGraphics();
	}

	public abstract void addPowerUp(Player player);
	
}
