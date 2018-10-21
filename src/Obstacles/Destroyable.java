package Obstacles;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorObstacle;

public class Destroyable extends Obstacle {	
	private Random rnd;
	
	public Destroyable(int x, int y, Game g) {
		super(x, y, g);		
		visitor = new VisitorObstacle(this);
		rnd = new Random();
		int i = rnd.nextInt(6);
		ImageIcon img = null;
		switch(i) {
			case 0: 
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_0.png")); break;
			case 1: 
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_1.png")); break;
			case 2: 
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_2.png")); break;
			case 3:
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_3.png")); break;
			case 4:
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_4.png")); break;
			case 5:
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_5.png")); break;
			case 6: 
				img = new ImageIcon(this.getClass().getResource("/Resources/Asteroids/asteroid_6.png")); break;
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
