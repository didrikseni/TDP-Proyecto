package Shot;

import java.awt.Image;

import javax.swing.ImageIcon;

import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorShotEnemy;

public class BossShot2 extends EnemyShot {
	private int dy;

	public BossShot2(int x, int y, int dy, Game g) {
		super(x, y, g);
		rectangle.height = rectangle.width = 25;
		this.speed = 3;
		this.damage = 30;
		this.dy = dy;
		visitor = new VisitorShotEnemy(this);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shots/bossShot2.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}

	@Override
	public void update() {
		super.update();
		this.rectangle.x += dy;
	}

	@Override
	public void accept(Visitor v) {
		v.visitEnemyShot(this);
	}

}
