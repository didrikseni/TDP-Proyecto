package Entity;

import java.awt.Image;
import javax.swing.ImageIcon;

import Behaviour.KamikazeBehaviour;
import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorEnemy;

public class EnemyKamikaze extends Enemy {
	private int damage;
	
	public EnemyKamikaze(int x, int y, int speed,  Game g) {
		super(x, y, speed, g);
		visitor = new VisitorEnemy(this);
		comportamiento = new KamikazeBehaviour();
		score = 150;
		damage = 80;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/XWingAbajo.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitEnemy(this);
	}

	@Override
	public void shoot() {}

	public int getDamage() {
		return damage;
	}

}