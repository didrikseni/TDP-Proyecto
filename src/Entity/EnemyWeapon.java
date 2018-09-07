package Entity;

import java.awt.Image;

import javax.swing.ImageIcon;


public class EnemyWeapon extends Enemy {	
	
	public EnemyWeapon(int x, int y, int speed) {
		super(x, y, speed);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/XWingAbajo.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

}
