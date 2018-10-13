package PowerUp;

import java.awt.Image;
import javax.swing.ImageIcon;
import Entity.Player;
import Main.Game;
import Shield.ShieldPowerUp;
import Visitor.Visitor;

public class PowerUpShield extends PowerUp {

	public PowerUpShield(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/PowerUp/icon_10.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);
	}

	@Override
	public void addPowerUp(Player player) {
		player.setSield(new ShieldPowerUp(Player.getInstance(0, 0, null)));
		game.deadEntity(this);
	}

}
