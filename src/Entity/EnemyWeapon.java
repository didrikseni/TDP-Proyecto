package Entity;

import java.awt.Image;

import javax.swing.ImageIcon;

import Game.Game;
import Visitor.Visitor;
import Visitor.VisitorEnemyWeapon;


public class EnemyWeapon extends Enemy {	
	
	public EnemyWeapon(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		
		v = new VisitorEnemyWeapon(this);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/XWingAbajo.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitEnemy(this);
	}

}
