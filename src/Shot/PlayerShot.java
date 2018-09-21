package Shot;

import java.awt.Image;

import javax.swing.ImageIcon;

import Game.Game;
import Visitor.Visitor;
import Visitor.VisitorShotPlayer;

public class PlayerShot extends Shot {
	
	public PlayerShot(int x, int y, Game g) {
		super(x, y, g);
		
		damage = 100;
		
		v = new VisitorShotPlayer(this);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/disparo.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
	
	public void update() {
		pos.y -= speed;
		this.updateGraphics();
		if(pos.y < -20) {
			g.imDead(this);
		}
	}

	@Override
	public void accept(Visitor v) {
		v.visitPlayerShot(this);
		
	}
	
	

}
