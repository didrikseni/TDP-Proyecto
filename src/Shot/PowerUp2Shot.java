package Shot;

import java.awt.Image;
import javax.swing.ImageIcon;
import GUI.GUI_Game;
import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorShotPlayer;

public class PowerUp2Shot extends PlayerShot {
	private boolean positivo;

	public PowerUp2Shot(int x, int y, boolean posit, Game g) {
		super(x, y, g);
		damage = 25;
		visitor = new VisitorShotPlayer(this);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shots/player_shot_00.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height + 10, Image.SCALE_DEFAULT));
		positivo = posit;
	}

	@Override
	public void accept(Visitor v) {
		
	}
	
	public void update() {
		int y = (int) (2 * rectangle.y * Math.PI / GUI_Game.getInstance().getHeight());
		if (positivo) {
			rectangle.x += 2 * Math.cos(y) + 1;
		} else {
			rectangle.x -= 2 * Math.cos(y);
		}		
		super.update();
	}

}
