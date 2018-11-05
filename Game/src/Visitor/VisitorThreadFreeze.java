package Visitor;

import java.util.HashMap;
import Behaviour.Behaviour;
import Behaviour.FreezeBehaviour;
import Entity.Enemy;
import Entity.Entity;
import Entity.Player;
import Obstacle.Obstacle;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorThreadFreeze extends Visitor {
	private static VisitorThreadFreeze INSTANCE;
	private static HashMap<Entity,Behaviour> behaviourMap;
	
	private VisitorThreadFreeze() {
		behaviourMap = new HashMap<Entity, Behaviour>();
	}
	
	public static VisitorThreadFreeze getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VisitorThreadFreeze();
		} 
		return INSTANCE;
	}
	
	public void visitPlayer(Player p) {}
	
	@Override
	public void visitEnemy(Enemy e) {
		if (behaviourMap.get(e) == null) {
			behaviourMap.put(e, e.getBehaviour());
			e.setComportamiento(FreezeBehaviour.getInstance());			
		} else {
			e.setComportamiento(behaviourMap.get(e));
			behaviourMap.remove(e);
		}
	}

	public void visitObstacle(Obstacle d) {}
	public void visitPowerUp(PowerUp p) {}	
	public void visitPlayerShot(PlayerShot p) {}
	public void visitEnemyShot(EnemyShot e) {}
}
