package PowerUp;

import java.awt.Image;
import javax.swing.ImageIcon;
import Entity.Player;
import Main.Game;

public class PowerUpPotion extends PowerUp {

	public PowerUpPotion(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/PowerUp/pw_potion.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}

	@Override
	public void addPowerUp(Player player) {
		super.addPowerUp(player);
		player.setPotion();
		game.addDeadEntity(this);
	}

}
