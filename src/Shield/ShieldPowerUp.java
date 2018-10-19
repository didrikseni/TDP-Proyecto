package Shield;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entity.Player;

public class ShieldPowerUp extends Shield {
	
	public ShieldPowerUp(Player player) {
		super(player);
		reduction = 4;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shields/shield_0.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width + 5, height, Image.SCALE_DEFAULT));
		this.shieldGraphics = new JLabel(icon);
	}

}
