package Shield;

import java.awt.Image;
import javax.swing.ImageIcon;

import Entity.Player;

public class ShieldPowerUp extends Shield {
	
	public ShieldPowerUp(Player player) {
		super(player);
		reduction = 4;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shields/shield_0.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(player.getWidth(), player.getHeight(), Image.SCALE_DEFAULT));
	}

}
