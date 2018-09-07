package Obstacles;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Destroyable extends Obstacles {	
	
	public Destroyable(int x, int y) {
		super(x, y);
		width = 30;
		height = 30;
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/aestroid_brown.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	
	
}
