package Visitor;

import Animation.Animation;
import Animation.AnimationSuperMissile;
import Entity.Enemy;
import Entity.Entity;
import Entity.Player;
import Main.Game;
import Obstacle.Obstacle;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;
import Shot.SuperMissile;

public class VisitorSuperMissile extends Visitor {
	private SuperMissile superMissile;
	private Game game;

	public VisitorSuperMissile(SuperMissile missile, Game game) {
		superMissile = missile;
		this.game = game;
	}

	@Override
	public void visitPlayer(Player p) {

	}

	@Override
	public void visitEnemy(Enemy e) {
		superMissile.getRectangle().setBounds(superMissile.getRectangle().x - 80, superMissile.getRectangle().y - 80, 200, 200);
		for(Entity ent: game.getEntities()) {
			if (superMissile.getRectangle().intersects(ent.getRectangle())) {
				ent.takeDamage(superMissile.getDamage());
			}
		}
		Animation anm = new AnimationSuperMissile(superMissile.getRectangle().x, superMissile.getRectangle().y, 200, 200);
		anm.getStarted();
		game.addDeadEntity(superMissile);
	}

	@Override
	public void visitObstacle(Obstacle d) {

	}

	@Override
	public void visitPowerUp(PowerUp p) {

	}

	@Override
	public void visitPlayerShot(PlayerShot p) {

	}

	@Override
	public void visitEnemyShot(EnemyShot e) {

	}

}
