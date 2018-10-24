package Entity;

import java.awt.Image;
import javax.swing.ImageIcon;
import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorEnemy;
import Weapon.Weapon;
import Weapon.WeaponEnemy;

public class EnemyWeapon extends Enemy {	
	private Weapon weapon;
	
	public EnemyWeapon(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		weapon = new WeaponEnemy(g);
		visitor = new VisitorEnemy(this);
		score = 100;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/enemy_ship_00.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitEnemy(this);
	}
/*
	@Override
	public void takeDamage(int damage) {
		super.takeDamage(damage);
		if (life <= 20) {
			this.comportamiento = new KamikazeBehaviour();
		}
	}
	*/
	@Override
	public void shoot() {
		weapon.shoot(this.getPos());
	}
}
