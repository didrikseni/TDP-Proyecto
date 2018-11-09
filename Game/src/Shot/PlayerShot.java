package Shot;

import java.awt.Image;

import javax.swing.ImageIcon;

import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorShotPlayer;

public class PlayerShot extends Shot {
	
	public PlayerShot(int x, int y, Game g) {
		super(x, y, g);
		damage = 20;
		visitor = new VisitorShotPlayer(this);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shots/basic_shot_00.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitPlayerShot(this);
	}
	
	@Override
	public void update() {
		rectangle.y -= speed;
		super.update();
	}
	

}
