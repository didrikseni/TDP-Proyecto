package PowerUp;

import java.awt.Image;
import javax.swing.ImageIcon;
import Entity.Player;
import Main.Game;
import Shot.SuperMissile;

public class PowerUpMissile extends PowerUp {
	
	public PowerUpMissile(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/PowerUp/missile.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}
	
	@Override
	public void addPowerUp(Player player) {
		super.addPowerUp(player);
		this.game.addEntity(new SuperMissile(player.getRectangle().x, player.getRectangle().y, game));
		game.addDeadEntity(this);
	}
	
}
