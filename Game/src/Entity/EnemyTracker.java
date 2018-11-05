package Entity;

import java.awt.Image;

import javax.swing.ImageIcon;

import Main.Game;
import Visitor.Visitor;
import Weapon.Weapon;
import Weapon.WeaponEnemyTracker;

public class EnemyTracker extends Enemy {
	protected Weapon weapon;
	
	public EnemyTracker(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		this.life = 40;
		this.weapon = new WeaponEnemyTracker(game);
		this.rectangle.height = 40;
		this.rectangle.width = 20;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Ships/enemy_ship_04.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitEnemy(this);
	}
	
	@Override
	public void shoot() {
		weapon.shoot(this.getPos());
	}
	
}
