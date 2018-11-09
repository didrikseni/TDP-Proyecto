package Obstacle;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import Main.Game;
import Visitor.VisitorBarricade;

public class Barricade extends Obstacle {
	private Random rnd;

	public Barricade(int x, int y, Game g) {
		super(x, y, g);
		visitor = new VisitorBarricade(this);
		rnd = new Random();
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_" + (rnd.nextInt(6) + 7) + ".png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}

	@Override
	public void update() {}

}
