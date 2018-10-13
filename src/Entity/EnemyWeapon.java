package Entity;

import java.awt.Image;

import javax.swing.ImageIcon;

import Main.Game;
import PowerUp.PowerUpFreeze;
import PowerUp.PowerUpPotion;
import PowerUp.PowerUpShield;
import PowerUp.PowerUp;
import PowerUp.PowerUpWeapon_1;
import PowerUp.ThreadFreeze;
import Shot.EnemyShot;
import Shot.Shot;
import Visitor.Visitor;
import Visitor.VisitorEnemy;

public class EnemyWeapon extends Enemy {	
	
	public EnemyWeapon(int x, int y, int speed, Game g) {
		super(x, y, speed, g);		
		visitor = new VisitorEnemy(this);
		score = 100;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/XWingAbajo.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitEnemy(this);
	}

	@Override
	public void shoot() {
		Shot shot = new EnemyShot(rectangle.x, rectangle.y, this.game);
		game.addEntity(shot);		
	}

	@Override
	protected void dropPowerUp() {
		int i = rnd.nextInt(100);
		PowerUp powerUp = null;
		if (i < 10) {
			powerUp = new PowerUpWeapon_1(rectangle.x, rectangle.y , game);
		} else if (i < 20 && !ThreadFreeze.isRunning()) {
			powerUp = new PowerUpFreeze(rectangle.x, rectangle.y , game);
		} else if (i < 30) {
			powerUp = new PowerUpPotion(rectangle.x, rectangle.y , game);
		} else if (i < 40) {
			powerUp = new PowerUpShield(rectangle.x, rectangle.y , game);
		}
		if (powerUp != null) {
			game.addEntity(powerUp); 
		}
	}

}
