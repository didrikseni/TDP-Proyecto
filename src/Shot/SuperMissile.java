package Shot;

import java.awt.Image;
import javax.swing.ImageIcon;
import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorSuperMissile;

public class SuperMissile extends PlayerShot {
	
	public SuperMissile(int x, int y, Game g) {
		super(x, y, g);
		damage = 55;
		visitor = new VisitorSuperMissile(this, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shots/basic_shot_03.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitPlayerShot(this);
	}	
}
