package Obstacle;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import Main.Game;
import Visitor.VisitorObstacle;

public class Destroyable extends Obstacle {	
	private Random rnd;
	
	public Destroyable(int x, int y, Game g) {
		super(x, y, g);		
		visitor = new VisitorObstacle(this);
		rnd = new Random();
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_" + rnd.nextInt(6) + ".png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}

	@Override
	public void update() {}	
	
}
