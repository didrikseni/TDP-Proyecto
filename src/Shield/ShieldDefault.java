package Shield;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import Entity.Player;

public class ShieldDefault extends Shield {
	
	public ShieldDefault(Player player) {
		super(player);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shields/shield_3.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	}

	@Override
	public Icon getIcon() {
		return icon;
	}
	
}
