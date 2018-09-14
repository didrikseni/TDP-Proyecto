package Game;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JLayeredPane;

import Entity.Enemy;
import Entity.EnemyWeapon;
import Entity.Entity;
import Entity.Player;
import Main.GUI;
import Obstacles.Destroyable;
import Obstacles.Obstacles;
import PowerUp.PowerUp;
import Shot.PlayerShot;
import Shot.Shot;

public abstract class Game{
	
	//Attributes
	protected GUI gui;
	protected Player player;
	protected Collection<Entity> entities;
	protected JLayeredPane contentPane;
	
	

	//Constructor
	protected Game(GUI gui) {
		entities = new ArrayList<Entity>();
		this.gui = gui;
		initializeMap(gui);		
	}


	private void initializeMap(GUI gui) {
		player = Player.getInstance(gui.getWidth() / 2 - 25, gui.getHeight() / 6 * 5, this);
		gui.add(player.getGraphics());
		gui.addLayerGUI(player.getGraphics(), 5);
		
		
		//ENEMIGOS Y OBSTACULOS TEMPORALES
		java.util.Random rnd = new java.util.Random();
		for(int i = 0; i < 10; i++) {
			Obstacles o = new Destroyable(rnd.nextInt(575), rnd.nextInt(675), this);
			gui.add(o.getGraphics());
			gui.addLayerGUI(o.getGraphics(), 3);
		}
		
		int x = 100;
		for(int i = 0; i < 3; i++) {
			Enemy e = new EnemyWeapon(x, 100, 5, this);
			entities.add(e);
			gui.add(e.getGraphics());
			gui.addLayerGUI(e.getGraphics(), 4);
			x += 150;
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
		/*
		//MOVIMIENTO TEMPORAL DE LOS ENEMIGOS.
		java.util.Random rnd = new java.util.Random();
		if (rnd.nextBoolean()) {
			for(Entity e: entities) {
				e.move(rnd.nextInt(4));
				e.update();
			} 
		} else {
			for(Entity e: entities) {
				e.stop(0);
				e.stop(1);
				e.stop(2);
				e.stop(3);
				e.update();
			} 
		}
		*/
		for(Entity e: entities) {
			e.update();
		}
		
	}


	public void shoot() {
		player.shoot(true);
	}


	public void addEntity(Entity s) {
		entities.add(s);
		gui.add(s.getGraphics());
		gui.addLayerGUI(s.getGraphics(), 3);
	}


	public void remove(Entity e) {
		gui.remove(e.getGraphics());
	}	
}
