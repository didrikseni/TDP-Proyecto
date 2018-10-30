package PowerUp;

import java.awt.Image;
import javax.swing.ImageIcon;
import Entity.Player;
import Main.Game;
import Visitor.Visitor;
import Weapon.WeaponFirstPowerUp;

public class PowerUpWeapon_1 extends PowerUp {

	public PowerUpWeapon_1(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/PowerUp/pw_weapon_00.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);
	}

	@Override
	public void addPowerUp(Player player) {
		player.setWeapon(new WeaponFirstPowerUp(game));
		game.addDeadEntity(this);
		
	}

}
