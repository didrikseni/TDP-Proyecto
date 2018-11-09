package Entity;

import java.awt.Image;
import javax.swing.ImageIcon;
import Behaviour.KamikazeBehaviour;
import Main.Game;

public class EnemyKamikaze extends Enemy {
	private int damage;
	
	public EnemyKamikaze(int x, int y, int speed,  Game g) {
		super(x, y, speed, g);
		comportamiento = new KamikazeBehaviour();
		score = 150;
		damage = 80;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Ships/enemy_ship_03.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}



	@Override
	public void shoot() {}

	public int getDamage() {
		return damage;
	}
	
	@Override
	public void takeDamage(int damage) {
		super.takeDamage(damage);
		if (life < 50) {
			if (rnd.nextInt(100) < 30)
				comportamiento.changeBehaviour(this);
		}
	}
	
}
