package Obstacles;

import java.awt.Image;
import javax.swing.ImageIcon;
import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorObstacle;

public class Destroyable extends Obstacle {	
	
	public Destroyable(int x, int y, Game g) {
		super(x, y, g);		
		visitor = new VisitorObstacle(this);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/aestroid_brown.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitObstacle(this);
	}

	
	
}
