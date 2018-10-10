package Shot;

import java.awt.Image;

import javax.swing.ImageIcon;

import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorShotEnemy;

public class EnemyShot extends Shot {

	public EnemyShot(int x, int y, Game g) {
		super(x, y, g);
		this.width = 20;
		this.height = 20;
		damage = 10;
		visitor = new VisitorShotEnemy(this);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shots/enemyShot.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitEnemyShot(this);
	}
	
	public void update() {
		rectangle.y += speed;
		this.updateGraphics();
		if(rectangle.y < -20) {
			game.deadEntity(this);
		}
	}

}
