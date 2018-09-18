package Game;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;

import Entity.Enemy;
import Entity.EnemyWeapon;
import Entity.Entity;
import Entity.Player;
import Main.GUI;
import Obstacles.Destroyable;
import Obstacles.Obstacles;

public abstract class Game{
	
	//Attributes
	protected GUI gui;
	protected Player player;
	protected List<Entity> entities;
	protected JLayeredPane contentPane;
	
	

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
				player.move(3);;
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
		Entity e1, e2;
		
		for(Entity e: entities) {
			e.update();
			if(hasCollide(player,e)) {
				player.collide(e);
				e.collide(player);
			}
		}
		
		//Colisiones entre entidades.
		for(int i = 0; i < entities.size(); i++) {
			e1 = entities.get(i);
			for(int j = i + 1; j < entities.size(); j++) {
				e2 = entities.get(j);
				if(hasCollide(e1,e2)) {
					e1.collide(e2);
					e2.collide(e1);
				}
				
				if(e2.getLife() <= 0) {
					gui.remove(e2.getGraphics());
					entities.remove(j);
				}
			}
			if(e1.getLife() <= 0) {
				gui.remove(e1.getGraphics());
				entities.remove(i);
			}
		}	
	}

	/**
	 * Funcion que retorna verdadero si dos entidades colisionaron.
	 * @param Entidad 1.
	 * @param Entidad 2.
	 * @return Verdadero si colisionaron, falso caso contrario.
	 */
	private boolean hasCollide(Entity e1, Entity e2) {
		double dx = e1.getPos().x - e2.getPos().x;
		double dy = e1.getPos().y - e2.getPos().y;
		double dist = Math.sqrt(dx*dx + dy*dy);
		
		if (dist < (e1.getWidth() / 2 + e2.getWidth() / 2) || dist < (e1.getHeight() / 2 + e2.getHeight() / 2)) {
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

	
	/**
	 * Remueve una entidad del mapa.
	 * @param Entidad a remover.
	 */
	public void remove(Entity e) {
		gui.remove(e.getGraphics());
	}

	//CONSULTAR
	public GUI getGUI() {
		return gui;
	}	
}
