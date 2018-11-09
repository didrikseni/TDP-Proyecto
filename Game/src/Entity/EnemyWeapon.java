package Entity;

import java.awt.Image;
import javax.swing.ImageIcon;
import Main.Game;
import Weapon.Weapon;
import Weapon.WeaponEnemy;

public class EnemyWeapon extends Enemy {	
	protected Weapon weapon;
	
	public EnemyWeapon(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		weapon = new WeaponEnemy(g);
		score = 100;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Ships/enemy_ship_02.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}	
	
	@Override
	public void shoot() {
		weapon.shoot(this.getPos());
	}
	
	@Override
	public void takeDamage(int damage) {
		super.takeDamage(damage);
		if (life < 20) {
			if (rnd.nextInt(100) < 35) 
				comportamiento.changeBehaviour(this);
		}
	}
	
}
