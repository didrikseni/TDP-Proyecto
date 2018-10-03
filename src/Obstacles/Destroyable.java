package Obstacles;

import java.awt.Image;

import javax.swing.ImageIcon;

import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorObstacleDestroyable;

public class Destroyable extends Obstacles {	
	
	public Destroyable(int x, int y, Game g) {
		super(x, y, g);
		//width = 30;
		//height = 30;
		
		visitor = new VisitorObstacleDestroyable(this);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/aestroid_brown.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitObstacleDestroyable(this);
	}

	
	
}
