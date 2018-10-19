package Shield;

import javax.swing.Icon;
import javax.swing.JLabel;
import Entity.Player;

public abstract class Shield {
	protected Player player;
	protected int reduction, width, height;
	protected Icon icon;
	protected JLabel shieldGraphics;

	public Shield(Player player) {
		this.player = player;
		reduction = 0;
		height = width = 60;
	}

	public Icon getIcon() {
		return icon;
	}

	public int takeDamage(int damage) {
		return (damage - reduction >= 0) ? damage - reduction : 0;
	}	

	public void update() {
		if (this.shieldGraphics != null) {
			this.shieldGraphics.setBounds(player.getRectangle().x - 10, player.getRectangle().y - 10 , width, height);
		}
	}

	public JLabel getGraphics() {
		return shieldGraphics;
	}
}
