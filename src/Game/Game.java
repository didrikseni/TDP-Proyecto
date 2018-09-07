package Game;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JLayeredPane;

import Entity.Enemy;
import Entity.EnemyWeapon;
import Entity.Player;
import Main.GUI;
import Obstacles.Destroyable;
import Obstacles.Obstacles;
import PowerUp.PowerUp;
import Shot.Shot;

public abstract class Game{
	
	//Attributes
	protected Player player;
	protected Collection<Enemy> enemies;
	protected Collection<Obstacles> obstacles;
	protected Collection<Shot> shots;
	protected Collection<PowerUp> powerUps;
	protected JLayeredPane contentPane;
	
	

	//Constructor
	protected Game(GUI gui) {
		enemies = new ArrayList<Enemy>();
		obstacles = new ArrayList<Obstacles>();
		shots = new ArrayList<Shot>();
		powerUps = new ArrayList<PowerUp>();
		
		player = Player.getInstance(gui.getWidth() / 2 - 25, gui.getHeight() / 6 * 5);
		gui.add(player.getGraphics());
		gui.addLayerAux(player.getGraphics(), 5);
		
		
		//ENEMIGOS Y OBSTACULOS TEMPORALES
		java.util.Random rnd = new java.util.Random();
		for(int i = 0; i < 5; i++) {
			Obstacles o = new Destroyable(rnd.nextInt(600), rnd.nextInt(700));
			gui.add(o.getGraphics());
			gui.addLayerAux(o.getGraphics(), 5);
		}
		
		int x = 100;
		for(int i = 0; i < 3; i++) {
			Enemy e = new EnemyWeapon(x, 100, 5);
			enemies.add(e);
			gui.add(e.getGraphics());
			gui.addLayerAux(e.getGraphics(), 4);
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
		}
	}


	public void update() {
		player.update();
		
		//MOVIMIENTO TEMPORAL DE LOS ENEMIGOS.
		java.util.Random rnd = new java.util.Random();
		if (rnd.nextBoolean()) {
			for(Enemy e: enemies) {
				e.move(rnd.nextInt(3));
				e.update();
			} 
		} else {
			for(Enemy e: enemies) {
				e.stop(0);
				e.stop(1);
				e.stop(2);
				e.stop(3);
				e.update();
			} 
		}
		
	}
	
}
