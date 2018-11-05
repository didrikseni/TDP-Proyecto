package PowerUp;

import java.awt.Image;
import javax.swing.ImageIcon;
import Entity.Player;
import Main.Game;
import Visitor.Visitor;

public class PowerUpShieldInvunerable extends PowerUp {
	private static PowerUpShieldInvunerable INSTANCE = null;
	
	private PowerUpShieldInvunerable(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/PowerUp/pw_shield_02.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}
	
	public static synchronized PowerUpShieldInvunerable getInstance(int x, int y, Game game) {
		if (INSTANCE == null) {
			INSTANCE = new PowerUpShieldInvunerable(x,y,game);
		}
		return INSTANCE;
	}

	@Override
	public void addPowerUp(Player player) {
		ThreadInvunerable invunerable = new ThreadInvunerable(player);
		Thread thread = new Thread(invunerable);
		thread.start();
		game.addDeadEntity(this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);
	}

}
