package PowerUp;

import java.awt.Image;
import javax.swing.ImageIcon;
import Entity.Player;
import Main.Game;
import Visitor.Visitor;

public class PowerUpFreeze extends TemporalMagic {
	public PowerUpFreeze(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/PowerUp/icon_57.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);
	}

	@Override
	public void addPowerUp(Player player) {
		ThreadFreeze threadFreeze = ThreadFreeze.getInstance(game);
		game.addDeadEntity(this);
		Thread thread = new Thread(threadFreeze);
		thread.start();
	}
}
