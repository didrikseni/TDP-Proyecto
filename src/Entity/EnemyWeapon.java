package Entity;

import java.awt.Image;

import javax.swing.ImageIcon;

import Game.Game;
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
		Shot shot = new EnemyShot(this.pos.x, this.pos.y, this.game);
		game.addEntity(shot);		
	}

}
