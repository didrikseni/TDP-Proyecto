package Game;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLayeredPane;

import Entity.Enemy;
import Entity.EnemyWeapon;
import Entity.Entity;
import Entity.Player;
import Main.GUI;
import Obstacles.Destroyable;
import Obstacles.Obstacles;

public abstract class Game {
	
	//Attributes
	protected GUI gui;
	protected Player player;
	protected List<Entity> entities;
	protected JLayeredPane contentPane;
	protected HashMap<Entity, Boolean> deadEntities;

	//Constructor
	protected Game(GUI gui) {
		entities = new ArrayList<Entity>();
		this.gui = gui;
		initializeMap();		
	}

	/*
	 * Inicializa el nivel
	 */
	private void initializeMap() {
		player = Player.getInstance(gui.getWidth() / 2 - 25, gui.getHeight() / 6 * 5, this);
		gui.add(player.getGraphics());
		gui.addLayerGUI(player.getGraphics(), 5);
		//entities.add(player);
		
		
		//ENEMIGOS Y OBSTACULOS TEMPORALES
		java.util.Random rnd = new java.util.Random();
		for(int i = 0; i < 5; i++) {
			Obstacles o = new Destroyable(rnd.nextInt(575), rnd.nextInt(550), this);
			gui.add(o.getGraphics());
			gui.addLayerGUI(o.getGraphics(), 3);
			entities.add(o);
		}
		
		int x = 55;
		for(int i = 0; i < 5; i++) {
			Enemy e = new EnemyWeapon(x, 100, 4, this);
			entities.add(e);
			gui.add(e.getGraphics());
			gui.addLayerGUI(e.getGraphics(), 4);
			x += 100;
		}
		
		x=5;
		for(int i = 0; i < 5; i++) {
			Enemy e = new EnemyWeapon(x, 50, 4, this);
			entities.add(e);
			gui.add(e.getGraphics());
			gui.addLayerGUI(e.getGraphics(), 4);
			x += 100;
		}
		
		x = 5;
		for(int i = 0; i < 5; i++) {
			Enemy e = new EnemyWeapon(x, 150, 4, this);
			entities.add(e);
			gui.add(e.getGraphics());
			gui.addLayerGUI(e.getGraphics(), 4);
			x += 100;
		}
	}


	public void move(int keyCode) {
		switch (keyCode){
			case KeyEvent.VK_UP :
				player.move(0);
				break;
			case KeyEvent.VK_DOWN :
				player.move(1);
				break;
			case KeyEvent.VK_LEFT :
				player.move(2);
				break;
			case KeyEvent.VK_RIGHT :
				player.move(3);
				break;
		}
	}


	public void stop(int keyCode) {
		switch (keyCode){
			case KeyEvent.VK_UP :
				player.stop(0);
				break;
			case KeyEvent.VK_DOWN :
				player.stop(1);
				break;
			case KeyEvent.VK_LEFT :
				player.stop(2);
				break;
			case KeyEvent.VK_RIGHT :
				player.stop(3);;
				break;
			case KeyEvent.VK_SPACE :
				player.stop(10);
				break;
		}
	}


	public void update() {
		player.update();
		deadEntities = new HashMap<Entity, Boolean>();
		detectCollisions();
		removeDeadEntities();
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
			remove(entity);
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

	/**
	 * Disparo del player.
	 */
	public void shoot(boolean b) {
		player.shoot(b);
	}

	/**
	 * Agrega una entidad al juego y al mapa.
	 * @param Entidad a agregar.
	 */
	public void addEntity(Entity s) {
		entities.add(s);
		gui.add(s.getGraphics());
		gui.addLayerGUI(s.getGraphics(), 3);
	}

	public void imDead(Entity e) {
		deadEntities.put(e, true);
	}
	
	public void imDead(Enemy e, int score) {
		player.addScore(score);
		deadEntities.put(e, true);
	}

	/**
	 * Remueve una entidad del mapa.
	 * @param Entidad a remover.
	 */
	private void remove(Entity e) {
		gui.remove(e.getGraphics());
		entities.remove(e);
	}
}
