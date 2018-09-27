package Entity;

import java.awt.Image;
import javax.swing.ImageIcon;
import Game.Game;
import Intelligence.KamikazeIntelligence;
import Visitor.Visitor;
import Visitor.VisitorEnemy;

public class EnemyChase extends Enemy {
	private int damage;
	
	public EnemyChase(int x, int y, int speed,  Game g) {
		super(x, y, speed, g);
		visitor = new VisitorEnemy(this);
		intel = KamikazeIntelligence.getInstance();
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
