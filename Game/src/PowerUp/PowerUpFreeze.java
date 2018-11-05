package PowerUp;

import java.awt.Image;
import javax.swing.ImageIcon;
import Entity.Player;
import Main.Game;
import Visitor.Visitor;

public class PowerUpFreeze extends PowerUp {
	public static PowerUpFreeze INSTANCE = null;
	
	private PowerUpFreeze(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/PowerUp/pw_freeze.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}
	
	public static PowerUpFreeze getInstance(int x, int y, Game g) {
		if (INSTANCE == null) {
			INSTANCE = new PowerUpFreeze(x,y,g);
		}
		return new PowerUpFreeze(x,y,g);
	}
	
	public static boolean hasInstance() {
		return INSTANCE != null;
	}
	
	public static void setInstanceNull() {
		INSTANCE = null;
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);
	}

	@Override
	public void addPowerUp(Player player) {
		ThreadFreeze threadFreeze = new ThreadFreeze(game);
		game.addDeadEntity(this);
		Thread thread = new Thread(threadFreeze);
		thread.start();
	}
}
