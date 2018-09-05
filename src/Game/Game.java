package Game;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import Entity.Enemy;
import Entity.Player;
import Main.GUI;
import Obstacles.Obstacles;
import PowerUp.PowerUp;
import Shot.Shot;

public abstract class Game{
	
	//Attributes
	protected Player player;
	protected Collection<Enemy> enemys;
	protected Collection<Obstacles> obstacles;
	protected Collection<Shot> shots;
	protected Collection<PowerUp> powerUps;
	protected JLayeredPane contentPane;
	
	

	//Constructor
	protected Game(GUI gui) {
		player = new Player(gui.getWidth() / 2 - 25, gui.getHeight() / 6 * 5);
		gui.add(player.getGraphics());
		gui.addLayerAux(player.getGraphics(), 5);
		
		enemys = new ArrayList<Enemy>();
		obstacles = new ArrayList<Obstacles>();
		shots = new ArrayList<Shot>();
		powerUps = new ArrayList<PowerUp>();
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
		
	}
	
}
