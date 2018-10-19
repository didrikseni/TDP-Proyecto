package PowerUp;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entity.Player;
import Main.Game;
import Visitor.Visitor;

public class PowerUpShieldInvunerable extends PowerUp {

	public PowerUpShieldInvunerable(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/PowerUp/pw_shield_02.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void addPowerUp(Player player) {
		ThreadShieldInvunerable invunerable = new ThreadShieldInvunerable(player);
		Thread thread = new Thread(invunerable);
		thread.start();
		game.addDeadEntity(this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);
	}

}
