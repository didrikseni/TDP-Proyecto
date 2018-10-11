package Main;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLayeredPane;
import Entity.Enemy;
import Entity.Entity;
import Entity.Player;
import GUI.GUI_Game;

public abstract class Game {
	protected GUI_Game gui;
	protected int nivel;
	protected Player player;
	protected List<Entity> entities;
	protected JLayeredPane contentPane;
	protected HashMap<Entity, Boolean> deadEntities;

	protected Game(GUI_Game gui) {
		entities = new ArrayList<Entity>();
		this.gui = gui;
		initializeMap();		
	}

	private void initializeMap() {
		player = Player.getInstance(gui.getWidth() / 2 - 25, gui.getHeight() / 6 * 5, this);
		gui.add(player.getGraphics());
		gui.addComponentInLayer(player.getGraphics(), 5);
				
		FileOpener fileOpener = new FileOpener(this);
		fileOpener.readFile();
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
		return entity1.getRectangle().intersects(entity2.getRectangle());
	}

	private void removeEntityFromMap(Entity e) {
		gui.remove(e.getGraphics());
		entities.remove(e);
	}
}
