package PowerUp;

import java.awt.Image;
import javax.swing.ImageIcon;
import Entity.Player;
import Main.Game;
import Weapon.WeaponSecondPowerUp;

public class PowerUpWeapon_2 extends PowerUp {

	public PowerUpWeapon_2(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/PowerUp/pw_weapon_01.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}

	@Override
	public void addPowerUp(Player player) {
		super.addPowerUp(player);
		player.setWeapon(new WeaponSecondPowerUp(game));
		game.addDeadEntity(this);
	}

}
