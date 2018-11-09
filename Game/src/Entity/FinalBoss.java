package Entity;

import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import Behaviour.BossBehaviour;
import Main.Game;
import Weapon.Weapon;
import Weapon.WeaponBoss;
import Weapon.WeaponBoss2;

public class FinalBoss extends Enemy {
	private Weapon weapon;

	public FinalBoss(int x, int y, Game game) {
		super(x, y, 0, game);
		this.rectangle.width = this.rectangle.height = 200;
		comportamiento = new BossBehaviour(game);
		life = 1500;
		weapon = new WeaponBoss(game);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Ships/bossShip.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));	
	}

	@Override
	public void update() {
		super.update();
		if (life < 500) {
			weapon = new WeaponBoss2(game);
		}
	}
	
	@Override
	public void shoot() {
		weapon.shoot(new Point(rectangle.x, rectangle.y + rectangle.height / 2));
	}

}
