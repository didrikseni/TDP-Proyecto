package Visitor;

import Animations.Animations;
import Entity.Enemy;
import Entity.Player;
import Main.GUI;
import Obstacles.Obstacle;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorPlayer extends Visitor{
	private Player player;
	
	public VisitorPlayer(Player e) {
		player = e;	
	}

	public void visitPlayer(Player p) {}

	public void visitEnemy(Enemy e) {
		e.takeDamage(player.getLife());
		player.takeDamage(player.getLife());
		GUI.getInstance().updateLifeBar(player.getLife());
	}

	public void visitPowerUp(PowerUp p) {
		p.addPowerUp(player);
	}
	
	public void visitPlayerShot(PlayerShot p) {}

	public void visitEnemyShot(EnemyShot e) {
		e.takeDamage(e.getLife());
		player.takeDamage(e.getDamage());
		GUI.getInstance().updateLifeBar(player.getLife());
		//Animations animations = Animations.getInstance();
		//animations.startSparkAnimation(player.getPos().x, player.getPos().y);
	}

	@Override
	public void visitObstacle(Obstacle d) {
		player.takeDamage(player.getLife());
		GUI.getInstance().updateLifeBar(player.getLife());
	}
}
