package Shield;

import Entity.Player;

public class Shield {
	protected Player player;
	protected int reduction;
	
	public Shield() {
		player = Player.getInstance();
		reduction = 0;
	}
	
	public int takeDamage(int damage) {
		return (damage - reduction >= 0) ? damage - reduction : 0;
	}
}
