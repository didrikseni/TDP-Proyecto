package Shot;

import java.awt.Image;
import javax.swing.ImageIcon;
import Entity.Player;
import GUI.RotatedIcon;
import Main.Game;

public class TrackerShot extends EnemyShot {
	private Player player;
	private RotatedIcon rotatedIcon;
	
	public TrackerShot(int x, int y, Game game, Player player) {
		super(x, y, game);
		this.player = player;
		damage = 15;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shots/basic_shot_02.png"));
		rotatedIcon = new RotatedIcon(new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT)), 90.0);
		this.icon = rotatedIcon;
	}

	@Override
	public void update() {
		int vectorX = player.getPos().x - this.rectangle.x;
		int vectorY = player.getPos().y - this.rectangle.y;
		
		double angle = Math.atan2(vectorY, vectorX);
		
		rectangle.x += (int) (5 * Math.cos(angle));
		rectangle.y += (int) (5 * Math.sin(angle));
		
		rotatedIcon.setDegrees(angle * (180 / Math.PI) + 90);
		this.graphic.setIcon(rotatedIcon);
		graphic.repaint();
		
		this.updateGraphics();
		
		if(rectangle.y < -20) {
			this.soundClip.getClip().stop();
			game.addDeadEntity(this);
		}
	}
	
}