package Obstacles;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorBarricade;

public class Barricade extends Obstacle {
	private Random rnd;

	public Barricade(int x, int y, Game g) {
		super(x, y, g);
		visitor = new VisitorBarricade(this);
		rnd = new Random();
		int i = rnd.nextInt(6);
		ImageIcon img = null;
		switch(i) {
			case 0: 
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_7.png")); break;
			case 1: 
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_8.png")); break;
			case 2: 
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_9.png")); break;
			case 3:
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_10.png")); break;
			case 4:
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_11.png")); break;
			case 5:
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_12.png")); break;
			case 6: 
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_13.png")); break;
		}
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitObstacle(this);
	}

	@Override
	public void update() {}

}
