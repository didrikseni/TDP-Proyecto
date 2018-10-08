package Main;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLayeredPane;
import Entity.Enemy;
import Entity.EnemyKamikaze;
import Entity.EnemyWeapon;
import Entity.Entity;
import Entity.Player;
import Obstacles.Destroyable;
import Obstacles.Obstacle;

public abstract class Game {
	protected GUI gui;
	protected Player player;
	protected List<Entity> entities;
	protected JLayeredPane contentPane;
	protected HashMap<Entity, Boolean> deadEntities;

	protected Game(GUI gui) {
		entities = new ArrayList<Entity>();
		this.gui = gui;
		initializeMap();		
	}

	private void initializeMap() {
		player = Player.getInstance(gui.getWidth() / 2 - 25, gui.getHeight() / 6 * 5, this);
		gui.add(player.getGraphics());
		gui.addComponentInLayer(player.getGraphics(), 5);
				
		//ENEMIGOS Y OBSTACULOS TEMPORALES
		//Factory factory = new ConcreteFactory(this);
		java.util.Random rnd = new java.util.Random();		
		for(int i = 0; i < 5; i++) {
			Obstacle o = new Destroyable(rnd.nextInt(575), rnd.nextInt(550), this);
			gui.add(o.getGraphics());
			gui.addComponentInLayer(o.getGraphics(), 3);
			entities.add(o);
		}
		int x = 55;
		for(int i = 0; i < 5; i++) {
			Enemy e = new EnemyWeapon(x, 150, 1, this);
			entities.add(e);
			gui.add(e.getGraphics());
			gui.addComponentInLayer(e.getGraphics(), 4);
			x += 100;
		}		
		x=5;
		for(int i = 0; i < 5; i++) {
			Enemy e = new EnemyWeapon(x, 100, 1, this);
			entities.add(e);
			gui.add(e.getGraphics());
			gui.addComponentInLayer(e.getGraphics(), 4);
			x += 100;
		}
		Enemy e = new EnemyKamikaze(gui.getAncho() / 2, 150, 2, this);
		entities.add(e);
		gui.add(e.getGraphics());
		gui.addComponentInLayer(e.getGraphics(), 4);
	}
	
	public abstract Game getInstance();
	
	public void playerStartMove(int keyCode) {
		switch (keyCode){
			case KeyEvent.VK_UP:
				player.startMove(0); break;
			case KeyEvent.VK_DOWN:
				player.startMove(1); break;
			case KeyEvent.VK_LEFT:
				player.startMove(2); break;
			case KeyEvent.VK_RIGHT:
				player.startMove(3); break;
		}
	}

	public void playerStopMove(int keyCode) {
		switch (keyCode){
			case KeyEvent.VK_UP:
				player.stopMove(0);  break;
			case KeyEvent.VK_DOWN:
				player.stopMove(1);	 break;
			case KeyEvent.VK_LEFT:
				player.stopMove(2);	 break;
			case KeyEvent.VK_RIGHT:
				player.stopMove(3);  break;
		}
	}

	public void update() {
		player.update();
		deadEntities = new HashMap<Entity, Boolean>();
		detectCollisions();
		removeDeadEntities();
	}
	
	public void playerShoot(boolean b) {
		player.shoot(b);
	}

	public void addEntity(Entity s) {
		entities.add(s);
		gui.add(s.getGraphics());
		gui.addComponentInLayer(s.getGraphics(), 3);
	}

	public void deadEntity(Entity e) {
		deadEntities.put(e, true);
	}
	
	public void deadEntity(Enemy e, int score) {
		player.addScore(score);
		deadEntities.put(e, true);
	}

	private void detectCollisions() {
		Entity entity1, entity2;
		for(int i = 0; i < entities.size(); i++) {
			entity1 = entities.get(i);
			entity1.update();
			if(hasCollide(player, entity1)) {
				player.collide(entity1);
				entity1.collide(player);
			}
			for(int j = i + 1; j < entities.size(); j++) {
				entity2 = entities.get(j);
				if(hasCollide(entity1,entity2)) {
					entity1.collide(entity2);
					entity2.collide(entity1);
				}
			}
		}
	}

	private void removeDeadEntities() {
		for(Entity entity: deadEntities.keySet()) {
			removeEntityFromMap(entity);
		}
		gui.repaint();
	}

	private boolean hasCollide(Entity entity1, Entity entity2) {
		double dx = entity1.getPos().x - entity2.getPos().x;
		double dy = entity1.getPos().y - entity2.getPos().y;
		double dist = Math.sqrt(dx*dx + dy*dy);
		if (dist < (entity1.getWidth() / 2 + entity2.getWidth() / 2) ||
			dist < (entity1.getHeight() / 2 + entity2.getHeight() / 2)) {
			return true;
		} else {
			return false;
		}
	}

	private void removeEntityFromMap(Entity e) {
		gui.remove(e.getGraphics());
		entities.remove(e);
	}
}
