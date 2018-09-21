package Shot;

import java.awt.Image;

import javax.swing.ImageIcon;

import Game.Game;
import Visitor.Visitor;
import Visitor.VisitorShotEnemy;

public class EnemyShot extends Shot {

	public EnemyShot(int x, int y, Game g) {
		super(x, y, g);
		
		damage = 25;
		
		v = new VisitorShotEnemy(this);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/disparo.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitEnemyShot(this);
	}

}
