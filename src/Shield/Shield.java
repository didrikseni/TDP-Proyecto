package Shield;

import javax.swing.Icon;
import Entity.Player;

public abstract class Shield {
	protected Player player;
	protected int reduction;
	protected Icon icon;
	
	public Shield(Player player) {
		this.player = player;
		reduction = 0;
	}
	
	public int takeDamage(int damage) {
		return (damage - reduction >= 0) ? damage - reduction : 0;
	}
	
	public abstract Icon getIcon();
}
