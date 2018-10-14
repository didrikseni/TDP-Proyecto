package PowerUp;

import java.awt.Image;
import javax.swing.ImageIcon;
import Entity.Player;
import Main.Game;
import Shield.Shield;
import Shield.ShieldPowerUp2;
import Visitor.Visitor;

public class PowerUpShield2  extends PowerUp {

	public PowerUpShield2(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/PowerUp/pw_shield_01.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void addPowerUp(Player player) {
		Shield s = new ShieldPowerUp2(player);
		player.setSield(s);
		game.addDeadEntity(this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);
	}

}
