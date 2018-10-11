package Shot;

import java.awt.Image;

import javax.swing.ImageIcon;

import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorShotPlayer;

public class PowerUp2Shot extends PlayerShot {
	private boolean positivo;

	public PowerUp2Shot(int x, int y, Game g) {
		super(x, y, g);
		damage = 30;
		visitor = new VisitorShotPlayer(this);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shots/disparo.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)); 
	}

	@Override
	public void accept(Visitor v) {
		if (positivo) {
			rectangle.x += Math.cos(rectangle.y);
		} else {
			rectangle.x -= Math.cos(rectangle.y);
		}
		super.update();		
	}

}
