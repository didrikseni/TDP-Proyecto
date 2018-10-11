package Visitor;

import Animations.Animation;
import Animations.AnimationSpark;
import Entity.Enemy;
import Entity.Player;
import GUI.GUI_Game;
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
		//player.takeDamage(player.getLife());
		GUI_Game.getInstance().updateLifeBar(player.getLife());
	}

	public void visitPowerUp(PowerUp p) {
		p.addPowerUp(player);
	}
	
	public void visitPlayerShot(PlayerShot p) {}

	public void visitEnemyShot(EnemyShot e) {
		e.takeDamage(e.getLife());
		//player.takeDamage(e.getDamage());
		GUI_Game.getInstance().updateLifeBar(player.getLife());
		Animation anim = new AnimationSpark(player.getRectangle().x, player.getRectangle().y);
		anim.getStarted();
	}

	@Override
	public void visitObstacle(Obstacle d) {
		player.takeDamage(player.getLife());
		GUI_Game.getInstance().updateLifeBar(player.getLife());
	}
}
