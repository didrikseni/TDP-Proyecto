package PowerUp;

import Entity.Entity;
import Entity.Player;
import GUI.GUI_Game;
import Main.Game;
import Visitor.VisitorPowerUp;

public abstract class PowerUp extends Entity {
	
	protected PowerUp(int x, int y, Game g) {
		super(x, y, 2, g);
		visitor = new VisitorPowerUp(this);
	}
	
	public void update() {
		int gy = GUI_Game.getInstance().getHeight();
		rectangle.y += speed;
		if(rectangle.y > (gy - rectangle.height - 30)) {game.addDeadEntity(this); }
		this.updateGraphics();
	}

	public abstract void addPowerUp(Player player);
	
}
