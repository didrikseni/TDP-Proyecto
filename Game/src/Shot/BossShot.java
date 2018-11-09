package Shot;

import java.awt.Image;
import javax.swing.ImageIcon;
import GUI.GUI_Game;
import Main.Game;

public class BossShot extends EnemyShot {
	private boolean positivo;

	public BossShot(int x, int y, boolean b, Game g) {
		super(x, y, g);
		rectangle.height = rectangle.width = 20;
		this.speed = 3;
		this.damage = 40;
		positivo = b;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shots/bossShot.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}

	@Override
	public void update() {
		int y = (int) (2 * rectangle.y * Math.PI / GUI_Game.getInstance().getHeight());
		if (positivo) {
			rectangle.x += 2.2 * Math.cos(y) + 1;
		} else {
			rectangle.x -= 2.2 * Math.cos(y);
		}
		super.update();
	}

}
