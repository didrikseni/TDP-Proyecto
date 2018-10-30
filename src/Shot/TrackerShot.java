package Shot;

import java.awt.Image;
import javax.swing.ImageIcon;
import Entity.Player;
import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorShotEnemy;

public class TrackerShot extends EnemyShot {
	private Player player;
	
	public TrackerShot(int x, int y, Game game, Player player) {
		super(x, y, game);
		this.player = player;
		damage = 5;
		visitor = new VisitorShotEnemy(this);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shots/enemy_shot_02.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(rectangle.width, rectangle.height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitEnemyShot(this);
	}
	
	@Override
	public void update() {
		int vectorX = player.getPos().x - this.rectangle.x;
		int vectorY = player.getPos().y - this.rectangle.y;
		
		double angle = Math.atan2(vectorY, vectorX);
		
		rectangle.x += (int) (5 * Math.cos(angle));
		rectangle.y += (int) (5 * Math.sin(angle));
		this.updateGraphics();
		if(rectangle.y < -20) {
			game.addDeadEntity(this);
		}
	}
	
}
