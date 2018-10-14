package Shield;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entity.Player;

public class ShieldPowerUp2 extends Shield {

	public ShieldPowerUp2(Player player) {
		super(player);
		reduction = 6;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shields/shield_1.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	}

}
