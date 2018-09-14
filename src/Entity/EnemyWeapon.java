package Entity;

import java.awt.Image;

import javax.swing.ImageIcon;

import Game.Game;


public class EnemyWeapon extends Enemy {	
	
	public EnemyWeapon(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/XWingAbajo.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

}
